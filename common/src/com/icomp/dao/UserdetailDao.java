/*
 * 工具自动生成：用户明细DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Userdetail;

import java.sql.SQLException;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface UserdetailDao extends BaseDao{

    Userdetail searchByPrimaryID(String userID) throws SQLException;
}

