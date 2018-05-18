package com.icomp.v01b03.b03s007.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b03.b03s007.business.B03S007Business;

import java.util.HashMap;
import java.util.Map;

/**
 * 筒刀拆装记录查询ACTION
 * @ClassName: B03S007Action
 * @author Sj
 * @date 2017-7-7 下午04:21:51
 */
public class B03S007Action extends IcompAction {
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 刃磨信息快速查询BUSINESS
	 */
	private B03S007Business b03s007Business;
	public void setB03s007Business(B03S007Business b03s007Business) {
		this.b03s007Business = b03s007Business;
	}


	/**
	 * 刃磨信息快速查询页面初始化
	 * @title initb03S007
	 * @return
	 * String
	 */
	public String initb03S007(){
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				//  修复通知单查询列表
				Map<String, Object> list = this.b03s007Business.getListMerchants(param, langCode, langValue,1);
				super.ajaxReturn(list);
				return null;
			}
			total = this.b03s007Business.getMnumber();
			// 取得页面grid显示项目列表
            /*super.session("gridcol", b03s002Business.getGridColmun(
					"B03S003", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));*/
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B03S003.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B03S003", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

	/**
	 * 取得用户信息
	 *
	 * @return
	 */
	public String tdDetail() {
		try {
			String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
			String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
			Map<String, Object> param = super.param ();


			Map<String, Object> ret = new HashMap<String, Object>();
			if("detail".equals(param.get("opt"))){
				ret = this.b03s007Business.detailInfo ( param, langCode, langValue );
			}else if("total".equals(param.get("opt"))){
				ret = this.b03s007Business.totalInfo ( param, langCode, langValue );
			}

			super.ajaxReturn ( ret );
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException ( getResponse (), "/tdDetail.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "tdDetail", ((Customer) super.session ( "Customer" )).getCustomerID () );
			return null;
		}
	}

}
