package com.icomp.v01b06.b06s009.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Vcostamortization;
import com.icomp.v01b06.b06s009.business.B06S009Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成本摊销Action
 * 
 * @ClassName: B06S009Action
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S009Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 成本摊销BUSINESS
	 */
	private B06S009Business b06s009Business;

	public void setB06s009Business(B06S009Business b06s009Business) {
		this.b06s009Business = b06s009Business;
	}

	/**
	 * 初始化成本摊销页面
	 * 
	 * @title initb01S009
	 * @return String
	 */
	public String initb06S009() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 成本摊销列表
				Map<String, Object> list = this.b06s009Business.getList(param, langCode, langValue,1);
				super.ajaxReturn(list);
				return null;
			} else {
				// 初始化页面下拉列表默认值
				super.assign("AssemblyLine","");
				super.assign("Process","");
				super.assign("Parts","");
				super.assign("Equipment","");
				super.assign("Axle","");
				Map<String,Object> list = this.b06s009Business.getPageSelList(langCode, langValue);
				super.assign("AssemblyLineList",list.get("AssemblyLineList"));
				super.assign("ProcessList",list.get("ProcessList"));
				super.assign("PartsList",list.get("PartsList"));
				super.assign("AxleLineList",list.get("AxleLineList"));

				// 取得页面grid显示项目列表
				super.session("gridcol", b06s009Business.getGridColmun(
						"B06S009", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode, langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B06S009.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B06S009", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String exportExcel() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("toolConsumetype", toolConsumetype);
		param.put("dstar", dateStar);
		param.put("dend", dateEnd);
		param.put("yield", yield);
		param.put("spareParts",spareParts );
		param.put("systeCode",systeCode );
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
			cells =rows.createCell(2);
			cells.setCellValue("材料号");
			cells=rows.createCell(3);
			if ("".equals(systeCode)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(systeCode);
			}

			cells =rows.createCell(4);
			cells.setCellValue("时间");
			cells=rows.createCell(5);
			if ("".equals(dateStar)&&"".equals(dateEnd)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(dateStar+"-"+dateEnd);
			}

			cells =rows.createCell(6);
			cells.setCellValue("产量");
			cells=rows.createCell(7);
			if ("".equals(yield)){
				cells.setCellValue("-");
			}else {
				cells.setCellValue(yield);
			}
			cells =rows.createCell(8);
			cells.setCellValue("零部件");
			cells=rows.createCell(9);
			if ("".equals(spareParts)){
				cells.setCellValue("-");
			}else {
				Map<String,Object> list = this.b06s009Business.getPageSelList("", "");
				List<Parts> prlist=(List<Parts>)list.get("PartsList");
				for (Parts parts : prlist) {
					if (spareParts.equals(parts.getPartsID())) {
						cells.setCellValue(parts.getPartsName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}

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
			cell.setCellValue("单价(SAP)");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("消耗次数");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("摊销成本（人民币）");
			cell.setCellStyle(style);

			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b06s009Business.getList(param, "", "", 2);
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vcostamortization> vctList = (List<Vcostamortization>) list.get("rows");
			if (vctList == null) {
				vctList = new ArrayList<Vcostamortization>();
			}
			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vctList.size(); i++) {
				Vcostamortization vcostamortization = vctList.get(i);
				row = sheet.createRow(i + 4);
				cell = row.createCell(0);//刀具类型
				String type =vcostamortization.getToolType();

					cell.setCellValue("type");


				cell = row.createCell(1);
				if ("".equals(vcostamortization.getToolCode())||vcostamortization.getToolCode()==null){
				cell.setCellValue("null");
				}else {
					cell.setCellValue(vcostamortization.getToolCode());//材料号
				}
				cell = row.createCell(2);//单价
				if ("".equals(vcostamortization.getUnitPrice())||vcostamortization.getUnitPrice()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(vcostamortization.getUnitPrice());
				}
				cell = row.createCell(3);//消耗次数
				if ("".equals( vcostamortization.getUserNumber())|| vcostamortization.getUserNumber()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(vcostamortization.getUserNumber().toString());
				}
				cell = row.createCell(4);//摊销成本
				if ("".equals(vcostamortization.getAmortizationRMB())||vcostamortization.getAmortizationRMB()==null){
					cell.setCellValue(IConstant.STRING_0);
				}else {
					cell.setCellValue(String.valueOf(vcostamortization.getAmortizationRMB()));
				}


			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);
			os.close();
			byte[] fileContent = os.toByteArray();
			ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
			excelStream = is;
			excelFileName = "成本摊销.xls";
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
	private String yield;
	private String spareParts;
	private String systeCode;

	private InputStream excelStream;
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

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getSysteCode() {
		return systeCode;
	}

	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
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
