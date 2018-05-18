/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/20 14:52:19
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VprocessingabnormalalarmDao;
import com.icomp.entity.base.Vprocessingabnormalalarm;

/**
 * VprocessingabnormalalarmDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/20 14:52:19
 */
@SuppressWarnings("unchecked")
public class VprocessingabnormalalarmDaoImpl implements VprocessingabnormalalarmDao{

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
		return (Integer)dataSource.queryForObject("Vprocessingabnormalalarm.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vprocessingabnormalalarm> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocessingabnormalalarm>)dataSource.queryForList("Vprocessingabnormalalarm.searchByList", entity);
	}
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vprocessingabnormalalarm> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocessingabnormalalarm>)dataSource.queryForList("Vprocessingabnormalalarm.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vprocessingabnormalalarm searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vprocessingabnormalalarm)dataSource.queryForObject("Vprocessingabnormalalarm.searchByPrimaryKey", entity);
	}

	@Override
	public int searchByCount_F(Vprocessingabnormalalarm entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vprocessingabnormalalarm.searchByCount_F", entity);
	}


}

