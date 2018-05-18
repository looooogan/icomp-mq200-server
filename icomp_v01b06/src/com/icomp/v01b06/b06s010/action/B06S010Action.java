package com.icomp.v01b06.b06s010.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s010.business.B06S010Business;

/**
 * 刀具报废Action
 * 
 * @ClassName: B06S010Action
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S010Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 成本摊销BUSINESS
	 */
	private B06S010Business b06s010Business;

	public void setB06s010Business(B06S010Business b06s010Business) {
		this.b06s010Business = b06s010Business;
	}

	/**
	 * 初始化页面
	 * 
	 * @title initb01S010
	 * @return String
	 */
	public String initb06S010() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 成本摊销列表
				Map<String, Object> list = this.b06s010Business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {
				// 初始化消耗类别
				super.assign("ToolConsumetype","");
				super.assign("ToolConsumeTypeList", b06s010Business.getComList(
						IConstant.TOOL_CONSUME_TYPE, langCode,langValue));
				// 取得页面grid显示项目列表
				super.session("gridcol", b06s010Business.getGridColmun(
						"B06S010", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode, langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B06S010.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B06S010", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	public String b06S010Save(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			Map<String, Object> list = this.b06s010Business.b06s010Save(param,
					langCode, langValue);
			super.ajaxReturn(list);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/b06S010Save.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "b06S010Save", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
