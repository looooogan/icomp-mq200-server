package com.icomp.v01b01.b01s012.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vauthorization;
import com.icomp.v01b01.b01s012.business.B01S012Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 授权查询
 * @ClassName: B01S012Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:17:43
 */
public class B01S012Action extends IcompAction {
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 *授权查询 BUSINESS
	 */
	private B01S012Business b01s012Business;
	public void setB01s012Business(B01S012Business b01s012Business) {
		this.b01s012Business = b01s012Business;
	}

	/**
	 * 页面初始化
	 * @title initb01S012 
	 * @return
	 * String
	 */
	public String initb01S012(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//库存查询列表
				Map<String, Object> list = this.b01s012Business.getList(param,langCode,langValue,1);
				super.ajaxReturn(list);
				return null;
			}else {
				total=this.b01s012Business.getNumber();
				// 初始化页面下拉列表默认值
				super.assign("Business","");
				Map<String,Object> list = this.b01s012Business.getPageSelList(langCode, langValue);
				super.assign("BusinessesList",list.get("BusinessesList"));
				// 取得页面grid显示项目列表
				super.session("gridcol", b01s012Business.getGridColmun("B01S012", ((Customer) super.session("Customer")).getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}

		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B01S012.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B01S012", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
		//	excel下载

	public String exportExcel() {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("authorizedReason", authorizedReason);
				param.put("dstar", dateStar);
				param.put("dend", dateEnd);
				param.put("systeCode", systeCode);
				param.put("authorizationName", authorizationName);
				param.put("OperationConten", operationConten);
				param.put("SituationBrief", situationBrief);
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

					cells.setCellValue("材料号");
					cells=rows.createCell(1);
					if ("".equals(systeCode)){
						cells.setCellValue("-");
					}else {
						cells.setCellValue(systeCode);
					}
					cells =rows.createCell(2);
					cells.setCellValue("原因");
					cells=rows.createCell(3);
					if ("".equals(authorizedReason)){
						cells.setCellValue("-");
					}else if(IConstant.STRING_0.equals(authorizedReason)){
						cells.setCellValue("断刀");
					}else if(IConstant.STRING_1.equals(authorizedReason)){
						cells.setCellValue("丢刀");
					}else if(IConstant.STRING_2.equals(authorizedReason)){
						cells.setCellValue("补领");
					}else if(IConstant.STRING_3.equals(authorizedReason)){
						cells.setCellValue("到寿");
					}else if(IConstant.STRING_4.equals(authorizedReason)){
						cells.setCellValue("卸下后安上");
					}else if(IConstant.STRING_5.equals(authorizedReason)){
						cells.setCellValue("重复换装");
					}else if(IConstant.STRING_6.equals(authorizedReason)){
						cells.setCellValue("重复复磨");
					}else if(IConstant.STRING_7.equals(authorizedReason)){
						cells.setCellValue("重复初始化设备");
					}else if(IConstant.STRING_8.equals(authorizedReason)){
						cells.setCellValue("库存盘点");
					}else if(IConstant.STRING_9.equals(authorizedReason)){
						cells.setCellValue("出库报废");
					}else if(IConstant.STRING_10.equals(authorizedReason)){
						cells.setCellValue("刀具报废");
					}else if(IConstant.STRING_12.equals(authorizedReason)){
						cells.setCellValue("刀具分拣");
					}else {
						cells.setCellValue("其他");
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
					cells.setCellValue("授权人");
					cells=rows.createCell(7);
					if ("".equals(authorizationName)){
						cells.setCellValue("-");
					}else {
						cells.setCellValue(authorizationName);
					}
					cells =rows.createCell(8);
					cells.setCellValue("操作流程");
					cells=rows.createCell(9);
					if ("".equals(operationConten)){
						cells.setCellValue("-");
					}else {
						Map<String,Object> list = this.b01s012Business.getPageSelList("", "");
					   List<Business>	 busList = (List<Business>) list.get("BusinessesList");
						for (Business bus : busList) {
							if (operationConten.equals(bus.getBusinessID())){
								cells.setCellValue(bus.getBusinessCode());
								break;
							}else {
								cells.setCellValue("-");

							}
						}

					}
					cells =rows.createCell(10);
					cells.setCellValue("情况简述");
					cells=rows.createCell(11);
					if ("".equals(situationBrief)){
						cells.setCellValue("-");
					}else {
						cells.setCellValue(situationBrief);
					}

					HSSFRow rowsd = sheet.createRow(2);//创建第三行
					HSSFCell cellsd = rowsd.createCell(0);//创建这行的第一个元素.从0开始
					sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
					cellsd.setCellValue("详细");
					cellsd.setCellStyle(style);

					HSSFRow row = sheet.createRow(3);//创建一行
					HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始
					cell.setCellValue("材料号");//写入内容
					cell.setCellStyle(style);

					cell = row.createCell(1);//同上
					cell.setCellValue("时间段");
					cell.setCellStyle(style);

					cell = row.createCell(2);
					cell.setCellValue("授权人");
					cell.setCellStyle(style);

					cell = row.createCell(3);
					cell.setCellValue("授权原因");
					cell.setCellStyle(style);

					cell = row.createCell(4);
					cell.setCellValue("刀具当前状态");
					cell.setCellStyle(style);

					cell = row.createCell(5);
					cell.setCellValue("操作流程");
					cell.setCellStyle(style);

					cell = row.createCell(6);
					cell.setCellValue("操作者");
					cell.setCellStyle(style);

					cell = row.createCell(7);
					cell.setCellValue("情况简述");
					cell.setCellStyle(style);

					Map<String, Object> list = new HashMap<String, Object>();
					try {
						  list = this.b01s012Business.getList(param, "", "", 2);
						if (list == null && list.size() < 0) {
							list = new HashMap<String, Object>();
						}
					} catch (Exception e1) {
						System.out.println("ecxel导出异常");
					}
					List<Vauthorization> vahList = (List<Vauthorization>) list.get("rows");
					if (vahList == null) {
						vahList = new ArrayList<Vauthorization>();
					}
					//循环,将下面几行的数据取出来放入这个sheet中
					for (int i = 0; i < vahList.size(); i++) {
						Vauthorization vauthorization = vahList.get(i);
						row = sheet.createRow(i + 4);
						//row.createCell(0).setCellValue("");
						cell = row.createCell(0);//材料号
						if("".equals(vauthorization.getToolCode())||vauthorization.getToolCode()==null){
							cell.setCellValue("-");
						}else {
							cell.setCellValue(vauthorization.getToolCode());
						}


						cell = row.createCell(1);//时间段
						if ("".equals(vauthorization.getAuthorizedTime())){
							cell.setCellValue(new Date());
						}else{
							cell.setCellValue(Ctl.dateFormat(vauthorization.getAuthorizedTime(),"yyyy-MM-dd"));
						}




						cell = row.createCell(2);//授权人
						if("".equals(vauthorization.getAuthorizationUser())||vauthorization.getAuthorizationUser()==null){
							cell.setCellValue("-");
						}else {
							cell.setCellValue(vauthorization.getAuthorizationUser());
						}



						cell = row.createCell(3);//授权原因0断刀1丢刀2报废3非正常流程
//						授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其他）
						if(IConstant.STRING_0.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("断刀");
						}else if(IConstant.STRING_1.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("丢刀");
						}else if(IConstant.STRING_2.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("补领");
						}else if(IConstant.STRING_3.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("到寿");
						}else if(IConstant.STRING_4.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("卸下后安上");
						}else if(IConstant.STRING_5.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("重复换装");
						}else if(IConstant.STRING_6.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("重复复磨");
						}else if(IConstant.STRING_7.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("重复初始化设备");
						}else if(IConstant.STRING_8.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("库存盘点");
						}else if(IConstant.STRING_9.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("出库报废");
						}else if(IConstant.STRING_10.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("刀具报废");
						}else if(IConstant.STRING_12.equals(vauthorization.getAuthorizedReason())){
							cell.setCellValue("刀具分拣");
						}else {
							cell.setCellValue("其他");
						}

						cell = row.createCell(4);
						//	授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其他）
						if(IConstant.STRING_0.equals(vauthorization.getToolReason())){
							cell.setCellValue("断刀");
						}else if(IConstant.STRING_1.equals(vauthorization.getToolReason())){
							cell.setCellValue("丢刀");
						}else if(IConstant.STRING_2.equals(vauthorization.getToolReason())){
							cell.setCellValue("补领");
						}else if(IConstant.STRING_3.equals(vauthorization.getToolReason())){
							cell.setCellValue("到寿");
						}else if(IConstant.STRING_4.equals(vauthorization.getToolReason())){
							cell.setCellValue("卸下后安上");
						}else if(IConstant.STRING_5.equals(vauthorization.getToolReason())){
							cell.setCellValue("重复换装");
						}else if(IConstant.STRING_6.equals(vauthorization.getToolReason())){
							cell.setCellValue("重复复磨");
						}else if(IConstant.STRING_7.equals(vauthorization.getToolReason())){
							cell.setCellValue("重复初始化设备");
						}else if(IConstant.STRING_8.equals(vauthorization.getToolReason())){
							cell.setCellValue("库存盘点");
						}else if(IConstant.STRING_9.equals(vauthorization.getToolReason())){
							cell.setCellValue("出库报废");
						}else if(IConstant.STRING_10.equals(vauthorization.getToolReason())){
							cell.setCellValue("刀具报废");
						}else if(IConstant.STRING_12.equals(vauthorization.getToolReason())){
							cell.setCellValue("刀具分拣");
						}else {
							cell.setCellValue("其他");
						}
						cell = row.createCell(5);//操作流程
						if("".equals(vauthorization.getBusinessCode())||vauthorization.getBusinessCode()==null){
							cell.setCellValue("其他");
						}else{
							cell.setCellValue(vauthorization.getBusinessCode());
						}

						cell = row.createCell(6);//操作者
						if("".equals(vauthorization.getOperator())||vauthorization.getOperator()==null){
							cell.setCellValue("-");
						}else {
							cell.setCellValue(vauthorization.getOperator());
						}


						cell = row.createCell(7);//情况简述
						if ("".equals(vauthorization.getNote())||vauthorization.getNote()==null){
							cell.setCellValue("-");
						}else {
							cell.setCellValue(vauthorization.getNote());
						}


					}
					ByteArrayOutputStream os = new ByteArrayOutputStream();

					wb.write(os);
					os.close();
					byte[] fileContent = os.toByteArray();
					ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
					excelStream = is;
					excelFileName = "授权记录查询表.xls";
					excelFileName = new String(excelFileName.getBytes("gb2312"),
							"iso8859-1");
				} catch (BusinessException ex) {
					ApplicationException.setApplicationException(getResponse(),
							"/B01S012.action", IConstant.RESULT_CODE_1, ex,
							this.getClass().getName(), "B01S012", ((Customer) super
									.session("Customer")).getCustomerID());
					return null;
				} catch (IOException e) {
					System.out.println("写入流异常");

				}
				return "exportExcels";

			}
	private String authorizedReason;
	private String dateStar;
	private String dateEnd;
	private String systeCode;
	private String operationConten;
	private String authorizationName;
	private String situationBrief;
	private String excelFileName;
	private InputStream excelStream;

	public String getAuthorizedReason() {
		return authorizedReason;
	}

	public void setAuthorizedReason(String authorizedReason) {
		this.authorizedReason = authorizedReason;
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

	public String getOperationConten() {
		return operationConten;
	}

	public void setOperationConten(String operationConten) {
		this.operationConten = operationConten;
	}

	public String getAuthorizationName() {
		return authorizationName;
	}

	public void setAuthorizationName(String authorizationName) {
		this.authorizationName = authorizationName;
	}

	public String getSituationBrief() {
		return situationBrief;
	}

	public void setSituationBrief(String situationBrief) {
		this.situationBrief = situationBrief;
	}

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
}
