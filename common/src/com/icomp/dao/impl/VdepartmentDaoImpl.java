/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/11 17:40:48
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VdepartmentDao;
import com.icomp.entity.base.Vdepartment;

/**
 * VdepartmentDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/11 17:40:48
 */
public class VdepartmentDaoImpl implements VdepartmentDao{

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
		return (Integer)dataSource.queryForObject("Vdepartment.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vdepartment> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vdepartment>)dataSource.queryForList("Vdepartment.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vdepartment searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vdepartment)dataSource.queryForObject("Vdepartment.searchByPrimaryKey", entity);
	}

}
