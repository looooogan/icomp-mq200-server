package com.icomp.common.service.icomp.v01b04.s007;

import com.icomp.entity.base.Vwarning;
import com.icomp.entity.base.Warning;

import java.util.Map;

/**
 * 加工信息快速查询SERVICES接口
 * @ClassName: ICOMPV01B03S005Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:42:36
 */
public interface ICOMPV01B04S007Service {
/**
 * 加工信息快速查询
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

	public Map<String, Object> getList(Vwarning entity);


	Map<String,Object> checkInput(Map<String, Object> param, String langCode, String langValue, String userID, int i);

	Map<String,Object> VwarningAdd(Warning entity, String langCode, String langValue);

	Map<String,Object> getWanrning(Map<String, Object> param, Warning entity,String customerID);

	String getNumber();
}
