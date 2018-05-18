package com.icomp.wsdl.v01c01.c01s018.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s018.business.C01S018Business;
import com.icomp.wsdl.v01c01.c01s018.business.impl.C01S018BusinessImpl;
import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Request;
import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Respons;
import com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 刀具复磨安上-Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S018WsdlImpl
 * @date 2014-9-23 下午12:04:07
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s018.endpoint.C01S018Wsdl")
public class C01S018WsdlImpl extends BaseWsdl implements C01S018Wsdl {

    /**
     * 刀具复磨安上-Business接口
     */
    private C01S018Business c01S018Business;
    private C01S018Request regSwitch;

    public void setC01S018Business(C01S018BusinessImpl c01S018Business) {
        this.c01S018Business = c01S018Business;
    }

    
    
    /**
     * 取得修磨设备列表
     */
    public String getGrindingEqulist(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得修磨设备列表
            C01S018Respons ret = (C01S018Respons) c01S018Business.getGrindingEqulist(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getGrindingEqulist",
                    IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),
                    MessageReSource.getMessageBox(IConstant.CIMSG0053, null, null));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getGrindingEqulist", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getGrindingEqulist", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
    
    
    
    
    /**
     * 取得修磨刀具信息
     */
    public String getGrindingToolsInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得修磨刀具信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.getGrindingToolsInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getGrindingToolsInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getGrindingToolsInfo", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getGrindingToolsInfo", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
    
    
    /**
     * 提交刀具修磨设备信息
     */
    public String submitToolsGrindingEquInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 提交刀具修磨设备信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.submitToolsGrindingEquInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "submitToolsGrindingEquInfo",
                    IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID (),
                    MessageReSource.getMessageBox(IConstant.CIMSG0053, null,null));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "submitToolsGrindingEquInfo", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "submitToolsGrindingEquInfo", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * 取得扫描刀具的信息
     */
    public String getToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得扫描刀具的信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.getToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getToolInfo", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getToolInfo", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 复磨刀具安上
     */
    public String saveNoticeToolload(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 复磨刀具安上
            C01S018Respons ret = (C01S018Respons) c01S018Business.saveNoticeToolload(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveNoticeToolload", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0064, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "saveNoticeToolload", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "saveNoticeToolload", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 复磨报废
     */
    public String savetoolDelete(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 复磨刀具安上
            C01S018Respons ret = (C01S018Respons) c01S018Business.savetoolDelete(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "savetoolDelete", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0064, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "savetoolDelete", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "savetoolDelete", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得刀具长度和不可刃磨长度
     */
    public String getToolLength(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得测量刀具的信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.getToolLength(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolLength", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getToolLength", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getToolLength", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得报废盒子
     */
    public String getDiscardBox(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得测量刀具的信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.getDiscardBox(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getDiscardBox", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getDiscardBox", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getDiscardBox", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得盒子数量
     */
    public String getToolInfoCount(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得测量刀具的信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.getToolInfoCount(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolInfoCount", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getToolInfoCount", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getToolInfoCount", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 按刀具编码或物料号查询取得刃磨数量(非单品)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String getToolCodeAndKivCode(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 按刀具编码或物料号查询取得刃磨数量(非单品)
            C01S018Respons ret = (C01S018Respons) c01S018Business.getToolCodeAndKivCode(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolCodeAndKivCode", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getToolCodeAndKivCode", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getToolCodeAndKivCode", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得刃磨设备信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String getEquipmentByRfid(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 取得测量刀具的信息
            C01S018Respons ret = (C01S018Respons) c01S018Business.getEquipmentByRfid(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getEquipmentByRfid", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getEquipmentByRfid", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getEquipmentByRfid", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    @Override
    public String putScrapGrindingContainer(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 扫描待放刃磨完刀具的容器(报废)
            C01S018Respons ret = (C01S018Respons) c01S018Business.putScrapGrindingContainer(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "putScrapGrindingContainer", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "putScrapGrindingContainer", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "putScrapGrindingContainer", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    @Override
    public String putGrindingContainer(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            // 扫描待放刃磨完刀具的容器(无报废)
            C01S018Respons ret = (C01S018Respons) c01S018Business.putGrindingContainer(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "putGrindingContainer", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "putGrindingContainer", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "putGrindingContainer", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得所有刃磨刀具的设备列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String getPanGrindingEquipment(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S018Request) obj;
            //  取得所有刃磨刀具的设备列表
            C01S018Respons ret = (C01S018Respons) c01S018Business.getPanGrindingEquipment(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getPanGrindingEquipment", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S018WsdlImpl", "getPanGrindingEquipment", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S018WsdlImpl", "getPanGrindingEquipment", regSwitch.getCustomerID());
            C01S018Respons ret = new C01S018Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
}
