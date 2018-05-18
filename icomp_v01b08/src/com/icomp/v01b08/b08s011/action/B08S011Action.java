package com.icomp.v01b08.b08s011.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vlibrarycode;
import com.icomp.v01b08.b08s011.business.B08S011Business;

public class B08S011Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工序配置Business
	 */
	private B08S011Business business;

	public void setBusiness(B08S011Business business) {
		this.business = business;
	}

	/**
	 * 库房货架配置初始化Action
	 * 
	 * @return
	 */
	public String initb08S011() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值

				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {
                List<Vlibrarycode> listlib = business.getVLibraryCodeList(param, langValue);
				
				super.assign("LibraryCodeList", listlib);          //库位码
				super.assign("ComplexList", business.getComList(
						IConstant.COMPLEX, langCode, langValue)); // 厂区
				super.assign("DepotList", business.getComList(
						IConstant.DEPOT, langCode, langValue)); // 库房号
				super.assign("ShelfList", business.getComList(
						IConstant.SHELF, langCode, langValue)); //货架 
				super.assign("LayerList", business.getComList(
						IConstant.LAYER, langCode, langValue)); //层
				super.assign("StackList", business.getComList(
						IConstant.STACK, langCode, langValue)); //货位
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
				
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun(
						"B08S011", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S011.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S011", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}

	}

	/**
	 * 删除库房货架配置信息
	 * 
	 * @return
	 */
	public String stackDelete() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			// 删除库房货架配置
			Map<String, Object> ret = this.business.stackDelete(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);
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
					"stackDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/stackDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "stackDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建库房货架配置信息
	 * 
	 * @return
	 */
	public String stackAdd() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.stackAdd(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);

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
					"stackAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/stackAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "stackAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得库房货架配置信息
	 * 
	 * @return
	 */
	public String stackInfo() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.stackInfo(param,
					langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/stackInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "stackInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑库房货架配置信息
	 * 
	 * @return
	 */
	public String stackEdit() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.stackEdit(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);
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
					"stackEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/stackEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "stackEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

}
