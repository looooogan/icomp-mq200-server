package com.icomp.v01b12.b12s001.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflow;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b12.b12s001.business.B12S001Business;

public class B12S001Action extends IcompAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作流程管理Business
	 */
	private B12S001Business b12S001Business;

	public void setB12S001Business(B12S001Business b12s001Business) {
		b12S001Business = b12s001Business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb12S001
	 * @return String
	 */
	public String initb12S001() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			Map<String, Object> list = new HashMap<String, Object>();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值
				list = this.b12S001Business.getList(param, langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}
				// 取得流程列表
				List<Businessflow> listBusinessFlow = b12S001Business
						.getBusinessFlowList(IConstant.DEL_FLAG_0, langCode,
								langValue);
				super.assign("BusinessFlowList", listBusinessFlow);
				// 取得业务名列表
				List<Business> listBusiness = b12S001Business.getBusinessList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				super.assign("listBusiness", listBusiness);
				// 取得功能名列表
				List<Capability> listCapability = b12S001Business.getCapabilityList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				super.assign("listCapability", listCapability);
				
				// 取得页面grid显示项目列表
				super.session("gridcol", b12S001Business.getGridColmun(
						"B12S001", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B12S001.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B12S001", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}


	/**
	 * 新建流程
	 * 
	 * @return
	 */
	public String businessAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b12S001Business.businessAdd(
					param, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode, langValue);
			// 取得流程列表
			List<Businessflow> listBusinessFlow = b12S001Business
					.getBusinessFlowList(IConstant.DEL_FLAG_0, langCode,
							langValue);
			ret.put("data", listBusinessFlow);
			
			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(listBusinessFlow, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"businessAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/businessAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "businessAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除流程
	 */
	public String businessDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b12S001Business.businessDelete(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode, langValue);
			// 取得流程列表
			List<Businessflow> listBusinessFlow = b12S001Business
					.getBusinessFlowList(IConstant.DEL_FLAG_0, langCode,
							langValue);
			ret.put("data", listBusinessFlow);
			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(listBusinessFlow, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录编辑成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"businessDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/businessDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "businessEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 编辑流程
	 */
	public String businessEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b12S001Business.businessEdit(param,
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
					"businessEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/businessEdit.action", IConstant.RESULT_CODE_1, ex, this
					.getClass().getName(), "businessEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得流程信息
	 * @return
	 */
	public String businessInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b12S001Business.businessInfo(param,
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/businessInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "businessInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	

}
