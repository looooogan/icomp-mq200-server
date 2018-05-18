/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/06/13 18:51:57
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 18:51:57
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public class Vtoolsop extends VtoolsopWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具ID	*/
	private String toolID;

	/**
	 * 刀具ID取得
	 * @return toolID
	 */
	public String getToolID() {
		return toolID;
	}

	/**
	 * 刀具ID设定
	 * @param toolID
	 */
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	/* 材料号	*/
	private String toolCode;

	/**
	 * 材料号取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 材料号设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 入库数量	*/
	private BigDecimal storageNum;

	/**
	 * 入库数量取得
	 * @return storageNum
	 */
	public BigDecimal getStorageNum() {
		return storageNum;
	}

	/**
	 * 入库数量设定
	 * @param storageNum
	 */
	public void setStorageNum(BigDecimal storageNum) {
		this.storageNum = storageNum;
	}

	/* 	*/
	private BigDecimal receiveCount;

	/**
	 * 取得
	 * @return receiveCount
	 */
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}

	/**
	 * 设定
	 * @param receiveCount
	 */
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}

	/* 	*/
	private String inLiber;

	/**
	 * 取得
	 * @return inLiber
	 */
	public String getInLiber() {
		return inLiber;
	}

	/**
	 * 设定
	 * @param inLiber
	 */
	public void setInLiber(String inLiber) {
		this.inLiber = inLiber;
	}

	/* 	*/
	private String outLiber;

	/**
	 * 取得
	 * @return outLiber
	 */
	public String getOutLiber() {
		return outLiber;
	}

	/**
	 * 设定
	 * @param outLiber
	 */
	public void setOutLiber(String outLiber) {
		this.outLiber = outLiber;
	}

	/* 创建者	*/
	private String libraryUser;

	/**
	 * 创建者取得
	 * @return libraryUser
	 */
	public String getLibraryUser() {
		return libraryUser;
	}

	/**
	 * 创建者设定
	 * @param libraryUser
	 */
	public void setLibraryUser(String libraryUser) {
		this.libraryUser = libraryUser;
	}

	/* 上传状态	*/
	private BigDecimal stateTs;

	/**
	 * 上传状态取得
	 * @return stateTs
	 */
	public BigDecimal getStateTs() {
		return stateTs;
	}

	/**
	 * 上传状态设定
	 * @param stateTs
	 */
	public void setStateTs(BigDecimal stateTs) {
		this.stateTs = stateTs;
	}

	/* 上传状态	*/
	private String stateSt;

	/**
	 * 上传状态取得
	 * @return stateSt
	 */
	public String getStateSt() {
		return stateSt;
	}

	/**
	 * 上传状态设定
	 * @param stateSt
	 */
	public void setStateSt(String stateSt) {
		this.stateSt = stateSt;
	}

	private String toolType;
	private String dstar;
	private String dend;
	private String userName;
	private String moveType;
	private String outInDate;

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getDstar() {
		return dstar;
	}

	public void setDstar(String dstar) {
		this.dstar = dstar;
	}

	public String getDend() {
		return dend;
	}

	public void setDend(String dend) {
		this.dend = dend;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	public String getOutInDate() {
		return outInDate;
	}

	public void setOutInDate(String outInDate) {
		this.outInDate = outInDate;
	}

	private String valType;
	private String poItem;
	private String sapID;

	public String getValType() {
		return valType;
	}

	public void setValType(String valType) {
		this.valType = valType;
	}

	public String getPoItem() {
		return poItem;
	}

	public void setPoItem(String poItem) {
		this.poItem = poItem;
	}

	public String getSapID() {
		return sapID;
	}

	public void setSapID(String sapID) {
		this.sapID = sapID;
	}
}

