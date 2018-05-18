/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/16 13:06:15
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VpurchasingorderDao;
import com.icomp.entity.base.Vpurchasingorder;

/**
 * VpurchasingorderDao实现类
 * 
 * @author 工具自动生成 生成时间 : 2014/09/16 13:06:15
 */
@SuppressWarnings("unchecked")
public class VpurchasingorderDaoImpl implements VpurchasingorderDao {

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
				"Vpurchasingorder.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * 
	 * @param entity
	 *            查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vpurchasingorder> searchByList(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Vpurchasingorder>) dataSource.queryForList(
				"Vpurchasingorder.searchByList", entity);
	}

	/**
	 * 按任意查询
	 * 
	 * @param entity  查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vpurchasingorder> searchByList_new(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (List<Vpurchasingorder>) dataSource.queryForList(
				"Vpurchasingorder.searchByList_new", entity);
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
	public Vpurchasingorder searchByPrimaryKey(BaseEntity entity)
			throws SQLException {
		// 按任意查询
		return (Vpurchasingorder) dataSource.queryForObject(
				"Vpurchasingorder.searchByPrimaryKey", entity);
	}

}
