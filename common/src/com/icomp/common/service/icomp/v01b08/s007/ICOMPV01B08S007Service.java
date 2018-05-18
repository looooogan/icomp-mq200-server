package com.icomp.common.service.icomp.v01b08.s007;

import java.util.Map;

import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Vequipment;


/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S007Service {

	public Map<String, Object> getList(Vequipment entity);

	public Map<String, Object> equipmentDelete(Equipment equipment, String langCode,String langValue);

	public Map<String, Object> equipmentAdd(Equipment equipment, String langCode,String langValue);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int i);
	public Map<String, Object> equipmentEdit(Equipment equipment, String langCode,String langValue);
	
	public Map<String, Object> equipmentInfo(Vequipment equipment);
	//解绑
	public Map<String, Object> equipmentUnbund(Equipment equipment,
			String langCode, String langValue);

	public Map<String, Object> noticeequipmentAdd(Noticeequipment equipment,
			String langCode, String langValue);

	public Map<String, Object> noticeequipmentEdit(
			Noticeequipment noticeEqupment, String langCode, String langValue);

	public Map<String, Object> noticeequipmentDelete(
			Noticeequipment noticeEqupment, String langCode, String langValue);
	


}
