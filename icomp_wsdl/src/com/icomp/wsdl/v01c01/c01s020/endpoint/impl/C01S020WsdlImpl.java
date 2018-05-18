package com.icomp.wsdl.v01c01.c01s020.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s020.business.C01S020Business;
import com.icomp.wsdl.v01c01.c01s020.business.impl.C01S020BusinessImpl;
import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Request;
import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Respons;
import com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 回厂识别-Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S020WsdlImpl
 * @date 2014-9-23 下午12:06:46
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s020.endpoint.C01S020Wsdl")
public class C01S020WsdlImpl extends BaseWsdl implements C01S020Wsdl {
    /**
     * 回厂识别-Business接口
     */
    private C01S020Business c01S020Business;

    public void setC01S020Business(C01S020BusinessImpl c01S020Business) {
        this.c01S020Business = c01S020Business;
    }

    private C01S020Request regSwitch;

    /**
     * 取得出厂单号列表
     */
    public String getNotificationList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂单号列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.getNotificationList ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getNotificationList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0066, null, null ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "getNotificationList", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "getNotificationList", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 取得通知单号信息
     */
    public String getNotificationListInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂单号列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.getNotificationListInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getNotificationListInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0066, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "getNotificationListInfo", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "getNotificationListInfo", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 取得盛放入库刀具的空盒信息
     */
    public String getEmptyBoxInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂单号列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.getEmptyBoxInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getEmptyBoxInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0066, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "getEmptyBoxInfo", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "getEmptyBoxInfo", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 提交回厂入库刀片信息
     */
    public String submitBackFactoryToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂单号列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.submitBackFactoryToolInfo ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "submitBackFactoryToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0066, null, null ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "submitBackFactoryToolInfo", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "submitBackFactoryToolInfo", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 提交钻头激光码
     */
    public String submitBitLaserCode(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂单号列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.submitBitLaserCode ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "submitBitLaserCode", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0066, null, null ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "submitBitLaserCode", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "submitBitLaserCode", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }
    /*************************************************************************************************/

    /**
     * 取得出厂单号列表
     */
    public String getFactoryNoList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂单号列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.getFactoryNoList ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getFactoryNoList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0066, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "getFactoryNoList", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "getFactoryNoList", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 取得出厂刀具列表
     */
    public String getFactoryToolList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 取得出厂刀具列表
            C01S020Respons ret = (C01S020Respons) c01S020Business.getFactoryToolList ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getFactoryToolList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0067, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "getFactoryToolList", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "getFactoryToolList", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 回厂刀片绑定
     */
    public String saveFactoryBlade(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 回厂刀片绑定
            C01S020Respons ret = (C01S020Respons) c01S020Business.saveFactoryBlade ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "saveFactoryBlade", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0068, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "saveFactoryBlade", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "saveFactoryBlade", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 回厂钻头绑定
     */
    public String saveFactoryBoringCrown(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 回厂钻头绑定
            C01S020Respons ret = (C01S020Respons) c01S020Business.saveFactoryBoringCrown ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "saveFactoryBoringCrown", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0069, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "saveFactoryBoringCrown", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "saveFactoryBoringCrown", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 回厂钻头绑定
     */
    public String checkRfid(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            // 回厂钻头绑定
            C01S020Respons ret = (C01S020Respons) c01S020Business.checkRfid ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "checkRfid", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), MessageReSource.getMessageBox ( IConstant.CIMSG0070, regSwitch.getLanguageCode (), regSwitch.getLanguageValue () ) );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "checkRfid", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "checkRfid", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

    /**
     * 扫描rfid（只能是空标签
     */
    public String getRFIDnullCode(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            //扫描rfid（只能是空标签
            C01S020Respons ret = (C01S020Respons) c01S020Business.getRFIDnullCode ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "getRFIDnullCode", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), "扫描rfid（只能是空标签" );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "getRFIDnullCode", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "getRFIDnullCode", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }
    /**
     *提交扫描信息并初始化
     */
    public String submitOutFactInData(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder ().decodeBuffer ( request );
            Object obj = bytesToObject ( buf );
            regSwitch = (C01S020Request) obj;
            //提交扫描信息并初始化
            C01S020Respons ret = (C01S020Respons) c01S020Business.submitOutFactInData ( regSwitch );
            byte[] tre = objectToBytes ( ret );
            //记录查询日志
            CommonLogUtil.saveBrowsLog ( regSwitch.getLanguageCode (), this.getClass ().getName (), "submitOutFactInData", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (), "提交扫描信息并初始化" );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( ex, "C01S020WsdlImpl", "submitOutFactInData", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getLocalMessage () );
            ret.setStateMsg ( ex.getLocalMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        } catch (Exception ex) {
            ApplicationException.setApplicationException ( ex.getMessage (), "C01S020WsdlImpl", "submitOutFactInData", regSwitch.getCustomerID () );
            C01S020Respons ret = new C01S020Respons ();
            ret.setMessageText ( ex.getMessage () );
            byte[] tre = objectToBytes ( ret );
            return new String ( org.apache.commons.codec.binary.Base64.encodeBase64 ( tre ) );
        }
    }

}
