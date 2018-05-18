/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/02 17:23:45
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VconsumptiontoolDao;
import com.icomp.entity.base.Vconsumptiontool;

/**
 * VconsumptiontoolDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/02 17:23:45
 */
@SuppressWarnings("unchecked")
public class VconsumptiontoolDaoImpl implements VconsumptiontoolDao{

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
		return (Integer)dataSource.queryForObject("Vconsumptiontool.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vconsumptiontool> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vconsumptiontool>)dataSource.queryForList("Vconsumptiontool.searchByList", entity);
	}
	
	/**
	 * 任意条件查询-toolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vconsumptiontool> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vconsumptiontool>)dataSource.queryForList("Vconsumptiontool.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vconsumptiontool searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vconsumptiontool)dataSource.queryForObject("Vconsumptiontool.searchByPrimaryKey", entity);
	}
	/**
	 * 刀具消耗量分析统计
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vconsumptiontool> getStatisticalCount(BaseEntity entity) throws SQLException {
		return (List<Vconsumptiontool>)dataSource.queryForList("Vconsumptiontool.getStatisticalCount", entity);
	}

}

