/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/25 11:04:29
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetsealedsafekeepingtoolDao;
import com.icomp.entity.base.Vgetsealedsafekeepingtool;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * VgetsealedsafekeepingtoolDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/25 11:04:29
 */
public class VgetsealedsafekeepingtoolDaoImpl implements VgetsealedsafekeepingtoolDao{

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
		return (Integer)dataSource.queryForObject("Vgetsealedsafekeepingtool.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetsealedsafekeepingtool> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetsealedsafekeepingtool>)dataSource.queryForList("Vgetsealedsafekeepingtool.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetsealedsafekeepingtool searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetsealedsafekeepingtool)dataSource.queryForObject("Vgetsealedsafekeepingtool.searchByPrimaryKey", entity);
	}
	/**
	 * 保存待封存刀具信息
	 * saveReturnToolInfo
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	@Override
	public int saveReturnToolInfo(Map<String,Object> param) throws SQLException {
		return dataSource.update("Vgetsealedsafekeepingtool.saveReturnToolInfo", param);
	}

}

