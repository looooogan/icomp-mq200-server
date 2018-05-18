/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/04/25 15:31:07
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VknifeinventoryDao;
import com.icomp.entity.base.Vknifeinventory;

import java.sql.SQLException;
import java.util.List;

/**
 * VknifeinventoryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/04/25 15:31:07
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VknifeinventoryDaoImpl implements VknifeinventoryDao{

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
		return (Integer)dataSource.queryForObject("Vknifeinventory.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vknifeinventory> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vknifeinventory>)dataSource.queryForList("Vknifeinventory.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vknifeinventory searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vknifeinventory)dataSource.queryForObject("Vknifeinventory.searchByPrimaryKey", entity);
	}

}

