package com.icomp.v01b04.b04s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b04.s001.ICOMPV01B04S001Service;
import com.icomp.common.service.icomp.v01b04.s003.ICOMPV01B04S003Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Synthesistoolsmachininginfo;
import com.icomp.entity.base.Vworkloadqueries;
import com.icomp.v01b04.b04s001.business.B04S001Business;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 工作量查询BUsiness实现类
 *
 * @author Taoyy
 * @ClassName: B01S001BusinessImpl
 * @date 2014-8-20下午04:10:15
 */
public class B04S001BusinessImpl implements B04S001Business {

    /**
     * 工作量查询SERVICE
     */
    private ICOMPV01B04S001Service icompv01b04s001Service;
    private ICOMPV01B04S003Service icompv01b04s003Service;

    public void setIcompv01b04s003Service(ICOMPV01B04S003Service icompv01b04s003Service) {
        this.icompv01b04s003Service = icompv01b04s003Service;
    }

    public void setIcompv01b04s001Service(ICOMPV01B04S001Service icompv01b04s001Service) {
        this.icompv01b04s001Service = icompv01b04s001Service;
    }

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
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

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 工作量查询列表
     */ public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {

        /**
         *  设置检索条件
         */
        String dateStarStr = param.get ( "dstar" ).toString ().trim ();
        String dateEndStr = param.get ( "dend" ).toString ().trim ();

        Synthesistoolsmachininginfo entity = new Synthesistoolsmachininginfo ();
        DateFormat format = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" );
        try {
            // 申请起始时间
            if (dateStarStr != null && dateStarStr != "") {
                dateStarStr += " 00:00:00";
                entity.setDateStar ( format.parse ( dateStarStr ) );
            }
            // 申请结束时间
            if (dateEndStr != null && !("").equals ( dateEndStr )) {
                dateEndStr += " 23:59:59";
                entity.setDateEnd ( format.parse ( dateEndStr ) );
            }
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        //生产线
        entity.setAssemblyLineID ( StringUtils.isEmpty ( param.get ( "productionLine" ).toString () ) ? null : param.get ( "productionLine" ).toString () );
        //工序
        entity.setProcessID ( StringUtils.isEmpty ( param.get ( "procedure" ).toString () ) ? null : param.get ( "procedure" ).toString () );
        //加工设备
        entity.setEquipmentID ( StringUtils.isEmpty ( param.get ( "equipment" ).toString () ) ? null : param.get ( "equipment" ).toString () );
        //轴编号
        entity.setAxleID ( StringUtils.isEmpty ( param.get ( "axisNumber" ).toString () ) ? null : param.get ( "axisNumber" ).toString () );
        //机型
        entity.setPartsID ( StringUtils.isEmpty ( param.get ( "model" ).toString () ) ? null : param.get ( "model" ).toString () );
        //合成刀具编码
        entity.setSynthesisParametersCode ( StringUtils.isEmpty ( param.get ( "toolCode" ).toString () ) ? null : param.get ( "toolCode" ).toString () );
        //卸下原因
        entity.setRemoveReason ( StringUtils.isEmpty ( param.get ( "removeReason" ).toString () ) ? null : param.get ( "removeReason" ).toString () );
        entity.setOrderString ( "OuterTime desc" );
        //时间

        if (param.get ( "ecxel" ) == null) {
            // 分页起始行数
            entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
            // 分页页数
            entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
        }

        Map<String, Object> rtn = icompv01b04s003Service.getList1 ( entity );
        //

        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Synthesistoolsmachininginfo>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
    }

    @Override
    public Map<String, Object> getAssemblyLineList(String langCode, String langValue) {
        // 流水线查询列表
        Vworkloadqueries entity = new Vworkloadqueries ();
        Map<String, Object> rtn = icompv01b04s001Service.getAssemblyLineNameList ( entity );
        return rtn;
    }

    @Override
    public Map<String, Object> getProcessNameList(String langCode, String langValue) {
        // 流水线查询列表
        Vworkloadqueries entity = new Vworkloadqueries ();
        Map<String, Object> rtn = icompv01b04s001Service.getProcessNameList ( entity );
        return rtn;
    }

}
