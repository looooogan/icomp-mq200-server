/*
 * 工具自动生成：厂外修复表DAO接口
 * 生成时间    : 2016/02/25 19:22:51
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Outsidefactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 继承父接口
 * @author 工具自动生成
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public interface OutsidefactoryDao extends BaseDao {
    public Object insert(BaseEntity entity) throws SQLException;

    /**
     * 取得通知单号列表
     * @param outentity
     * @return
     * @throws Exception
     */
    Outsidefactory getNotificationList(Outsidefactory outentity)throws Exception;


    Outsidefactory getBackFactoryToolInfo(Outsidefactory tt)throws Exception;

    List<Outsidefactory> searchByPrimaryView(Outsidefactory tt)throws SQLException;


    // 2017/08/25 宋健 追加↓↓↓　dazhong@YMSC
    List<Outsidefactory> searchByPrimaryViewDetail(Outsidefactory tt)throws SQLException;
    // 2017/08/25 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/08/25 宋健 追加↓↓↓　dazhong@YMSC
    List<Outsidefactory> searchByPrimaryViewForBack(Outsidefactory tt)throws SQLException;
    // 2017/08/25 宋健 追加↑↑↑　dazhong@YMSC

    List<Outsidefactory> getBackFactoryToolInfoSumlist(Outsidefactory of)throws Exception;

    /**
     * 批量插入厂外修复表
     * @param list
     * @return
     * @throws SQLException
     */
    Object insertBatchs(List<Outsidefactory> list) throws SQLException;

    /**
     * 修改出厂表信息为加厂
     * @param map
     * @return
     * @throws SQLException
     */
    int updateRepairStateByRfidConnerID(Map<String,Object>map) throws SQLException;

    /**
     * 出厂信息查询数据总数（LHL)
     * @param entity
     * @return
     * @throws SQLException
     */
    public int searchByPrimaryViewCount(BaseEntity entity) throws SQLException;

    // 2017/08/25 宋健 追加↓↓↓　dazhong@YMSC
    public int searchByPrimaryViewCountForBack(BaseEntity entity) throws SQLException;
    // 2017/08/25 宋健 追加↑↑↑　dazhong@YMSC

    public List<Outsidefactory> searchOutsideFactoryList(BaseEntity of) throws SQLException;

    public List<Outsidefactory> searchAllOutsideFactoryList(BaseEntity of) throws SQLException;

    // 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
    public List<Outsidefactory> getDetailList(BaseEntity of) throws SQLException;
    public int updateNonQuery2(Outsidefactory entity) throws SQLException;
    // 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/19 王冉 追加↓↓↓　dazhong@YMSC
    List<Outsidefactory> searchByList(Outsidefactory tt) throws SQLException;
    // 2017/09/19 王冉 追加↑↑↑　dazhong@YMSC
}

