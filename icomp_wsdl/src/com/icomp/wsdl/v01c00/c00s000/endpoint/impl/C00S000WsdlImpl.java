package com.icomp.wsdl.v01c00.c00s000.endpoint.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.dao.UserdetailDao;
import com.icomp.entity.base.Userdetail;
import com.icomp.wsdl.v01c00.c00s000.business.C00S000Business;
import com.icomp.wsdl.v01c00.c00s000.endpoint.C00S000Wsdl;
import com.icomp.wsdl.v01c00.c00s000.endpoint.HandRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.HandRespons;
import com.icomp.wsdl.v01c00.c00s000.endpoint.LocalRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.LocalRespons;
import com.icomp.wsdl.v01c00.c00s000.endpoint.MenuRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.MenuRespons;
import com.icomp.wsdl.v01c00.c00s000.endpoint.UserRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.UserRespons;

import javax.jws.WebParam;
import javax.jws.WebService;

import Decoder.BASE64Decoder;

import java.util.List;

@WebService(endpointInterface = "com.icomp.wsdl.v01c00.c00s000.endpoint.C00S000Wsdl")
public class C00S000WsdlImpl extends BaseWsdl implements C00S000Wsdl {

    private C00S000Business c00S000Business;
    private UserRequest regSwitch;



    public void setC00S000Business(C00S000Business c00s000Business) {
        this.c00S000Business = c00s000Business;
    }

    /**
     * 用户登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String userLogin(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (UserRequest) obj;
            UserRespons ret = c00S000Business.systemInit(regSwitch);
            //如果用户不存在直接返回
            if (ret.getCustomer() == null){
            	byte[] tre = objectToBytes(ret);
            	return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
            }
            //customerId
            List<Userdetail> userdetailList = c00S000Business.selectUserName(ret.getCustomer().getCustomerID());
            ret.setUserName(userdetailList.get(0).getUserName());
            byte[] tre = objectToBytes(ret);
            //记录登录日志
            //			CommonLogUtil.saveBrowsLog(ret.getLanguagetable().getLanguageCode(), this.getClass().getName(),"userLogin", IConstant.SYSTEM_LOG_FLAG_0
            //					,IConstant.SYSTEM_LOG_LEVEL_0, ret.getCustomer().getCustomerID(),
            //					MessageReSource.getMessageBox(IConstant.CIMSG0001,ret.getLanguagetable().getLanguageCode(), ret.getLanguagetable().getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C00S000WsdlImpl", "userLogin", regSwitch.getCustomerID());
            UserRespons ret = new UserRespons();
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C00S000WsdlImpl", "userLogin", regSwitch.getCustomerID());
            UserRespons ret = new UserRespons();
            ret.setStateMsg(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 用户授权
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String userGruant(String request) throws Exception {
        regSwitch = null;
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (UserRequest) obj;
            UserRespons ret = (UserRespons) c00S000Business.userGruant(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录登录日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "userGruant", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0002, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C00S000WsdlImpl", "userGruant", regSwitch.getCustomerID());
            UserRespons ret = new UserRespons();
            ret.setStateMsg(ex.getLocalMessage());
            ret.setMessageText(ex.getLocalMessage());
            ret.setStateCode(IConstant.STRING_1);
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C00S000WsdlImpl", "userGruant", regSwitch.getCustomerID());
            UserRespons ret = new UserRespons();
            ret.setStateMsg(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 用户信息取得
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String userInfo(String request) throws Exception {
        regSwitch = null;
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (UserRequest) obj;
            UserRespons ret = (UserRespons) c00S000Business.userInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录登录日志
            CommonLogUtil.saveBrowsLog(ret.getLanguagetable().getLanguageCode(), this.getClass().getName(), "userInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, ret.getCustomer().getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0003, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C00S000WsdlImpl", "userInfo", regSwitch.getCustomerID());
            UserRespons ret = new UserRespons();
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C00S000WsdlImpl", "userInfo", regSwitch.getCustomerID());
            UserRespons ret = new UserRespons();
            ret.setStateMsg(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 用户权限取得
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String getMenu(String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            MenuRequest regSwitch = (MenuRequest) obj;
            MenuRespons ret = (MenuRespons) c00S000Business.getMenu(regSwitch);
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C00S000WsdlImpl", "getMenu", regSwitch.getCustomerID());
            MenuRespons ret = new MenuRespons();
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C00S000WsdlImpl", "getMenu", regSwitch.getCustomerID());
            MenuRespons ret = new MenuRespons();
            ret.setStateMsg(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 取得系统默认语言
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String getSysLocal(@WebParam(name = "request") String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            LocalRequest regSwitch = (LocalRequest) obj;
            LocalRespons ret = (LocalRespons) c00S000Business.getSysLocal(regSwitch);
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C00S000WsdlImpl", "getSysLocal", regSwitch.getCustomerID());
            LocalRespons ret = new LocalRespons();
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C00S000WsdlImpl", "getSysLocal", regSwitch.getCustomerID());
            LocalRespons ret = new LocalRespons();
            ret.setStateMsg(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }

    /**
     * 判断当前手持机是否注册
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String getHandParam(@WebParam(name = "request") String request) throws Exception {
        try {
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            HandRequest regSwitch = (HandRequest) obj;
            HandRespons ret = (HandRespons) c00S000Business.getHandParam(regSwitch);
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C00S000WsdlImpl", "getHandParam", regSwitch.getCustomerID());
            HandRespons ret = new HandRespons();
            ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C00S000WsdlImpl", "getHandParam", regSwitch.getCustomerID());
            HandRespons ret = new HandRespons();
            ret.setStateMsg(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
    }
}