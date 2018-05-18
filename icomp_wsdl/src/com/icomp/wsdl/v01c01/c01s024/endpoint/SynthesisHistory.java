package com.icomp.wsdl.v01c01.c01s024.endpoint;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Taoyy
 * Date: 2015/3/3
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */
public class SynthesisHistory implements Serializable{

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

	/* RFID标签ID	*/
	private String rfidCode;

	/**
	 * RFID标签ID取得
	 * @return rfidCode
	 */
	public String getRfidCode() {
		return rfidCode;
	}

	/**
	 * RFID标签ID设定
	 * @param rfidCode
	 */
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	/* RFID(辅具或配套上打孔安装的RFID)	*/
	private String rfidContainerID;

	/**
	 * RFID(辅具或配套上打孔安装的RFID)取得
	 * @return rfidContainerID
	 */
	public String getRfidContainerID() {
		return rfidContainerID;
	}

	/**
	 * RFID(辅具或配套上打孔安装的RFID)设定
	 * @param rfidContainerID
	 */
	public void setRfidContainerID(String rfidContainerID) {
		this.rfidContainerID = rfidContainerID;
	}

	/* 合成刀具编码(系统唯一)	*/
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 合成刀具编号(例如：001、002、003)	*/
	private String synthesisParametersNumber;

	/**
	 * 合成刀具编号(例如：001、002、003)取得
	 * @return synthesisParametersNumber
	 */
	public String getSynthesisParametersNumber() {
		return synthesisParametersNumber;
	}

	/**
	 * 合成刀具编号(例如：001、002、003)设定
	 * @param synthesisParametersNumber
	 */
	public void setSynthesisParametersNumber(String synthesisParametersNumber) {
		this.synthesisParametersNumber = synthesisParametersNumber;
	}

	/* 	*/
	private String businessName;

	/**
	 * 取得
	 * @return businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * 设定
	 * @param businessName
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/* 	*/
	private String userName;

	/**
	 * 取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设定
	 * @param userName
	 */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
