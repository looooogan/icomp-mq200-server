package com.icomp.common.service.icomp.v01c01.s021;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Toolrepairnotice;
import com.icomp.entity.base.Vgettoolcodeandnumberbyid;

/**
 * 修复通知领取-Service接口
 * @ClassName: ICOMPV01C01S021Service 
 * @author Taoyy
 * @date 2014-10-30 上午10:26:14
 */
public interface ICOMPV01C01S021Service {
	/**
	 * 取得修复通知单列表
	 * @title getToolRepairNoticeList 
	 * @param entity
	 * @return
	 * List<Toolrepairnotice>
	 */
	public List<Toolrepairnotice> getToolRepairNoticeList(Toolrepairnotice entity)throws Exception;
	/**
	 * 取得修复通知单下的刀具信息
	 * @title getToolList 
	 * @param entity
	 * @return
	 * @throws Exception
	 * List<Vgettoolcodeandnumberbyid>
	 */
	public List<Vgettoolcodeandnumberbyid> getToolList(Vgettoolcodeandnumberbyid entity)throws Exception;
	/**
	 * 保存修复通知单领取
	 * @title saveToolRepairNoticeReceive 
	 * @param map
	 * @return
	 * @throws Exception
	 * int
	 */
	public int saveToolRepairNoticeReceive(Map<String, Object> map)throws Exception;
}
