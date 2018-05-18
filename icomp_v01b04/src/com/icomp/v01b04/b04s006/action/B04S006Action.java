package com.icomp.v01b04.b04s006.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b04.b04s006.business.B04S006Business;

/**
 * 加工信息快速查询Action
 * 
 * @ClassName: B03S006Action
 * @author Taoyy
 * @date 2014-8-20 下午18:13:27
 */
public class B04S006Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 加工信息快速查询BUSINESS
	 */
	private B04S006Business b04s006Business;

	public void setB04s006Business(B04S006Business b04s006Business) {
		this.b04s006Business = b04s006Business;
	}




	/**
	 * 初始化加工信息快速查询页面
	 * @title initb01S006 
	 * @return
	 * String
	 */
	public String initb04S006(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 加工信息快速查询
				Map<String, Object> list = this.b04s006Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}

			// 取得页面grid显示项目列表
			super.session("gridcol", b04s006Business.getGridColmun(
					"B04S006", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S006", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	
}
