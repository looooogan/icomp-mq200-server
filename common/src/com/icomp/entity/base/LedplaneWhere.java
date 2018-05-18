/*
 * 工具自动生成：专机领用申请条件实体类
 * 生成时间    : 2015/03/31 14:01:09
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 专机领用申请条件实体类
 *
 * @author 工具自动生成
 *         创建时间：2015/03/31 14:01:09
 *         创建者  ：杨作庆
 */
public class LedplaneWhere extends BaseEntity implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    /* 专机领用申请ID	*/
    private String ledPlaneIDWhere;

    /**
     * 专机领用申请ID取得
     *
     * @return ledPlaneIDWhere
     */
    public String getLedPlaneIDWhere() {
        return ledPlaneIDWhere;
    }

    /**
     * 专机领用申请ID设定
     *
     * @param ledPlaneIDWhere
     */
    public void setLedPlaneIDWhere(String ledPlaneIDWhere) {
        this.ledPlaneIDWhere = ledPlaneIDWhere;
    }

    /* 刀具编码	*/
    private String toolIDWhere;

    /**
     * 刀具编码取得
     *
     * @return toolIDWhere
     */
    public String getToolIDWhere() {
        return toolIDWhere;
    }

    /**
     * 刀具编码设定
     *
     * @param toolIDWhere
     */
    public void setToolIDWhere(String toolIDWhere) {
        this.toolIDWhere = toolIDWhere;
    }

    /* 申请数量	*/
    private BigDecimal ledPlaneCountWhere;

    /**
     * 申请数量取得
     *
     * @return ledPlaneCountWhere
     */
    public BigDecimal getLedPlaneCountWhere() {
        return ledPlaneCountWhere;
    }

    /**
     * 申请数量设定
     *
     * @param ledPlaneCountWhere
     */
    public void setLedPlaneCountWhere(BigDecimal ledPlaneCountWhere) {
        this.ledPlaneCountWhere = ledPlaneCountWhere;
    }

    /* 申请时间	*/
    private Date ledPlaneTimeWhere;

    /**
     * 申请时间取得
     *
     * @return ledPlaneTimeWhere
     */
    public Date getLedPlaneTimeWhere() {
        return ledPlaneTimeWhere;
    }

    /**
     * 申请时间设定
     *
     * @param ledPlaneTimeWhere
     */
    public void setLedPlaneTimeWhere(Date ledPlaneTimeWhere) {
        this.ledPlaneTimeWhere = ledPlaneTimeWhere;
    }

    /* 申请人	*/
    private String ledPlaneUserWhere;

    /**
     * 申请人取得
     *
     * @return ledPlaneUserWhere
     */
    public String getLedPlaneUserWhere() {
        return ledPlaneUserWhere;
    }

    /**
     * 申请人设定
     *
     * @param ledPlaneUserWhere
     */
    public void setLedPlaneUserWhere(String ledPlaneUserWhere) {
        this.ledPlaneUserWhere = ledPlaneUserWhere;
    }

    /* 实际领取数量	*/
    private BigDecimal returnCountWhere;

    /**
     * 实际领取数量取得
     *
     * @return returnCountWhere
     */
    public BigDecimal getReturnCountWhere() {
        return returnCountWhere;
    }

    /**
     * 实际领取数量设定
     *
     * @param returnCountWhere
     */
    public void setReturnCountWhere(BigDecimal returnCountWhere) {
        this.returnCountWhere = returnCountWhere;
    }

    /* 实际领取时间	*/
    private Date returnTimeWhere;

    /**
     * 实际领取时间取得
     *
     * @return returnTimeWhere
     */
    public Date getReturnTimeWhere() {
        return returnTimeWhere;
    }

    /**
     * 实际领取时间设定
     *
     * @param returnTimeWhere
     */
    public void setReturnTimeWhere(Date returnTimeWhere) {
        this.returnTimeWhere = returnTimeWhere;
    }

    /* 确认人	*/
    private String confirmUserWhere;

    /**
     * 确认人取得
     *
     * @return confirmUserWhere
     */
    public String getConfirmUserWhere() {
        return confirmUserWhere;
    }

    /**
     * 确认人设定
     *
     * @param confirmUserWhere
     */
    public void setConfirmUserWhere(String confirmUserWhere) {
        this.confirmUserWhere = confirmUserWhere;
    }

    /* 处理状态(0:新建1备货2领取3送回确认)	*/
    private String ledPlaneStautsWhere;

    /**
     * 处理状态(0:新建1备货2领取3送回确认)取得
     *
     * @return ledPlaneStautsWhere
     */
    public String getLedPlaneStautsWhere() {
        return ledPlaneStautsWhere;
    }

    /**
     * 处理状态(0:新建1备货2领取3送回确认)设定
     *
     * @param ledPlaneStautsWhere
     */
    public void setLedPlaneStautsWhere(String ledPlaneStautsWhere) {
        this.ledPlaneStautsWhere = ledPlaneStautsWhere;
    }
}

