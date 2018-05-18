package com.icomp.v01b03.b03s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b03.b03s002.business.B03S002Business;

import java.util.Map;

/**
 * 厂家修复商家Action
 * 
 * @ClassName: B03S006Action
 * @author Taoyy
 * @date 2014-8-12 下午04:13:27
 */
public class B03S006Action extends IcompAction {

	private static final long serialVersionUID = 1L;
	/**
	 * 修复通知单查询Business
	 */
	private B03S002Business b03s002Business;

	public void setB03s002Business(B03S002Business b03s002Business) {
		this.b03s002Business = b03s002Business;
	}




	/**
	 * 页面初始化
	 * @title initb03S006
	 * @return String
	 */
	public String initb03S006() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//  修复通知单查询列表
				Map<String, Object> list = this.b03s002Business.getListMerchants(param,langCode,langValue,1);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			/*super.session("gridcol", b03s002Business.getGridColmun(
					"B03S006", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));*/
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B03S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B03S006", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}/**
	 * 新建厂外通知单
	 * @title initb03S006
	 * @return String
	 */
	public String merchantsAdd() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("add".equals(param.get("opt"))) {
				//  修复通知单查询列表
				Map<String, Object> list = this.b03s002Business.merchantsAdd(param,langCode,langValue,((Customer) super.session("Customer"))
						.getCustomerID());
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b03s002Business.getGridColmun(
					"B03S006", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B03S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B03S006", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
