package com.icomp.v01b06.b06s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b06.b06s002.business.B06S002Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System;
import java.util.*;

/**
 *  加工异常分析Action
 * @ClassName: B06S002Action
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S002Action extends IcompAction {
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
	 * 加工异常分析BUSINESS
	 */
	private B06S002Business b06s002Business;
	public void setB06s002Business(B06S002Business b06s002Business) {
		this.b06s002Business = b06s002Business;
	}

	/**
	 * 初始化加工异常分析页面
	 * @title initb01S002
	 * @return
	 * String
	 */
	public String initb06S002(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 加工异常分析列表
				Map<String, Object> list = this.b06s002Business.getList(param,langCode, langValue,1);
				super.ajaxReturn(list);
				return NONE;
			}else{
				total=this.b06s002Business.getNumber();
				super.assign("ProcessID"," ");
				super.assign("PatrsID"," ");
				Map<String,Object> ppList = this.b06s002Business.getPPList();
				super.assign("ProcessList",ppList.get("ProcessList"));
				super.assign("PatrsList",ppList.get("PatrsList"));
				// 2017/07/03 宋健 追加↓↓↓　dazhong@YMSC
				super.assign("AssemblylineList",ppList.get("AssemblylineList"));
				// 2017/07/03 宋健 追加↑↑↑　dazhong@YMSC

				// 取得页面grid显示项目列表
				super.session("gridcol", b06s002Business.getGridColmun(
						"B06S002", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B06S002.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S002", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 加工异常分析
	 * @title statistics_b06S002
	 * @return
	 * String
	 */
	public String statistics_b06S002(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			// 加工异常分析数量
			super.ajaxReturn(b06s002Business.getStatisticalCount(param,langCode, langValue));
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/statistics_b06S002", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S001", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 根据生产线Id获取零部件集合
	 * @title getPartsById
	 * @return
	 */
	public String getPartsById(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			String assemblyLineID = param.get("AssemblyLineID").toString();

			List<Parts> list = new ArrayList<Parts>();
			if(!"".equals(assemblyLineID)){
				list = this.b06s002Business.getPartsListById(assemblyLineID);
			}

			super.ajaxReturn(list);

			// 加工异常分析数量
//			super.ajaxReturn(b06s002Business.getStatisticalCount(param,langCode, langValue));
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/getPartsById", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S002", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	//	excel下载

	public String exportExcel() {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ToolConsumetype", toolConsumetype);
		param.put("dstar", dateStar);
		param.put("dend", dateEnd);
		param.put("systeCode", systeCode);
		param.put("abnormal",abnormal);
		param.put("operator", operator);
		param.put("aprocess",aprocess);
		param.put("spareParts",spareParts);
		try{
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
			cells =rows.createCell(2);
			cells.setCellValue("材料号");
			cells=rows.createCell(3);
			if ("".equals(systeCode)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(systeCode);
			}
			cells =rows.createCell(4);
			cells.setCellValue("异常原因");
			cells=rows.createCell(5);
			if ("".equals(abnormal)){
				cells.setCellValue("-");
			}else if (IConstant.STRING_0.equals(abnormal)){
				cells.setCellValue("加工尺寸不满足");
			}else if (IConstant.STRING_1.equals(abnormal)){
				cells.setCellValue("表面质量不满足");
			}else if (IConstant.STRING_2.equals(abnormal)){
				cells.setCellValue("机床原因");
			}else {
				cells.setCellValue("未知");
			}
			cells =rows.createCell(6);
			cells.setCellValue("工序");
			cells=rows.createCell(7);
			if ("".equals(aprocess)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> ppList = this.b06s002Business.getPPList();
				List<Process> prlist=(List<Process>)ppList.get("ProcessList");
				for (Process pr : prlist) {
					if (aprocess.equals(pr.getProcessID())) {
						cells.setCellValue(pr.getProcessName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}

			}
			cells =rows.createCell(8);
			cells.setCellValue("零部件");
			cells=rows.createCell(9);
			if ("".equals(spareParts)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> ppList = this.b06s002Business.getPPList();
				List<Parts> prlist=(List<Parts>)ppList.get("PatrsList");
				for (Parts parts : prlist) {
					if (spareParts.equals(parts.getPartsID())) {
						cells.setCellValue(parts.getPartsName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}

			}
			cells =rows.createCell(10);
			cells.setCellValue("操作者");
			cells=rows.createCell(11);
			if ("".equals(operator)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(operator);
			}
			cells =rows.createCell(12);
			cells.setCellValue("时间");
			cells=rows.createCell(13);
			if ("".equals(dateStar)&&"".equals(dateEnd)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(dateStar+"-"+dateEnd);
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
			cell.setCellValue("时间段");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("异常原因");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("操作者");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("工序");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("加工设备编号");
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue("零部件");
			cell.setCellStyle(style);

			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b06s002Business.getList(param, "", "", 2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vanalysis> vaList = (List<Vanalysis>) list.get("rows");
			if (vaList == null) {
				vaList = new ArrayList<Vanalysis>();
			}
			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vaList.size(); i++) {
				Vanalysis vanalysis = vaList.get(i);
				row = sheet.createRow(i + 4);
//row.createCell(0).setCellValue("");
				cell = row.createCell(0);//刀具类型
				String type =vanalysis.getToolType();
				if("".equals(type)){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(type);
				}

				cell = row.createCell(1);//材料号
				if ("".equals(vanalysis.getToolCode())||vanalysis.getToolCode()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vanalysis.getToolCode());
				}
				cell = row.createCell(2);
				if ("".equals(vanalysis.getOuterTime())||vanalysis.getOuterTime()==null){
					cell.setCellValue(new Date());
				}else {
					cell.setCellValue(Ctl.dateFormat(vanalysis.getOuterTime(), "yyyy-MM-dd"));//时间
				}
				cell = row.createCell(3);//异常原因
//			//0正常1 加工尺寸不满足2表面质量不满足3机床原因
				if (IConstant.STRING_0.equals(vanalysis.getRemoveReason())){
					cell.setCellValue("正常卸下");
				}else if (IConstant.STRING_1.equals(vanalysis.getRemoveReason())){
					cell.setCellValue("加工尺寸不满足");
				}
				else if (IConstant.STRING_2.equals(vanalysis.getRemoveReason())){
					cell.setCellValue("表面质量不满足");
				}else if (IConstant.STRING_3.equals(vanalysis.getRemoveReason())){
					cell.setCellValue("机床原因");
				}else {
					cell.setCellValue("未知");
				}

				cell = row.createCell(4);
				if ("".equals(vanalysis.getOuterUser())||vanalysis.getOuterUser()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vanalysis.getOuterUser());
				}
				cell = row.createCell(5);//工序
				if ("".equals(vanalysis.getProcessName())||vanalysis.getProcessName()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vanalysis.getProcessName());
				}
				cell = row.createCell(6);//设备
				if ("".equals(vanalysis.getEquipmentName())||vanalysis.getEquipmentName()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vanalysis.getEquipmentName());
				}
				cell = row.createCell(7);//零部件
				if ("".equals(vanalysis.getPartsName())||vanalysis.getPartsName()==null){
					cell.setCellValue("null");
				}else {
					cell.setCellValue(vanalysis.getPartsName());
				}
			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "加工异常分析报表.xls";// title是前台传入的
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
	private String  toolConsumetype;
	private String  dateStar;
	private String  dateEnd;
	private String  systeCode;
	private String  abnormal;
	private String  operator;
	private String  aprocess;
	private String  spareParts;
	private InputStream  excelStream;
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

	public String getAbnormal() {
		return abnormal;
	}

	public void setAbnormal(String abnormal) {
		this.abnormal = abnormal;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAprocess() {
		return aprocess;
	}

	public void setAprocess(String aprocess) {
		this.aprocess = aprocess;
	}

	public String getSpareParts() {
		return spareParts;
	}

	public void setSpareParts(String spareParts) {
		this.spareParts = spareParts;
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
