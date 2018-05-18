package com.icomp.v01b11.b11s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vdepartment;
import com.icomp.v01b11.b11s002.business.B11S002Business;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 部门管理Action
 * 
 * @ClassName: B11S002Action
 * @author Licc
 * @date 2014-8-21 下午04:13:27
 */
public class B11S002Action extends IcompAction {

	private static final long serialVersionUID = 1L;
	/**
	 * 部门管理Business
	 */
	private B11S002Business business;

	public void setBusiness(B11S002Business business) {
		this.business = business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb11S002
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String initb11S002() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值

				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {
				super.assign("DelFlag",IConstant.DEL_FLAG_0); // 删除区分-检索初始值
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode,langValue)); // 删除区分
				// 语言列表
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				super.assign("LanguageCodeList", langList);
				// 设置页面初始化值
				super.assign("AgencyID", "");
				super.assign("DepartmentID", "");
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
				super.session("gridcol", business.getGridColmun("B11S002", ((Customer) super.session("Customer")).getCustomerID(),langCode,  langValue));
				
				return SUCCESS;
			}

		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B11S002.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B11S002", ((Customer) super
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
			String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();
			String AgencyID = param.get("AgencyID").toString();
			if (StringUtils.isEmpty(AgencyID)) {
				// 取得机构列表
				List<Vagency> listAgency = business.getAgencyList(
						IConstant.DEL_FLAG_0, langCode,langValue);
				AgencyID = listAgency.get(0).getAgencyID();
			}
			// 取得部门列表
			List<Vdepartment> listDepartment = business.getDepartmentList(
					AgencyID, IConstant.DEL_FLAG_0, langCode,langValue);
			super.assign("DepartmentList", listDepartment);
			super.ajaxReturn(listDepartment, null, listDepartment.get(0).getMessageCode()==null?0:-2, null);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/changeAgency.action",
					IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
					"changeAgency", ((Customer) super.session("Customer"))
							.getCustomerID());
			return null;
		}
	}

	/**
	 * 删除部门信息
	 * 
	 * @return
	 */
	public String departmentDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.departmentDelete(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode, langValue);
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
					"departmentDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/departmentDelete.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "departmentDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建部门信息
	 * 
	 * @return
	 */
	public String departmentAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.departmentAdd(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode, langValue);

			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"departmentAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/departmentAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "departmentAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得部门信息
	 * 
	 * @return
	 */
	public String departmentInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.departmentInfo(param,
					 langCode,  langValue) ;
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/departmentInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "departmentInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑部门信息
	 * 
	 * @return
	 */
	public String departmentEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.departmentEdit(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode, langValue);
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
					"departmentEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/departmentEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "departmentEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

}
