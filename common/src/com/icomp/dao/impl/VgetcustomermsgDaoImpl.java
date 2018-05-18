/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/04/29 15:47:19
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetcustomermsgDao;
import com.icomp.entity.base.Vgetcustomermsg;

import java.sql.SQLException;
import java.util.List;

/**
 * VgetcustomermsgDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/04/29 15:47:19
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VgetcustomermsgDaoImpl implements VgetcustomermsgDao{

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
		return (Integer)dataSource.queryForObject("Vgetcustomermsg.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetcustomermsg> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetcustomermsg>)dataSource.queryForList("Vgetcustomermsg.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetcustomermsg searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetcustomermsg)dataSource.queryForObject("Vgetcustomermsg.searchByPrimaryKey", entity);
	}

}

