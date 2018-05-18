package com.icomp.v01b09.b09s003.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b09.b09s003.business.B09S003Business;

import java.util.List;
import java.util.Map;

/**
 * 列表显示项目参数
 * @ClassName: B01S003Action 
 * @author Taoyy
 * @date 2014-8-12 下午04:15:17
 */
public class B09S003Action extends IcompAction {
	
	private B09S003Business b09s003Business;

	public void setB09s003Business(B09S003Business b09s003Business) {
		this.b09s003Business = b09s003Business;
	}

	/** 
	 */ 
	private static final long serialVersionUID = 7255161566182210074L;

	/**
	 * 页面初始化
	 * @title initb03S003 
	 * @return
	 * String
	 */
	@SuppressWarnings("unchecked")
	public String initb09S003(){
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值
				Map<String, Object> map =this.b09s003Business.getList(param, langCode,langValue);
				super.ajaxReturn(map);
				return null;
			} else {
				//语言列表
				List<Languagetable> langList = (List<Languagetable>)super.session("langList");
				super.assign("LanguageCodeList", langList);
				 // 删除区分
				super.assign("DelFlagList", b09s003Business.getComList(
						IConstant.DEL_FLAG, langCode,langValue));
				super.assign("DelFlag",IConstant.DEL_FLAG_0); // 删除区分-检索初始值
				// 取得页面grid显示项目列表
				super.session("gridcol", b09s003Business.getGridColmun(
						"B09S003", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B09S003.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B09S003", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建列表显示项目信息
	 *
	 * @return
	 */
	public String displayItemAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			//添加打印项目
			Map<String, Object> ret = this.b09s003Business.PrintItemAdd(param,
					((Customer) super.session("Customer")).getCustomerID(),langCode,langValue);

			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"displayItemAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/displayItemAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "displayItemAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除列表显示项目信息
	 *
	 * @return
	 */
	public String displayItemDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			//删除
			Map<String, Object> ret = this.b09s003Business.printItemDelete(param,
					langCode, ((Customer) super.session("Customer"))
							.getCustomerID(), langValue);

			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录删除成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"displayItemDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/displayItemDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "displayItemDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}


	/**
	 * 编辑列表显示项目信息
	 *
	 * @return
	 */
	public String displayItemEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b09s003Business.printItemEdit(param, langCode,
					((Customer) super.session("Customer")).getCustomerID(),
					langValue);

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
					"displayItemEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/displayItemEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "displayItemEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 取得列表显示项目信息
	 *
	 * @return
	 */
	public String displayItemInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b09s003Business.printItemInfo(param, langCode,langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/displayItemInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "displayItemInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
