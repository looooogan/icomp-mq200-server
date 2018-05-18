package com.icomp.v01b10.b10s003.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b10.b10s003.business.B10S003Business;

/**
 * 管理平台日志
 * @ClassName: B10S003Action 
 * @author Licc
 * @date 2014-8-12 下午04:15:17
 */
public class B10S003Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;

	/**
	 * 管理平台日志Business
	 */
	private B10S003Business b10s003Business;
	
	public void setB10s003Business(B10S003Business b10s003Business) {
		this.b10s003Business = b10s003Business;
	}

	/**
	 * 管理平台日志页面初始化
	 * @title initb10S003
	 * @return String
	 */
	public String initb10S003() {
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

			    // 管理平台日志列表
				Map<String, Object> list = this.b10s003Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			} else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b10s003Business.getGridColmun("B10S003", ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B10S003.action",
					IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
					"B10S003", ((Customer) super.session("Customer"))
							.getCustomerID());
			return null;
		}
	}
}
