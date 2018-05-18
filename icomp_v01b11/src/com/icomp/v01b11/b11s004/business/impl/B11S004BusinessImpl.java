package com.icomp.v01b11.b11s004.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b11.s004.ICOMPV01B11S004Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.UserdetailDao;
import com.icomp.entity.base.*;
import com.icomp.v01b11.b11s004.business.B11S004Business;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B11S004BusinessImpl implements B11S004Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01B11S004Service iCOMPV01B11S004Service;

    public void setiCOMPV01B11S004Service(ICOMPV01B11S004Service iCOMPV01B11S004Service) {
        this.iCOMPV01B11S004Service = iCOMPV01B11S004Service;
    }

    /**
     * 用户详细信息Dao
     */
    @SuppressWarnings("unused")
    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    /**
     * 取得系统区分列表
     *
     * @param flagType 区分定义名称
     * @return
     * @throws BusinessException
     */
    public List<Comlist> getComList(String flagType, String langCode, String langValue) throws BusinessException {
        Comlist entity = new Comlist ();
        entity.setComListType ( flagType );
        entity.setLanguageCode ( langCode );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Comlist> list = service.getComList ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    /**
     * 取得用户信息列表
     *
     * @param param 页面检索条件
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        //设置检索条件
        Vcustomer entity = new Vcustomer ();
        entity.setAgencyID ( StringUtils.isEmpty ( param.get ( "AgencyID" ).toString () ) ? null : param.get ( "AgencyID" ).toString () );
        entity.setDepartmentID ( StringUtils.isEmpty ( param.get ( "DepartmentID" ).toString () ) ? null : param.get ( "DepartmentID" ).toString () );
        entity.setPositionID ( StringUtils.isEmpty ( param.get ( "PositionID" ).toString () ) ? null : param.get ( "PositionID" ).toString () );
        entity.setUserType ( StringUtils.isEmpty ( param.get ( "UserType" ).toString () ) ? null : param.get ( "UserType" ).toString () );
        entity.setUserName(StringUtils.isEmpty(param.get("UserName").toString())?null:param.get("UserName").toString());
        entity.setCustomerDelFlag ( IConstant.DEL_FLAG_0 );
        String userCar = param.get ( "UserName" ) + "";
        userCar = userCar.trim ();
        entity.setEmployeeCard ( StringUtils.isEmpty ( userCar ) ? null : userCar );
        //分页起始行数
        entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
        //分页页数
        entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
        // 排序
        entity.setOrderString ( "AgencyID,DepartmentID,PositionID,UserName" );
        Map<String, Object> rtn = iCOMPV01B11S004Service.getList ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            //检索错误时，返回
            throw new BusinessException ( ((List<Vcustomer>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
    }

    /**
     * 取得部门信息列表
     *
     * @return
     * @throws BusinessException
     */
    public List<Vagency> getAgencyList(String delFlag, String langCode, String langValue) throws BusinessException {
        Vagency entity = new Vagency ();
        entity.setDelFlag ( delFlag );
        entity.setAgencyLanguageCode ( langCode );
        List<Vagency> list = service.getVagency ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;

    }

    /**
     * 取得部门信息列表
     *
     * @return
     * @throws BusinessException
     */
    public List<Vdepartment> getDepartmentList(String agencyID, String delFlag, String langCode, String langValue) throws BusinessException {
        Vdepartment entity = new Vdepartment ();
        entity.setDepartmentAgencyID ( agencyID );
        entity.setDepartmentDelFlag ( delFlag );
        entity.setDepartmentLanguageCode ( langCode );
        List<Vdepartment> list = service.getVdepartment ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;

    }

    /**
     * 取得职务信息列表
     *
     * @throws BusinessException
     */
    public List<Vposition> getPositionList(Map<String, Object> param, String delFlag, String langCode, String langValue) throws BusinessException {
        Vposition entity = new Vposition ();
        String departmentID = param.get ( "DepartmentID" ).toString ();
        String agencyID = param.get ( "AgencyID" ).toString ();
        entity.setDepartmentID ( departmentID );
        entity.setAgencyID ( agencyID );
        entity.setDelFlag ( delFlag );
        List<Vposition> list = service.getVposition ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    /**
     * 取得待编辑的用户信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> userInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();
        String userID = param.get ( "userID" ).toString ();
        if (StringUtils.equals ( "edit", (String) param.get ( "opt" ) )) {
            //取得待编辑用户信息
            Vcustomer entity = new Vcustomer ();
            entity.setCustomerID ( userID );
            ret = iCOMPV01B11S004Service.getUserInfo ( entity );
            if (ret.size () > 1 && ret.get ( "error" ) != null) {
                //检索错误时，返回
                throw new BusinessException ( ((Vcustomer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
            }
        } else {//取得待编辑用户详细信息
            Userdetail entity = new Userdetail ();
            entity.setCustomerID ( userID );
            ret = iCOMPV01B11S004Service.getUserdetail ( entity );
            if (ret.size () > 1 && ret.get ( "error" ) != null) {//查询失败
                throw new BusinessException ( ((List<Userdetail>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
            }
        }
        return ret;
    }

    /**
     * 删除用户信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> userDelete(Map<String, Object> param, String userID, String langCode, String langValue) throws BusinessException {

        Customer customer = new Customer ();
        customer.setDelFlag ( IConstant.DEL_FLAG_1 );
        customer.setUpdateTime ( new Date () );
        customer.setUpdateUser ( userID );
        customer.setVersion ( new BigDecimal ( param.get ( "version" ).toString () ).add ( BigDecimal.ONE ) );
        customer.setCustomerIDWhere ( param.get ( "userID" ).toString () );
        customer.setUpdateTimeWhere ( Ctl.strToDate ( param.get ( "updatetime" ).toString ().replace ( "T", " " ) ) );
        customer.setUpdateUserWhere ( param.get ( "updateuser" ).toString () );
        customer.setVersionWhere ( new BigDecimal ( param.get ( "version" ).toString () ) );
        Map<String, Object> ret = iCOMPV01B11S004Service.userDelete ( customer, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //删除失败时，返回
            throw new BusinessException ( ((Customer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 新建用户信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> userAdd(Map<String, Object> param, String userID, String langCode, String langValue) throws BusinessException {
        //用户输入验证
        Map<String, Object> ret = iCOMPV01B11S004Service.checkInput ( param, langCode, langValue, userID, 1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Customer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        Customer customer = (Customer) ret.get ( "data" );
        //保存用户信息
        ret = iCOMPV01B11S004Service.userAdd ( customer, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //新建失败时，返回
            throw new BusinessException ( ((Customer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        String realName = (String) param.get ( "DivRealName" );
        // 真实姓名未输入 TODO
        if (!StringUtils.isEmpty ( realName )) {
            Userdetail ud = new Userdetail ();
            ud.setUserDetailID ( UUIDgen.getId () );
            ud.setCustomerID ( customer.getCustomerID () );
            ud.setUserName ( realName );
            // 2017/08/23 宋健 追加↓↓↓　dazhong@YMSC
            ud.setDelFlag("0");
            // 2017/08/23 宋健 追加↑↑↑　dazhong@YMSC
            ud.setCreateUser ( userID );
            ud.setCreateTime ( new Date () );
            ud.setUpdateUser ( userID );
            ud.setUpdateTime ( new Date () );
            //插入信息
            ret = iCOMPV01B11S004Service.userDetailAdd ( ud, langCode, langValue );
            if (ret.size () > 1 && ret.get ( "error" ) != null) {
                //新建失败时，返回
                throw new BusinessException ( ((Userdetail) ret.get ( "error" )).getMessageCode (), langCode, langValue );
            }
        }
        return ret;
    }

    /**
     * 编辑用户信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> userEdit(Map<String, Object> param, String userID, String langCode, String langValue) throws BusinessException {
        //用户输入验证
        Map<String, Object> ret = iCOMPV01B11S004Service.checkInput ( param, langCode, langValue, userID, 2 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Customer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        Customer customer = (Customer) ret.get ( "data" );
        //保存用户信息
        ret = iCOMPV01B11S004Service.userEdit ( customer, langCode, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //新建失败时，返回
            throw new BusinessException ( ((Customer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getGridColmun(String pageID, String userID, String langCode, String langValue) throws BusinessException {

        //取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun ( pageID, langCode, IConstant.ITEM_TYPE_1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //取得失败时，返回
            throw new BusinessException ( ((List<Displayeditemconfiguration>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 编辑用户详细信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> userDetailSave(Map<String, Object> param, String customerID, String langCode, String langValue) throws BusinessException {

        // 验证用户详细是否存在
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Userdetail userDetail = new Userdetail ();
        userDetail.setCustomerID ( param.get ( "DivUserID" ).toString () );
        rtn = iCOMPV01B11S004Service.getUserdetail ( userDetail );

        if (rtn.get ( "data" ) == null) {
            //新建
            //用户详细输入验证
            Map<String, Object> ret = iCOMPV01B11S004Service.userDetailcheckInput ( param, langCode, langValue, customerID, 1 );
            if (ret.size () > 1 && ret.get ( "error" ) != null) {
                throw new BusinessException ( ((Customer) ret.get ( "error" )).getMessageCode (), langCode, langValue );
            } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
                return ret;
            }
            //插入信息
            ret = iCOMPV01B11S004Service.userDetailAdd ( (Userdetail) ret.get ( "data" ), langCode, langValue );
            if (ret.size () > 1 && ret.get ( "error" ) != null) {
                //新建失败时，返回
                throw new BusinessException ( ((Userdetail) ret.get ( "error" )).getMessageCode (), langCode, langValue );
            }
            return ret;
        } else {
            //编辑
            //用户详细输入验证
            Map<String, Object> ret = iCOMPV01B11S004Service.userDetailcheckInput ( param, langCode, langValue, customerID, 2 );
            if (ret.size () > 1 && ret.get ( "error" ) != null) {
                throw new BusinessException ( ((Userdetail) ret.get ( "error" )).getMessageCode (), langCode, langValue );
            } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
                return ret;
            }

            userDetail = (Userdetail) ret.get ( "data" );

            userDetail.setCustomerIDWhere ( userDetail.getCustomerID () );
            userDetail.setVersionWhere ( userDetail.getVersion () );
            ret = iCOMPV01B11S004Service.userDetailEdit ( param, userDetail, langCode, langValue );

            if (ret.size () > 1 && ret.get ( "error" ) != null) {
                //编辑失败时，返回
                throw new BusinessException ( ((Userdetail) ret.get ( "error" )).getMessageCode (), langCode, langValue );
            }
            return ret;
        }
    }

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public Map<String, Object> detailInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();
        //取得详细信息
        Tubedetailinfo entity = new Tubedetailinfo ();
        entity.setSynthesisParametersCode(param.get("synthesisParametersCode").toString());
        entity.setRfId(param.get("rfId").toString());
        entity.setSplitTime(param.get("splitTime").toString());

        ret = iCOMPV01B11S004Service.getDetailInfo ( entity );

        //查询失败
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((List<Tubedetailinfo>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    @Override
    public Map<String, Object> totalInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();
        //取得详细信息
        Tubedetailinfo entity = new Tubedetailinfo ();

        ret = iCOMPV01B11S004Service.getTotalInfo ( entity );

        //查询失败
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((List<Tubedetailinfo>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
}
