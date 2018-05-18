/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/02/25 15:44:05
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;


import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.VtoolnoticehistoryDao;
import com.icomp.entity.base.Vtoolnoticehistory;


/**
 * VtoolnoticehistoryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/02/25 15:44:05
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VtoolnoticehistoryDaoImpl implements VtoolnoticehistoryDao{

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
		return (Integer)dataSource.queryForObject("Vtoolnoticehistory.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")

	public List<Vtoolnoticehistory> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolnoticehistory>)dataSource.queryForList("Vtoolnoticehistory.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	public Vtoolnoticehistory searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolnoticehistory)dataSource.queryForObject("Vtoolnoticehistory.searchByPrimaryKey", entity);
	}

}

