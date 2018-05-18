package com.icomp.common.service.icomp.v01b07.s004;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Vcustomer;
import com.icomp.entity.base.Vpurchasingorder;
import com.icomp.entity.base.Vtoolprocureds;

/**
 * 采购订单SERVICE接口
 * 
 * @ClassName: ICOMPV01B07S004Service
 * @author Taoyy
 * @date 2014-9-16 下午01:51:24
 */

public interface ICOMPV01B07S004Service {
	/**
	 * 采购订单列表
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	 // public Map<String, Object> getList(Vpurchasingorder entity);
	public Map<String, Object> getList(Vtoolprocureds entity);
	/**
	 * 取得用户列表
	 * @title getVcustomer 
	 * @param entity
	 * @return
	 * List<Vcustomer>
	 */
	public List<Vcustomer> getVcustomer(Vcustomer entity);
	/**
	 * 保存采购订单
	 * @title saveAll 
	 * @param langCode
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> orderAdd(Deliveryplan entity, String langCode, String tempCount,String langValue);

	/**
	 * 新建
	 * @param vtoolprocureds
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> deliveryplansAdd( Vtoolprocureds vtoolprocureds, String langCode, String langValue);


}
