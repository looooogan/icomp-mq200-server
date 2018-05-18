package com.icomp.v01b04.b04s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Voplinkdown;
import com.icomp.entity.base.Vsynthesiscondition;
import com.icomp.v01b04.b04s002.business.B04S002Business;

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
 * 车间刀具状态查询Action
 *
 * @ClassName: B03S002Action
 * @author Taoyy
 * @date 2014-8-12 下午04:13:27
 */
public class B04S002Action extends IcompAction {
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
	 * 车间刀具状态查询BUSINESS
	 */
	private B04S002Business b04s002Business;
	public void setB04s002Business(B04S002Business b04s002Business) {
		this.b04s002Business = b04s002Business;
	}



	/**
	 * 初始化车间刀具状态查询页面
	 * @title initb01S002
	 * @return
	 * String
	 */
	public String initb04S002(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 车间刀具状态查询
				Map<String, Object> list = this.b04s002Business.getList(param,langCode,langValue,1);
				super.ajaxReturn(list);
				return null;
			}else {
				Map<String,Object> list = this.b04s002Business.getPageSelList(langCode, langValue);
				super.assign("AssemblyLineList",list.get("AssemblyLineList"));
				super.assign("ProcessList",list.get("ProcessList"));


				// 取得页面grid显示项目列表
				super.session("gridcol", b04s002Business.getGridColmun(
						"B04S002", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S002.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S002", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	//下拉联动
	public String prossAnd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String AssemblylineID = param.get("productionLineID").toString();
			if (StringUtils.isEmpty(AssemblylineID)) {
				// 取得流程列表
				List<Assemblyline> listAssemblyline = b04s002Business.getAssemblyline(IConstant.DEL_FLAG_0, langCode, langValue);
				AssemblylineID = listAssemblyline.get(0).getAssemblyLineID();

			}
			// 取得流程工序中间表
			List<Voplinkdown> listOplink = b04s002Business.getVoplink(AssemblylineID, IConstant.DEL_FLAG_0, langCode, langValue,1);
			super.assign("listOplink", listOplink);
			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/prossAndBuss.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "prossAndBuss",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	String productionLine;
	String procedure;
	String toolCode;
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

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	//	excel下载

	public String exportExcel() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("productionLine", productionLine);
		param.put("procedure", procedure);
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

				Map<String,Object> list = this.b04s002Business.getPageSelList("", "");
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
				Map<String,Object> list = this.b04s002Business.getPageSelList("", "");
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
			cells.setCellValue("合成刀具编码");
			cells=rows.createCell(5);
			if ("".equals(toolCode)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(toolCode);
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
			cell.setCellValue("工序");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("合成刀具编码");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("设备上数量");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("已换装数量");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("卸下待换装");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("合计");
			cell.setCellStyle(style);
			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b04s002Business.getList(param, "", "",2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vsynthesiscondition> vsList = (List<Vsynthesiscondition>) list.get("rows");
			if (vsList == null) {
				vsList = new ArrayList<Vsynthesiscondition>();
			}


			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vsList.size(); i++) {
				Vsynthesiscondition vsystion = vsList.get(i);
				row = sheet.createRow(i + 4);
//row.createCell(0).setCellValue("");
				cell = row.createCell(0);//生产线
				if ("".equals(vsystion.getAssemblyLineName())||vsystion.getAssemblyLineName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getAssemblyLineName());
				}


				cell = row.createCell(1);//工序
				if ("".equals(vsystion.getProcessName())||vsystion.getProcessName()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getProcessName());
				}

				cell = row.createCell(2);//合成刀具编码
				if ("".equals(vsystion.getSynthesisParametersCode())||vsystion.getSynthesisParametersCode()==null){
					cell.setCellValue(new Date());
				}else {
					cell.setCellValue(vsystion.getSynthesisParametersCode());
				}

				cell = row.createCell(3);//设备上数量
				if ("".equals(vsystion.getNumberDevices())||vsystion.getNumberDevices()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getNumberDevices());
				}


				cell = row.createCell(4);//已换装数量
				if ("".equals(vsystion.getNumberToolStorage())||vsystion.getNumberToolStorage()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(vsystion.getNumberToolStorage());
				}


				cell = row.createCell(5);//卸下待换装
				if ("".equals(vsystion.getRegulatinRoom())||vsystion.getRegulatinRoom()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(vsystion.getRegulatinRoom());
				}
				cell = row.createCell(6);//合计
				if ("".equals(vsystion.getExpandSpace1())||vsystion.getExpandSpace1()==null){
					cell.setCellValue("-");
				}else {
					cell.setCellValue(vsystion.getExpandSpace1());
				}
			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "合成刀具状态查询.xls";
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
