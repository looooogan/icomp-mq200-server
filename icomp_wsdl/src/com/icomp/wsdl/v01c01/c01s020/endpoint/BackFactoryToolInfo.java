package com.icomp.wsdl.v01c01.c01s020.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/12 0012.
 */
public class BackFactoryToolInfo implements Serializable {
    private static final long serialVersionUID = 2776704132721946483L;





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

    public String getBackFactoryCount() {
        return backFactoryCount;
    }

    public void setBackFactoryCount(String backFactoryCount) {
        this.backFactoryCount = backFactoryCount;
    }

    public String getGrindingType() {
        return grindingType;
    }

    public void setGrindingType(String grindingType) {
        this.grindingType = grindingType;
    }
    //刀具ID
    private String toolID;
    //材料号（刀具编码）
    private String toolCode;
    //回厂数量
    private String backFactoryCount;
    //出厂方式
    private String grindingType;












}
