package com.icomp.wsdl.v01c01.c01s003.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.pojo.BaseRespons;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Request;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Respons;
import com.icomp.wsdl.v01c01.c01s003.business.C01S003Business;
import com.icomp.wsdl.v01c01.c01s003.business.impl.C01S003BusinessImpl;
import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Request;
import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Respons;
import com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Wsdl;

import java.net.ConnectException;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 刀具换领-Websevice实现类
 *
 * @author Taoyy
 * @ClassName: C01S003WsdlImpl
 * @date 2016-3-4 下午01:24:56
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s003.endpoint.C01S003Wsdl")
public class C01S003WsdlImpl extends BaseWsdl implements C01S003Wsdl {

    private C01S003Business c01S003Business;

    public void setC01S003Business(C01S003BusinessImpl c01S003Business) {
        this.c01S003Business = c01S003Business;
    }

    C01S003Request regSwitch;

    /**
     * 取得换领申请单明细
     */
    public String getRedemptionDetail(String request) throws Exception {
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            // 取得换领申请单明细
            C01S003Respons ret = (C01S003Respons) c01S003Business.getRedemptionDetail(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRfidType", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0012, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getRedemptionDetail", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getRedemptionDetail", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得换领申请单
     */
    public String getRedemptionInfo(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            // 取得换领申请单
            C01S003Respons ret = (C01S003Respons) c01S003Business.getRedemptionInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRedemptionInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0013, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getRedemptionInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getRedemptionInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得待换领刀具信息
     */
    public String getRedemptionToolInfo(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            // 取得待换领刀具信息
            C01S003Respons ret = (C01S003Respons) c01S003Business.getRedemptionToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRedemptionToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0014, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getRedemptionToolInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getRedemptionToolInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 备货刀具出库
     */
    public String saveOutputStockingTool(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            // 备货刀具出库
            C01S003Respons ret = (C01S003Respons) c01S003Business.saveOutputStockingTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveOutputStockingTool", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0015, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "saveOutputStockingTool", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "saveOutputStockingTool", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 换领结束，更新申请单
     */
    public String saveRedemptionInfo(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            // 换领结束，更新申请单
            C01S003Respons ret = (C01S003Respons) c01S003Business.saveRedemptionInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveRedemptionInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0016, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "saveRedemptionInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "saveRedemptionInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 更新备货刀具状态
     */
    public String saveStockingToolStauts(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.saveStockingToolStauts(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveStockingToolStauts", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0017, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "saveStockingToolStauts", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "saveStockingToolStauts", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 查询单品刀具信息
     */
    public String seachToolInfo(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.seachToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "seachToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "seachToolInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "seachToolInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 验证是否存在专机领用数据
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title existLedplane
     */
    public String existLedplane(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.existLedplane(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "existLedplane", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "existLedplane", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "existLedplane", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得区分值列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        String
     * @title getComlist
     */
    public String getComlist(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getComlist(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getComlist", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getComlist", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getComlist", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得扫描标签的绑定刀具数量及刀具编码
     *
     * @param request
     * @return
     * @throws Exception String
     * @title getToolInfo
     */
    public String getToolInfo(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getToolInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getToolInfo", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 保存专机领用数据
     *
     * @param request
     * @return
     * @throws Exception String
     * @title saveLedplane
     */
    public String saveLedplane(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.saveLedplane(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveLedplane", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "saveLedplane", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "saveLedplane", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得换领申请单列表按照人名和日期进行排序并显示在list中
     *
     * @param request
     * @return
     * @throws Exception String
     * @title getRequestList
     */
    public String getRequestList(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getRequestList(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRequestList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getRequestList", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getRequestList", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得用户选择的申请人、申请时间对应的备货信息
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S003Respons
     * @title getChoiceList
     */
    public String getChoiceList(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getChoiceList(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getChoiceList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getChoiceList", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getChoiceList", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得前页面传递的用户选择的申请单归还清单
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception        C01S003Respons
     * @title getRemand
     */
    public String getRemand(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getRemand(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRemand", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getRemand", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getRemand", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 备货信息提交
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String stockMsgSubmit(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.stockMsgSubmit(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "stockMsgSubmit", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "stockMsgSubmit", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "stockMsgSubmit", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 领刀授权提交
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String saveGetChangeTool(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.saveGetChangeTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveGetChangeTool", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "saveGetChangeTool", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "saveGetChangeTool", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得已备货的刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String getReadiedToolsMessage(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getReadiedToolsMessage(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getReadiedToolsMessage", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getReadiedToolsMessage", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getReadiedToolsMessage", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 刀具送回信息提交
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String reToolSubmit(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.reToolSubmit(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "reToolSubmit", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "reToolSubmit", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "reToolSubmit", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 非单品-获取换领申请列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    @Override
    public String getApplyUser(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getApplyUser(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getApplyUser", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getApplyUser", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getApplyUser", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 非单品-获取换领申请列表
     *
     * @param request
     * @return
     * @throws ConnectException
     * @throws Exception
     */
    @Override
    public String getRedemptionappliedListCodeByUserid(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            C01S003Respons ret = (C01S003Respons) c01S003Business.getRedemptionappliedListCodeByUserid(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRedemptionappliedListCodeByUserid", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0018, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "getRedemptionappliedListCodeByUserid", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "getRedemptionappliedListCodeByUserid", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 保存换领出库信息-非单品
     */
    public String saveRedemptionApplied(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S003Request) obj;
            // 换领结束，更新申请单
            C01S003Respons ret = (C01S003Respons) c01S003Business.saveRedemptionApplied(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveRedemptionApplied", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0016, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S003WsdlImpl", "saveRedemptionApplied", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S003WsdlImpl", "saveRedemptionApplied", regSwitch.getCustomerID());
            C01S003Respons ret = new C01S003Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
    
    /**
	 * 根据物料号查找刀具库存-非单
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getRfidTypeFD(String request) throws Exception {
		try {
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S003Request) obj;
			C01S003Respons ret = (C01S003Respons) c01S003Business
			.getToolInfoFD(regSwitch);
			 byte[] tre = objectToBytes(ret);
			// 记录取得刀具基本信息日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this
					.getClass().getName(), "getRfidTypeFD",
					IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0,
					regSwitch.getCustomerID(), MessageReSource.getMessageBox(
							IConstant.CIMSG0006, regSwitch.getLanguageCode(),
							regSwitch.getLanguageValue()));
			return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(ex, "C01S001WsdlImpl",
					"getRfidTypeFD", regSwitch.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		} catch (Exception ex) {
			ApplicationException
			.setApplicationException(ex.getMessage(),
					"C01S001WsdlImpl", "getRfidTypeFD", regSwitch
					.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		}
	}

	/**
	 * 取得换领申请人申请信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getApplyInfo(String request) throws Exception {
		try {
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S003Request) obj;
			C01S003Respons ret = (C01S003Respons) c01S003Business
			.getApplyInfo(regSwitch);
			 byte[] tre = objectToBytes(ret);
			// 记录取得刀具基本信息日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this
					.getClass().getName(), "getApplyInfo",
					IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0,
					regSwitch.getCustomerID(), MessageReSource.getMessageBox(
							IConstant.CIMSG0006, regSwitch.getLanguageCode(),
							regSwitch.getLanguageValue()));
			return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(ex, "C01S003WsdlImpl",
					"getApplyInfo", regSwitch.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		} catch (Exception ex) {
			ApplicationException
			.setApplicationException(ex.getMessage(),
					"C01S003WsdlImpl", "getApplyInfo", regSwitch
					.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		}
	}

	/**
	 * 取得要换领出库的刀具信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public String getRedemptionapplyInfo(String request) throws Exception {
		try {
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S003Request) obj;
			C01S003Respons ret = (C01S003Respons) c01S003Business
			.getRedemptionapplyInfo(regSwitch);
			 byte[] tre = objectToBytes(ret);
			// 记录取得刀具基本信息日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this
					.getClass().getName(), "getRedemptionapplyInfo",
					IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0,
					regSwitch.getCustomerID(), MessageReSource.getMessageBox(
							IConstant.CIMSG0006, regSwitch.getLanguageCode(),
							regSwitch.getLanguageValue()));
			return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(ex, "C01S003WsdlImpl",
					"getRedemptionapplyInfo", regSwitch.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		} catch (Exception ex) {
			ApplicationException
			.setApplicationException(ex.getMessage(),
					"C01S003WsdlImpl", "getRedemptionapplyInfo", regSwitch
					.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		}
	}

	/**
	 * 提交换领出库的刀具信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public String saveRedemptionapplyInfo(String request) throws Exception {
		try {
			byte[] buf = new BASE64Decoder().decodeBuffer(request);
			Object obj = bytesToObject(buf);
			regSwitch = (C01S003Request) obj;
			C01S003Respons ret = (C01S003Respons) c01S003Business
			.saveRedemptionapplyInfo(regSwitch);
			 byte[] tre = objectToBytes(ret);
			// 记录取得刀具基本信息日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this
					.getClass().getName(), "saveRedemptionapplyInfo",
					IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0,
					regSwitch.getCustomerID(), MessageReSource.getMessageBox(
							IConstant.CIMSG0006, regSwitch.getLanguageCode(),
							regSwitch.getLanguageValue()));
			return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(ex, "C01S003WsdlImpl",
					"saveRedemptionapplyInfo", regSwitch.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		} catch (Exception ex) {
			ApplicationException
			.setApplicationException(ex.getMessage(),
					"C01S003WsdlImpl", "saveRedemptionapplyInfo", regSwitch
					.getCustomerID());
			C01S003Respons ret = new C01S003Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(tre));
		}
	}
}
