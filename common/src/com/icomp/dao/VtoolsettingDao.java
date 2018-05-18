/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014-08-15 15:48:15
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vtoolsetting;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VtoolsettingDao extends BaseViewDao{

	/**
	 * 分组，按任意条件查询执行 
	 * @param entity 查询条件
	 * @return 条数
	 * @throws SQLException
	 */
	
	List<Vtoolsetting> searchByListWithGroup(BaseEntity entity)
			throws SQLException;
	/**
	 * 按任意查询-SynthesisParametersCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vtoolsetting> searchByList_F(BaseEntity entity) throws SQLException;

}

