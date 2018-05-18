/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/18 14:39:25
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.VgetcustomerinfoDao;
import  com.icomp.entity.base.Vgetcustomerinfo;

/**
 * VgetcustomerinfoDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/18 14:39:25
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VgetcustomerinfoDaoImpl implements VgetcustomerinfoDao{

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
		return (Integer)dataSource.queryForObject("Vgetcustomerinfo.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetcustomerinfo> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetcustomerinfo>)dataSource.queryForList("Vgetcustomerinfo.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetcustomerinfo searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetcustomerinfo)dataSource.queryForObject("Vgetcustomerinfo.searchByPrimaryKey", entity);
	}

	@Override
	public Vgetcustomerinfo findMemberMsgByCard(Vgetcustomerinfo vgetcustomerinfo) throws SQLException {
		// 按任意查询
		return (Vgetcustomerinfo)dataSource.queryForObject("Vgetcustomerinfo.searchByList", vgetcustomerinfo);
	}
}

