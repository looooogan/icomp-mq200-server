/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/05/13 14:40:40
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vinventorystatus;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VinventorystatusDao extends BaseViewDao{
	/**
	 * 按任意查询-ToolCode模糊查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vinventorystatus> searchByList_F(BaseEntity entity)
			throws SQLException;

}

