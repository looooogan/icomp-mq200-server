/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/10/13 19:17:16
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VstockinglistDao extends BaseViewDao{

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByStockingList(BaseEntity entity) throws SQLException;

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByOldToolList(List<String> rfidS) throws SQLException;
	
	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	public List<?> searchByStockingToolList(List<String> rfidS) throws SQLException;
}

