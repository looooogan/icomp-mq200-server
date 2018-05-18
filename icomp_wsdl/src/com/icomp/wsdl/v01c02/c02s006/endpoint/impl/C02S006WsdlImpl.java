package com.icomp.wsdl.v01c02.c02s006.endpoint.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c02.c02s006.business.impl.C02S006BusinessImpl;
import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Request;
import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Respons;
import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Wsdl")
public class C02S006WsdlImpl  extends BaseWsdl  implements C02S006Wsdl{
	C02S006Request regSwitch ;
	private C02S006BusinessImpl c02S006Business;
	
	public void setC02S006Business(C02S006BusinessImpl c02S006Business) {
		this.c02S006Business = c02S006Business;
	}
	

	/**
	 * 取得部门列表及已注册部门信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getDepatement(@WebParam(name = "request")String request) throws Exception {
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C02S006Request)obj;
			C02S006Respons ret = (C02S006Respons)c02S006Business.getDepatement(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getDepatement", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0074, regSwitch.getLanguageCode(),regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C02S006WsdlImpl","getDepatement",regSwitch.getCustomerID());
			C02S006Respons ret = new C02S006Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C02S006WsdlImpl","getDepatement",regSwitch.getCustomerID());
			C02S006Respons ret = new C02S006Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 手持机注册
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveHand(@WebParam(name = "request")String request) throws Exception {
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C02S006Request)obj;
			C02S006Respons ret = (C02S006Respons)c02S006Business.saveHand(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveHand", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0075, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C02S006WsdlImpl","saveHand",regSwitch.getCustomerID());
			C02S006Respons ret = new C02S006Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C02S006WsdlImpl","saveHand",regSwitch.getCustomerID());
			C02S006Respons ret = new C02S006Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
}
