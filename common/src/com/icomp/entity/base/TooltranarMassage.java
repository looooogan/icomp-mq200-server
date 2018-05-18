package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * 刀具流转信息查询
 * User: Taoyy
 * Date: 2015/8/5
 * Time: 18:05
 */
public class TooltranarMassage extends BaseEntity implements Serializable {
    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    //RFID载体ID
    private String rfidContainerID;
    //刀具编码
    private String toolCode;
    //自定义编码
    private String  systeCode;
    //物料号
    private String  customerCode;
    //刀具部门(0库存,1对刀室,2刃磨室,3,车间)
    private String toolThisState;
    //刃磨数量
    private String grindingCount;
    //刀具状态(0断刀1丢失2不合格3借入4申领,5到寿,6厂内待刃磨,7.厂外待刃磨9其他)
    private String toolState;
    //刀具id
    private String toolId;
    //RFID
    private String rfidCode;

    public String getRfidCode() {
        return rfidCode;
    }

    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getRfidContainerID() {
        return rfidContainerID;
    }

    public void setRfidContainerID(String rfidContainerID) {
        this.rfidContainerID = rfidContainerID;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * 刀具部门(0库存,1对刀室,2刃磨室,3,车间)
     * @return
     */
    public String getToolThisState() {
        return toolThisState;
    }

    public void setToolThisState(String toolThisState) {
        this.toolThisState = toolThisState;
    }

    public String getSysteCode() {
        return systeCode;
    }

    public void setSysteCode(String systeCode) {
        this.systeCode = systeCode;
    }

    public String getGrindingCount() {
        return grindingCount;
    }

    public void setGrindingCount(String grindingCount) {
        this.grindingCount = grindingCount;
    }

    public String getToolState() {
        return toolState;
    }

    public void setToolState(String toolState) {
        this.toolState = toolState;
    }
}
