/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/13 09:34:13
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VpositionsDao;
import com.icomp.entity.base.Vpositions;

/**
 * VpositionsDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/13 09:34:13
 */
public class VpositionsDaoImpl implements VpositionsDao{

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
		return (Integer)dataSource.queryForObject("Vpositions.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vpositions> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vpositions>)dataSource.queryForList("Vpositions.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vpositions searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vpositions)dataSource.queryForObject("Vpositions.searchByPrimaryKey", entity);
	}

}

