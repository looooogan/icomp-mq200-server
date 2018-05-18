/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/10 14:58:49
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VworkshopsummaryDao;
import com.icomp.entity.base.Vworkshopsummary;

import java.sql.SQLException;
import java.util.List;

/**
 * VworkshopsummaryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/10 14:58:49
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VworkshopsummaryDaoImpl implements VworkshopsummaryDao{

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
		return (Integer)dataSource.queryForObject("Vworkshopsummary.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vworkshopsummary> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询searchByList1
		return (List<Vworkshopsummary>)dataSource.queryForList("Vworkshopsummary.searchByList", entity);
	}
	public List<Vworkshopsummary> searchByList1(BaseEntity entity) throws SQLException {
		// 按任意查询searchByList1
		return (List<Vworkshopsummary>)dataSource.queryForList("Vworkshopsummary.searchByList1", entity);
	}


	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vworkshopsummary searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vworkshopsummary)dataSource.queryForObject("Vworkshopsummary.searchByPrimaryKey", entity);
	}

}

