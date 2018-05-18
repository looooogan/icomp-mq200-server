/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/11 14:14:14
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VrepairticketDao;
import com.icomp.entity.base.Vrepairticket;

/**
 * VrepairticketDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/11 14:14:14
 */
public class VrepairticketDaoImpl implements VrepairticketDao{

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
		return (Integer)dataSource.queryForObject("Vrepairticket.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vrepairticket> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vrepairticket>)dataSource.queryForList("Vrepairticket.searchByList", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vrepairticket> searchByList_new(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vrepairticket>)dataSource.queryForList("Vrepairticket.searchByList_new", entity);
	}
	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vrepairticket searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vrepairticket)dataSource.queryForObject("Vrepairticket.searchByPrimaryKey", entity);
	}

}

