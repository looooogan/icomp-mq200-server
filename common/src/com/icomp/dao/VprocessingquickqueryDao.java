/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2015/01/04 17:34:49
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Vprocessingquickquery;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VprocessingquickqueryDao extends BaseViewDao{

	List<Vprocessingquickquery> searchByList_B04S006(BaseEntity entity)
			throws SQLException;

	int searchByCount_B04S006(BaseEntity entity) throws SQLException;

}

