/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/21 17:07:36
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VanalysistoolfundsDao;
import com.icomp.entity.base.Vanalysistoolfunds;

/**
 * VanalysistoolfundsDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/21 17:07:36
 */
public class VanalysistoolfundsDaoImpl implements VanalysistoolfundsDao{

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
		return (Integer)dataSource.queryForObject("Vanalysistoolfunds.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vanalysistoolfunds> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vanalysistoolfunds>)dataSource.queryForList("Vanalysistoolfunds.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vanalysistoolfunds searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vanalysistoolfunds)dataSource.queryForObject("Vanalysistoolfunds.searchByPrimaryKey", entity);
	}
	/**
	 * 获取各种状态的残值金额
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vanalysistoolfunds> getStatisticalCount(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vanalysistoolfunds>)dataSource.queryForList("Vanalysistoolfunds.getStatisticalCount", entity);
	}

}

