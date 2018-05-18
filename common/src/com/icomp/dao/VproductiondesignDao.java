/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/11/17 14:16:49
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vproductiondesign;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VproductiondesignDao extends BaseViewDao{

	List<Vproductiondesign> getYearList(Vproductiondesign entity) throws SQLException;

}

