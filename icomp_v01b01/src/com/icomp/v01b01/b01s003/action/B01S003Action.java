package com.icomp.v01b01.b01s003.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s003.business.B01S003Business;

/**
 * 待处理刀具信息查询
 * @ClassName: B01S003Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:15:17
 */
public class B01S003Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;

	/**
	 * 待处理刀具信息查询BUSINESS
	 */
	private B01S003Business b01s003Business;
	
	public void setB01s003Business(B01S003Business b01s003Business) {
		this.b01s003Business = b01s003Business;
	}

	/**
	 * 初始化待处理刀具信息查询页面
	 * @title initb01S003 
	 * @return
	 * String
	 */
	public String initb01S003(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 待处理刀具信息查询列表
				Map<String, Object> list = this.b01s003Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}

			// 取得页面grid显示项目列表
			super.session("gridcol", b01s003Business.getGridColmun(
					"B01S003", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S003.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S003", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
