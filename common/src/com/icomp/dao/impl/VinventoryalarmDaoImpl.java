/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/19 13:13:07
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VinventoryalarmDao;
import com.icomp.entity.base.Vinventoryalarm;

/**
 * VinventoryalarmDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/19 13:13:07
 */
public class VinventoryalarmDaoImpl implements VinventoryalarmDao{

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
		return (Integer)dataSource.queryForObject("Vinventoryalarm.searchByCount", entity);
	}
	
	/**
	 * 查询数据条数-Toolcode模糊查询
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	@Override
	public int searchByCount_F(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vinventoryalarm.searchByCount_F", entity);
	}
	/**
	 * 查询周转量
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Map<String, String> getTurnover(BaseEntity entity)throws SQLException{
		dataSource.queryForMap("Vinventoryalarm.getTurnover", null, "itemName", "itemValue"); 
		return null;
	}
	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vinventoryalarm> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vinventoryalarm>)dataSource.queryForList("Vinventoryalarm.searchByList", entity);
	}
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vinventoryalarm> searchByList_F(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vinventoryalarm>)dataSource.queryForList("Vinventoryalarm.searchByList_F", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vinventoryalarm searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vinventoryalarm)dataSource.queryForObject("Vinventoryalarm.searchByPrimaryKey", entity);
	}

}

