/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/19 13:13:07
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vinventoryalarm;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VinventoryalarmDao extends BaseViewDao{
	public Map<String, String> getTurnover(BaseEntity entity)throws SQLException;
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vinventoryalarm> searchByList_F(BaseEntity entity) throws SQLException;
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	int searchByCount_F(BaseEntity entity) throws SQLException;
}

