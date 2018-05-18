package com.icomp.wsdl.v01c01.c01s011.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s011.business.C01S011Business;
import com.icomp.wsdl.v01c01.c01s011.business.impl.C01S011BusinessImpl;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Request;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Respons;
import com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Wsdl;

import java.net.ConnectException;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 安上设备
 *
 * @author
 * @ClassName: c11s001WsdlImpl
 * @date 2016-2-23
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s011.endpoint.C01S011Wsdl")
public class C01S011WsdlImpl extends BaseWsdl implements C01S011Wsdl {
    /**
     * 设备安上-Business接口
     */
    private C01S011Business c01S011Business;
    private C01S011Request regSwitch;

    public void setC01S011Business(C01S011BusinessImpl c01S011Business) {
        this.c01S011Business = c01S011Business;
    }

    /**
     * 取得合成刀信息和设备列表
     */
    public String getSyntheticInfoEquipmentList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S011Request) obj;
            // 取得合成刀信息和设备列表
            C01S011Respons ret = (C01S011Respons) c01S011Business.getSyntheticInfoEquipmentList(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getSyntheticInfoEquipmentList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0046, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S011WsdlImpl", "getSyntheticInfoEquipmentList", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S011WsdlImpl", "getSyntheticInfoEquipmentList", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 提交合成刀具安上设备信息
     */
    public String submitSyntheticInstallEquipmentInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S011Request) obj;
            // 提交合成刀具安上设备信息
            C01S011Respons ret = (C01S011Respons) c01S011Business.submitSyntheticInstallEquipmentInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "submitSyntheticInstallEquipmentInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0047, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S011WsdlImpl", "submitSyntheticInstallEquipmentInfo", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S011WsdlImpl", "submitSyntheticInstallEquipmentInfo", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /*******************************************************************************************************/
    /**
     * 取得设备信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S011Respons
     * @title getEquipmentToolInfo
     */
    public String getEquipmentInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S011Request) obj;
            // 取得合成刀具安装设备信息
            C01S011Respons ret = (C01S011Respons) c01S011Business.getEquipmentInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getEquipmentInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0046, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S011WsdlImpl", "getEquipmentInfo", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S011WsdlImpl", "getEquipmentInfo", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 合成刀具安上设备
     */
    public String saveToolInEquipment(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S011Request) obj;
            // 合成刀具安上设备
            C01S011Respons ret = (C01S011Respons) c01S011Business.saveToolInEquipment(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveToolInEquipment", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0047, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S011WsdlImpl", "saveToolInEquipment", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S011WsdlImpl", "saveToolInEquipment", regSwitch.getCustomerID());
            C01S011Respons ret = new C01S011Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
}
