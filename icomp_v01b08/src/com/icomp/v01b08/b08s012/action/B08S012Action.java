package com.icomp.v01b08.b08s012.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s012.business.B08S012Business;

import java.util.List;
import java.util.Map;

public class B08S012Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工序配置Business
	 */
	private B08S012Business business;

	public void setBusiness(B08S012Business business) {
		this.business = business;
	}

	/**
	 * 库房货架配置初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S012() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode(); // 语言编码
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue(); // 语言值
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				Map<String, Object> list = this.business.getList(param, langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {

				// 初始化页面下拉列表默认值
				super.assign("parts","");
				//取得下拉列表列表
				Map<String,Object> list = this.business.getPageSelList(langCode, langValue);
				super.assign("PartsLineList",list.get("PartsLineList"));
				// 语言列表
				List<Languagetable> langList = (List<Languagetable>) super.session("langList");
				super.assign("LanguageCodeList", langList);
				super.assign("DelFlag", IConstant.STRING_0);
				super.assign("DIVDelFlag", IConstant.STRING_0);

				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun("B08S012",
						 ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,langValue));
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode,langValue)); // 删除区分
				return SUCCESS;

			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S012.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S012", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}

	}

	/**
	 * 编辑零部件信息
	 * 
	 * @return
	 */
	public String assemblyLineEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.assemblyLineEdit(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode,langValue);

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
					"assemblyLineEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/assemblyLineEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "assemblyLineEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建零部件信息
	 * 
	 * @return
	 */
	public String assemblyLineAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.assemblyLineAdd(param,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode,langValue);

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
					"assemblyLineAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/assemblyLineAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "assemblyLineAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除零部件信息
	 * 
	 * @return
	 */
	public String assemblyLineDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.partsDelete(param,
					((Customer) super.session("Customer")).getCustomerID(), langCode,langValue);
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
					"assemblyLineDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/assemblyLineDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "assemblyLineDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得零部件信息
	 * 
	 * @return
	 */
	public String assemblyLineInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.assemblyLineInfo(param, langCode,langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/assemblyLineInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "assemblyLineInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
}
