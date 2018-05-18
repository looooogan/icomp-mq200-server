/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/03 10:24:39
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.VoplinkDao;
import  com.icomp.entity.base.Voplink;

/**
 * VoplinkDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/03 10:24:39
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VoplinkDaoImpl implements VoplinkDao{

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
		return (Integer)dataSource.queryForObject("Voplink.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Voplink> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Voplink>)dataSource.queryForList("Voplink.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Voplink searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Voplink)dataSource.queryForObject("Voplink.searchByPrimaryKey", entity);
	}

}

