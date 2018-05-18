/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/06/13 17:12:07
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 17:12:07
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * 
 */
public class Toollibraryhistory extends ToollibraryhistoryWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 出库ID	*/ 
	private String toolLiberyID;

	/**
	 * 出库ID取得
	 * @return toolLiberyID
	 */
	public String getToolLiberyID() {
		return toolLiberyID;
	}

	/**
	 * 出库ID设定
	 * @param toolLiberyID
	 */
	public void setToolLiberyID(String toolLiberyID) {
		this.toolLiberyID = toolLiberyID;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCode;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCode
	 */
	public String getKnifeInventoryCode() {
		return knifeInventoryCode;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCode
	 */
	public void setKnifeInventoryCode(String knifeInventoryCode) {
		this.knifeInventoryCode = knifeInventoryCode;
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

	/* 领取人	*/ 
	private String receiveUser;

	/**
	 * 领取人取得
	 * @return receiveUser
	 */
	public String getReceiveUser() {
		return receiveUser;
	}

	/**
	 * 领取人设定
	 * @param receiveUser
	 */
	public void setReceiveUser(String receiveUser) {
		this.receiveUser = receiveUser;
	}

	/* 领取数量	*/ 
	private BigDecimal receiveCount;

	/**
	 * 领取数量取得
	 * @return receiveCount
	 */
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}

	/**
	 * 领取数量设定
	 * @param receiveCount
	 */
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}

	/* 领取时间	*/ 
	private Date receiveTime;

	/**
	 * 领取时间取得
	 * @return receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * 领取时间设定
	 * @param receiveTime
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/* 出库原因(0申领1换领2外借)	*/ 
	private String libraryCause;

	/**
	 * 出库原因(0申领1换领2外借)取得
	 * @return libraryCause
	 */
	public String getLibraryCause() {
		return libraryCause;
	}

	/**
	 * 出库原因(0申领1换领2外借)设定
	 * @param libraryCause
	 */
	public void setLibraryCause(String libraryCause) {
		this.libraryCause = libraryCause;
	}

	/* 上传状态	*/ 
	private BigDecimal state;

	/**
	 * 上传状态取得
	 * @return state
	 */
	public BigDecimal getState() {
		return state;
	}

	/**
	 * 上传状态设定
	 * @param state
	 */
	public void setState(BigDecimal state) {
		this.state = state;
	}
}

