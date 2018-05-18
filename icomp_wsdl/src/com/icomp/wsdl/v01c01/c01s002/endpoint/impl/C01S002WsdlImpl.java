package com.icomp.wsdl.v01c01.c01s002.endpoint.impl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s002.business.impl.C01S002BusinessImpl;
import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Request;
import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Respons;
import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Wsdl;

@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Wsdl")
public class C01S002WsdlImpl extends BaseWsdl implements C01S002Wsdl {

	C01S002Request regSwitch;

	private C01S002BusinessImpl c01S002Business;

	public void setC01S002Business(C01S002BusinessImpl c01S002Business) {
		this.c01S002Business = c01S002Business;
	}

	/**
	 * 授权
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveAuthorized(String request) throws Exception {
		try {
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S002Request) obj;
			C01S002Respons ret = (C01S002Respons) c01S002Business
					.saveAuthorized(regSwitch);
			byte[] tre = objectToBytes(ret);
			// 授权
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this
					.getClass().getName(), "saveAuthorized",
					IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0,
					regSwitch.getCustomerID(), MessageReSource.getMessageBox(
							IConstant.CIMSG0004, regSwitch.getLanguageCode(),
							regSwitch.getLanguageValue()));
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(ex, "C01S002WsdlImpl",
					"saveAuthorized", regSwitch.getCustomerID());
			C01S002Respons ret = new C01S002Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		} catch (Exception ex) {
			ApplicationException
					.setApplicationException(ex.getMessage(),
							"C01S002WsdlImpl", "saveAuthorized", regSwitch
									.getCustomerID());
			C01S002Respons ret = new C01S002Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		}
	}
	
}
