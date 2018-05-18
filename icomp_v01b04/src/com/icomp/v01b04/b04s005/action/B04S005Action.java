package com.icomp.v01b04.b04s005.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.*;
import com.icomp.v01b04.b04s005.business.B04S005Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System;
import java.util.*;

/**
 * 车间工作量汇总询Action
 * 
 * @ClassName: B03S005Action
 * @author Taoyy
 * @date 2014-8-12 下午04:13:27
 */
public class B04S005Action extends IcompAction {
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
	 * 车间工作量汇总询BUSINESS
	 */
	private B04S005Business b04s005Business;

	public void setB04s005Business(B04S005Business b04s005Business) {
		this.b04s005Business = b04s005Business;
	}

	/**
	 * 初始化车间工作量汇总询页面
	 * 
	 * @title initb01S005
	 * @return String
	 */
	public String initb04S005() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 车间工作量汇总
				Map<String, Object> list = this.b04s005Business.getList(param,langCode, langValue,1);
				super.ajaxReturn(list);
				return null;
			} else {
				total= this.b04s005Business.getNumber();
				// 初始化页面下拉列表默认值
				super.assign("AssemblyLineID","");
				super.assign("ProcessID","");
				super.assign("SynthesisParametersID","");
				super.assign("PartsID","");
				super.assign("EquipmentID","");
				super.assign("AxleID","");
				// 年 月 周 日
				super.assign("WorkloadSummaryList", b04s005Business.getComList(IConstant.WORK_SUMMARY,langCode, langValue));
				Map<String,Object> list = this.b04s005Business.getPageSelList(langCode, langValue);
				super.assign("AssemblyLineList",list.get("AssemblyLineList"));
				super.assign("ProcessList",list.get("ProcessList"));
				super.assign("EquipmentList",list.get("EquipmentList"));
				super.assign("AxleLineList",list.get("AxleLineList"));
				super.assign("PartsList",list.get("PartsList"));
			}

			// 取得页面grid显示项目列表
			super.session("gridcol", b04s005Business.getGridColmun(
					"B04S005", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S005.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B04S005", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	//	excel下载

	public String exportExcel() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("productionLine", productionLine);
		param.put("procedure", procedure);
		param.put("equipment", equipment);
		param.put("axisNumber", axisNumber);
		param.put("toolCode",toolCode );
		param.put("datePeriod", datePeriod);
		param.put("dstar", dstar);
		param.put("dend", dend);
		param.put("model", model);



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

			cells.setCellValue("生产线");
			cells=rows.createCell(1);
			if ("".equals(productionLine)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b04s005Business.getPageSelList("", "");
				List<Assemblyline> aslist=(List<Assemblyline>) list.get("AssemblyLineList");
				for (Assemblyline as : aslist) {
					if (productionLine.equals(as.getAssemblyLineID())) {
						cells.setCellValue(as.getAssemblyLineName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}
			}
			cells =rows.createCell(2);
			cells.setCellValue("工序");
			cells=rows.createCell(3);
			if ("".equals(procedure)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b04s005Business.getPageSelList("", "");
				List<com.icomp.entity.base.Process> prlist=(List<com.icomp.entity.base.Process>) list.get("ProcessList");
				for (com.icomp.entity.base.Process prs : prlist) {
					if (procedure.equals(prs.getProcessID())) {
						cells.setCellValue(prs.getProcessName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}
			}
			cells =rows.createCell(4);
			cells.setCellValue("加工设备");
			cells=rows.createCell(5);
			if ("".equals(equipment)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b04s005Business.getPageSelList("", "");
				List<Equipment> prlist=(List<Equipment>)list.get("EquipmentList");
				for (Equipment eqs : prlist) {
					if (equipment.equals(eqs.getEquipmentID())) {
						cells.setCellValue(eqs.getEquipmentName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}
			}
			cells =rows.createCell(6);
			cells.setCellValue("轴编号");
			cells=rows.createCell(7);
			if ("".equals(axisNumber)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b04s005Business.getPageSelList("", "");
				List<Axle> prlist=(List<Axle>)list.get("AxleLineList");
				for (Axle ax : prlist) {
					if (axisNumber.equals(ax.getAxleID())) {
						cells.setCellValue(ax.getAxleName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}

			}

			cells =rows.createCell(8);
			cells.setCellValue("零部件");
			cells=rows.createCell(9);
			if ("".equals(model)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b04s005Business.getPageSelList("", "");
				List<Parts> prlist=(List<Parts>)list.get("PartsList");
				for (Parts parts : prlist) {
					if (model.equals(parts.getPartsID())) {
						cells.setCellValue(parts.getPartsName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}

			}
			cells =rows.createCell(10);
			cells.setCellValue("材料号");
			cells=rows.createCell(11);
			if ("".equals(toolCode)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(toolCode);
			}
			cells =rows.createCell(12);
			cells.setCellValue("时间");
			cells=rows.createCell(13);
			if ("".equals(dstar)&&"".equals(dend)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(dstar+"-"+dend);
			}

			HSSFRow rowsd = sheet.createRow(2);//创建第三行
			HSSFCell cellsd = rowsd.createCell(0);//创建这行的第一个元素.从0开始
			sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
			cellsd.setCellValue("详细");
			cellsd.setCellStyle(style);

			HSSFRow row = sheet.createRow(3);//创建一行
			HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始
			cell.setCellValue("生产线");//写入内容
			cell.setCellStyle(style);

			cell = row.createCell(1);//同上
			cell.setCellValue("加工设备");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("轴编号");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("合成刀具编码");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("工序");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("时间");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("加工数量");
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue("合成刀具消耗次数");
			cell.setCellStyle(style);


			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b04s005Business.getList(param, "", "", 2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vworkshopsummary> vwList = (List<Vworkshopsummary>) list.get("rows");
			if (vwList == null) {
				vwList = new ArrayList<Vworkshopsummary>();
			}

				//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vwList.size(); i++) {
				Vworkshopsummary vworkshopsummary = vwList.get(i);
				row = sheet.createRow(i + 4);
//row.createCell(0).setCellValue("");
				cell = row.createCell(0);//生产线
				if ("".equals(vworkshopsummary.getAssemblyLineName())||vworkshopsummary.getAssemblyLineName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vworkshopsummary.getAssemblyLineName());
				}
				cell = row.createCell(1);//加工设备
				if ("".equals(vworkshopsummary.getEquipmentName())||vworkshopsummary.getEquipmentName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vworkshopsummary.getEquipmentName());
				}
				cell = row.createCell(2);//轴编码
				if ("".equals(vworkshopsummary.getAxleCode())||vworkshopsummary.getAxleCode()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vworkshopsummary.getAxleCode());
				}
				cell = row.createCell(3);//修磨设备编码
				if ("".equals(vworkshopsummary.getSynthesisParametersCode())||vworkshopsummary.getSynthesisParametersCode()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vworkshopsummary.getSynthesisParametersCode());
				}
				cell = row.createCell(4);//工序
				if ("".equals(vworkshopsummary.getProcessName())||vworkshopsummary.getProcessName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(String.valueOf(vworkshopsummary.getPartsName()));
				}
				cell = row.createCell(5);//时间
				if ("".equals(vworkshopsummary.getOuterTime())||vworkshopsummary.getOuterTime()==null){
					cell.setCellValue(new Date());
				}else {
					cell.setCellValue(Ctl.dateFormat(vworkshopsummary.getOuterTime(), "yyyy-MM-dd"));
				}

				cell = row.createCell(6);//加工数量
				if ("".equals(vworkshopsummary.getProcessAmount())||vworkshopsummary.getProcessAmount()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(String.valueOf(vworkshopsummary.getProcessAmount()));
				}
				cell = row.createCell(7);//加工数量
				if ("".equals(vworkshopsummary.getSynconsume())||vworkshopsummary.getSynconsume()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(String.valueOf(vworkshopsummary.getSynconsume()));
				}
			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "车间工作量汇总表.xls";
			excelFileName = new String(excelFileName.getBytes("gb2312"),
					"iso8859-1");
			is.close();
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S005.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S005", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		} catch (IOException e) {
			System.out.println("写入流异常");
		}
		return "exportExcels";

	}
	private String productionLine;
	private String procedure;
	private String equipment;
	private String axisNumber;
	private String toolCode;
	private String datePeriod;
	private InputStream excelStream;
	private String excelFileName;
	private String dstar;
	private String dend;
	private String model;

	public String getDstar() {

		return dstar;
	}

	public void setDstar(String dstar) {
		this.dstar = dstar;
	}

	public String getDend() {
		return dend;
	}

	public void setDend(String dend) {
		this.dend = dend;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getAxisNumber() {
		return axisNumber;
	}

	public void setAxisNumber(String axisNumber) {
		this.axisNumber = axisNumber;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getDatePeriod() {
		return datePeriod;
	}

	public void setDatePeriod(String datePeriod) {
		this.datePeriod = datePeriod;
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
