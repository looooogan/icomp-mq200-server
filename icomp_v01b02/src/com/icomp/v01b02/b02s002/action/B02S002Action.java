package com.icomp.v01b02.b02s002.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b02.b02s002.business.B02S002Business;

public class B02S002Action extends IcompAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 换领申请信息Business
	 */
	private B02S002Business business;

	public void setBusiness(B02S002Business business) {
		this.business = business;
	}

	/**
	 * 换领申请信息查询初始化Action
	 * 
	 * @return
	 */
	public String initb02S002() {
		
		try {
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值
			//换领申请信息列表
			Map<String, Object> list = this.business.getList(param,langCode,langValue);
			super.ajaxReturn(list);
			return null;
			} else {
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun(
						"B02S002", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B02S002.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B02S002", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

}
