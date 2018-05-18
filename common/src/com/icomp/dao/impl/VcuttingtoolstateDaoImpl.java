/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/20 14:52:18
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VcuttingtoolstateDao;
import com.icomp.entity.base.Vcuttingtoolstate;

/**
 * VcuttingtoolstateDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/20 14:52:18
 */
@SuppressWarnings("unchecked")
public class VcuttingtoolstateDaoImpl implements VcuttingtoolstateDao{

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
		return (Integer)dataSource.queryForObject("Vcuttingtoolstate.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	@Override
	public List<Vcuttingtoolstate> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vcuttingtoolstate>)dataSource.queryForList("Vcuttingtoolstate.searchByList", entity);
	}
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vcuttingtoolstate> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vcuttingtoolstate>)dataSource.queryForList("Vcuttingtoolstate.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vcuttingtoolstate searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vcuttingtoolstate)dataSource.queryForObject("Vcuttingtoolstate.searchByPrimaryKey", entity);
	}

}

