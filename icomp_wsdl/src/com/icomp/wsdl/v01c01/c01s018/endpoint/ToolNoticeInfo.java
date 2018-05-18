package com.icomp.wsdl.v01c01.c01s018.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/14 0014.
 */
public class ToolNoticeInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    //RFID
    private String rfidCode;
    //刀具ID
    private String toolID;
    //(材料号)刀具编码
    private String materialNum;

    public String getRfidCode() {
        return rfidCode;
    }

    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }

    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    public String getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }
}
