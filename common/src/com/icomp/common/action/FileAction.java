package com.icomp.common.action;

import com.icomp.common.utils.Files;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String RE_LOGIN = "relogin";
	
	private String savePath;//上传文件的保存路径
//	public String Filedata;
//	public String Filename;
    public String getSavePath() {
        System.out.println(ServletActionContext.getServletContext().getRealPath(savePath));
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
        System.out.println("savePath: "+savePath);
    }

//	public String getFiledata() {
//		return Filedata;
//	}
//	public void setFiledata(String filedata) {
//		Filedata = filedata;
//	}
//	public String getFilename() {
//		return Filename;
//	}
//	public void setFilename(String filename) {
//		Filename = filename;
//	}
	/**
	 * 获得HttpServletRequest
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	}
	
	/**
	 * 获得HttpServletResponse
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
	}
	
	public String root(){
		return this.getRequest().getContextPath();
	}
	
	public String getRealPath(String url){
		return this.getRequest().getSession().getServletContext().getRealPath(url);
	}
	
	public void ajaxReturn(Object data,String info,int status){
		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			Map<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("data",data);
			rtn.put("info",info);
			rtn.put("status",status);
			PrintWriter out = response.getWriter();
			out.print(JSONUtil.serialize(rtn));
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	
	public void ajaxReturn(Object data,String info,int status,String message){
		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			Map<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("data",data);
			rtn.put("info",info);
			rtn.put("status",status);
			rtn.put("message",message);
			PrintWriter out = response.getWriter();
			out.print(JSONUtil.serialize(rtn));
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	
	public void ajaxReturn(Object data,String info,Object message,int status){
		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			Map<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("data",data);
			rtn.put("info",info);
			rtn.put("status",status);
			rtn.put("message",message);
			PrintWriter out = response.getWriter();
			out.print(JSONUtil.serialize(rtn));
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}	public void ajaxReturnList(Object data,String info,Object message,int status){
		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			Map<String,Object> rtn = new HashMap<String,Object>();
			rtn.put("list1",new ArrayList<String>());
			rtn.put("list2",new ArrayList<String>());
			rtn.put("status",status);
			rtn.put("message",message);
			PrintWriter out = response.getWriter();
			out.print(JSONUtil.serialize(rtn));
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	
	public void ajaxReturn(Object data){
		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			String ret = JSONUtil.serialize(data);
			out.print(ret);
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	public void echo(Object data){
		HttpServletResponse response = getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(data);
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	
	/**
	 * 获取request全部参数
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> param(){
		Map<String,Object> reMap=new HashMap<String,Object>();
		Map pars = this.getRequest().getParameterMap();
		Set<Map.Entry> entitySet=pars.entrySet();
		for(Map.Entry<String, String[]> entity:entitySet){
			if(entity.getValue().length==1){
				reMap.put(entity.getKey(), (entity.getValue())[0]);	
			}else{
				reMap.put(entity.getKey(), entity.getValue());
			}	
		}
		return reMap;
	}
	
	/**
	 * 页面赋值
	 * @param name
	 * @param value
	 */
	public void assign(String name,Object value){
		this.getRequest().setAttribute(name, value);
	}
	
	/**
	 * 页面跳转
	 * @param location
	 */
	public void redirect(String location){
		try {
			this.getResponse().sendRedirect(location);
		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage());
		}
	}
	
	/**
	 * 获取Session
	 * @param key
	 */
	public Object session(String key){
		if(key == null){
			this.getRequest().getSession().invalidate();
			return null;
		}else{
//			Map session = (Map) ActionContext.getContext().get("session");
//			return session.get(key);
			return this.getRequest().getSession().getAttribute(key);
		}
	}
	
	/**
	 * 写入Session
	 * @param key
	 * @param value
	 */
	public void session(String key,Object value){
		if(value == null){
			this.getRequest().getSession().removeAttribute(key);
		}else{
			this.getRequest().getSession().setAttribute(key, value);
		}
	}
	
	/**
	 * 读取Cookie
	 * @param key
	 * @return
	 */
	public Object cookie(String key){
		return null;
	}
	
	/**
	 * 写入Cookie
	 * @param key
	 * @param value
	 */
	public void cookie(String key,Object value){
		
	}
	
	/**
	 * 下载函数
	 */
	public void download(String url){
		String path = getRealPath(url);
		if(Files.isFile(path)){
			String filename = url.substring(url.lastIndexOf("/")+1);
			String file[] = filename.split("\\.");
			try {
				InputStream inStream = new FileInputStream(path);
				getResponse().reset();
				getResponse().setContentType("bin");
				getResponse().addHeader("Content-Disposition", "attachment; filename=\"" + new String(file[0].getBytes("GB2312"),"ISO8859-1") + "."+file[1]+"\"");
				byte[] b = new byte[100];
				int len;
				while ((len = inStream.read(b)) > 0) {
					getResponse().getOutputStream().write(b, 0, len);
				}
				inStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			echo("<script>alert('文件不存在！');window.close();</script>");
		}
	}
	
	
}
