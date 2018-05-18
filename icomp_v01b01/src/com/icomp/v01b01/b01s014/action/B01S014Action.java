package com.icomp.v01b01.b01s014.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s014.business.B01S014Business;

/**
 * 库存盘点查询Action
 * @ClassName: B01S013Action 
 * @author Licc
 * @date 2014-11-10 下午02:31:34
 */
public class B01S014Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 库存盘点查询BUSINESS
	 */
	private B01S014Business b01s014Business;
	
	public void setB01s014Business(B01S014Business b01s014Business) {
		this.b01s014Business = b01s014Business;
	}

	/**
	 * 库存盘点查询页面
	 * @title initb01S014 
	 * @return
	 * String
	 */
	public String initb01S014(){
		try {
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 库存盘点查询列表
				Map<String, Object> list = this.b01s014Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else {
				// 取得页面grid显示项目列表
				super.session("gridcol", b01s014Business.getGridColmun(
						"B01S014", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S014.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S014", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	
}
