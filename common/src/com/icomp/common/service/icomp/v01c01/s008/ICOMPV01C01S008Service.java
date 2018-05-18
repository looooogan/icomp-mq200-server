package com.icomp.common.service.icomp.v01c01.s008;

import com.icomp.entity.base.Vgetsynthesistooldownmsg;
import com.icomp.entity.base.Vgetsynthesistoolinfo;
import com.icomp.entity.base.Vgettoolshelfmessage;
import com.icomp.entity.base.Vtoolplatemessagelist;

import java.util.List;
import java.util.Map;

/**
 * 封存刀具-Services接口
 * @ClassName: ICOMPV01C01S008Service 
 * @author Taoyy
 * @date 2014-9-25 下午07:00:40
 */
public interface ICOMPV01C01S008Service {
	/**
	 * 取得合成卸下刀具信息
	 * @title getSynthesisToolInfo 
	 * @param map
	 * @return
	 * List<Vgetsynthesistoolinfo>
	 */
	public List<Vgetsynthesistooldownmsg> getSynthesisToolInfo(Map<String, Object> map)throws Exception;
	/**
	 * 
	 * @title getSynthesisToolInfo 
	 * @param entity
	 * @return
	 * @throws Exception
	 * List<Vgetsynthesistooldownmsg>
	 */
	public List<Vgetsynthesistoolinfo> getSynthesisToolInfo(Vgetsynthesistoolinfo entity)throws Exception;
	
	/**
	 *  刀具装盒
	 * @title saveToolBox 
	 * @param map
	 * @return
	 * int
	 */
	 
	public int saveToolBox(Map<String, Object> map)throws Exception;
	/**
	 * 不合格刀具卸下提交
	 * @title saveBelow 
	 * @param map
	 * @return
	 * int
	 */
	public int saveBelow(Map<String, Object> map)throws Exception;
	/**
	 * 刀具装盘
	 * @title saveToolPlate 
	 * @param map
	 * @return
	 * int
	 */
	public int saveToolPlate(Map<String, Object> map)throws Exception;
	/**
	 * 合成刀具卸下提交
	 * @title synthesisUnloadSubmit 
	 * @param map
	 * @return
	 * @throws Exception
	 * int
	 */
	public int synthesisUnloadSubmit(Map<String, Object> map)throws Exception;
	/**
	 *  取得工具盘列表
	 * @title getToolShelfList 
	 * @param entity
	 * @return
	 * @throws Exception
	 * List<Vgettoolshelfmessage>
	 */
	public List<Vtoolplatemessagelist> getToolShelfList(Vgettoolshelfmessage entity)throws Exception;
	
}
