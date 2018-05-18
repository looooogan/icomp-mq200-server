package com.icomp.wsdl.v01c01.c01s027.endpoint;

import java.io.Serializable;

public class TransferToolMsg implements Serializable {

    private static final long serialVersionUID = 2776704132721946484L;
    //刀具Id
    private String toolId;
    //刀具编码
    private String toolCode;
    //交接数量
    private int tratarnerCount;
    //确认数量
    private int confirmCount;
    //丢失数量
    private int lostCount;
    //丢失确认人
    private String lostConfirm;

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public int getTratarnerCount() {
        return tratarnerCount;
    }

    public void setTratarnerCount(int tratarnerCount) {
        this.tratarnerCount = tratarnerCount;
    }

    public int getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(int confirmCount) {
        this.confirmCount = confirmCount;
    }

    public int getLostCount() {
        return lostCount;
    }

    public void setLostCount(int lostCount) {
        this.lostCount = lostCount;
    }

    public String getLostConfirm() {
        return lostConfirm;
    }

    public void setLostConfirm(String lostConfirm) {
        this.lostConfirm = lostConfirm;
    }
}
