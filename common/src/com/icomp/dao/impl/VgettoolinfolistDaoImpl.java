/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/02/29 14:49:06
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgettoolinfolistDao;
import com.icomp.entity.base.Vgettoolinfolist;

/**
 * VgettoolinfolistDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/02/29 14:49:06
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VgettoolinfolistDaoImpl implements VgettoolinfolistDao{

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
		return (Integer)dataSource.queryForObject("Vgettoolinfolist.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgettoolinfolist> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgettoolinfolist>)dataSource.queryForList("Vgettoolinfolist.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgettoolinfolist searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgettoolinfolist)dataSource.queryForObject("Vgettoolinfolist.searchByPrimaryKey", entity);
	}

}

