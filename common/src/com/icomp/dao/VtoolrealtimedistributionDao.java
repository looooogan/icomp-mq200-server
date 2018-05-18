/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/08/21 17:07:37
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vtoolrealtimedistribution;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VtoolrealtimedistributionDao extends BaseViewDao{

	
	/**
	 * 任意条件查询-toolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */

	List<Vtoolrealtimedistribution> searchByList_F(BaseEntity entity)
			throws SQLException;

}

