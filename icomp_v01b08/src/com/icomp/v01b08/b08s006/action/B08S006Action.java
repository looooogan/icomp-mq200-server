package com.icomp.v01b08.b08s006.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s006.business.B08S006Business;

public class B08S006Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 手持机配置Business
	 */
	private B08S006Business business;

	public void setBusiness(B08S006Business business) {
		this.business = business;
	}

	/**
	 * 手持机配置初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S006() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			Map<String, Object> param = super.param();

			// 当点击查询按钮，根据页面的检索条件，取得对应数据
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值
				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;

				// 当点击查询以外时，取得下拉列表的值
			} else {
				// 下拉列表值取得
				super.assign("HandSetStautsList", business.getComList(
						IConstant.HAND_SET_STAUTS, langCode, langValue)); // 手持机状态
				super.assign("IsRegistrationList", business.getComList(
						IConstant.ISREGISTRATION, langCode, langValue)); // 是否注册
				super.assign("LoginStautsList", business.getComList(
						IConstant.LOGIN_STAUTS, langCode, langValue)); // 登录状态
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				// 获取部门列表
				super.assign("VdepartmentList", business.getVdepartment(
						IConstant.DEL_FLAG_0,langCode, langValue));
				super.assign("LanguageCodeList", langList); // 语言列表
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun(
						"B08S006", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S006.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S006", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除手持机配置信息
	 * 
	 * @return
	 */
	public String handSetDelete() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			Map<String, Object> param = super.param();
			// 删除手持机
			Map<String, Object> ret = this.business.handSetDelete(param,
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
					"handSetDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/handSetDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "handSetDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建手持机配置信息
	 * 
	 * @return
	 */
	public String handSetAdd() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			Map<String, Object> param = super.param();
			// 新建手持机
			Map<String, Object> ret = this.business.handSetAdd(param,
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
					"handSetAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/handSetAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "handSetAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得待处理手持机信息
	 * 
	 * @return
	 */
	public String handSetInfo() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			Map<String, Object> param = super.param();
			// 取得待处理手持机信息
			Map<String, Object> ret = this.business.handSetInfo(param,
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/handSetInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "handSetInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑手持机信息
	 * 
	 * @return
	 */
	public String handSetEdit() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			Map<String, Object> param = super.param();
			// 编辑手持机信息
			Map<String, Object> ret = this.business.handSetEdit(param,
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
					"handSetEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/handSetEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "handSetEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

}
