package com.icomp.wsdl.v01c04.c04s001.endpoint.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c04.c04s001.business.impl.C04S001BusinessImpl;
import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Request;
import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Respons;
import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Wsdl")
public class C04S001WsdlImpl   extends BaseWsdl implements C04S001Wsdl{
	C04S001Request regSwitch;
	private C04S001BusinessImpl c04S001Business;
	
	public void setC04S001Business(C04S001BusinessImpl c04S001Business) {
		this.c04S001Business = c04S001Business;
	}
	
	/**
	 * 取得当前扫描刀具数据webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getToolList(@WebParam(name = "request")String  request) throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C04S001Request)obj;
			C04S001Respons ret = (C04S001Respons)c04S001Business.getToolList(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0081,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C04S001WsdlImpl","getToolList",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C04S001WsdlImpl","getToolList",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	/**
	 * 取得盘点数据列表webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String getStockingList(@WebParam(name = "request")String  request) throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C04S001Request)obj;
			C04S001Respons ret = (C04S001Respons)c04S001Business.getStockingList(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getStockingList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0082,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C04S001WsdlImpl","getStockingList",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C04S001WsdlImpl","getStockingList",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 保存盘点数据列表webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String saveStockingList(@WebParam(name = "request")String  request) throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C04S001Request)obj;
			C04S001Respons ret = (C04S001Respons)c04S001Business.saveStockingList(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveStockingList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0083,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C04S001WsdlImpl","saveStockingList",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C04S001WsdlImpl","saveStockingList",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	/**
	 * 根据材料号查询刀具在库数量webService
	 * @param request
	 * @return
	 * @throws ConnectException
	 * @throws Exception
	 */
	public String seachInitNewVentory(@WebParam(name = "request")String  request) throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C04S001Request)obj;
			C04S001Respons ret = (C04S001Respons)c04S001Business.seachInitNewVentory(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"seachInitNewVentory", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),
					MessageReSource.getMessageBox(IConstant.CIMSG0081,null,null));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C04S001WsdlImpl","seachInitNewVentory",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C04S001WsdlImpl","seachInitNewVentory",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}/**
	 * 提交在库盘点刀具webService
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String submitCheckToolDate(@WebParam(name = "request")String  request) throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C04S001Request)obj;
			C04S001Respons ret = (C04S001Respons)c04S001Business.submitCheckToolDate(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"submitCheckToolDate", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0081,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C04S001WsdlImpl","submitCheckToolDate",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C04S001WsdlImpl","submitCheckToolDate",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	@Override
	public String checkRFIDType(String request) throws Exception {
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C04S001Request)obj;
			C04S001Respons ret = (C04S001Respons)c04S001Business.checkRFIDType(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"checkRFIDType", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0081,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C04S001WsdlImpl","checkRFIDType",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C04S001WsdlImpl","checkRFIDType",regSwitch.getCustomerID());
			C04S001Respons ret = new C04S001Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
}
