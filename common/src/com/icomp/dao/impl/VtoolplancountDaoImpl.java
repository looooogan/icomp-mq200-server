/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/11/22 13:55:41
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolplancountDao;
import com.icomp.entity.base.Vtoolplancount;

/**
 * VtoolplancountDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/11/22 13:55:41
 */
public class VtoolplancountDaoImpl implements VtoolplancountDao{

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
		return (Integer)dataSource.queryForObject("Vtoolplancount.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoolplancount> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolplancount>)dataSource.queryForList("Vtoolplancount.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolplancount searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolplancount)dataSource.queryForObject("Vtoolplancount.searchByPrimaryKey", entity);
	}

}

