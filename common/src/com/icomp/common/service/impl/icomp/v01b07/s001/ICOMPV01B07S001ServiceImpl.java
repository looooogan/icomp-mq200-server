package com.icomp.common.service.impl.icomp.v01b07.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b07.s001.ICOMPV01B07S001Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.ToolalarmparamDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.VtoolprocuredsDao;
import com.icomp.dao.VtransitalarmDao;
import com.icomp.dao.WerkzeugeanforderunDao;
import com.icomp.entity.base.Toolalarmparam;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Vtransitalarm;
import com.icomp.entity.base.Werkzeugeanforderun;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在途计划报警查询SERVICE实现类
 *
 * @author Licc
 * @ClassName: ICOMPV01B01S011ServiceImpl
 * @date 2014-8-20 下午06:11:19
 */
public class ICOMPV01B07S001ServiceImpl extends BaseService implements ICOMPV01B07S001Service {
    SimpleDateFormat sf = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    @SuppressWarnings("unused")
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;
    private WerkzeugeanforderunDao werkzeugeanforderunDao;
    private ToolprocuredDao toolprocuredDao;
    private VtoolprocuredsDao vtoolprocuredsDao;

    public void setVtoolprocuredsDao(VtoolprocuredsDao vtoolprocuredsDao) {
        this.vtoolprocuredsDao = vtoolprocuredsDao;
    }

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    public void setWerkzeugeanforderunDao(WerkzeugeanforderunDao werkzeugeanforderunDao) {
        this.werkzeugeanforderunDao = werkzeugeanforderunDao;
    }

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 告警参数配置
     */
    ToolalarmparamDao toolalarmparamDao;

    public void setToolalarmparamDao(ToolalarmparamDao toolalarmparamDao) {
        this.toolalarmparamDao = toolalarmparamDao;
    }

    /**
     * 在途计划报警查询Dao
     */
    private VtransitalarmDao vtransitalarmDao;

    public void setVtransitalarmDao(VtransitalarmDao vtransitalarmDao) {
        this.vtransitalarmDao = vtransitalarmDao;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 在途计划报警查询列表
     */ public Map<String, Object> getList(Vtransitalarm entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            List<Vtransitalarm> list = (List<Vtransitalarm>) vtransitalarmDao.searchByList ( entity );
            //在途计划告警参数
            Toolalarmparam param = new Toolalarmparam ();
            param.setToolAlarmType ( IConstant.STRING_1 );
            List<Toolalarmparam> paramlist = (List<Toolalarmparam>) toolalarmparamDao.searchByList ( param );
            BigDecimal TransitPlanningAlarm = BigDecimal.ONE;
            if (list.size () <= 0) {
                list = new ArrayList<Vtransitalarm> ();
                Vtransitalarm vtransitalarm = new Vtransitalarm ();
                vtransitalarm.setMessageCode ( IConstant.EMSG0001 );
                vtransitalarm.setRetErrFlag ( true );
                list.add ( vtransitalarm );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                for (Toolalarmparam pa : paramlist) {
                    TransitPlanningAlarm = pa.getToolAlarmRatio ();
                }
            }
            if (list.size () <= 0) {
                list = new ArrayList<Vtransitalarm> ();
                Vtransitalarm vtransitalarm = new Vtransitalarm ();
                // 消息：检索为0
                vtransitalarm.setMessageCode ( IConstant.EMSG0001 );
                vtransitalarm.setRetErrFlag ( true );
                list.add ( vtransitalarm );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                //对数据进行操作
                for (Vtransitalarm v : list) {
                    //逾期天数
                    if (v.getTheyTime () != null)
                        v.setDayCount ( getTheyDays ( v.getTheyTime ().substring ( 0, 19 ) ) );
                    //是否逾期
                    if (v.getTheyTime () != null)
                        v.setRetErrFlag ( getTheyStatus ( v.getTheyTime ().substring ( 0, 19 ), TransitPlanningAlarm ) );
                    //设定预计到货时间
                    if (v.getTheyTime () != null)
                        v.setTheyTime ( v.getTheyTime ().substring ( 0, 10 ) );
                }
                int total = vtransitalarmDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            List<Vtransitalarm> list = new ArrayList<Vtransitalarm> ();
            Vtransitalarm vtransitalarm = new Vtransitalarm ();
            // 错误消息：数据库操作异常,查询失败!
            vtransitalarm.setMessageCode ( IConstant.EMSG0004 );
            vtransitalarm.setRetErrFlag ( true );
            vtransitalarm.setExceMessage ( e.getMessage () );
            list.add ( vtransitalarm );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    /**
     * 是否逾期
     *
     * @param theyTime
     * @return String
     * @title getTheyStatus
     */
    private boolean getTheyStatus(String theyTime, BigDecimal TransitPlanningAlarm) {
        //是否逾期
        boolean ret = false;
        try {
            int Ratiio = TransitPlanningAlarm.intValue ();
            int theyDays = Integer.parseInt ( getTheyDays ( theyTime ) );
            if (theyDays > Ratiio) {
                ret = true;
            }
        } catch (Exception e) {
            e.printStackTrace ();
            return ret;
        }
        return ret;
    }

    /**
     * 逾期天数
     *
     * @param theyTime
     * @return String
     * @title getTheyStatus
     */
    private String getTheyDays(String theyTime) {
        long theyDays;
        try {

            //当前时间
            long currentTime = (long) System.currentTimeMillis ();
            // 一天的秒数
            long daytime = Long.parseLong ( IConstant.DAYS_MILLI_SECOND );
            //预计到货时间
            long theTime = (long) sf.parse ( theyTime ).getTime ();
            //逾期天数 = (当前时间 - 预计到货时间)/一天的秒数
            theyDays = ((currentTime - theTime) / daytime);
        } catch (Exception e) {
            e.printStackTrace ();
            return e.toString ();
        }
        return theyDays + "";
    }

    @Override
    public List<Werkzeugeanforderun> getWerList() throws SQLException {
        return werkzeugeanforderunDao.searchByLists ();
    }

    @Override
    public int getUpdate(Map<String, Object> werMap) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        int supdata = 0;
        Werkzeugeanforderun werEntity = new Werkzeugeanforderun ();
        Werkzeugeanforderun wer = new Werkzeugeanforderun ();
        try {
            for (Map.Entry<String, Object> entry : werMap.entrySet ()) {
                System.out.println ( "key= " + entry.getKey () + " and value= " + entry.getValue () );
                //条件

                //需要修改的值map的V值
                werEntity = (Werkzeugeanforderun) entry.getValue ();
                wer.setDemandCodeWhere ( werEntity.getDemandCode () );
                wer.setMaterialNrWhere ( werEntity.getMaterialNr () );

                wer.setUnitPreis ( werEntity.getUnitPreis () );
                wer.setBestellBezeichnung ( werEntity.getBestellBezeichnung () );
                wer.setMenge ( werEntity.getMenge () );
                wer.setEinheit ( werEntity.getEinheit () );
                wer.setBetrag ( werEntity.getBetrag () );
                wer.setLieferant ( werEntity.getLieferant () );
                wer.setLiefertermin ( werEntity.getLiefertermin () );
                wer.setEinsAtzort ( werEntity.getEinsAtzort () );
                wer.setSubjectCode ( werEntity.getSubjectCode () );
                wer.setExpenseCode ( werEntity.getExpenseCode () );
                wer.setNotes ( werEntity.getNotes () );
                wer.setTypingDate ( werEntity.getTypingDate () );
                wer.setDelFlag ( werEntity.getDelFlag () );
                wer.setCreateUser ( werEntity.getCreateUser () );
                wer.setCreateTime ( werEntity.getCreateTime () );
                wer.setUpdateUser ( werEntity.getUpdateUser () );
                wer.setUpdateTime ( werEntity.getUpdateTime () );
                wer.setVersion ( new BigDecimal ( 0 ) );

                supdata = werkzeugeanforderunDao.updates ( wer );

            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return supdata;
    }

    @Override
    public Object werkAdd(List<Werkzeugeanforderun> insertList) throws SQLException {
        return werkzeugeanforderunDao.insertBatchs ( insertList );
    }

    @Override
    public List<Toolprocured> getToolpro() throws SQLException {
        return toolprocuredDao.searchByToolList ();
    }

    @Override
    public int getupdateTool(Werkzeugeanforderun werList) throws SQLException {
        int toolprod = 0;
        Toolprocured toolprocured = new Toolprocured ();

        toolprocured.setProcuredBatchWhere ( werList.getDemandCode () );
        toolprocured.setToolCodeWhere ( werList.getMaterialNr () );
        //订单号
        toolprocured.setToolsOrdeNO ( werList.getDemandCode () );

        //采购日期
        toolprocured.setProcuredTime ( Ctl.dateFormat ( werList.getTypingDate () ) );
        //采购单价
        toolprocured.setUnitPrice ( werList.getUnitPreis () );

        //是否入库
        toolprocured.setProcuredInto ( IConstant.PROCURED_TYPE_1 );
        //是否付费
        toolprocured.setProcuredPaying ( IConstant.PROCURED_PAYING_9 );
        //更新时间
        toolprocured.setUpdateTime ( new Date () );
        //采购类型(0新采购1外委图层2外委复磨9其他)
        String wer = werList.getMaterialNr ();
        if ("X".equalsIgnoreCase ( wer.substring ( wer.length () - 1, wer.length () ) )) {
            //材料号
            toolprocured.setToolCode ( wer.substring ( 0, wer.length () - 1 ) );
            toolprocured.setProcuredType ( IConstant.PROCURED_TYPE_1 );
        } else {
            //0新采购
            toolprocured.setProcuredType ( IConstant.PROCURED_TYPE_0 );
            toolprocured.setToolCode ( wer );
        }
        toolprocured.setDelFlag ( IConstant.DEL_FLAG_0 );
        toolprocured.setCreateTime ( new Date () );
        toolprocured.setUpdateTime ( new Date () );
        //			采购数量
        toolprocured.setProcuredNumber ( werList.getMenge () );
        toolprod = toolprocuredDao.updateNonQuery ( toolprocured );

        return toolprod;
    }

    @Override
    public Object toolproAdd(Toolprocured toolEntiy) throws SQLException {
        return toolprocuredDao.insert ( toolEntiy );
    }

    @Override
    public Map<String, Object> getList1(Werkzeugeanforderun entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {

            //toolCode模糊查询
            List<Werkzeugeanforderun> list = (List<Werkzeugeanforderun>) werkzeugeanforderunDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Werkzeugeanforderun> ();
                Werkzeugeanforderun vtoolprocureds = new Werkzeugeanforderun ();
                vtoolprocureds.setMessageCode ( IConstant.EMSG0001 );
                vtoolprocureds.setRetErrFlag ( true );
                list.add ( vtoolprocureds );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                int total = werkzeugeanforderunDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
            }
        } catch (SQLException e) {
            List<Werkzeugeanforderun> list = new ArrayList<Werkzeugeanforderun> ();
            Werkzeugeanforderun vtoolprocureds = new Werkzeugeanforderun ();
            vtoolprocureds.setMessageCode ( IConstant.EMSG0004 );
            vtoolprocureds.setRetErrFlag ( true );
            vtoolprocureds.setExceMessage ( e.getMessage () );
            list.add ( vtoolprocureds );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
        return rtn;
    }

    @Override
    public Map<String, Object> werDelete(Werkzeugeanforderun werkzeugeanforderun) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            // 删除成功
            int reval = werkzeugeanforderunDao.delete ( werkzeugeanforderun );
            rtn.put ( "message", MessageReSource.getMessageBox ( IConstant.IMSG0003, null, null ) );
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
            return rtn;
        } catch (SQLException e) {
            Werkzeugeanforderun entity = new Werkzeugeanforderun ();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode ( IConstant.EMSG0008 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }

    @Override
    public Map<String, Object> dbWerforderun(Map<String, Object> param) throws BusinessException {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        int reVal = 0;
        try {
            List<String> demandCodes = (List<String>) param.get ( "demandCodes" );
            List<Werkzeugeanforderun> infos = (List<Werkzeugeanforderun>) param.get ( "infos" );
            if (demandCodes != null && demandCodes.size () > 0) {
                //删除原有的需求单号
                werkzeugeanforderunDao.deleteListByDemands ( demandCodes );
            }
            if (infos != null && infos.size () > 0) {
            //新增当当前上传的数据
                werkzeugeanforderunDao.insertBatchs (infos);
            }
            return rtn;
        } catch (SQLException e) {
            Werkzeugeanforderun entity = new Werkzeugeanforderun ();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode ( IConstant.EMSG0007 );
            entity.setRetErrFlag ( true );
            entity.setExceMessage ( e.getMessage () );
            rtn.put ( "error", entity );
            rtn.put ( "data", null );
            return rtn;
        }
    }


}
