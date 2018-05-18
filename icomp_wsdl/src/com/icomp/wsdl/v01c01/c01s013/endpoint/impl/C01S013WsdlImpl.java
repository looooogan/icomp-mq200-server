package com.icomp.wsdl.v01c01.c01s013.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s013.business.C01S013Business;
import com.icomp.wsdl.v01c01.c01s013.business.impl.C01S013BusinessImpl;
import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Request;
import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Respons;
import com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;
/**
 * 设备卸下-Webservce实现类
 * @ClassName: C01S013WsdlImpl 
 * @author Taoyy
 * @date 2014-9-23 上午11:56:40
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s013.endpoint.C01S013Wsdl")
public class C01S013WsdlImpl extends BaseWsdl implements C01S013Wsdl{
	/**
	 * 设备卸下-Business接口
	 */
	private C01S013Business c01S013Business;
	private C01S013Request regSwitch;
	
	public void setC01S013Business(C01S013BusinessImpl c01S013Business) {
		this.c01S013Business = c01S013Business;
	}
	
	
	/**
	 * 取得合成刀下设备信息
	 */
	public String getSynthesisToolInfoOutEqu(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S013Request)obj;
			// 取得扫描合成刀具信息
			C01S013Respons ret = (C01S013Respons)c01S013Business.getSynthesisToolInfoOutEqu(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getSynthesisToolInfoOutEqu", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),
					MessageReSource.getMessageBox(IConstant.CIMSG0049,"", ""));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S013WsdlImpl","getSynthesisToolInfoOutEqu",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S013WsdlImpl","getSynthesisToolInfoOutEqu",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 提交合成刀下设备信息
	 */
	public String submitSyntheticUnloadEquipmentInfo(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S013Request)obj;
			// 合成刀具卸下设备
			C01S013Respons ret = (C01S013Respons)c01S013Business.submitSyntheticUnloadEquipmentInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitSyntheticUnloadEquipmentInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0051,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S013WsdlImpl","submitSyntheticUnloadEquipmentInfo",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S013WsdlImpl","submitSyntheticUnloadEquipmentInfo",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 取得扫描合成刀具信息
	 */
	public String getSynthesisToolInfo(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S013Request)obj;
			// 取得扫描合成刀具信息
			C01S013Respons ret = (C01S013Respons)c01S013Business.getSynthesisToolInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getSynthesisToolInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0049,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S013WsdlImpl","getSynthesisToolInfo",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S013WsdlImpl","getSynthesisToolInfo",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 合成刀具卸下设备
	 */
	public String saveToolRecovery(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S013Request)obj;
			// 合成刀具卸下设备
			C01S013Respons ret = (C01S013Respons)c01S013Business.saveToolRecovery(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveToolRecovery", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0051,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S013WsdlImpl","saveToolRecovery",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S013WsdlImpl","saveToolRecovery",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	/**
	 * 取得设备（砂轮）卸下合成刀具信息
	 */
	@Override
	public String getSynthesisToolInfoOutWheel(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S013Request)obj;
			// 取得设备（砂轮）卸下合成刀具信息
			C01S013Respons ret = (C01S013Respons)c01S013Business.getSynthesisToolInfoOutWheel(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog("01", this.getClass().getName(),"getSynthesisToolInfoOutWheel", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),
					MessageReSource.getMessageBox(IConstant.CIMSG0049,"01", "zh_CN"));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S013WsdlImpl","getSynthesisToolInfoOutWheel",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S013WsdlImpl","getSynthesisToolInfoOutWheel",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	/**
	 * 提交设备（砂轮）卸下合成刀具信息
	 */
	@Override
	public String submitSyntheticUnloadWheelInfo(String request)
			throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S013Request)obj;
			// 提交设备（砂轮）卸下合成刀具信息
			C01S013Respons ret = (C01S013Respons)c01S013Business.submitSyntheticUnloadWheelInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitSyntheticUnloadWheelInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),
					MessageReSource.getMessageBox(IConstant.CIMSG0051,null, null));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S013WsdlImpl","submitSyntheticUnloadWheelInfo",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S013WsdlImpl","submitSyntheticUnloadWheelInfo",regSwitch.getCustomerID());
			C01S013Respons ret = new C01S013Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}


	
}
