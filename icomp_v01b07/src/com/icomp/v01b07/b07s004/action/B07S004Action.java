package com.icomp.v01b07.b07s004.action;

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
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.v01b07.b07s004.business.B07S004Business;

/**
 * 采购订单Action
 * 
 * @ClassName: B07S004Action
 * @author Taoyy
 * @date 2014-9-16 下午01:47:46
 */

public class B07S004Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 采购订单BUSINESS
	 */
	private B07S004Business b07s004Business;

	public void setB07s004Business(B07S004Business b07s004Business) {
		this.b07s004Business = b07s004Business;
	}

	/**
	 * 采购订单页面初始化
	 * 
	 * @title initb03S004
	 * @return String
	 */
	public String initb07S004() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 换领申请信息列表
				Map<String, Object> list = this.b07s004Business.getList(param,langCode, langValue);
				super.ajaxReturn(list);
				return NONE;
			}else{
				// 取得页面grid显示项目列表
				super.session("gridcol", b07s004Business.getGridColmun(
						"B07S004", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/B07S004.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B07S004", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 采购订单增加
	 * @title deliveryPlanAdd 
	 * @return
	 * String
	 */
	public String deliveryPlanAdd() {
		try {

			// 语言编码
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			// 用户ID
			String customer = ((Customer) super.session("Customer")).getCustomerID();

			// 保存采购订单
			Map<String, Object> ret = b07s004Business.saveAll(param, langValue, customer, langCode);
			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "b07S004Save", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
			return NONE;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(), "/b07S004Save.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "procurementAdd", ((Customer) super.session("Customer")).getCustomerID());
			return NONE;
		}
	}

	public String deliveryPlannewAdd() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("add".equals(param.get("opt"))) {
				//  修复通知单查询列表
				Map<String, Object> list = this.b07s004Business.newAdd(param, langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b07s004Business.getGridColmun(
					"B07S004", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode, langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B07S004.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B07S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}

	}
	
	
	
	
	
	/**
	 * 取得机构列表
	 * 
	 * @title getAgencyList
	 * @return String
	 */
	public String getAgencyList() {
		Map<String,Object> ret = new HashMap<String, Object>();
		// 语言实体类
		String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
		// 语言实体类
		String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
		// 取得机构列表
		List<Vagency> listAgency = b07s004Business.getAgencyList(IConstant.DEL_FLAG_0,langCode, langValue);
		ret.put("data", listAgency);
		super.ajaxReturn(ret);
		return NONE;
	}
	/**
	 * 取得部门列表
	 * 
	 * @title getDepartmentList
	 * @return String
	 */
	public String getDepartmentList() {
		Map<String,Object> ret = new HashMap<String, Object>();
		// 语言实体类
		String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
		// 语言实体类
		// 参数
		Map<String, Object> param = super.param();
		// 取得部门列表
		List<Vdepartment> listDepartment = b07s004Business.getDepartmentList(param.get("AgencyID").toString(), IConstant.DEL_FLAG_0, langCode);
		ret.put("data", listDepartment);
		super.ajaxReturn(ret);
		return NONE;
	}

	/**
	 * 取得职务列表
	 * 
	 * @title getDepartmentList
	 * @return String
	 */
	public String getPositionList() {
		Map<String,Object> ret = new HashMap<String, Object>();
		// 语言实体类
		String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
		// 参数
		Map<String, Object> param = super.param();
		// 取得职务列表
		List<Vposition> positionList = b07s004Business.getPositionList(param.get("DepartmentID").toString(), IConstant.DEL_FLAG_0, langCode);
		ret.put("data", positionList);
		super.ajaxReturn(ret);
		return NONE;
	}
	/**
	 *	取得用户列表
	 * 
	 * @title getDepartmentList
	 * @return String
	 */
	public String getUserNameList() {
		Map<String,Object> ret = new HashMap<String, Object>();
		// 语言实体类
		String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
		// 参数
		Map<String, Object> param = super.param();
		// 取得用户列表
		List<Vcustomer> customerList = b07s004Business.getUserNameList(param.get("PositionID").toString(), IConstant.DEL_FLAG_0, langCode);
		ret.put("data", customerList);
		super.ajaxReturn(ret);
		return NONE;
	}

}
