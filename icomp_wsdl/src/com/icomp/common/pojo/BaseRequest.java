package com.icomp.common.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlType(name = "BaseRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5781711065255726627L;

    public BaseRequest() {

    }

    /* 系统语言编码 */
    private String languageCode;

    public String getLanguageCode() {
        languageCode = "01";
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    /* 系统语言编码 */
    private String languageValue;

    public String getLanguageValue() {
        languageValue = "zh_CN";
        return languageValue;
    }

    public void setLanguageValue(String languageValue) {
        this.languageValue = languageValue;
    }

    /* 用户ID[自动生成20位字符串]	*/
    private String customerID;

    /**
     * 用户ID[自动生成20位字符串]取得
     *
     * @return customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * 用户ID[自动生成20位字符串]设定
     *
     * @param customerID
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    //起始行
    private int staIndex = -1;
    //结束行
    private int rowCount;
    /*手持机ID*/
    private String handSetId;

    public String getHandSetId() {
        return handSetId;
    }

    public void setHandSetId(String handSetId) {
        this.handSetId = handSetId;
    }

    public int getStaIndex() {
        return staIndex;
    }

    public void setStaIndex(int staIndex) {
        this.staIndex = staIndex;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    protected String gruantUserID;// 授权用户ID
    protected String gruantUserName;// 授权用户姓名

    public String getGruantUserID() {
        return gruantUserID;
    }

    public void setGruantUserID(String gruantUserID) {
        this.gruantUserID = gruantUserID;
    }

    public String getGruantUserName() {
        return gruantUserName;
    }

    public void setGruantUserName(String gruantUserName) {
        this.gruantUserName = gruantUserName;
    }

    private String synthesisToolCode;

    public String getSynthesisToolCode() {
        return synthesisToolCode;
    }

    public void setSynthesisToolCode(String synthesisToolCode) {
        this.synthesisToolCode = synthesisToolCode;
    }
    
    /* 单品刀或合成刀具的刀具编码 */
    private String toolCode;

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
}
