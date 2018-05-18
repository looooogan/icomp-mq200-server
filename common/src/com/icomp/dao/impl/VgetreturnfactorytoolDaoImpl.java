/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/09/24 19:46:00
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetreturnfactorytoolDao;
import com.icomp.entity.base.Vgetreturnfactorytool;

/**
 * VgetreturnfactorytoolDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/09/24 19:46:00
 */
public class VgetreturnfactorytoolDaoImpl implements VgetreturnfactorytoolDao{

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
		return (Integer)dataSource.queryForObject("Vgetreturnfactorytool.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetreturnfactorytool> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetreturnfactorytool>)dataSource.queryForList("Vgetreturnfactorytool.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetreturnfactorytool searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetreturnfactorytool)dataSource.queryForObject("Vgetreturnfactorytool.searchByPrimaryKey", entity);
	}
	/**
	 * 保存返厂刀具数据
	 * saveReturnToolInfo
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public int saveReturnToolInfo(Map<String,Object> param) throws Exception {
		 // 数据更新(未指定数据更新为null)
		return dataSource.update("Vgetreturnfactorytool.saveReturnToolInfo", param);
	}

}

