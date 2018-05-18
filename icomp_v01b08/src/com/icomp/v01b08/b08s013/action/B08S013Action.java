package com.icomp.v01b08.b08s013.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Voplinkdown;
import com.icomp.v01b08.b08s013.business.B08S013Business;

import java.util.List;
import java.util.Map;

public class B08S013Action extends IcompAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工序配置Business
	 */
	private B08S013Business business;

	public void setBusiness(B08S013Business business) {
		this.business = business;
	}

	/**
	 * 库房货架配置初始化Action
	 *
	 * @return
	 */
	public String initb08S013() {

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
				super.assign("AssemblyLine","");
				super.assign("Process","");
				super.assign("SynthesisParameters","");
				super.assign("Parts","");
				super.assign("Equipment","");
				super.assign("LastProcess","");
				super.assign("Axle","");
				//取得下拉列表列表
				Map<String,Object> list = this.business.getPageSelList(langCode, langValue);
				super.assign("AssemblyLineList",list.get("AssemblyLineList"));
				super.assign("ProcessList",list.get("ProcessList"));
				super.assign("SynthesisParametersList",list.get("SynthesisParametersList"));
				super.assign("EquipmentList",list.get("EquipmentList"));
				super.assign("PartsList",list.get("PartsList"));
				super.assign("LastProcessList",list.get("LastProcessList"));
				super.assign("AxleLineList",list.get("AxleLineList"));
				// 取得页面grid显示项目列表
				super.session("gridcol", business.getGridColmun("B08S013",
						((Customer) super.session("Customer"))
								.getCustomerID(), langCode,langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B08S013.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B08S013", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}

	}


	/**
	 * 编辑
	 *
	 * @return
	 */
	public String oplinkEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.oplinkEdit(param,((Customer) super.session("Customer")).getCustomerID(),langCode,langValue);

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
					"oplinkEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/oplinkEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "oplinkEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 新建
	 *
	 * @return
	 */
	public String oplinkAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();

			Map<String, Object> ret = this.business.oplinkAdd(param,
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
					"oplinkAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/oplinkAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "oplinkAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 删除用户信息
	 *
	 * @return
	 */
	public String oplinkDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.oplinkDelete(param,
					((Customer) super.session("Customer"))
							.getCustomerID(), langCode,langValue);
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
					"oplinkDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/oplinkDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "oplinkDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得用户信息
	 *
	 * @return
	 */
	public String oplinkInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.business.oplinkInfo(param, langCode,langValue);
			super.ajaxReturn(ret);
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/oplinkInfo.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "oplinkInfo",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String prossAndBuss8() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 根据用户选择的机构ID，取得 相应的部门及职务列表
			Map<String, Object> param = super.param();

			// 取得流程工序中间表
			List<Voplinkdown> listOplink = business.getVoplink(param, IConstant.DEL_FLAG_0, langCode, langValue,4);
//			String ProcessID = listProcess.get(0).getProcessID();
			super.assign("listOplink", listOplink);
			super.ajaxReturn(listOplink, null, listOplink.get(0).getMessageCode()==null?0:-2, null );

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/changeDepartment.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "changeDepartment",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
}
