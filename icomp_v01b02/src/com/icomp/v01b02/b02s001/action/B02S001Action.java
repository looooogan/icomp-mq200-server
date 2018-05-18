package com.icomp.v01b02.b02s001.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b02.b02s001.business.B02S001Business;

/**
 * 待处理刀具信息查询
 * @ClassName: B02S001Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:15:17
 */
public class B02S001Action extends IcompAction {

	private static final long serialVersionUID = 7255161566182210074L;

	/**
	 * 待处理刀具信息查询BUSINESS
	 */
	private B02S001Business b02s001Business;
	
	public void setB02s001Business(B02S001Business b02s001Business) {
		this.b02s001Business = b02s001Business;
	}

	/**
	 * 初始化待处理刀具信息查询页面
	 * @title initb02S001 
	 * @return
	 * String
	 */
	public String initb02S001(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 待处理刀具信息查询列表
				Map<String, Object> list = this.b02s001Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b02s001Business.getGridColmun(
					"B02S001", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B02S001.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B02S001", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
