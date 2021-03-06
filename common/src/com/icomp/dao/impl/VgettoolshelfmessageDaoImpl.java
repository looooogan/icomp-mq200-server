/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/31 10:44:24
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgettoolshelfmessageDao;
import com.icomp.entity.base.Vgettoolshelfmessage;

/**
 * VgettoolshelfmessageDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/31 10:44:24
 */
public class VgettoolshelfmessageDaoImpl implements VgettoolshelfmessageDao{

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
		return (Integer)dataSource.queryForObject("Vgettoolshelfmessage.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgettoolshelfmessage> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgettoolshelfmessage>)dataSource.queryForList("Vgettoolshelfmessage.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgettoolshelfmessage searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgettoolshelfmessage)dataSource.queryForObject("Vgettoolshelfmessage.searchByPrimaryKey", entity);
	}

}

