/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/08/21 17:07:37
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vtoolsupplieranalysis;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VtoolsupplieranalysisDao extends BaseViewDao{
	/**
	 * 刀具供应商分析统计数量
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * List<Vtoolsupplieranalysis>
	 * @throws SQLException 
	 */
  public List<Vtoolsupplieranalysis> getStatisticalCount(BaseEntity entity) throws SQLException;

}

