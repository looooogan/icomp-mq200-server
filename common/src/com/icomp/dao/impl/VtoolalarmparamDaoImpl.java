/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/02/27 11:06:06
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VtoolalarmparamDao;
import com.icomp.entity.base.Vtoolalarmparam;

import java.sql.SQLException;
import java.util.List;

/**
 * VtoolalarmparamDao实现类
 *
 * @author 工具自动生成
 *         生成时间    : 2016/02/27 11:06:06
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public class VtoolalarmparamDaoImpl implements VtoolalarmparamDao {

    /* 数据源 */
    private SqlMapClient dataSource;

    public void setDataSource(SqlMapClient dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 查询数据条数
     *
     * @param entity 查询条件
     * @return 条数
     * @throws SQLException
     */

    public int searchByCount(BaseEntity entity) throws SQLException {
        // 查询数据条数
        return (Integer) dataSource.queryForObject ( "Vtoolalarmparam.searchByCount", entity );
    }

    /**
     * 按任意查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")

    public List<Vtoolalarmparam> searchByList(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (List<Vtoolalarmparam>) dataSource.queryForList ( "Vtoolalarmparam.searchByList", entity );
    }

    /**
     * 按主键查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */

    public Vtoolalarmparam searchByPrimaryKey(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (Vtoolalarmparam) dataSource.queryForObject ( "Vtoolalarmparam.searchByPrimaryKey", entity );
    }

    @Override
    public List<Vtoolalarmparam> searcy(Vtoolalarmparam entity) throws SQLException {

        return (List<Vtoolalarmparam>) dataSource.queryForList ( "Vtoolalarmparam.searcy", entity );
    }

    @Override
    public List<Vtoolalarmparam> searchNewVentoryList(Vtoolalarmparam entity) throws SQLException {
        //查询库存新刀异常信息
        return (List<Vtoolalarmparam>) dataSource.queryForList ( "Vtoolalarmparam.searchNewVentoryList", entity );
    }

    @Override
    public int searchNewVentoryCount(Vtoolalarmparam entity) throws SQLException {
        // 查询库存新刀异常信息
        return (Integer) dataSource.queryForObject ( "Vtoolalarmparam.searchNewVentoryCount", entity );
    }

    @Override
    public List<Vtoolalarmparam> searchTooltreantList(Vtoolalarmparam entity) throws SQLException {
        //查询备刀库异常信息
        return (List<Vtoolalarmparam>) dataSource.queryForList ( "Vtoolalarmparam.searchTooltreantList", entity );
    }

    @Override
    public int searchTooltreantCount(Vtoolalarmparam entity) throws SQLException {
        // 查询备刀库异常数量
        return (Integer) dataSource.queryForObject ( "Vtoolalarmparam.searchTooltreantCount", entity );
    }

}

