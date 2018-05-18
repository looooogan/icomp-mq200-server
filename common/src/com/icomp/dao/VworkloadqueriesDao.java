/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/11/12 18:19:05
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vworkloadqueries;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VworkloadqueriesDao extends BaseViewDao{

	/** 
	
	* @Title: searchProcessNameByList 
	
	* @Description: (这里用一句话描述这个方法的作用)
	
	* @param @param entity
	* @param @return
	* @param @throws SQLException    设定文件 
	
	* @return List<Vworkloadqueries>    返回类型 
	
	* @throws 
	
	*/ 
	
	List<Vworkloadqueries> searchProcessNameByList(BaseEntity entity)
			throws SQLException;

	/** 
	
	* @Title: searchAssemblyLineNameByList 
	
	* @Description: (这里用一句话描述这个方法的作用)
	
	* @param @param entity
	* @param @return
	* @param @throws SQLException    设定文件 
	
	* @return List<Vworkloadqueries>    返回类型 
	
	* @throws 
	
	*/ 
	
	List<Vworkloadqueries> searchAssemblyLineNameByList(BaseEntity entity)
			throws SQLException;

}

