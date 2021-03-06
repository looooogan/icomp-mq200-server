/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/15 14:22:13
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetgrindingonmsgDao;
import com.icomp.entity.base.Vgetgrindingonmsg;

/**
 * VgetgrindingonmsgDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/15 14:22:13
 */
public class VgetgrindingonmsgDaoImpl implements VgetgrindingonmsgDao{

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
		return (Integer)dataSource.queryForObject("Vgetgrindingonmsg.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetgrindingonmsg> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetgrindingonmsg>)dataSource.queryForList("Vgetgrindingonmsg.searchByList", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 	@SuppressWarnings("unchecked")
	@Override
	public List<Vgetgrindingonmsg> searchByToolList(Map<String,Object> map) throws SQLException {
		// 按任意查询
		return (List<Vgetgrindingonmsg>)dataSource.queryForList("Vgetgrindingonmsg.searchByToolList", map);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetgrindingonmsg searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetgrindingonmsg)dataSource.queryForObject("Vgetgrindingonmsg.searchByPrimaryKey", entity);
	}

}

