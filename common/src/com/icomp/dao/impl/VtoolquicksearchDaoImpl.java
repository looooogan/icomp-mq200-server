/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/14 17:53:20
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolquicksearchDao;
import com.icomp.entity.base.Vtoolquicksearch;

/**
 * VtoolquicksearchDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/14 17:53:20
 */
public class VtoolquicksearchDaoImpl implements VtoolquicksearchDao{

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
		return (Integer)dataSource.queryForObject("Vtoolquicksearch.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolquicksearch> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolquicksearch>)dataSource.queryForList("Vtoolquicksearch.searchByList", entity);
	}
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolquicksearch> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolquicksearch>)dataSource.queryForList("Vtoolquicksearch.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolquicksearch searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolquicksearch)dataSource.queryForObject("Vtoolquicksearch.searchByPrimaryKey", entity);
	}

}

