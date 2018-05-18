/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/08/21 17:07:37
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vscrapanalysis;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VscrapanalysisDao extends BaseViewDao{
	/**
	 * 报废分析统计数量
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * List<Vscrapanalysis>
	 * @throws SQLException 
	 */
	List<Vscrapanalysis> getStatisticalCount(BaseEntity entity) throws SQLException;
	/**
	 * 按任意查询ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	
	List<Vscrapanalysis> searchByList_F(BaseEntity entity) throws SQLException;

}

