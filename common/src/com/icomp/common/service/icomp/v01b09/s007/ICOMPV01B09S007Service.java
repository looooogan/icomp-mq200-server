package com.icomp.common.service.icomp.v01b09.s007;

import com.icomp.entity.base.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


/**
 * 修复通知单查询SERVICE接口
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B03S002Service
 * @date 2014-8-20 下午03:57:20
 */
public interface ICOMPV01B09S007Service {
    /**
     * 修复通知单查询
     *
     * @param entity
     * @return Map<String,Object>
     * @title getList
     */
    /**
     * 用户管理
     *
     * @param entity 页面查询条件
     * @return 用户信息
     * @throws
     */
    public Map<String, Object> getMerchantsInfo(Merchants entity);

    public Map<String, Object> getList(Outsidefactory entity);

    public Map<String, Object> getLists(Voutsidefactory entity);

    /**
     * @param entity
     * @return
     */


    public Map<String, Object> getlistsMer(Merchants entity);

    /**
     * 厂外修复添加
     *
     * @param outsidefactory
     * @param langCode
     * @param langValue
     * @return
     * @throws SQLException
     */
    Map<String, Object> outFactoryAdd(Outsidefactory outsidefactory, String langCode, String langValue);

    /**
     * 厂外商家添加
     *
     * @param merchants
     * @param langCode
     * @param langValue
     * @return
     */
    Map<String, Object> merchantsAdd(Merchants merchants, String langCode, String langValue);

    /**
     * 厂外商家编辑
     *
     * @param merchants
     * @param langCode
     * @param langValue
     * @return
     */
    Map<String, Object> merchantEdit(Merchants merchants, String langCode, String langValue);

    /**
     * 厂外商家删除
     *
     * @param merchants
     * @param langCode
     * @param langValue
     * @return
     */
    Map<String, Object> merchantDel(Merchants merchants, String langCode, String langValue,String userID);

    Map<String, Object> merchantsFind(Merchants entity);

    /**
     * 取得件列表
     *
     * @return
     */
    public List<Merchants> getPartsLine();

    Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, int checkType,String userID);


    List<Outsidefactory> outFactoryList(Outsidefactory out);

    Map<String,Object> getOutList(Outsidefactory entity);

    Map<String,Object> outsidefactoryEdid(Outsidefactory outsidefactory, String langCode, String langValue);

    Map<String,Object> outsidefactoryEdid2(Outsidefactory outsidefactory, String langCode, String langValue) throws ParseException;

    List<Tool> toolListB(Tool t);

    List<Merchants> getMerchan(Merchants mer);

    String getNumber();

    String getMnumber();

    Map<String,Object> getOutsideFactoryList(Outsidefactory outsidefactory);

    // 2017/09/12 宋健 追加↓↓↓　dazhong@YMSC
    Map<String,Object> getRfidcontainerList(Rfidcontainer rf);

    Synthesisknife getSynByRfidConner(Synthesisknife skentity)throws Exception;

    Tool searchToolInfoBySpcode(String spCode);

    int updateSynthesisknife(Synthesisknife sk);

    int insertAuthorizationDao(Authorization authorization);

    List<Tooltransfer> searchTooltransferList(Tooltransfer t);

    int updateTooltransfer(Tooltransfer t);

    TooltransferTotal getTooltransferTotalInfoByToolCode(TooltransferTotal t);

    int updateTooltransferTotalInfo(TooltransferTotal tst);

    Tool searchBitInputInf(Tool entity);

    Rfidcontainer getRfidInfoByRfid(String rfId);
    // 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC
}

