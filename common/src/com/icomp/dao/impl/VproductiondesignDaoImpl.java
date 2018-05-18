/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/11/17 14:16:49
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VproductiondesignDao;
import com.icomp.entity.base.Vproductiondesign;

/**
 * VproductiondesignDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/11/17 14:16:49
 */
@SuppressWarnings("unchecked")
public class VproductiondesignDaoImpl implements VproductiondesignDao{

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
		return (Integer)dataSource.queryForObject("Vproductiondesign.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public List<Vproductiondesign> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vproductiondesign>)dataSource.queryForList("Vproductiondesign.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vproductiondesign searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vproductiondesign)dataSource.queryForObject("Vproductiondesign.searchByPrimaryKey", entity);
	}

	@Override
	public List<Vproductiondesign> getYearList(Vproductiondesign entity) throws SQLException {
		// 按任意查询
		return (List<Vproductiondesign>)dataSource.queryForList("Vproductiondesign.getYearList", entity);
	}


}

