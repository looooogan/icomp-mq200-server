package com.icomp.wsdl.v01c01.c01s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s002.ICOMPV01C01S002Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.wsdl.v01c01.c01s002.business.C01S002Business;
import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Request;
import com.icomp.wsdl.v01c01.c01s002.endpoint.C01S002Respons;

import oracle.net.aso.MD5;

import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class C01S002BusinessImpl implements C01S002Business {

    public static final int ZERO = 0;
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S002Service iCOMPV01C01S002Service;

    public void setiCOMPV01C01S002Service(ICOMPV01C01S002Service iCOMPV01C01S002Service) {
        this.iCOMPV01C01S002Service = iCOMPV01C01S002Service;
    }
    
    /**
     * 授权
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S002Respons saveAuthorized(C01S002Request request) throws Exception {
        C01S002Respons respons = new C01S002Respons();
        Customer customerentity = new Customer();
        Rfidcontainer rfidcontainerentity = new Rfidcontainer();
        
        // 传入数据 存在性校验
        Map<String, Object> rtn = cuttingToolStorageCheck(request);
        if (Integer.parseInt(rtn.get("status").toString()) < 0) {
            respons.setStateCode(rtn.get("status").toString());
            respons.setStateMsg(rtn.get("messagetext").toString());
            return respons;
        } else{
        	// 授权类型(0:登陆;1:扫描)
        	if((IConstant.DEL_FLAG_0).equals(request.getAuthorizedType())){
            	// 用户名
            	customerentity.setUserName(request.getUserName());
            	// 密码
            	customerentity.setUserPass(Ctl.md5(request.getUserPass()));
            	customerentity.setDelFlag(IConstant.DEL_FLAG_0);
            	// 查询授权人ID
            	customerentity = iCOMPV01C01S002Service.searchAuID(request.getCustomerID(),customerentity);
            	if (customerentity.isRetErrFlag()) {
                    throw new BusinessException(customerentity.getMessageCode(), IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
                }else{

                	Map<String, Object> ret = iCOMPV01C01S002Service.saveAuthorized(request.getCustomerID(),request.getAuthorizedReason(),
                			request.getToolID(),request.getBusinessID(),customerentity);
                	if (Integer.parseInt(ret.get("status").toString()) < 0) {
                        throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
                    }
                    respons.setAuthorizedUsersID(customerentity.getCustomerID());
//                    respons.setStateCode(ret.get("status").toString());
//                    respons.setStateMsg(ret.get("messagetext").toString());
//                    return respons;
                }
        	} else if((IConstant.DEL_FLAG_1).equals(request.getAuthorizedType())){
        		// RFID（员工卡）
        		rfidcontainerentity.setRfidCode(request.getRfidCode());
        		//标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
        		rfidcontainerentity.setQueryType(IConstant.USER_BLOOD_GROUP_3);
        		rfidcontainerentity.setDelFlag(IConstant.DEL_FLAG_0);
        		rfidcontainerentity = iCOMPV01C01S002Service.searchRfid(rfidcontainerentity);
        		if (rfidcontainerentity.isRetErrFlag()) {
                    throw new BusinessException(rfidcontainerentity.getMessageCode(), IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
                }else{
                	//RFID载体ID
                	customerentity.setRfidContainerID(rfidcontainerentity.getRfidContainerID());
                	//查询授权人ID
                	customerentity = iCOMPV01C01S002Service.searchAuID(request.getCustomerID(),customerentity);
                	if (customerentity.isRetErrFlag()) {
                        throw new BusinessException(customerentity.getMessageCode(), IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
                    }else{
                    	Map<String, Object> ret = iCOMPV01C01S002Service.saveAuthorized(request.getCustomerID(),request.getAuthorizedReason(),
                    			request.getToolID(),request.getBusinessID(),customerentity);
                    	if (Integer.parseInt(ret.get("status").toString()) < 0) {
                            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
                        }

                    	// 授权人ID
                    	respons.setAuthorizedUsersID(customerentity.getCustomerID());
                        respons.setStateCode(IConstant.DEL_FLAG_0);
                        respons.setStateMsg("提交成功");
                        return respons;
                    }
                }
        	}        	
        }
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("提交成功");
		return respons;           
    }

    /**
     * 传入数据 存在性校验
     *
     * @param request
     * @return
     * @throws Exception
     */
    private Map<String, Object> cuttingToolStorageCheck(C01S002Request request) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        Map<String, Object> msgMap = new HashMap<String, Object>();
//        if (StringUtils.isEmpty(request.getCustomerID())) {
//            msgMap.put("MessageCode", "未传入用户ID");// 未传入用户ID
//        }
//        if (StringUtils.isEmpty(request.getAuthorizedReason())) {
//            msgMap.put("MessageCode", "未传入授权原因");// 未传入授权原因
//        }
//        if (StringUtils.isEmpty(request.getToolID())) {
//            msgMap.put("MessageCode", "未传入刀具ID");// 未传入刀具ID
//        }
//        if (StringUtils.isEmpty(request.getBusinessID())) {
//            msgMap.put("MessageCode", "未传入流程ID");// 未传入流程ID
//        }
//        if (StringUtils.isEmpty(request.getAuthorizedType())) {
//            msgMap.put("MessageCode", "未传入授权类型");// 未传入授权类型(0:登陆;1:扫描)
//        }
        if (StringUtils.isEmpty(request.getUserName()) || StringUtils.isEmpty(request.getUserPass())) {
            msgMap.put("MessageCode", "未传入用户名或密码");// 未传入 用户名或密码
        }
//        if((IConstant.DEL_FLAG_0).equals(request.getAuthorizedType())){
//        	if (StringUtils.isEmpty(request.getUserName()) || StringUtils.isEmpty(request.getUserPass())) {
//                msgMap.put("MessageCode", "未传入用户名或密码");// 未传入 用户名或密码
//            }
//        }
//        else if((IConstant.DEL_FLAG_1).equals(request.getAuthorizedType())){
//        	if (StringUtils.isEmpty(request.getRfidCode())) {
//                msgMap.put("MessageCode", "未传入RFID（员工卡）");// 未传入 RFID（员工卡）
//            }
//        }
        
              
        if (msgMap.size() > 0) {
            rtn.put("status", IConstant.RESULT_CODE_2);
            rtn.put("messagetext", msgMap);
        } else {
            rtn.put("status", IConstant.RESULT_CODE_0);
        }
        return rtn;
    }


}
