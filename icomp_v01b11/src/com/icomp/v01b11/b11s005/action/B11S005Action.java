package com.icomp.v01b11.b11s005.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
;
import com.icomp.v01b11.b11s005.business.B11S005Business;

import java.util.Map;

/**
 * 加工信息快速查询Action
 * 
 * @ClassName: B03S006Action
 * @author Taoyy
 * @date 2014-8-20 下午18:13:27
 */
public class B11S005Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 加工信息快速查询BUSINESS
	 */
	private B11S005Business b11S005Business;

	public void setB11S005Business(B11S005Business b11S005Business) {
		this.b11S005Business = b11S005Business;
	}

	/**
	 * 初始化加工信息快速查询页面
	 *
	 * @return String
	 * @title initb01S006
	 */
	public String initb11S005() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 加工信息快速查询
				Map<String, Object> list = this.b11S005Business.getList(param, langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}else {
//				super.session("gridcol", b11S005Business.getGridColmun(
//						"B01S001", ((Customer) super.session("Customer"))
//								.getCustomerID(), langCode, langValue));
				return SUCCESS;

			}


		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B04S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B04S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	public  String leaserEdit(){
		try{
		String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
		String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();

		Map<String,Object> param = super.param();
		Map<String, Object> ret = this.b11S005Business.leaserSp(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);

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
