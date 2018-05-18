package com.icomp.wsdl.v01c01.c01s004.endpoint;

import java.io.Serializable;

/**
 * 补领出库
 * @ClassName: ReplacementToolInfo 
 * @author Taoyy
 * @date 2016-3-8 下午5:05:50
 */
public class ReplacementInfo implements Serializable {
	private static final long serialVersionUID = 8279334903203236827L;
	//补领单号
	private String replacementID;

	public String getReplacementID() {
		return replacementID;
	}

	public void setReplacementID(String replacementID) {
		this.replacementID = replacementID;
	}

	//申请人ID
	private String applyID;
	public String getApplyID() {
		return applyID;
	}
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}

	//申请人名称
	private String applyUser;
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	
	//申请时间
	private String applyTime;
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
}
