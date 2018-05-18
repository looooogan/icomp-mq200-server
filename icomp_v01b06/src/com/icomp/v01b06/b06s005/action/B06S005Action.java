package com.icomp.v01b06.b06s005.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b06.b06s005.business.B06S005Business;

import java.util.Map;

/**
 * 刀具实时分布状况Action
 * 
 * @ClassName: B06S005Action
 * @author Taoyy
 * @date 2014-8-22 上午09:05:25
 */

public class B06S005Action extends IcompAction {
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 刀具实时分布状况BUSINESS
	 */
	private B06S005Business b06s005Business;

	public void setB06s005Business(B06S005Business b06s005Business) {
		this.b06s005Business = b06s005Business;
	}

	/**
	 * 初始化刀具实时分布状况页面
	 * 
	 * @title initb01S005
	 * @return String
	 */
	public String initb06S005() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable"))
					.getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable"))
					.getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 刀具实时分布状况列表
				Map<String, Object> list = this.b06s005Business.getList(param,
						langCode, langValue);
				super.ajaxReturn(list);
				return null;
			} else {

//
//				// 取得机构列表
//				List<Vagency> listAgency = b06s005Business.getAgencyList(
//						IConstant.DEL_FLAG_0, langCode, langValue);
//				super.assign("AgencyList", listAgency);
//				// 取得部门列表
//				List<Vdepartment> listDepartment = b06s005Business.getDepartmentList(
//						listAgency.get(0).getAgencyID(), IConstant.DEL_FLAG_0,
//						langCode, langValue);
//				super.assign("DepartmentList", listDepartment);
//				// 取得页面grid显示项目列表
				super.session("gridcol", b06s005Business.getGridColmun(
						"B06S005", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode, langValue));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B06S005.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B06S005", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 分析统计
	 * @title statistics_b06S005
	 * @return
	 * String
	 */
	public String statistics_b06S005(){
		try {
				// 语言实体类
				String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
				String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
				// 参数
				Map<String, Object> param = super.param();
				// 刀具资金占用情况分析统计
				super.ajaxReturn(b06s005Business.getStatisticalCount(param, langCode, langValue));
				return NONE;
			} catch (BusinessException ex) {
				ApplicationException.setApplicationException(getResponse(), "/statistics_b06S008", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B06S008", ((Customer) super.session("Customer")).getCustomerID());
				return NONE;
			}
		}


}
