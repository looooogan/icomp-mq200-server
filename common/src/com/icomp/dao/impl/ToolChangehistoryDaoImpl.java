/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2014/11/13 14:08:26
 */
package com.icomp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.ToolChangehistoryDao;
import com.icomp.entity.base.ToolChangehistory;
import com.icomp.entity.base.Vstocking;

/**
 * VstockingDao实现类
 * @author 工具自动生成
 * 生成时间    : 2014/11/13 14:08:26
 */
@SuppressWarnings("unchecked")
public class ToolChangehistoryDaoImpl implements ToolChangehistoryDao{

    /* 数据源 */
    private SqlMapClient dataSource;
    public void setDataSource(SqlMapClient dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 查询数据条数
     * @param entity 查询条件
     * @return 条数
     * @throws SQLException
     */
    @Override
    public int searchByCount2(ToolChangehistory entity) throws SQLException {
        // 查询数据条数
        return (Integer)dataSource.queryForObject("ToolChangehistory.searchByCount", entity);
    }

    /**
     * 按任意查询
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @Override
    public List<ToolChangehistory> searchByList2(ToolChangehistory entity) throws SQLException {
        // 按任意查询
        return (List<ToolChangehistory>)dataSource.queryForList("ToolChangehistory.searchByList", entity);
    }
    /**
     * 按任意查询-ToolCode模糊查询
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */


}

