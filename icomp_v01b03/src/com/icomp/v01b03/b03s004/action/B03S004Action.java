package com.icomp.v01b03.b03s004.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b03.b03s004.business.B03S004Business;

/**
 * 刃磨工作量汇总Action
 * 
 * @ClassName: B03S004Action
 * @author Taoyy
 * @date 2014-8-12 下午04:16:08
 */
public class B03S004Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 刃磨工作量汇总BUSINESS
	 */
	private B03S004Business b03s004Business;
	public void setB03s004Business(B03S004Business b03s004Business) {
		this.b03s004Business = b03s004Business;
	}

	/**
	 * 刃磨工作量汇总页面初始化
	 * 
	 * @title initb03S004
	 * @return String
	 */
	public String initb03S004() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//刃磨工作量汇总列表
				Map<String, Object> list = this.b03s004Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b03s004Business.getGridColmun(
					"B03S004", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B03S004.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B03S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

}
