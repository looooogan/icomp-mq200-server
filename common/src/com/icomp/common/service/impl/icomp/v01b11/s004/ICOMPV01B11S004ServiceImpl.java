package com.icomp.common.service.impl.icomp.v01b11.s004;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b11.s004.ICOMPV01B11S004Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

@SuppressWarnings("unchecked")
public class ICOMPV01B11S004ServiceImpl extends BaseService implements ICOMPV01B11S004Service {

    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 用户管理视图Dao
     */
    private VcustomerDao vcustomerDao;

    public void setVcustomerDao(VcustomerDao vcustomerDao) {
        this.vcustomerDao = vcustomerDao;
    }

    /**
     * 用户详细信息Dao
     */
    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    /**
     * 用户信息Dao
     */
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    private TubedetailinfoDao tubedetailinfoDao;

    public void setTubedetailinfoDao(TubedetailinfoDao tubedetailinfoDao) {
        this.tubedetailinfoDao = tubedetailinfoDao;
    }
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC

    /**
     * 用户管理
     *
     * @param entity 页面查询条件
     * @return 用户信息
     * @throws BusinessException
     */
    public Map<String, Object> getList(Vcustomer entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Vcustomer> list = (List<Vcustomer>) vcustomerDao.searchByList ( entity );
            for (Vcustomer vList : list) {
                Userdetail user = new Userdetail ();
                user.setCustomerID ( vList.getCustomerID () );
                List<Userdetail> ulist = (List<Userdetail>) userdetailDao.searchByList ( user );
                if (ulist.size () == 0) {
                    vList.setUserName ( "-" );
                } else {
                    vList.setUserName ( ulist.get ( 0 ).getUserName () );
                }
            }
            if (list.size () <= 0) {
                list = new ArrayList<Vcustomer> ();
                Vcustomer vcustomer = new Vcustomer ();
                //消息：检索为0
                vcustomer.setMessageCode ( IConstant.EMSG0001 );
                vcustomer.setRetErrFlag ( true );
                list.add ( vcustomer );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                int total = vcustomerDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            List<Vcustomer> list = new ArrayList<Vcustomer> ();
            Vcustomer vcustomer = new Vcustomer ();
            //错误消息：数据库操作异常，查询失败!
            vcustomer.setMessageCode ( IConstant.EMSG0004 );
            vcustomer.setRetErrFlag ( true );
            vcustomer.setExceMessage ( e.getMessage () );
            list.add ( vcustomer );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    /**
     * 用户管理
     *
     * @param entity 页面查询条件
     * @return 用户信息
     * @throws BusinessException
     */
    public Map<String, Object> getUserInfo(Vcustomer entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Vcustomer> list = (List<Vcustomer>) vcustomerDao.searchByList ( entity );
            if (list.size () <= 0) {
                Vcustomer vcustomer = new Vcustomer ();
                //消息：检索为0
                vcustomer.setMessageCode ( IConstant.EMSG0001 );
                vcustomer.setRetErrFlag ( true );
                rtn.put ( "data", vcustomer );
                rtn.put ( "error", vcustomer );
                return rtn;
            } else {
                list.get ( 0 ).setExpandSpace1 ( list.get ( 0 ).getUserPass () );
                rtn.put ( "data", list.get ( 0 ) );
                return rtn;
            }

        } catch (SQLException e) {
            Vcustomer vcustomer = new Vcustomer ();
            //错误消息：数据库操作异常，查询失败!
            vcustomer.setMessageCode ( IConstant.EMSG0004 );
            vcustomer.setRetErrFlag ( true );
            vcustomer.setExceMessage ( e.getMessage () );
            rtn.put ( "data", null );
            rtn.put ( "error", vcustomer );
            return rtn;
        }
    }

    /**
     * 用户管理
     *
     * @param entity 页面查询条件
     * @return 用户信息
     * @throws BusinessException
     */
    public Map<String, Object> getUserdetail(Userdetail entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Userdetail> list = (List<Userdetail>) userdetailDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Userdetail> ();
                Userdetail userdetail = new Userdetail ();
                //消息：检索为0
                userdetail.setMessageCode ( IConstant.EMSG0001 );
                userdetail.setRetErrFlag ( true );
                list.add ( userdetail );
                rtn.put ( "data", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                rtn.put ( "data", list.get ( 0 ) );
                return rtn;
            }

        } catch (SQLException e) {
            List<Userdetail> list = new ArrayList<Userdetail> ();
            Userdetail userdetail = new Userdetail ();
            //错误消息：数据库操作异常，查询失败!
            userdetail.setMessageCode ( IConstant.EMSG0004 );
            userdetail.setRetErrFlag ( true );
            userdetail.setExceMessage ( e.getMessage () );
            list.add ( userdetail );
            rtn.put ( "data", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    /**
     * 用户删除
     *
     * @param customer 页面查询条件
     * @return 用户信息
     * @throws BusinessException
     */
    public Map<String, Object> userDelete(Customer customer, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 更新失败! 进行数据排他验证
            Customer entity = new Customer ();
            entity.setCustomerID ( customer.getCustomerIDWhere () );
            entity.setUpdateTime ( customer.getUpdateTimeWhere () );
            entity.setUpdateUser ( customer.getUpdateUserWhere () );
            entity.setVersion ( customer.getVersionWhere () );
            List<Customer> list = (List<Customer>) customerDao.searchByList ( entity );
            if (list == null || list.size () == 0) {
                entity = new Customer ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );
                return rtn;
            }
            // 删除成功
            customerDao.updateNonQuery ( customer );
            Userdetail userdetail = new Userdetail ();
            userdetail.setCustomerID ( customer.getCustomerIDWhere () );
            List<Userdetail> ulist = (List<Userdetail>) userdetailDao.searchByList ( userdetail );
            if (ulist.size () > 0) {
                Userdetail userdetailEntity = new Userdetail ();
                userdetailEntity.setDelFlag ( IConstant.DEL_FLAG_1 );
                userdetailEntity.setCustomerIDWhere ( customer.getCustomerIDWhere () );
                userdetailDao.updateNonQuery ( userdetailEntity );
            }
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0003, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Customer entity = new Customer ();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode ( IConstant.EMSG0008 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 新建用户信息
     *
     * @param langValue
     * @return
     * @paramparam
     */
    public Map<String, Object> userAdd(Customer customer, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            customerDao.insert ( customer );
            //成功消息：插入成功
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0004, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Customer entity = new Customer ();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode ( IConstant.EMSG0007 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 编辑用户信息
     *
     * @param langValue
     * @return
     * @throws BusinessException
     * @paramparam
     */
    public Map<String, Object> userEdit(Customer customer, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 更新失败! 进行数据排他验证
            Customer entity = new Customer ();
            entity.setCustomerID ( customer.getCustomerIDWhere () );
            entity.setUpdateTime ( customer.getUpdateTimeWhere () );
            entity.setUpdateUser ( customer.getUpdateUserWhere () );
            entity.setVersion ( customer.getVersionWhere () );
            List<Customer> list = (List<Customer>) customerDao.searchByList ( entity );
            if (list == null || list.size () == 0) {
                entity = new Customer ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );

            }
            // 更新用户成功
            @SuppressWarnings("unused")
            int ret = customerDao.updateNonQuery ( customer );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );

        } catch (SQLException e) {
            Customer entity = new Customer ();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode ( IConstant.EMSG0006 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );

        }
        return rtn;
    }

    /**
     * 新建用户信息验证
     *
     * @param param
     * @param langValue
     * @return
     */
    public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, String userID, int checkType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            Customer customer = new Customer ();
            // 页面输入项目验证
            Map<String, String> map = new HashMap<String, String> ();
            if (checkType == 1)
                if (StringUtils.isEmpty ( param.get ( "DivUserName" ).toString () )) {// 如果用户名未输入
                    map.put ( "DivUserName", MessageReSource.getMessageBox ( IConstant.WMSG0010, langCode, langValue ) );
                } else {
/*				if (param.get("DivUserName").toString().length() < 6) { // 用户名不可以小于6位
                    map.put("DivUserName", MessageReSource.getMessageBox(
							IConstant.WMSG0011, langCode, langValue));
				} else {*/
                    // 验证用户名是否存在
                    customer.setUserName ( param.get ( "DivUserName" ).toString () );
                    // 2017/08/22 宋健 追加↓↓↓　dazhong@YMSC
                    customer.setDelFlag("0");
                    // 2017/08/22 宋健 追加↓↓↓　dazhong@YMSC
                    List<Customer> list = (List<Customer>) customerDao.searchByList ( customer );
                    if (list.size () > 0) {

                        map.put ( "DivUserName", MessageReSource.getMessageBox ( IConstant.WMSG0012, langCode, langValue ) );
                    }

                    //}
                }

            if (param.get ( "DivUserPass" ) != null) {
                if (StringUtils.isEmpty ( param.get ( "DivUserPass" ).toString () )) {// 如果密码未输入
                    if (checkType == 1)
                        map.put ( "DivUserPass", MessageReSource.getMessageBox ( IConstant.WMSG0013, langCode, langValue ) );
                } else {
					/*if (param.get("DivUserPass").toString().length() < 6) { // 密码不可以小于6位
						map.put("DivUserPass", MessageReSource.getMessageBox(
								IConstant.WMSG0014, langCode, langValue));
					} else {*/
                    if (param.get ( "DivUserPass" ).toString ().equals ( param.get ( "DivPass" ).toString () )) {
                        customer.setUserPass ( param.get ( "DivUserPass" ).toString () );
                    } else {
                        customer.setUserPass ( Ctl.md5 ( param.get ( "DivUserPass" ).toString () ) );
                    }

                    //}
                }
            }

            if (StringUtils.isEmpty ( param.get ( "DivEmployeeCard" ).toString () )) {// 如果员工卡 未输入,不提示错误
            } else {
                if (param.get ( "DivEmployeeCard" ).toString ().length () > 20) { // 员工卡不可超过20位
                    map.put ( "DivEmployeeCard", "员工卡不可超过20位" );
                } else {

                }
            }
            if (StringUtils.isEmpty ( param.get ( "DivAgencyID" ).toString () )) {// 如果机构未选择
                map.put ( "DivAgencyID", MessageReSource.getMessageBox ( IConstant.WMSG0015, langCode, langValue ) );
            }

            if (StringUtils.isEmpty ( param.get ( "DivDepartmentID" ).toString () )) {// 如果部门未选择
                map.put ( "DivDepartmentID", MessageReSource.getMessageBox ( IConstant.WMSG0016, langCode, langValue ) );
            }

            if (StringUtils.isEmpty ( param.get ( "DivPositionID" ).toString () )) {// 如果职务未选择
                map.put ( "DivPositionID", MessageReSource.getMessageBox ( IConstant.WMSG0017, langCode, langValue ) );
            } else {
                customer.setPositionID ( param.get ( "DivPositionID" ).toString () );
            }

            if (StringUtils.isEmpty ( param.get ( "DivUserType" ).toString () )) {// 如果用户类型未选择
                map.put ( "DivUserType", MessageReSource.getMessageBox ( IConstant.WMSG0018, langCode, langValue ) );
            } else {
                customer.setUserType ( param.get ( "DivUserType" ).toString () );
            }

            if (checkType == 1 && map.size () <= 0) {
                customer.setCustomerID ( NextKeyValue.getNextkeyvalue ( IConstant.CUSTOMER, IConstant.CUSTOMER_ID, userID ) );// 取得用户表主键
                customer.setEmployeeCard ( param.get ( "DivEmployeeCard" ).toString () );
                customer.setUpdateTime ( new Date () );// 更新时间
                customer.setUpdateUser ( userID );// 更新者
                customer.setCreateTime ( new Date () );// 创建时间
                customer.setCreateUser ( userID );// 创建者
                customer.setVersion ( BigDecimal.ZERO );// 版本号
                customer.setDelFlag ( IConstant.DEL_FLAG_0 );
            } else if (checkType == 2 && map.size () <= 0) {
                customer.setUpdateTime ( new Date () );
                customer.setUpdateUser ( userID );
                customer.setEmployeeCard ( param.get ( "DivEmployeeCard" ).toString () );
                customer.setVersion ( new BigDecimal ( param.get ( "DivVersion" ).toString () ).add ( BigDecimal.ONE ) );
                customer.setCustomerIDWhere ( param.get ( "DivUserID" ).toString () );
                customer.setUpdateTimeWhere ( Ctl.strToDate ( param.get ( "DivUpdateTime" ).toString ().replace ( "T", " " ) ) );
                customer.setUpdateUserWhere ( param.get ( "DivUpdateUser" ).toString () );
                customer.setVersionWhere ( new BigDecimal ( param.get ( "DivVersion" ).toString () ) );
                customer.setDelFlag ( IConstant.DEL_FLAG_0 );
            } else if (map.size () > 0) {
                rtn.put ( "message", map );
            }
            rtn.put ( "data", customer );
            rtn.put ( "status", IConstant.RESULT_CODE_2 );


        } catch (SQLException e) {
            Customer entity = new Customer ();
            //错误消息：数据库操作异常，查询失败!
            entity.setMessageCode ( IConstant.EMSG0004 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );

        }
        return rtn;
    }

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param lang
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getGridColmun(String pageID, String lang) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            Displayeditemconfiguration entity = new Displayeditemconfiguration ();
            entity.setPageName ( pageID );
            entity.setLanguageCode ( lang );

            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Displayeditemconfiguration> ();
                Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration ();
                displayeditemconfiguration.setMessageCode ( IConstant.WMSG0008 );
                displayeditemconfiguration.setRetErrFlag ( true );
                list.add ( displayeditemconfiguration );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                for (Displayeditemconfiguration displayeditemconfiguration : list) {
                    rtn.put ( displayeditemconfiguration.getColName (), IConstant.DISPLAYED_FLAG_0.equals ( displayeditemconfiguration.getDisplayedFlag () ) ? true : false );
                }
                return rtn;
            }

        } catch (SQLException e) {
            List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration> ();
            Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration ();
            //错误消息：数据库操作异常，查询失败!
            displayeditemconfiguration.setMessageCode ( IConstant.EMSG0004 );
            displayeditemconfiguration.setRetErrFlag ( true );
            displayeditemconfiguration.setExceMessage ( e.getMessage () );
            list.add ( displayeditemconfiguration );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;

        }
    }

    /**
     * 用户详细信息验证
     *
     * @param param
     * @param langCode
     * @param langValue
     * @param customerID
     * @param checkType
     * @return
     */

    public Map<String, Object> userDetailcheckInput(Map<String, Object> param, String langCode, String langValue, String customerID, int checkType) {

        Map<String, Object> rtn = new HashMap<String, Object> ();
        Map<String, String> map = new HashMap<String, String> ();
        Userdetail userdetail = new Userdetail ();
        try {
            //姓名验证
            if (StringUtils.isEmpty ( param.get ( "DivUserName" ).toString () )) {
                map.put ( "DivUserName", MessageReSource.getMessageBox ( IConstant.WMSG0010, langCode, langValue ) );
            } else {
                if (checkType == 1) {
                    // 新建时，验证用户名是否存在
//                    Userdetail entity = new Userdetail ();
//                    entity.setUserName ( param.get ( "DivUserName" ).toString () );
//                    List<Userdetail> list = (List<Userdetail>) userdetailDao.searchByList ( entity );
//                    if (list.size () > 0) {
//                        map.put ( "DivUserName", MessageReSource.getMessageBox ( IConstant.WMSG0012, langCode, langValue ) );
//                    }
                }
            }
            //年龄
            if (StringUtils.isEmpty ( param.get ( "DivUserAge" ).toString () )) {// 如果年龄未输入
                //请输入年龄!
                //			map.put("DivUserAge",MessageReSource.getMessageBox(
                //					IConstant.WMSG0212, langCode, langValue));
            } else {
                if (checkOutNum ( param.get ( "DivUserAge" ).toString () )) {
                    userdetail.setUserAge ( new BigDecimal ( param.get ( "DivUserAge" ).toString () ) );
                } else {
                    //年龄必须是数字
                    map.put ( "DivUserAge", MessageReSource.getMessageBox ( IConstant.WMSG0213, langCode, langValue ) );
                }
            }
            //身高
            if (StringUtils.isEmpty ( param.get ( "DivUserHeight" ).toString () )) {// 如果身高未输入
                //请输入身高!
			/*map.put("DivUserHeight",MessageReSource.getMessageBox(
					IConstant.WMSG0214, langCode, langValue));*/
            } else {
                if (checkOutNum ( param.get ( "DivUserHeight" ).toString () )) {
                    userdetail.setUserHeight ( new BigDecimal ( param.get ( "DivUserHeight" ).toString () ) );
                } else {
                    //身高必须是数字
                    map.put ( "DivUserHeight", MessageReSource.getMessageBox ( IConstant.WMSG0215, langCode, langValue ) );
                }
            }

            //体重
            if (StringUtils.isEmpty ( param.get ( "DivUserWeight" ).toString () )) {// 如果体重未输入
			/*//请输入体重!
			map.put("DivUserWeight", MessageReSource.getMessageBox(
					IConstant.WMSG0216, langCode, langValue));*/
            } else {
                if (checkOutNum ( param.get ( "DivUserWeight" ).toString () )) {
                    userdetail.setUserWeight ( new BigDecimal ( param.get ( "DivUserWeight" ).toString () ) );
                } else {
                    //体重必须是数字
                    map.put ( "DivUserWeight", MessageReSource.getMessageBox ( IConstant.WMSG0217, langCode, langValue ) );
                }
            }
            //出生年月日
            if (checkType == 1 && StringUtils.isEmpty ( param.get ( "DivUserBirthday" ).toString () )) {
            } else {
                String birthday = param.get ( "DivUserBirthday" ).toString ();
                if (birthday != "") {
                    birthday = birthday.replace ( "-", "" );
                }
                userdetail.setUserBirthday ( birthday );             //生年月日
            }

            if (checkType == 1) {
                if (map.size () <= 0) {
                    userdetail.setUserDetailID ( NextKeyValue.getNextkeyvalue ( IConstant.USERDETAIL, IConstant.USERDETAIL_ID, customerID ) );// 取得用户明细表主键
                    userdetail.setCustomerID ( param.get ( "DivUserID" ).toString () );                 //id
                    userdetail.setUserName ( param.get ( "DivUserName" ).toString () );                     //姓名
                    userdetail.setUserSex ( param.get ( "DivUserSex" ).toString () );                       //性别

                    userdetail.setUserCardID ( param.get ( "DivUserCardID" ).toString () );                 //身份证号
                    userdetail.setUserMobile ( param.get ( "DivUserMobile" ).toString () );                 //移动电话
                    userdetail.setUserLandline ( param.get ( "DivUserLandline" ).toString () );             //座机
                    userdetail.setUserPrivacies ( param.get ( "DivUserPrivacies" ).toString () );           //婚否
                    userdetail.setUserUniversity ( param.get ( "DivUserUniversity" ).toString () );         //毕业院校
                    userdetail.setUserProfessional ( param.get ( "DivUserProfessional" ).toString () );     //专业
                    userdetail.setUserEducation ( param.get ( "DivUserEducation" ).toString () );           //学历
                    userdetail.setUserBloodGroup ( param.get ( "DivUserBloodGroup" ).toString () );         //血型
                    userdetail.setUpdateTime ( new Date () );// 更新时间
                    userdetail.setUpdateUser ( customerID );// 更新者
                    userdetail.setCreateTime ( new Date () );// 创建时间
                    userdetail.setCreateUser ( customerID );// 创建者
                    userdetail.setDelFlag ( IConstant.DEL_FLAG_0 );//删除区分
                    userdetail.setVersion ( BigDecimal.ZERO );// 版本号
                    rtn.put ( "data", userdetail );
                } else {
                    rtn.put ( "data", null );
                    rtn.put ( "message", map );
                }
                rtn.put ( "status", IConstant.RESULT_CODE_2 );
                return rtn;
            } else {
                if (map.size () <= 0) {
                    userdetail.setUserName ( param.get ( "DivUserName" ).toString () );                     //姓名
                    userdetail.setUserSex ( param.get ( "DivUserSex" ).toString () );                       //性别
                    userdetail.setUserCardID ( param.get ( "DivUserCardID" ).toString () );                 //身份证号
                    userdetail.setUserMobile ( param.get ( "DivUserMobile" ).toString () );                 //移动电话
                    userdetail.setUserLandline ( param.get ( "DivUserLandline" ).toString () );             //座机
                    userdetail.setUserPrivacies ( param.get ( "DivUserPrivacies" ).toString () );           //婚否
                    userdetail.setUserUniversity ( param.get ( "DivUserUniversity" ).toString () );         //毕业院校
                    userdetail.setUserProfessional ( param.get ( "DivUserProfessional" ).toString () );     //专业
                    userdetail.setUserEducation ( param.get ( "DivUserEducation" ).toString () );           //学历
                    userdetail.setUserBloodGroup ( param.get ( "DivUserBloodGroup" ).toString () );         //血型
                    userdetail.setDelFlag ( IConstant.EDIT_FLAG_0 );                       //删除区分
                    userdetail.setUpdateTime ( new Date () );
                    userdetail.setUpdateUser ( customerID );
                    userdetail.setUpdateTimeWhere ( Ctl.strToDate ( param.get ( "DivUpdateTime" ).toString ().replace ( "T", " " ) ) );
                    userdetail.setUpdateUserWhere ( param.get ( "DivUpdateUser" ).toString () );
                    rtn.put ( "data", userdetail );
                } else {
                    rtn.put ( "data", null );
                    rtn.put ( "message", map );
                }
                rtn.put ( "status", IConstant.RESULT_CODE_2 );
                return rtn;
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return rtn;
    }

    @Override
    public Map<String, Object> userDetailAdd(Userdetail userdetail, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            userdetailDao.insert ( userdetail );
            //成功消息：插入成功
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0004, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Userdetail entity = new Userdetail ();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode ( IConstant.EMSG0007 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    /**
     * 保存用户详细信息
     *
     * @param param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> userDetailEdit(Map<String, Object> param, Userdetail userDetail, String langCode, String langValue) {
        //新建
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 更新失败! 进行数据排他验证
            Userdetail entity = new Userdetail ();
            entity.setCustomerID ( userDetail.getCustomerIDWhere () );
            entity.setUpdateTime ( userDetail.getUpdateTimeWhere () );
            entity.setUpdateUser ( userDetail.getUpdateUserWhere () );
            entity.setVersion ( userDetail.getVersionWhere () );
            List<Userdetail> list = (List<Userdetail>) userdetailDao.searchByList ( entity );
            if (list == null || list.size () == 0) {
                entity = new Userdetail ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );
                return rtn;
            }
            // 更新用户成功
            @SuppressWarnings("unused")
            int ret = userdetailDao.updateNonQuery ( userDetail );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Userdetail entity = new Userdetail ();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode ( IConstant.EMSG0006 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    @Override
    public Map<String, Object> getDetailInfo(Tubedetailinfo entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Tubedetailinfo> list = tubedetailinfoDao.searchDetailList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Tubedetailinfo> ();
                Tubedetailinfo detail = new Tubedetailinfo ();
                //消息：检索为0
                detail.setMessageCode ( IConstant.EMSG0001 );
                detail.setRetErrFlag ( true );
                list.add ( detail );
                rtn.put ( "data", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                rtn.put ( "data", list );
                return rtn;
            }

        } catch (SQLException e) {
            List<Tubedetailinfo> list = new ArrayList<Tubedetailinfo> ();
            Tubedetailinfo detail = new Tubedetailinfo ();
            //错误消息：数据库操作异常，查询失败!
            detail.setMessageCode ( IConstant.EMSG0004 );
            detail.setRetErrFlag ( true );
            detail.setExceMessage ( e.getMessage () );
            list.add ( detail );
            rtn.put ( "data", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    @Override
    public Map<String, Object> getTotalInfo(Tubedetailinfo entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Tubedetailinfo> list = tubedetailinfoDao.searchTotalList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Tubedetailinfo> ();
                Tubedetailinfo detail = new Tubedetailinfo ();
                //消息：检索为0
                detail.setMessageCode ( IConstant.EMSG0001 );
                detail.setRetErrFlag ( true );
                list.add ( detail );
                rtn.put ( "data", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                rtn.put ( "data", list );
                return rtn;
            }

        } catch (SQLException e) {
            List<Tubedetailinfo> list = new ArrayList<Tubedetailinfo> ();
            Tubedetailinfo detail = new Tubedetailinfo ();
            //错误消息：数据库操作异常，查询失败!
            detail.setMessageCode ( IConstant.EMSG0004 );
            detail.setRetErrFlag ( true );
            detail.setExceMessage ( e.getMessage () );
            list.add ( detail );
            rtn.put ( "data", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
}
