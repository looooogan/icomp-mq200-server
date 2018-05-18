package com.icomp.v01b10.b10s002.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b10.b10s002.business.B10S002Business;

/**
 * 手持机日志Action
 * 
 * @ClassName: B03S002Action
 * @author Taoyy
 * @date 2014-8-12 下午04:13:27
 */
public class B10S002Action extends IcompAction {

	private static final long serialVersionUID = 1L;
	/**
	 * 手持机日志Business
	 */
	private B10S002Business b10s002Business;
	
	public void setB10s002Business(B10S002Business b10s002Business) {
		this.b10s002Business = b10s002Business;
	}

	/**
	 * 手持机日志页面初始化
	 * @title initb10S002
	 * @return String
	 */
	public String initb10S002() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//  手持机日志列表
				Map<String, Object> list = this.b10s002Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b10s002Business.getGridColmun("B10S002", ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B10S002.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B10S002", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
}
