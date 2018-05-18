package com.icomp.v01b04.b04s004.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Axle;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Process;
import com.icomp.entity.base.Vamortization;
import com.icomp.entity.base.Voplinkdown;
import com.icomp.v01b04.b04s004.business.B04S004Business;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具消耗查询Action
 * 
 * @ClassName: B03S004Action
 * @author Taoyy
 * @date 2014-8-12 下午04:13:27
 */
public class B04S004Action extends IcompAction {
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
	 * 刀具消耗查询BUSINESS
	 */
	private B04S004Business b04s004Business;
	public void setB04s004Business(B04S004Business b04s004Business) {
		this.b04s004Business = b04s004Business;
	}
	
	/**
	 * 初始化刀具消耗查询页面
	 * @title initb01S004 
	 * @return
	 * String
	 */
	public String initb04S004(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 刀具消耗查询
				Map<String, Object> list = this.b04s004Business.getList(param,langCode,langValue,1);
				super.ajaxReturn(list);
				return null;
			}else{

				total  = this.b04s004Business.getNumber();
				// 初始化页面下拉列表默认值
				super.assign("AssemblyLineID","");
				super.assign("ProcessID","");

				super.assign("PartsID","");
				super.assign("EquipmentID","");
				super.assign("AxleID","");
				// 年 月 周 日

				Map<String,Object> list = this.b04s004Business.getPageSelList(langCode, langValue);
				super.assign("AssemblyLineList",list.get("AssemblyLineList"));
				super.assign("ProcessList",list.get("ProcessList"));
				super.assign("EquipmentList",list.get("EquipmentList"));
				super.assign("PartsList",list.get("PartsList"));
				super.assign("AxleLineList",list.get("AxleLineList"));
			}

			// 取得页面grid显示项目列表
			super.session("gridcol", b04s004Business.getGridColmun(
					"B04S004", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S004.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	/*生产管理联动*/
	public String prossAndBuss() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String AssemblylineID = param.get("productionLineID").toString();
			if (StringUtils.isEmpty(AssemblylineID)) {
				// 取得流程列表
				List<Assemblyline> listAssemblyline = b04s004Business.getAssemblyline(IConstant.DEL_FLAG_0, langCode, langValue);
				AssemblylineID = listAssemblyline.get(0).getAssemblyLineID();

			}
			// 取得流程工序中间表
			List<Voplinkdown> listOplink = b04s004Business.getVoplink(param, IConstant.DEL_FLAG_0, langCode, langValue,1);

			super.assign("listOplink", listOplink);
			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );


		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeDepartment",
					((Customer) super.session("Customer")).getCustomerID());

		}
		return null;
	}
	public String prossAndBuss1() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String ProcedureID = param.get("procedureID").toString();
			if (StringUtils.isEmpty(ProcedureID)) {
				// 取得工序
				List<Process> listProcess = b04s004Business.getProcess(IConstant.DEL_FLAG_0, langCode, langValue);
				ProcedureID = listProcess.get(0).getProcessID();

			}
			// 取得流程工序中间表
			List<Voplinkdown> listOplink = b04s004Business.getVoplink(param, IConstant.DEL_FLAG_0, langCode, langValue,2);
//			String ProcessID = listProcess.get(0).getProcessID();
			super.assign("listOplink", listOplink);
			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeDepartment",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String prossAndBuss2() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
				String EquipmentID = (String) param.get("equipmentID");
			if (StringUtils.isEmpty(EquipmentID)) {
				// 取得设备
				List<Equipment> listEquipment = b04s004Business.getEquipment(IConstant.DEL_FLAG_0, langCode, langValue);
				EquipmentID = listEquipment.get(0).getEquipmentID();

			}
			// 取得流程工序中间表
			List<Voplinkdown> listOplink = b04s004Business.getVoplink(param, IConstant.DEL_FLAG_0, langCode, langValue,3);
//			String ProcessID = listProcess.get(0).getProcessID();
			super.assign("listOplink", listOplink);
			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeDepartment",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String prossAndBuss3() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String AxleID = param.get("axisNumberID").toString();
			if (StringUtils.isEmpty(AxleID)) {
				// 取得设备
				List<Axle> listAxle = b04s004Business.getAxle(IConstant.DEL_FLAG_0, langCode, langValue);
				AxleID = listAxle.get(0).getAxleID();

			}
			// 取得流程工序中间表
			List<Voplinkdown> listOplink = b04s004Business.getVoplink(param, IConstant.DEL_FLAG_0, langCode, langValue,4);
//			String ProcessID = listProcess.get(0).getProcessID();
			super.assign("listOplink", listOplink);
			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeDepartment",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	private String productionLine;
	private String procedure;
	private String equipment;
	private String axisNumber;
	private String model;
	private String toolCode;
	private String dstar;
	private String dend;
	private String excelFileName;
	private InputStream excelStream;

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

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

	public String exportExcel() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("productionLine", productionLine);
		param.put("procedure", procedure);
		param.put("equipment", equipment);
		param.put("axisNumber", axisNumber);
		param.put("model", model);
		param.put("dstar", dstar);
		param.put("dend", dend);
		param.put("toolCode", toolCode);
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

			cells.setCellValue("生产线");
			cells=rows.createCell(1);
			if ("".equals(productionLine)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b04s004Business.getPageSelList("", "");
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
				Map<String,Object> list = this.b04s004Business.getPageSelList("", "");
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
				Map<String,Object> list = this.b04s004Business.getPageSelList("", "");
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
				Map<String,Object> list = this.b04s004Business.getPageSelList("", "");
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
				Map<String,Object> list = this.b04s004Business.getPageSelList("", "");
				super.assign("AxleLineList",list.get("AxleLineList"));
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
			cell.setCellValue("材料号");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("加工设备");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("轴编号");
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
			cell.setCellValue("刀具消耗（次数）");
			cell.setCellStyle(style);
			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b04s004Business.getList(param, "", "",2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vamortization> vsList = (List<Vamortization>) list.get("rows");
			if (vsList == null) {
				vsList = new ArrayList<Vamortization>();
			}


			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vsList.size(); i++) {
				Vamortization vsystion = vsList.get(i);
				row = sheet.createRow(i + 4);

				cell = row.createCell(0);//生产线
				if ("".equals(vsystion.getAssemblyLineName())||vsystion.getAssemblyLineName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getAssemblyLineName());
				}

				cell = row.createCell(1);//材料号
				if ("".equals(vsystion.getToolCode())||vsystion.getToolCode()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getToolCode());
				}

				cell = row.createCell(2);//加工设备
				if ("".equals(vsystion.getEquipmentName())||vsystion.getEquipmentName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getEquipmentName());
				}

				cell = row.createCell(3);//轴编号
				if ("".equals(vsystion.getAssemblyLineName())||vsystion.getAssemblyLineName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getAssemblyLineName());
				}


				cell = row.createCell(4);//工序
				if ("".equals(vsystion.getPartsName())||vsystion.getProcessName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getPartsName());
				}


				cell = row.createCell(5);//时间
				if ("".equals(vsystion.getOuterTime())||vsystion.getOuterTime()==null){
					cell.setCellValue(new Date());
				}else {
					cell.setCellValue(Ctl.dateFormat(vsystion.getOuterTime(),"yyyy-MM-dd"));
				}
				cell = row.createCell(6);//加工数量
				if ("".equals(vsystion.getProcessAmount())||vsystion.getProcessAmount()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(String.valueOf(vsystion.getProcessAmount()));
				}

				cell = row.createCell(7);//刀具消耗（次数）
				if ("".equals(vsystion.getProcesNumber())||vsystion.getProcesNumber()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(String.valueOf(vsystion.getProcesNumber()));
				}
			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "刀具消耗查询.xls";
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



}
