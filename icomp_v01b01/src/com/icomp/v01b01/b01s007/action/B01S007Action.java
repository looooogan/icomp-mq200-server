package com.icomp.v01b01.b01s007.action;

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
import com.icomp.v01b01.b01s007.business.B01S007Business;

/**
 * 在途计划查询ACTION
 * 
 * @ClassName: B01S007Action
 * @author Taoyy
 * @date 2014-8-12 下午04:21:12
 */
public class B01S007Action extends IcompAction {

	/**
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 在途计划查询BUSINESS
	 */
	private B01S007Business b01s007Business;

	public void setB01s007Business(B01S007Business b01s007Business) {
		this.b01s007Business = b01s007Business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb01S007
	 * @return String
	 */
	public String initb01S007() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 在途计划查询列表
				Map<String, Object> list = this.b01s007Business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			}
			
			// 取得机构列表
			List<Vagency> listAgency = b01s007Business.getAgencyList(IConstant.DEL_FLAG_0,langCode, langValue);
			// 取得页面grid显示项目列表
			super.assign("listAgency", listAgency);
			super.session("gridcol", b01s007Business.getGridColmun(
					"B01S007", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S007.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B01S007", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 编辑在途计划信息
	 * 
	 * @return
	 */
	public String vtransitPlanEdit() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			Map<String, Object> param = super.param();
			String str = ((Customer) super.session("Customer")).getCustomerID();
			Map<String, Object> ret = this.b01s007Business.vtransitPlanEdit(
					param, langValue, str, langCode);
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
					"vtransitPlanEdit", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/vtransitPlanEdit.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "vtransitPlanEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 添加实际到货时间、实际到货数量
	 * 
	 * @return
	 */
	public String vtransitPlanAdd() {
		try {
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b01s007Business.vtransitPlanAdd(
					param, langValue, ((Customer) super.session("Customer"))
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
					"vtransitPlanAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/vtransitPlanAdd.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "vtransitPlanAdd",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	
	/**
	 * 取得当前在途计划信息
	 * 
	 * @return
	 */	
	public String vtransitInfo(){
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret=new HashMap<String, Object>();
			if ("edit".equals(param.get("opt"))) {
				ret = this.b01s007Business.vtransitInfo(param, langCode,langValue);
				super.ajaxReturn(ret);
			}
			if ("DepartmentID".equals(param.get("opt"))) {
				// 取得部门列表
				List<Vdepartment> listDepartment = b01s007Business.getDepartmentList(param.get("ID").toString(), IConstant.DEL_FLAG_0, langCode);
				ret.put("data", listDepartment);
				super.ajaxReturn(ret);
			}
			if ("DivPositionID".equals(param.get("opt"))) {
				// 取得职务列表
				List<Vposition> list = b01s007Business.getPositionList(param.get("ID").toString(), IConstant.DEL_FLAG_0, langCode);
				ret.put("data", list);
				super.ajaxReturn(ret);
			}
			if ("DivUserID".equals(param.get("opt"))) {
				// 取得用户列表
				List<Vcustomer> list = b01s007Business.getUserNameList(param.get("ID").toString(), IConstant.DEL_FLAG_0, langCode);
				ret.put("data", list);
				super.ajaxReturn(ret);
			}
			return null;
	}

}
