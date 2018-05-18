package com.icomp.common.service.icomp.v01b06.s003;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Procurementplans;

/**
 *  建议采购计划SERVICE接口
 * @ClassName: ICOMPV01B06S003Service 
 * @author Taoyy
 * @date 2014-9-9 上午10:01:07
 */
 

public interface ICOMPV01B06S003Service {
	/**
	 * 建议采购计划
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */

	public Map<String, Object> getList(Map<String, Object> param,String langCode, String langValue);

	/**
	 * 取得页面grid显示项目列表
	 * @title getGridColmun 
	 * @param pageID
	 * @param lang
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getGridColmun(String pageID, String lang);
	/**
	 *  批量增加建议采购计划
	 * @title saveAll 
	 * @param list
	 * @param lang
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> saveAll(List<Procurementplans> list, String langCode,String langValue);
	

}
