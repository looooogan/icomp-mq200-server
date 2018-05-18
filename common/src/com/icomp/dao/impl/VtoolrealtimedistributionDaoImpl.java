/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/21 17:07:37
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolrealtimedistributionDao;
import com.icomp.entity.base.Vtoolrealtimedistribution;

/**
 * VtoolrealtimedistributionDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/21 17:07:37
 */

@SuppressWarnings("unchecked")
public class VtoolrealtimedistributionDaoImpl implements VtoolrealtimedistributionDao{

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
		return (Integer)dataSource.queryForObject("Vtoolrealtimedistribution.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vtoolrealtimedistribution> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolrealtimedistribution>)dataSource.queryForList("Vtoolrealtimedistribution.searchByList", entity);
	}
	/**
	 * 任意条件查询-toolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	
	@Override
	public List<Vtoolrealtimedistribution> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolrealtimedistribution>)dataSource.queryForList("Vtoolrealtimedistribution.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolrealtimedistribution searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolrealtimedistribution)dataSource.queryForObject("Vtoolrealtimedistribution.searchByPrimaryKey", entity);
	}

}

