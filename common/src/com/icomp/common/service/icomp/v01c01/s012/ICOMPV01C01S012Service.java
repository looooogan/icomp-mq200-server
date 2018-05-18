package com.icomp.common.service.icomp.v01c01.s012;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Vgetbacktoolnamebyrfid;

/**
 * 设备安上-Service接口
 * @ClassName: ICOMPV01C01S012Service 
 * @author Taoyy
 * @date 2014-10-29 下午05:24:49
 */
public interface ICOMPV01C01S012Service {
	/**
	 * 根据合成刀具RFID取得待收回合成刀具信息
	 * @title getToolRecoveryInfo 
	 * @param entity
	 * @return
	 * List<Vgetbacktoolnamebyrfid>
	 */
	public List<Vgetbacktoolnamebyrfid> getToolRecoveryInfo(Vgetbacktoolnamebyrfid entity)throws Exception;
	/**
	 * 更新刀具为已回收状态
	 * @title saveToolRecovery 
	 * @param syList
	 * @return
	 * int
	 */
	public int saveToolRecovery(Map<String, Object> map)throws Exception;
}
