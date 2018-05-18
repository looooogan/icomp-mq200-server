/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/28 16:09:55
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/28 16:09:55
 * 创建者  ：杨作庆
 * 
 */
public class VledplanelistWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 专机领用申请ID	*/ 
	private String ledPlaneIDWhere;

	/**
	 * 专机领用申请ID取得
	 * @return ledPlaneIDWhere
	 */
	public String getLedPlaneIDWhere () {
		return ledPlaneIDWhere;
	}

	/**
	 * 专机领用申请ID设定
	 * @param ledPlaneIDWhere
	 */
	public void setLedPlaneIDWhere (String ledPlaneIDWhere) {
		this.ledPlaneIDWhere = ledPlaneIDWhere;
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

	/* 领用数量	*/ 
	private BigDecimal ledPlaneCountWhere;

	/**
	 * 领用数量取得
	 * @return ledPlaneCountWhere
	 */
	public BigDecimal getLedPlaneCountWhere () {
		return ledPlaneCountWhere;
	}

	/**
	 * 领用数量设定
	 * @param ledPlaneCountWhere
	 */
	public void setLedPlaneCountWhere (BigDecimal ledPlaneCountWhere) {
		this.ledPlaneCountWhere = ledPlaneCountWhere;
	}

	/* 领用时间	*/ 
	private Date ledPlaneTimeWhere;

	/**
	 * 领用时间取得
	 * @return ledPlaneTimeWhere
	 */
	public Date getLedPlaneTimeWhere () {
		return ledPlaneTimeWhere;
	}

	/**
	 * 领用时间设定
	 * @param ledPlaneTimeWhere
	 */
	public void setLedPlaneTimeWhere (Date ledPlaneTimeWhere) {
		this.ledPlaneTimeWhere = ledPlaneTimeWhere;
	}

	/* 领用人	*/ 
	private String ledPlaneUserWhere;

	/**
	 * 领用人取得
	 * @return ledPlaneUserWhere
	 */
	public String getLedPlaneUserWhere () {
		return ledPlaneUserWhere;
	}

	/**
	 * 领用人设定
	 * @param ledPlaneUserWhere
	 */
	public void setLedPlaneUserWhere (String ledPlaneUserWhere) {
		this.ledPlaneUserWhere = ledPlaneUserWhere;
	}

	/* 送回数量	*/ 
	private BigDecimal returnCountWhere;

	/**
	 * 送回数量取得
	 * @return returnCountWhere
	 */
	public BigDecimal getReturnCountWhere () {
		return returnCountWhere;
	}

	/**
	 * 送回数量设定
	 * @param returnCountWhere
	 */
	public void setReturnCountWhere (BigDecimal returnCountWhere) {
		this.returnCountWhere = returnCountWhere;
	}

	/* 送回时间	*/ 
	private Date returnTimeWhere;

	/**
	 * 送回时间取得
	 * @return returnTimeWhere
	 */
	public Date getReturnTimeWhere () {
		return returnTimeWhere;
	}

	/**
	 * 送回时间设定
	 * @param returnTimeWhere
	 */
	public void setReturnTimeWhere (Date returnTimeWhere) {
		this.returnTimeWhere = returnTimeWhere;
	}

	/* 处理状态(0:新建1备货2领取3送回确认)	*/ 
	private String ledPlaneStautsWhere;

	/**
	 * 处理状态(0:新建1备货2领取3送回确认)取得
	 * @return ledPlaneStautsWhere
	 */
	public String getLedPlaneStautsWhere () {
		return ledPlaneStautsWhere;
	}

	/**
	 * 处理状态(0:新建1备货2领取3送回确认)设定
	 * @param ledPlaneStautsWhere
	 */
	public void setLedPlaneStautsWhere (String ledPlaneStautsWhere) {
		this.ledPlaneStautsWhere = ledPlaneStautsWhere;
	}

	/* 刀具编码	*/ 
	private String toolCodeWhere;

	/**
	 * 刀具编码取得
	 * @return toolCodeWhere
	 */
	public String getToolCodeWhere () {
		return toolCodeWhere;
	}

	/**
	 * 刀具编码设定
	 * @param toolCodeWhere
	 */
	public void setToolCodeWhere (String toolCodeWhere) {
		this.toolCodeWhere = toolCodeWhere;
	}

	/* 姓名	*/ 
	private String userNameWhere;

	/**
	 * 姓名取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 姓名设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}
}

