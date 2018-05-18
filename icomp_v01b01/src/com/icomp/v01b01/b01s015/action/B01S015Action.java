package com.icomp.v01b01.b01s015.action;

import java.util.Map;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b01.b01s015.business.B01S015Business;

/**
 * 库存盘点查询Action
 * @ClassName: B01S013Action
 * @author Licc
 * @date 2014-11-10 下午02:31:34
 */
public class B01S015Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	/**
	 * 库存盘点查询BUSINESS
	 */
	private B01S015Business b01s015Business;

	public void setB01s015Business(B01S015Business b01s015Business) {
		this.b01s015Business = b01s015Business;
	}

	/**
	 * 库存盘点查询页面
	 * @title initb01S015
	 * @return
	 * String
	 */
	public String initb01S015(){
		try {
			// 语言实体类
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 库存盘点查询列表
				Map<String, Object> list = this.b01s015Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else {


				super.assign ( "AssemblyLineID", "" );
				super.assign ( "ProcessID", "" );
				super.assign ( "PartsID", "" );
				super.assign ( "EquipmentID", "" );
				super.assign ( "AxleID", "" );

				Map<String, Object> list = this.b01s015Business.getPageSelList ( langCode, langValue );
				super.assign ( "AssemblyLineList", list.get ( "AssemblyLineList" ) );
				super.assign ( "ProcessList", list.get ( "ProcessList" ) );
				super.assign ( "EquipmentList", list.get ( "EquipmentList" ) );
				super.assign ( "PartsList", list.get ( "PartsList" ) );
				super.assign ( "AxleLineList", list.get ( "AxleLineList" ) );
			}
			// 取得页面grid显示项目列表
			super.session("gridcol", b01s015Business.getGridColmun(
					"B01S015", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B01S015.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B01S015", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}

}