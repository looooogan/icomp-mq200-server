/*
 * 工具自动生成：区分定义DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Comlist;

import java.sql.SQLException;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 */
public interface ComlistDao extends BaseDao {
    /**
     * 取得区分值
     *
     * @param entity
     * @return
     */
    public Object getComListText(Comlist entity)throws SQLException;
}

