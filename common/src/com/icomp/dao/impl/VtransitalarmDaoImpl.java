/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/14 09:21:43
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtransitalarmDao;
import com.icomp.entity.base.Vtransitalarm;

/**
 * VtransitalarmDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/14 09:21:43
 */
public class VtransitalarmDaoImpl implements VtransitalarmDao{

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
		return (Integer)dataSource.queryForObject("Vtransitalarm.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtransitalarm> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtransitalarm>)dataSource.queryForList("Vtransitalarm.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtransitalarm searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtransitalarm)dataSource.queryForObject("Vtransitalarm.searchByPrimaryKey", entity);
	}

}

