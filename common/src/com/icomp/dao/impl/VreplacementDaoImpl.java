/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/17 19:57:35
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VreplacementDao;
import com.icomp.entity.base.Vreplacement;

import java.sql.SQLException;
import java.util.List;

/**
 * VreplacementDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/17 19:57:35
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VreplacementDaoImpl implements VreplacementDao{

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
		return (Integer)dataSource.queryForObject("Vreplacement.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vreplacement> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vreplacement>)dataSource.queryForList("Vreplacement.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vreplacement searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vreplacement)dataSource.queryForObject("Vreplacement.searchByPrimaryKey", entity);
	}

}

