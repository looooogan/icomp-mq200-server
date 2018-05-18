/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/24 09:41:59
 */
package com.icomp.dao;

import java.sql.SQLException;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.common.entity.BaseEntity;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VgetfacilitieslibraryDao extends BaseViewDao{
	/**
	 * 保存配套出库信息
	 * @title saveOutputToolInfo 
	 * @param entity
	 * @return
	 * Object
	 * @throws SQLException 
	 */
   public int saveOutputToolInfo(BaseEntity entity) throws SQLException;

}

