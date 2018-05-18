package com.icomp.v01b07.b07s006.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b07.b07s006.business.B07S006Business;
/**
 * 工作记录查询
 * @ClassName: B07S006Action 
 * @author licc
 * @date 2014-9-25 下午04:21:51
 */
public class B07S006Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 工作记录查询BUSINESS
	 */
	private B07S006Business b07s006Business;
	
	public void setB07s006Business(B07S006Business b07s006Business) {
		this.b07s006Business = b07s006Business;
	}

	/**
	 * 页面初始化
	 * @title initb07S006 
	 * @return
	 * String
	 */
	public String initb07S006(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//工作记录列表
				Map<String, Object> list = this.b07s006Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b07s006Business.getGridColmun(
						"B07S006", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B07S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B07S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
}
