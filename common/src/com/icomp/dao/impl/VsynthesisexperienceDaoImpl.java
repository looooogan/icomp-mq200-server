/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/27 11:08:19
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VsynthesisexperienceDao;
import com.icomp.entity.base.Vsynthesisexperience;

/**
 * VsynthesisexperienceDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/27 11:08:19
 */
public class VsynthesisexperienceDaoImpl implements VsynthesisexperienceDao{

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
		return (Integer)dataSource.queryForObject("Vsynthesisexperience.searchByCount", entity);
	}
	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount_F(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vsynthesisexperience.searchByCount_F", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vsynthesisexperience> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vsynthesisexperience>)dataSource.queryForList("Vsynthesisexperience.searchByList", entity);
	}
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vsynthesisexperience> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-SynthesisParametersCode模糊查询
		return (List<Vsynthesisexperience>)dataSource.queryForList("Vsynthesisexperience.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vsynthesisexperience searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vsynthesisexperience)dataSource.queryForObject("Vsynthesisexperience.searchByPrimaryKey", entity);
	}

}

