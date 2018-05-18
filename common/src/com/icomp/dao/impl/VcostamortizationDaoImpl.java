/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/05/30 11:21:40
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VcostamortizationDao;
import com.icomp.entity.base.Vcostamortization;

import java.sql.SQLException;
import java.util.List;

/**
 * VcostamortizationDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/05/30 11:21:40
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VcostamortizationDaoImpl implements VcostamortizationDao{

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
		return (Integer)dataSource.queryForObject("Vcostamortization.searchByCount", entity);
	}

	public int searchByCount2(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Vcostamortization.searchByCount2", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vcostamortization> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vcostamortization>)dataSource.queryForList("Vcostamortization.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vcostamortization searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vcostamortization)dataSource.queryForObject("Vcostamortization.searchByPrimaryKey", entity);
	}

	@Override
	public List<Vcostamortization> searchByLists(BaseEntity entity) throws SQLException {
		return (List<Vcostamortization>)dataSource.queryForList("Vcostamortization.searchByLists", entity);
	}

	@Override
	public List<Vcostamortization> searchByLists2(BaseEntity entity) throws SQLException {
		return (List<Vcostamortization>)dataSource.queryForList("Vcostamortization.searchByLists2", entity);
	}
}

