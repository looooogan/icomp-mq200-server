package com.icomp.v01b05.b05s001.action;

import java.util.HashMap;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b05.b05s001.business.B05S001Business;

/**
 * 待质检刀具查询Action
 * @ClassName: B05S001Action 
 * @author Licc
 * @date 2014-8-20 下午02:31:34
 */
public class B05S001Action extends IcompAction {

	/** 
	 * @Fields serialVersionUID 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 待质检刀具查询BUSINESS
	 */
	private B05S001Business b05s001Business;
	public void setB05s001Business(B05S001Business b05s001Business) {
		this.b05s001Business = b05s001Business;
	}


	/**
	 * 待质检刀具查询初始化
	 * @title initb01S001 
	 * @return
	 * String
	 */
	public String initb05S001(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 待质检刀具查询列表
				Map<String, Object> list = this.b05s001Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}

			// 取得页面grid显示项目列表
			super.session("gridcol", b05s001Business.getGridColmun(
					"B05S001", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B05S001.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B05S001", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	/**
	 * 编辑待质检刀具信息
	 * 
	 * @return
	 */
	public String deliveryplanEdit() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b05s001Business.deliveryplanEdit(
					param, langValue, ((Customer) super.session("Customer")).getCustomerID(), langCode);
			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录编辑成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"deliveryplanEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/deliveryplanEdit.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "deliveryplanEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	/**
	 * 取得当前待质检刀具信息
	 * 
	 * @return
	 */	
	public String deliveryplanInfo(){
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret=new HashMap<String, Object>();
			if ("edit".equals(param.get("opt"))) {
				ret = this.b05s001Business.deliveryplanInfo(param, langCode,langValue);
				super.ajaxReturn(ret);
			}
			return null;
	}

}
