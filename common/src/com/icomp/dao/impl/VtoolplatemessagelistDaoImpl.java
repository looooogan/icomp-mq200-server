/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/12/26 14:30:49
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolplatemessagelistDao;
import com.icomp.entity.base.Vtoolplatemessagelist;

/**
 * VtoolplatemessagelistDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/12/26 14:30:49
 */
public class VtoolplatemessagelistDaoImpl implements VtoolplatemessagelistDao{

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
		return (Integer)dataSource.queryForObject("Vtoolplatemessagelist.searchByCount", entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
 @SuppressWarnings("unchecked")
	@Override
	public List<Vtoolplatemessagelist> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vtoolplatemessagelist>)dataSource.queryForList("Vtoolplatemessagelist.searchByList", entity);
	}

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws java.sql.SQLException
	 */
	@Override
	public Vtoolplatemessagelist searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vtoolplatemessagelist)dataSource.queryForObject("Vtoolplatemessagelist.searchByPrimaryKey", entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolplatemessagelist> searchAllToolPan() throws Exception {
		return (List<Vtoolplatemessagelist>)dataSource.queryForList("Vtoolplatemessagelist.searchAllToolPan");
	}

	/**
	 * 根据工具盘ID取出空盘的位置号
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolplatemessagelist> searchIsNullByPanId(Vtoolplatemessagelist vt) throws Exception {
	return (List<Vtoolplatemessagelist>)dataSource.queryForList("Vtoolplatemessagelist.searchIsNullByPanId",vt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vtoolplatemessagelist> searchListByStrlist(List<String> list) throws Exception {
		// 根据刀具入库编码查找对应工具盘
		return (List<Vtoolplatemessagelist>)dataSource.queryForList("Vtoolplatemessagelist.searchListByStrlist",list);
	}

}

