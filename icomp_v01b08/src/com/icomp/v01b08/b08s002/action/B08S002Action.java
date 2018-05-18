package com.icomp.v01b08.b08s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s002.business.B08S002Business;

import java.util.Map;

public class B08S002Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 内置编码配置Business
	 */
	private B08S002Business business;

	public void setBusiness(B08S002Business business) {
		this.business = business;
	}

	/**
	 * 内置编码配置初始化Action
	 * @return
	 */
	public String initb08S002() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值

				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);

			}else {
				super.session("gridcol", business.getGridColmun(
						"B07S002", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S002.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S002", ((Customer) super
							.session("Customer")).getCustomerID());

			return null;
		}
		return null;
	}

	/**
	 * 删除内置编码配置信息
	 * @return
	 */
	public String libraryCodeDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//删除内置编码
			Map<String, Object> ret = this.business.libraryCodeDelete(param,
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
					"libraryCodeDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/libraryCodeDelete.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "libraryCodeDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得内置编码信息
	 * @return
	 */
	public String libraryCodeInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//取得内置编码信息
			Map<String, Object> ret = this.business.librarycodeInfo(param,
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/librarycodeInfo.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "librarycodeInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑内置编码信息
	 * @return
	 */
	public String libraryCodeEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//编辑内置编码信息
			Map<String, Object> ret = this.business.librarycodeEdit(param,
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
					"librarycodeEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/librarycodeEdit.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "librarycodeEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	public  String onOffch(){
		try{
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();

			Map<String,Object> param = super.param();
			Map<String, Object> ret = this.business.onOff(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);

			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/waningSsp.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "waningSsp",((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
		return null;
	}

}