package com.icomp.v01b01.b01s013.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vtoolsop;
import com.icomp.v01b01.b01s013.business.B01S013Business;
import org.apache.poi.hssf.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 库存状况查询Action
 * @ClassName: B01S013Action 
 * @author Licc
 * @date 2014-11-10 下午02:31:34
 */
public class B01S013Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 入库信息查询BUSINESS
	 */
	private B01S013Business b01s013Business;
	
	public void setB01s013Business(B01S013Business b01s013Business) {
		this.b01s013Business = b01s013Business;
	}


	/**
	 * 初始化库存状况查询页面
	 * @title initb01S013 
	 * @return
	 * String
	 */
	public String initb01S013(){
		try {
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 库存状况查询列表
				Map<String, Object> list = this.b01s013Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else if("edit".equals(param.get("opt"))) {
				// 库存状况查询列表
				Map<String, Object> list = this.b01s013Business.getList(param,langCode,langValue);
				super.ajaxReturn(list.get(0));
				return null;
			}else{
					super.assign("ToolTypeList", b01s013Business.getComList(
							IConstant.TOOL_TYPE, langCode,langValue));
					super.assign("KnifeInventoryTypeList", b01s013Business.getComList(
							IConstant.KNIFE_INVENTORY_TYPE, langCode,langValue));
					// 取得页面grid显示项目列表
					super.session("gridcol", b01s013Business.getGridColmun(
							"B01S013", ((Customer) super.session("Customer"))
									.getCustomerID(), langCode,  langValue));
					return SUCCESS;
				}


		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S013.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S013", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑用户信息
	 *
	 * @return
	 */
	public String sapEdit() {
		try {
			String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
			String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
			Map<String, Object> param = super.param ();
			Map<String, Object> ret = this.b01s013Business.sapEdit ( param, langCode, langValue );

			if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
				super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
				return null;
			} else {
				super.ajaxReturn ( ret );
			}
			//记录编辑成功日志
			CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "sapEdit", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
			return null;
		} catch (Exception ex) {
			//ApplicationException.setApplicationException ( getResponse (), "/userEdit.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userEdit", ((Customer) super.session ( "Customer" )).getCustomerID () );
			return null;
		}
	}

	private String toolType;
	private String systeCode;
	private String dstar;
	private String dends;
	private String userName;
	private String stateSt;
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

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getSysteCode() {
		return systeCode;
	}

	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
	}

	public String getDstar() {
		return dstar;
	}

	public void setDstar(String dstar) {
		this.dstar = dstar;
	}

	public String getDends() {
		return dends;
	}

	public void setDends(String dends) {
		this.dends = dends;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStateSt() {
		return stateSt;
	}

	public void setStateSt(String stateSt) {
		this.stateSt = stateSt;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String exportExcel() {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("toolType", toolType);
		param.put("systeCode", systeCode);
		param.put("dstar", dstar);
		param.put("dends", dends);
		param.put("userName", userName);
		param.put("stateSt", stateSt);

		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
			HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
			HSSFRow row = sheet.createRow(0);//创建一行
			HSSFCellStyle style = wb.createCellStyle();//居中

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
			cell.setCellValue("库管员");
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue("上传状态选择：已上传、未上传（失败原因）");
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue("上传类型：入库、出库");
			cell.setCellStyle(style);


			Map<String, Object> list = new HashMap<String, Object>();
			try {
				list = this.b01s013Business.getList(param, "", "");
				if (list == null && list.size() < 0) {
					list = new HashMap<String, Object>();
				}
			} catch (Exception e1) {
				System.out.println("ecxel导出异常");
			}
			List<Vtoolsop> vrList = (List<Vtoolsop>) list.get("rows");
			if (vrList == null) {
				vrList = new ArrayList<Vtoolsop>();
			}


			//循环,将下面几行的数据取出来放入这个sheet中
			for (int i = 0; i < vrList.size(); i++) {
				Vtoolsop vlist = vrList.get(i);
				row = sheet.createRow(i + 1);

				cell = row.createCell(0);//刀具类型
				if ("".equals(vlist.getExpandSpace1())||vlist.getExpandSpace1()==null){
				cell.setCellValue("-");
			}else {
				cell.setCellValue(vlist.getToolCode().charAt(0));
			}


			cell = row.createCell(1);//材料号
			if ("".equals(vlist.getToolCode())||vlist.getToolCode()==null){
				cell.setCellValue("-");
			}else {
				cell.setCellValue(vlist.getToolCode());
			}

			cell = row.createCell(2);//时间
			if ("".equals(vlist.getCreateTime())||vlist.getCreateTime()==null){
				cell.setCellValue(new Date());
			}else  {
				String date = Ctl.dateFormat(vlist.getCreateTime(), "yyyy-MM-dd");
				cell.setCellValue(date);

			}

			cell = row.createCell(4);//数量
			if ("".equals(vlist.getStorageNum())||vlist.getStorageNum()==null){
				cell.setCellValue("-");
			}else {
				cell.setCellValue( String.valueOf(vlist.getStorageNum()));
			}


			cell = row.createCell(5);//库管员
			if ("".equals(vlist.getLibraryUser())||vlist.getLibraryUser()==null){
				cell.setCellValue("-");
			}else {
				cell.setCellValue(vlist.getLibraryUser());
			}
			cell = row.createCell(6);//上传状态
			if ("".equals(vlist.getStates())||vlist.getStates()==null){
				cell.setCellValue("-");
			}else {
				cell.setCellValue(vlist.getStates());
			}
			cell = row.createCell(7);//上传类型
			if ("".equals(vlist.getStateSt())||vlist.getStateSt()==null){
				cell.setCellValue("-");
			}else {
				cell.setCellValue(vlist.getStateSt().toString());
			}


		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		wb.write(os);
		os.close();
		byte[] fileContent = os.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
		excelStream = is;
		excelFileName = "Sap查询.xls";
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
