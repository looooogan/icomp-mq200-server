/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014-08-21 16:24:03
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VdeptDao;
import com.icomp.entity.base.Vdept;

/**
 * VdeptDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014-08-21 16:24:03
 */
@SuppressWarnings("unchecked")
public class VdeptDaoImpl implements VdeptDao{

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
		return (Integer)dataSource.queryForObject("Vdept.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vdept> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vdept>)dataSource.queryForList("Vdept.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vdept searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vdept)dataSource.queryForObject("Vdept.searchByPrimaryKey", entity);
	}

}

