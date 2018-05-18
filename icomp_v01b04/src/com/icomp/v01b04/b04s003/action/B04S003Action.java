package com.icomp.v01b04.b04s003.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b04.b04s003.business.B04S003Business;

import java.util.Map;

/**
 * 加工量异常报警Action
 * 
 * @ClassName: B03S003Action
 * @author Taoyy
 * @date 2014-8-12 下午04:13:27
 */
public class B04S003Action extends IcompAction {
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
	 * 加工量异常报警BUSINESS
	 */
	private B04S003Business b04s003Business;
	public void setB04s003Business(B04S003Business b04s003Business) {
		this.b04s003Business = b04s003Business;
	}



	/**
	 * 初始化加工量异常报警页面
	 * @title initb01S003 
	 * @return
	 * String
	 */
	public String initb04S003(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 加工量异常报警
				Map<String, Object> list = this.b04s003Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else {
				total = this.b04s003Business.getNumber();

				super.assign("AssemblyLineID","");
				super.assign("ProcessID","");
				super.assign("PartsID","");
				super.assign("EquipmentID","");
				super.assign("AxleID","");

				Map<String,Object> list = this.b04s003Business.getPageSelList(langCode, langValue);
				super.assign("AssemblyLineList",list.get("AssemblyLineList"));
				super.assign("ProcessList",list.get("ProcessList"));
				super.assign("EquipmentList",list.get("EquipmentList"));
				super.assign("PartsList",list.get("PartsList"));
				super.assign("AxleLineList",list.get("AxleLineList"));
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b04s003Business.getGridColmun(
					"B04S003", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S003.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S003", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
//	public String prossAndBuss() {
//		try {
//			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
//			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
//			// 根据用户选择的机构ID，取得 相应的部门及职务列表
//			Map<String, Object> param = super.param();
//			String AssemblylineID = param.get("productionLineID").toString();
//			if (StringUtils.isEmpty(AssemblylineID)) {
//				// 取得流程列表
//				List<Assemblyline> listAssemblyline = b04s003Business.getAssemblyline(IConstant.DEL_FLAG_0, langCode, langValue);
//				AssemblylineID = listAssemblyline.get(0).getAssemblyLineID();
//
//			}
//			// 取得流程工序中间表
//			List<Voplinkdown> listOplink = b04s003Business.getVoplink(AssemblylineID, IConstant.DEL_FLAG_0, langCode, langValue,1);
////			String ProcessID = listProcess.get(0).getProcessID();
//			super.assign("listOplink", listOplink);
//			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );
//
//			return null;
//		} catch (BusinessException ex) {
//			ApplicationException.setApplicationException(getResponse(),
//					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
//					this.getClass().getName(), "changeDepartment",
//					((Customer) super.session("Customer")).getCustomerID());
//			return null;
//		}
//	}
//	public String prossAndBuss1() {
//		try {
//			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
//			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
//			// 根据用户选择的机构ID，取得 相应的部门及职务列表
//			Map<String, Object> param = super.param();
//			String ProcedureID = param.get("procedureID").toString();
//			if (StringUtils.isEmpty(ProcedureID)) {
//				// 取得工序
//				List<com.icomp.entity.base.Process> listProcess = b04s003Business.getProcess(IConstant.DEL_FLAG_0, langCode, langValue);
//				ProcedureID = listProcess.get(0).getProcessID();
//
//			}
//			// 取得流程工序中间表
//			List<Voplinkdown> listOplink = b04s003Business.getVoplink(ProcedureID, IConstant.DEL_FLAG_0, langCode, langValue,2);
////			String ProcessID = listProcess.get(0).getProcessID();
//			super.assign("listOplink", listOplink);
//			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );
//
//			return null;
//		} catch (BusinessException ex) {
//			ApplicationException.setApplicationException(getResponse(),
//					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
//					this.getClass().getName(), "changeDepartment",
//					((Customer) super.session("Customer")).getCustomerID());
//			return null;
//		}
//	}
//	public String prossAndBuss2() {
//		try {
//			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
//			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
//			// 根据用户选择的机构ID，取得 相应的部门及职务列表
//			Map<String, Object> param = super.param();
//			String EquipmentID = param.get("equipmentID").toString();
//			if (StringUtils.isEmpty(EquipmentID)) {
//				// 取得设备
//				List<Equipment> listEquipment = b04s003Business.getEquipment(IConstant.DEL_FLAG_0, langCode, langValue);
//				EquipmentID = listEquipment.get(0).getEquipmentID();
//
//			}
//			// 取得流程工序中间表
//			List<Voplinkdown> listOplink = b04s003Business.getVoplink(EquipmentID, IConstant.DEL_FLAG_0, langCode, langValue,3);
////			String ProcessID = listProcess.get(0).getProcessID();
//			super.assign("listOplink", listOplink);
//			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );
//
//			return null;
//		} catch (BusinessException ex) {
//			ApplicationException.setApplicationException(getResponse(),
//					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
//					this.getClass().getName(), "changeDepartment",
//					((Customer) super.session("Customer")).getCustomerID());
//			return null;
//		}
//	}
//	public String prossAndBuss3() {
//		try {
//			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
//			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
//			// 根据用户选择的机构ID，取得 相应的部门及职务列表
//			Map<String, Object> param = super.param();
//			String AxleID = param.get("axleID").toString();
//			if (StringUtils.isEmpty(AxleID)) {
//				// 取得设备
//				List<Axle> listAxle = b04s003Business.getAxle(IConstant.DEL_FLAG_0, langCode, langValue);
//				AxleID = listAxle.get(0).getAxleID();
//
//			}
//			// 取得流程工序中间表
//			List<Voplinkdown> listOplink = b04s003Business.getVoplink(AxleID, IConstant.DEL_FLAG_0, langCode, langValue, 4);
////			String ProcessID = listProcess.get(0).getProcessID();
//			super.assign("listOplink", listOplink);
//			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode() == null ? 0 : -2, null);
//
//			return null;
//		} catch (BusinessException ex) {
//			ApplicationException.setApplicationException(getResponse(),
//					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
//					this.getClass().getName(), "changeDepartment",
//					((Customer) super.session("Customer")).getCustomerID());
//			return null;
//		}
//	}
}
