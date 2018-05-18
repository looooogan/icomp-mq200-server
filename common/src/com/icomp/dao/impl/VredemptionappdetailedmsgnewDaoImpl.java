/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2015/03/09 14:13:27
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VredemptionappdetailedmsgnewDao;
import com.icomp.entity.base.Vredemptionappdetailedmsgnew;

import java.sql.SQLException;
import java.util.List;

/**
 * VredemptionappdetailedmsgnewDao实现类
 * @author 工具自动生成
 * 生成时间    : 2015/03/09 14:13:27
 */
public class VredemptionappdetailedmsgnewDaoImpl implements VredemptionappdetailedmsgnewDao{

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
		return (Integer)dataSource.queryForObject("Vredemptionappdetailedmsgnew.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vredemptionappdetailedmsgnew> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vredemptionappdetailedmsgnew>)dataSource.queryForList("Vredemptionappdetailedmsgnew.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vredemptionappdetailedmsgnew searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vredemptionappdetailedmsgnew)dataSource.queryForObject("Vredemptionappdetailedmsgnew.searchByPrimaryKey", entity);
	}

}

