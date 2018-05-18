/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/08 10:20:54
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetcontainercarrierinfoDao;
import com.icomp.entity.base.Vgetcontainercarrierinfo;

import java.sql.SQLException;
import java.util.List;

/**
 * VgetcontainercarrierinfoDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/08 10:20:54
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VgetcontainercarrierinfoDaoImpl implements VgetcontainercarrierinfoDao{

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
		return (Integer)dataSource.queryForObject("Vgetcontainercarrierinfo.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vgetcontainercarrierinfo> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetcontainercarrierinfo>)dataSource.queryForList("Vgetcontainercarrierinfo.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vgetcontainercarrierinfo searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetcontainercarrierinfo)dataSource.queryForObject("Vgetcontainercarrierinfo.searchByPrimaryKey", entity);
	}

	@Override
	public Vgetcontainercarrierinfo getcontainercarrierinfo(Vgetcontainercarrierinfo r) throws Exception {
		// 按任意查询
		return (Vgetcontainercarrierinfo)dataSource.queryForObject("Vgetcontainercarrierinfo.searchByList", r);
	}

	@Override
	public List<Vgetcontainercarrierinfo> searchByListGroud(Vgetcontainercarrierinfo entity) throws Exception {
		return (List<Vgetcontainercarrierinfo>)dataSource.queryForList("Vgetcontainercarrierinfo.searchByListGroud", entity);
	}
}

