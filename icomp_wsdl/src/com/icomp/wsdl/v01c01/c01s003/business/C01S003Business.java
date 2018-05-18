package com.icomp.wsdl.v01c01.c01s003.business;

import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Request;
import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Respons;

/**
 * 刀具换领-Business接口
 *
 * @author Taoyy
 * @ClassName: C01S003Business
 * @date 2016-3-4 下午01:24:40
 */
public interface C01S003Business {

    /**
     * 取得换领申请人申请信息
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title getApplyInfo
     */
    public C01S003Respons getApplyInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 取得要换领出库的刀具信息
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title getRedemptionapplyInfo
     */
    public C01S003Respons getRedemptionapplyInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 提交换领出库的刀具信息
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title saveRedemptionapplyInfo
     */
    public C01S003Respons saveRedemptionapplyInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 取得换领申请单
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title getRedemptionInfo
     */
    public C01S003Respons getRedemptionInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 取得换领申请单明细
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title getRfidType
     */
    public C01S003Respons getRedemptionDetail(C01S003Request regSwitch) throws Exception;

    /**
     * 取得待换领刀具信息
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title getRedemptionToolInfo
     */
    public C01S003Respons getRedemptionToolInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 备货刀具出库
     *
     * @param regSwitch
     * @return C01S003Respons
     * @title saveOutputStockingTool
     */
    public C01S003Respons saveOutputStockingTool(C01S003Request regSwitch) throws Exception;

    /**
     * 换领结束，更新申请单
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title saveRedemptionInfo
     */
    public C01S003Respons saveRedemptionInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 保存换领出库信息-非单品
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title saveRedemptionInfo
     */
    public C01S003Respons saveRedemptionApplied(C01S003Request regSwitch) throws Exception;

    /**
     * 更新备货刀具状态
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title saveStockingToolStauts
     */
    public C01S003Respons saveStockingToolStauts(C01S003Request regSwitch) throws Exception;

    /**
     * 查询单品刀具信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title seachToolInfo
     */
    public C01S003Respons seachToolInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 验证是否存在专机领用数据
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title existLedplane
     */
    public C01S003Respons existLedplane(C01S003Request regSwitch) throws Exception;

    /**
     * 取得区分值列表
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title getComlist
     */
    public C01S003Respons getComlist(C01S003Request regSwitch) throws Exception;

    /**
     * 取得扫描标签的绑定刀具数量及刀具编码
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title getToolInfo
     */
    public C01S003Respons getToolInfo(C01S003Request regSwitch) throws Exception;

    /**
     * 保存专机领用数据
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title saveLedplane
     */
    public C01S003Respons saveLedplane(C01S003Request regSwitch) throws Exception;

    /**
     * 取得换领申请单列表按照人名和日期进行排序并显示在list中
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S004Respons
     * @title saveStockingToolStauts
     */
    public C01S003Respons getRequestList(C01S003Request regSwitch) throws Exception;

    /**
     * 取得用户选择的申请人、申请时间对应的备货信息
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S004Respons
     * @title getChoiceList
     */
    public C01S003Respons getChoiceList(C01S003Request regSwitch) throws Exception;

    /**
     * 取得前页面传递的用户选择的申请单归还清单
     *
     * @param regSwitch
     * @return
     * @throws Exception C01S003Respons
     * @title getRemand
     */
    public C01S003Respons getRemand(C01S003Request regSwitch) throws Exception;

    /**
     * 备货信息提交
     *
     * @param regSwitch
     * @throws Exception
     */
    public C01S003Respons stockMsgSubmit(C01S003Request regSwitch) throws Exception;

    /**
     * 领刀授权提交
     *
     * @param regSwitch
     * @return
     * @throws Exception
     */
    public C01S003Respons saveGetChangeTool(C01S003Request regSwitch) throws Exception;

    /**
     * 刀具送回信息提交
     *
     * @param request
     * @return
     * @throws Exception
     */
    C01S003Respons reToolSubmit(C01S003Request request) throws Exception;

    /**
     * 取得已备货的刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    C01S003Respons getReadiedToolsMessage(C01S003Request request) throws Exception;

    /**
     * 非单品-获取换领出库申请人
     *
     * @param regSwitch
     * @return
     * @throws Exception
     */
    C01S003Respons getApplyUser(C01S003Request regSwitch) throws Exception;

    /**
     * 非单品-获取换领出库申请单
     */

    C01S003Respons getRedemptionappliedListCodeByUserid(C01S003Request request)
            throws Exception;

    /**
     * 非单品-获取换领出库申请单
     */
    C01S003Respons getToolInfoFD(C01S003Request regSwitch) throws Exception;
}
