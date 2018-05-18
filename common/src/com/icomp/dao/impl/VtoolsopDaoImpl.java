/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/06/13 18:51:57
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolsopDao;
import com.icomp.entity.base.Vtoolsop;

import java.sql.SQLException;
import java.util.List;

/**
 * VtoolsopDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/06/13 18:51:57
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VtoolsopDaoImpl implements VtoolsopDao{

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
		return (Integer)dataSource.queryForObject("Vtoolsop.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoolsop> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolsop>)dataSource.queryForList("Vtoolsop.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolsop searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolsop)dataSource.queryForObject("Vtoolsop.searchByPrimaryKey", entity);
	}

	/**
	 * 数据更新
	 * @param entity 更新数据(未指定数据不更新)
	 * @return 影响条数
	 * @throws SQLException
	 */
	@Override
	public int updateNonQuery(Vtoolsop entity) throws SQLException {
		// 数据更新(未指定数据不更新)
		return dataSource.update("Vtoolsop.updateNonQuery", entity);
	}

}

