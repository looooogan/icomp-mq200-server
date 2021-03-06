/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/11/13 14:08:26
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VstockingDao;
import com.icomp.entity.base.Vstocking;

/**
 * VstockingDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/11/13 14:08:26
 */
@SuppressWarnings("unchecked")
public class VstockingDaoImpl implements VstockingDao{

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
	public int searchByCount_F(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vstocking.searchByCount_F", entity);
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
		return (Integer)dataSource.queryForObject("Vstocking.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vstocking> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vstocking>)dataSource.queryForList("Vstocking.searchByList", entity);
	}
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	
	@Override
	public List<Vstocking> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-ToolCode模糊查询
		return (List<Vstocking>)dataSource.queryForList("Vstocking.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vstocking searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vstocking)dataSource.queryForObject("Vstocking.searchByPrimaryKey", entity);
	}

}

