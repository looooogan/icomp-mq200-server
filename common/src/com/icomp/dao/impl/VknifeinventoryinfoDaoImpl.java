/*
 * 工具自动生成：VIEWDAO实现类
 * 生成时间    : 2016/03/22 10:03:10
 */
package com.icomp.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.icomp.common.entity.BaseEntity;
import com.icomp.dao.VknifeinventoryinfoDao;
import com.icomp.entity.base.Vknifeinventoryinfo;

import java.sql.SQLException;
import java.util.List;

/**
 * VknifeinventoryinfoDao实现类
 *
 * @author 工具自动生成
 *         生成时间    : 2016/03/22 10:03:10
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public class VknifeinventoryinfoDaoImpl implements VknifeinventoryinfoDao {

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
    @Override
    public int searchByCount(BaseEntity entity) throws SQLException {
        // 查询数据条数
        return (Integer) dataSource.queryForObject("Vknifeinventoryinfo.searchByCount", entity);
    }

    /**
     * 按任意查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Vknifeinventoryinfo> searchByList(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (List<Vknifeinventoryinfo>) dataSource.queryForList("Vknifeinventoryinfo.searchByList", entity);
    }

    /**
     * 按主键查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    @Override
    public Vknifeinventoryinfo searchByPrimaryKey(BaseEntity entity) throws SQLException {
        // 按任意查询
        return (Vknifeinventoryinfo) dataSource.queryForObject("Vknifeinventoryinfo.searchByPrimaryKey", entity);
    }

    @Override
    public Vknifeinventoryinfo getIsHasToolInit(Vknifeinventoryinfo entity) throws SQLException {
        //查询当前材料号是否初始化
        return (Vknifeinventoryinfo) dataSource.queryForObject("Vknifeinventoryinfo.getIsHasToolInit", entity);
    }

    @Override
    public Vknifeinventoryinfo getknifeinventoryByToolCode(Vknifeinventoryinfo entity) throws SQLException {
        //材料号查询库存信息
        return (Vknifeinventoryinfo) dataSource.queryForObject("Vknifeinventoryinfo.getknifeinventoryByToolCode", entity);
    }

    @Override
    public Vknifeinventoryinfo getknifeinventoryBySamleTool(Vknifeinventoryinfo entity) throws SQLException {
        //按照RFID查询库存信息
        return (Vknifeinventoryinfo) dataSource.queryForObject("Vknifeinventoryinfo.getknifeinventoryBySamleTool", entity);
    }

    @Override
    public List<Vknifeinventoryinfo> searchListByToolCode(Vknifeinventoryinfo entity) throws SQLException {
        //根据材料号查询库存信息
        return (List<Vknifeinventoryinfo>) dataSource.queryForList("Vknifeinventoryinfo.searchListByToolCode", entity);
    }
}

