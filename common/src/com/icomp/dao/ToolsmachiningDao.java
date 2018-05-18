/*
 * 工具自动生成：刀具加工DAO接口
 * 生成时间    : 2016/05/24 15:10:32
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toolsmachining;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface ToolsmachiningDao extends BaseDao{

    /**
     * 批量插入单品刀具加工信息
     * @param tsList
     * @throws SQLException
     */
    public void insertBacths(List<Toolsmachining> tsList)throws SQLException;

    /**
     * 使用次数(E)
     * @param entity
     * @return
     * @throws SQLException
     */
    int searchCountByToolID(Toolsmachining entity) throws SQLException;

    int searchCountBeWeenAnd(Toolsmachining entity) throws SQLException;
}

