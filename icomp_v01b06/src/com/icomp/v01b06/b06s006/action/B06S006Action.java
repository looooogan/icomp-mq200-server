package com.icomp.v01b06.b06s006.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s006.business.B06S006Business;

/**
 *  定额执行情况分析Action
 * @ClassName: B06S006Action 
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S006Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 定额执行情况分析BUSINESS
	 */
	private B06S006Business b06s006Business;
	public void setB06s006Business(B06S006Business b06s006Business) {
		this.b06s006Business = b06s006Business;
	}

	/**
	 * 初始化定额执行情况分析页面
	 * @title initb01S006 
	 * @return
	 * String
	 */
	public String initb06S006(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 定额执行情况分析列表
				Map<String, Object> list = this.b06s006Business.getList(param,langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b06s006Business.getGridColmun(
						"B06S006", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B06S006.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 定额执行情况分析统计
	 * @title statistics_b06S002 
	 * @return
	 * String
	 */
	public String statistics_b06S006(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			// 加工异常分析数量
			super.ajaxReturn(b06s006Business.getStatisticalCount(param,langCode, langValue));
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/statistics_b06S002", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S006", ((Customer) super.session("Customer")).getCustomerID());
			return NONE;
		}
	}
	
}
