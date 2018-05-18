/*
 * 工具自动生成：DAO接口
 * 生成时间    : 2016/03/11 13:10:45
 */
package com.icomp.dao;


import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.TooltranarMassage;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.TooltransferTotal;

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
public interface TooltransferDao extends BaseDao {
    /**
     * 新旧RFID交换
     *
     * @param map
     * @return int
     * @title updateRfidNuber
     */
    public int updateRfidNuber(Map<String, Object> map) throws Exception;

    /**
     * 取得要修改的数据
     *
     * @param rfidList
     * @return List<Tooltransfer>
     * @throws SQLException
     * @title searchHalfByList
     */
    public List<Tooltransfer> searchHalfByList(List<String> rfidList) throws SQLException;

    /**
     * 批量更新刀具流转流程
     *
     * @param map businessFlowLnkID 业务流程
     *            userId  用户ID
     *            list   List<String> RFIDCode
     * @return
     * @throws Exception int
     * @title updateBatchByRfid
     */
    public int updateBatchByRfid(Map<String, Object> map) throws SQLException;

    /**
     * 批量更新刀具流转为被修复通知领取状态
     *
     * @param map
     * @return
     * @throws Exception int
     * @title updateBatchByRfid
     */
    public int updateBatchByOldRfid(Map<String, Object> map) throws Exception;

    /**
     * 根据入库刀具编码更新载体id
     *
     * @param pMap
     * @return
     * @throws Exception int
     * @title updateContainerByRfid
     */
    public int updateContainerByRfid(Map<String, Object> pMap) throws Exception;

    /**
     * 删除从盒中拿出来的刀具
     *
     * @param map
     * @return
     * @throws Exception int
     * @title updateDelFlagByRfid
     */
    public int updateDelFlagByRfid(Map<String, Object> map) throws Exception;

    /**
     * 批量插入
     *
     * @param ttList1 void
     * @title insertBatchs
     */
    public Object insertBatchs(List<Tooltransfer> ttList1) throws SQLException;

    /**
     * 更新报废刀具确认
     *
     * @param map
     * @return
     * @throws Exception
     */
    public int saveb06s010(Map<String, Object> map) throws SQLException;

    /**
     * 根据刀具编码和入库编码查找断刀和丢刀的数量
     *
     * @param map
     * @return
     * @throws Exception Map<String,Object>
     * @title findCUserByTK
     */
    public List<Tooltransfer> findCUserByTK(Map<String, Object> map) throws Exception;

    /**
     * 删除换领多余的数据
     *
     * @param list
     * @return
     * @throws Exception int
     * @title delListByCIdAndTKCode
     */
    int delListByCIdAndTKCode(List<Tooltransfer> list) throws Exception;

    /**
     * 根据刀具入库编码查询要修改的值
     *
     * @param list
     * @return
     * @throws Exception List<Tooltransfer>
     * @title searchListByKiCodes
     */
    List<Tooltransfer> searchListByKiCodes(List<String> list) throws Exception;

    /**
     * 根据RFIDlist删除流转中的数据
     *
     * @param map delFlag -> 删除区分
     *            userId -> 删除用户id
     *            updateTime ->删用户时间
     *            list -> rfidCode
     * @return
     */
    int updateBatchDeFlagByRfid(Map<String, Object> map) throws SQLException;

    /**
     * 根据RFID更新流转中库存类型
     *
     * @param map inParam  rfidlist,
     *            stockType 库存状态(0正常1报废2返厂3封存4流转9其他)
     *            updateTime 更新时间,
     *            updateUser 更新人,
     *            gruantId  授权人,
     *            delFlag   删除区分
     * @return
     * @throws SQLException
     */
    int updateStockState(Map<String, Object> map) throws SQLException;

    /**
     * 查询已流转中辅具的刀具编码
     *
     * @param rfidString
     * @return
     * @throws SQLException
     */
    Object getHelpToolCode(String rfidString) throws SQLException;

    int updateNonQuerySplistBox(Tooltransfer entity) throws SQLException;

    /**
     * 按合成刀具RFID查询流程信息
     *
     * @param rfidSynthesisString
     * @return
     * @throws SQLException
     */
    List<Tooltransfer> findAllBySynthesRfid(String rfidSynthesisString) throws SQLException;

    /**
     * 根据刀具id和载体id,部门状态,limit数量
     * 更新载体和刀具状态为报废
     *
     * @param tooltransfert
     * @return
     * @throws SQLException
     */
    int updateDateByToolID(Tooltransfer tooltransfert) throws SQLException;

    /**
     * 按刀具编码或物料号查询取得刃磨数量
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    List<TooltranarMassage> getToolCodeAndKivCode(TooltranarMassage entity) throws SQLException;

    /**
     * 取得修磨处理(非单品)
     *
     * @param entity
     * @return
     * @throws Exception
     */
    List<Tooltransfer> getRegrindingList(BaseEntity entity) throws SQLException;
    /**
     * 取得扫描RFID的刀具信息（非单品）
     *
     * @param tooltransfer 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    List<Tooltransfer> getToolInfoDetail(Tooltransfer tooltransfer) throws SQLException ;

    /**
     *  取得交接的容器
     * @param entity
     * @return
     * @throws SQLException
     */
    List<TooltranarMassage> getGrindingContarnerByRfid(TooltranarMassage entity)throws  SQLException;

    /**
     * 取得流转刀具信息--报废
     *
     * @param tooltransfer 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    List<Tooltransfer> tooltransferList2(Tooltransfer tooltransfer) throws SQLException ;

    List<Tooltransfer> getSynSingesToolList(Tooltransfer tt)throws SQLException;

    Tooltransfer getToolCode(Tooltransfer t)throws Exception;



    public List<Tooltransfer> searchByList_F(BaseEntity entity) throws SQLException;




    Object insertBatchss(List<Tooltransfer> tt)throws SQLException;




    List<Tooltransfer> getToolMSgBToolID(Tooltransfer t)throws Exception;

    List<Tooltransfer> getTooltransferMsg(Tooltransfer tf)throws SQLException;

    Object updateBatchss(List<Tooltransfer> ttlist)throws SQLException;

    /**
     * 查询当前载体是否在流转表中存在
     * @param ttRfidConID
     * @return
     * @throws SQLException
     */
    List<Tooltransfer> getRfidConnerIDed(List<String> ttRfidConID) throws SQLException;

    /**
     * 查询当前合成刀具的组成部分
     * @param tfentity
     * @return
     * @throws SQLException
     */
    List<Tooltransfer> getSynthesisknifeToolMsg(Tooltransfer tfentity) throws SQLException;

    /**
     * 获取刀具信息
     * @param entiry
     * @return
     * @throws SQLException
     */
    List<Tooltransfer> getToolMsg(Tooltransfer entiry)throws SQLException;

    /**
     * 查询待报废刀具列表信息
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    List<?> searchByList2(BaseEntity entity) throws SQLException;

    /**
     * 按载体ID删除流转中的数据
     * @param list
     */
    int updateBatchbyttRfidConID(List<String> list) throws SQLException;

    int updatecontainerCount(Tooltransfer tt) throws SQLException;

    /**
     * 删除流转中的刀具信息
     * @param list
     * @return
     * @throws SQLException
     */
    int deleteByRfidCodeList(List<String> list) throws SQLException;

    /**
     * 按order分组
     * @param entity
     * @return
     * @throws SQLException
     */
    List<Tooltransfer> searchByListGrouby(Tooltransfer entity) throws SQLException;

    /**
     *
     * @param params
     * updateTime  ,updateUser,stockState,businessFlowLnkID,toolState,toolThisState
     * @return
     * @throws SQLException
     */
    int updatStateByRfidConner(Map<String, Object> params) throws SQLException;

    /**
     * 按照RFIDcode修改状态
     * @param param
     * @return
     * @throws SQLException
     */
    int updateToolStateBatchByRfid(Map<String, Object> param) throws SQLException;

    /**
     * 修改流转表中的信息为待换装状态
     *
     * @param map
     * @return
     */
    int updateToolStateBatchByRFIDConnerID(Map<String, Object> map) throws SQLException;

    /**
     * 修改流转表中的信息为待换装状态加1
     * @param map
     * @return
     * @throws SQLException
     */
    int updateToolStateBatchByRFIDConnerIDAddOne(Map<String, Object> map) throws SQLException;

    // 2017/08/30 宋健 追加↓↓↓　dazhong@YMSC
    List<TooltransferTotal> getTooltransferTotalByKey(BaseEntity entity) throws SQLException;

    int updateTooltransferTotal(BaseEntity entity) throws SQLException;

    List<TooltransferTotal> searchList(BaseEntity entity) throws SQLException;

    int searchCount(BaseEntity entity) throws SQLException;

    List<TooltransferTotal> searchList2(BaseEntity entity) throws SQLException;

    int searchCount2(BaseEntity entity) throws SQLException;

    List<Tooltransfer> searchTooltransferList(Tooltransfer t) throws SQLException;
    // 2017/08/30 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
    int updateTooltransferTotalInfo(TooltransferTotal t) throws SQLException;
    // 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/13 宋健 追加↓↓↓　dazhong@YMSC
    int updateNum(TooltransferTotal t) throws SQLException;
    // 2017/09/13 宋健 追加↑↑↑　dazhong@YMSC

}