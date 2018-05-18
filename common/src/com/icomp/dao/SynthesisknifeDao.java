/*
 * 工具自动生成：合成刀库DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.dao.BaseDao;
import com.icomp.common.entity.BaseEntity;
import com.icomp.entity.base.Synthesisknife;

/**
 * 继承父接口
 *
 * @author 工具自动生成
 */
public interface SynthesisknifeDao extends BaseDao {
    /**
     * 更新刀具为已回收状态
     *
     * @param list
     * @return
     * @throws Exception int
     * @title updateBatchs
     */
    public int updateBatchs(List<Synthesisknife> list) throws Exception;

    /**
     * 根据RFID批量更新合成刀具
     *
     * @param map
     * @return
     * @throws Exception int
     * @title updateBatchByRfid
     */
    public int updateBatchByRfid(Map<String, Object> map) throws Exception;

    /**
     * 查询合成刀具详细信息
     *
     * @param sk
     * @return List<Synthesisknife>
     * @title searchListByRfid
     */
    public List<Synthesisknife> searchListByRfid(Synthesisknife sk) throws Exception;

    /**
     * 按RFID打到合成刀库中的对应的数据
     * 只是单个的RFID并且查询出的列中不包含辅具
     *
     * @param rfidString
     * @return
     * @throws Exception List<Synthesisknife>
     * @title findskListByRfid
     */
    public List<Synthesisknife> findskListByRfid(String rfidString) throws Exception;

    /**
     * 根据刀具入库编码修改下一流程和刀具安上状态
     *
     * @param synthesisCode:合成刀具编码
     * @param synthesisNumber:编号
     * @param businessFlowLnkID:最后执行业务流程
     * @param list:刀具入库编码list
     * @param updateTime:修改时间
     * @param userId:修改人
     * @param installFlag:安装状态
     * @return
     * @throws Exception int
     * @title updateListbyCode
     */
    public int updateListbyCode(HashMap<String, Object> map) throws Exception;

    /**
     * 按主键查询-SynthesisParametersCode模糊查询
     *
     * @param entity 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    List<Synthesisknife> searchByList_F(BaseEntity entity) throws SQLException;

    int updateBatchDeFlagByRfid(Map<String, Object> map) throws SQLException;

    /**
     * 按照RFID查询对应的合成刀具（只辅具）
     *
     * @param list
     * @return
     * @throws SQLException
     */
    List<Synthesisknife> findskListByRfidList(List<String> list) throws SQLException;

    /**
     * 查询数据条数
     *
     * @param entity 查询条件
     * @return 条数
     * @throws SQLException
     */
    int searchByCount_F(BaseEntity entity) throws SQLException;

    /**
     * 根据载体id查询合成刀具编码
     *
     * @param entity
     * @return
     */
    public Synthesisknife getSynthesisknife(Synthesisknife entity) throws SQLException;

    Synthesisknife getSynParameNumber(Synthesisknife sk) throws Exception;

    Synthesisknife getSynthesisknifebyRfidc(Synthesisknife skEntity) throws Exception;

    Object insertBatchs(List<Synthesisknife> sk) throws Exception;

    Synthesisknife getSynthesisParametersNumberMAX(Synthesisknife skn) throws Exception;

    Synthesisknife getSynCodeByRfidConner(Synthesisknife skentity) throws Exception;

    Object submitInitSynthesis(List<Synthesisknife> sk) throws Exception;

    Synthesisknife searchBySynthesisknife(Synthesisknife entity) throws Exception;

    int deleteBatchByRfidCodeList(List<String> rfidCodes) throws SQLException;

    // 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
    Synthesisknife searchSyn(Synthesisknife entity) throws Exception;
    // 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    List<Synthesisknife> searchSynthesisknifeList(BaseEntity entity) throws SQLException;

    int searchSynthesisknifeListByCount(BaseEntity entity) throws SQLException;
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
}

