package com.icomp.common.service.impl.icomp.v01b06.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s002.ICOMPV01B06S002Service;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车间刀具状态查询SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B03S002ServiceImpl
 * @date 2014-8-20 下午03:58:41
 */
public class ICOMPV01B06S002ServiceImpl extends BaseService implements ICOMPV01B06S002Service {

    /**
     * 加工异常分析DAO
     */
    private VanalysisabnormalprocessingDao vanalysisabnormalprocessingDao;
    private VanalysisDao vanalysisDao;
    private ProcessDao processDao;
    private PartsDao partsDao;
    private AssemblylineDao assemblylineDao;

    public void setProcessDao(ProcessDao processDao) {
        this.processDao = processDao;
    }

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setVanalysisDao(VanalysisDao vanalysisDao) {
        this.vanalysisDao = vanalysisDao;
    }

    public void setVanalysisabnormalprocessingDao(VanalysisabnormalprocessingDao vanalysisabnormalprocessingDao) {
        this.vanalysisabnormalprocessingDao = vanalysisabnormalprocessingDao;
    }

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }

    /**
     * 车间刀具状态查询
     *
     * @param entity
     * @return Map<String,Object>
     * @title getList
     */
    @Override
    public Map<String, Object> getList(Vanalysisabnormalprocessing entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            //SynthesisParametersCode模糊查询
            List<Vanalysisabnormalprocessing> list = (List<Vanalysisabnormalprocessing>) vanalysisabnormalprocessingDao.searchByList_F ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vanalysisabnormalprocessing> ();
                Vanalysisabnormalprocessing vanalysisabnormalprocessing = new Vanalysisabnormalprocessing ();
                vanalysisabnormalprocessing.setMessageCode ( IConstant.EMSG0001 );
                vanalysisabnormalprocessing.setRetErrFlag ( true );
                list.add ( vanalysisabnormalprocessing );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                int total = vanalysisabnormalprocessingDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            List<Vanalysisabnormalprocessing> list = new ArrayList<Vanalysisabnormalprocessing> ();
            Vanalysisabnormalprocessing vanalysisabnormalprocessing = new Vanalysisabnormalprocessing ();
            vanalysisabnormalprocessing.setMessageCode ( IConstant.EMSG0004 );
            vanalysisabnormalprocessing.setRetErrFlag ( true );
            vanalysisabnormalprocessing.setExceMessage ( e.getMessage () );
            list.add ( vanalysisabnormalprocessing );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    @Override
    public Map<String, Object> getLists(Vanalysis entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Vanalysis vanalysis = null;
        try {
            //SynthesisParametersCode模糊查询
            List<Vanalysis> list = (List<Vanalysis>) vanalysisDao.searchByList ( entity );

            for (Vanalysis valist : list) {
                valist.setToolType ( String.valueOf ( valist.getToolCode ().charAt ( 0 ) ) );
            }
            if (list.size () <= 0) {
                list = new ArrayList<Vanalysis> ();
                vanalysis = new Vanalysis ();
                vanalysis.setMessageCode ( IConstant.EMSG0001 );
                vanalysis.setRetErrFlag ( true );
                list.add ( vanalysis );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );

            } else {
                int total = vanalysisDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );

            }

        } catch (SQLException e) {
            List<Vanalysis> list = new ArrayList<Vanalysis> ();
            vanalysis = new Vanalysis ();
            vanalysis.setMessageCode ( IConstant.EMSG0004 );
            vanalysis.setRetErrFlag ( true );
            vanalysis.setExceMessage ( e.getMessage () );
            list.add ( vanalysis );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );

        }
        return rtn;
    }

    @Override
    /**
     * 加工异常分析统计数量
     */ public String getStatisticalCount(Vanalysis entity) {

        //0正常卸下
        int normal = 0;
        //1加工尺寸不满足
        int notSatisfied = 0;
        //2表面质量不满足
        int massNo = 0;
        //3机床原因
        int machineReason = 0;
        //其他
        int other = 0;
        try {
            List<Vanalysis> list = (List<Vanalysis>) vanalysisDao.searchByList ( entity );
            for (Vanalysis v : list) {
                if (v != null) {
                    //卸下原因( 0正常卸下,1加工尺寸不满足,2表面质量不满足,3机床原因4其他)(可维护
                    String reason = v.getRemoveReason ();
                    if (IConstant.STRING_1.equals ( reason )) {
                        notSatisfied++;
                    } else if (IConstant.STRING_2.equals ( reason )) {
                        massNo++;
                    } else if (IConstant.STRING_3.equals ( reason )) {
                        machineReason++;
                    } else {
                        other++;
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return notSatisfied + "," + massNo + "," + machineReason + "," + other;
    }

    @Override
    public List<Process> getProcess() {
        Process entity = null;
        List<Process> list = null;
        Process process = null;
        try {
            entity = new Process ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "processName" );
            list = (List<Process>) processDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Process> ();
                process = new Process ();
                // 消息：检索为0
                process.setMessageCode ( IConstant.EMSG0001 );
                process.setRetErrFlag ( false );
                list.add ( process );
            }
        } catch (SQLException e) {
            list = new ArrayList<Process> ();
            process = new Process ();
            // 错误消息：数据库操作异常，查询失败!
            process.setMessageCode ( IConstant.EMSG0004 );
            process.setRetErrFlag ( true );
            process.setExceMessage ( e.getMessage () );
            list.add ( process );
        }
        return list;
    }

    @Override
    public List<Parts> getParts() {
        Parts entity = null;
        Parts parts = null;
        List<Parts> list = null;
        try {
            entity = new Parts ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            list = (List<Parts>) partsDao.searchByList ( entity );

            if (list.size () <= 0) {
                list = new ArrayList<Parts> ();
                parts = new Parts ();
                // 消息：检索为0
                parts.setMessageCode ( IConstant.EMSG0001 );
                parts.setRetErrFlag ( false );
                list.add ( parts );
            }
        } catch (SQLException e) {
            list = new ArrayList<Parts> ();
            parts = new Parts ();
            // 错误消息：数据库操作异常，查询失败!
            parts.setMessageCode ( IConstant.EMSG0004 );
            parts.setRetErrFlag ( true );
            parts.setExceMessage ( e.getMessage () );
            list.add ( parts );
        }
        return list;
    }

    @Override
    public List<Parts> getPartsListById(String id) {
        Parts entity = null;
        Parts parts = null;
        List<Parts> list = null;
        try {
            entity = new Parts ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            list = (List<Parts>) partsDao.searchListById(id);

            if (list.size () <= 0) {
                list = new ArrayList<Parts> ();
                parts = new Parts ();
                // 消息：检索为0
                parts.setMessageCode ( IConstant.EMSG0001 );
                parts.setRetErrFlag ( false );
                list.add ( parts );
            }
        } catch (SQLException e) {
            list = new ArrayList<Parts> ();
            parts = new Parts ();
            // 错误消息：数据库操作异常，查询失败!
            parts.setMessageCode ( IConstant.EMSG0004 );
            parts.setRetErrFlag ( true );
            parts.setExceMessage ( e.getMessage () );
            list.add ( parts );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Assemblyline> getAssemblyline() {
        Assemblyline entity = null;
        Assemblyline assemblyline = null;
        List<Assemblyline> list = null;
        try {
            entity = new Assemblyline();
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            list = (List<Assemblyline>) assemblylineDao.searchByList(entity);


            if (list.size() <= 0) {
                list = new ArrayList<Assemblyline>();
                assemblyline = new Assemblyline();
                // 消息：检索为0
                assemblyline.setMessageCode(IConstant.EMSG0001);
                assemblyline.setRetErrFlag(false);
                list.add(assemblyline);

            }


        } catch (SQLException e) {
            list = new ArrayList<Assemblyline>();
            assemblyline = new Assemblyline();
            // 错误消息：数据库操作异常，查询失败!
            assemblyline.setMessageCode(IConstant.EMSG0004);
            assemblyline.setRetErrFlag(true);
            assemblyline.setExceMessage(e.getMessage());
            list.add(assemblyline);

        }
        return list;
    }

    @Override
    public String getNumber() {
        int total = 0;
        Vanalysis va = new Vanalysis ();
        va.setDelFlag ( IConstant.DEL_FLAG_0 );
        try {
            total = vanalysisDao.searchByCount ( va );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return String.valueOf ( total );
    }
}
