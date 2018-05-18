/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/05/13 14:40:40
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VinventorystatusDao;
import com.icomp.entity.base.Vinventorystatus;

import java.sql.SQLException;
import java.util.List;

/**
 * VinventorystatusDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/05/13 14:40:40
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VinventorystatusDaoImpl implements VinventorystatusDao{

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
		return (Integer)dataSource.queryForObject("Vinventorystatus.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vinventorystatus> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vinventorystatus>)dataSource.queryForList("Vinventorystatus.searchByList", entity);
	}
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vinventorystatus> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询-ToolCode模糊查询
		return (List<Vinventorystatus>)dataSource.queryForList("Vinventorystatus.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vinventorystatus searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vinventorystatus)dataSource.queryForObject("Vinventorystatus.searchByPrimaryKey", entity);
	}

}

