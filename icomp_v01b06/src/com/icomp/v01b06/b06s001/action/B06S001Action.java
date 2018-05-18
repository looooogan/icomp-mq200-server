package com.icomp.v01b06.b06s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vscrap;
import com.icomp.v01b06.b06s001.business.B06S001Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 *  报废分析Action
 * @ClassName: B06S001Action 
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S001Action extends IcompAction {
	private String total;

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
	 * 报废分析BUSINESS
	 */
	private B06S001Business b06s001Business;
	public void setB06s001Business(B06S001Business b06s001Business) {
		this.b06s001Business = b06s001Business;
	}

	/**
	 * 初始化报废分析页面
	 * @title initb01S001 
	 * @return
	 * String
	 */
	public String initb06S001(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 报废分析列表
				Map<String, Object> list = this.b06s001Business.getList(param,langCode, langValue,1);
				super.ajaxReturn(list);
				return null;
			}else {
				total =this.b06s001Business.getNumber();

//				super.assign("Business","");
				List<Business> businessList = this.b06s001Business.getBusinessList();
				super.assign("BusinessList",businessList);
				// 取得页面grid显示项目列表
				super.session("gridcol", b06s001Business.getGridColmun(
						"B06S001", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				//厂区
				//super.assign("WorkloadSummaryList", b06s001Business.getComList(IConstant.WORK_SUMMARY, langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B06S001.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S001", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 报废分析统计
	 * @title B06S001Action 
	 * @return
	 * String
	 */
	public String statistics_b06S001() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 参数
			Map<String, Object> param = super.param();

				// 报废分析统计数量
			super.ajaxReturn(b06s001Business.getStatisticalCount(param, langCode, langValue));
				return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/statistics_b06S001.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S001", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}

	}

	//	excel下载

	public String exportExcel() {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ToolConsumetype", toolConsumetype);
		param.put("DateStar", dateStar);
		param.put("DateEnd", dateEnd);
		param.put("ToolCode", systeCode);
		param.put("Authorized",authorized);
		param.put("Operation",operation);
		param.put("ScrapReason", scrapReason);
		param.put("StorageCheck",storageCheck);
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
			HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
			HSSFCellStyle style = wb.createCellStyle();//居中
			sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 9));//合并单元格

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
			cells =rows.createCell(2);
			cells.setCellValue("材料号");
			cells=rows.createCell(3);
			if ("".equals(systeCode)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(systeCode);
			}
			cells =rows.createCell(4);
			cells.setCellValue("原因");
			cells=rows.createCell(5);
			if ("".equals(scrapReason)){
				cells.setCellValue("-");
			} else if ("0".equals(scrapReason)){
				cells.setCellValue("断刀");
			}else if ("1".equals(scrapReason)){
				cells.setCellValue("丢刀");
			}else if ("2".equals(scrapReason)){
				cells.setCellValue("到寿");
			} else if ("3".equals(scrapReason)){
				cells.setCellValue("出库报废");
			}else {
				cells.setCellValue("其他");
			}
			cells =rows.createCell(6);
			cells.setCellValue("查询时间");
			cells=rows.createCell(7);
			if ("".equals(dateStar)&&"".equals(dateEnd)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(dateStar+"--"+dateEnd);
			}
			cells =rows.createCell(8);
			cells.setCellValue("授权人");
			cells=rows.createCell(9);
			if ("".equals(authorized)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(authorized);
			}
			cells =rows.createCell(10);
			cells.setCellValue("操作流程");
			cells=rows.createCell(11);
			if ("".equals(operation)){
				cells.setCellValue("-");
			}else {
				List<Business> businessList = this.b06s001Business.getBusinessList();
				for (Business bus : businessList) {
					if (operation.equals(bus.getBusinessID())){
						cells.setCellValue(bus.getBusinessCode());
						break;
					}else {
						cells.setCellValue("-");

					}
				}

			}
			cells =rows.createCell(12);
			cells.setCellValue("库房点验者");
			cells=rows.createCell(13);
			if ("".equals(storageCheck)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(storageCheck);
			}
			cells =rows.createCell(14);
			cells.setCellValue("时间段");
			cells=rows.createCell(15);
			if ("".equals(dateStar)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(dateStar+""+dateEnd);
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
			cell.setCellValue("入库时间");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("操作流程");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("库房点验者");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("报废原因");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("授权人");
			cell.setCellStyle(style);

			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b06s001Business.getList(param, "", "", 2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vscrap> vsList = (List<Vscrap>) list.get("rows");
			if (vsList == null) {
				vsList = new ArrayList<Vscrap>();
			}
			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vsList.size(); i++) {
				Vscrap vscrap = vsList.get(i);
				row = sheet.createRow(i + 4);
//row.createCell(0).setCellValue("");
				cell = row.createCell(0);//刀具类型
				String type =vscrap.getToolType();
					cell.setCellValue(type);

				cell = row.createCell(1);//材料号
				if ("".equals(vscrap.getToolCode())||vscrap.getToolCode()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vscrap.getToolCode());
				}
				cell = row.createCell(2);//时间
				if ("".equals(vscrap.getCreateTimes())||vscrap.getCreateTimes()==null){
					cell.setCellValue(new Date());
				}else {
					cell.setCellValue(Ctl.dateFormat(vscrap.getCreateTimes(),"yyyy-MM-dd"));

				}
				cell = row.createCell(3);//操作流程
				if ("".equals(vscrap.getBusinessName())||vscrap.getBusinessName()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vscrap.getBusinessName());
				}
				cell = row.createCell(4);//库房点验者 TODO sql没有写入先与授权人相同
				if ("".equals(vscrap.getAuthorizationUser())||vscrap.getAuthorizationUser()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vscrap.getAuthorizationUser());
				}
				cell = row.createCell(5);//报废原因
				if("".equals(vscrap.getScrapCause())||vscrap.getScrapCause()==null){
					cell.setCellValue("null");
				}else {
//					0.断刀1.丢刀2.到寿3.出库报废4.其他
					if ("0".equals(vscrap.getScrapCause())){
						cell.setCellValue("断刀");
					}else if ("1".equals(vscrap.getScrapCause())){
						cell.setCellValue("丢刀");
					}else if ("2".equals(vscrap.getScrapCause())){
						cell.setCellValue("到寿");
					} else if ("3".equals(vscrap.getScrapCause())){
						cell.setCellValue("出库报废");
					}else {
						cell.setCellValue("其他");
					}

				}
				cell = row.createCell(6);//授权人
				if ("".equals(vscrap.getAuthorizationUser())||vscrap.getAuthorizationUser()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vscrap.getAuthorizationUser());
				}

			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "报废原因分析表.xls";// title是前台传入的
			excelFileName = new String(excelFileName.getBytes("gb2312"),
					"iso8859-1");
			is.close();
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B03S001.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B03S001", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		} catch (IOException e) {
			System.out.println("写入流异常");
		}
		return "exportExcels";

	}
	private String toolConsumetype;
	private String dateStar;
	private String dateEnd;
	private String systeCode;
	private String authorized;
	private String operation;

	private String scrapReason;
	private String storageCheck;
	private InputStream excelStream;
	private String excelFileName;

	public InputStream getExcelStream() {

		return excelStream;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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

	public String getAuthorized() {
		return authorized;
	}

	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}

	public String getScrapReason() {
		return scrapReason;
	}

	public void setScrapReason(String scrapReason) {
		this.scrapReason = scrapReason;
	}

	public String getStorageCheck() {
		return storageCheck;
	}

	public void setStorageCheck(String storageCheck) {
		this.storageCheck = storageCheck;
	}
}
