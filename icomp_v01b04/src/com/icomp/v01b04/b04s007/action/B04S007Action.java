package com.icomp.v01b04.b04s007.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b04.b04s007.business.B04S007Business;

import java.util.Map;

/**
 * 预警设置Action
 * 
 * @ClassName: B03S006Action
 * @author Taoyy
 * @date 2014-8-20 下午18:13:27
 */
public class B04S007Action extends IcompAction {
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 加工信息快速查询BUSINESS
	 */
	private B04S007Business b04s007Business;

	public void setB04s007Business(B04S007Business b04s007Business) {
		this.b04s007Business = b04s007Business;
	}

	/**
	 * 初始化加工信息快速查询页面
	 *
	 * @return String
	 * @title initb01S006
	 */
	public String initb04S007() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 加工信息快速查询
				Map<String, Object> list = this.b04s007Business.getList(param, langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}
			total = this.b04s007Business.getNumber();


		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
		return SUCCESS;
	}

	public String warningAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			//添加
			Map<String, Object> ret = this.b04s007Business.VwarningAdd(param,
					((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);

			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/warningAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "warningAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
		return null;
	}

	public  String waningSsp(){
		try{
		String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
		String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();

		Map<String,Object> param = super.param();
		Map<String, Object> ret = this.b04s007Business.VwarningSsp(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);

	if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
			super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
			return null;
		} else {
			super.ajaxReturn(ret);
	}
	} catch (BusinessException ex) {
		ApplicationException.setApplicationException(getResponse(),
				"/waningSsp.action", IConstant.RESULT_CODE_1, ex, this
						.getClass().getName(), "waningSsp",((Customer) super.session("Customer")).getCustomerID());
		return null;
	}
		return null;
	}
}
