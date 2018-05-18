/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/04/25 17:20:14
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoollibraryhistoryDao;
import com.icomp.entity.base.Vtoollibraryhistory;

import java.sql.SQLException;
import java.util.List;

/**
 * VtoollibraryhistoryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/04/25 17:20:14
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VtoollibraryhistoryDaoImpl implements VtoollibraryhistoryDao{

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
		return (Integer)dataSource.queryForObject("Vtoollibraryhistory.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoollibraryhistory> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoollibraryhistory>)dataSource.queryForList("Vtoollibraryhistory.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vtoollibraryhistory searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoollibraryhistory)dataSource.queryForObject("Vtoollibraryhistory.searchByPrimaryKey", entity);
	}

}

