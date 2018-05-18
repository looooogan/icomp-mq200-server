/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/03/26 13:54:04
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Warning;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface WarningDao extends BaseDao {
    List<Warning> searchByCarName(Warning warning) throws SQLException;

    /**
     * 查询没有禁用的所有信息
     * @return
     * @throws SQLException
     */
    List<Warning> searchListByUse() throws SQLException;


}

