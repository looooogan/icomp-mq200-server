/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/13 19:17:16
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VstockinglistDao;
import com.icomp.entity.base.Vstockinglist;

/**
 * VstockinglistDao实现类
 * 
 * @author 工具自动生成 生成时间 : 2014/10/13 19:17:16
 */
public class VstockinglistDaoImpl implements VstockinglistDao {

	/* 数据源 */
	private SqlMapClient dataSource;

	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 查询数据条数
	 * 
	 * @param entity
	 *            查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer) dataSource.queryForObject(
				"Vstockinglist.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * 
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vstockinglist> searchByStockingList(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Vstockinglist>) dataSource.queryForList(
				"Vstockinglist.searchByStockingList", entity);
	}

	/**
	 * 按任意查询
	 * 
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vstockinglist> searchByStockingToolList(List<String> rfidS)
			throws SQLException {
		// 按任意查询
		return (List<Vstockinglist>) dataSource.queryForList(
				"Vstockinglist.searchByStockingToolList", rfidS);
	}
	

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<?> searchByOldToolList(List<String> rfidS) throws SQLException {
		// 按任意查询
		return (List<Vstockinglist>) dataSource.queryForList(
				"Vstockinglist.searchByOldToolList", rfidS);
	}
	
	/**
	 * 按任意查询
	 * 
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vstockinglist> searchByList(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Vstockinglist>) dataSource.queryForList(
				"Vstockinglist.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * 
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vstockinglist searchByPrimaryKey(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (Vstockinglist) dataSource.queryForObject(
				"Vstockinglist.searchByPrimaryKey", entity);
	}

}
