/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/02/25 15:44:05
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/02/25 15:44:05
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Vtoolnoticehistory extends VtoolnoticehistoryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

private  String empCard;


	public String getEmpCard() {
		return empCard;
	}

	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}

	/* 刀具分类(0刀具1辅具2配套9其他）	*/
	private String toolType;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolType
	 */
	public String getToolType() {
		return toolType;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolType
	 */
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	/* 刀具编码	*/ 
	private String systeCode;

	/**
	 * 刀具编码取得
	 * @return systeCode
	 */
	public String getSysteCode() {
		return systeCode;
	}

	/**
	 * 刀具编码设定
	 * @param systeCode
	 */
	public void setSysteCode(String systeCode) {
		this.systeCode = systeCode;
	}

	/* 修复时间	*/ 
	private Date noticeTime;

	/**
	 * 修复时间取得
	 * @return noticeTime
	 */
	public Date getNoticeTime() {
		return noticeTime;
	}

	/**
	 * 修复时间设定
	 * @param noticeTime
	 */
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	/* 操作人	*/ 
	private String toolRepairNoticeUser;

	/**
	 * 操作人取得
	 * @return toolRepairNoticeUser
	 */
	public String getToolRepairNoticeUser() {
		return toolRepairNoticeUser;
	}

	/**
	 * 操作人设定
	 * @param toolRepairNoticeUser
	 */
	public void setToolRepairNoticeUser(String toolRepairNoticeUser) {
		this.toolRepairNoticeUser = toolRepairNoticeUser;
	}

	/* 	*/ 
	private String repairID;

	/**
	 * 取得
	 * @return repairID
	 */
	public String getRepairID() {
		return repairID;
	}

	/**
	 * 设定
	 * @param repairID
	 */
	public void setRepairID(String repairID) {
		this.repairID = repairID;
	}

	/* 设备编码	*/ 
	private String equipmentCode;

	/**
	 * 设备编码取得
	 * @return equipmentCode
	 */
	public String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * 设备编码设定
	 * @param equipmentCode
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	/* 修复数量	*/ 
	private BigDecimal noticeCount;

	/**
	 * 修复数量取得
	 * @return noticeCount
	 */
	public BigDecimal getNoticeCount() {
		return noticeCount;
	}

	/**
	 * 修复数量设定
	 * @param noticeCount
	 */
	public void setNoticeCount(BigDecimal noticeCount) {
		this.noticeCount = noticeCount;
	}

	/* 修复原因(0断刀1正常刃磨)	*/ 
	private String repairedBecause;

	/**
	 * 修复原因(0断刀1正常刃磨)取得
	 * @return repairedBecause
	 */
	public String getRepairedBecause() {
		return repairedBecause;
	}

	/**
	 * 修复原因(0断刀1正常刃磨)设定
	 * @param repairedBecause
	 */
	public void setRepairedBecause(String repairedBecause) {
		this.repairedBecause = repairedBecause;
	}
}

