package com.icomp.wsdl.v01c01.c01s024.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s024.business.C01S024Business;
import com.icomp.wsdl.v01c01.c01s024.business.impl.C01S024BusinessImpl;
import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Request;
import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Respons;
import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;
/**
 * 刀具管理-刀具状态查询-Webservce实现类
 * @ClassName: C01S024WsdlImpl
 * @author Taoyy
 * @date 2014-9-23 下午12:15:42
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Wsdl")
public class C01S024WsdlImpl extends BaseWsdl implements C01S024Wsdl{
	/**
	 * 刀具管理-刀具状态查询-Business接口
	 */
	private C01S024Business c01S024Business;

	public void setC01S024Business(C01S024BusinessImpl c01S024Business) {
		this.c01S024Business = c01S024Business;
	}
	C01S024Request regSwitch;

	/**
	 * 取得要查询的信息
	 */
	public String getInformation(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S024Request)obj;
			// 取得信息
			C01S024Respons ret = (C01S024Respons)c01S024Business.getInformation(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getInformation", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0018,null, null));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S024WsdlImpl","getInformation",regSwitch.getCustomerID());
			C01S024Respons ret = new C01S024Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S024WsdlImpl","getInformation",regSwitch.getCustomerID());
			C01S024Respons ret = new C01S024Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}


























	/**
	 * 取得单品刀具信息
	 */
	public String getToolInfo(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S024Request)obj;
			// 取得单品刀具信息
			C01S024Respons ret = (C01S024Respons)c01S024Business.getToolInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0018,null,null));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S024WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C01S024Respons ret = new C01S024Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S024WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C01S024Respons ret = new C01S024Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
}
