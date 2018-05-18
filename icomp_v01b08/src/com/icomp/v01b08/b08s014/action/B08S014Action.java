package com.icomp.v01b08.b08s014.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s014.business.B08S014Business;

public class B08S014Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工序配置Business
	 */
	private B08S014Business business;

	public void setBusiness(B08S014Business business) {
		this.business = business;
	}

	/**
	 * 库房货架配置初始化Action
	 * 
	 * @return
	 */
	public String initb08S014() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun("B08S014",
						 ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,langValue));
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S014.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S014", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}

	}


	

	/**
	 * 新建用户信息
	 * 
	 * @return
	 */
	public String toolshelfAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.toolshelfAdd(param,
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
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"toolshelfAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/toolshelfAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "toolshelfAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 */
	public String toolshelfDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.toolshelfDelete(param,
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
					"toolshelfDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/toolshelfDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "toolshelfDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
