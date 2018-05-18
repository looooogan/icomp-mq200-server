/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/20 15:29:43
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetredemptionappdetailedmsgDao;
import com.icomp.entity.base.Vgetredemptionappdetailedmsg;

/**
 * VgetredemptionappdetailedmsgDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/20 15:29:43
 */
public class VgetredemptionappdetailedmsgDaoImpl implements VgetredemptionappdetailedmsgDao{

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
		return (Integer)dataSource.queryForObject("Vgetredemptionappdetailedmsg.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetredemptionappdetailedmsg> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetredemptionappdetailedmsg>)dataSource.queryForList("Vgetredemptionappdetailedmsg.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetredemptionappdetailedmsg searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetredemptionappdetailedmsg)dataSource.queryForObject("Vgetredemptionappdetailedmsg.searchByPrimaryKey", entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vgetredemptionappdetailedmsg> searchListByRold(Map<String, Object> map) throws SQLException {
		// 按任意查询
		return (List<Vgetredemptionappdetailedmsg>)dataSource.queryForList("Vgetredemptionappdetailedmsg.searchListByRold", map);
	}

}

