/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/10/24 14:06:04
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vsynthesisexperience;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VsynthesisexperienceDao extends BaseViewDao{
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vsynthesisexperience> searchByList_F(BaseEntity entity)
			throws SQLException;

	int searchByCount_F(BaseEntity entity) throws SQLException;

}

