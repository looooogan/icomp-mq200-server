/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/13 16:41:39
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VprocessingtoolsDao;
import com.icomp.entity.base.Vprocessingtools;

/**
 * VprocessingtoolsDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/13 16:41:39
 */
public class VprocessingtoolsDaoImpl implements VprocessingtoolsDao{

	/* 数据源 */
	private SqlMapClient dataSource;
	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vprocessingtools.searchByCount", entity);
	}
	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount_F(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vprocessingtools.searchByCount_F", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vprocessingtools> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocessingtools>)dataSource.queryForList("Vprocessingtools.searchByList", entity);
	}
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 	@SuppressWarnings("unchecked")
	@Override
	public List<Vprocessingtools> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocessingtools>)dataSource.queryForList("Vprocessingtools.searchByList_F", entity);
	}
	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vprocessingtools searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vprocessingtools)dataSource.queryForObject("Vprocessingtools.searchByPrimaryKey", entity);
	}

}

