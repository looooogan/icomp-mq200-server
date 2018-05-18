/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/10/20 15:29:43
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vgetredemptionappdetailedmsg;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VgetredemptionappdetailedmsgDao extends BaseViewDao{
	/**
	 * 查询申领详细列表 
	 * @title searchListByRold 
	 * @param pstList
	 * @return
	 * @throws SQLException
	 * List<Vgetredemptionappdetailedmsg>
	 */
	public List<Vgetredemptionappdetailedmsg> searchListByRold(Map<String, Object> map) throws SQLException;

}

