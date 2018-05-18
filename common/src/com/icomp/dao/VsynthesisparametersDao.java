/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/09/19 18:01:27
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vsynthesisparameters;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VsynthesisparametersDao extends BaseViewDao{
	/**
	 * 按无合成刀位置-任意查询
	 * @param entity 查询条件
	 * @return 查询结果
	 * @throws SQLException
	 */
	List<Vsynthesisparameters> searchByListNoLoaction(
			Vsynthesisparameters entity)throws SQLException ;

}

