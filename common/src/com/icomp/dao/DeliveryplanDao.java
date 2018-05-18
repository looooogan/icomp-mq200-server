/*
 * 工具自动生成：到货计划DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import java.sql.SQLException;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Deliveryplan;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface DeliveryplanDao extends BaseDao{

	public int updateTheyStatus(Deliveryplan deliveryplan) throws SQLException;

}

