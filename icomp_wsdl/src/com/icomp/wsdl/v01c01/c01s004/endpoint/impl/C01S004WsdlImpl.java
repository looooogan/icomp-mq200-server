package com.icomp.wsdl.v01c01.c01s004.endpoint.impl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s004.business.C01S004Business;
import com.icomp.wsdl.v01c01.c01s004.business.impl.C01S004BusinessImpl;
import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Request;
import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Respons;
import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Wsdl;

/**
 * 补领出库Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S004WsdlImpl
 * @date 2016-3-8 下午01:28:18
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Wsdl")
public class C01S004WsdlImpl extends BaseWsdl implements C01S004Wsdl {
    /**
     * 刀具申领Business接口
     */
    private C01S004Business c01S004Business;
    private C01S004Request regSwitch;

    public void setC01S004Business(C01S004BusinessImpl c01S004Business) {
        this.c01S004Business = c01S004Business;
    }

    /**
     * 生成申领单号
     */
    public String getApplyNumber(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 生成申领单号
            C01S004Respons ret = (C01S004Respons) c01S004Business.getApplyNumber(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getApplyNumber", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0024, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "getApplyNumber", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "getApplyNumber", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得待申领刀具信息
     */
    public String getApplyToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 取得待申领刀具信息
            C01S004Respons ret = (C01S004Respons) c01S004Business.getApplyToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getApplyToolInfo", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0020, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "getApplyToolInfo", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "getApplyToolInfo", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 申领结束，记录申请单
     */
    public String saveApplyInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 申领结束，记录申请单
            C01S004Respons ret = (C01S004Respons) c01S004Business.saveApplyInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveApplyInfo", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0025, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "saveApplyInfo", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "saveApplyInfo", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 备货刀具出库
     */
    public String saveOutputStockingTool(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 备货刀具出库
            C01S004Respons ret = (C01S004Respons) c01S004Business.saveOutputStockingTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveOutputStockingTool", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0026, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "saveOutputStockingTool", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "saveOutputStockingTool", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 更新备货刀具状态
     */
    public String saveStockingToolStauts(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 更新备货刀具状态
            C01S004Respons ret = (C01S004Respons) c01S004Business.saveStockingToolStauts(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveStockingToolStauts", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0027, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "saveStockingToolStauts", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "saveStockingToolStauts", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 扫描rfid，取得当前rfid对应的信息
     */
    public String getRfidToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 备货刀具出库
            C01S004Respons ret = (C01S004Respons) c01S004Business.getRfidToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRfidToolInfo", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0021, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "getRfidToolInfo", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "getRfidToolInfo", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得补领出库申请列表
     */
    @Override
    public String getReplacementList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 备货刀具出库
            C01S004Respons ret = (C01S004Respons) c01S004Business.getReplacementList(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getReplacementList", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0021, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "getReplacementList", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "getReplacementList", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得补领出库申请列表
     */
    @Override
    public String getReplacementApply(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 备货刀具出库
            C01S004Respons ret = (C01S004Respons) c01S004Business.getReplacementApply(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getReplacementApply", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0021, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "getReplacementApply", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "getReplacementApply", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得要补领出库的刀具信息
     */
    @Override
    public String getReplacementTool(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 备货刀具出库
            C01S004Respons ret = (C01S004Respons) c01S004Business.getReplacementTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getReplacementTool", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0021, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "getReplacementTool", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "getReplacementTool", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 提交补领出库的刀具信息
     */
    @Override
    public String saveReplacementTool(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S004Request) obj;
            // 备货刀具出库
            C01S004Respons ret = (C01S004Respons) c01S004Business.saveReplacementTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveReplacementTool", IConstant.SYSTEM_LOG_FLAG_0
                    , IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
                    MessageReSource.getMessageBox(IConstant.CIMSG0021, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S004WsdlImpl", "saveReplacementTool", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S004WsdlImpl", "saveReplacementTool", regSwitch.getCustomerID());
            C01S004Respons ret = new C01S004Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(
                    org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

}
