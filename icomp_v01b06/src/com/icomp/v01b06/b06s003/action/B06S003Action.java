package com.icomp.v01b06.b06s003.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s003.business.B06S003Business;

/**
 * 建议采购计划Action
 * 
 * @ClassName: B06S003Action
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S003Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 建议采购计划BUSINESS
	 */
	private B06S003Business b06s003Business;

	public void setB06s003Business(B06S003Business b06s003Business) {
		this.b06s003Business = b06s003Business;
	}

	/**
	 * 初始化建议采购计划页面
	 * 
	 * @title initb01S003
	 * @return String
	 */
	public String initb06S003() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 建议采购计划列表
				Map<String, Object> list = this.b06s003Business.getList(param,langCode, langValue);
				super.ajaxReturn(list);
				return NONE;
			} else {
				
				// 取得页面grid显示项目列表
				super.session("gridcol", b06s003Business.getGridColmun("B06S003", langCode, ((Customer) super.session("Customer")).getCustomerID(), langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B06S003.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S003", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 保存建议采购计划
	 * 
	 * @title b06S003Save
	 * @return String
	 */
	public String b06S003Save() {
		try{
			
			//语言编码
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			//参数
			Map<String, Object> param = super.param();
			//用户ID
			String customer =  ((Customer) super.session("Customer")).getCustomerID();
			
			// 保存建议采购计划		
			Map<String, Object> ret  =b06s003Business.saveAll(param, langCode,  customer, langValue);
			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "b06S003Save", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
			return NONE;
	} catch (BusinessException ex) {
		ApplicationException.setApplicationException(getResponse(), "/b06S003Save.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "roleAdd", ((Customer) super.session("Customer")).getCustomerID());
		return NONE;
	}
	}

}
