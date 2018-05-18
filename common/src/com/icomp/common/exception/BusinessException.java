package com.icomp.common.exception;

import com.icomp.common.utils.MessageReSource;



public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 0xc1a865c45ffdc5f9L;
	/**
	 * 异常返回值
	 */
	private int resultCode;
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 系统语言
	 */
	private String local;
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * 错误消息
	 */
	private String localMessage;
	public String getLocalMessage() {
		return localMessage;
	}
	public void setLocalMessage(String localMessage) {
		this.localMessage = localMessage;
	}
	public BusinessException(String msgID,String lang,String langValue){
		this.local = lang;
		this.localMessage =MessageReSource.getMessageBox(msgID,lang,langValue);
	}
	
	public BusinessException(String msgID,String lang,String langValue,String ... msgText){
		this.local = lang;
		this.localMessage =MessageReSource.getMessageBox(msgID,lang,langValue,msgText);
	}
	
	/**
	 * 业务异常处理
	 * @param e 抛出异常
	 * @param exceType 异常类型
	 * @param methodName 抛出方法名
	 * @param local 语言
	 * @param userID 操作用户
	 */
	public BusinessException(Exception e,String exceType,String methodName,String local,String userID){
		//记录后台异常信息
	}
	public BusinessException(String string) {

	}
	
}
