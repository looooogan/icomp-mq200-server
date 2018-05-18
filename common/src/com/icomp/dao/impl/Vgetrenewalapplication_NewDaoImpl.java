/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/12/08 10:06:15
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.Vgetrenewalapplication_NewDao;
import com.icomp.entity.base.Vgetrenewalapplication_New;

/**
 * Vgetrenewalapplication_NewDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/12/08 10:06:15
 */
public class Vgetrenewalapplication_NewDaoImpl implements Vgetrenewalapplication_NewDao{

	/* 数据源 */
	private SqlMapClient dataSource;
	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws java.sql.SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vgetrenewalapplication_New.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetrenewalapplication_New> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetrenewalapplication_New>)dataSource.queryForList("Vgetrenewalapplication_New.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vgetrenewalapplication_New searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetrenewalapplication_New)dataSource.queryForObject("Vgetrenewalapplication_New.searchByPrimaryKey", entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vgetrenewalapplication_New> searchHotByList(Vgetrenewalapplication_New entity) throws Exception {
		// 热套刀具申请 
		return dataSource.queryForList("Vgetrenewalapplication_New.searchHotByList", entity);
	}

}

