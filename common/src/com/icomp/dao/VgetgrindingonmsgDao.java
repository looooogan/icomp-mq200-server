/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2014/10/15 14:22:13
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vgetgrindingonmsg;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface VgetgrindingonmsgDao extends BaseViewDao{

	public List<Vgetgrindingonmsg> searchByToolList(Map<String,Object> map) throws SQLException;
}

