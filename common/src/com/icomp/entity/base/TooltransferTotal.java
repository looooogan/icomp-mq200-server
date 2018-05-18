
/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2016/03/10 15:23:42
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2016/03/10 15:23:42
 * 创建者  ：sj
 * 更新者  ：sj
 *
 */
public class TooltransferTotal extends TooltransferTotalWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 刀具材料号	*/
	private String toolCode;

	/**
	 * 刀具材料号取得
	 * @return toolCode
	 */
	public String getToolCode() {
		return toolCode;
	}

	/**
	 * 刀具材料号设定
	 * @param toolCode
	 */
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	/* 备刀数量	*/
	private BigDecimal spareKnifeSum;

	/**
	 * 备刀数量取得
	 * @return spareKnifeSum
	 */
	public BigDecimal getSpareKnifeSum() {
		return spareKnifeSum;
	}

	/**
	 * 备刀数量设定
	 * @param spareKnifeSum
	 */
	public void setSpareKnifeSum(BigDecimal spareKnifeSum) {
		this.spareKnifeSum = spareKnifeSum;
	}

	/* 厂内修磨数量	*/
	private BigDecimal grindingFactorySnum;

	/**
	 * 厂内修磨数量取得
	 * @return grindingFactorySnum
	 */
	public BigDecimal getGrindingFactorySnum() {
		return grindingFactorySnum;
	}

	/**
	 * 厂内修磨数量设定
	 * @param grindingFactorySnum
	 */
	public void setGrindingFactorySnum(BigDecimal grindingFactorySnum) {
		this.grindingFactorySnum = grindingFactorySnum;
	}


	/* 厂外待修磨数量*/
	private BigDecimal stayExternalGrindingSum;

	public BigDecimal getStayExternalGrindingSum() {
		return stayExternalGrindingSum;
	}

	public void setStayExternalGrindingSum(BigDecimal stayExternalGrindingSum) {
		this.stayExternalGrindingSum = stayExternalGrindingSum;
	}

	/* 厂外修磨数量	*/
	private BigDecimal externalGrindingSum;

	/**
	 * 厂外修磨数量取得
	 * @return externalGrindingSum
	 */
	public BigDecimal getExternalGrindingSum() {
		return externalGrindingSum;
	}

	/**
	 * 厂外修磨数量设定
	 * @param externalGrindingSum
	 */
	public void setExternalGrindingSum(BigDecimal externalGrindingSum) {
		this.externalGrindingSum = externalGrindingSum;
	}

	/* 生成中刀具数量	*/
	private BigDecimal productionLineSum;

	/**
	 * 生成中刀具数量取得
	 * @return productionLineSum
	 */
	public BigDecimal getProductionLineSum() {
		return productionLineSum;
	}

	/**
	 * 生成中刀具数量设定
	 * @param productionLineSum
	 */
	public void setProductionLineSum(BigDecimal productionLineSum) {
		this.productionLineSum = productionLineSum;
	}

	/* 合计	*/
	private String expandSpace1;

	/**
	 * 合计取得
	 * @return productionLineSum
	 */
	public String getExpandSpace1() {
		return expandSpace1;
	}

	/**
	 * 合计设定
	 * @param expandSpace1
	 */
	public void setExpandSpace1(String expandSpace1) {
		this.expandSpace1 = expandSpace1;
	}


	// 2017/08/30 宋健 追加↓↓↓　dazhong@YMSC
	private String createUser;

	@Override
	public String getCreateUser() {
		return createUser;
	}

	@Override
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	// 2017/08/30 宋健 追加↑↑↑　dazhong@YMSC

	// 2017/08/30 宋健 追加↓↓↓　dazhong@YMSC
	private String updateUser;

	@Override
	public String getUpdateUser() {
		return updateUser;
	}

	@Override
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	// 2017/09/12 宋健 追加↑↑↑　dazhong@YMSC


	/* 总报废数量	*/
	private BigDecimal scrapSum;

	/**
	 * 总报废数量取得
	 * @return 总报废数量
	 */
	public BigDecimal getScrapSum() {
		return scrapSum;
	}

	/**
	 * 总报废数量设定
	 * @param scrapSum
	 */
	public void setScrapSum(BigDecimal scrapSum) {
		this.scrapSum = scrapSum;
	}

}