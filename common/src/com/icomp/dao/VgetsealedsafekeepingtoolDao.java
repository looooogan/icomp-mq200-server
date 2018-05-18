/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/25 11:04:29
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;

import java.sql.SQLException;
import java.util.Map;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VgetsealedsafekeepingtoolDao extends BaseViewDao{
	/**
	 * 保存待封存刀具信息
	 * @title saveReturnToolInfo 
	 * @param param
	 * @return
	 * int
	 * @throws SQLException 
	 */
	public int saveReturnToolInfo(Map<String,Object> param) throws SQLException;

}

