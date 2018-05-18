package com.icomp.v01b01.b01s010.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s010.business.B01S010Business;
/**
 * 库存信息快速查询Action
 * @ClassName: B01S010Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:18:51
 */
public class B01S010Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 库存信息快速查询BUSINESS
	 */
	private B01S010Business b01s010Business;
	public void setB01s010Business(B01S010Business b01s010Business) {
		this.b01s010Business = b01s010Business;
	}
	/**
	 * 页面初始化
	 * @title initb01S010
	 * @return
	 * String
	 */
	public String initb01S010(){
			try {
				// 语言实体类
				String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
				String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
				//参数
				Map<String, Object> param = super.param();
				if ("list".equals(param.get("opt"))) {
					// 库存信息快速查询列表
					Map<String, Object> list = this.b01s010Business.getList(param,langCode,langValue);
					super.ajaxReturn(list);
					return null;
				}
				// 取得页面grid显示项目列表
				super.session("gridcol", b01s010Business.getGridColmun(
						"B01S010", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			} catch (BusinessException ex) {
				ApplicationException.setApplicationException(getResponse(),
						"/B01S010.action", IConstant.RESULT_CODE_1, ex,
						this.getClass().getName(), "B01S010", ((Customer) super.session("Customer")).getCustomerID());
				return null;
			}
	}
}
