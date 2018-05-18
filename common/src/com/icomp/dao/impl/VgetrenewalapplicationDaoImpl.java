/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/30 15:17:34
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetrenewalapplicationDao;
import com.icomp.entity.base.Vgetrenewalapplication;

/**
 * VgetrenewalapplicationDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/30 15:17:34
 */
public class VgetrenewalapplicationDaoImpl implements VgetrenewalapplicationDao{

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
		return (Integer)dataSource.queryForObject("Vgetrenewalapplication.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetrenewalapplication> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetrenewalapplication>)dataSource.queryForList("Vgetrenewalapplication.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetrenewalapplication searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetrenewalapplication)dataSource.queryForObject("Vgetrenewalapplication.searchByPrimaryKey", entity);
	}

}

