/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/05/09 17:49:35
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VoutsidefactoryDao;
import com.icomp.entity.base.Voutsidefactory;

import java.sql.SQLException;
import java.util.List;

/**
 * VoutsidefactoryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/05/09 17:49:35
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VoutsidefactoryDaoImpl implements VoutsidefactoryDao{

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
		return (Integer)dataSource.queryForObject("Voutsidefactory.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Voutsidefactory> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Voutsidefactory>)dataSource.queryForList("Voutsidefactory.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Voutsidefactory searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Voutsidefactory)dataSource.queryForObject("Voutsidefactory.searchByPrimaryKey", entity);
	}

}

