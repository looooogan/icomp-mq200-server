package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
/**
 * Created by ibm on 2017/11/30.
 */
public class ToolChangehistory extends BaseEntity implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    private String changeID;
    private String synthesisParametersCode;
    private String assemblyLineID;
    private String processID;
    private String equipmentID;
    private String partsID;
    private String axleID;
    private String changeDate;
    private String changeUser;
    private String toolCode;
    private String changeNum;
    private String updateUser;
    private String createUser;
    private String assemblyLineName;
    private String processName;
    private String equipmentName;
    private String axleName;
    private String partsName;

    public String getChangeID() {
        return changeID;
    }

    public void setChangeID(String changeID) {
        this.changeID = changeID;
    }

    public String getSynthesisParametersCode() {
        return synthesisParametersCode;
    }

    public void setSynthesisParametersCode(String synthesisParametersCode) {
        this.synthesisParametersCode = synthesisParametersCode;
    }

    public String getAssemblyLineID() {
        return assemblyLineID;
    }

    public void setAssemblyLineID(String assemblyLineID) {
        this.assemblyLineID = assemblyLineID;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getPartsID() {
        return partsID;
    }

    public void setPartsID(String partsID) {
        this.partsID = partsID;
    }

    public String getAxleID() {
        return axleID;
    }

    public void setAxleID(String axleID) {
        this.axleID = axleID;
    }

    public String getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(String changeNum) {
        this.changeNum = changeNum;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getAssemblyLineName() {
        return assemblyLineName;
    }

    public void setAssemblyLineName(String assemblyLineName) {
        this.assemblyLineName = assemblyLineName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getAxleName() {
        return axleName;
    }

    public void setAxleName(String axleName) {
        this.axleName = axleName;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }
}
