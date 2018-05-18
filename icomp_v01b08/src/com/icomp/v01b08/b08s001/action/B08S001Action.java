package com.icomp.v01b08.b08s001.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s001.business.B08S001Business;

public class B08S001Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 功能管理Business
	 */
	private B08S001Business business;

	public void setBusiness(B08S001Business business) {
		this.business = business;
	}

	/**
	 * 功能管理初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S001() {
		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			
				// 初始化页面下拉列表
				// 取得功能列表
				super.assign("CapabilityIDList",null);
				super.assign("CapabilityIDList", business.getCapabilityIDList(
						param, langCode,langValue).get("rows"));
				// 删除区分
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue));
				// 是否菜单
				super.assign("MenuFlagList", business.getComList(
						IConstant.MENU_FLAG, langCode, langValue));
				// 功能归属
				super.assign("BelongFlagList", business.getComList(
						IConstant.BELONG_FLAG, langCode, langValue));
				// 语言列表
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				super.assign("LanguageCodeList", langList);
				// 取得权限列表
				Map<String, Object> list = this.business.getList(param,
						langCode, langValue);
				super.assign("GruanList", list.get("rows"));
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun("B08S001",
						langValue, ((Customer) super.session("Customer"))
								.getCustomerID(), langCode));
				if ("list".equals(param.get("opt"))) {
					// 设置页面初始化值
					list = this.business.getList(param,
							langCode, langValue);
					super.ajaxReturn(list);
					// 取得功能列表
					super.assign("CapabilityIDList",null);
					super.assign("CapabilityIDList", business.getCapabilityIDList(
							param, langCode,langValue).get("rows"));
					return null;
				} 
				return SUCCESS;
			
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S001.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S001", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建功能Action
	 * 
	 * @return
	 */
	public String capabilityAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			super.ajaxReturn(business.capabilityAdd(param, langValue,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode));
			return null;

		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/capabilityAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "capabilityAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 功能信息查询Action
	 * 
	 * @return
	 */
	public String capabilityInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			super.ajaxReturn(business
					.capabilityInfo(param, langCode, langValue));
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/caplitiyInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "caplitiyInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑功能Action
	 * 
	 * @return
	 */
	public String capablitiyEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			super.ajaxReturn(business.capabilityEdit(param, langValue,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode));
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/capabilityInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "capabilityInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除功能Action
	 * 
	 * @return
	 */
	public String capabilityDel() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			super.ajaxReturn(business.capabilityDelete(param, langValue,
					((Customer) super.session("Customer")).getCustomerID(),
					langCode));
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/capabilityInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "capabilityInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
