/*
 * 工具自动生成：厂外修复表实体类
 * 生成时间    : 2016/02/25 19:22:51
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;


/**
 * 厂外修复表实体类
 * @author 工具自动生成
 * 创建时间：2016/02/25 19:22:51
 * 创建者  ：yzq
 * 更新者  ：taoyy
 *
 */
public class Outsidefactory extends OutsidefactoryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 厂外修复ID	*/
	private String outsideFactoryID;

	/**
	 * 厂外修复ID取得
	 * @return outsideFactoryID
	 */
	public String getOutsideFactoryID() {
		return outsideFactoryID;
	}

	/**
	 * 厂外修复ID设定
	 * @param outsideFactoryID
	 */
	public void setOutsideFactoryID(String outsideFactoryID) {
		this.outsideFactoryID = outsideFactoryID;
	}

	/* 通知单号	*/
	private String orderNum;

	/**
	 * 通知单号取得
	 * @return orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * 通知单号设定
	 * @param orderNum
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/* 商家ID	*/
	private String merchantsID;

	/**
	 * 商家ID取得
	 * @return merchantsID
	 */
	public String getMerchantsID() {
		return merchantsID;
	}

	/**
	 * 商家ID设定
	 * @param merchantsID
	 */
	public void setMerchantsID(String merchantsID) {
		this.merchantsID = merchantsID;
	}

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
	private String materialNum;

	/**
	 * 材料号取得
	 * @return materialNum
	 */
	public String getMaterialNum() {
		return materialNum;
	}

	/**
	 * 材料号设定
	 * @param materialNum
	 */
	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}

	/* 修磨数量	*/
	private String numberGrinding;

	/**
	 * 修磨数量取得
	 * @return numberGrinding
	 */
	public String getNumberGrinding() {
		return numberGrinding;
	}

	/**
	 * 修磨数量设定
	 * @param numberGrinding
	 */
	public void setNumberGrinding(String numberGrinding) {
		this.numberGrinding = numberGrinding;
	}

	/* 修复类型（0.厂外图层1.厂外复磨）	*/
	private String grindingType;

	/**
	 * 修复类型（0.厂外图层1.厂外复磨）取得
	 * @return grindingType
	 */
	public String getGrindingType() {
		return grindingType;
	}

	/**
	 * 修复类型（0.厂外图层1.厂外复磨）设定
	 * @param grindingType
	 */
	public void setGrindingType(String grindingType) {
		this.grindingType = grindingType;
	}

	/* 激光码	*/
	private String laserCode;

	/**
	 * 激光码取得
	 * @return laserCode
	 */
	public String getLaserCode() {
		return laserCode;
	}

	/**
	 * 激光码设定
	 * @param laserCode
	 */
	public void setLaserCode(String laserCode) {
		this.laserCode = laserCode;
	}

	/* 刀具类型（0.钻头1.刀片）	*/
	private String toolType;

	/**
	 * 刀具类型（0.钻头1.刀片）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具类型（0.钻头1.刀片）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	/* 出厂日期	*/
	private Date manufactureDate;

	/**
	 * 出厂日期取得
	 * @return manufactureDate
	 */
	public Date getManufactureDate() {
		return manufactureDate;
	}

	/**
	 * 出厂日期设定
	 * @param manufactureDate
	 */
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	/* 审批人	*/
	private String approver;

	/**
	 * 审批人取得
	 * @return approver
	 */
	public String getApprover() {
		return approver;
	}

	/**
	 * 审批人设定
	 * @param approver
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}

	/* 修复状态(0.未修复1.已修复2.其他）	*/
	private String repairState;

	/**
	 * 修复状态(0.未修复1.已修复2.其他）取得
	 * @return repairState
	 */
	public String getRepairState() {
		return repairState;
	}

	/**
	 * 修复状态(0.未修复1.已修复2.其他）设定
	 * @param repairState
	 */
	public void setRepairState(String repairState) {
		this.repairState = repairState;
	}

	/* 备注	*/
	private String note;

	/**
	 * 备注取得
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * 备注设定
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 刀具名称
	 */
	private String toolName;

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	/**
	 * 出门单号
	 */
	private String outDoorNom;

	public String getOutDoorNom() {
		return outDoorNom;
	}

	public void setOutDoorNom(String outDoorNom) {
		this.outDoorNom = outDoorNom;
	}

	/**
	 * 回厂数量
	 */
	private String backFactoryNumber;

	public String getBackFactoryNumber() {
		return backFactoryNumber;
	}

	public void setBackFactoryNumber(String backFactoryNumber) {
		this.backFactoryNumber = backFactoryNumber;
	}

	/* 回厂日期	*/
	private Date createTime;

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// 2017/08/21 宋健 追加↓↓↓　dazhong@YMSC
	public int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/* 回厂日期	*/
	private Date updateTime;

	/**
	 * 回厂日期取得
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 回厂日期设定
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	// 2017/08/21 宋健 追加↑↑↑　dazhong@YMSC

	// 2017/09/11 宋健 追加↓↓↓　dazhong@YMSC
	private String sendUser;

	public String getSendUser() {
		return sendUser;
	}

	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}

	private String descr;

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String lastBackNum;

	public String getLastBackNum() {
		return lastBackNum;
	}

	public void setLastBackNum(String lastBackNum) {
		this.lastBackNum = lastBackNum;
	}

	public String receiveNumber;

	public String getReceiveNumber() {
		return receiveNumber;
	}

	public void setReceiveNumber(String receiveNumber) {
		this.receiveNumber = receiveNumber;
	}

	// 2017/09/11 宋健 追加↑↑↑　dazhong@YMSC
}

