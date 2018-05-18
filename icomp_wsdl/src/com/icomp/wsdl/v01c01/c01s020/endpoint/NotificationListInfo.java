package com.icomp.wsdl.v01c01.c01s020.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/12 0012.
 */
public class NotificationListInfo implements Serializable {
    private static final long serialVersionUID = 2776704132721946483L;

    //激光码
    private String laserCode;
    //修磨方式
    private String grindingType;
    //刀具ID
    private String toolID ;
    //材料号（刀具编码）
    private String materialNum;
    //修磨数量
    private String numberGrinding;

    public String getNumberGrinding() {
		return numberGrinding;
	}

	public void setNumberGrinding(String numberGrinding) {
		this.numberGrinding = numberGrinding;
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

    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }

    public String getGrindingType() {
        return grindingType;
    }

    public void setGrindingType(String grindingType) {
        this.grindingType = grindingType;
    }














}
