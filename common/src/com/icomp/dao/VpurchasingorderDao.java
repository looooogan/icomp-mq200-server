/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/16 13:06:15
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vpurchasingorder;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VpurchasingorderDao extends BaseViewDao{

	/** 
	
	* @Title: searchByList_new 
	
	* @Description:(这里用一句话描述这个方法的作用)
	
	* @param @param entity
	* @param @return
	* @param @throws SQLException    设定文件 
	
	* @return List<Vpurchasingorder>    返回类型 
	
	* @throws 
	
	*/ 
	
	List<Vpurchasingorder> searchByList_new(BaseEntity entity)
			throws SQLException;

}

