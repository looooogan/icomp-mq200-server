package com.icomp.v01b01.b01s011.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s011.business.B01S011Business;
/**
 * 在途计划报警Action
 * @ClassName: B01S011Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:18:18
 */
public class B01S011Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 在途计划报警查询BUSINESS
	 */
	private B01S011Business b01s011Business;
	public void setB01s011Business(B01S011Business b01s011Business) {
		this.b01s011Business = b01s011Business;
	}
	/**
	 * 页面初始化
	 * @title initb01S011
	 * @return
	 * String
	 */
	public String initb01S011(){
			try {
				// 语言实体类
				String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
				String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
				//参数
				Map<String, Object> param = super.param();
				if ("list".equals(param.get("opt"))) {
					// 在途计划报警查询列表
					Map<String, Object> list = this.b01s011Business.getList(param,langCode,langValue);
					super.ajaxReturn(list);
					return null;
				}
				// 取得页面grid显示项目列表
				super.session("gridcol", b01s011Business.getGridColmun(
						"B01S011", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			} catch (BusinessException ex) {
				ApplicationException.setApplicationException(getResponse(),
						"/B01S011.action", IConstant.RESULT_CODE_1, ex,
						this.getClass().getName(), "B01S011", ((Customer) super.session("Customer")).getCustomerID());
				return null;
			}
	}
}
