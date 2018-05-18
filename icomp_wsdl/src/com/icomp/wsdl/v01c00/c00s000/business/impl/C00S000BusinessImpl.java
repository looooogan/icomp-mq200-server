package com.icomp.wsdl.v01c00.c00s000.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c00.s000.ICOMPV01C00S000Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.*;
import com.icomp.wsdl.v01c00.c00s000.business.C00S000Business;
import com.icomp.wsdl.v01c00.c00s000.endpoint.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class C00S000BusinessImpl implements C00S000Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C00S000Service iCOMPV01C00S000Service;

    public void setiCOMPV01C00S000Service(ICOMPV01C00S000Service iCOMPV01C00S000Service) {
        this.iCOMPV01C00S000Service = iCOMPV01C00S000Service;
    }

    /**
     * 系统初始化
     */
    public UserRespons systemInit(UserRequest request) throws BusinessException {
        UserRespons ret = new UserRespons();
        String loginType = request.getLoginType();
        //验证登录用户
        Customer customer = new Customer();

        //登录类型(0输入登陆，1扫卡登陆)
        if (IConstant.STRING_0.equals(loginType)) {
            //0输入登陆
            //输入登录
            customer.setUserName(request.getUserName());//用户名
            customer.setUserPass(Ctl.md5(request.getUserPass()));//密码
        } else {
            //1扫卡登陆
            try {
                Rfidcontainer entity = new Rfidcontainer();
                entity.setRfidCode(request.getEmployeeCard());
                entity.setDelFlag(IConstant.STRING_0);
                Rfidcontainer reVal = service.getRfidContainerByRfidCode(entity);
                if (reVal == null || (!IConstant.STRING_3.equals(reVal.getQueryType()))) {
                    ret.setStateCode(IConstant.STRING_1);
                    ret.setStateMsg("您扫描的卡号不存在");
                    ret.setMessageText("您扫描的卡号不存在");
                    return ret;
                } else {
                    customer.setRfidContainerID(reVal.getRfidContainerID());
                }
            } catch (Exception e) {
                ret.setStateCode(IConstant.STRING_1);
                ret.setStateMsg("您扫描的卡号不存在");
                ret.setMessageText("您扫描的卡号不存在");
                return ret;
            }
        }

        customer.setDelFlag(IConstant.DEL_FLAG_0);
        customer = iCOMPV01C00S000Service.login(customer);
        if (customer.isRetErrFlag()) {//查询失败
            ret.setStateCode(IConstant.STRING_1);
            ret.setStateMsg("您输入的用户名或密码错误");
            ret.setMessageText("您输入的用户名或密码错误");
            return ret;
        }
        ret.setCustomer(customer);
        //取得系统默认语言
        Languagetable entity = service.getSystemDefaultLanguage();
        if (entity.isRetErrFlag()) {//查询失败
            throw new BusinessException(entity.getMessageCode(), "01", "zh_CN");
        }
        ret.setLanguagetable(entity);
        //取得系统语言列表
        List<Languagetable> list = service.getSystemListLanguage();
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), entity.getLanguageCode(), entity.getLanguageValue());
        }
        ret.setListLanguagetable(list);
        ret.setStateCode(IConstant.STRING_0);

        return ret;
    }

    /**
     * 用户授权
     */
    public UserRespons userGruant(UserRequest request) throws BusinessException {
        UserRespons ret = new UserRespons();
        String employeeCard = null;
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        Rfidcontainer reVal = null;
        //员工卡授权
        if (request.getEmployeeCard() != null) {
            try {
                rfidcontainer.setRfidCode(request.getEmployeeCard());
                reVal = service.getRfidContainerByRfidCode(rfidcontainer);
            } catch (Exception ex) {
            }
            if (reVal == null || (!IConstant.STRING_3.equals(reVal.getQueryType()))) {
                //当前标签未
                throw new BusinessException(IConstant.WMSG0245_4, request.getLanguageCode(), request.getLanguageValue());
            }
            employeeCard = reVal.getRfidContainerID();
        }
        //验证登录用户
        Customer customer = new Customer();
        customer.setUserName(request.getUserName());
        customer.setUserPass(Ctl.md5(request.getUserPass()));
        customer.setRfidContainerID(employeeCard);
        customer.setDelFlag(IConstant.DEL_FLAG_0);
        customer = iCOMPV01C00S000Service.login(customer);
        if (customer.isRetErrFlag()) {//查询失败
            throw new BusinessException(customer.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        ret.setCustomer(customer);
        //验证用户授权权限
        Vgrantlist serachParam = new Vgrantlist();//设置权限列表查询条件
        serachParam.setPositionLanguageCode(request.getLanguageCode());
        serachParam.setPositionDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setSystemLanguageCode(request.getLanguageCode());
        serachParam.setSystemDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setCapabilityLanguageCode(request.getLanguageCode());
        serachParam.setCapabilityDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setAgencyLanguageCode(request.getLanguageCode());
        serachParam.setAgencyDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setDepartmentLanguageCode(request.getLanguageCode());
        serachParam.setDepartmentDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setBelongFlag(IConstant.BELONG_FLAG_9);
        if (request.getUserName() == null) {
            serachParam.setUserName(customer.getUserName());
        } else {
            serachParam.setUserName(request.getUserName());
        }
        serachParam.setCapabilityLevel(new BigDecimal(2));
        serachParam.setCapabilityCode(request.getActivityName());
        serachParam.setStaIndex(request.getStaIndex());
        serachParam.setRowCount(request.getRowCount());
        serachParam.setOrderString("CapabilityLevel ,CapabilityOrder"); //TODO  这个视图可能有问题
        List<Vgrantlist> vgrantlist = iCOMPV01C00S000Service.getUserGrant(serachParam);
        if (vgrantlist.size() == 1 && vgrantlist.get(0).isRetErrFlag()) {
            throw new BusinessException(vgrantlist.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        //取得用户真实姓名
        Userdetail entity = new Userdetail();
        entity.setCustomerID(customer.getCustomerID());
        entity = iCOMPV01C00S000Service.userdetail(entity);
        ret.setUserDetailName(entity.getUserName());
        ret.setStatus(IConstant.RESULT_CODE_0);
        ret.setStateCode(IConstant.DEL_FLAG_0);
        return ret;
    }

    /**
     * 用户信息取得
     */
    public UserRespons userInfo(UserRequest request) throws BusinessException {
        UserRespons ret = new UserRespons();
        //验证登录用户
        Customer customer = new Customer();
        customer.setUserName(request.getUserName());
        customer.setUserPass(Ctl.md5(request.getUserPass()));
        customer.setEmployeeCard(request.getEmployeeCard());
        customer.setDelFlag(IConstant.DEL_FLAG_0);
        customer = iCOMPV01C00S000Service.login(customer);
        if (customer.isRetErrFlag()) {//查询失败
            throw new BusinessException(customer.getMessageCode(), "01", "zh_CN");
        }
        ret.setCustomer(customer);
        return ret;
    }

    /**
     * 取得用户菜单
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    public MenuRespons getMenu(MenuRequest request) throws BusinessException {
        //加载登录用户权限
        Vgrantlist serachParam = new Vgrantlist();//设置权限列表查询条件
        serachParam.setPositionLanguageCode(request.getLanguageCode());
        serachParam.setPositionDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setSystemLanguageCode(request.getLanguageCode());
        serachParam.setSystemDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setCapabilityLanguageCode(request.getLanguageCode());
        serachParam.setCapabilityDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setAgencyLanguageCode(request.getLanguageCode());
        serachParam.setAgencyDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setDepartmentLanguageCode(request.getLanguageCode());
        serachParam.setDepartmentDelFlag(IConstant.DEL_FLAG_0);
        serachParam.setBelongFlag(IConstant.BELONG_FLAG_1);
        serachParam.setUserName(request.getUserName());
        serachParam.setCapabilityLevel(request.getCapabilityLevel());
        serachParam.setCapCapabilityID(request.getCapCapabilityID());
        serachParam.setStaIndex(request.getStaIndex());
        serachParam.setRowCount(request.getRowCount());
        serachParam.setOrderString("CapabilityLevel ,CapabilityOrder");
        List<Vgrantlist> vgrantlist = iCOMPV01C00S000Service.getUserGrant(serachParam);
        if (vgrantlist.size() == 1 && vgrantlist.get(0).isRetErrFlag()) {
            throw new BusinessException(vgrantlist.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        MenuRespons menuRespons = new MenuRespons();
        menuRespons.setTotal(iCOMPV01C00S000Service.getUserGrantCount(serachParam));
        menuRespons.setVgrantlist(vgrantlist);
        return menuRespons;

    }

    /**
     * 获取系统默认语言
     *
     * @return
     * @throws BusinessException
     */
    public LocalRespons getSysLocal(LocalRequest request) throws BusinessException {
        Languagetable entity = new Languagetable();
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        List<Languagetable> list = iCOMPV01C00S000Service.getSysLocal(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), "01", "zh_CN");
        }
        LocalRespons respons = new LocalRespons();
        respons.setLanguageCode(list.get(0).getLanguageCode());
        respons.setLanguageName(list.get(0).getLanguageName());
        respons.setLanguageValue(list.get(0).getLanguageValue());
        return respons;
    }

    /**
     * 判断当前手持机是否注册
     *
     * @param request
     * @return
     * @throws Exception
     */
    public HandRespons getHandParam(HandRequest request) throws BusinessException {
        Handset entity = new Handset();
        entity.setHandSetCode(request.getHandMacCode());
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity.setHandSetStauts(IConstant.HANDSET_STAUTS_1);
        entity.setIsRegistration(IConstant.ISREGISTRATION_0);
        Map<String, Object> ret = iCOMPV01C00S000Service.getHandParam(entity);
        if (ret.get("hand") != null) {
            throw new BusinessException(((Handset) ret.get("hand")).getMessageCode(), "01", "zh_CN");
        }
        HandRespons respons = new HandRespons();
        respons.setHandFlag(Boolean.valueOf(ret.get("handFlag").toString()));
        respons.setHandsetID(ret.get("handSetID").toString());
        respons.setLoginStauts(ret.get("loginStauts").toString());
        return respons;
    }

    /**
     * 根据customerId获取用户姓名
     *
     * @param customerId
     * @return
     * @throws BusinessException
     */
    @Override
    public List<Userdetail> selectUserName(String customerId) throws BusinessException {
        Userdetail userdetail1 = new Userdetail();
        //customerId
        userdetail1.setCustomerID(customerId);
        List<Userdetail> userdetailList = iCOMPV01C00S000Service.selectUserName(userdetail1);

        return userdetailList;
    }

}
