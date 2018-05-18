package com.icomp.v01b02.b02s005.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b02.b02s005.business.B02S005Business;

public class B02S005Action extends IcompAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 对刀工作量汇总Business
	 */
	private B02S005Business b02s005Business;

	public void setB02s005Business(B02S005Business b02s005Business) {
		this.b02s005Business = b02s005Business;
	}

	/**
	 * 对刀工作量汇总初始化Action
	 * 
	 * @return
	 */
	public String initb02S005() {
		
		try {
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
			// 设置页面初始化值
			//对刀记录查询列表
			Map<String, Object> list = this.b02s005Business.getList(param,langCode,langValue);
			super.ajaxReturn(list);
			return null;
			} else {
				// 取得页面grid显示项目列表
				super.session("gridcol", b02s005Business.getGridColmun(
						"B02S005", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B02S005.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B02S005", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
