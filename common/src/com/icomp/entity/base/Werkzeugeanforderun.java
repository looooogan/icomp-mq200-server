/*
 * 工具自动生成：实体类
 * 生成时间    : 2016/05/18 14:26:37
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 实体类
 * @author 工具自动生成
 * 创建时间：2016/05/18 14:26:37
 * 创建者  ：yzq
 * 更新者  ：taoyy
 * Betrag
 */
public class Werkzeugeanforderun extends WerkzeugeanforderunWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 材料号	*/ 
	private String materialNr;

	/**
	 * 材料号取得
	 * @return materialNr
	 */
	public String getMaterialNr() {
		return materialNr;
	}

	/**
	 * 材料号设定
	 * @param materialNr
	 */
	public void setMaterialNr(String materialNr) {
		this.materialNr = materialNr;
	}

	/* 订货名称	*/ 
	private String bestellBezeichnung;

	/**
	 * 订货名称取得
	 * @return bestellBezeichnung
	 */
	public String getBestellBezeichnung() {
		return bestellBezeichnung;
	}

	/**
	 * 订货名称设定
	 * @param bestellBezeichnung
	 */
	public void setBestellBezeichnung(String bestellBezeichnung) {
		this.bestellBezeichnung = bestellBezeichnung;
	}

	/* 数量	*/ 
	private BigDecimal menge;

	/**
	 * 数量取得
	 * @return menge
	 */
	public BigDecimal getMenge() {
		return menge;
	}

	/**
	 * 数量设定
	 * @param menge
	 */
	public void setMenge(BigDecimal menge) {
		this.menge = menge;
	}

	/* 单位	*/ 
	private String einheit;

	/**
	 * 单位取得
	 * @return einheit
	 */
	public String getEinheit() {
		return einheit;
	}

	/**
	 * 单位设定
	 * @param einheit
	 */
	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}

	/* 单价	*/ 
	private String unitPreis;

	/**
	 * 单价取得
	 * @return unitPreis
	 */
	public String getUnitPreis() {
		return unitPreis;
	}

	/**
	 * 单价设定
	 * @param unitPreis
	 */
	public void setUnitPreis(String unitPreis) {
		this.unitPreis = unitPreis;
	}

	/* 金额	*/ 
	private String betrag;

	/**
	 * 金额取得
	 * @return betrag
	 */
	public String getBetrag() {
		return betrag;
	}

	/**
	 * 金额设定
	 * @param betrag
	 */
	public void setBetrag(String betrag) {
		this.betrag = betrag;
	}

	/* 供货商	*/ 
	private String lieferant;

	/**
	 * 供货商取得
	 * @return lieferant
	 */
	public String getLieferant() {
		return lieferant;
	}

	/**
	 * 供货商设定
	 * @param lieferant
	 */
	public void setLieferant(String lieferant) {
		this.lieferant = lieferant;
	}

	/* 使用点	*/ 
	private String einsAtzort;

	/**
	 * 使用点取得
	 * @return einsAtzort
	 */
	public String getEinsAtzort() {
		return einsAtzort;
	}

	/**
	 * 使用点设定
	 * @param einsAtzort
	 */
	public void setEinsAtzort(String einsAtzort) {
		this.einsAtzort = einsAtzort;
	}

	/* 供货周期	*/ 
	private String liefertermin;

	/**
	 * 供货周期取得
	 * @return liefertermin
	 */
	public String getLiefertermin() {
		return liefertermin;
	}

	/**
	 * 供货周期设定
	 * @param liefertermin
	 */
	public void setLiefertermin(String liefertermin) {
		this.liefertermin = liefertermin;
	}

	/* 科目代码	*/ 
	private String subjectCode;

	/**
	 * 科目代码取得
	 * @return subjectCode
	 */
	public String getSubjectCode() {
		return subjectCode;
	}

	/**
	 * 科目代码设定
	 * @param subjectCode
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	/* 费用代码	*/ 
	private String expenseCode;

	/**
	 * 费用代码取得
	 * @return expenseCode
	 */
	public String getExpenseCode() {
		return expenseCode;
	}

	/**
	 * 费用代码设定
	 * @param expenseCode
	 */
	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}

	/* 备注	*/ 
	private String notes;

	/**
	 * 备注取得
	 * @return notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * 备注设定
	 * @param notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/* 需求号	*/ 
	private String demandCode;

	/**
	 * 需求号取得
	 * @return demandCode
	 */
	public String getDemandCode() {
		return demandCode;
	}

	/**
	 * 需求号设定
	 * @param demandCode
	 */
	public void setDemandCode(String demandCode) {
		this.demandCode = demandCode;
	}

	/* 录入日期	*/ 
	private Date typingDate;

	/**
	 * 录入日期取得
	 * @return typingDate
	 */
	public Date getTypingDate() {
		return typingDate;
	}

	/**
	 * 录入日期设定
	 * @param typingDate
	 */
	public void setTypingDate(Date typingDate) {
		this.typingDate = typingDate;
	}
}

