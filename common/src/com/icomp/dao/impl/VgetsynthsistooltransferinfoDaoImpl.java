/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/05/16 13:44:03
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VgetsynthsistooltransferinfoDao;
import com.icomp.entity.base.Vgetsynthsistooltransferinfo;

/**
 * VgetsynthsistooltransferinfoDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/05/16 13:44:03
 */
public class VgetsynthsistooltransferinfoDaoImpl implements VgetsynthsistooltransferinfoDao{

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
		return (Integer)dataSource.queryForObject("Vgetsynthsistooltransferinfo.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
 @SuppressWarnings("unchecked")
 @Override
	public List<Vgetsynthsistooltransferinfo> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vgetsynthsistooltransferinfo>)dataSource.queryForList("Vgetsynthsistooltransferinfo.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
    @Override
	public Vgetsynthsistooltransferinfo searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vgetsynthsistooltransferinfo)dataSource.queryForObject("Vgetsynthsistooltransferinfo.searchByPrimaryKey", entity);
	}

}

