/*
 * 工具自动生成：专机领用申请实体类
 * 生成时间    : 2015/03/31 14:01:09
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 专机领用申请实体类
 *
 * @author 工具自动生成
 *         创建时间：2015/03/31 14:01:09
 *         创建者  ：杨作庆
 */
public class Ledplane extends LedplaneWhere implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    /* 专机领用申请ID	*/
    private String ledPlaneID;

    /**
     * 专机领用申请ID取得
     *
     * @return ledPlaneID
     */
    public String getLedPlaneID() {
        return ledPlaneID;
    }

    /**
     * 专机领用申请ID设定
     *
     * @param ledPlaneID
     */
    public void setLedPlaneID(String ledPlaneID) {
        this.ledPlaneID = ledPlaneID;
    }

    /* 刀具编码	*/
    private String toolID;

    /**
     * 刀具编码取得
     *
     * @return toolID
     */
    public String getToolID() {
        return toolID;
    }

    /**
     * 刀具编码设定
     *
     * @param toolID
     */
    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    /* 申请数量	*/
    private BigDecimal ledPlaneCount;

    /**
     * 申请数量取得
     *
     * @return ledPlaneCount
     */
    public BigDecimal getLedPlaneCount() {
        return ledPlaneCount;
    }

    /**
     * 申请数量设定
     *
     * @param ledPlaneCount
     */
    public void setLedPlaneCount(BigDecimal ledPlaneCount) {
        this.ledPlaneCount = ledPlaneCount;
    }

    /* 申请时间	*/
    private Date ledPlaneTime;

    /**
     * 申请时间取得
     *
     * @return ledPlaneTime
     */
    public Date getLedPlaneTime() {
        return ledPlaneTime;
    }

    /**
     * 申请时间设定
     *
     * @param  ledPlaneTime
     */
    public void setLedPlaneTime(Date ledPlaneTime) {
        this.ledPlaneTime = ledPlaneTime;
    }

    /* 申请人	*/
    private String ledPlaneUser;

    /**
     * 申请人取得
     *
     * @return ledPlaneUser
     */
    public String getLedPlaneUser() {
        return ledPlaneUser;
    }

    /**
     * 申请人设定
     *
     * @param ledPlaneUser
     */
    public void setLedPlaneUser(String ledPlaneUser) {
        this.ledPlaneUser = ledPlaneUser;
    }

    /* 实际领取数量	*/
    private BigDecimal returnCount;

    /**
     * 实际领取数量取得
     *
     * @return returnCount
     */
    public BigDecimal getReturnCount() {
        return returnCount;
    }

    /**
     * 实际领取数量设定
     *
     * @param returnCount
     */
    public void setReturnCount(BigDecimal returnCount) {
        this.returnCount = returnCount;
    }

    /* 实际领取时间	*/
    private Date returnTime;

    /**
     * 实际领取时间取得
     *
     * @return returnTime
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 实际领取时间设定
     *
     * @param returnTime
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    /* 确认人	*/
    private String confirmUser;

    /**
     * 确认人取得
     *
     * @return confirmUser
     */
    public String getConfirmUser() {
        return confirmUser;
    }

    /**
     * 确认人设定
     *
     * @param confirmUser
     */
    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }

    /* 处理状态(0:新建1备货2领取3送回确认)	*/
    private String ledPlaneStauts;

    /**
     * 处理状态(0:新建1备货2领取3送回确认)取得
     *
     * @return ledPlaneStauts
     */
    public String getLedPlaneStauts() {
        return ledPlaneStauts;
    }

    /**
     * 处理状态(0:新建1备货2领取3送回确认)设定
     *
     * @param ledPlaneStauts
     */
    public void setLedPlaneStauts(String ledPlaneStauts) {
        this.ledPlaneStauts = ledPlaneStauts;
    }
}

