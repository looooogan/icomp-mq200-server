/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/11/24 15:52:33
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgrindingrecordDao;
import com.icomp.entity.base.Vgrindingrecord;

/**
 * VgrindingrecordDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/11/24 15:52:33
 */
@SuppressWarnings("unchecked")
public class VgrindingrecordDaoImpl implements VgrindingrecordDao{

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
		return (Integer)dataSource.queryForObject("Vgrindingrecord.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vgrindingrecord> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgrindingrecord>)dataSource.queryForList("Vgrindingrecord.searchByList", entity);
	}
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	
	@Override
	public List<Vgrindingrecord> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-ToolCode模糊查询
		return (List<Vgrindingrecord>)dataSource.queryForList("Vgrindingrecord.searchByList_F", entity);
	}
	
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	
	@Override
	public List<Vgrindingrecord> searchByList_b04s006(BaseEntity entity) throws SQLException {
		// 按任意查询-ToolCode模糊查询
		return (List<Vgrindingrecord>)dataSource.queryForList("Vgrindingrecord.searchByList_b04s006", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgrindingrecord searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgrindingrecord)dataSource.queryForObject("Vgrindingrecord.searchByPrimaryKey", entity);
	}

}

