package com.icomp.wsdl.v01c01.c01s019.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s019.business.C01S019Business;
import com.icomp.wsdl.v01c01.c01s019.business.impl.C01S019BusinessImpl;
import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Request;
import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Respons;
import com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 对刀结束-Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S019WsdlImpl
 * @date 2014-9-23 下午12:05:28
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s019.endpoint.C01S019Wsdl")
public class C01S019WsdlImpl extends BaseWsdl implements C01S019Wsdl {
    /**
     * 对刀结束-Business接口
     */
    private C01S019Business c01S019Business;

    public void setC01S019Business(C01S019BusinessImpl c01S019Business) {
        this.c01S019Business = c01S019Business;
    }

    private C01S019Request regSwitch;

    /**
     * 取得要绑定的刀具信息
     */
    public String getBindingToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 取得合成刀具信息
            C01S019Respons ret = (C01S019Respons) c01S019Business.getBindingToolInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getBindingToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0034, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "getBindingToolInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "getBindingToolInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 取得激光码
     */
    public String getLaserCode(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 取得合成刀具信息
            C01S019Respons ret = (C01S019Respons) c01S019Business.getLaserCode ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getLaserCode", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0034, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "getLaserCode", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "getLaserCode", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 提交激光码
     */
    public String setLaserCode(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 取得合成刀具信息
            C01S019Respons ret = (C01S019Respons) c01S019Business.setLaserCode ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "setLaserCode", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0034, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "setLaserCode", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "setLaserCode", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 提交刀具绑定信息
     */
    public String submitToolBindingInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 取得合成刀具信息
            C01S019Respons ret = (C01S019Respons) c01S019Business.submitToolBindingInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "submitToolBindingInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0034, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "submitToolBindingInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "submitToolBindingInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    @Override
    public String getOutfactTools(String request) throws Exception {
          try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 取得要出厂的刀具信息
            C01S019Respons ret = c01S019Business.getOutfactTools ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getOutfactTools", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),"取得要出厂的刀具信息" );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "getOutfactTools", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "getOutfactTools", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    @Override
    public String submitOutFackterTools(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 提交出厂刀具信息
            C01S019Respons ret = c01S019Business.submitOutFackterTools ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "submitOutFackterTools", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), "提交出厂刀具信息" );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "submitOutFackterTools", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "submitOutFackterTools", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 取得合成刀具信息
     */
    public String getToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 取得合成刀具信息
            C01S019Respons ret = (C01S019Respons) c01S019Business.getToolInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0034, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "getToolInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "getToolInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 对刀结束
     */
    public String saveToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S019Request) obj;
            // 对刀结束
            C01S019Respons ret = (C01S019Respons) c01S019Business.saveToolInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "saveToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.WMSG0312_3, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S019WsdlImpl", "saveToolInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S019WsdlImpl", "saveToolInfo", regSwitch.getCustomerID () );
            C01S019Respons ret = new C01S019Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }
}
