/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2015/03/11 17:50:19
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vsynthesistoolsmachining;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VsynthesistoolsmachiningDao extends BaseViewDao{

	List<Vsynthesistoolsmachining> searchSummaryByTime(Vsynthesistoolsmachining entity) throws SQLException;

	List<Vsynthesistoolsmachining> searchSummaryCount(Vsynthesistoolsmachining entity) throws SQLException;

}

