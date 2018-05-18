package com.icomp.v01b06.b06s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s002.ICOMPV01B06S002Service;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b06.b06s002.business.B06S002Business;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加工异常分析BUSINESS实现类
 *
 * @author Taoyy
 * @ClassName: B01S002BusinessImpl
 * @date 2014-8-14 下午02:02:34
 */
public class B06S002BusinessImpl implements B06S002Business {

    /**
     * 系统初始化Service
     */
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 加工异常分析SERVICE
     */
    private ICOMPV01B06S002Service icompv01b06s002Service;

    public void setIcompv01b06s002Service(ICOMPV01B06S002Service icompv01b06s002Service) {
        this.icompv01b06s002Service = icompv01b06s002Service;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 加工异常分析列表
     */ public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue, int checkType) throws BusinessException {
        //Vanalysisabnormalprocessing entity = new Vanalysisabnormalprocessing();
        Vanalysis entity = new Vanalysis ();
        String dateStarStr = null;
        String dateEndStr = null;
        if (param.get ( "dstar" ) != null) {
            dateStarStr = String.valueOf ( param.get ( "dstar" ) ).trim ();
        }
        if (param.get ( "dend" ) != null) {
            dateEndStr = String.valueOf ( param.get ( "dend" ) ).trim ();
        }

        DateFormat format = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" );
        try {
            // 申请起始时间
            if (dateStarStr != null && dateStarStr != "") {
                dateStarStr += " 00:00:00";
                entity.setDateStar ( format.parse ( dateStarStr ) );
            }
            // 申请结束时间
            if (dateEndStr != null && dateEndStr != "") {
                dateEndStr += " 23:59:59";
                entity.setDateEnd ( format.parse ( dateEndStr ) );
            }
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        /**
         *  设置检索条件
         */
        //合成刀具编码
//        String ToolConsumetype = (String) param.get ( "ToolConsumetype" );
//        entity.setToolType ( StringUtils.isEmpty ( ToolConsumetype ) ? null : ToolConsumetype );
        entity.setToolCode ( StringUtils.isEmpty ( param.get ( "systeCode" ).toString () ) ? null : param.get ( "systeCode" ).toString () );
        entity.setRemoveReason ( StringUtils.isEmpty ( param.get ( "abnormal" ).toString () ) ? null : param.get ( "abnormal" ).toString () );
        entity.setOuterUser ( StringUtils.isEmpty ( param.get ( "operator" ).toString () ) ? null : param.get ( "operator" ).toString () );
        entity.setEmpCard ( StringUtils.isEmpty ( param.get ( "operator" ).toString () ) ? null : param.get ( "operator" ).toString () );
        entity.setProcessID ( StringUtils.isEmpty ( param.get ( "aprocess" ).toString () ) ? null : param.get ( "aprocess" ).toString () );
        entity.setPartsID ( StringUtils.isEmpty ( param.get ( "spareParts" ).toString () ) ? null : param.get ( "spareParts" ).toString () );
        entity.setLineID ( StringUtils.isEmpty ( param.get ( "line" ).toString () ) ? null : param.get ( "line" ).toString () );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );

        if (checkType == 1) {
            //分页起始行数
            entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
            //分页页数
            entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
            //排序
            entity.setOrderString ( "OuterTime desc" );


        } else if (checkType == 2) {
            entity.setStaIndex ( 0 );
            entity.setRowCount ( 3000 );
        }
        //加工异常分析列表-SynthesisParametersCode模糊查询
        Map<String, Object> rtn = icompv01b06s002Service.getLists ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Vanalysis>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
    }

    @Override
    /**
     * 加工异常分析统计数量
     */ public String getStatisticalCount(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        Vanalysis entity = new Vanalysis ();
        String dateStarStr = null;
        String dateEndStr = null;
        if (param.get ( "dstar" ) != null) {
            dateStarStr = String.valueOf ( param.get ( "dstar" ) ).trim ();
        }
        if (param.get ( "dend" ) != null) {
            dateEndStr = String.valueOf ( param.get ( "dend" ) ).trim ();
        }

        DateFormat format = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" );
        try {
            // 申请起始时间
            if (dateStarStr != null && dateStarStr != "") {
                dateStarStr += " 00:00:00";
                entity.setDateStar ( format.parse ( dateStarStr ) );
            }
            // 申请结束时间
            if (dateEndStr != null && dateEndStr != "") {
                dateEndStr += " 23:59:59";
                entity.setDateEnd ( format.parse ( dateEndStr ) );
            }
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        /**
         *  设置检索条件
         */
        //合成刀具编码
        String ToolConsumetype = (String) param.get ( "ToolConsumetype" );
        entity.setToolType ( StringUtils.isEmpty ( ToolConsumetype ) ? null : ToolConsumetype );
        entity.setToolCode ( StringUtils.isEmpty ( param.get ( "systeCode" ).toString () ) ? null : param.get ( "systeCode" ).toString () );
        entity.setRemoveReason ( StringUtils.isEmpty ( param.get ( "abnormal" ).toString () ) ? null : param.get ( "abnormal" ).toString () );
        entity.setOuterUser ( StringUtils.isEmpty ( param.get ( "operator" ).toString () ) ? null : param.get ( "operator" ).toString () );
        entity.setEmpCard ( StringUtils.isEmpty ( param.get ( "operator" ).toString () ) ? null : param.get ( "operator" ).toString () );
        entity.setProcessID ( StringUtils.isEmpty ( param.get ( "aprocess" ).toString () ) ? null : param.get ( "aprocess" ).toString () );
        entity.setPartsID ( StringUtils.isEmpty ( param.get ( "spareParts" ).toString () ) ? null : param.get ( "spareParts" ).toString () );
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        //排序
        entity.setOrderString ( "toolType" );
        return icompv01b06s002Service.getStatisticalCount ( entity );
    }

    @Override
    public List<Parts> getPartsListById(String id) {
        List<Parts> partsList = icompv01b06s002Service.getPartsListById (id);
        return partsList;
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
    public Map<String, Object> getPPList() throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();

        //取得工序
        List<Process> processList = icompv01b06s002Service.getProcess ();
        if (processList.size () > 0 && processList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( processList.get ( 0 ).getMessageCode (), "", "" );
        }
        ret.put ( "ProcessList", processList );

        //取得零部件
        List<Parts> partsList = icompv01b06s002Service.getParts ();
        if (partsList.size () > 0 && partsList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( partsList.get ( 0 ).getMessageCode (), "", "" );
        }
        ret.put ( "PatrsList", partsList );


        /* 2017/07/03 宋健 追加↓↓↓　dazhong@YMSC */
        //取得生产线
        List<Assemblyline> assemblylineList = icompv01b06s002Service.getAssemblyline();
        if (assemblylineList.size () > 0 && assemblylineList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( assemblylineList.get ( 0 ).getMessageCode (), "", "" );
        }
        ret.put ( "AssemblylineList", assemblylineList );
        /* 2017/07/03 宋健 追加↑↑↑　dazhong@YMSC */

        return ret;
    }

    @Override
    public String getNumber() throws BusinessException {
        return icompv01b06s002Service.getNumber ();
    }

}
