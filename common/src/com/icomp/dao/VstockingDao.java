/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/11/13 14:08:26
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vstocking;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VstockingDao extends BaseViewDao{
	/**
	 * 按任意查询--ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vstocking> searchByList_F(BaseEntity entity) throws SQLException;

	int searchByCount_F(BaseEntity entity) throws SQLException;

}

