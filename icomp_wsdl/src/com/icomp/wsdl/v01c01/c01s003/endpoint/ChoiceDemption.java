package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;
/**
 * 备货信息
 * @ClassName: RedemptionDemption 
 * @author Taoyy
 * @date 2014-10-20 下午03:48:32
 */
public class ChoiceDemption implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1673018997151775652L;
	/* 换领申请流水号	*/ 
	private String redemptionAppliedID;

	
	/**
	 * 换领申请流水号取得
	 * @return redemptionAppliedID
	 */
	public String getRedemptionAppliedID() {
		return redemptionAppliedID;
	}

	/**
	 * 换领申请流水号设定
	 * @param redemptionAppliedID
	 */
	public void setRedemptionAppliedID(String redemptionAppliedID) {
		this.redemptionAppliedID = redemptionAppliedID;
	}

	//扫描数量
	private int scannumber;

	public int getScannumber() {
		return scannumber;
	}

	public void setScannumber(int scannumber) {
		this.scannumber = scannumber;
	}
	//实际数量
	private int reality;
	
	public int getReality() {
		return reality;
	}

	public void setReality(int reality) {
		this.reality = reality;
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

	/* 库位码 */
	private String lblCode;
	
	public String getLblCode() {
		return lblCode;
	}

	public void setLblCode(String lblCode) {
		this.lblCode = lblCode;
	}

	/* 申请数量	*/ 
	private int appliedNumber;

	/**
	 * 申请数量取得
	 * @return appliedNumber
	 */
	public int getAppliedNumber() {
		return appliedNumber;
	}

	/**
	 * 申请数量设定
	 * @param appliedNumber
	 */
	public void setAppliedNumber(int appliedNumber) {
		this.appliedNumber = appliedNumber;
	}

	/* A库数量	*/ 
	private int inventoryCount_A;

	/**
	 * 取得A库数量
	 * @return inventoryCount_A
	 */
	public int getInventoryCount_A() {
		return inventoryCount_A;
	}

	/**
	 * 设定A库数量
	 * @param inventoryCount_A
	 */
	public void setInventoryCount_A(int inventoryCount_A) {
		this.inventoryCount_A = inventoryCount_A;
	}

	/* B库数量	*/ 
	private int inventoryCount_B;

	/**
	 * 取得B库数量
	 * @return inventoryCount_B
	 */
	public int getInventoryCount_B() {
		return inventoryCount_B;
	}

	/**
	 * 设定B库数量
	 * @param inventoryCount_B
	 */
	public void setInventoryCount_B(int inventoryCount_B) {
		this.inventoryCount_B = inventoryCount_B;
	}

	/* 送回数量	*/ 
	private int returnNumber;

	/**
	 * 送回数量取得
	 * @return returnNumber
	 */
	public int getReturnNumber() {
		return returnNumber;
	}

	/**
	 * 送回数量设定
	 * @param returnNumber
	 */
	public void setReturnNumber(int returnNumber) {
		this.returnNumber = returnNumber;
	}

	/* 断刀数量	*/ 
	private int brokenNumber;

	/**
	 * 断刀数量取得
	 * @return brokenNumber
	 */
	public int getBrokenNumber() {
		return brokenNumber;
	}

	/**
	 * 断刀数量设定
	 * @param brokenNumber
	 */
	public void setBrokenNumber(int brokenNumber) {
		this.brokenNumber = brokenNumber;
	}

	/* 丢失数量	*/ 
	private int lostNumber;

	/**
	 * 丢失数量取得
	 * @return lostNumber
	 */
	public int getLostNumber() {
		return lostNumber;
	}

	/**
	 * 丢失数量设定
	 * @param lostNumber
	 */
	public void setLostNumber(int lostNumber) {
		this.lostNumber = lostNumber;
	}
	//到寿数量
	private int finishNumber;

	/**
	 * 到寿数量
	 * @title getFinishNumber 
	 * @return
	 * int
	 */
	public int getFinishNumber() {
		return finishNumber;
	}
	/**
	 * 到寿数量
	 * @title setFinishNumber 
	 * @param finishNumber
	 * void
	 */
	public void setFinishNumber(int finishNumber) {
		this.finishNumber = finishNumber;
	}

    /**
     *备货数量
     */
    private int stockNumber;
    /**
     *备货数量
     */
    public int getStockNumber() {
        return stockNumber;
    }
    /**
     *备货数量
     */
    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    private String processingStatus;


	public String getProcessingStatus() {
		return processingStatus;
	}

	public void setProcessingStatus(String processingStatus) {
		this.processingStatus = processingStatus;
	}

    /**
     * 已领取数量
     */
    private int receiveNumber;

    public int getReceiveNumber() {
        return receiveNumber;
    }

    public void setReceiveNumber(int receiveNumber) {
        this.receiveNumber = receiveNumber;
    }
}
