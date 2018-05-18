package com.icomp.wsdl.v01c03.c03s002.endpoint.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c03.c03s002.business.impl.C03S002BusinessImpl;
import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Request;
import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Respons;
import com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c03.c03s002.endpoint.C03S002Wsdl")
public class C03S002WsdlImpl   extends BaseWsdl  implements C03S002Wsdl{
	C03S002Request regSwitch ;
	private C03S002BusinessImpl c03S002Business;
	
	public void setC03S002Business(C03S002BusinessImpl c03S002Business) {
		this.c03S002Business = c03S002Business;
	}
	
	/**
	 * 验证RFID是否可用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String checkRfid(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.checkRfid(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"checkRfid", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","checkRfid",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","checkRfid",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 取得合成刀具列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getToolList(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.getToolList(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0034,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","getToolList",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","getToolList",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 取得合成刀具配置信息webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolInfo(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.getToolInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0079,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	/**
	 * 取得合成刀具配置信息webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveToolList(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.saveToolList(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveToolList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","saveToolList",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","saveToolList",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询所有流水线和设备
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String findAllEquipment(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.findAllEquipment(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"findAllEquipment", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","findAllEquipment",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","findAllEquipment",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 设备标签绑定
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String submitEquipmentRifdCode(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.submitEquipmentRifdCode(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitEquipmentRifdCode", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","submitEquipmentRifdCode",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","submitEquipmentRifdCode",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 容器标签绑定
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String submitContainer(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.submitContainer(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitContainer", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","submitContainer",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","submitContainer",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询所有刃磨设备
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String findGrindEquipment(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S002Request)obj;
			C03S002Respons ret = (C03S002Respons)c03S002Business.findGrindEquipment(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"findGrindEquipment", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S002WsdlImpl","findGrindEquipment",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S002WsdlImpl","findGrindEquipment",regSwitch.getCustomerID());
			C03S002Respons ret = new C03S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
}
