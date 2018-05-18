package com.icomp.v01b08.b08s005.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s005.business.B08S005Business;

public class B08S005Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 系统码表配置Business
	 */
	private B08S005Business business;

	public void setBusiness(B08S005Business business) {
		this.business = business;
	}

	/**
	 * 系统码表配置初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S005() {
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
				super.assign("EditFlagList", business.getComList(
						IConstant.EDIT_FLAG, langCode, langValue)); // 是否可以修改
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				super.assign("LanguageCodeList", langList); // 语言列表
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun(
						"B08S005", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S005.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S005", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除系统码表配置信息
	 * 
	 * @return
	 */
	public String comlistDelete() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.comlistDelete(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);
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
					"comlistDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/comlistDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "comlistDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建系统码表配置信息
	 * 
	 * @return
	 */
	public String comlistAdd() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.comlistAdd(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);

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
					"comlistAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/comlistAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "comlistAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得系统码表信息
	 * 
	 * @return
	 */
	public String comlistInfo() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.comlistInfo(param,
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/comlistInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "comlistInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑系统码表信息
	 * 
	 * @return
	 */
	public String comlistEdit() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.comlistEdit(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);
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
					"comlistEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/comlistEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "comlistEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
