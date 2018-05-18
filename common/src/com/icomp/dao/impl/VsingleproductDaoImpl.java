/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/05/16 13:50:36
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VsingleproductDao;
import com.icomp.entity.base.Vsingleproduct;

import java.sql.SQLException;
import java.util.List;

/**
 * VsingleproductDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/05/16 13:50:36
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VsingleproductDaoImpl implements VsingleproductDao{

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
		return (Integer)dataSource.queryForObject("Vsingleproduct.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vsingleproduct> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vsingleproduct>)dataSource.queryForList("Vsingleproduct.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vsingleproduct searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vsingleproduct)dataSource.queryForObject("Vsingleproduct.searchByPrimaryKey", entity);
	}

}

