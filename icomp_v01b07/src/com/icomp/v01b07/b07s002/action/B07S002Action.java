package com.icomp.v01b07.b07s002.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b07.b07s002.business.B07S002Business;

import java.util.Map;

/**
 * 库存异常报警
 * @ClassName: B01S012Action 
 * @author Licc
 * @date 2014-8-20 下午04:17:43
 */
public class B07S002Action extends IcompAction {
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	private static final long serialVersionUID = 1L;
	/**
	 * 库存异常报警Business
	 */
	private B07S002Business b07s002Business;

	public void setB07s002Business(B07S002Business b07s002Business) {
		this.b07s002Business = b07s002Business;
	}

	/**
	 * 页面初始化
	 * @title initb07S002
	 * @return String
	 */
	public String initb07S002() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//库存异常报警列表
				Map<String, Object> list = this.b07s002Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				total =this.b07s002Business.getNumber();
				// 取得页面grid显示项目列表
				super.session("gridcol", b07s002Business.getGridColmun(
						"B07S002", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B07S002.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B07S002", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
