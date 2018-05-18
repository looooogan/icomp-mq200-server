/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/03/22 10:03:10
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vknifeinventoryinfo;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface VknifeinventoryinfoDao extends BaseViewDao {

    /**
     * 查询当前材料号是否初始化
     * @param vknifeinventoryinfo
     * @return
     * @throws SQLException
     */
    Vknifeinventoryinfo getIsHasToolInit(Vknifeinventoryinfo vknifeinventoryinfo) throws SQLException;

    /**
     * 材料号查询库存信息
     * @param entity
     * @return
     * @throws SQLException
     */
    Vknifeinventoryinfo getknifeinventoryByToolCode(Vknifeinventoryinfo entity)throws SQLException;

    /**
     * 按照RFID查询库存信息
     * @param entity
     * @return
     * @throws SQLException
     */
    Vknifeinventoryinfo getknifeinventoryBySamleTool(Vknifeinventoryinfo entity) throws SQLException;

    /**
     * 根据材料号查询库存信息
     * @param v
     * @return
     * @throws SQLException
     */
    List<Vknifeinventoryinfo> searchListByToolCode(Vknifeinventoryinfo v) throws SQLException;
}

