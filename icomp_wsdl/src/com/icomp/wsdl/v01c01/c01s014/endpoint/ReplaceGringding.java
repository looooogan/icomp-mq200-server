package com.icomp.wsdl.v01c01.c01s014.endpoint;

import java.io.Serializable;

/**
 * 刀具分拣
 * User: Taoyy
 * Date: 2016/2/29
 * Time: 11:27
 */
public class ReplaceGringding implements Serializable {
    private static final long serialVersionUID = -82431861849804L;
    
    //刀具id(容器)
    private String rtoolID;
    
    public String getRtoolID() {
		return rtoolID;
	}

	public void setRtoolID(String rtoolID) {
		this.rtoolID = rtoolID;
	}
	
	//材料号(容器)
    private String rmaterialNum;
    
    public String getRmaterialNum() {
		return rmaterialNum;
	}

	public void setRmaterialNum(String rmaterialNum) {
		this.rmaterialNum = rmaterialNum;
	}
    
	//修磨方式(容器)(0:厂内，1厂外）
    private String rgrindingMode;

	public String getRgrindingMode() {
		return rgrindingMode;
	}

	public void setRgrindingMode(String rgrindingMode) {
		this.rgrindingMode = rgrindingMode;
	}
	
	//数量(容器)
    private String rcount;

	public String getRcount() {
		return rcount;
	}

	public void setRcount(String rcount) {
		this.rcount = rcount;
	}

	//���߱���
    private String toolCode;
    //��ĥ����
    private int gringdingCount;
    //��������
    private int lostCount;
    //����ȷ����
    private String lostConfirm;
    //����״̬
    private String handleType;

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public int getGringdingCount() {
        return gringdingCount;
    }

    public void setGringdingCount(int gringdingCount) {
        this.gringdingCount = gringdingCount;
    }

    public int getLostCount() {
        return lostCount;
    }

    public void setLostCount(int lostCount) {
        this.lostCount = lostCount;
    }

    public String getLostConfirm() {
        return lostConfirm;
    }

    public void setLostConfirm(String lostConfirm) {
        this.lostConfirm = lostConfirm;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }
}
