package com.icomp.v01b08.b08s003.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s003.business.B08S003Business;

public class B08S003Action extends IcompAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 国际化需求配置Business
	 */
	private B08S003Business business;

	public void setBusiness(B08S003Business business) {
		this.business = business;
	}

	/**
	 * 国际化需求初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S003() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//当点击查询时
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值

				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				super.assign("LanguageCodeList", langList);        // 语言列表
				// 设置页面初始化值
				super.assign("LanguageCode", "");     // 语言编码
				super.assign("DIVLanguageCode", "");  // 语言编码
				super.assign("DIVLanguageValue", ""); // 语言值
				super.assign("DIVLanguageName", "");  // 语言
				super.assign("DIVDelFlag", "");       // 删除区分
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun(
						"B08S003", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S003.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S003", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

//	/**
//	 * 删除国际化需求配置信息
//	 * 
//	 * @return
//	 */
//	public String languageTableDelete() {
//		try {
//			String langCode = ((Languagetable) super.session("Languagetable"))
//					.getLanguageCode();          //语言编码
//			String langValue = ((Languagetable) super.session("Languagetable"))
//					.getLanguageValue();         //语言值
//			Map<String, Object> param = super.param();
//			//删除国际化需求配置
//			Map<String, Object> ret = this.business.languageTableDelete(param,
//					langValue, ((Customer) super.session("Customer"))
//							.getCustomerID(), langCode);
//			if (ret.get("message") != null
//					&& !"-2".equals(ret.get("status").toString())) {
//				super.ajaxReturn(null, null, ret.get("message"), Integer
//						.parseInt(ret.get("status").toString()));
//				return null;
//			} else {
//				super.ajaxReturn(ret);
//			}
//			// 记录删除成功日志
//			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
//					"languageTableDelete", IConstant.SYSTEM_LOG_FLAG_1,
//					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
//							.session("Customer")).getCustomerID(), ret.get(
//							"message").toString());
//			return null;
//		} catch (BusinessException ex) {
//			ApplicationException.setApplicationException(getResponse(),
//					"/languageTableDelete.action", IConstant.RESULT_CODE_1, ex,
//					this.getClass().getName(), "languageTableDelete",
//					((Customer) super.session("Customer")).getCustomerID());
//			return null;
//		}
//	}

	/**
	 * 新建国际化需求配置信息
	 * 
	 * @return
	 */
	public String languageTableAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//新建国际化需求配置
			Map<String, Object> ret = this.business.languageAdd(param,
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
					"languageTableAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/languageTableAdd.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "languageTableAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得待处理语言信息
	 * 
	 * @return
	 */
	public String languageTableInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//取得待处理语言
			Map<String, Object> ret = this.business.languageInfo(param,
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/languageInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "languageInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑语言信息
	 * 
	 * @return
	 */
	public String languageTableEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//编辑语言
			Map<String, Object> ret = this.business.languageEdit(param,
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
					"languageEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/languageEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "languageEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 启用语言信息
	 * 
	 * @return
	 */
	public String languageStartUse() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//启用语言
			Map<String, Object> ret = this.business.languageStartUse(param,
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
			// 记录启用成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"languageStartUse", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/languageStartUse.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "languageStartUse",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
