package com.icomp.v01b07.b07s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s001.ICOMPV01B07S001Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Werkzeugeanforderun;
import com.icomp.v01b07.b07s001.business.B07S001Business;

import org.apache.commons.collections.map.HashedMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在途计划报警BUsiness实现类
 *
 * @author Taoyy
 * @ClassName: B07S001BusinessImpl
 * @date 2014-9-18 下午03:51:58
 */

public class B07S001BusinessImpl implements B07S001Business {
    GregorianCalendar gc = new GregorianCalendar ();
    SimpleDateFormat sf = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
    /**
     * 系统初始化Service
     */
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 在途计划报警查询SERVICE
     */
    private ICOMPV01B07S001Service icompv01b07s001Service;

    public void setIcompv01b07s001Service(ICOMPV01B07S001Service icompv01b07s001Service) {
        this.icompv01b07s001Service = icompv01b07s001Service;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        /**
         * 设置检索条件
         */
        Werkzeugeanforderun entity = new Werkzeugeanforderun ();

        // 分页起始行数
        entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
        // 分页页数
        entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );
        // 排序
        entity.setOrderString ( "UpdateTime desc" );
        // 在途计划报警查询列表
        Map<String, Object> rtn = icompv01b07s001Service.getList1 ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Werkzeugeanforderun>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
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
    public Map<String, Object> dbWerforderun(List<Werkzeugeanforderun> infos, String langCode, String langValue, String userID) throws BusinessException {
        Map<String, Object> sMap = new HashMap<String, Object> ();
    //    List<Werkzeugeanforderun> insertList = new ArrayList<Werkzeugeanforderun> ();

        int werUpdate = 0;
        List<String> demandCodes = new ArrayList<String> ();
  //      List<Werkzeugeanforderun> werList = null;
       // Map<String, Object> werMap = new HashMap<String, Object> ();
        try {
            //取得表格中所有的需求单号
            for (Werkzeugeanforderun info : infos) {
                info.setCreateUser ( userID );
                info.setUpdateUser ( userID );
                if (demandCodes.contains ( info.getDemandCode () )) {
                    continue;
                } else {
                    demandCodes.add ( info.getDemandCode () );
                }
            }
            Map<String, Object> param = new HashedMap ();
            param.put ( "demandCodes", demandCodes );
            param.put ( "infos", infos );
          sMap =   icompv01b07s001Service.dbWerforderun (param);


            //数据库的数据
   /*    //     werList = icompv01b07s001Service.getWerList ();

            //把数据库的所有需求号放入list
            for (Werkzeugeanforderun dbStr : werList) {
                demandCodes.add ( dbStr.getDemandCode () );
            }
            //上传表格中的数据
            for (Werkzeugeanforderun infoDate : infos) {
                if (true == demandCodes.contains ( infoDate.getDemandCode () )) {
                    //如果当前list包含当前需求号
                    werMap.put ( infoDate.getDemandCode (), infoDate );

                } else {
                    insertList.add ( infoDate );
                }
            }
            if (werMap.size () > 0) {
                werUpdate = icompv01b07s001Service.getUpdate ( werMap );

            }
            if (insertList.size () > 0) {
                icompv01b07s001Service.werkAdd ( insertList );
            }

            sMap.put ( "list", insertList );
            sMap.put ( "total", werUpdate );

            Toolprocured toolEntiy = new Toolprocured ();
            //查询订单表中的所有数据
            List<Toolprocured> toolpList = icompv01b07s001Service.getToolpro ();
            List<String> tpList = new ArrayList<String> ();
            //订单表里批次号放入新建list里
            for (Toolprocured tp : toolpList) {
                tpList.add ( tp.getProcuredBatch () );
            }

            for (Werkzeugeanforderun werslists : infos) {
                if (tpList.contains ( werslists.getDemandCode () )) {
                    //如果存在 更新
                    int C = icompv01b07s001Service.getupdateTool ( werslists );
                    continue;
                } else {

                    String toolpdID = UUIDgen.getId ();
                    toolEntiy.setToolProcuredID ( toolpdID );
                    //材料号
                    toolEntiy.setToolCode ( werslists.getMaterialNr () );
                    //订单号
                    toolEntiy.setToolsOrdeNO ( werslists.getDemandCode () );
                    //批次号
                    toolEntiy.setProcuredBatch ( werslists.getDemandCode () );
                    //采购日期d
                    toolEntiy.setProcuredTime ( Ctl.dateFormat ( werslists.getTypingDate () ) );
                    //采购单价
                    toolEntiy.setUnitPrice ( werslists.getUnitPreis () );
                    //
                    toolEntiy.setProcuredCount ( werslists.getMenge () );
                    //是否入库
                    toolEntiy.setProcuredInto ( IConstant.PROCURED_TYPE_1 );
                    //是否付费
                    toolEntiy.setProcuredPaying ( IConstant.PROCURED_PAYING_9 );
                    //更新时间
                    toolEntiy.setUpdateTime ( new Date () );
                    //采购类型
                    String wer = werslists.getMaterialNr ();
                    if ("X".equalsIgnoreCase ( wer.substring ( wer.length () - 1 ) )) {
                        toolEntiy.setProcuredType ( IConstant.PROCURED_TYPE_0 );
                    } else {
                        toolEntiy.setProcuredType ( IConstant.PROCURED_TYPE_1 );
                    }
                    toolEntiy.setDelFlag ( IConstant.DEL_FLAG_0 );
                    toolEntiy.setCreateUser ( userID );
                    toolEntiy.setCreateTime ( new Date () );
                    toolEntiy.setUpdateTime ( new Date () );
                    //                    采购数量
                    toolEntiy.setProcuredNumber ( werslists.getMenge () );
                    icompv01b07s001Service.toolproAdd ( toolEntiy );
                }

            }
*/

        } catch (Exception e) {
            System.out.println ( "----------------------" + e.toString () );
        }
        return sMap;
    }

    @Override
    public Map<String, Object> werDelete(Map<String, Object> parm) throws BusinessException {
        Werkzeugeanforderun werkzeugeanforderun = new Werkzeugeanforderun ();
        if (parm.get ( "demandCode" ) != null) {
            werkzeugeanforderun.setDemandCodeWhere ( parm.get ( "demandCode" ).toString () );
        }
        if (parm.get ( "materialNr" ) != null) {
            werkzeugeanforderun.setMaterialNrWhere ( parm.get ( "materialNr" ).toString () );
        }

        Map<String, Object> ret = icompv01b07s001Service.werDelete ( werkzeugeanforderun );
        return ret;

    }

}
