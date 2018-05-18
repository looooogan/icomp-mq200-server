/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2015/03/11 17:50:20
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VsynthesistoolsmachiningDao;
import com.icomp.entity.base.Vsynthesistoolsmachining;

import java.sql.SQLException;
import java.util.List;

/**
 * VsynthesistoolsmachiningDao实现类
 * @author 工具自动生成
 * 生成时间    : 2015/03/11 17:50:20
 */
@SuppressWarnings("unchecked")
public class VsynthesistoolsmachiningDaoImpl implements VsynthesistoolsmachiningDao{

	/* 数据源 */
	private SqlMapClient dataSource;
	public void setDataSource(SqlMapClient dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 查询数据条数
	 * @param entity 查询条件
	 * @return 条数
	 * @throws java.sql.SQLException
	 */
	@Override
	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vsynthesistoolsmachining.searchByCount", entity);
	}
	/**
	 * 汇总查询
	 */
	
	public List<Vsynthesistoolsmachining> searchSummaryByTime(Vsynthesistoolsmachining entity) throws SQLException {
		return (List<Vsynthesistoolsmachining>)dataSource.queryForList("Vsynthesistoolsmachining.searchSummaryByTime", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	
	@Override
	public List<Vsynthesistoolsmachining> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vsynthesistoolsmachining>)dataSource.queryForList("Vsynthesistoolsmachining.searchByList", entity);
	}
	/**
	 * 汇总查询数量 
	 */
	public List<Vsynthesistoolsmachining> searchSummaryCount(Vsynthesistoolsmachining entity) throws SQLException {
		return (List<Vsynthesistoolsmachining>)dataSource.queryForList("Vsynthesistoolsmachining.searchSummaryCount", entity);
	}
	
	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vsynthesistoolsmachining searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vsynthesistoolsmachining)dataSource.queryForObject("Vsynthesistoolsmachining.searchByPrimaryKey", entity);
	}


}

