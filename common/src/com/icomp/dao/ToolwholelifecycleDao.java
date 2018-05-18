/*
 * 工具自动生成：刀具全生命周期DAO接口
 * 生成时间    : 2014/08/11 15:35:18
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Toolwholelifecycle;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 */
public interface ToolwholelifecycleDao extends BaseDao {
    //批量更新
     Object insertBatchs(List<Toolwholelifecycle> lisToolwholelifecycles) throws SQLException;

     List<Toolwholelifecycle> searchByList1(BaseEntity entity) throws SQLException;

     int searchByCount1(BaseEntity entity) throws SQLException;

}

