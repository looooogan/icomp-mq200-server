package com.icomp.v01b09.b09s004.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b09.b09s004.business.B09S004Business;

import java.util.List;
import java.util.Map;
/**
 * 打印项目参数
 * @author cyn
 *
 */
public class B09S004Action extends IcompAction {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	
	private B09S004Business b09s004Business;

	public void setB09s004Business(B09S004Business b09s004Business) {
		this.b09s004Business = b09s004Business;
	}

	/**
	 * 页面初始化
	 * 
	 * @title initb03S004
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String initb09S004() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 设置页面初始化值
				Map<String, Object> map =this.b09s004Business.getList(param, langCode,langValue);
				super.ajaxReturn(map);
				return null;
			} else {
				//语言列表
				List<Languagetable> langList = (List<Languagetable>)super.session("langList");
				super.assign("LanguageCodeList", langList);
				 // 删除区分
				super.assign("DelFlagList", b09s004Business.getComList(
						IConstant.DEL_FLAG, langCode,langValue));
				super.assign("DelFlag",IConstant.DEL_FLAG_0); // 删除区分-检索初始值
				// 取得页面grid显示项目列表
				super.session("gridcol", b09s004Business.getGridColmun(
						"B09S004", ((Customer) super.session("Customer"))
								.getCustomerID(), langCode,  langValue));
				return SUCCESS;
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B09S004.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "B09S004", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	/**
	 * 新建容器
	 * 
	 * @return
	 */
	public String printItemAdd() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			//添加打印项目
			Map<String, Object> ret = this.b09s004Business.PrintItemAdd(param,
					((Customer) super.session("Customer")).getCustomerID(),langCode,langValue);

			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录新建成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),
					"printItemAdd", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super
							.session("Customer")).getCustomerID(), ret.get(
							"message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/printItemAdd.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "printItemAdd", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	/**
	 * 删除打印项目信息
	 * 
	 * @return
	 */
	public String printItemDelete() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			//删除
			Map<String, Object> ret = this.b09s004Business.printItemDelete(param,
					langCode, ((Customer) super.session("Customer"))
							.getCustomerID(), langValue);
			
			if (ret.get("message") != null
					&& !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer
						.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/printItemDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "printItemDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	
	
	/**
	 * 编辑打印项目信息
	 * 
	 * @return
	 */
	public String printItemEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable"))
			.getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable"))
			.getLanguageValue();	
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b09s004Business.printItemEdit(param, langCode,
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

			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/printItemEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "printItemEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	/**
	 * 取得项目打印信息
	 * 
	 * @return
	 */
	public String printItemInfo() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
	        String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b09s004Business.printItemInfo(param, langCode,langValue);
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
