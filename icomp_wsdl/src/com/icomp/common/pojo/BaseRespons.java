package com.icomp.common.pojo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.icomp.common.utils.MessageReSource;

@XmlType(name = "BaseRespons")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseRespons implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269092701686822283L;

	public BaseRespons(){
	
	}
	

	/**
	 * 消息类型
	 */
	private String stateCode;
	
	private String stateMsg;

	
	public String getStateMsg() {
		return stateMsg;
	}

	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	/**
	 * 处理消息
	 */
	private String messageText;

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
		
	}
	public void setMessageText(String msgID,String lang,String langValue) {
		this.messageText =MessageReSource.getMessageBox(msgID,lang,langValue);
		
	}
	
	/**
	 * 消息类型
	 */
	private String messageInfo;

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	/* webService 处理结果 */
	private int status = -1;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
