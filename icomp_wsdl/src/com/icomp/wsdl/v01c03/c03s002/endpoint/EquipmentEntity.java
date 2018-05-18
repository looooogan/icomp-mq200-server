package com.icomp.wsdl.v01c03.c03s002.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/18 0018.
 */
public class EquipmentEntity implements Serializable {
    private static final long serialVersionUID = 2942853420898210667L;
    //流水线id
    private String assemblyLineID;
    //流水线编码
    private String assemblyLineCode;
    //流水线名称
    private String assemblyLineName;
    //设备ID
    private String equipmentID;
    //设备编码
    private String equipmentCode;
    //设备名称
    private String equipmentName;

    public String getAssemblyLineID() {
        return assemblyLineID;
    }

    public void setAssemblyLineID(String assemblyLineID) {
        this.assemblyLineID = assemblyLineID;
    }

    public String getAssemblyLineCode() {
        return assemblyLineCode;
    }

    public void setAssemblyLineCode(String assemblyLineCode) {
        this.assemblyLineCode = assemblyLineCode;
    }

    public String getAssemblyLineName() {
        return assemblyLineName;
    }

    public void setAssemblyLineName(String assemblyLineName) {
        this.assemblyLineName = assemblyLineName;
    }

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

    @Override
    public String toString() {
        return equipmentName;
    }
}
