/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/07 09:47:32
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VprocessDao;
import com.icomp.entity.base.Vprocess;

/**
 * VprocessDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/07 09:47:32
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VprocessDaoImpl implements VprocessDao{

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
		return (Integer)dataSource.queryForObject("Vprocess.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vprocess> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vprocess>)dataSource.queryForList("Vprocess.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vprocess searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vprocess)dataSource.queryForObject("Vprocess.searchByPrimaryKey", entity);
	}

}

