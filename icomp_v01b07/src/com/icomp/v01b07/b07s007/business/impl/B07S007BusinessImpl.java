package com.icomp.v01b07.b07s007.business.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s007.ICOMPV01B07S007Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Rfidpurchase;
import com.icomp.v01b07.b07s007.business.B07S007Business;

/**
 * 标签采购BUSINESS实体类
 * 
 * @ClassName: B07S007BusinessImpl
 * @author Licc
 * @date 2014-8-21 上午10:39:35
 */
public class B07S007BusinessImpl implements B07S007Business {

	/**
	 * 调用COMMONSERVICES接口
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01B07S007Service icompv01b07s007Service;

	public void setIcompv01b07s007Service(ICOMPV01B07S007Service icompv01b07s007Service) {
		this.icompv01b07s007Service = icompv01b07s007Service;
	}

	/**
	 * 标签采购列表
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue) throws BusinessException {

		/**
		 * 设置检索条件
		 */
		Rfidpurchase entity = new Rfidpurchase();

		// 标签ID
		entity.setRfidPurchaseID(StringUtils.isEmpty(param.get("RfidPurchaseID").toString()) ? null : param.get("RfidPurchaseID").toString());
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("RfidPurchaseID");			
		// 标签采购列表
		Map<String, Object> rtn = icompv01b07s007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Rfidpurchase>) rtn.get("error")).get(0).getMessageCode(),langCode, langValue);
		}
		return rtn;
	}
	
	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
}
