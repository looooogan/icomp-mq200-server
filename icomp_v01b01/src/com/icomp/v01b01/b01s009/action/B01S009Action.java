package com.icomp.v01b01.b01s009.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s009.business.B01S009Business;
/**
 * 质检记录查询ACTION
 * @ClassName: B01S009Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:19:52
 */
public class B01S009Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 质检记录查询BUSINESS
	 */
	private B01S009Business b01s009Business;
	public void setB01s009Business(B01S009Business b01s009Business) {
		this.b01s009Business = b01s009Business;
	}
	/**
	 * 页面初始化
	 * @title initb01S009 
	 * @return
	 * String
	 */
	public String initb01S009(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 质检记录查询列表
				Map<String, Object> list = this.b01s009Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b01s009Business.getGridColmun(
					"B01S009", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S009.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S009", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
