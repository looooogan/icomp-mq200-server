/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/02 17:23:45
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vconsumptiontool;

/**
 * 继承父接口
 * 
 * @author 工具自动生成
 * 
 */
public interface VconsumptiontoolDao extends BaseViewDao {
	/**
	 * 单品刀具分析统计
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * List<Vconsumptiontool>
	 * @throws SQLException 
	 */
   public List<Vconsumptiontool> getStatisticalCount(BaseEntity entity) throws SQLException;
	/**
	 * 任意条件查询-toolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vconsumptiontool> searchByList_F(BaseEntity entity)
			throws SQLException;

}
