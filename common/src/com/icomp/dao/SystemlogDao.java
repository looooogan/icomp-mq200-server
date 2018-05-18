/*
 * 工具自动生成：日志DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.List;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Systemlog;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface SystemlogDao extends BaseDao{

	List<Systemlog> searchByListWithSystemLogUser(Systemlog entity) throws SQLException;
}

