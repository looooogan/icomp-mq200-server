package com.icomp.common.timer;

import com.icomp.common.constant.IConstant;
import com.icomp.common.sap.SAPTools;
import com.icomp.common.utils.DateFormatUtil;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.WerkzeugeanforderunDao;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Werkzeugeanforderun;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务页，在本页配置定时任务-每晚0.30执行。
 */
public class SynSAPOrderDate extends QuartzJobBean {
    private Logger logger = Logger.getLogger ( SynSAPOrderDate.class );

    //订单信息表
    private ToolprocuredDao toolprocuredDao;
    //需求订单表
    private WerkzeugeanforderunDao werkzeugeanforderunDao;

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    public void setWerkzeugeanforderunDao(WerkzeugeanforderunDao werkzeugeanforderunDao) {
        this.werkzeugeanforderunDao = werkzeugeanforderunDao;
    }

    /**
     * 要调度的具体任务
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    }

    /**
     * 定时同步SAP订单信息到该系统上
     */
    public void synSAPOrderDateByTime() {
        try {
            Map<String, String> map = new HashMap<> ();
            System.out.println ( "定时执行同步SAP订单信息--" + DateFormatUtil.dateToString ( new Date (), 1 ) );
            List<String> orders = new ArrayList<> ();
            //所有的订单详情
            List<Toolprocured> tpList = new ArrayList<> ();
            List<Toolprocured> insertList = new ArrayList<> ();
            List<Werkzeugeanforderun> updateList = new ArrayList<> ();
            Werkzeugeanforderun wer = null;
            String order = null;
            //查询需求单号-只查询未全到货的信息
            List<Werkzeugeanforderun> reWer = werkzeugeanforderunDao.findNoDemandCode ();
            for (Werkzeugeanforderun we : reWer) {

                //通过需求单号查询订单号
                order = SAPTools.getOrderNoByMumber ( we.getDemandCode () );
                if (StringUtils.isEmpty ( order )) {
                    continue;
                } else {
                    map.put ( order, we.getDemandCode () );
                    orders.add ( order );
                }
            }
            //根据订单号查询订单详情
            for (String ord : orders) {
                tpList.addAll ( SAPTools.getPoFromSAP ( ord ) );
            }
       /*     //查询到订单详情表中未入库的信息
            List<Toolprocured> tableList = toolprocuredDao.findListByNoLib ();*/
            Toolprocured param = null;
            for (Toolprocured stp : tpList) {
                param = new Toolprocured ();
                //where
                param.setToolsOrdeNOWhere ( stp.getToolsOrdeNO () );
                param.setToolCodeWhere ( stp.getToolCode () );
                //set
                //采购日期
                param.setProcuredTime ( stp.getProcuredTime () );
                //采购单价
                param.setUnitPrice ( stp.getUnitPrice () );
                //采购者
                if (StringUtils.isEmpty ( stp.getProcuredUser () )) {
                    param.setProcuredUser ("" );
                } else {
                    param.setProcuredUser ( stp.getProcuredUser () );
                }
                //采购数量
                param.setProcuredCount ( stp.getProcuredCount () );
                param.setUpdateTime ( new Date () );
                //	如有的则进行更新（根据订单号和材料号）
                int updatCount = toolprocuredDao.updateNonQuery ( param );
                if (updatCount < 1) {
                    insertList.add ( stp );
                }
                if (stp.getProcuredCount () == null) {
                    stp.setProcuredCount ( BigDecimal.ZERO );
                }
                //到货数量大于等于订单数量时
                String delCount = stp.getExpandSpace1 ();
                if (StringUtils.isEmpty ( delCount ) || "null".equals ( delCount )) {
                    delCount = IConstant.STRING_0;
                }
                if (Integer.parseInt ( delCount ) >= stp.getProcuredCount ().intValue ()) {
                    wer = new Werkzeugeanforderun ();
                    String key = stp.getToolsOrdeNO ();
                    wer.setDemandCodeWhere ( map.get ( key ) );
                    // //采购类型(0新采购1外委图层2外委复磨9其他)
                    String procuredTyep = stp.getProcuredType ();
                    String toolCode = stp.getToolCode ();
                    if (IConstant.STRING_1.equals ( procuredTyep )) {
                        toolCode = toolCode + "T";
                    } else if (IConstant.STRING_2.equals ( procuredTyep )) {
                        toolCode = toolCode + "X";
                    }
                    wer.setMaterialNrWhere ( toolCode );
                    //到货状态（0未全到货，1全部到货）
                    wer.setDelFlag ( IConstant.DEL_FLAG_1 );
                    //通过到货数量修改需求单的状态
                    werkzeugeanforderunDao.updateNonQuery ( wer );
                }
            }
            //	没有的直接新增
            if (insertList.size () > 0) {
                toolprocuredDao.batchInsert ( insertList );
            }
        } catch (Exception e) {
            logger.info ( "synSAPOrderDateByTime--" + e.toString () );
        }
    }
}