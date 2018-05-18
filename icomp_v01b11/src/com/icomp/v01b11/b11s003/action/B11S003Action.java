package com.icomp.v01b11.b11s003.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.v01b11.b11s003.business.B11S003Business;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class B11S003Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户管理Business
	 */
	private B11S003Business business;

	public void setBusiness(B11S003Business business) {
		this.business = business;
	}

	/**
	 * 用户管理初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb11S003() {
		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值

				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode,langValue)); // 删除区分
				// 语言列表
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				super.assign("LanguageCodeList", langList);
				// 设置页面初始化值
				super.assign("AgencyID", "");
				super.assign("DepartmentID", "");
				super.assign("DelFlag",IConstant.DEL_FLAG_0); // 删除区分-检索初始值
				super.assign("PositionID", "");
				super.assign("DIV_DelFlag", "");
				super.assign("DIV_LanguageCode", "");
				super.assign("DIV_AgencyID", "");
				super.assign("DIV_DepartmentID", "");

				// 取得机构列表
				List<Vagency> listAgency = business.getAgencyList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				super.assign("AgencyList", listAgency);
				// 取得部门列表
				List<Vdepartment> listDepartment = business.getDepartmentList(
						listAgency.get(0).getAgencyID(), IConstant.DEL_FLAG_0,
						langCode, langValue);
				super.assign("DepartmentList", listDepartment);
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun("B11S003",
						 ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B11S004.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B11S004", ((Customer) super
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
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String AgencyID = param.get("AgencyID").toString();
			if (StringUtils.isEmpty(AgencyID)) {
				// 取得机构列表
				List<Vagency> listAgency = business.getAgencyList(IConstant.DEL_FLAG_0, langCode,langValue);
				AgencyID = listAgency.get(0).getAgencyID();
			}
			// 取得部门列表
			List<Vdepartment> listDepartment = business.getDepartmentList(AgencyID, IConstant.DEL_FLAG_0, langCode,langValue);
			super.assign("DepartmentList", listDepartment);

			super.ajaxReturn(listDepartment, null, listDepartment.get(0).getMessageCode()==null?0:-2, null);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeAgency.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "changeAgency",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑用户信息
	 * 
	 * @return
	 */
	public String roleEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.roleEdit(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode,langValue);

			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录编辑成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"roleEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/roleEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "roleEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建用户信息
	 * 
	 * @return
	 */
	public String roleAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.roleAdd(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode,langValue);

			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"roleAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/roleAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "roleAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 */
	public String roleDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.roleDelete(param,
					((Customer) super.session("Customer"))
							.getCustomerID(), langCode,langValue);
			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录删除成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"roleDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/userDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "roleDelete",
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
				List<Vagency> listAgency = business.getAgencyList(IConstant.DEL_FLAG_0, langCode,langValue);
				String AgencyID = listAgency.get(0).getAgencyID();
				// 取得部门列表
				List<Vdepartment> listDepartment = business.getDepartmentList(AgencyID, IConstant.DEL_FLAG_0, langCode,langValue);
				DepartmentID = listDepartment.get(0).getDepartmentID();
			}
			// 取得职务列表
			List<Vposition> positionList= business.getPositionList(param, IConstant.DEL_FLAG_0, langCode,langValue);
			super.ajaxReturn(positionList, null, positionList.get(0).getMessageCode()==null?0:-2, null);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeDepartment",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得用户信息
	 * 
	 * @return
	 */
	public String roleInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.roleInfo(param, langCode,langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/roleInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "roleInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
