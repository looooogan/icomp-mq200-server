package com.icomp.wsdl.v01c01.c01s005.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s005.business.impl.C01S005BusinessImpl;
import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Request;
import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Respons;
import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Wsdl")
public class C01S005WsdlImpl extends BaseWsdl implements C01S005Wsdl {

    C01S005Request regSwitch;

    private C01S005BusinessImpl c01S005Business;

    public void setC01S005Business(C01S005BusinessImpl c01S005Business) {
        this.c01S005Business = c01S005Business;
    }

    /**
     * 报废
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String saveScrap(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S005Request) obj;
            C01S005Respons ret = (C01S005Respons) c01S005Business.saveScrap ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            // 报废
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "saveScrap", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0004, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S005WsdlImpl", "saveScrap", regSwitch.getCustomerID () );
            C01S005Respons ret = new C01S005Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S005WsdlImpl", "saveScrap", regSwitch.getCustomerID () );
            C01S005Respons ret = new C01S005Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    @Override
    public String getToolMsg(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S005Request) obj;
            C01S005Respons ret = (C01S005Respons) c01S005Business.getToolMsg ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            // 报废
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getToolMsg", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0004, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S005WsdlImpl", "getToolMsg", regSwitch.getCustomerID () );
            C01S005Respons ret = new C01S005Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S005WsdlImpl", "getToolMsg", regSwitch.getCustomerID () );
            C01S005Respons ret = new C01S005Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    @Override
    public String delRfidCodeIsNull(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S005Request) obj;
            // 清空当前扫描的标签信息
            C01S005Respons ret = c01S005Business.delRfidCodeIsNull ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "delRfidCodeIsNull", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), "清空当前扫描的标签信息" );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S005WsdlImpl", "delRfidCodeIsNull", regSwitch.getCustomerID () );
            C01S005Respons ret = new C01S005Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S005WsdlImpl", "delRfidCodeIsNull", regSwitch.getCustomerID () );
            C01S005Respons ret = new C01S005Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }


}
