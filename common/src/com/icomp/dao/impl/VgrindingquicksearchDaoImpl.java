/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2015/07/01 10:59:08
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgrindingquicksearchDao;
import com.icomp.entity.base.Vgrindingquicksearch;

import java.sql.SQLException;
import java.util.List;

/**
 * VgrindingquicksearchDao实现类
 * @author 工具自动生成
 * 生成时间    : 2015/07/01 10:59:08
 */
public class VgrindingquicksearchDaoImpl implements VgrindingquicksearchDao{

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
		return (Integer)dataSource.queryForObject("Vgrindingquicksearch.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgrindingquicksearch> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgrindingquicksearch>)dataSource.queryForList("Vgrindingquicksearch.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgrindingquicksearch searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgrindingquicksearch)dataSource.queryForObject("Vgrindingquicksearch.searchByPrimaryKey", entity);
	}

}

