package com.icomp.wsdl.v01c02.c02s008.endpoint.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c02.c02s008.business.impl.C02S008BusinessImpl;
import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Request;
import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Respons;
import com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Wsdl;
@WebService(endpointInterface = "com.icomp.wsdl.v01c02.c02s008.endpoint.C02S008Wsdl")
public class C02S008WsdlImpl  extends BaseWsdl  implements C02S008Wsdl{
	C02S008Request regSwitch ;
	private C02S008BusinessImpl c02S008Business;
	
	public void setC02S008Business(C02S008BusinessImpl c02S008Business) {
		this.c02S008Business = c02S008Business;
	}
	
	/**
	 * 保存用户卡绑定信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveUserBinding(@WebParam(name = "request")String request)throws Exception{
		try{
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			 regSwitch = (C02S008Request)obj;
			C02S008Respons ret = (C02S008Respons)c02S008Business.saveUserBinding(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveUserBinding", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0077,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C02S008WsdlImpl","saveUserBinding",regSwitch.getCustomerID());
			C02S008Respons ret = new C02S008Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C02S008WsdlImpl","saveUserBinding",regSwitch.getCustomerID());
			C02S008Respons ret = new C02S008Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	
	}
}
