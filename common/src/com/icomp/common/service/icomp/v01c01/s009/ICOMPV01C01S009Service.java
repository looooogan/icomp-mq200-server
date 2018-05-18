package com.icomp.common.service.icomp.v01c01.s009;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Vgetbackworkshopmag;

/**
 * 刀具送回车间-Serviecs接口
 * @ClassName: ICOMPV01C01S009Service 
 * @author Taoyy
 * @date 2014-9-29 上午11:20:04
 */
public interface ICOMPV01C01S009Service {
	/**
	 * 取得待送回车间信息
	 * @title getBackWorkshopMag 
	 * @param entity
	 * @return
	 * List<Vgetbackworkshopmag>
	 */
	public List<Vgetbackworkshopmag> getBackWorkshopMag(Vgetbackworkshopmag entity)throws Exception;
	/**
	 * 根据合成刀具编码修改相应的合成刀库状态
	 * @title saveSynthesisToolInfo 
	 * @param map
	 * @return
	 * @throws Exception
	 * int
	 */
	public int saveSynthesisToolInfo(Map<String, Object> map)throws Exception;
}
