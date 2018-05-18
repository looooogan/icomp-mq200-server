/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/12/19 11:14:12
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetpositioncapabilityDao;
import com.icomp.entity.base.Vgetpositioncapability;

/**
 * VgetpositioncapabilityDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/12/19 11:14:12
 */
public class VgetpositioncapabilityDaoImpl implements VgetpositioncapabilityDao{

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
		return (Integer)dataSource.queryForObject("Vgetpositioncapability.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetpositioncapability> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetpositioncapability>)dataSource.queryForList("Vgetpositioncapability.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vgetpositioncapability searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetpositioncapability)dataSource.queryForObject("Vgetpositioncapability.searchByPrimaryKey", entity);
	}

}

