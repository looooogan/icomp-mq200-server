package com.icomp.v01b08.b08s007.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b08.b08s007.business.B08S007Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class B08S007Action extends IcompAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 设备配置Business
	 */
	private B08S007Business business;

	public void setBusiness(B08S007Business business) {
		this.business = business;
	}

	/**
	 * 工序配置初始化Action
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initb08S007() {

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
			} else if ("unbund".equals(param.get("opt"))) {
				Map<String, Object> ret = this.business.equipmentUnbund(param,
						langValue, ((Customer) super.session("Customer"))
								.getCustomerID(), langCode);
				if (ret.get("message") != null
						&& !"-2".equals(ret.get("status").toString())) {
					super.ajaxReturn(null, null, ret.get("message"), Integer
							.parseInt(ret.get("status").toString()));
				} else {
					super.ajaxReturn(ret);
				}
				return null;
			} else{
				super.assign("DelFlagList", business.getComList(
						IConstant.DEL_FLAG, langCode, langValue)); // 删除区分
				List<Languagetable> langList = (List<Languagetable>) super
						.session("langList");
				super.assign("LanguageCodeList", langList);// 语言列表
				List<Comlist> equipmentTypeList =business.getComList(IConstant.EQUIPMENT_TYPES, langCode, langValue);
				List<Comlist> equipmentTypeListR=new ArrayList<Comlist>();
				for(Comlist c:equipmentTypeList){
					if(c.getComListValue().equals(IConstant.STRING_0)){
						equipmentTypeListR.add(c);
					}
				}
				super.assign("EquipmentTypeList",equipmentTypeListR); //设备类型
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun("B08S007",
						((Customer) super.session("Customer")).getCustomerID(),
						langCode, langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S007.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S007", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}

	}

	/**
	 * 取得设备信息Action
	 * 
	 * @return
	 */
	public String equipmentInfo() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			// 取得设备信息
			Map<String, Object> param = super.param();
			
			// 取得设备列表
			Map<String, Object> ret = business.equipmentInfo(param, langCode, langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeAssemblyLine.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeAssemblyLine",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	public String equipmentEdit() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.equipmentEdit(param,
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
					"equipmentEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/equipmentEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "equipmentEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	/**
	 * 删除设备配置信息
	 * 
	 * @return
	 */
	public String equipmentDelete() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			// 删除设备配置
			Map<String, Object> ret = this.business.equipmentDelete(param,
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
					"equipmentDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/equipmentDelete.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "equipmentDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建工序信息
	 * 
	 * @return
	 */
	public String equipmentAdd() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue(); // 语言编码
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode(); // 语言值
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.equipmentAdd(param,
					langValue, ((Customer) super.session("Customer"))
							.getCustomerID(), langCode);

			if (ret.get("message") != null && "-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"equipmentAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/equipmentAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "equipmentAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

}
