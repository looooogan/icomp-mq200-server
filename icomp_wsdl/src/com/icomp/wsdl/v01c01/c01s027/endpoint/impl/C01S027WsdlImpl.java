package com.icomp.wsdl.v01c01.c01s027.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s027.business.impl.C01S027BusinessImpl;
import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Request;
import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Respons;
import com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 刀具管理-刀具送回-Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S027WsdlImpl
 * @date 2016年3月9日 14:02:24
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s027.endpoint.C01S027Wsdl")
public class C01S027WsdlImpl extends BaseWsdl implements C01S027Wsdl {
    /**
     * 刀具管理-刀具交接-Business接口
     */
    private C01S027BusinessImpl C01S027Business;

    public void setC01S027Business(C01S027BusinessImpl c01S027Business) {
        C01S027Business = c01S027Business;
    }

    private C01S027Request regSwitch;



    @Override
    public String getTransferToolsContarner(String request) throws Exception {
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S027Request) obj;
            // 取得交接的容器
            C01S027Respons ret = (C01S027Respons) C01S027Business.getTransferToolsContarner(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getTransferToolsContarner", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0073, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S027WsdlImpl", "getTransferToolsContarner", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S027WsdlImpl", "getTransferToolsContarner", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    @Override
    public String saveKnifeToGrindingData(String request) throws Exception {
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S027Request) obj;
            // 对刀室-->刃磨室 提交数据
            C01S027Respons ret = (C01S027Respons) C01S027Business.saveKnifeToGrindingData(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveKnifeToGrindingData", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0073, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S027WsdlImpl", "saveKnifeToGrindingData", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S027WsdlImpl", "saveKnifeToGrindingData", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    @Override
    public String saveGrindingToKnifeData(String request) throws Exception {
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S027Request) obj;
            // 刃磨室-->对刀室 提交数据
            C01S027Respons ret = (C01S027Respons) C01S027Business.saveGrindingToKnifeData(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveGrindingToKnifeData", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0073, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S027WsdlImpl", "saveGrindingToKnifeData", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S027WsdlImpl", "saveGrindingToKnifeData", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    @Override
    public String getPutContarner(String request) throws Exception {
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S027Request) obj;
            //取得盛放的容器
            C01S027Respons ret = (C01S027Respons) C01S027Business.getPutContarner(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getPutContarner", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0073, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S027WsdlImpl", "getPutContarner", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S027WsdlImpl", "getPutContarner", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得刀具送回信息
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public String getToolBackInfo(String request) throws Exception {
		try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S027Request) obj;
            //取得盛放的容器
            C01S027Respons ret = (C01S027Respons) C01S027Business.getToolBackInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolBackInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0073, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S027WsdlImpl", "getToolBackInfo", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S027WsdlImpl", "getToolBackInfo", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

	/**
     * 提交刀具送回的刀具信息
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public String saveToolBackInfo(String request) throws Exception {
		try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S027Request) obj;
            //取得盛放的容器
            C01S027Respons ret = (C01S027Respons) C01S027Business.saveToolBackInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveToolBackInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0073, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S027WsdlImpl", "saveToolBackInfo", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S027WsdlImpl", "saveToolBackInfo", regSwitch.getCustomerID());
            C01S027Respons ret = new C01S027Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}
}
