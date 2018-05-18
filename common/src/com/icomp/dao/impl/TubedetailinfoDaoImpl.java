/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/02/25 15:44:05
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.TubedetailinfoDao;
import com.icomp.entity.base.Tubedetailinfo;

import java.sql.SQLException;
import java.util.List;


/**
 * TubedetailinfoDao实现类
 * @author 工具自动生成
 * 生成时间    : 2017/07/10 15:44:05
 * 创建者  ：sj
 * 更新者  ：sj
 */
public class TubedetailinfoDaoImpl implements TubedetailinfoDao{

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

	public int searchByCount(BaseEntity entity) throws SQLException {
		// 查询数据条数
		return (Integer)dataSource.queryForObject("Tubedetailinfo.searchByCount", entity);
	}
	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	public Tubedetailinfo searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Tubedetailinfo)dataSource.queryForObject("Tubedetailinfo.searchByPrimaryKey", entity);
	}

	@Override
	public List<Tubedetailinfo> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Tubedetailinfo>)dataSource.queryForList("Tubedetailinfo.searchByList", entity);
	}

	// 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
	@Override
	public List<Tubedetailinfo> searchDetailList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Tubedetailinfo>)dataSource.queryForList("Tubedetailinfo.searchDetailList", entity);
	}

	@Override
	public List<Tubedetailinfo> searchTotalList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Tubedetailinfo>)dataSource.queryForList("Tubedetailinfo.searchTotalList", entity);
	}
	// 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
}