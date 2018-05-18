package com.icomp.v01b11.b11s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.v01b11.b11s001.business.B11S001Business;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class B11S001Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 功能管理Business
	 */
	private B11S001Business business;

	public void setBusiness(B11S001Business business) {
		this.business = business;
	}

	/**
	 * 功能管理初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb11S001() {
		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();

			if ("get".equals(param.get("opt"))) {
				// 设置页面初始化值
				Map<String, Object> ret = this.business.getRoleGruanList(param,
						langCode, langValue);
				super.ajaxReturn(ret);
				return null;
			} else {

				// 初始化权限列表
				Map<String, Object> list = this.business.getCapTree(param,
						langCode, langValue);
				super.assign("GruanList", (List<Capability>) list.get("rows"));
				// 设置页面初始化值
				super.assign("AgencyID", "");
				super.assign("DepartmentID", "");
				super.assign("PositionID", "");
				// 取得机构列表
				List<Vagency> listAgency = business.getAgencyList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				super.assign("AgencyList", listAgency);
				// 取得部门列表
				List<Vdepartment> listDepartment = business.getDepartmentList(
						listAgency.get(0).getAgencyID(), IConstant.DEL_FLAG_0,
						langCode, langValue);
				super.assign("BelongFlagList", business.getComList(
						IConstant.BELONG_FLAG, langCode, langValue));
				super.assign("DepartmentList", listDepartment);
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B11S001.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B11S001", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 修改组织结构列表选择Action
	 * 
	 * @return
	 */
	public String changeAgency() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String AgencyID = param.get("AgencyID").toString();
			if (StringUtils.isEmpty(AgencyID)) {
				// 取得机构列表
				List<Vagency> listAgency = business.getAgencyList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				AgencyID = listAgency.get(0).getAgencyID();
			}
			// 取得部门列表
			List<Vdepartment> listDepartment = business.getDepartmentList(
					AgencyID, IConstant.DEL_FLAG_0, langCode, langValue);
			super.assign("DepartmentList", listDepartment);
			super.ajaxReturn(listDepartment, null, listDepartment.get(0).getMessageCode()==null?0:-2, null);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/selAgency.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "selAgency",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 权限保存Action
	 * 
	 * @return
	 */
	public String gruantSave() {
		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.saveGruant(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/saveGruant.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "gruantSave",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 修改组织结构列表选择Action
	 * 
	 * @return
	 */
	public String changeDepartment() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String DepartmentID = param.get("DepartmentID").toString();
			if (StringUtils.isEmpty(DepartmentID)) {
				// 取得机构列表
				List<Vagency> listAgency = business.getAgencyList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				;
				String AgencyID = listAgency.get(0).getAgencyID();
				// 取得部门列表
				List<Vdepartment> listDepartment = business.getDepartmentList(
						AgencyID, IConstant.DEL_FLAG_0, langCode, langValue);
				DepartmentID = listDepartment.get(0).getDepartmentID();
			}
			// 取得职务列表
			List<Vposition> positionList= business.getPositionList(param,
					IConstant.DEL_FLAG_0, langCode,langValue);
			super.ajaxReturn(positionList, null, positionList.get(0).getMessageCode()==null?0:-2, null);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/selDepartment.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "selDepartment",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

}
