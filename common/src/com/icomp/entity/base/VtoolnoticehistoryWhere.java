/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/02/25 15:44:05
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

import java.util.Date;
import java.math.BigDecimal;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/02/25 15:44:05
 * 创建者  ：工具自动生成
 * 
 */
public class VtoolnoticehistoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具分类(0刀具1辅具2配套9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具分类(0刀具1辅具2配套9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 刀具编码	*/ 
	private String systeCodeWhere;

	/**
	 * 刀具编码取得
	 * @return systeCodeWhere
	 */
	public String getSysteCodeWhere () {
		return systeCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param systeCodeWhere
	 */
	public void setSysteCodeWhere (String systeCodeWhere) {
		this.systeCodeWhere = systeCodeWhere;
	}

	/* 修复时间	*/ 
	private Date noticeTimeWhere;

	/**
	 * 修复时间取得
	 * @return noticeTimeWhere
	 */
	public Date getNoticeTimeWhere () {
		return noticeTimeWhere;
	}

	/**
	 * 修复时间设定
	 * @param noticeTimeWhere
	 */
	public void setNoticeTimeWhere (Date noticeTimeWhere) {
		this.noticeTimeWhere = noticeTimeWhere;
	}

	/* 操作人	*/ 
	private String toolRepairNoticeUserWhere;

	/**
	 * 操作人取得
	 * @return toolRepairNoticeUserWhere
	 */
	public String getToolRepairNoticeUserWhere () {
		return toolRepairNoticeUserWhere;
	}

	/**
	 * 操作人设定
	 * @param toolRepairNoticeUserWhere
	 */
	public void setToolRepairNoticeUserWhere (String toolRepairNoticeUserWhere) {
		this.toolRepairNoticeUserWhere = toolRepairNoticeUserWhere;
	}

	/* 	*/ 
	private String repairIDWhere;

	/**
	 * 取得
	 * @return repairIDWhere
	 */
	public String getRepairIDWhere () {
		return repairIDWhere;
	}

	/**
	 * 设定
	 * @param repairIDWhere
	 */
	public void setRepairIDWhere (String repairIDWhere) {
		this.repairIDWhere = repairIDWhere;
	}

	/* 设备编码	*/ 
	private String equipmentCodeWhere;

	/**
	 * 设备编码取得
	 * @return equipmentCodeWhere
	 */
	public String getEquipmentCodeWhere () {
		return equipmentCodeWhere;
	}

	/**
	 * 设备编码设定
	 * @param equipmentCodeWhere
	 */
	public void setEquipmentCodeWhere (String equipmentCodeWhere) {
		this.equipmentCodeWhere = equipmentCodeWhere;
	}

	/* 修复数量	*/ 
	private BigDecimal noticeCountWhere;

	/**
	 * 修复数量取得
	 * @return noticeCountWhere
	 */
	public BigDecimal getNoticeCountWhere () {
		return noticeCountWhere;
	}

	/**
	 * 修复数量设定
	 * @param noticeCountWhere
	 */
	public void setNoticeCountWhere (BigDecimal noticeCountWhere) {
		this.noticeCountWhere = noticeCountWhere;
	}

	/* 修复原因(0断刀1正常刃磨)	*/ 
	private String repairedBecauseWhere;

	/**
	 * 修复原因(0断刀1正常刃磨)取得
	 * @return repairedBecauseWhere
	 */
	public String getRepairedBecauseWhere () {
		return repairedBecauseWhere;
	}

	/**
	 * 修复原因(0断刀1正常刃磨)设定
	 * @param repairedBecauseWhere
	 */
	public void setRepairedBecauseWhere (String repairedBecauseWhere) {
		this.repairedBecauseWhere = repairedBecauseWhere;
	}
}

