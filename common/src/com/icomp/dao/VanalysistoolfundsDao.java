/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/08/21 17:07:36
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vanalysistoolfunds;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VanalysistoolfundsDao extends BaseViewDao{
	/**
	 * 获取各种状态的残值金额
	 * @title getStatisticalCount 
	 * @param entity
	 * @return
	 * List<Vconsumptiontool>
	 * @throws SQLException 
	 */
	List<Vanalysistoolfunds> getStatisticalCount(BaseEntity entity) throws SQLException;

}

