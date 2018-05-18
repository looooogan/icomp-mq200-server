/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/21 17:07:36
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VanalysisabnormalprocessingDao;
import com.icomp.entity.base.Vanalysisabnormalprocessing;

/**
 * VanalysisabnormalprocessingDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/21 17:07:36
 */
@SuppressWarnings("unchecked")
public class VanalysisabnormalprocessingDaoImpl implements VanalysisabnormalprocessingDao{

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
		return (Integer)dataSource.queryForObject("Vanalysisabnormalprocessing.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vanalysisabnormalprocessing> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vanalysisabnormalprocessing>)dataSource.queryForList("Vanalysisabnormalprocessing.searchByList", entity);
	}
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vanalysisabnormalprocessing> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-SynthesisParametersCode模糊查询
		return (List<Vanalysisabnormalprocessing>)dataSource.queryForList("Vanalysisabnormalprocessing.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vanalysisabnormalprocessing searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vanalysisabnormalprocessing)dataSource.queryForObject("Vanalysisabnormalprocessing.searchByPrimaryKey", entity);
	}
	/**
	 * 加工异常分析统计数量
	 */
	@Override
	public List<Vanalysisabnormalprocessing> getStatisticalCount(BaseEntity entity) throws SQLException {
		return (List<Vanalysisabnormalprocessing>)dataSource.queryForList("Vanalysisabnormalprocessing.getStatisticalCount", entity);
	}

}

