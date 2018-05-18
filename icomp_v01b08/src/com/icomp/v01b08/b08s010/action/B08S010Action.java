package com.icomp.v01b08.b08s010.action;

import java.util.List;
import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vproductiondesign;
import com.icomp.v01b08.b08s010.business.B08S010Business;

public class B08S010Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 生产计划Business
	 */
	private B08S010Business business;

	public void setBusiness(B08S010Business business) {
		this.business = business;
	}

	/**
	 * 生产计划初始化Action
	 * @return
	 */
	public String initb08S010() {

		// 下拉列表值取得
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言编码
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言值
			Map<String, Object> param = super.param();

			// 当点击查询按钮，根据页面的检索条件，取得对应数据
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值
				Map<String, Object> list = this.business.getList(param,
						((Customer) super.session("Customer")).getCustomerID(),
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
				// 当点击查询以外时，取得下拉列表的值
			}else {
				// 取得零部件列表
				List<Assemblyline> listAssemblyline = business.getPartsList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				super.assign("listAssemblyline", listAssemblyline);
				// 取得年份列表
				List<Vproductiondesign> yearList = this.business.getYearList(
						IConstant.DEL_FLAG_0, langCode, langValue);
				super.assign("listAssemblyline", listAssemblyline);
				super.assign("yearList", yearList);
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun(
						"B08S010", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S010.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S010", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 编辑生产计划 
	 * @return
	 */
	public String productionDesignEdit(){
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.productionDesignEdit(param, langCode,
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
					"productionDesignEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/productionDesignEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "productionDesignEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 新建生产计划
	 * @return
	 */
	public String productionDesignAdd(){
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.productionDesignAdd(param, langCode,
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
					"productionDesignEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/productionDesignEdit.action", IConstant.RESULT_CODE_1, ex, this
					.getClass().getName(), "productionDesignEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 获取生产计划
	 * 
	 * @return
	 */
	public String productionDesignInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.productionDesignInfo(param, langCode,((Customer) super.session("Customer")).getCustomerID(),langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/printItemInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "printItemInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
