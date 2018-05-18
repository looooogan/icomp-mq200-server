package com.icomp.v01b07.b07s003.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vsuggestionpurchaseplan;
import com.icomp.v01b07.b07s003.business.B07S003Business;

/**
 * 采购计划处理
 * 
 * @ClassName: B07S003Action
 * @author Taoyy
 * @date 2014-9-13 下午02:50:12
 */

public class B07S003Action extends IcompAction {
	private static final long serialVersionUID = 7255161566182210074L;

	/**
	 * 采购计划处理Business
	 */
	private B07S003Business b07s003Business;

	public void setB07s003Business(B07S003Business b07s003Business) {
		this.b07s003Business = b07s003Business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb03S003
	 * @return String
	 */
	public String initb07S003() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 采购计划处理列表
				Map<String, Object> list = this.b07s003Business.getList(param,langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b07s003Business.getGridColmun(
						"B07S003", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B07S003.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B07S003", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得采购计划信息
	 * 
	 * @title roleInfo
	 * @return String
	 */

	public String procurementInfo() {
		try {
			Map<String, Object> ret = new HashMap<String, Object>();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			List<Vsuggestionpurchaseplan> list = this.b07s003Business.procurementInfo(param,langCode, langValue);
			ret.put("data", list);
			super.ajaxReturn(ret);
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/procurementInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "procurementInfo", ((Customer) super.session("Customer")).getCustomerID());
			return NONE;
		}
	}
	/**
	 * 启用采购计划提交
	 * @title procurementAdd 
	 * @return
	 * String
	 */
	public String procurementAdd() {
		try {

			// 语言编码
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 参数
			Map<String, Object> param = super.param();
			// 用户ID
			String customer = ((Customer) super.session("Customer")).getCustomerID();

			// 保存建议采购计划
			Map<String, Object> ret = b07s003Business.saveAll(param, langValue, customer, langCode);
			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "b07S003Save", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/b07S003Save.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "procurementAdd", ((Customer) super.session("Customer")).getCustomerID());
			return NONE;
		}
	}
	/**
	 * 建议采购计划删除
	 * @title procurementPlansDel 
	 * @return
	 * String
	 */
	public String procurementPlansDel() {
		try {
			
			// 语言编码
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 参数
			Map<String, Object> param = super.param();
			// 用户ID
			String customer = ((Customer) super.session("Customer")).getCustomerID();
			
			// 保存建议采购计划
			Map<String, Object> ret = b07s003Business.procurementPlansDel(param, langValue, customer, langCode);
			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "procurementPlansDel", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/procurementPlansDel.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "procurementPlansDel", ((Customer) super.session("Customer")).getCustomerID());
			return NONE;
		}
	}

}
