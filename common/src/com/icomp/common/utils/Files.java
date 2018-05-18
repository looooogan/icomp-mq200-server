package com.icomp.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Files {
	
	/**
	 * 创建目录
	 * @param dir
	 * @return
	 */
	public static String mkdir(String dir) {
		boolean isTrue = false;
		File file = new File(dir);
		if (file.isDirectory()) {
			if (file.exists()) {
				isTrue = true;
			}
		}
		if(!isTrue){
			file.mkdirs();
		}
		return dir;
	}
	
	/**
	 * 文件删除
	 * @param sPath
	 * @return
	 */
	public static Boolean rm(String path) {  
	    boolean flag = false;  
	    File file = new File(path);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}
	
	public static boolean isFile(String path){
		boolean flag = false;
		File file = new File(path);
		if (file.isFile() && file.exists()) {
			flag = true;
		}
		return flag;
	}
	
	public static String  fileUpload(String path,String filename,File file) throws IOException{
		 FileOutputStream fos;
			mkdir(path);
			fos = new FileOutputStream(path+"//"+filename);
		
	        FileInputStream fis=new FileInputStream(file);
	        byte[] buffer=new byte[1024];
	        int len=0;
	        while((len=fis.read(buffer))>0){
	            fos.write(buffer, 0, len);
	        }
	        return path;
	}
}
