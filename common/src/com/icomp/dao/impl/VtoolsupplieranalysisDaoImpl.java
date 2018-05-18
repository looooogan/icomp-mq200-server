/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/21 17:07:37
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolsupplieranalysisDao;
import com.icomp.entity.base.Vtoolsupplieranalysis;

/**
 * VtoolsupplieranalysisDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/21 17:07:37
 */
public class VtoolsupplieranalysisDaoImpl implements VtoolsupplieranalysisDao{

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
		return (Integer)dataSource.queryForObject("Vtoolsupplieranalysis.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoolsupplieranalysis> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolsupplieranalysis>)dataSource.queryForList("Vtoolsupplieranalysis.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolsupplieranalysis searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolsupplieranalysis)dataSource.queryForObject("Vtoolsupplieranalysis.searchByPrimaryKey", entity);
	}
	/**
	 * 刀具供应商分析统计数量
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolsupplieranalysis> getStatisticalCount(BaseEntity entity) throws SQLException {
		 return (List<Vtoolsupplieranalysis>)dataSource.queryForList("Vtoolsupplieranalysis.getStatisticalCount", entity);
	}

}

