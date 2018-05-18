/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/28 13:46:11
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VqualityinspectionDao;
import com.icomp.entity.base.Vqualityinspection;

/**
 * VqualityinspectionDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/28 13:46:11
 */
@SuppressWarnings("unchecked")
public class VqualityinspectionDaoImpl implements VqualityinspectionDao{

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
		return (Integer)dataSource.queryForObject("Vqualityinspection.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vqualityinspection> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vqualityinspection>)dataSource.queryForList("Vqualityinspection.searchByList", entity);
	}
	
	 /**
	  * 按任意查询--ToolCode模糊查询
	  * @param entity 查询条件
	  * @return 查询结果
	  * @throws SQLException
	  */
	 @Override
	 public List<Vqualityinspection> searchByList_F(BaseEntity entity) throws SQLException {
		 // 按任意查询
		 return (List<Vqualityinspection>)dataSource.queryForList("Vqualityinspection.searchByList_F", entity);
	 }

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vqualityinspection searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vqualityinspection)dataSource.queryForObject("Vqualityinspection.searchByPrimaryKey", entity);
	}

}

