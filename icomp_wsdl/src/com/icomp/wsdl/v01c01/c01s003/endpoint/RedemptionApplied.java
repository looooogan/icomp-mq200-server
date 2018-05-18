package com.icomp.wsdl.v01c01.c01s003.endpoint;

import java.io.Serializable;

/**
 * 记录换领申请单列表
 * 
 * @author yzq
 * 
 */
public class RedemptionApplied implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510562650515966047L;
	

	// 申请人
	private String userName;
    //申请人ID
    private String userId;

	// 申请时间
	private String userTime;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTime() {
		return userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
