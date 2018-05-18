/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/12/03 15:37:51
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolshelfDao;
import com.icomp.entity.base.Vtoolshelf;

/**
 * VtoolshelfDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/12/03 15:37:51
 */
public class VtoolshelfDaoImpl implements VtoolshelfDao{

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
		return (Integer)dataSource.queryForObject("Vtoolshelf.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoolshelf> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolshelf>)dataSource.queryForList("Vtoolshelf.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vtoolshelf searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolshelf)dataSource.queryForObject("Vtoolshelf.searchByPrimaryKey", entity);
	}

}

