/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/05/18 14:26:37
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Werkzeugeanforderun;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface WerkzeugeanforderunDao extends BaseDao{
    /**
     * @param List
     * @return
     * @throws Exception
     */
    Object insertBatchs(List<Werkzeugeanforderun> List) throws SQLException;

    List<Werkzeugeanforderun> searchByLists()throws SQLException;
     int updates(Werkzeugeanforderun entity) throws SQLException;

    /**
     * 查询需求单号-只查询未全到货的信息
     * @return
     * @throws SQLException
     */
    List<Werkzeugeanforderun> findNoDemandCode() throws SQLException;

    /**
     * 删除原有的需求单号
     * @param list
     * @return
     * @throws SQLException
     */
    int deleteListByDemands(List<String> list) throws SQLException;
}

