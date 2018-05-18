/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/10/29 16:41:57
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetbacktoolnamebyrfidDao;
import com.icomp.entity.base.Vgetbacktoolnamebyrfid;

/**
 * VgetbacktoolnamebyrfidDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/10/29 16:41:57
 */
public class VgetbacktoolnamebyrfidDaoImpl implements VgetbacktoolnamebyrfidDao{

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
		return (Integer)dataSource.queryForObject("Vgetbacktoolnamebyrfid.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetbacktoolnamebyrfid> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetbacktoolnamebyrfid>)dataSource.queryForList("Vgetbacktoolnamebyrfid.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetbacktoolnamebyrfid searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetbacktoolnamebyrfid)dataSource.queryForObject("Vgetbacktoolnamebyrfid.searchByPrimaryKey", entity);
	}

}

