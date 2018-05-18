/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/08/15 14:40:51
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolshertoolDao;
import com.icomp.entity.base.Vtoolshertool;

import java.sql.SQLException;
import java.util.List;

/**
 * VtoolshertoolDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/08/15 14:40:51
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VtoolshertoolDaoImpl implements VtoolshertoolDao {

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
		return (Integer)dataSource.queryForObject("Vtoolshertool.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoolshertool> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolshertool>)dataSource.queryForList("Vtoolshertool.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoolshertool searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolshertool)dataSource.queryForObject("Vtoolshertool.searchByPrimaryKey", entity);
	}

}

