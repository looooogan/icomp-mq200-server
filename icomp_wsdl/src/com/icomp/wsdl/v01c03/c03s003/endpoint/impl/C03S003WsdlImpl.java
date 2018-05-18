package com.icomp.wsdl.v01c03.c03s003.endpoint.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c03.c03s003.business.C03S003Business;
import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Request;
import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Respons;
import com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c03.c03s003.endpoint.C03S003Wsdl")
public class C03S003WsdlImpl   extends BaseWsdl  implements C03S003Wsdl{
	C03S003Request regSwitch ;
	private C03S003Business c03s003Business;
	
	public void setC03S003Business(C03S003Business c03s003Business) {
		this.c03s003Business = c03s003Business;
	}
	

	/**
	 * 取得设备类型及设备列表
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getEquipment(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C03S003Request)obj;
			C03S003Respons ret = (C03S003Respons)c03s003Business.getEquipment(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveToolList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S003WsdlImpl","saveToolList",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S003WsdlImpl","saveToolList",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 绑定设备标签
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveEquipmentRfid(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C03S003Request)obj;
			C03S003Respons ret = (C03S003Respons)c03s003Business.saveEquipmentRfid(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveToolList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S003WsdlImpl","saveToolList",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S003WsdlImpl","saveToolList",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询员工信息
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String findMemberMsgByCard(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S003Request)obj;
			C03S003Respons ret = (C03S003Respons)c03s003Business.findMemberMsgByCard(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"findMemberMsgByCard", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S003WsdlImpl","findMemberMsgByCard",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S003WsdlImpl","findMemberMsgByCard",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 初始化员工卡
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String submitEmployeeCardMsg(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S003Request)obj;
			C03S003Respons ret = (C03S003Respons)c03s003Business.submitEmployeeCardMsg(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitEmployeeCardMsg", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0080,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S003WsdlImpl","submitEmployeeCardMsg",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S003WsdlImpl","submitEmployeeCardMsg",regSwitch.getCustomerID());
			C03S003Respons ret = new C03S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
}
