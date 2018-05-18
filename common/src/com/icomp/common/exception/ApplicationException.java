package com.icomp.common.exception;

import com.icomp.common.constant.IConstant;
import com.icomp.common.utils.CommonLogUtil;
import org.apache.log4j.Logger;
import org.apache.struts2.json.JSONUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;



public class ApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 处理系统异常
	 * @param
	 */
	public static void  setApplicationException(HttpServletResponse response,String url,int status,BusinessException ex,String className,String methodName,String userID){
		//记录系统异常
		response.setContentType("text/html;charset=utf-8");
		try {
			//保存日志信息
			LogSave(ex,className,methodName,userID);
			//设置页面返回信息
			Map<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("info",url);
			rtn.put("status",status);
			rtn.put("message",ex.getLocalMessage());
			rtn.put("rows",null);
			PrintWriter out = response.getWriter();
			out.print(JSONUtil.serialize(rtn));
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}

	
	public static void setApplicationException(BusinessException ex,String className,String methodName,String userID){
		//记录系统异常
		try {
			//保存日志信息
			LogSave(ex,className,methodName,userID);
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	
	public static void setApplicationException(String message,String className,String methodName,String userID){
		//记录系统异常
		try {
			//保存日志信息
			LogSave(message,className,methodName,userID);
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	/**
	 * 处理系统异常返回页面
	 * @param
	 * @param methodName
	 */
	private static void LogSave(String message,String className,String methodName,String userID){
		//记录系统错误日志
		CommonLogUtil.saveBrowsLog("01", className, methodName, IConstant.SYSTEM_LOG_FLAG_2,IConstant.SYSTEM_LOG_LEVEL_2, userID,"[" + message + "]");
	}
	/**
	 * 处理系统异常返回页面
	 * @param
	 * @param methodName
	 */
	private static void LogSave(BusinessException e,String className,String methodName,String userID){
		//记录系统错误日志
		CommonLogUtil.saveBrowsLog(e.getLocal(), className, methodName, IConstant.SYSTEM_LOG_FLAG_2,IConstant.SYSTEM_LOG_LEVEL_2, userID,(e.getMessage()==null?"":e.getMessage())+ "[" + e.getLocalMessage() + "]");
	}
	
}
