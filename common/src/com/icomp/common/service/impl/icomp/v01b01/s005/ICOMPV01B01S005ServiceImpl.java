package com.icomp.common.service.impl.icomp.v01b01.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s005.ICOMPV01B01S005Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.CustomerDao;
import com.icomp.dao.DepartmentDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.ReplacementDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VapplyuserDao;
import com.icomp.dao.VreplacementDao;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Department;
import com.icomp.entity.base.Replacement;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vapplyuser;
import com.icomp.entity.base.Vreplacement;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 申请信息查询SERVICES实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B01S005ServiceImpl
 * @date 2014-8-13 下午05:01:41
 */
class ICOMPV01B01S005ServiceImpl extends BaseService implements ICOMPV01B01S005Service {

    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    @SuppressWarnings("unused")
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;
    private DepartmentDao departmentDao;
    private ToolDao toolDao;
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 申请信息Dao
     */
    private VreplacementDao replacementDao;
    private ReplacementDao replacementDaos;
    private VapplyuserDao vapplyuserDao;
    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    public void setVapplyuserDao(VapplyuserDao vapplyuserDao) {
        this.vapplyuserDao = vapplyuserDao;
    }

    public void setReplacementDao(VreplacementDao replacementDao) {
        this.replacementDao = replacementDao;
    }

    public void setReplacementDaos(ReplacementDao replacementDaos) {
        this.replacementDaos = replacementDaos;
    }

    public Map<String, Object> getList(Vreplacement entity) {

        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Vreplacement> list = (List<Vreplacement>) replacementDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vreplacement> ();
                Vreplacement replacement = new Vreplacement ();
                replacement.setMessageCode ( IConstant.EMSG0001 );
                replacement.setRetErrFlag ( true );
                list.add ( replacement );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                for (Vreplacement vlist : list) {

                    if ("0".equals ( vlist.getReplacementReason () ) == true) {
                        //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                        String[] sc = vlist.getApplyUser ().split ( "#" );
                        //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                        vlist.setExpandSpace1 ( sc[0] );

                        vlist.setDepartmentName ( sc[1] );

                        vlist.setApplyUser ( sc[2] );

                        vlist.setDepartmentTel ( sc[3] );

                        vlist.setEmil ( sc[4] );

                    } else {
                        vlist.setExpandSpace1 ( "一汽大众" );
                    }


                }

                int total = replacementDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", list.size() );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            List<Replacement> list = new ArrayList<Replacement> ();
            Replacement replacement = new Replacement ();
            replacement.setMessageCode ( IConstant.EMSG0004 );
            replacement.setRetErrFlag ( true );
            replacement.setExceMessage ( e.getMessage () );
            list.add ( replacement );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    public Map<String, Object> replaceAdd(Replacement replacement, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            replacementDaos.insert ( replacement );
            //成功消息：插入成功
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0004, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );

        } catch (SQLException e) {
            Replacement entity = new Replacement ();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode ( IConstant.EMSG0007 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );

        }
        return rtn;
    }

    public List<Department> getPartsLine() {
        List<Department> list = null;
        try {
            Department entity = new Department ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            list = (List<Department>) departmentDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Department> ();
                Department parts = new Department ();
                // 消息：检索为0
                parts.setMessageCode ( IConstant.EMSG0001 );
                parts.setRetErrFlag ( false );
                list.add ( parts );
            }
            return list;
        } catch (SQLException e) {
            list = new ArrayList<Department> ();
            Department department = new Department ();
            // 错误消息：数据库操作异常，查询失败!
            department.setMessageCode ( IConstant.EMSG0004 );
            department.setRetErrFlag ( true );
            department.setExceMessage ( e.getMessage () );
            list.add ( department );

        }
        return list;
    }

    public Map<String, Object> checkInput(Map<String, Object> param, String langValue, String userID, int checkType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Map<String, String> map = new HashMap<String, String> ();
        Replacement entity = new Replacement ();
        System.out.println ( userID );
        try {
            Customer cu = new Customer ();
            cu.setCustomerID ( userID );
            //通过userID查询当前人员的信息
            Customer reCu = customerDao.searchDetelByUserID ( cu );
            // 2017/08/11 宋健 追加↓↓↓　dazhong@YMSC
            if("0".equals( param.get ( "DIVreissueReason" ).toString () )){
                entity.setReplacementFlag("1");
            }else if("1".equals( param.get ( "DIVreissueReason" ).toString () )){
                entity.setReplacementFlag("0");
            }else {
                entity.setReplacementFlag("2");
            }
            // 2017/08/11 宋健 追加↑↑↑　dazhong@YMSC
            if (checkType == 1) {
                entity.setReplacementID ( NextKeyValue.getkeyvalueNO ( IConstant.REDEMPTION_APPLIED, IConstant.REDEMPTION_APPLIED_ID, userID ) );
                //				材料号
                if (StringUtils.isEmpty ( param.get ( "DIVsysteCode" ).toString () )) {
                    map.put ( "DIVsysteCode", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_02, "", langValue ) );
                } else {
                    //验证材料号是否存在
                    Tool t = new Tool ();
                    t.setToolCode ( param.get ( "DIVsysteCode" ).toString () );
                    List<Tool> listTool = toolDao.getToolList ( t );
                    if (listTool == null || listTool.size () == 0) {
                        map.put ( "DIVsysteCode", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_10, "", langValue ) );
                    } else {
                        // 根据材料号和补领单号 验证是否存在在表单里
                        //
                        //						entity.setToolCode(param.get("DIVsysteCode").toString());
                        //						List<Replacement> list = replacementDaos.getsearchByPrimaryKey_Code(entity);
                        //						if (list.size()==0 ) {
                        entity.setToolCode ( param.get ( "DIVsysteCode" ).toString () );
                        //						} else {
                        //							map.put("DIVsysteCode", MessageReSource.getMessageBox(IConstant.ERROR_MSG_15, "", langValue));
                        //						}
                    }

                }

                //补领原因
                if (StringUtils.isEmpty ( param.get ( "DIVreissueReason" ).toString () )) {
                    map.put ( "DIVreissueReason", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_04, "", langValue ) );
                    //如果是借用
                } else if (IConstant.STRING_0.equals ( param.get ( "DIVreissueReason" ).toString () )) {
                    //验证借用状态
                    if (StringUtils.isEmpty ( param.get ( "DIVreturnStatus" ).toString () )) {
                        map.put ( "DIVreturnStatus", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_05, "", langValue ) );
                        //						周期
                    } else if (StringUtils.isEmpty ( param.get ( "DivDay" ).toString () )) {
                        map.put ( "DivDay", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_13, "", langValue ) );
                    } else if (Ctl.checkString ( 0, param.get ( "DivDay" ).toString () )) {
                        entity.setVersion ( new BigDecimal ( param.get ( "DivDay" ).toString () ) );
                        entity.setReplacementReason ( param.get ( "DIVreissueReason" ).toString () );
                        entity.setProcessingStatus ( param.get ( "DIVreturnStatus" ).toString () );

                    } else {
                        map.put ( "DivDay", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_13, "", langValue ) );
                    }

                    if (!StringUtils.isEmpty ( param.get ( "DivEmil" ).toString () )) {
                        //						String check = "^\\\\w+([-+.]\\\\w+)*@\\\\w+([-.]\\\\w+)*\\\\.\\\\w+([-.]\\\\w+)*$";
                        String check = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
                        Pattern regex = Pattern.compile ( check );
                        Matcher matcher = regex.matcher ( param.get ( "DivEmil" ).toString () );
                        if (matcher.matches () == false) {
                            map.put ( "DivEmil", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_22, "", langValue ) );
                        }
                    }

                    if (StringUtils.isEmpty ( param.get ( "Divdv" ).toString () )) {
                        map.put ( "Divdv", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_16, "", langValue ) );
                    } else if (StringUtils.isEmpty ( param.get ( "Divjyr" ).toString () )) {
                        map.put ( "Divjyr", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_17, "", langValue ) );
                    } else if (StringUtils.isEmpty ( param.get ( "Divjyr" ).toString () )) {
                        map.put ( "Divjyr", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_17, "", langValue ) );
                    }
                    if (StringUtils.isEmpty ( param.get ( "DivTel" ).toString () )) {
                        param.put ( "DivTel", "-" );
                    }

                        String bm = null, emil = null;
                        if (param.get ( "Divbm" ) == null || "".equals ( param.get ( "Divbm" ) )) {
                            bm = "-";
                        } else {
                            bm = param.get ( "Divbm" ).toString ();
                        }
                        if (param.get ( "DivEmil" ) == null || "".equals ( param.get ( "DivEmil" ) )) {
                            emil = "-";
                        } else {

                            emil = param.get ( "DivEmil" ).toString ();
                        }
                        //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                        String teams = param.get ( "Divdv" ).toString () + "#" + bm + "#" + param.get ( "Divjyr" ).toString () + "#" + param.get ( "DivTel" ).toString () + "#" + emil + "#";
                        //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                        entity.setApplyUser ( teams );
                        entity.setApplyID ( param.get ( "Divjyr" ).toString () );

                    //除借用外
                } else {
                    //申领人
                    //申请人姓名
                    entity.setApplyUser ( reCu.getUserName () );
                    //申领人ID
                    entity.setApplyID ( userID );
                    entity.setReplacementReason ( param.get ( "DIVreissueReason" ).toString () );
                    //申请人部门
                    entity.setDepartmentID ( reCu.getUserPass () );
                    entity.setVersion ( new BigDecimal ( IConstant.GRINDING_0 ) );
                    entity.setProcessingStatus ( IConstant.STRING_9 );
                    entity.setExpandSpace1 ( "一汽大众" );
                }

                //			补领时间
                if (StringUtils.isEmpty ( param.get ( "DIVtime" ).toString () )) {
                    map.put ( "DIVtime", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_06, "", langValue ) );
                } else {
                    String ghfg = param.get ( "DIVtime" ).toString ();
                    DateFormat format1 = new SimpleDateFormat ( "HH:mm:ss" );
                    Date date1 = new Date ();
                    ghfg += " " + format1.format ( date1 );
                    entity.setApplyTime ( Ctl.strToDate ( ghfg ) );
                }

                //数量
                if (StringUtils.isEmpty ( param.get ( "DivBorrowNum" ).toString () )) {
                    map.put ( "DivBorrowNum", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_03, "", langValue ) );
                } else if (Ctl.checkString ( 0, param.get ( "DivBorrowNum" ).toString () )) {
                    if (param.get ( "DivBorrowNum" ).toString ().length () <= 6) {
                        entity.setAppliedNumber ( new BigDecimal ( param.get ( "DivBorrowNum" ).toString () ) );
                        entity.setAppliedTotalNumber ( new BigDecimal ( param.get ( "DivBorrowNum" ).toString () ) );
                    } else {
                        map.put ( "DivBorrowNum", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_14, "", langValue ) );
                    }

                } else {
                    map.put ( "DivBorrowNum", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_11, "", langValue ) );
                }
                //领取人

                entity.setReceiveUser ( userID );

                if (map.size () <= 0) {
                    entity.setUpdateTime ( new Date () );
                    entity.setUpdateUser ( userID );
                    entity.setCreateTime ( new Date () );
                    entity.setCreateUser ( userID );
                    entity.setDelFlag ( IConstant.DEL_FLAG_0 );


                } else {
                    rtn.put ( "message", map );
                    rtn.put ( "status", IConstant.RESULT_CODE_2 );
                }

                rtn.put ( "data", entity );
                rtn.put ( "status", IConstant.RESULT_CODE_2 );
            } else {
                //编辑
                entity.setReplacementIDWhere ( param.get ( "DIVreplacementIDh" ).toString () );
                entity.setToolCodeWhere ( param.get ( "DIVsysteCodeh" ).toString () );

                //补领原因
                if (StringUtils.isEmpty ( param.get ( "DIVsysteCode" ).toString () )) {
                    map.put ( "DIVsysteCode", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_02, "", langValue ) );
                }

                //补领原因
                if (StringUtils.isEmpty ( param.get ( "DIVreissueReason" ).toString () )) {
                    map.put ( "DIVreissueReason", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_04, "", langValue ) );
                    //如果是借用
                } else if (IConstant.STRING_0.equals ( param.get ( "DIVreissueReason" ).toString () )) {
                    //验证借用状态
                    if (StringUtils.isEmpty ( param.get ( "DIVreturnStatus" ).toString () )) {
                        map.put ( "DIVreturnStatus", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_05, "", langValue ) );
                        //						周期
                    } else if (StringUtils.isEmpty ( param.get ( "DivDay" ).toString () )) {
                        map.put ( "DivDay", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_13, "", langValue ) );
                    } else if (Ctl.checkString ( 0, param.get ( "DivDay" ).toString () )) {
                        entity.setVersion ( new BigDecimal ( param.get ( "DivDay" ).toString () ) );
                        entity.setReplacementReason ( param.get ( "DIVreissueReason" ).toString () );
                        entity.setProcessingStatus ( param.get ( "DIVreturnStatus" ).toString () );
                    } else {
                        map.put ( "DivDay", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_13, "", langValue ) );
                    }

                    if (!StringUtils.isEmpty ( param.get ( "DivEmil" ).toString () )) {
                        //						String check = "^\\\\w+([-+.]\\\\w+)*@\\\\w+([-.]\\\\w+)*\\\\.\\\\w+([-.]\\\\w+)*$";
                        String check = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
                        Pattern regex = Pattern.compile ( check );
                        Matcher matcher = regex.matcher ( param.get ( "DivEmil" ).toString () );
                        if (matcher.matches () == false) {
                            map.put ( "DivEmil", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_22, "", langValue ) );
                        }
                    }

                    if (StringUtils.isEmpty ( param.get ( "Divdv" ).toString () )) {
                        map.put ( "Divdv", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_16, "", langValue ) );
                    } else if (StringUtils.isEmpty ( param.get ( "Divjyr" ).toString () )) {
                        map.put ( "Divjyr", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_17, "", langValue ) );
                    } else if (StringUtils.isEmpty ( param.get ( "Divjyr" ).toString () )) {
                        map.put ( "Divjyr", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_17, "", langValue ) );
                    } else if (StringUtils.isEmpty ( param.get ( "DivTel" ).toString () )) {
                        map.put ( "DivTel", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_18, "", langValue ) );
                    } else {
                        String bm = null, emil = null;
                        if (param.get ( "Divbm" ) == null || "".equals ( param.get ( "Divbm" ) )) {
                            bm = "-";
                        } else {
                            bm = param.get ( "Divbm" ).toString ();
                        }
                        if (param.get ( "DivEmil" ) == null || "".equals ( param.get ( "DivEmil" ) )) {
                            emil = "-";
                        } else {

                            emil = param.get ( "DivEmil" ).toString ();
                        }

                        //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                        String teams = param.get ( "Divdv" ).toString () + "#" + bm + "#" + param.get ( "Divjyr" ).toString () + "#" + param.get ( "DivTel" ).toString () + "#" + emil + "#";
                        //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                        entity.setApplyUser ( teams );
                        entity.setApplyID ( param.get ( "Divjyr" ).toString () );
                    }
                    //除借用外
                } else {
                    //申领人
                    if (StringUtils.isEmpty ( userID )) {
                        map.put ( "DIVapplyUser", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_08, "", langValue ) );
                    } else {
                        //申领人
                        //申请人姓名
                        entity.setApplyUser ( reCu.getUserName () );
                        //申领人ID
                        entity.setApplyID ( userID );
                        entity.setReplacementReason ( param.get ( "DIVreissueReason" ).toString () );
                        //申请人部门
                        entity.setDepartmentID ( reCu.getUserPass () );
                        entity.setVersion ( new BigDecimal ( IConstant.GRINDING_0 ) );
                        entity.setProcessingStatus ( IConstant.STRING_9 );
                        entity.setExpandSpace1 ( "一汽大众" );
                    }
                }

                //			补领时间
                if (StringUtils.isEmpty ( param.get ( "DIVtime" ).toString () )) {
                    map.put ( "DIVtime", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_06, "", langValue ) );
                } else {
                    String ghfg = param.get ( "DIVtime" ).toString ();
                    DateFormat format1 = new SimpleDateFormat ( "HH:mm:ss" );
                    Date date1 = new Date ();
                    ghfg += " " + format1.format ( date1 );
                    entity.setApplyTime ( Ctl.strToDate ( ghfg ) );
                }

                //数量
                if (StringUtils.isEmpty ( param.get ( "DivBorrowNum" ).toString () )) {
                    map.put ( "DivBorrowNum", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_03, "", langValue ) );
                } else if (Ctl.checkString ( 0, param.get ( "DivBorrowNum" ).toString () )) {
                    if (param.get ( "DivBorrowNum" ).toString ().length () <= 6) {
                        entity.setAppliedNumber ( new BigDecimal ( param.get ( "DivBorrowNum" ).toString () ) );
                        entity.setAppliedTotalNumber ( new BigDecimal ( param.get ( "DivBorrowNum" ).toString () ) );
                    } else {
                        map.put ( "DivBorrowNum", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_14, "", langValue ) );
                    }

                } else {
                    map.put ( "DivBorrowNum", MessageReSource.getMessageBox ( IConstant.ERROR_MSG_11, "", langValue ) );
                }
                //领取人

                entity.setReceiveUser ( userID );

                // 如果是编辑
                if (map.size () <= 0) {
                    entity.setUpdateUser ( userID );
                    //2017/11/14 王冉 变更↓↓↓　dazhong@YMSC
                    //entity.setApplyTime ( new Date () );
                    String ghfg = param.get ( "DIVtime" ).toString ();
                    DateFormat format1 = new SimpleDateFormat ( "HH:mm:ss" );
                    Date date1 = new Date ();
                    ghfg += " " + format1.format ( date1 );
                    entity.setApplyTime ( Ctl.strToDate ( ghfg ) );
                    //2017/11/14 王冉 变更↑↑↑　dazhong@YMSC
                    entity.setUpdateTime ( new Date () );

                } else {
                    rtn.put ( "message", map );
                }
            }

            rtn.put ( "data", entity );
            rtn.put ( "status", IConstant.RESULT_CODE_2 );


        } catch (SQLException e) {
            Replacement replacement = new Replacement ();
            //错误消息：数据库操作异常，查询失败!
            replacement.setMessageCode ( IConstant.EMSG0004 );
            replacement.setRetErrFlag ( true );
            replacement.setExceMessage ( e.getMessage () );
            rtn.put ( "data", null );
            rtn.put ( "error", replacement );
        }

        return rtn;
    }

    @Override
    public Map<String, Object> getprintItemInfo(Vreplacement entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Vreplacement> list = (List<Vreplacement>) replacementDao.searchByList ( entity );

            if (list.size () <= 0) {
                Vreplacement vreplacement = new Vreplacement ();
                //消息：检索为0
                vreplacement.setMessageCode ( IConstant.EMSG0001 );
                vreplacement.setRetErrFlag ( true );
                rtn.put ( "data", null );
                rtn.put ( "error", vreplacement );
                return rtn;
            } else {
                rtn.put ( "data", list.get ( 0 ) );
                return rtn;
            }

        } catch (SQLException e) {
            Vreplacement vreplacement = new Vreplacement ();
            //错误消息：数据库操作异常，查询失败!
            vreplacement.setMessageCode ( IConstant.EMSG0004 );
            vreplacement.setRetErrFlag ( true );
            vreplacement.setExceMessage ( e.getMessage () );
            rtn.put ( "data", null );
            rtn.put ( "error", vreplacement );
            return rtn;
        }
    }

    @Override
    public Map<String, Object> printEdit(Replacement replacement, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            // 删除失败! 进行数据排他验证
            Replacement entity = new Replacement ();
            List<Replacement> list = (List<Replacement>) replacementDaos.searchByList ( entity );
            if (list == null || list.size () == 0) {
                entity = new Replacement ();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode ( IConstant.WMSG0009 );
                entity.setRetErrFlag ( true );
                rtn.put ( "error", entity );
                rtn.put ( "data", null );
            }
            // 更新项目打印成功
            @SuppressWarnings("unused")
            int ret = replacementDaos.updateNonQuery ( replacement );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0005, langCode, langValue ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );


        } catch (SQLException e) {
            Replacement entity = new Replacement ();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode ( IConstant.EMSG0006 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );

        }
        return rtn;
    }

    @Override
    public List<Vapplyuser> getUsList() {
        List<Vapplyuser> list = null;
        try {
            Vapplyuser entity = new Vapplyuser ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            list = (List<Vapplyuser>) vapplyuserDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vapplyuser> ();
                Vapplyuser vapplyuser = new Vapplyuser ();
                // 消息：检索为0
                vapplyuser.setMessageCode ( IConstant.EMSG0001 );
                vapplyuser.setRetErrFlag ( false );
                list.add ( vapplyuser );
            }
            return list;
        } catch (SQLException e) {
            list = new ArrayList<Vapplyuser> ();
            Vapplyuser vapplyuser = new Vapplyuser ();
            // 错误消息：数据库操作异常，查询失败!
            vapplyuser.setMessageCode ( IConstant.EMSG0004 );
            vapplyuser.setRetErrFlag ( true );
            vapplyuser.setExceMessage ( e.getMessage () );
            list.add ( vapplyuser );

        }
        return list;
    }

    @Override
    public List<Vapplyuser> getVapplyuser(Vapplyuser entity) {
        try {

            List<Vapplyuser> list = (List<Vapplyuser>) vapplyuserDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Vapplyuser> ();
                Vapplyuser vapplyuser = new Vapplyuser ();
                vapplyuser.setMessageCode ( IConstant.WMSG0008 );
                vapplyuser.setRetErrFlag ( false );
                list.add ( vapplyuser );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vapplyuser> list = new ArrayList<Vapplyuser> ();
            Vapplyuser vapplyuser = new Vapplyuser ();
            vapplyuser.setMessageCode ( IConstant.EMSG0004 );
            vapplyuser.setRetErrFlag ( true );
            vapplyuser.setExceMessage ( e.getMessage () );
            list.add ( vapplyuser );
            return list;
        }
    }

    @Override
    public List<Vreplacement> getVrpList() {
        List<Vreplacement> list = null;
        try {
            Vreplacement entity = new Vreplacement ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            list = (List<Vreplacement>) replacementDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vreplacement> ();
                Vreplacement vreplacement = new Vreplacement ();
                // 消息：检索为0
                vreplacement.setMessageCode ( IConstant.EMSG0001 );
                vreplacement.setRetErrFlag ( false );
                list.add ( vreplacement );
            }
            return list;
        } catch (SQLException e) {
            list = new ArrayList<Vreplacement> ();
            Vreplacement department = new Vreplacement ();
            // 错误消息：数据库操作异常，查询失败!
            department.setMessageCode ( IConstant.EMSG0004 );
            department.setRetErrFlag ( true );
            department.setExceMessage ( e.getMessage () );
            list.add ( department );

        }
        return list;
    }

    @Override
    public String getVappnumber() {
        int total = 0;
        try {
            total = replacementDao.searchByCount ( new Vreplacement () );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return String.valueOf ( total );
    }
}
