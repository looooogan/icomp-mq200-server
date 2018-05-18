package com.icomp.wsdl.v01c01.c01s019.endpoint;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.wsdl.v01c01.c01s018.endpoint.ToolNoticeInfo;

import java.util.List;

/**
 * 对刀结束	-返回参数
 *
 * @author Taoyy
 * @ClassName: C01S019Respons
 * @date 2014-9-23 上午9:34:04
 */
public class C01S019Respons extends BaseRespons {
    private static final long serialVersionUID = 4791460974066213008L;
    //绑定刀具信息
    private List<BindingToolEntity> equipments;

    public List<BindingToolEntity> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<BindingToolEntity> equipments) {
        this.equipments = equipments;
    }

    //激光码
    private String laserCode;

    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }

    //刀具修磨信息
    private List<ToolNoticeInfo> toolNoticeInfoList;

    public List<ToolNoticeInfo> getToolNoticeInfoList() {
        return toolNoticeInfoList;
    }

    public void setToolNoticeInfoList(List<ToolNoticeInfo> toolNoticeInfoList) {
        this.toolNoticeInfoList = toolNoticeInfoList;
    }

    //刀具ID
    private String toolID;

    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    //材料号
    private String materialNu;

    public String getMaterialNu() {
        return materialNu;
    }

    public void setMaterialNu(String materialNu) {
        this.materialNu = materialNu;
    }

}
