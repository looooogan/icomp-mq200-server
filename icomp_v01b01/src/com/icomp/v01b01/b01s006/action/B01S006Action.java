package com.icomp.v01b01.b01s006.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Merchants;
import com.icomp.v01b01.b01s002.business.B01S002Business;
import com.icomp.v01b01.b01s006.business.B01S006Business;
/**
 * 更替刀具库存查询
 * @ClassName: B01S006Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:21:35
 */
public class B01S006Action extends IcompAction {

	/** 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 更替刀具库存查询BUSINESS
	 */
	private B01S006Business b01s006Business;
	public void setB01s006Business(B01S006Business b01s006Business) {
		this.b01s006Business = b01s006Business;
	}


	/**
	 * 页面初始化
	 * @title initb01S006
	 * @return
	 * String
	 */
	public String initb01S006(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//更替刀具库存列表
				Map<String, Object> list = this.b01s006Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b01s006Business.getGridColmun(
					"B01S006", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
