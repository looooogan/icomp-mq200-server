/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/24 09:41:59
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetfacilitieslibraryDao;
import com.icomp.entity.base.Vgetfacilitieslibrary;

/**
 * VgetfacilitieslibraryDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/24 09:41:59
 */
public class VgetfacilitieslibraryDaoImpl implements VgetfacilitieslibraryDao{

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
		return (Integer)dataSource.queryForObject("Vgetfacilitieslibrary.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetfacilitieslibrary> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetfacilitieslibrary>)dataSource.queryForList("Vgetfacilitieslibrary.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetfacilitieslibrary searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetfacilitieslibrary)dataSource.queryForObject("Vgetfacilitieslibrary.searchByPrimaryKey", entity);
	}
	
	/**
	 * 保存配套出库信息
	 * @throws SQLException 
	 */
	@Override
	public int saveOutputToolInfo(BaseEntity entity) throws SQLException {
			// 数据更新(未指定数据更新为null)
			return dataSource.update("Vgetfacilitieslibrary.saveOutputToolInfo", entity);
		
	}

}

