package com.icomp.wsdl.v01c01.c01s014.endpoint;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Vgetrepairnoticetoolmsg;

import java.util.List;

/**
 * 刀具分拣-返回参数
 * @ClassName: C01S014Respons 
 * @author Taoyy
 * @date 2016-2-29 下午6:47:16
 */
public class C01S014Respons extends BaseRespons {
	private static final long serialVersionUID = -8046138670775361746L;
	
	//rfid类型（0单品，1容器）
	private String queryType;
	
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	//刀具id(单品)
	private String toolID;
	
	public String getToolID() {
		return toolID;
	}
	public void setToolID(String toolID) {
		this.toolID = toolID;
	}
	
	//材料号(单品)
	private String materialNum;
	
	public String getMaterialNum() {
		return materialNum;
	}
	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	
	

	//修磨方式(单品)
	private String grindingMode;
	
	public String getGrindingMode() {
		return grindingMode;
	}
	public void setGrindingMode(String grindingMode) {
		this.grindingMode = grindingMode;
	}
	
	//刀具信息(容器)
	private  List<ReplaceGringding> gringdingList;
	
	public List<ReplaceGringding> getGringdingList() {
		return gringdingList;
	}

	public void setGringdingList(List<ReplaceGringding> gringdingList) {
		this.gringdingList = gringdingList;
	}
	
	
	
	

	

	

	

	//取得刀具修复通知单信息实体类
	private Vgetrepairnoticetoolmsg vgetrepairnoticetoolmsg;
	//刃磨方式 
	private List<Comlist> repairWayList;
	//通知单号
	private String RepairNoticeNumber;
	
	//装暂时存储的数据 
	private List<Vgetrepairnoticetoolmsg> trnList;
	//装暂时存储的RFID数据 
	private String rfidCode;
	
	//激光识别码
	private String LaserIdentificationCode;
	
	public String getLaserIdentificationCode() {
		return LaserIdentificationCode;
	}
	public void setLaserIdentificationCode(String laserIdentificationCode) {
		LaserIdentificationCode = laserIdentificationCode;
	}
	public List<Vgetrepairnoticetoolmsg> getTrnList() {
		return trnList;
	}
	public void setTrnList(List<Vgetrepairnoticetoolmsg> trnList) {
		this.trnList = trnList;
	}
	/**
	 * 通知单号
	 * @title getRepairNoticeNumber 
	 * @return
	 * String
	 */
	public String getRepairNoticeNumber() {
		return RepairNoticeNumber;
	}
	/**
	 * 通知单号
	 * @title setRepairNoticeNumber 
	 * @param repairNoticeNumber
	 * void
	 */
	public void setRepairNoticeNumber(String repairNoticeNumber) {
		RepairNoticeNumber = repairNoticeNumber;
	}
	/**
	 * 刃磨方式 
	 * @title getRepairWayList 
	 * @return
	 * List<Comlist>
	 */
	public List<Comlist> getRepairWayList() {
		return repairWayList;
	}
	/**
	 * 刃磨方式 
	 * @title setRepairWayList 
	 * @param repairWayList
	 * void
	 */
	public void setRepairWayList(List<Comlist> repairWayList) {
		this.repairWayList = repairWayList;
	}
	/**
	 * 取得刀具修复通知单信息实体类
	 * @title getVgetrepairnoticetoolmsg 
	 * @return
	 * Vgetrepairnoticetoolmsg
	 */
	public Vgetrepairnoticetoolmsg getVgetrepairnoticetoolmsg() {
		return vgetrepairnoticetoolmsg;
	}
	/**
	 * 取得刀具修复通知单信息实体类
	 * @title setVgetrepairnoticetoolmsg 
	 * @param vgetrepairnoticetoolmsg
	 * void
	 */
	public void setVgetrepairnoticetoolmsg(Vgetrepairnoticetoolmsg vgetrepairnoticetoolmsg) {
		this.vgetrepairnoticetoolmsg = vgetrepairnoticetoolmsg;
	}
	public String getRfidCode() {
		return rfidCode;
	}
	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}


}
