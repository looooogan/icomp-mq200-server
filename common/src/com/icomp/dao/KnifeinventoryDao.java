/*
 * 工具自动生成：新刀库存表DAO接口
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Knifeinventory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 */
public interface KnifeinventoryDao extends BaseDao {
    /**
     * 根据刀具入库编号删除出库的信息
     *
     * @param map updateTime  更新时间
     *            userId  更新用户
     *            list   刀具入库编码list
     * @return
     * @throws Exception int
     * @title deleteToolByknifeCode
     */

    int deleteToolByknifeCode(Map<String, Object> map) throws Exception;

    /**
     * 根据RFID查询对应的刀具
     *
     * @param itRfidList
     * @return
     * @throws Exception List<Knifeinventory>
     * @title searchListByRfid
     */
    List<Knifeinventory> searchListByRfid(List<String> itRfidList) throws Exception;

    /**
     * 根据RFID更新新库存类型
     *
     * @param map inParam:rfidlist,
     *            stockType:库存类型(0新刀1出厂回库2流转回库3封存4返厂5外借6借入9其他),
     *            updateTime 更新时间,
     *            updateUser 更新人,
     *            gruantId  授权人,
     *            delFlag   删除区分
     * @return
     * @throws SQLException
     */
    public int updateKnifeInventoryType(Map<String, Object> map) throws SQLException;

    /**
     * 查询要出库的辅具信息
     *
     * @param knifeinventory ToolID  刀具编码
     *                       KnifeInventoryCode  库位码
     *                       totalCount 出库数量
     * @return
     */
    public List<Knifeinventory> findHelpToolOutByNumber(Knifeinventory knifeinventory) throws SQLException;

    /**
     * 任意条件更新处理(未指定字段不更新) (分盒时用)
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    int updateNonQuerySplistBox(Knifeinventory entity) throws SQLException;

    /**
     * 批量插入新刀库存表
     *
     * @param rfList
     * @return
     * @throws SQLException
     */
    Object batchInserts(List<Knifeinventory> kvList) throws SQLException;

    /**
     * 库存新刀初始化批量加入
     *
     * @param k
     * @return
     * @throws Exception
     */
    Object insertBatch1(List<Knifeinventory> k) throws SQLException;

    Knifeinventory getKNMsg(Knifeinventory k) throws Exception;

    List<Knifeinventory> getKNMsgs(Knifeinventory k) throws Exception;

    int inserts(Knifeinventory k) throws Exception;

    /**
     * 根据RFID载体查询是否有已初始化的刀具
     *
     * @param rfidConIDList
     * @return
     * @throws Exception
     */
    List<Knifeinventory> getRfidContainerEd(List<String> rfidConIDList) throws Exception;

    int getupdateDel(Map<String, Object> updateMap) throws Exception;

    /**
     * 按载体ID删除库存新刀的数据
     *
     * @param ttRfidConID
     * @return
     * @throws SQLException
     */
    int updateBatchbykn(List<String> ttRfidConID) throws SQLException;

    int getDelRFIDAndKn(Map<String, Object> rfMap) throws SQLException;

    /**
     *
     * @param list
     * @return
     * @throws SQLException
     */
    int deleteByRfidCodeList(List<String> list) throws SQLException;
}

