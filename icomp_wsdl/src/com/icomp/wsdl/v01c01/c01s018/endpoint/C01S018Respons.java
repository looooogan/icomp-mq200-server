package com.icomp.wsdl.v01c01.c01s018.endpoint;

import java.math.BigDecimal;
import java.util.List;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Tool;

/**
 * 刀具复磨安上-返回参数
 *
 * @author Taoyy
 * @ClassName: C01S018Respons
 * @date 2014-9-23 上午9:28:02
 */
public class C01S018Respons extends BaseRespons {
    private static final long serialVersionUID = -8375608882331409568L;


    //刀具ID
    private String toolID;


    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }



	//修磨设备列表
	private List<GrindingEquipmentEntity> equipments ;
	
	public List<GrindingEquipmentEntity> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<GrindingEquipmentEntity> equipments) {
		this.equipments = equipments;
	}
	//材料号
	private String materialNu ;

    public String getMaterialNu() {
        return materialNu;
    }

    public void setMaterialNu(String materialNu) {
        this.materialNu = materialNu;
    }

    //刃磨设备列表
    private List<NoticeequipmentSelect> noticeEquipmentList;
    //刃磨安上列表
    private List<GrindingonmsgList> grindingonmsgList;
    //刀具类型
    private String toolType;
    //入库编码
    private String knifeInventoryCode;
    //库存状态(0正常1报废2返厂3封存4流转9其他)
    private String stockState;
    //业务-流程中间表ID
    private String businessFlowLnkID;
    //报废数量
    private int scrapNumber;
    //刀具长度
    private BigDecimal toolLength;
    //不可刃磨长度
    private BigDecimal noGrindingLength;
  
    //物料号
    private String kivCode;
    //刃磨数量
    private int gringCount;

    public BigDecimal getToolLength() {
        return toolLength;
    }

    public void setToolLength(BigDecimal toolLength) {
        this.toolLength = toolLength;
    }

    public BigDecimal getNoGrindingLength() {
        return noGrindingLength;
    }

    public void setNoGrindingLength(BigDecimal noGrindingLength) {
        this.noGrindingLength = noGrindingLength;
    }

    public List<NoticeequipmentSelect> getNoticeEquipmentList() {
        return noticeEquipmentList;
    }

    public void setNoticeEquipmentList(List<NoticeequipmentSelect> noticeEquipmentList) {
        this.noticeEquipmentList = noticeEquipmentList;
    }

    public List<GrindingonmsgList> getGrindingonmsgList() {
        return grindingonmsgList;
    }

    public void setGrindingonmsgList(List<GrindingonmsgList> grindingonmsgList) {
        this.grindingonmsgList = grindingonmsgList;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getKnifeInventoryCode() {
        return knifeInventoryCode;
    }

    public void setKnifeInventoryCode(String knifeInventoryCode) {
        this.knifeInventoryCode = knifeInventoryCode;
    }

    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    public String getBusinessFlowLnkID() {
        return businessFlowLnkID;
    }

    public void setBusinessFlowLnkID(String businessFlowLnkID) {
        this.businessFlowLnkID = businessFlowLnkID;
    }

    public int getScrapNumber() {
        return scrapNumber;
    }

    public void setScrapNumber(int scrapNumber) {
        this.scrapNumber = scrapNumber;
    }

 

    public String getKivCode() {
        return kivCode;
    }

    public void setKivCode(String kivCode) {
        this.kivCode = kivCode;
    }

    public int getGringCount() {
        return gringCount;
    }

    public void setGringCount(int gringCount) {
        this.gringCount = gringCount;
    }

	public void setToolCode(String toolCode) {

		
	}

}
