/*
 * 工具自动生成：条件实体类
 * 生成时间    : 2016/09/04 16:21:29
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 条件实体类
 * @author 工具自动生成
 * 创建时间：2016/09/04 16:21:29
 * 创建者  ：工具自动生成
 * 
 */
public class ScrapWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 报废ID	*/ 
	private String scrapIDWhere;

	/**
	 * 报废ID取得
	 * @return scrapIDWhere
	 */
	public String getScrapIDWhere () {
		return scrapIDWhere;
	}

	/**
	 * 报废ID设定
	 * @param scrapIDWhere
	 */
	public void setScrapIDWhere (String scrapIDWhere) {
		this.scrapIDWhere = scrapIDWhere;
	}

	/* 刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）	*/ 
	private String toolTypeWhere;

	/**
	 * 刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）取得
	 * @return toolTypeWhere
	 */
	public String getToolTypeWhere () {
		return toolTypeWhere;
	}

	/**
	 * 刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）设定
	 * @param toolTypeWhere
	 */
	public void setToolTypeWhere (String toolTypeWhere) {
		this.toolTypeWhere = toolTypeWhere;
	}

	/* 流程ID	*/ 
	private String businessIDWhere;

	/**
	 * 流程ID取得
	 * @return businessIDWhere
	 */
	public String getBusinessIDWhere () {
		return businessIDWhere;
	}

	/**
	 * 流程ID设定
	 * @param businessIDWhere
	 */
	public void setBusinessIDWhere (String businessIDWhere) {
		this.businessIDWhere = businessIDWhere;
	}

	/* 材料号	*/ 
	private String materialWhere;

	/**
	 * 材料号取得
	 * @return materialWhere
	 */
	public String getMaterialWhere () {
		return materialWhere;
	}

	/**
	 * 材料号设定
	 * @param materialWhere
	 */
	public void setMaterialWhere (String materialWhere) {
		this.materialWhere = materialWhere;
	}

	/* 单品ID	*/ 
	private String knifeInventoryCodeWhere;

	/**
	 * 单品ID取得
	 * @return knifeInventoryCodeWhere
	 */
	public String getKnifeInventoryCodeWhere () {
		return knifeInventoryCodeWhere;
	}

	/**
	 * 单品ID设定
	 * @param knifeInventoryCodeWhere
	 */
	public void setKnifeInventoryCodeWhere (String knifeInventoryCodeWhere) {
		this.knifeInventoryCodeWhere = knifeInventoryCodeWhere;
	}

	/* 已刃磨次数	*/ 
	private BigDecimal usageCounterWhere;

	/**
	 * 已刃磨次数取得
	 * @return usageCounterWhere
	 */
	public BigDecimal getUsageCounterWhere () {
		return usageCounterWhere;
	}

	/**
	 * 已刃磨次数设定
	 * @param usageCounterWhere
	 */
	public void setUsageCounterWhere (BigDecimal usageCounterWhere) {
		this.usageCounterWhere = usageCounterWhere;
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

	/* 报废原因	*/ 
	private String scrapCauseWhere;

	/**
	 * 报废原因取得
	 * @return scrapCauseWhere
	 */
	public String getScrapCauseWhere () {
		return scrapCauseWhere;
	}

	/**
	 * 报废原因设定
	 * @param scrapCauseWhere
	 */
	public void setScrapCauseWhere (String scrapCauseWhere) {
		this.scrapCauseWhere = scrapCauseWhere;
	}

	/* 报废数量	*/ 
	private BigDecimal scrapNumberWhere;

	/**
	 * 报废数量取得
	 * @return scrapNumberWhere
	 */
	public BigDecimal getScrapNumberWhere () {
		return scrapNumberWhere;
	}

	/**
	 * 报废数量设定
	 * @param scrapNumberWhere
	 */
	public void setScrapNumberWhere (BigDecimal scrapNumberWhere) {
		this.scrapNumberWhere = scrapNumberWhere;
	}

	/* 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）	*/ 
	private String scrapStateWhere;

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）取得
	 * @return scrapStateWhere
	 */
	public String getScrapStateWhere () {
		return scrapStateWhere;
	}

	/**
	 * 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）设定
	 * @param scrapStateWhere
	 */
	public void setScrapStateWhere (String scrapStateWhere) {
		this.scrapStateWhere = scrapStateWhere;
	}

	/* 报废时间	*/ 
	private Date scrapTimeWhere;

	/**
	 * 报废时间取得
	 * @return scrapTimeWhere
	 */
	public Date getScrapTimeWhere () {
		return scrapTimeWhere;
	}

	/**
	 * 报废时间设定
	 * @param scrapTimeWhere
	 */
	public void setScrapTimeWhere (Date scrapTimeWhere) {
		this.scrapTimeWhere = scrapTimeWhere;
	}

	/* 授权人	*/ 
	private String authorizationIDWhere;

	/**
	 * 授权人取得
	 * @return authorizationIDWhere
	 */
	public String getAuthorizationIDWhere () {
		return authorizationIDWhere;
	}

	/**
	 * 授权人设定
	 * @param authorizationIDWhere
	 */
	public void setAuthorizationIDWhere (String authorizationIDWhere) {
		this.authorizationIDWhere = authorizationIDWhere;
	}
}

