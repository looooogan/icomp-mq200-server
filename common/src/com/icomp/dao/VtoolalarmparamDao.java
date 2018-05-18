/*
 * 工具自动生成：VIEWDAO接口
 * 生成时间    : 2016/05/27 11:57:12
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseViewDao;
import com.icomp.entity.base.Vtoolalarmparam;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public interface VtoolalarmparamDao extends BaseViewDao {

    List<Vtoolalarmparam> searcy(Vtoolalarmparam entity) throws SQLException;

    /**
     * 查询库存新刀异常信息
     *
     * @param entity
     * @return
     * @throws String
     */
    List<Vtoolalarmparam> searchNewVentoryList(Vtoolalarmparam entity) throws SQLException;

    /**
     * 查询库存新刀异常数量
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    int searchNewVentoryCount(Vtoolalarmparam entity) throws SQLException;

    /**
     * 查询备刀库异常信息
     *
     * @param entity
     * @return
     * @throws Exception
     */
    List<Vtoolalarmparam> searchTooltreantList(Vtoolalarmparam entity) throws SQLException;

    /**
     * 查询备刀库异常数量
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    int searchTooltreantCount(Vtoolalarmparam entity) throws SQLException;
}

