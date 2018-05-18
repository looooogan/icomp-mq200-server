/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/08/28 18:34:44
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VlibrarycodeDao;
import com.icomp.entity.base.Vlibrarycode;

/**
 * VlibrarycodeDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/08/28 18:34:44
 */
@SuppressWarnings("unchecked")
public class VlibrarycodeDaoImpl implements VlibrarycodeDao{

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
		return (Integer)dataSource.queryForObject("Vlibrarycode.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vlibrarycode> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vlibrarycode>)dataSource.queryForList("Vlibrarycode.searchByList", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	
	@Override
	public List<Vlibrarycode> searchByList_new(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vlibrarycode>)dataSource.queryForList("Vlibrarycode.searchByList_new", entity);
	}
	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vlibrarycode searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vlibrarycode)dataSource.queryForObject("Vlibrarycode.searchByPrimaryKey", entity);
	}

	@Override
	public List<Vlibrarycode> searchByList_b08s011(Vlibrarycode entity)
			throws SQLException {
		// 按任意查询
		return (List<Vlibrarycode>)dataSource.queryForList("Vlibrarycode.searchByList_b08s011", entity);
	}
}

