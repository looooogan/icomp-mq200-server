/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/06/13 17:12:07
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/06/13 17:12:07
 * 创建者  ：工具自动生成
 * 
 */
public class ToollibraryhistoryWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 出库ID	*/ 
	private String toolLiberyIDWhere;

	/**
	 * 出库ID取得
	 * @return toolLiberyIDWhere
	 */
	public String getToolLiberyIDWhere () {
		return toolLiberyIDWhere;
	}

	/**
	 * 出库ID设定
	 * @param toolLiberyIDWhere
	 */
	public void setToolLiberyIDWhere (String toolLiberyIDWhere) {
		this.toolLiberyIDWhere = toolLiberyIDWhere;
	}

	/* 刀具入库编码	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 刀具入库编码取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 刀具入库编码设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 刀具ID	*/ 
	private String toolIDWhere;

	/**
	 * 刀具ID取得
	 * @return toolIDWhere
	 */
	public String getToolIDWhere () {
		return toolIDWhere;
	}

	/**
	 * 刀具ID设定
	 * @param toolIDWhere
	 */
	public void setToolIDWhere (String toolIDWhere) {
		this.toolIDWhere = toolIDWhere;
	}

	/* 领取人	*/ 
	private String receiveUserWhere;

	/**
	 * 领取人取得
	 * @return receiveUserWhere
	 */
	public String getReceiveUserWhere () {
		return receiveUserWhere;
	}

	/**
	 * 领取人设定
	 * @param receiveUserWhere
	 */
	public void setReceiveUserWhere (String receiveUserWhere) {
		this.receiveUserWhere = receiveUserWhere;
	}

	/* 领取数量	*/ 
	private BigDecimal receiveCountWhere;

	/**
	 * 领取数量取得
	 * @return receiveCountWhere
	 */
	public BigDecimal getReceiveCountWhere () {
		return receiveCountWhere;
	}

	/**
	 * 领取数量设定
	 * @param receiveCountWhere
	 */
	public void setReceiveCountWhere (BigDecimal receiveCountWhere) {
		this.receiveCountWhere = receiveCountWhere;
	}

	/* 领取时间	*/ 
	private Date receiveTimeWhere;

	/**
	 * 领取时间取得
	 * @return receiveTimeWhere
	 */
	public Date getReceiveTimeWhere () {
		return receiveTimeWhere;
	}

	/**
	 * 领取时间设定
	 * @param receiveTimeWhere
	 */
	public void setReceiveTimeWhere (Date receiveTimeWhere) {
		this.receiveTimeWhere = receiveTimeWhere;
	}

	/* 出库原因(0申领1换领2外借)	*/ 
	private String libraryCauseWhere;

	/**
	 * 出库原因(0申领1换领2外借)取得
	 * @return libraryCauseWhere
	 */
	public String getLibraryCauseWhere () {
		return libraryCauseWhere;
	}

	/**
	 * 出库原因(0申领1换领2外借)设定
	 * @param libraryCauseWhere
	 */
	public void setLibraryCauseWhere (String libraryCauseWhere) {
		this.libraryCauseWhere = libraryCauseWhere;
	}

	/* 上传状态	*/ 
	private BigDecimal stateWhere;

	/**
	 * 上传状态取得
	 * @return stateWhere
	 */
	public BigDecimal getStateWhere () {
		return stateWhere;
	}

	/**
	 * 上传状态设定
	 * @param stateWhere
	 */
	public void setStateWhere (BigDecimal stateWhere) {
		this.stateWhere = stateWhere;
	}
}

