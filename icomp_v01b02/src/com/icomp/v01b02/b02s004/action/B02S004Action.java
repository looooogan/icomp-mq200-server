package com.icomp.v01b02.b02s004.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b02.b02s004.business.B02S004Business;

public class B02S004Action extends IcompAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 对刀记录查询Business
	 */
	private B02S004Business b02s004Business;
	public void setB02s004Business(B02S004Business b02s004Business) {
		this.b02s004Business = b02s004Business;
	}



	/**
	 * 对刀记录查询初始化Action
	 * 
	 * @return
	 */
	public String initb02S004() {
		
		try {
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
			// 设置页面初始化值
			//对刀记录查询列表
			Map<String, Object> list = this.b02s004Business.getList(param,langCode,langValue);
			super.ajaxReturn(list);
			return null;
			} else {
				// 取得页面grid显示项目列表
				super.session("gridcol", b02s004Business.getGridColmun(
						"B02S004", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B02S004.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B02S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
