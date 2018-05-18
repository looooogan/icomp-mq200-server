/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2015/03/09 14:13:26
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2015/03/09 14:13:26
 * 创建者  ：杨作庆
 * 
 */
public class Vredemptionappdetailedmsgnew extends VredemptionappdetailedmsgnewWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 申请人	*/ 
	private String applyUser;

	/**
	 * 申请人取得
	 * @return applyUser
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * 申请人设定
	 * @param applyUser
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/* 刀具编码	*/ 
	private String toolCode;

	/**
	 * 刀具编码取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具编码设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 	*/ 
	private String lblCode;

    public String getLblCode() {
        return lblCode;
    }

    public void setLblCode(String lblCode) {
        this.lblCode = lblCode;
    }

    /**
	 * 取得
	 * @return lblCode
	 */


	/* 申请数量	*/ 
	private BigDecimal appliedNumber;

	/**
	 * 申请数量取得
	 * @return appliedNumber
	 */
	public BigDecimal getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 申请数量设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(BigDecimal appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/* 备货数量	*/ 
	private BigDecimal stockNumber;

	/**
	 * 备货数量取得
	 * @return stockNumber
	 */
	public BigDecimal getStockNumber() {
		return stockNumber;
	}

	/**
	 * 备货数量设定
	 * @param stockNumber
	 */
	public void setStockNumber(BigDecimal stockNumber) {
		this.stockNumber = stockNumber;
	}

	/* 申请时间	*/ 
	private  String applyTime;

	/**
	 * 申请时间取得
	 * @return applyTime
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * 申请时间设定
	 * @param applyTime
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_A;

	/**
	 * 取得
	 * @return inventoryCount_A
	 */
	public BigDecimal getInventoryCount_A() {
		return inventoryCount_A;
	}

	/**
	 * 设定
	 * @param inventoryCount_A
	 */
	public void setInventoryCount_A(BigDecimal inventoryCount_A) {
		this.inventoryCount_A = inventoryCount_A;
	}

	/* 	*/ 
	private BigDecimal inventoryCount_B;

	/**
	 * 取得
	 * @return inventoryCount_B
	 */
	public BigDecimal getInventoryCount_B() {
		return inventoryCount_B;
	}

	/**
	 * 设定
	 * @param inventoryCount_B
	 */
	public void setInventoryCount_B(BigDecimal inventoryCount_B) {
		this.inventoryCount_B = inventoryCount_B;
	}

	/* 送回数量	*/ 
	private BigDecimal returnNumber;

	/**
	 * 送回数量取得
	 * @return returnNumber
	 */
	public BigDecimal getReturnNumber() {
		return returnNumber;
	}

	/**
	 * 送回数量设定
	 * @param returnNumber
	 */
	public void setReturnNumber(BigDecimal returnNumber) {
		this.returnNumber = returnNumber;
	}

	/* 断刀数量	*/ 
	private BigDecimal brokenNumber;

	/**
	 * 断刀数量取得
	 * @return brokenNumber
	 */
	public BigDecimal getBrokenNumber() {
		return brokenNumber;
	}

	/**
	 * 断刀数量设定
	 * @param brokenNumber
	 */
	public void setBrokenNumber(BigDecimal brokenNumber) {
		this.brokenNumber = brokenNumber;
	}

	/* 丢失数量	*/ 
	private BigDecimal lostNumber;

	/**
	 * 丢失数量取得
	 * @return lostNumber
	 */
	public BigDecimal getLostNumber() {
		return lostNumber;
	}

	/**
	 * 丢失数量设定
	 * @param lostNumber
	 */
	public void setLostNumber(BigDecimal lostNumber) {
		this.lostNumber = lostNumber;
	}

	/* 到寿数量	*/ 
	private BigDecimal lifeOverNumber;

	/**
	 * 到寿数量取得
	 * @return lifeOverNumber
	 */
	public BigDecimal getLifeOverNumber() {
		return lifeOverNumber;
	}

	/**
	 * 到寿数量设定
	 * @param lifeOverNumber
	 */
	public void setLifeOverNumber(BigDecimal lifeOverNumber) {
		this.lifeOverNumber = lifeOverNumber;
	}

    /**
     * 当前状态
     */
    private String processingStatus;

    public String getProcessingStatus() {

        return processingStatus;
    }
    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    /**
     * 刀具类型
     */
    private String toolConsumetype;
    //临时值（申请单号暂时无用）
    private String redemptionAppliedID;

    public String getToolConsumetype() {
        return toolConsumetype;
    }

    public void setToolConsumetype(String toolConsumetype) {
        this.toolConsumetype = toolConsumetype;
    }

    public String getRedemptionAppliedID() {
        return redemptionAppliedID;
    }

    public void setRedemptionAppliedID(String redemptionAppliedID) {
        this.redemptionAppliedID = redemptionAppliedID;
    }

    private BigDecimal receiveNumber;

    public BigDecimal getReceiveNumber() {
        return receiveNumber;
    }

    public void setReceiveNumber(BigDecimal receiveNumber) {
        this.receiveNumber = receiveNumber;
    }
}

