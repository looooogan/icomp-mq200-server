package com.icomp.v01b01.b01s008.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s008.business.B01S008Business;
/**
 * 采购计划查询
 * @ClassName: B01S008Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:20:16
 */
public class B01S008Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 采购计划查询BUSINESS
	 */
	private B01S008Business b01s008Business;
	public void setB01s008Business(B01S008Business b01s008Business) {
		this.b01s008Business = b01s008Business;
	}
	/**
	 * 页面初始化
	 * @title initb01S008 
	 * @return
	 * String
	 */
	public String initb01S008(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 采购计划查询列表
				Map<String, Object> list = this.b01s008Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b01s008Business.getGridColmun(
					"B01S008", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S008.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S008", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
