package com.icomp.common.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FileDownloadAction extends ActionSupport{


	public String inputPath;

	public String filenames;

	public String getFilenames() {
		return filenames;
	}

	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String getDownloadFileName(){


		String downloadFileName ="";
		try {
			String  filename = filenames.substring(37);
//String filename =	new String(file.getBytes("utf-8");
			System.out.println(filename);
			downloadFileName = URLEncoder.encode(filename,"utf-8");

		} catch (UnsupportedEncodingException e) {
			return "获取文件名出现了错误!";
		}
		return downloadFileName;
	}

	public InputStream getInputStream() throws IOException{
		String path = ServletActionContext.getServletContext().getRealPath("//images");
//		String filename = this.getDownloadFileName();

//		String filepath = path + "\\" + new String(filenames.getBytes("ISO-8859-1"), "utf-8");
		String filepath = path + "//"+filenames;
		System.out.println(filepath+"4444");
		File file = new File(filepath);
		return FileUtils.openInputStream(file);
//		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}


}
