/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/28 12:06:53
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VbatchlistDao;
import com.icomp.entity.base.Vbatchlist;

/**
 * VbatchlistDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/28 12:06:53
 */
public class VbatchlistDaoImpl implements VbatchlistDao{

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
		return (Integer)dataSource.queryForObject("Vbatchlist.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vbatchlist> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vbatchlist>)dataSource.queryForList("Vbatchlist.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vbatchlist searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vbatchlist)dataSource.queryForObject("Vbatchlist.searchByPrimaryKey", entity);
	}

}

