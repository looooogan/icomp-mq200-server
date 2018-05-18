/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/06/13 16:54:39
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * VIEW实体类
 *
 * @author 工具自动生成
 *         创建时间：2016/06/13 16:54:39
 *         创建者  ：yzq
 *         更新者  ：taoyy
 */
public class Vpartsmachiningmsg extends VpartsmachiningmsgWhere implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    /* 零部件	*/
    private String partsID;

    /**
     * 零部件取得
     *
     * @return partsID
     */
    public String getPartsID() {
        return partsID;
    }

    /**
     * 零部件设定
     *
     * @param partsID
     */
    public void setPartsID(String partsID) {
        this.partsID = partsID;
    }

    /* 卸下时间	*/
    private Date outerTime;

    /**
     * 卸下时间取得
     *
     * @return outerTime
     */
    public Date getOuterTime() {
        return outerTime;
    }

    /**
     * 卸下时间设定
     *
     * @param outerTime
     */
    public void setOuterTime(Date outerTime) {
        this.outerTime = outerTime;
    }

    /* 刀具ID	*/
    private String toolID;

    /**
     * 刀具ID取得
     *
     * @return toolID
     */
    public String getToolID() {
        return toolID;
    }

    /**
     * 刀具ID设定
     *
     * @param toolID
     */
    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    /* 刀具编码	*/
    private String toolCode;

    /**
     * 刀具编码取得
     *
     * @return toolCode
     */
    public String getToolCode() {
        return toolCode;
    }

    /**
     * 刀具编码设定
     *
     * @param toolCode
     */
    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    /* 刀具分类(0刀具1辅具2配套9其他）	*/
    private String toolType;

    /**
     * 刀具分类(0刀具1辅具2配套9其他）取得
     *
     * @return toolType
     */
    public String getToolType() {
        return toolType;
    }

    /**
     * 刀具分类(0刀具1辅具2配套9其他）设定
     *
     * @param toolType
     */
    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    /* 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他	*/
    private String toolConsumetype;

    /**
     * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他取得
     *
     * @return toolConsumetype
     */
    public String getToolConsumetype() {
        return toolConsumetype;
    }

    /**
     * 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他设定
     *
     * @param toolConsumetype
     */
    public void setToolConsumetype(String toolConsumetype) {
        this.toolConsumetype = toolConsumetype;
    }

    /* 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层	*/
    private String toolGrinding;

    /**
     * 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层取得
     *
     * @return toolGrinding
     */
    public String getToolGrinding() {
        return toolGrinding;
    }

    /**
     * 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层设定
     *
     * @param toolGrinding
     */
    public void setToolGrinding(String toolGrinding) {
        this.toolGrinding = toolGrinding;
    }

    /* 加工数量	*/
    private BigDecimal processAmount;

    /**
     * 加工数量取得
     *
     * @return processAmount
     */
    public BigDecimal getProcessAmount() {
        return processAmount;
    }

    /**
     * 加工数量设定
     *
     * @param processAmount
     */
    public void setProcessAmount(BigDecimal processAmount) {
        this.processAmount = processAmount;
    }

    /* 	*/
    private String avgFrequencyUse;

    /**
     * 取得
     *
     * @return avgFrequencyUse
     */
    public String getAvgFrequencyUse() {
        return avgFrequencyUse;
    }

    /**
     * 设定
     *
     * @param avgFrequencyUse
     */
    public void setAvgFrequencyUse(String avgFrequencyUse) {
        this.avgFrequencyUse = avgFrequencyUse;
    }

    /* 	*/
    private String usedCounts;

    /**
     * 取得
     *
     * @return usedCounts
     */
    public String getUsedCounts() {
        return usedCounts;
    }

    /**
     * 设定
     *
     * @param usedCounts
     */
    public void setUsedCounts(String usedCounts) {
        this.usedCounts = usedCounts;
    }

    /* 	*/
    private String stockCounts;

    /**
     * 取得
     *
     * @return stockCounts
     */
    public String getStockCounts() {
        return stockCounts;
    }

    /**
     * 设定
     *
     * @param stockCounts
     */
    public void setStockCounts(String stockCounts) {
        this.stockCounts = stockCounts;
    }

    /* 	*/
    private String activeCounts;

    /**
     * 取得
     *
     * @return activeCounts
     */
    public String getActiveCounts() {
        return activeCounts;
    }

    /**
     * 设定
     *
     * @param activeCounts
     */
    public void setActiveCounts(String activeCounts) {
        this.activeCounts = activeCounts;
    }

    /* 	*/
    private String goingNewCounts;

    /**
     * 取得
     *
     * @return goingNewCounts
     */
    public String getGoingNewCounts() {
        return goingNewCounts;
    }

    /**
     * 设定
     *
     * @param goingNewCounts
     */
    public void setGoingNewCounts(String goingNewCounts) {
        this.goingNewCounts = goingNewCounts;
    }

    /* 	*/
    private String goingOldCounts;

    /**
     * 取得
     *
     * @return goingOldCounts
     */
    public String getGoingOldCounts() {
        return goingOldCounts;
    }

    /**
     * 设定
     *
     * @param goingOldCounts
     */
    public void setGoingOldCounts(String goingOldCounts) {
        this.goingOldCounts = goingOldCounts;
    }

    /* 	*/
    private String procuresCycle;

    /**
     * 取得
     *
     * @return procuresCycle
     */
    public String getProcuresCycle() {
        return procuresCycle;
    }

    /**
     * 设定
     *
     * @param procuresCycle
     */
    public void setProcuresCycle(String procuresCycle) {
        this.procuresCycle = procuresCycle;
    }

    /* 	*/
    private String purchaseCounts;
    private String goingOldToNewCounts;
    private String paramStringA;
    private String paramStringB;
    private String paramStringC;
    private String paramStringD;

    public String getParamStringA() {
        return paramStringA;
    }

    public void setParamStringA(String paramStringA) {
        this.paramStringA = paramStringA;
    }

    public String getParamStringB() {
        return paramStringB;
    }

    public void setParamStringB(String paramStringB) {
        this.paramStringB = paramStringB;
    }

    public String getParamStringC() {
        return paramStringC;
    }

    public void setParamStringC(String paramStringC) {
        this.paramStringC = paramStringC;
    }

    public String getParamStringD() {
        return paramStringD;
    }

    public void setParamStringD(String paramStringD) {
        this.paramStringD = paramStringD;
    }

    public String getGoingOldToNewCounts() {
        return goingOldToNewCounts;
    }

    public void setGoingOldToNewCounts(String goingOldToNewCounts) {
        this.goingOldToNewCounts = goingOldToNewCounts;
    }

    /**
     * 取得
     *
     * @return purchaseCounts
     */
    public String getPurchaseCounts() {
        return purchaseCounts;
    }

    /**
     * 设定
     *
     * @param purchaseCounts
     */
    public void setPurchaseCounts(String purchaseCounts) {
        this.purchaseCounts = purchaseCounts;
    }
}

