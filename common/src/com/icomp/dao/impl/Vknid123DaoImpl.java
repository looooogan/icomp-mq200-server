/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/02/15 18:57:18
 */
package com.icomp.dao.impl;

import java.sql.SQLException;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.Vknid123Dao;
import  com.icomp.entity.base.Vknid123;

/**
 * Vknid123Dao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/02/15 18:57:18
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class Vknid123DaoImpl implements Vknid123Dao{

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

	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vknid123.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")

	public List<Vknid123> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vknid123>)dataSource.queryForList("Vknid123.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	public Vknid123 searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vknid123)dataSource.queryForObject("Vknid123.searchByPrimaryKey", entity);
	}

}

