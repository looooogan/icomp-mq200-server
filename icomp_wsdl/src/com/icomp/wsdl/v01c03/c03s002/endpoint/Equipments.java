package com.icomp.wsdl.v01c03.c03s002.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/18 0018.
 */
public class Equipments implements Serializable {
    private static final long serialVersionUID = 2942853420898210667L;
    //设备ID
    private String equipmentID;
    //设备编码
    private String equipmentCode;
    //设备名称

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    private String equipmentName;
















}
