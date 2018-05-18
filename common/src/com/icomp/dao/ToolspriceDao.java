/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/09/03 09:55:10
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Toolsprice;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface ToolspriceDao extends BaseDao {
    /**
     * 按时ToolID删除原来的信息
     * @param list
     * @return
     * @throws SQLException
     */
    void deleteAllByID(List<String> list) throws SQLException;

    /**
     * 批量新增到表中
     * @param tss
     * @throws SQLException
     */
    void insertBatchs(List<Toolsprice> tss) throws SQLException;
}

