package com.icomp.wsdl.v01c01.c01s014.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s014.business.C01S014Business;
import com.icomp.wsdl.v01c01.c01s014.business.impl.C01S014BusinessImpl;
import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Request;
import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Respons;
import com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 刀具分拣-Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S014WsdlImpl
 * @date 2016-2-29 上午11:58:24
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s014.endpoint.C01S014Wsdl")
public class C01S014WsdlImpl extends BaseWsdl implements C01S014Wsdl {
    /**
     * 刀具修复通知单-Business接口
     */
    private C01S014Business c01S014Business;
    private C01S014Request regSwitch;

    public void setC01S014Business(C01S014BusinessImpl c01S014Business) {
        this.c01S014Business = c01S014Business;
    }

    /**
     * 取得分拣刀具的信息
     */
    public String getToolsSorting(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 取得分拣刀具的信息
            C01S014Respons ret = (C01S014Respons) c01S014Business.getToolsSorting(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolsSorting", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0055, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "getToolsSorting", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "getToolsSorting", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
    
    /**
     * 提交分拣刀具的信息
     */
    public String saveToolsSortingInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 提交分拣刀具的信息
            C01S014Respons ret = (C01S014Respons) c01S014Business.saveToolsSortingInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveToolsSortingInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0055, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "saveToolsSortingInfo", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "saveToolsSortingInfo", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * 修复通知单号生成
     */
    public String createRepairNoticeNumber(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 修复通知单号生成
            C01S014Respons ret = (C01S014Respons) c01S014Business.createRepairNoticeNumber(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "createRepairNoticeNumber", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0055, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "createRepairNoticeNumber", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "createRepairNoticeNumber", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 刃磨方式取得
     */
    public String getRepairWayList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 刃磨方式取得
            C01S014Respons ret = (C01S014Respons) c01S014Business.getRepairWayList(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRepairWayList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0056, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "getRepairWayList", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "getRepairWayList", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得扫描刀具信息
     */
    public String getToolInfo(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            //取得扫描刀具信息
            C01S014Respons ret = (C01S014Respons) c01S014Business.getToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0053, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "getToolInfo", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "getToolInfo", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 修复通知单发布
     */
    public String saveToolRepairNotice(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 修复通知单发布
            C01S014Respons ret = (C01S014Respons) c01S014Business.saveToolRepairNotice(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveToolRepairNotice", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0054, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "saveToolRepairNotice", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "saveToolRepairNotice", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得修磨处理(非单品)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String getRegrindingList(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 取得修磨处理(非单品)
            C01S014Respons ret = (C01S014Respons) c01S014Business.getRegrindingList(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getRegrindingList", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0054, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "getRegrindingList", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "getRegrindingList", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 保存修磨处理(非单品)
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String saveRegrinding(String request) throws Exception {
        try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S014Request) obj;
            // 保存修磨处理(非单品)
            C01S014Respons ret = (C01S014Respons) c01S014Business.saveRegrinding(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveRegrinding", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0054, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S014WsdlImpl", "saveRegrinding", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S014WsdlImpl", "saveRegrinding", regSwitch.getCustomerID());
            C01S014Respons ret = new C01S014Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
}
