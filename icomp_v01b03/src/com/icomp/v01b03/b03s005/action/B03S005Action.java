package com.icomp.v01b03.b03s005.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b03.b03s005.business.B03S005Business;
/**
 * 刃磨信息快速查询ACTION
 * @ClassName: B03S005Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:21:51
 */
public class B03S005Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 刃磨信息快速查询BUSINESS
	 */
	private B03S005Business b03s005Business;
	public void setB03s005Business(B03S005Business b03s005Business) {
		this.b03s005Business = b03s005Business;
	}


	/**
	 * 刃磨信息快速查询页面初始化
	 * @title initb03S005 
	 * @return
	 * String
	 */
	public String initb03S005(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//刃磨信息快速查询列表
				Map<String, Object> list = this.b03s005Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b03s005Business.getGridColmun(
					"B03S005", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B03S005.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B03S005", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
}
