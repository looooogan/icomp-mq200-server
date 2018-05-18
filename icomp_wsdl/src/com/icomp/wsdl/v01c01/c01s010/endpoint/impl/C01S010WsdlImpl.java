package com.icomp.wsdl.v01c01.c01s010.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s010.business.C01S010Business;
import com.icomp.wsdl.v01c01.c01s010.business.impl.C01S010BusinessImpl;
import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Request;
import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Respons;
import com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Wsdl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

/**
 * 刀具换装-Webservce实现类
 *
 * @author Taoyy
 * @ClassName: C01S010WsdlImpl
 * @date 2016-2-26 上午11:51:50
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s010.endpoint.C01S010Wsdl")
public class C01S010WsdlImpl extends BaseWsdl implements C01S010Wsdl {
    /**
     * 刀具换装-Business接口
     */
    private C01S010Business c01S010Business;

    public void setC01S010Business(C01S010BusinessImpl c01S010Business) {
        this.c01S010Business = c01S010Business;
    }

    /**
     * 取得合成刀组成信息
     */
    public String getSynthesisTool(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.getSynthesisTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getSynthesisTool", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "getSynthesisTool", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "getSynthesisTool", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得单品刀具信息
     */
    @Override
    public String getSingleTool(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.getSingleTool(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getSingleTool", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "getSingleTool", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "getSingleTool", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 提交热套换装完成信息
     */
    @Override
    public String saveHotChangeInfo(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = c01S010Business.saveHotChangeInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveHotChangeInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "saveHotChangeInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "saveHotChangeInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 提交合成刀具报废信息
     */
    @Override
    public String saveToolScrapInfo(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.saveToolScrapInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveToolScrapInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "saveToolScrapInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "saveToolScrapInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 提交合成刀具报废信息
     */
    @Override
    public String saveGrindingBitInfo(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.saveGrindingBitInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveGrindingBitInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "saveGrindingBitInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "saveGrindingBitInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 提交可复磨刀片的信息
     */
    @Override
    public String savesGrindingToolInfo(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.savesGrindingToolInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "savesGrindingToolInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "savesGrindingToolInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "savesGrindingToolInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 刀具换装最后提交
     */
	@Override
	public String saveSubmit(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.saveSubmit(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveSubmit", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), "刀具换装最后提交");
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "saveSubmit", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "saveSubmit", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

	/**
	 * 查询刃磨容器的Rfid
	 */
	@Override
	public String searchByGrindingContainerRfid(String request)
			throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.searchByGrindingContainerRfid(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "searchByGrindingContainerRfid", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "searchByGrindingContainerRfid", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "searchByGrindingContainerRfid", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

	/**
	 * 查询报废容器的RFID
	 */
	@Override
	public String searchByScrapContainerRfid(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.searchByScrapContainerRfid(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "searchByScrapContainerRfid", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "searchByScrapContainerRfid", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "searchByScrapContainerRfid", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

	/**
	 * 查询盛放可刃磨钻头的刀盒的信息
	 */
	@Override
	public String searchGrindingBitInfo(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.searchGrindingBitInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "searchGrindingBitInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "searchGrindingBitInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "searchGrindingBitInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

/*===================================刀具卸下辅具=====================================Begin====taoyy=============2016年8月13日14:48:37================ */
	@Override
	public String getSynthesisToolByRfid(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息
            C01S010Respons ret = (C01S010Respons) c01S010Business.getSynthesisToolByRfid(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getSynthesisToolByRfid", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S010WsdlImpl", "getSynthesisToolByRfid", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "getSynthesisToolByRfid", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

		@Override
	public String saveLoadownMsg(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息saveLoadownMsg
            C01S010Respons ret = (C01S010Respons) c01S010Business.saveLoadownMsg(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveLoadownMsg", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "saveLoadownMsg", "searchGrindingBitInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "saveLoadownMsg", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}
/*===================================刀具卸下辅具=====================================End=====taoyy=============2016年8月13日14:48:37=============== */

/*===================================刀具安上辅具=====================================Begin====taoyy=============2016年8月13日14:48:37================ */

		@Override
	public String getSynthesisToolByupload(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息saveLoadownMsg
            C01S010Respons ret = (C01S010Respons) c01S010Business.getSynthesisToolByupload(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getSynthesisToolByupload", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "getSynthesisToolByupload", "getSynthesisToolByupload", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "getSynthesisToolByupload", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}


		@Override
	public String getSynthesisToolByCode(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息saveLoadownMsg
            C01S010Respons ret = (C01S010Respons) c01S010Business.getSynthesisToolByCode(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getSynthesisToolByCode", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "saveLoadownMsg", "getSynthesisToolByCode", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "getSynthesisToolByCode", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}


		@Override
	public String saveUploadingMsg(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息saveLoadownMsg
            C01S010Respons ret = (C01S010Respons) c01S010Business.saveUploadingMsg(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveUploadingMsg", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "saveUploadingMsg", "searchGrindingBitInfo", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "saveUploadingMsg", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

		@Override
	public String deleteRfidByToolID(String request) throws Exception {
		C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息saveLoadownMsg
            C01S010Respons ret = (C01S010Respons) c01S010Business.deleteRfidByToolID(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "deleteRfidByToolID", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "deleteRfidByToolID", "deleteRfidByToolID", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "deleteRfidByToolID", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

    @Override
    public String seachToolMsg(String request) throws Exception {
        C01S010Request regSwitch = null;
        try {
            // 反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S010Request) obj;
            // 取得刀具信息saveLoadownMsg
            C01S010Respons ret = (C01S010Respons) c01S010Business.seachToolMsg(regSwitch);
            byte[] tre = objectToBytes(ret);
            // 记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "seachToolMsg", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0034, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "deleteRfidByToolID", "seachToolMsg", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S010WsdlImpl", "seachToolMsg", regSwitch.getCustomerID());
            C01S010Respons ret = new C01S010Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }




/*===================================刀具安上辅具=====================================end=====taoyy=============2016年8月13日14:48:37=============== */
}
