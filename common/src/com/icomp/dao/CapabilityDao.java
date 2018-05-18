/*
 * 工具自动生成：功能DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Capability;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface CapabilityDao extends BaseDao{
	/**
	 * 按capabilityLevel查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Capability> searchByListByLevel(BaseEntity entity) throws SQLException;

}

