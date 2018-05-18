package com.icomp.common.service.icomp.v01b06.s008;

import com.icomp.entity.base.CapitalTakes;
import com.icomp.entity.base.Vprice;

import java.util.Map;

/**
 * 刀具资金占用情况分析SERVICES接口
 * @ClassName: ICOMPV01B03S005Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:42:36
 */
public interface ICOMPV01B06S008Service {
/**
 * 刀具资金占用情况分析
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

public Map<String, Object> getList(Vprice entity,String langCode);
	public Map<String, Object> getLists(CapitalTakes entity, String langCode);
	/**
	 * 刀具资金占用情况分析统计
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * String
	 */
	public String getStatisticalCount(CapitalTakes entity);


	String getNumber();
}
