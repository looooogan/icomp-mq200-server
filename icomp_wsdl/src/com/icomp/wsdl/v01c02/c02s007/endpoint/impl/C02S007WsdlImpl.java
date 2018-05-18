package com.icomp.wsdl.v01c02.c02s007.endpoint.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c02.c02s007.business.impl.C02S007BusinessImpl;
import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Request;
import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Respons;
import com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s007.endpoint.C02S007Wsdl")
public class C02S007WsdlImpl  extends BaseWsdl   implements C02S007Wsdl{
	C02S007Request regSwitch;
	private C02S007BusinessImpl c02S007Business;
	
	public void setC02S007Business(C02S007BusinessImpl c02S007Business) {
		this.c02S007Business = c02S007Business;
	}
	
	/**
	 * 获取系统支持的语言列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getLangageList(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C02S007Request)obj;
			C02S007Respons ret = (C02S007Respons)c02S007Business.getLangageList(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getLangageList", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0076,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C02S007WsdlImpl","getLangageList",regSwitch.getCustomerID());
			C02S007Respons ret = new C02S007Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C02S007WsdlImpl","getLangageList",regSwitch.getCustomerID());
			C02S007Respons ret = new C02S007Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	
	}
}
