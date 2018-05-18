package com.icomp.wsdl.v01c01.c01s001.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s001.business.impl.C01S001BusinessImpl;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Request;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Respons;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Wsdl")
public class C01S001WsdlImpl extends BaseWsdl implements C01S001Wsdl {

    C01S001Request regSwitch;

    private C01S001BusinessImpl c01S001Business;

    public void setC01S001Business(C01S001BusinessImpl c01S001Business) {
        this.c01S001Business = c01S001Business;
    }

    /**
     * 取得钻头(刀片)入库的信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String getBitInputInf(String request) throws Exception {
        System.out.println ( "request" + request );
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S001Request) obj;
            C01S001Respons ret = (C01S001Respons) c01S001Business.getBitInputInf ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            // 取得钻头(刀片)入库的信息
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getBitInputInf", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0004, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S001WsdlImpl", "getBitInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S001WsdlImpl", "getBitInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setStateMsg ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 提交钻头入库信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String setBitInputInf(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S001Request) obj;
            C01S001Respons ret = (C01S001Respons) c01S001Business.setBitInputInf ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            // 提交钻头入库的信息
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "setBitInputInf", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0004, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S001WsdlImpl", "setBitInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S001WsdlImpl", "setBitInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 查询钻头(刀片)入库的信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String searchBitInputInf(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S001Request) obj;
            C01S001Respons ret = (C01S001Respons) c01S001Business.searchBitInputInf ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            // 查询钻头(刀片)入库的信息
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "searchBitInputInf", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0004, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S001WsdlImpl", "searchBitInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S001WsdlImpl", "searchBitInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 提交刀片入库信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String setToolInputInf(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S001Request) obj;
            C01S001Respons ret = (C01S001Respons) c01S001Business.setToolInputInf ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            // 提交钻头入库的信息
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "setToolInputInf", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0004, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S001WsdlImpl", "setToolInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S001WsdlImpl", "setToolInputInf", regSwitch.getCustomerID () );
            C01S001Respons ret = new C01S001Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

}
