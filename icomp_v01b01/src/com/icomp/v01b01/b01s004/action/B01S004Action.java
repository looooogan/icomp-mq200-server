package com.icomp.v01b01.b01s004.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vredemptionapplied;
import com.icomp.v01b01.b01s004.business.B01S004Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 换领申请信息查询Action
 * 
 * @ClassName: B01S004Action
 * @author Taoyy
 * @date 2014-8-12 下午04:16:08
 */
public class B01S004Action extends IcompAction {
	private  String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 换领申请信息查询BUSINESS
	 */
	private B01S004Business b01s004Business;

	public void setB01s004Business(B01S004Business b01s004Business) {
		this.b01s004Business = b01s004Business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb01S004
	 * @return String
	 */
	public String initb01S004() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//换领申请信息列表
				Map<String, Object> list = this.b01s004Business.getList(param,langCode,langValue,1);
				super.ajaxReturn(list);
				return null;
			}
			total = this.b01s004Business.getNumber();

			// 取得页面grid显示项目列表
			super.session("gridcol", b01s004Business.getGridColmun(
					"B01S004", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S004.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}


	public String redemptionappliedInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b01s004Business.printItemInfo(param, langCode,langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/redemptionappliedInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "redemptionappliedInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	//	excel下载

	public String exportExcel() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ToolConsumetype", toolConsumetype);
		param.put("DateStar", dateStar);
		param.put("DateEnd", dateEnd);
		param.put("systeCode", systeCode);
		param.put("status", status);
		param.put("applyPerson", applyPerson);
		param.put("libraryMember", libraryMember);
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
			HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
			sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 9));//合并单元格
			HSSFCellStyle style = wb.createCellStyle();//居中
			HSSFRow rowss = sheet.createRow(0);//创建第一行
			HSSFCell cellss = rowss.createCell(0);
			cellss.setCellValue("检索：");
			cellss.setCellStyle(style);

			HSSFRow rows = sheet.createRow(1);//创建第二行
			HSSFCell cells = rows.createCell(0);//创建这行的第一个元素.从0开始
			cells.setCellValue("刀具类型");
			cells=rows.createCell(1);
			if ("".equals(toolConsumetype)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(toolConsumetype);
			}
			cells=rows.createCell(2);
			cells.setCellValue("材料号");
			cells=rows.createCell(3);
			if ("".equals(systeCode)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(systeCode);
			}
			cells =rows.createCell(4);
			cells.setCellValue("查询时间");
			cells=rows.createCell(5);
			if ("".equals(dateStar)&&"".equals(dateEnd)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(dateStar+"--"+dateEnd);
			}
			cells =rows.createCell(6);
			cells.setCellValue("状态");
			cells=rows.createCell(7);
			if ("".equals(status)){
				cells.setCellValue("-");
			}else if(IConstant.BAND_TYPE_0.equals(status)) {
				cells.setCellValue("申领中");
			}else {
				cells.setCellValue("换领结束");
			}
			cells =rows.createCell(8);
			cells.setCellValue("申领人");
			cells=rows.createCell(9);
			if ("".equals(applyPerson)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(applyPerson);
			}
			cells =rows.createCell(10);
			cells.setCellValue("库管员");
			cells=rows.createCell(11);
			if ("".equals(libraryMember)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(libraryMember);
			}

			HSSFRow rowsd = sheet.createRow(2);//创建第三行
			HSSFCell cellsd = rowsd.createCell(0);//创建这行的第一个元素.从0开始
			sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
			cellsd.setCellValue("详细");
			cellsd.setCellStyle(style);






			HSSFRow row = sheet.createRow(3);//创建一行
			HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始
			cell.setCellValue("刀具类型");//写入内容
			cell.setCellStyle(style);

			cell = row.createCell(1);//同上
			cell.setCellValue("材料号");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("时间");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("数量");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("申请人");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("库管员");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("完成情况");
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue("换领数量");
			cell.setCellStyle(style);

			cell = row.createCell(8);
			cell.setCellValue("送回数量");
			cell.setCellStyle(style);

			cell = row.createCell(9);
			cell.setCellValue("丢失数量");
			cell.setCellStyle(style);
			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b01s004Business.getList(param, "", "", 2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vredemptionapplied> vrList = (List<Vredemptionapplied>) list.get("rows");
			if (vrList == null) {
				vrList = new ArrayList<Vredemptionapplied>();

			}
			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vrList.size(); i++) {
				Vredemptionapplied vredemptionapplied = vrList.get(i);
				row = sheet.createRow(i + 4);
//row.createCell(0).setCellValue("");
				cell = row.createCell(0);//刀具类型
				String type =vredemptionapplied.getToolType();
				cell.setCellValue(type);


				cell = row.createCell(1);
				if ("".equals(vredemptionapplied.getToolCode())||vredemptionapplied.getToolCode()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vredemptionapplied.getToolCode());//材料号
				}
				cell = row.createCell(2);
				if ("".equals(vredemptionapplied.getApplyTime())||vredemptionapplied.getApplyTime()==null){
					cell.setCellValue(new Date());
				}else {
//					String date = Ctl.dateFormat(vredemptionapplied.getApplyTime(), "yyyy-MM-dd");
					cell.setCellValue(vredemptionapplied.getApplyTime());//时间
				}
// 				String date = Ctl.dateFormat(vknifeinventory.getCreateTime(), "yyyy-MM-dd");
//				cell.setCellValue(date);

				cell = row.createCell(3);
				if ("".equals(vredemptionapplied.getReceiveNumber())||vredemptionapplied.getReceiveNumber()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vredemptionapplied.getReceiveNumber().toString());//数量
				}
				cell = row.createCell(4);
				if ("".equals(vredemptionapplied.getReceiveUser())||vredemptionapplied.getReceiveUser()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vredemptionapplied.getApplyUser());//申请人
				}
				cell = row.createCell(5);
				if ("".equals(vredemptionapplied.getLibraryUser())||vredemptionapplied.getLibraryUser()==null){
					cell.setCellValue("-");
				}else {

					cell.setCellValue(vredemptionapplied.getReceiveUser());//库管员
				}
				cell = row.createCell(6);
//				完成情况(0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
				if ("".equals(vredemptionapplied.getProcessingStatus())||vredemptionapplied.getProcessingStatus()==null){
				cell.setCellValue("-");
				}else  if(IConstant.STRING_0.equals(vredemptionapplied.getProcessingStatus())){
					cell.setCellValue("申请中");
				}else  if(IConstant.STRING_1.equals(vredemptionapplied.getProcessingStatus())){
					cell.setCellValue("已备货");
				}else  if(IConstant.STRING_2.equals(vredemptionapplied.getProcessingStatus())){
					cell.setCellValue("换领已送回");
				}else  if(IConstant.STRING_3.equals(vredemptionapplied.getProcessingStatus())){
					cell.setCellValue("换领未送回");
				}else  if(IConstant.STRING_5.equals(vredemptionapplied.getProcessingStatus())){
					cell.setCellValue("换领完毕");
				}else {
					cell.setCellValue("换领完毕");
				}
				cell = row.createCell(7);
				if ("".equals(vredemptionapplied.getAppliedNumber())||vredemptionapplied.getAppliedNumber()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(String.valueOf(vredemptionapplied.getAppliedNumber()));//换领数量
				}

				cell = row.createCell(8);
				if ("".equals(vredemptionapplied.getReceiveNumber())||vredemptionapplied.getReceiveNumber()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(String.valueOf(vredemptionapplied.getReceiveNumber()));//送回数量
				}
				cell = row.createCell(9);
				if ("".equals(vredemptionapplied.getLostNumber())||vredemptionapplied.getLostNumber()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(String.valueOf(vredemptionapplied.getLostNumber()));//丢失数量
				}

			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "换领申请查询信息表.xls";
			excelFileName = new String(excelFileName.getBytes("gb2312"),
					"iso8859-1");
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S001.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S001", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		} catch (IOException e) {
			System.out.println("写入流异常");
		}
		return "exportExcels";
	}
	private String toolConsumetype;
	private String dateStar ;
	private String dateEnd;
	private String systeCode;
	private String libraryMember;
	private String status;
	private String applyPerson;
	private InputStream excelStream ;
	private String excelFileName;
	public String getToolConsumetype() {
		return toolConsumetype;
	}

	public void setToolConsumetype(String toolConsumetype) {
		this.toolConsumetype = toolConsumetype;
	}

	public String getDateStar() {
		return dateStar;
	}

	public void setDateStar(String dateStar) {
		this.dateStar = dateStar;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getSysteCode() {
		return systeCode;
	}

	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
	}

	public String getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(String libraryMember) {
		this.libraryMember = libraryMember;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplyPerson() {
		return applyPerson;
	}

	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}


}
