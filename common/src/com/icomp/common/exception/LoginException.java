package com.icomp.common.exception;

public class LoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理系统异常
	 * 
	 * @param e
	 */
	public LoginException(BusinessException e) {

	}

	/**
	 * 处理系统异常返回页面
	 */
	public LoginException() {
		
	}

}
