/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/07 11:58:48
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.icomp.common.entity.BaseEntity;
import  com.icomp.dao.VgetequipmentinfoDao;
import  com.icomp.entity.base.Vgetequipmentinfo;

/**
 * VgetequipmentinfoDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/07 11:58:48
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VgetequipmentinfoDaoImpl implements VgetequipmentinfoDao{

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
		return (Integer)dataSource.queryForObject("Vgetequipmentinfo.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetequipmentinfo> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetequipmentinfo>)dataSource.queryForList("Vgetequipmentinfo.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetequipmentinfo searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetequipmentinfo)dataSource.queryForObject("Vgetequipmentinfo.searchByPrimaryKey", entity);
	}

	@Override
	public List<Vgetequipmentinfo> getequipmentinfo(Vgetequipmentinfo r) throws Exception {
		// 按任意查询
		return (List<Vgetequipmentinfo>)dataSource.queryForList("Vgetequipmentinfo.searchByList", r);
	}
}

