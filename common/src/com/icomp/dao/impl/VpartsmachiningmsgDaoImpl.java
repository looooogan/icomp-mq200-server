/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/06/13 16:54:39
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VpartsmachiningmsgDao;
import com.icomp.entity.base.Vpartsmachiningmsg;

import java.sql.SQLException;
import java.util.List;

/**
 * VpartsmachiningmsgDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/06/13 16:54:39
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VpartsmachiningmsgDaoImpl implements VpartsmachiningmsgDao{

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
		return (Integer)dataSource.queryForObject("Vpartsmachiningmsg.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vpartsmachiningmsg> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vpartsmachiningmsg>)dataSource.queryForList("Vpartsmachiningmsg.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vpartsmachiningmsg searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vpartsmachiningmsg)dataSource.queryForObject("Vpartsmachiningmsg.searchByPrimaryKey", entity);
	}

	@Override
	public List<Vpartsmachiningmsg> searchListByTime(Vpartsmachiningmsg entity) throws SQLException {
		// 按时间和零部件查询
		return (List<Vpartsmachiningmsg>)dataSource.queryForList("Vpartsmachiningmsg.searchListByTime", entity);
	}

	@Override
	public int searchByCount1(Vpartsmachiningmsg entity) throws SQLException {
		return (Integer)dataSource.queryForObject("Vpartsmachiningmsg.searchByCount1", entity);
	}
}

