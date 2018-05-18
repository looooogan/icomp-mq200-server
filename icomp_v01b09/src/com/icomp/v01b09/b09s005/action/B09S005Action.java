package com.icomp.v01b09.b09s005.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b09.b09s005.business.B09S005Business;

import java.util.Map;

/**
 * 初始化
 * @author cyn
 *
 */
public class B09S005Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	
	private B09S005Business b09s005Business;

	public void setB09s005Business(B09S005Business b09s005Business) {
		this.b09s005Business = b09s005Business;
	}

	public String initb09S005() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 待处理刀具信息查询列表
				Map<String, Object> list = this.b09s005Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}
				super.assign("ContainercarriersList","");
				Map<String,Object> list = this.b09s005Business.getPageSelList(langCode, langValue);
				super.assign("ContainercarriersList",list.get("ContainercarriersList"));

			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B09S005.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B09S005", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String sferAdd() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();

				//申请信息列表
			Map<String, Object> ret = this.b09s005Business.sferAdds(param, langCode, langValue ,((Customer) super.session("Customer")).getCustomerID());



			if (ret.get("message") != null ) {
					super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
					return null;
				} else {
					super.ajaxReturn(ret);
				}

		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S005.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S005", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
		return SUCCESS;
	}


	}

