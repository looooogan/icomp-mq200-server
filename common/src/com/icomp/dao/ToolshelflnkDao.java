/*
 * 工具自动生成：工具盘位置信息DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import java.util.List;
import java.util.Map;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toolshelflnk;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface ToolshelflnkDao extends BaseDao{

	 public int updateNonQuerys(Toolshelflnk tf)throws Exception;
	 
	 /**
	  * 根据工具盘ID查询对应的位置（不等于空）
	  * @title searchListByToolId 
	  * @param entity
	  * @throws Exception
	  * void
	  */
	 public List<Toolshelflnk> searchListByToolId(Toolshelflnk entity)throws Exception;
	 /**
	  * 根据工具盘id的入库编码清空工具盘中的入库编码
	  * @title updateKiCodeISNull 
	  * @param map
	  * @param toolPanId :工具盘id
	  * @param list :刀具入库编码list
	  * @return
	  * @throws Exception
	  * int
	  */
	public int updateKiCodeISNull(Map<String, Object> map) throws Exception;

}

