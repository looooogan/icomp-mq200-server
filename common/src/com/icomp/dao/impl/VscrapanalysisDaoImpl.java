/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/21 17:07:37
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VscrapanalysisDao;
import com.icomp.entity.base.Vscrapanalysis;

/**
 * VscrapanalysisDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/21 17:07:37
 */
@SuppressWarnings("unchecked")
public class VscrapanalysisDaoImpl implements VscrapanalysisDao{

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
		return (Integer)dataSource.queryForObject("Vscrapanalysis.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vscrapanalysis> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vscrapanalysis>)dataSource.queryForList("Vscrapanalysis.searchByList", entity);
	}
	/**
	 * 按任意查询ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vscrapanalysis> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-ToolCode模糊查询
		return (List<Vscrapanalysis>)dataSource.queryForList("Vscrapanalysis.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vscrapanalysis searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vscrapanalysis)dataSource.queryForObject("Vscrapanalysis.searchByPrimaryKey", entity);
	}

	@Override
	/**
	 * 报废分析统计数量
	 */
	public List<Vscrapanalysis> getStatisticalCount(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vscrapanalysis>)dataSource.queryForList("Vscrapanalysis.searchByList", entity);
	}

}

