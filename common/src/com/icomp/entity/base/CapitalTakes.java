/*
 * 工具自动生成：机构实体类
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.entity.base;

import java.io.Serializable;


/**
 * 机构实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:03
 * 创建者  ：杨作庆
 * 
 */
public class CapitalTakes extends CapitalTakesWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;
	private String toolType;//刀具类型
	private String toolCode;//刀具编码
	private String numberDevices;//待修磨厂内
	private String numberDevices1;//待修磨厂外
	private String numberDevices2;//待送回
	private String numberDevices3;//厂外修磨
	private String numberDevices4;//对刀间
	private String numberDevices5;//车间
	private String numberDevices6;//报废
	private String sprice;//资金占用
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getNumberDevices() {
		return numberDevices;
	}
	public void setNumberDevices(String numberDevices) {
		this.numberDevices = numberDevices;

	}
	public String getNumberDevices1() {
		return numberDevices1;
	}
	public void setNumberDevices1(String numberDevices1) {
		this.numberDevices1 = numberDevices1;
	}
	public String getNumberDevices2() {
		return numberDevices2;
	}
	public void setNumberDevices2(String numberDevices2) {
		this.numberDevices2 = numberDevices2;
	}
	public String getNumberDevices3() {
		return numberDevices3;
	}
	public void setNumberDevices3(String numberDevices3) {
		this.numberDevices3 = numberDevices3;
	}
	public String getNumberDevices4() {
		return numberDevices4;
	}
	public void setNumberDevices4(String numberDevices4) {
		this.numberDevices4 = numberDevices4;
	}
	public String getNumberDevices5() {
		return numberDevices5;
	}
	public void setNumberDevices5(String numberDevices5) {
		this.numberDevices5 = numberDevices5;
	}
	public String getNumberDevices6() {
		return numberDevices6;
	}
	public void setNumberDevices6(String numberDevices6) {
		this.numberDevices6 = numberDevices6;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}


}

