/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/12 13:13:55
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VsuggestionpurchaseplanDao;
import com.icomp.entity.base.Vsuggestionpurchaseplan;

/**
 * VsuggestionpurchaseplanDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/12 13:13:55
 */
public class VsuggestionpurchaseplanDaoImpl implements VsuggestionpurchaseplanDao{

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
		return (Integer)dataSource.queryForObject("Vsuggestionpurchaseplan.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vsuggestionpurchaseplan> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vsuggestionpurchaseplan>)dataSource.queryForList("Vsuggestionpurchaseplan.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vsuggestionpurchaseplan searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vsuggestionpurchaseplan)dataSource.queryForObject("Vsuggestionpurchaseplan.searchByPrimaryKey", entity);
	}

}

