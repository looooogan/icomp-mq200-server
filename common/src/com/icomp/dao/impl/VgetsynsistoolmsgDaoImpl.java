/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/26 16:53:46
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.VgetsynsistoolmsgDao;
import  com.icomp.entity.base.Vgetsynsistoolmsg;

/**
 * VgetsynsistoolmsgDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/26 16:53:46
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VgetsynsistoolmsgDaoImpl implements VgetsynsistoolmsgDao{

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
		return (Integer)dataSource.queryForObject("Vgetsynsistoolmsg.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetsynsistoolmsg> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetsynsistoolmsg>)dataSource.queryForList("Vgetsynsistoolmsg.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetsynsistoolmsg searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetsynsistoolmsg)dataSource.queryForObject("Vgetsynsistoolmsg.searchByPrimaryKey", entity);
	}

	@Override
	public List<Vgetsynsistoolmsg> getSynLocationMsg(Vgetsynsistoolmsg entity) throws Exception {
		// 按任意查询
		return (List<Vgetsynsistoolmsg>)dataSource.queryForList("Vgetsynsistoolmsg.searchByList", entity);
	}
}

