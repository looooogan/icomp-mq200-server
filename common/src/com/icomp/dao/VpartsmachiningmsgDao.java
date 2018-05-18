/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/06/13 16:54:39
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vpartsmachiningmsg;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public interface VpartsmachiningmsgDao extends BaseViewDao {
    /**
     * 按时间和零部件查询
     * @param entity
     * @return
     * @throws SQLException
     */
    List<Vpartsmachiningmsg> searchListByTime(Vpartsmachiningmsg entity) throws SQLException;

    int searchByCount1(Vpartsmachiningmsg entity) throws SQLException;
}

