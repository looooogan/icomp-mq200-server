/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/11/10 14:40:47
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VreplacesynthesisDao;
import com.icomp.entity.base.Vreplacesynthesis;

/**
 * VreplacesynthesisDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/11/10 14:40:47
 */
public class VreplacesynthesisDaoImpl implements VreplacesynthesisDao{

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
		return (Integer)dataSource.queryForObject("Vreplacesynthesis.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vreplacesynthesis> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vreplacesynthesis>)dataSource.queryForList("Vreplacesynthesis.searchByList", entity);
	}
	/**
	 * 按任意查询--SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vreplacesynthesis> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询--SynthesisParametersCode模糊查询
		return (List<Vreplacesynthesis>)dataSource.queryForList("Vreplacesynthesis.searchByList_F", entity);
	}
	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vreplacesynthesis searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vreplacesynthesis)dataSource.queryForObject("Vreplacesynthesis.searchByPrimaryKey", entity);
	}

}

