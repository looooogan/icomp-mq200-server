package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Taoyy
 * Date: 2015/3/10
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 */
public class StockMsgList implements Serializable {
    private static final long serialVersionUID = -1673018997151771552L;

    //申请人ID
    private String appliedUserId;
    //申请时间
    private String appliedDate;
    //刀具编码
    private String toolCode;
    //备货数量
    private int stockNum;
    //申请数量
    private int appliedNum;
    //对应的rfid
    private String rfids;

    public String getAppliedUserId() {
        return appliedUserId;
    }

    public void setAppliedUserId(String appliedUserId) {
        this.appliedUserId = appliedUserId;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public int getAppliedNum() {
        return appliedNum;
    }

    public void setAppliedNum(int appliedNum) {
        this.appliedNum = appliedNum;
    }

    public String getRfids() {
        return rfids;
    }

    public void setRfids(String rfids) {
        this.rfids = rfids;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }
}
