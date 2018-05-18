package com.icomp.wsdl.v01c03.c03s001.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c03.c03s001.business.impl.C03S001BusinessImpl;
import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Request;
import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Respons;
import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Wsdl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;
@WebService(endpointInterface = "com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Wsdl")
public class C03S001WsdlImpl  extends BaseWsdl  implements C03S001Wsdl{
	C03S001Request regSwitch ;
	private C03S001BusinessImpl c03S001Business;
	
	public void setC03S001Business(C03S001BusinessImpl c03S001Business) {
		this.c03S001Business = c03S001Business;
	}
	/**
	 * 提交初始化合成刀具信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitInitSynthesis(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.submitInitSynthesis(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitInitSynthesis", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0093,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","submitInitSynthesis",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","submitInitSynthesis",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询要初始化的合成刀具
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String seachInitSynthesisByRfid(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.seachInitSynthesisByRfid(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"seachInitSynthesisByRfid", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","seachInitSynthesisByRfid",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","seachInitSynthesisByRfid",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询合成刀具组成信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getSynthesisMsg(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.getSynthesisMsg(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getSynthesisMsg", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","getSynthesisMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","getSynthesisMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询当前标签是否已初始化(库位标签)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String findLibraryInitializeMsg(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;C03S001Respons ret = (C03S001Respons)c03S001Business.findLibraryInitializeMsg(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"findLibraryInitializeMsg", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","findLibraryInitializeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","findLibraryInitializeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 提交库存标签初始化数据
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitLibraryCodeMsg(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.submitLibraryCodeMsg(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitLibraryCodeMsg", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","submitLibraryCodeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","submitLibraryCodeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 按材料号查询库存标签信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String findLibraryCodeMsg(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.findLibraryCodeMsg(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"findLibraryCodeMsg", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","findLibraryCodeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","findLibraryCodeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 提交库存新刀初始化数据
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitNewVentoryInItDate(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.submitNewVentoryInItDate(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitNewVentoryInItDate", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","submitNewVentoryInItDate",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","submitNewVentoryInItDate",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询待初始化库存新刀
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String seachInitNewVentory(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.seachInitNewVentory(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"seachInitNewVentory", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","seachInitNewVentory",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","seachInitNewVentory",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 提交流转旧刀初始化数据
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitOldRunInItDate(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.submitOldRunInItDate(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitOldRunInItDate", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","submitOldRunInItDate",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","submitOldRunInItDate",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 查询当前标签是否已初始化
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String findInitializeMsg(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.findInitializeMsg(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"findInitializeMsg", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","findInitializeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","findInitializeMsg",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 根据材料号查询待初始化旧刀
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String seachOldRunToolsByToolCode(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.seachOldRunToolsByToolCode(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"seachOldRunToolsByToolCode", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","seachOldRunToolsByToolCode",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","seachOldRunToolsByToolCode",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
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
			 regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.checkRfid(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"checkRfid", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0070,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","checkRfid",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","checkRfid",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 取得刀具基本信息webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getToolInfo(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.getToolInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0006,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 判断rfid状态
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getRfidType(String request) throws Exception {
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.getRfidType(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getRfidType", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0004,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","getRfidType",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","getRfidType",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 初始化刀具信息保存webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveInitialization(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C03S001Request)obj;
			C03S001Respons ret = (C03S001Respons)c03S001Business.saveInitialization(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveInitialization", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0078,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C03S001WsdlImpl","saveInitialization",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C03S001WsdlImpl","saveInitialization",regSwitch.getCustomerID());
			C03S001Respons ret = new C03S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
}
