package com.icomp.v01b07.b07s007.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b07.b07s007.business.B07S007Business;

/**
 * 标签采购Action
 * 
 * @ClassName: B07S007Action
 * @author Licc
 * @date 2014-8-21 下午04:16:08
 */
public class B07S007Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 标签采购BUSINESS
	 */
	private B07S007Business b07s007Business;
	
	public void setB07s007Business(B07S007Business b07s007Business) {
		this.b07s007Business = b07s007Business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb07S007
	 * @return String
	 */
	public String initb07S007() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//标签采购列表
				Map<String, Object> list = this.b07s007Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b07s007Business.getGridColmun(
						"B07S007", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B07S007.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B07S007", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

}
