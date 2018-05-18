/*
 * 工具自动生成：系统-功能DAO实现类
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;

import com.icomp.dao.CapitalTakesDao;
import com.icomp.entity.base.CapitalTakes;
import com.icomp.entity.base.Customer;


import java.sql.SQLException;
import java.util.List;

/**
 * SclinkDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/11 15:35:17
 */
public class CapitalTakesDaoImpl implements CapitalTakesDao{


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
		return (Integer)dataSource.queryForObject("CapitalTakes.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")

	public List<CapitalTakes> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<CapitalTakes>)dataSource.queryForList("CapitalTakes.searchByList", entity);
	}
	@Override
	public BaseEntity searchByPrimaryKey(BaseEntity entity) throws SQLException {
		return null;
	}


	@Override
	public Object insert(BaseEntity entity) throws SQLException {
		return null;
	}

	@Override
	public int delete(BaseEntity entity) throws SQLException {
		return 0;
	}

	@Override
	public int update(BaseEntity entity) throws SQLException {
		return 0;
	}

	@Override
	public int updateNonQuery(BaseEntity entity) throws SQLException {
		return 0;
	}

	@Override
	public int updateBatch(List<? extends BaseEntity> list) throws SQLException {
		return 0;
	}

	@Override
	public int updateNonQueryBatch(List<? extends BaseEntity> list) throws SQLException {
		return 0;
	}

	@Override
	public int insertBatch(List<? extends BaseEntity> list) throws SQLException {
		return 0;
	}


}

