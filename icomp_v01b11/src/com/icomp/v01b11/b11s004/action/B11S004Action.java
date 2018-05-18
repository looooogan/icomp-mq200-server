package com.icomp.v01b11.b11s004.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.entity.base.*;
import com.icomp.v01b11.b11s004.business.B11S004Business;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B11S004Action extends IcompAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户管理Business
     */
    private B11S004Business business;

    public void setBusiness(B11S004Business business) {
        this.business = business;
    }

    /**
     * 用户管理初始化Action
     *
     * @return
     */
    public String initb11S004() {
        // 下拉列表值取得
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                // 设置页面初始化值

                Map<String, Object> list = this.business.getList ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            } else {
                super.assign ( "DelFlag", IConstant.DEL_FLAG_0 ); // 删除区分-检索初始值
                super.assign ( "DelFlagList", business.getComList ( IConstant.DEL_FLAG, langCode, langValue ) ); // 删除区分
                super.assign ( "UserTypeList", business.getComList ( IConstant.USER_TYPE, langCode, langValue ) ); // 用户类型
                super.assign ( "UserSexList", business.getComList ( IConstant.USER_SEX, langCode, langValue ) ); // 用户性别
                super.assign ( "UserPrivaciesList", business.getComList ( IConstant.USER_PRIVACIES, langCode, langValue ) ); // 婚否
                super.assign ( "UserBloodGroupList", business.getComList ( IConstant.USER_BLOOD_GROUP, langCode, langValue ) ); // 血型
                // 设置页面初始化值
                super.assign ( "AgencyID", "" );
                super.assign ( "DepartmentID", "" );
                super.assign ( "PositionID", "" );
                super.assign ( "UserType", "" );
                super.assign ( "UserPrivacies", "" );
                super.assign ( "UserBloodGroup", "" );
                // 取得机构列表
                List<Vagency> listAgency = business.getAgencyList ( IConstant.DEL_FLAG_0, langCode, langValue );
                super.assign ( "AgencyList", listAgency );
                // 取得部门列表
                List<Vdepartment> listDepartment = business.getDepartmentList ( listAgency.get ( 0 ).getAgencyID (), IConstant.DEL_FLAG_0, langCode, langValue );
                super.assign ( "DepartmentList", listDepartment );
                //取得页面grid显示项目列表
                super.session ( "gridcol", business.getGridColmun ( "B11S004", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
                return SUCCESS;
            }
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B11S004.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B11S004", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 修改组织结构列表选择Action
     *
     * @return
     */
    public String changeAgency() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            // 根据用户选择的机构ID，取得 相应的部门及职务列表
            Map<String, Object> param = super.param ();
            String AgencyID = param.get ( "AgencyID" ).toString ();
            if (StringUtils.isEmpty ( AgencyID )) {
                // 取得机构列表
                List<Vagency> listAgency = business.getAgencyList ( IConstant.DEL_FLAG_0, langCode, langValue );
                AgencyID = listAgency.get ( 0 ).getAgencyID ();
            }
            // 取得部门列表
            List<Vdepartment> listDepartment = business.getDepartmentList ( AgencyID, IConstant.DEL_FLAG_0, langCode, langValue );
            super.ajaxReturn ( listDepartment, null, listDepartment.get ( 0 ).getMessageCode () == null ? 0 : -2, null );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/changeAgency.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "changeAgency", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 修改组织结构列表选择Action
     *
     * @return
     */
    public String changeDepartment() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            // 根据用户选择的机构ID，取得 相应的部门及职务列表
            Map<String, Object> param = super.param ();
            String DepartmentID = param.get ( "DepartmentID" ).toString ();
            if (StringUtils.isEmpty ( DepartmentID )) {
                // 取得机构列表
                List<Vagency> listAgency = business.getAgencyList ( IConstant.DEL_FLAG_0, langCode, langValue );
                String AgencyID = listAgency.get ( 0 ).getAgencyID ();
                // 取得部门列表
                List<Vdepartment> listDepartment = business.getDepartmentList ( AgencyID, IConstant.DEL_FLAG_0, langCode, langValue );
                DepartmentID = listDepartment.get ( 0 ).getDepartmentID ();
            }
            List<Vposition> positionList = (List<Vposition>) business.getPositionList ( param, IConstant.DEL_FLAG_0, langCode, langValue );
            // 取得职务列表
            super.ajaxReturn ( positionList, null, positionList.get ( 0 ).getMessageCode () == null ? 0 : -2, null );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/changeDepartment.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "changeDepartment", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 编辑用户详细信息
     *
     * @return
     */
    public String userDetail() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.business.userDetailSave ( param, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue );

            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录编辑成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "userDetail", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userDetail.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userDetail", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 编辑用户信息
     *
     * @return
     */
    public String userEdit() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.business.userEdit ( param, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue );

            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录编辑成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "userEdit", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userEdit.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userEdit", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 新建用户信息
     *
     * @return
     */
    public String userAdd() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.business.userAdd ( param, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue );

            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录新建成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "userAdd", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userAdd.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userAdd", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    public String userDelete() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.business.userDelete ( param, ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue );
            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录删除成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "userDelete", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userDelete.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userDelete", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    /**
     * 取得用户信息
     *
     * @return
     */
    public String userInfo() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();

            // 2017/09/16 宋健 变更↓↓↓　dazhong@YMSC
            Map<String, Object> ret = new HashMap<String, Object>();
            if("detail".equals(param.get("opt"))){
                ret = this.business.detailInfo ( param, langCode, langValue );
            }else if("total".equals(param.get("opt"))){
                ret = this.business.totalInfo ( param, langCode, langValue );
            }else{
                ret = this.business.userInfo ( param, langCode, langValue );
            }
            // 2017/09/16 宋健 变更↑↑↑　dazhong@YMSC
            super.ajaxReturn ( ret );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/userInfo.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "userInfo", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }
}
