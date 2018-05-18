package com.icomp.common.service.icomp.v01b05.s001;

import java.util.Map;

import com.icomp.entity.base.Deliveryplan;
import com.icomp.entity.base.Vqualityinspection;

/**
 * 待质检刀具查询SERVICE接口
 * @ClassName: ICOMPV01B01S008Service 
 * @author Licc
 * @date 2014-8-15 下午03:19:35
 */
public interface ICOMPV01B05S001Service {
	/**
	 * 待质检刀具查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
    public	Map<String, Object> getList(Vqualityinspection entity);

	public Map<String, Object> getDeliveryplanInfo(Deliveryplan entity);

	public Map<String, Object> deliveryplanEdit(Deliveryplan deliveryplan,
			String langCode, String langValue);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String customerID, int i, String langValue);



}
