package com.icomp.wsdl.v01c01.c01s020.endpoint;

import java.util.List;

import com.icomp.common.pojo.BaseRespons;

/**
 * 回厂识别	-返回参数
 * @ClassName: C01S020Respons 
 * @author Taoyy
 * @date 2014-9-23 上午9:41:31
 */
public class C01S020Respons extends BaseRespons {

	private static final long serialVersionUID = 3281732751929737810L;
//取得通知单号列表
private List<NotificationList> notificationLists ;
//取得通知单号信息
private List<NotificationListInfo> notificationListInfoList;
	//rfid
private String rfidCode;

	public List<NotificationList> getNotificationLists() {
		return notificationLists;
	}

	public void setNotificationLists(List<NotificationList> notificationLists) {
		this.notificationLists = notificationLists;
	}

	public List<NotificationListInfo> getNotificationListInfoList() {
		return notificationListInfoList;
	}

	public void setNotificationListInfoList(List<NotificationListInfo> notificationListInfoList) {
		this.notificationListInfoList = notificationListInfoList;
	}

	public String getRfidCode() {
		return rfidCode;
	}

	public void setRfidCode(String rfidCode) {
		this.rfidCode = rfidCode;
	}

	// 通知单流水号列表
	private List<String> toolRepairNoticeIDList;

	public List<String> getToolRepairNoticeIDList() {
		return toolRepairNoticeIDList;
	}

	public void setToolRepairNoticeIDList(List<String> toolRepairNoticeIDList) {
		this.toolRepairNoticeIDList = toolRepairNoticeIDList;
	}
	//刀具列表
	private List<ToolInfo> toolInfoList;

	public List<ToolInfo> getToolInfoList() {
		return toolInfoList;
	}

	public void setToolInfoList(List<ToolInfo> toolInfoList) {
		this.toolInfoList = toolInfoList;
	}
}
