/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/10 15:23:42
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VsynthesisconditionDao;
import com.icomp.entity.base.TooltransferTotal;
import com.icomp.entity.base.Vsynthesiscondition;

import java.sql.SQLException;
import java.util.List;

/**
 * VsynthesisconditionDao实现类
 * @author 工具自动生成
 * 生成时间    : 2016/03/10 15:23:42
 * 生成时间    : 2016/03/10 15:23:42
 * 创建者  ：yzq
 * 更新者  ：taoyy
 */
public class VsynthesisconditionDaoImpl implements VsynthesisconditionDao{

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
		return (Integer)dataSource.queryForObject("TooltransferTotal.searchByCount",entity);
	}

	/**
	 * 按任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Vsynthesiscondition> searchByList(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vsynthesiscondition>)dataSource.queryForList("Vsynthesiscondition.searchByList", entity);
	}
	public List<Vsynthesiscondition> searchByList1(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<Vsynthesiscondition>)dataSource.queryForList("Vsynthesiscondition.searchByList1", entity);
	}
	public List<TooltransferTotal> searchByList2(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<TooltransferTotal>)dataSource.queryForList("TooltransferTotal.searchByList",entity);
	}

	//2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
	public List<TooltransferTotal> searchByList3(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (List<TooltransferTotal>)dataSource.queryForList("TooltransferTotal.searchByList2",entity);
	}

	/**
	 * 更新流转统计表
	 * @param entity
	 * @return
	 * @throws Exception
     */
	@Override
	public int updateTooltransferTotal(TooltransferTotal entity) throws Exception {
		return dataSource.update("TooltransferTotal.updateTooltransferTotal", entity);
	}
	//2017/08/14 王冉 变更↑↑↑　dazhong@YMSC

	/**
	 * 按主键查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	@Override
	public Vsynthesiscondition searchByPrimaryKey(BaseEntity entity) throws SQLException {
		// 按任意查询
		return (Vsynthesiscondition)dataSource.queryForObject("Vsynthesiscondition.searchByPrimaryKey", entity);
	}

}

