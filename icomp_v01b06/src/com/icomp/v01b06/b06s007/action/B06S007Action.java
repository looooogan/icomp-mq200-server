package com.icomp.v01b06.b06s007.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s007.business.B06S007Business;

/**
 *  单品刀具分析Action
 * @ClassName: B06S007Action 
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S007Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 单品刀具分析BUSINESS
	 */
	private B06S007Business b06s007Business;
	public void setB06s007Business(B06S007Business b06s007Business) {
		this.b06s007Business = b06s007Business;
	}

	/**
	 * 初始化单品刀具分析页面
	 * @title initb01S007 
	 * @return
	 * String
	 */
	public String initb06S007(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 刀具消耗量分析列表
				Map<String, Object> list = this.b06s007Business.getList(param,langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}else {
				// 取得页面grid显示项目列表
				super.session("gridcol", b06s007Business.getGridColmun(
						"B06S007", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				super.assign("ToolConsumetypeList", b06s007Business.getComList(IConstant.TOOLCONSUME_TYPE,langCode, langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B06S007.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S007", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 单品刀具分析统计
	 * @title statistics_b06S002 
	 * @return
	 * String
	 */
	public String statistics_b06S007(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			// 单品刀具分析数量
			Map<String, Object> list = b06s007Business.getStatisticalCount(param,
					((Customer) super.session("Customer"))
					.getCustomerID(),langCode, langValue);
			super.ajaxReturn(list);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/statistics_b06S007", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S007", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
