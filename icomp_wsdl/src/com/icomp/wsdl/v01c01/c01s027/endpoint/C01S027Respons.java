package com.icomp.wsdl.v01c01.c01s027.endpoint;

import com.icomp.common.pojo.BaseRespons;

import java.util.List;

/**
 * 刀具管理-刀具送回-返回参数
 *
 * @author Taoyy
 * @ClassName: C01S027Respons
 * @date 2016年3月9日 10:22:56
 */
public class C01S027Respons extends BaseRespons {

    private static final long serialVersionUID = 8302488118892836363L;
    


    //刀具Id
    private String toolID;

    public String getToolID() {
        return toolID;
    }
    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    //RFID标签
    private String rfidCode;

    public String getRfidCode() {
        return rfidCode;
    }
    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }

    //材料号
    private String materialNum;

    public String getMaterialNum() {
        return materialNum;
    }
    public void setMaterialNum(String materialNum) {
        this.materialNum = materialNum;
    }

    //应送回数量
    private String inventory;

    public String getInventory() {
        return inventory;
    }
    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
    //修磨方式
    private String toolGrinding;

    public String getToolGrinding() {
        return toolGrinding;
    }

    public void setToolGrinding(String toolGrinding) {
        this.toolGrinding = toolGrinding;
    }









	//通知单号
    private String orderNum ;
    //通知单号ID
    private String outsideFactoryID;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOutsideFactoryID() {
        return this.outsideFactoryID;
    }

    public void setOutsideFactoryID(String outsideFactoryID) {
        this.outsideFactoryID = outsideFactoryID;
    }


    //修复状态
    private String repairState ;

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }


    //材料号（刀具编码）
    private String toolCode;
    //激光码
    private String laserCode;

    public String getGrindingType() {
        return grindingType;
    }

    public void setGrindingType(String grindingType) {
        this.grindingType = grindingType;
    }

    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }



    //修磨方式
    private String grindingType;



































    //交接信息
    private List<TransferToolMsg> transferToolMsgList;
    //交接方向(0对刀室-->刃磨室,1刃磨室-->对刀室)
    private String aspact;

    public List<TransferToolMsg> getTransferToolMsgList() {
        return transferToolMsgList;
    }

    public void setTransferToolMsgList(List<TransferToolMsg> transferToolMsgList) {
        this.transferToolMsgList = transferToolMsgList;
    }

    /**
     * 交接方向(0对刀室-->刃磨室,1刃磨室-->对刀室)
     * @return
     */
    public String getAspact() {
        return aspact;
    }

    /**
     * 交接方向(0对刀室-->刃磨室,1刃磨室-->对刀室)
     * @param aspact
     */
    public void setAspact(String aspact) {
        this.aspact = aspact;
    }
}
