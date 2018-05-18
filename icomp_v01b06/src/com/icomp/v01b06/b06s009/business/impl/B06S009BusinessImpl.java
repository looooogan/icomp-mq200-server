package com.icomp.v01b06.b06s009.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b06.s009.ICOMPV01B06S009Service;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b06.b06s009.business.B06S009Business;

import org.apache.cxf.common.util.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成本摊销BUsiness实现类
 *
 * @author Taoyy
 * @ClassName: B06S009BusinessImpl
 * @date 2014-8-22 上午09:10:39
 */

public class B06S009BusinessImpl implements B06S009Business {

    /**
     * 系统初始化Service
     */
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 成本摊销SERVICES
     */
    public ICOMPV01B06S009Service icompv01b06s009Service;

    public void setIcompv01b06s009Service(ICOMPV01B06S009Service icompv01b06s009Service) {
        this.icompv01b06s009Service = icompv01b06s009Service;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue, int checkType) throws BusinessException {
        String dateStar = param.get ( "dstar" ).toString ().trim ();
        String dateEnd = param.get ( "dend" ).toString ().trim ();
        /**
         * 设置检索条件
         */
        Vcostamortization entity = new Vcostamortization ();
        String yield = null;
        // 刀具类型
        /**
         * 设置检索条件
         */
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

        //entity.setToolType ( StringUtils.isEmpty ( param.get ( "toolConsumetype" ).toString () ) ? null : param.get ( "toolConsumetype" ).toString () );
        entity.setToolCode ( StringUtils.isEmpty ( param.get ( "systeCode" ).toString () ) ? null : param.get ( "systeCode" ).toString () );

        if (StringUtils.isEmpty ( param.get ( "yield" ).toString () )) {//产量
            throw new BusinessException ( IConstant.CBTX001, langValue, langCode );
        } else {
            yield = param.get ( "yield" ).toString ();
            entity.setProcessAmount ( new BigDecimal ( yield ) );
        }

        if(param.get("type").equals("0")){
            if (StringUtils.isEmpty ( param.get ( "spareParts" ).toString () )) {//零部件
                entity.setPartsID ( null );
            } else {
                entity.setPartsID ( param.get ( "spareParts" ).toString () );
            }
        }

        //entity.setGroupString ( "PartsName,PartsID,ToolType,ToolCode,UnitPrice,UserNumber" );
        if (checkType == 1) {
            // 分页起始行数
            entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
            // 分页页数
            entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
        } else {
            entity.setStaIndex ( 0 );
            entity.setRowCount ( 3000 );
        }

        // 排序
        //entity.setOrderString("PartsID");
        // 成本摊销列表

        Map<String, Object> rtn;
        //加工摊销
        if(param.get("type").equals("0")){
            rtn = icompv01b06s009Service.getList ( entity, yield );
        }else {
            //出入库摊销
            rtn = icompv01b06s009Service.getList2 ( entity, yield );
        }
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Vcostamortization>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
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
    public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object> ();

        //取得生产线
        List<Assemblyline> assemblylineList = icompv01b06s009Service.getAssemblyline ();
        if (assemblylineList.size () > 0 && assemblylineList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( assemblylineList.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        ret.put ( "AssemblyLineList", assemblylineList );
        //取得轴编号
        List<Axle> axleList = icompv01b06s009Service.getAxleLine ();
        if (axleList.size () > 0 && axleList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( axleList.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        ret.put ( "AxleLineList", axleList );
        //取得工序列表
        List<Process> processList = icompv01b06s009Service.getProcess ();
        if (processList.size () > 0 && processList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( processList.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        ret.put ( "ProcessList", processList );

        //取得零部件列表
        List<Parts> partsList = icompv01b06s009Service.getParts ();
        if (partsList.size () > 0 && partsList.get ( 0 ).isRetErrFlag ()) {
            //检索错误时，返回
            throw new BusinessException ( partsList.get ( 0 ).getMessageCode (), langCode, langValue );
        }
        ret.put ( "PartsList", partsList );

        return ret;
    }
}
