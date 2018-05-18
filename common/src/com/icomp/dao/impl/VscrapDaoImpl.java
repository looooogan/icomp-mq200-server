/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/25 14:35:22
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.VscrapDao;
import  com.icomp.entity.base.Vscrap;

/**
 * VscrapDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/25 14:35:22
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VscrapDaoImpl implements VscrapDao{

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
		return (Integer)dataSource.queryForObject("Vscrap.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vscrap> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vscrap>)dataSource.queryForList("Vscrap.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vscrap searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vscrap)dataSource.queryForObject("Vscrap.searchByPrimaryKey", entity);
	}

}

