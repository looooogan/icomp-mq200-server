package com.icomp.entity.base;

import java.io.Serializable;

/**
 * Created by logan on 2018/5/17.
 */
public class SynthesisExchange extends SynthesisExchangeWhere implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String rfid;

    private String toolID;

    private String toolCode;

    private String synthesisParametersID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getSynthesisParametersID() {
        return synthesisParametersID;
    }

    public void setSynthesisParametersID(String synthesisParametersID) {
        this.synthesisParametersID = synthesisParametersID;
    }
}
