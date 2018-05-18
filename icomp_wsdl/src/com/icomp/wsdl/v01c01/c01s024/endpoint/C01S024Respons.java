package com.icomp.wsdl.v01c01.c01s024.endpoint;

import com.icomp.common.pojo.BaseRespons;

import java.util.List;

/**
 * 刀具管理-刀具状态查询-返回参数
 * @ClassName: C01S024Respons 
 * @author Taoyy
 * @date 2014-9-23 上午10:14:22
 */
public class C01S024Respons extends BaseRespons {
	private static final long serialVersionUID = 7688477911876780597L;

	//数量
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	//容器
	private List<TypeEntity> con;

	public List<TypeEntity> getCon() {
		return con;
	}

	public void setCon(List<TypeEntity> con) {
		this.con = con;
	}



	//刀具安装状态
	private String installationState;
	public String getInstallationState() {
		return installationState;
	}
	public void setInstallationState(String installationState) {
		this.installationState = installationState;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	private String DisplayType;
	public String getDisplayType() {
		return DisplayType;
	}
	public void setDisplayType(String displayType) {
		DisplayType = displayType;
	}
	private int toolNoticeCount;
	public int getToolNoticeCount() {
		return toolNoticeCount;
	}
	public void setToolNoticeCount(int toolNoticeCount) {
		this.toolNoticeCount = toolNoticeCount;
	}
	//查询方式
	private String queryType;
	//刀具类型
	private String toolType;
	//刀具编码（材料号）
	private String toolCode;
	//当前状态
	private String toolStauts;
	//额定加工量
	private int quotaProcessingVolume;
	//孔位数
	private int synthesisCount;
	//辅具数
	private int technologyCount;
	//钻头数
	private int boringCrownCount;
	//刀片数
	private int bladeCount;
	//X坐标
	private double xPoint;
	//Y坐标
	private double yPoint;
	//当前操作者
	private String toolRepairNoticeUser;
	//刃磨次数
	private int usageCounter;
	//使用面数
	private int toolSharpennum;
	//可刃磨长度
	private double toolSharpennumLength;
	//已刃磨长度
	private double toolGrindingLength;
	//剩余尺寸
	private double toolLength;
	//加工数量
	private int processingVolume;
    /**
     * 流程list
     */
    private List<SynthesisHistory> shList;
    public List<SynthesisHistory> getShList() {
        return shList;
    }
    public void setShList(List<SynthesisHistory> shList) {
        this.shList = shList;
    }

    public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getToolStauts() {
		return toolStauts;
	}
	public void setToolStauts(String toolStauts) {
		this.toolStauts = toolStauts;
	}
	public int getQuotaProcessingVolume() {
		return quotaProcessingVolume;
	}
	public void setQuotaProcessingVolume(int quotaProcessingVolume) {
		this.quotaProcessingVolume = quotaProcessingVolume;
	}
	public int getSynthesisCount() {
		return synthesisCount;
	}
	public void setSynthesisCount(int synthesisCount) {
		this.synthesisCount = synthesisCount;
	}
	public int getTechnologyCount() {
		return technologyCount;
	}
	public void setTechnologyCount(int technologyCount) {
		this.technologyCount = technologyCount;
	}
	public int getBoringCrownCount() {
		return boringCrownCount;
	}
	public void setBoringCrownCount(int boringCrownCount) {
		this.boringCrownCount = boringCrownCount;
	}
	public int getBladeCount() {
		return bladeCount;
	}
	public void setBladeCount(int bladeCount) {
		this.bladeCount = bladeCount;
	}
	public double getxPoint() {
		return xPoint;
	}
	public void setxPoint(double xPoint) {
		this.xPoint = xPoint;
	}
	public double getyPoint() {
		return yPoint;
	}
	public void setyPoint(double yPoint) {
		this.yPoint = yPoint;
	}
	public String getToolRepairNoticeUser() {
		return toolRepairNoticeUser;
	}
	public void setToolRepairNoticeUser(String toolRepairNoticeUser) {
		this.toolRepairNoticeUser = toolRepairNoticeUser;
	}
	public int getUsageCounter() {
		return usageCounter;
	}
	public void setUsageCounter(int usageCounter) {
		this.usageCounter = usageCounter;
	}
	public int getToolSharpennum() {
		return toolSharpennum;
	}
	public void setToolSharpennum(int toolSharpennum) {
		this.toolSharpennum = toolSharpennum;
	}
	public double getToolSharpennumLength() {
		return toolSharpennumLength;
	}
	public void setToolSharpennumLength(double toolSharpennumLength) {
		this.toolSharpennumLength = toolSharpennumLength;
	}
	public double getToolGrindingLength() {
		return toolGrindingLength;
	}
	public void setToolGrindingLength(double toolGrindingLength) {
		this.toolGrindingLength = toolGrindingLength;
	}
	public double getToolLength() {
		return toolLength;
	}
	public void setToolLength(double toolLength) {
		this.toolLength = toolLength;
	}
	public int getProcessingVolume() {
		return processingVolume;
	}
	public void setProcessingVolume(int processingVolume) {
		this.processingVolume = processingVolume;
	}



}
