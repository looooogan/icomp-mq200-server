/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014-08-15 15:48:15
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolsettingDao;
import com.icomp.entity.base.Vtoolsetting;

/**
 * VtoolsettingDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014-08-15 15:48:15
 */
public class VtoolsettingDaoImpl implements VtoolsettingDao{

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
		return (Integer)dataSource.queryForObject("Vtoolsetting.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolsetting> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolsetting>)dataSource.queryForList("Vtoolsetting.searchByList", entity);
	}
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolsetting> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-SynthesisParametersCode模糊查询
		return (List<Vtoolsetting>)dataSource.queryForList("Vtoolsetting.searchByList_F", entity);
	}
 
	/**
	 * 分组，按任意条件查询执行 
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolsetting> searchByListWithGroup(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolsetting>)dataSource.queryForList("Vtoolsetting.searchByListWithGroup", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolsetting searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolsetting)dataSource.queryForObject("Vtoolsetting.searchByPrimaryKey", entity);
	}

}

