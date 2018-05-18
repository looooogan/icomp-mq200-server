package com.icomp.wsdl.v01c02.c02s006.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c02.s006.ICOMPV01C02S006Service;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Handset;
import com.icomp.wsdl.v01c02.c02s006.business.C02S006Business;
import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Request;
import com.icomp.wsdl.v01c02.c02s006.endpoint.C02S006Respons;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class C02S006BusinessImpl implements C02S006Business {

    @SuppressWarnings("unused")
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C02S006Service iCOMPV01C02S006Service;

    public void setiCOMPV01C02S006Service(ICOMPV01C02S006Service iCOMPV01C02S006Service) {
        this.iCOMPV01C02S006Service = iCOMPV01C02S006Service;
    }

    /**
     * 取得部门列表及已注册部门信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C02S006Respons getDepatement(C02S006Request request) throws Exception {
        C02S006Respons respons = new C02S006Respons();
        //取得部门列表
        Department depatement = new Department();
        depatement.setDelFlag(IConstant.DEL_FLAG_0);
        depatement.setLanguageCode(request.getLanguageCode());
        List<Department> list = iCOMPV01C02S006Service.getDepatement(depatement);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setList(list);
        //取得已注册部门信息
        Handset handset = new Handset();
        handset.setHandSetCode(request.getHandMacCode());
        List<Handset> handsets = iCOMPV01C02S006Service.getHandsets(handset);
        if (list.size() == 0) {
            respons.setDepartmentID(null);
        } else if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        } else {
            if (handsets.size() > 0) {
                respons.setDepartmentID(handsets.get(0).getDepartmentID());
                Department depatement1 = new Department();
                depatement1.setDelFlag(IConstant.DEL_FLAG_0);
                depatement1.setLanguageCode(request.getLanguageCode());
                depatement1.setDepartmentID(handsets.get(0).getDepartmentID());
                List<Department> list1 = iCOMPV01C02S006Service.getDepatement(depatement1);
                respons.setDepartmentName(list1.get(0).getDepartmentName());
            }

        }
        return respons;
    }

    /**
     * 手持机注册
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C02S006Respons saveHand(C02S006Request request) throws Exception {
        C02S006Respons respons = new C02S006Respons();
        Handset handset = new Handset();
        handset.setDepartmentID(request.getDepartmentID());
        handset.setHandSetCode(request.getHandMacCode());
        handset.setIsRegistration(IConstant.ISREGISTRATION_0);
        handset.setLoginStauts(IConstant.LOGINSTAUTS_1);
        handset.setDelFlag(IConstant.DEL_FLAG_0);
        handset.setUpdateTime(new Date());
        handset.setCreateTime(new Date());
        handset.setCreateUser(request.getCustomerID() == null ? "system" : request.getCustomerID());
        handset.setUpdateUser(request.getCustomerID() == null ? "system" : request.getCustomerID());
        Map<String, Object> ret = iCOMPV01C02S006Service.saveHand(handset);
        if (ret.size() > 1 && Integer.parseInt(ret.get("status").toString()) < 0) {
            throw new BusinessException(ret.get("MessageCode").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(Integer.parseInt(ret.get("status").toString()));
        if (ret.get("MessageCode") != null) {
            respons.setMessageText(ret.get("MessageCode").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }
}
