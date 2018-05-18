package com.icomp.v01b08.b08s004.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Toolalarmparam;
import com.icomp.v01b08.b08s004.business.B08S004Business;

public class B08S004Action extends IcompAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 功能管理Business
	 */
	private B08S004Business business;

	public void setBusiness(B08S004Business business) {
		this.business = business;
	}

	/**
	 * 刀具告警配置初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S004() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//取得待处理刀具告警配置
			Map<String, Object> ret = this.business.toolAlarmInfo(param,
					langCode, langValue);
			super.assign("ToolAlarmList",(List<Toolalarmparam>)ret.get("data"));
			// 取得页面grid显示项目列表
			super.session("gridcol", business.getGridColmun(
					"B08S004", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S004.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}


	/**
	 * 编辑刀具告警配置
	 * 
	 * @return
	 */
	public String toolAlarmEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();          //语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();         //语言值
			Map<String, Object> param = super.param();
			//编辑刀具告警配置
			Map<String, Object> ret = this.business.toolAlarmEdit(param,
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

	
	
	
}
