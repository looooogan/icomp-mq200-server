package com.icomp.common.wsdl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import Decoder.BASE64Decoder;

import com.icomp.common.pojo.BaseRespons;

public abstract class BaseWsdl {

	protected Object decoderObject(String request) throws Exception {
		byte[] buf = new BASE64Decoder().decodeBuffer(request);
		return bytesToObject(buf);
	}
	
	protected String encodeBase64String(BaseRespons ret) throws Exception {
		byte[] tre = objectToBytes(ret);
		
		return new String(org.apache.commons.codec.binary.Base64
				.encodeBase64(tre));
	}
	
	protected byte[] objectToBytes(Object obj) throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		ObjectOutputStream sOut = new ObjectOutputStream(out);

		sOut.writeObject(obj);

		sOut.flush();

		byte[] bytes = out.toByteArray();

		return bytes;

	}

	protected Object bytesToObject(byte[] bytes) throws Exception {

		ByteArrayInputStream in = new ByteArrayInputStream(bytes);

		ObjectInputStream sIn = new ObjectInputStream(in);

		return sIn.readObject();

	}
	
	/**
	 * 获得其它业务类对象
	* */
	protected Object getBean(String FileName,String name)
	 {
		ApplicationContext ac = new FileSystemXmlApplicationContext(FileName);
		return ac.getBean(name);
	 }
}
