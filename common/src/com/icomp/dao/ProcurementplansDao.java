/*
 * 工具自动生成：采购计划DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.EntityProcurementplansWhere;
import com.icomp.entity.base.Procurementplans;

/**
 * 继承父接口
 * 
 * @author 工具自动生成
 * 
 */
public interface ProcurementplansDao extends BaseDao {
	/**
	 * 建议采购计划生成查询
	 * 
	 * @title searchByProcurementplans
	 * @param entity
	 * @return
	 * @throws SQLException
	 *             List<EntityProcurementplansWhere>
	 */
	List<EntityProcurementplansWhere> searchByProcurementplans(BaseEntity entity) throws SQLException;
	/**
	 * 批量插入
	 * @title batchInsert 
	 * @param list
	 * @return
	 * int
	 * @throws SQLException 
	 */
	public Object batchInsert(List<Procurementplans> list) throws SQLException;
}
