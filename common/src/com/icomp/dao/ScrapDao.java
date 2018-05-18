/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/02/24 14:46:36
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Scrap;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface ScrapDao extends BaseDao{
    /**
     * 获取报废刀具的平均刃磨次数
     * @return
     * @throws SQLException
     */
    List<Scrap> usageCounterGroupToolCode() throws SQLException;
}

