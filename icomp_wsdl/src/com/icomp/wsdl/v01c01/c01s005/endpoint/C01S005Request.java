package com.icomp.wsdl.v01c01.c01s005.endpoint;

import com.icomp.common.pojo.BaseRequest;

import java.util.List;

public class C01S005Request extends BaseRequest {

    /**
     *
     */
    private static final long serialVersionUID = -2899122586795753449L;

    /* 刀具类型*/
    private String toolType;

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    /* 材料号*/
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    /* 刀具ID*/
    private String toolID;

    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    /* 报废原因*/
    private String scrapCause;

    public String getScrapCause() {
        return scrapCause;
    }

    public void setScrapCause(String scrapCause) {
        this.scrapCause = scrapCause;
    }

    /* 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）*/
    private String scrapState;

    public String getScrapState() {
        return scrapState;
    }

    public void setScrapState(String scrapState) {
        this.scrapState = scrapState;
    }

    /* 授权人*/
    private String authorizationID;

    public String getAuthorizationID() {
        return authorizationID;
    }

    public void setAuthorizationID(String authorizationID) {
        this.authorizationID = authorizationID;
    }

    /* 用户ID*/
    private String customerID;

    public String getRfidCode() {
        return rfidCode;
    }

    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }

    private String rfidCode;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    private List<String> rfidCodeList;

    public List<String> getRfidCodeList() {
        return rfidCodeList;
    }

    public void setRfidCodeList(List<String> rfidCodeList) {
        this.rfidCodeList = rfidCodeList;
    }

}
