package com.icomp.v01b01.b01s005.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b01.s005.ICOMPV01B01S005Service;
import com.icomp.entity.base.*;
import com.icomp.v01b01.b01s005.business.B01S005Business;

import org.apache.commons.lang3.StringUtils;

import java.lang.System;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B01S005BusinessImpl implements B01S005Business {

    /**
     * 系统初始化SERVICE
     */
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 申请信息查询SERVICES
     */
    private ICOMPV01B01S005Service icompv01b01s005Service;

    public void setIcompv01b01s005Service(ICOMPV01B01S005Service icompv01b01s005Service) {
        this.icompv01b01s005Service = icompv01b01s005Service;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 申请信息列表
     */ public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue, int chey) throws BusinessException {
        String dateStar = null;
        String dateEnd = null;
        if (param.get ( "dstar" ) != null) {
            dateStar = String.valueOf ( param.get ( "dstar" ) ).trim ();
        }
        if (param.get ( "dends" ) != null) {
            dateEnd = String.valueOf ( param.get ( "dends" ) ).trim ();
        }
        /**
         * 设置检索条件
         */
        Vreplacement entity = new Vreplacement ();
        //		Replacement entity = new Replacement();
        DateFormat format = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" );

        try {
            // 申请起始时间
            if (dateStar != null && !"".equals ( dateStar )) {
                dateStar += " 00:00:00";
                entity.setDateStar ( format.parse ( dateStar ) );
            }
            // 申请结束时间
            if (dateEnd != null && !"".equals ( dateEnd )) {
                dateEnd += " 23:59:59";
                entity.setDateEnd ( format.parse ( dateEnd ) );
            }
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        //借还状态StockState
        if (param.get ( "reissueReason" ) != null) {
            entity.setReplacementReason ( StringUtils.isEmpty ( param.get ( "reissueReason" ).toString () ) ? null : param.get ( "reissueReason" ).toString () );
        }
        //申领人ApplyUser
        entity.setApplyID ( StringUtils.isEmpty ( param.get ( "applyPerson" ).toString () ) ? null : param.get ( "applyPerson" ).toString () );
        //领用部门
        entity.setDepartmentID ( StringUtils.isEmpty ( param.get ( "receiveDepartment" ).toString () ) ? null : param.get ( "receiveDepartment" ).toString () );
        //归还状态
        entity.setStockState ( StringUtils.isEmpty ( param.get ( "returnStatus" ).toString () ) ? null : param.get ( "returnStatus" ).toString () );
        //领取人（经办人）
        entity.setReceiveUser ( StringUtils.isEmpty ( param.get ( "operator" ).toString () ) ? null : param.get ( "operator" ).toString () );
        entity.setEmpCard ( StringUtils.isEmpty ( param.get ( "operator" ).toString () ) ? null : param.get ( "operator" ).toString () );
        //补领原因
        entity.setReplacementReason ( StringUtils.isEmpty ( param.get ( "reissueReason" ).toString () ) ? null : param.get ( "reissueReason" ).toString () );
        // 材料号
        entity.setToolCode ( StringUtils.isEmpty ( param.get ( "systeCode" ).toString () ) ? null : param.get ( "systeCode" ).toString () );

        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        if (chey == 1) {

            // 分页起始行数
            entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
            // 分页页数
            entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
        } else {
            entity.setStaIndex ( IConstant.RESULT_CODE_0 );
            entity.setRowCount ( 30000 );
        }

        // 排序
        entity.setOrderString ( "ApplyTime DESC" );
        // 申请信息列表
        Map<String, Object> rtn = icompv01b01s005Service.getList ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Vreplacement>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
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

        // 取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun ( pageID, langCode, IConstant.ITEM_TYPE_1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 取得失败时，返回
            throw new BusinessException ( ((List<Displayeditemconfiguration>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    @Override
    public Map<String, Object> replacementAdd(Map<String, Object> param, String langCode, String langValue, String userID) throws BusinessException {
        //补领输入验证
        Map<String, Object> ret = icompv01b01s005Service.checkInput ( param, langValue, userID, 1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Vreplacement) ret.get ( "error" )).getMessageCode (), "", langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        Replacement replacement = (Replacement) ret.get ( "data" );

        //保存补领信息
        ret = icompv01b01s005Service.replaceAdd ( replacement, langCode, langValue );
        if (ret.size () > 0 && ret.get ( "error" ) != null) {
            //新建失败时，返回
            throw new BusinessException ( ((Replacement) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    /**
     * 取得页面下拉列表内容
     *
     * @param langCode
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();
        //取得零部件列表
        List<Department> departmentList = icompv01b01s005Service.getPartsLine ();
        List<Vreplacement> vrpList = icompv01b01s005Service.getVrpList ();
        if (departmentList.size () > 0 && departmentList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( departmentList.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        ret.put ( "DepartmentList", departmentList );
        ret.put ( "Vreplacement", vrpList );

        return ret;
    }

    private Map<String, Object> checkInput(Map<String, Object> param, int checkType) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        // 页面输入项目验证
        Map<String, String> map = new HashMap<String, String> ();
        if (checkType == 1)
            ;
        if (StringUtils.isEmpty ( param.get ( "DIVreplacementID" ).toString () )) {// 如果补领单号未输入
            map.put ( "DIVreplacementID", IConstant.ERROR_MSG_01 );
        }
        if (StringUtils.isEmpty ( param.get ( "DIVsysteCode" ).toString () )) {//如果补领单号未输入
            map.put ( "DIVsysteCode", IConstant.ERROR_MSG_02 );
        }
        if (StringUtils.isEmpty ( param.get ( "DIV_DepartmentID" ).toString () )) {//如果刀具类型未选
            map.put ( "DIV_DepartmentID", IConstant.ERROR_MSG_03 );
        }

        if (StringUtils.isEmpty ( param.get ( "DIVreissueReason" ).toString () )) {//如果补领原因未选
            map.put ( " DIVreissueReason", IConstant.ERROR_MSG_04 );
        }
        if (StringUtils.isEmpty ( param.get ( "DIVreturnStatus" ).toString () )) {//如果借用归还状态未选
            map.put ( " DIVreturnStatus", IConstant.ERROR_MSG_05 );
        }

        if (StringUtils.isEmpty ( param.get ( "DIVtime" ).toString () )) {//如果补领时间未选
            map.put ( " DIVtime", IConstant.ERROR_MSG_06 );
        }
        if (StringUtils.isEmpty ( param.get ( "DIVreceiveDepartment" ).toString () )) {//如果补领单位未选
            map.put ( " DIVreceiveDepartment", IConstant.ERROR_MSG_07 );
        }

        if (map.size () > 0) {
            rtn.put ( IConstant.MESSAGE_STR, map );
            rtn.put ( IConstant.STATUS_STR, IConstant.RESULT_CODE_STR_3 );
        }
        return rtn;
    }

    @Override
    public Map<String, Object> replacementEdit(Map<String, Object> param, String langCod, String langValue, String userID) throws BusinessException {
        //编辑验证
        System.out.println ( userID );
        Map<String, Object> ret = icompv01b01s005Service.checkInput ( param, langValue, userID, 2 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            throw new BusinessException ( ((Vreplacement) ret.get ( "error" )).getMessageCode (), "", langValue );
        } else if (ret.size () > 1 && ret.get ( "message" ) != null) {
            return ret;
        }
        Replacement entity = (Replacement) ret.get ( "data" );
        //保存编辑内容
        ret = icompv01b01s005Service.printEdit ( entity, langCod, langValue );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //新建失败时，返回
            throw new BusinessException ( ((Replacement) ret.get ( "error" )).getMessageCode (), "", langValue );
        }
        return ret;
    }

    @Override
    public Map<String, Object> printItemInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();
        System.out.println ( param.get ( "replacementID" ).toString () );
        String replacementID = param.get ( "replacementID" ).toString ();
        //取得待编辑用户信息
        Vreplacement entity = new Vreplacement ();
        entity.setReplacementID ( replacementID );
        ret = icompv01b01s005Service.getprintItemInfo ( entity );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            //检索错误时，返回
            throw new BusinessException ( ((Replacement) ret.get ( "error" )).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    @Override
    public Map<String, Object> getUserList(String langCode, String langValue) throws BusinessException {

        Map<String, Object> ret = new HashMap<String, Object> ();
        //取得零部件列表
        List<Vapplyuser> usList = icompv01b01s005Service.getUsList ();
        if (usList.size () > 0 && usList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( usList.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        ret.put ( "UserList", usList );
        return ret;
    }

    @Override
    public List<Vapplyuser> getVapplyuser(String cuID, String delFlag0, String langCode, String langValue, int i) throws BusinessException {
        Vapplyuser entity = new Vapplyuser ();

        entity.setDepartmentID ( cuID );

        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        List<Vapplyuser> list = icompv01b01s005Service.getVapplyuser ( entity );
        if (list.size () == 1 && list.get ( 0 ).isRetErrFlag ()) {
            throw new BusinessException ( list.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return list;
    }

    @Override
    public String getNumber() throws BusinessException {
        return icompv01b01s005Service.getVappnumber ();
    }
}
