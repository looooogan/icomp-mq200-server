package com.icomp.v01b06.b06s004.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s004.business.B06S004Business;

/**
 *  刀具供应商分析Action
 * @ClassName: B06S004Action 
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S004Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 刀具供应商分析BUSINESS
	 */
	private B06S004Business b06s004Business;
	public void setB06s004Business(B06S004Business b06s004Business) {
		this.b06s004Business = b06s004Business;
	}

	/**
	 * 初始化刀具供应商分析页面
	 * @title initb01S004 
	 * @return
	 * String
	 */
	public String initb06S004(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 刀具供应商分析列表
				Map<String, Object> list = this.b06s004Business.getList(param,langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b06s004Business.getGridColmun(
						"B06S004", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B06S004.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S004", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	/**
	 * 刀具供应商分析统计
	 * @title statistics_b06S002 
	 * @return
	 * String
	 */
	public String statistics_b06S004(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			// 刀具供应商分析统计数量
			super.ajaxReturn(b06s004Business.getStatisticalCount(param, langCode,langValue));
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/statistics_b06S004", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S004", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
}
