/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2015/01/04 17:34:49
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VprocessingquickqueryDao;
import com.icomp.entity.base.Vprocessingquickquery;

import java.sql.SQLException;
import java.util.List;

/**
 * VprocessingquickqueryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2015/01/04 17:34:49
 */
@SuppressWarnings("unchecked")
public class VprocessingquickqueryDaoImpl implements VprocessingquickqueryDao{

	/* 数据源 */
	private SqlMapClient dataSource;
	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws java.sql.SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vprocessingquickquery.searchByCount", entity);
	}
	
	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws java.sql.SQLException
	 */
	@Override
	public int searchByCount_B04S006(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vprocessingquickquery.searchByCount_B04S006", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */

	@Override
	public List<Vprocessingquickquery> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocessingquickquery>)dataSource.queryForList("Vprocessingquickquery.searchByList", entity);
	}
	
	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	
	@Override
	public List<Vprocessingquickquery> searchByList_B04S006(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocessingquickquery>)dataSource.queryForList("Vprocessingquickquery.searchByList_B04S006", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vprocessingquickquery searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vprocessingquickquery)dataSource.queryForObject("Vprocessingquickquery.searchByPrimaryKey", entity);
	}

}

