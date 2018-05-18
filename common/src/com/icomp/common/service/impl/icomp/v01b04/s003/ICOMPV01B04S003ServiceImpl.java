package com.icomp.common.service.impl.icomp.v01b04.s003;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b04.s003.ICOMPV01B04S003Service;
import com.icomp.dao.AssemblylineDao;
import com.icomp.dao.AxleDao;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.EquipmentDao;
import com.icomp.dao.OplinkDao;
import com.icomp.dao.PartsDao;
import com.icomp.dao.ProcessDao;
import com.icomp.dao.SynthesistoolsmachiningDao;
import com.icomp.dao.VoplinkdownDao;
import com.icomp.dao.VprocessingabnormalalarmDao;
import com.icomp.dao.VtoolsmachiningDao;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Axle;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Process;
import com.icomp.entity.base.Synthesistoolsmachininginfo;
import com.icomp.entity.base.Voplinkdown;
import com.icomp.entity.base.Vprocessingabnormalalarm;
import com.icomp.entity.base.Vtoolsmachining;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加工量异常报警SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B03S003ServiceImpl
 * @date 2014-8-20 下午04:16:06
 */
public class ICOMPV01B04S003ServiceImpl extends BaseService implements ICOMPV01B04S003Service {
    /**
     * 加工量异常报警DAO
     */
    private VprocessingabnormalalarmDao vprocessingabnormalalarmDao;
    private VtoolsmachiningDao vtoolsmachiningDao;
    private AssemblylineDao assemblylineDao;
    private AxleDao axleDao;
    private ProcessDao processDao;
    private EquipmentDao equipmentDao;
    private PartsDao partsDao;
    private BusinessDao businessDao;
    private OplinkDao oplinkDao;
    private VoplinkdownDao voplinkdownDao;
    private SynthesistoolsmachiningDao synthesistoolsmachiningDao ;

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }

    public void setAxleDao(AxleDao axleDao) {
        this.axleDao = axleDao;
    }

    public void setProcessDao(ProcessDao processDao) {
        this.processDao = processDao;
    }

    public void setEquipmentDao(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    public void setOplinkDao(OplinkDao oplinkDao) {
        this.oplinkDao = oplinkDao;
    }

    public void setVoplinkdownDao(VoplinkdownDao voplinkdownDao) {
        this.voplinkdownDao = voplinkdownDao;
    }

    public void setVtoolsmachiningDao(VtoolsmachiningDao vtoolsmachiningDao) {
        this.vtoolsmachiningDao = vtoolsmachiningDao;
    }

    public void setVprocessingabnormalalarmDao(VprocessingabnormalalarmDao vprocessingabnormalalarmDao) {
        this.vprocessingabnormalalarmDao = vprocessingabnormalalarmDao;
    }

    public Map<String, Object> getLista(Vprocessingabnormalalarm entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        try {
            //SynthesisParametersCode模糊查询
            List<Vprocessingabnormalalarm> list = (List<Vprocessingabnormalalarm>) vprocessingabnormalalarmDao.searchByList_F ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vprocessingabnormalalarm> ();
                Vprocessingabnormalalarm vprocessingabnormalalarm = new Vprocessingabnormalalarm ();
                vprocessingabnormalalarm.setMessageCode ( IConstant.EMSG0001 );
                vprocessingabnormalalarm.setRetErrFlag ( true );
                list.add ( vprocessingabnormalalarm );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );
                return rtn;
            } else {
                List<Vprocessingabnormalalarm> resultList = new ArrayList<Vprocessingabnormalalarm> ();
                for (Vprocessingabnormalalarm r : list) {
                    double ret = Math.abs ( r.getProcessAmount ().doubleValue () - r.getQuotaProcessingVolume ().doubleValue () ) / r.getQuotaProcessingVolume ().doubleValue () * 100;
                    double com = r.getProcessAmount ().doubleValue () - r.getQuotaProcessingVolume ().doubleValue ();
                    //						if(ret>r.getToolAlarmRatio().doubleValue()){
                    //							if(com>0){
                    //								r.setStates(IConstant.STRING_0);//过多
                    //							}
                    //							if(com<0){
                    //								r.setStates(IConstant.STRING_1);//过少
                    //							}
                    //							resultList.add(r);
                    //					}
                }

                int total = resultList.size ();
                rtn.put ( "rows", resultList );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );
                return rtn;
            }

        } catch (SQLException e) {
            List<Vprocessingabnormalalarm> list = new ArrayList<Vprocessingabnormalalarm> ();
            Vprocessingabnormalalarm vprocessingabnormalalarm = new Vprocessingabnormalalarm ();
            vprocessingabnormalalarm.setMessageCode ( IConstant.EMSG0004 );
            vprocessingabnormalalarm.setRetErrFlag ( true );
            vprocessingabnormalalarm.setExceMessage ( e.getMessage () );
            list.add ( vprocessingabnormalalarm );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    @Override
    public Map<String, Object> getList(Vtoolsmachining entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Vtoolsmachining vtoolsmachining = null;
        try {
            //SynthesisParametersCode模糊查询
            List<Vtoolsmachining> list = vtoolsmachiningDao.searchByList1 ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Vtoolsmachining> ();
                vtoolsmachining = new Vtoolsmachining ();
                vtoolsmachining.setMessageCode ( IConstant.EMSG0001 );
                vtoolsmachining.setRetErrFlag ( true );
                list.add ( vtoolsmachining );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );

            } else {

                int total = vtoolsmachiningDao.searchByCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );

            }

        } catch (SQLException e) {
            List<Vprocessingabnormalalarm> list = new ArrayList<Vprocessingabnormalalarm> ();
            Vprocessingabnormalalarm vprocessingabnormalalarm = new Vprocessingabnormalalarm ();
            vprocessingabnormalalarm.setMessageCode ( IConstant.EMSG0004 );
            vprocessingabnormalalarm.setRetErrFlag ( true );
            vprocessingabnormalalarm.setExceMessage ( e.getMessage () );
            list.add ( vprocessingabnormalalarm );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );

        }
        return rtn;
    }

    @Override
    public List<Parts> getParts() {
        Parts entity = null;
        Parts parts = null;
        try {
            entity = new Parts ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Parts> list = (List<Parts>) partsDao.searchByList ( entity );

            //			for (Equipment equipment : list2) {
            //				list.add(equipment);
            //			}
            if (list.size () <= 0) {
                list = new ArrayList<Parts> ();
                parts = new Parts ();
                // 消息：检索为0
                parts.setMessageCode ( IConstant.EMSG0001 );
                parts.setRetErrFlag ( false );
                list.add ( parts );
                return list;
            }
            return list;

        } catch (SQLException e) {
            List<Parts> list = new ArrayList<Parts> ();
            parts = new Parts ();
            // 错误消息：数据库操作异常，查询失败!
            parts.setMessageCode ( IConstant.EMSG0004 );
            parts.setRetErrFlag ( true );
            parts.setExceMessage ( e.getMessage () );
            list.add ( parts );
            return list;
        }

    }

    @Override
    public List<Axle> getAxleLine() {
        List<Axle> list = null;
        Axle axle = null;
        Axle entity = null;
        try {
            entity = new Axle ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            list = (List<Axle>) axleDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Axle> ();
                axle = new Axle ();
                // 消息：检索为0
                axle.setMessageCode ( IConstant.EMSG0001 );
                axle.setRetErrFlag ( false );
                list.add ( axle );
            }
        } catch (SQLException e) {
            list = new ArrayList<Axle> ();
            axle = new Axle ();
            // 错误消息：数据库操作异常，查询失败!
            axle.setMessageCode ( IConstant.EMSG0004 );
            axle.setRetErrFlag ( true );
            axle.setExceMessage ( e.getMessage () );
            list.add ( axle );
        }
        return list;


    }

    @Override
    public List<Process> getProcess() {
        try {
            Process entity = new Process ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setOrderString ( "processName" );
            List<Process> list = (List<Process>) processDao.searchByList ( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Process> ();
                Process process = new Process ();
                // 消息：检索为0
                process.setMessageCode ( IConstant.EMSG0001 );
                process.setRetErrFlag ( false );
                list.add ( process );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Process> list = new ArrayList<Process> ();
            Process process = new Process ();
            // 错误消息：数据库操作异常，查询失败!
            process.setMessageCode ( IConstant.EMSG0004 );
            process.setRetErrFlag ( true );
            process.setExceMessage ( e.getMessage () );
            list.add ( process );
            return list;
        }
    }

    @Override
    public List<Equipment> getEquipment() {
        try {
            Equipment entity = new Equipment ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setEquipmentType ( IConstant.EQUIPMENT_TYPES_0 );
            entity.setOrderString ( "equipmentName" );

            List<Equipment> list = (List<Equipment>) equipmentDao.searchByList ( entity );
            entity = new Equipment ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            entity.setEquipmentType ( IConstant.EQUIPMENT_TYPES_2 );
            List<Equipment> list2 = (List<Equipment>) equipmentDao.searchByList ( entity );
            for (Equipment equipment : list2) {
                list.add ( equipment );
            }
            if (list.size () <= 0) {
                list = new ArrayList<Equipment> ();
                Equipment equipment = new Equipment ();
                // 消息：检索为0
                equipment.setMessageCode ( IConstant.EMSG0001 );
                equipment.setRetErrFlag ( false );
                list.add ( equipment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Equipment> list = new ArrayList<Equipment> ();
            Equipment equipment = new Equipment ();
            // 错误消息：数据库操作异常，查询失败!
            equipment.setMessageCode ( IConstant.EMSG0004 );
            equipment.setRetErrFlag ( true );
            equipment.setExceMessage ( e.getMessage () );
            list.add ( equipment );
            return list;
        }
    }

    @Override
    public List<Assemblyline> getAssemblyline() {
        Assemblyline entity = null;
        Assemblyline assemblyline = null;
        try {
            entity = new Assemblyline ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList ( entity );

            //			for (Equipment equipment : list2) {
            //				list.add(equipment);
            //			}
            if (list.size () <= 0) {
                list = new ArrayList<Assemblyline> ();
                assemblyline = new Assemblyline ();
                // 消息：检索为0
                assemblyline.setMessageCode ( IConstant.EMSG0001 );
                assemblyline.setRetErrFlag ( false );
                list.add ( assemblyline );
            }
            return list;
        } catch (SQLException e) {
            List<Assemblyline> list = new ArrayList<Assemblyline> ();
            assemblyline = new Assemblyline ();
            // 错误消息：数据库操作异常，查询失败!
            assemblyline.setMessageCode ( IConstant.EMSG0004 );
            assemblyline.setRetErrFlag ( true );
            assemblyline.setExceMessage ( e.getMessage () );
            list.add ( assemblyline );
            return list;
        }

    }

    @Override
    public List<Assemblyline> getAssemblylineList(Assemblyline entity) {
        try {

            List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Assemblyline> ();
                Assemblyline assemblyline = new Assemblyline ();
                assemblyline.setMessageCode ( IConstant.WMSG0008 );
                assemblyline.setRetErrFlag ( true );
                list.add ( assemblyline );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Assemblyline> list = new ArrayList<Assemblyline> ();
            Assemblyline assemblyline = new Assemblyline ();
            assemblyline.setMessageCode ( IConstant.EMSG0004 );
            assemblyline.setRetErrFlag ( true );
            assemblyline.setExceMessage ( e.getMessage () );
            list.add ( assemblyline );
            return list;
        }
    }

    @Override
    public int getprocessAmount() {
        return 0;
    }//TODO ...

    @Override
    public List<Voplinkdown> getVoplinList(Voplinkdown entity) {
        try {

            List<Voplinkdown> list = (List<Voplinkdown>) voplinkdownDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Voplinkdown> ();
                Voplinkdown voplinkdown = new Voplinkdown ();
                voplinkdown.setMessageCode ( IConstant.WMSG0008 );
                voplinkdown.setRetErrFlag ( false );
                list.add ( voplinkdown );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Voplinkdown> list = new ArrayList<Voplinkdown> ();
            Voplinkdown voplinkdown = new Voplinkdown ();
            voplinkdown.setMessageCode ( IConstant.EMSG0004 );
            voplinkdown.setRetErrFlag ( true );
            voplinkdown.setExceMessage ( e.getMessage () );
            list.add ( voplinkdown );
            return list;
        }
    }

    @Override
    public List<Process> getProcessList(Process entity) {
        try {

            List<Process> list = (List<Process>) processDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Process> ();
                Process process = new Process ();
                process.setMessageCode ( IConstant.WMSG0008 );
                process.setRetErrFlag ( true );
                list.add ( process );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Process> list = new ArrayList<Process> ();
            Process process = new Process ();
            process.setMessageCode ( IConstant.EMSG0004 );
            process.setRetErrFlag ( true );
            process.setExceMessage ( e.getMessage () );
            list.add ( process );
            return list;
        }
    }

    @Override
    public List<Equipment> getEquipmentList(Equipment entity) {
        try {
            List<Equipment> list = (List<Equipment>) equipmentDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Equipment> ();
                Equipment equipment = new Equipment ();
                equipment.setMessageCode ( IConstant.WMSG0008 );
                equipment.setRetErrFlag ( true );
                list.add ( equipment );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Equipment> list = new ArrayList<Equipment> ();
            Equipment equipment = new Equipment ();
            equipment.setMessageCode ( IConstant.EMSG0004 );
            equipment.setRetErrFlag ( true );
            equipment.setExceMessage ( e.getMessage () );
            list.add ( equipment );
            return list;
        }
    }

    @Override
    public List<Axle> getAxlelist(Axle entity) {
        try {
            List<Axle> list = (List<Axle>) axleDao.searchByList ( entity );
            if (list.size () <= 0) {
                // 列表取得失败!
                list = new ArrayList<Axle> ();
                Axle axle = new Axle ();
                axle.setMessageCode ( IConstant.WMSG0008 );
                axle.setRetErrFlag ( true );
                list.add ( axle );
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Axle> list = new ArrayList<Axle> ();
            Axle axle = new Axle ();
            axle.setMessageCode ( IConstant.EMSG0004 );
            axle.setRetErrFlag ( true );
            axle.setExceMessage ( e.getMessage () );
            list.add ( axle );
            return list;
        }
    }

    @Override
    public String getNumber() {
        int total = 0;
        try {
            total = vtoolsmachiningDao.searchByCount ( new Vtoolsmachining () );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return String.valueOf ( total );
    }

    @Override
    public Map<String, Object> getList1(Synthesistoolsmachininginfo entity) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        Synthesistoolsmachininginfo vtoolsmachining = null;
        try {
            //换刀记录
            List<Synthesistoolsmachininginfo> list = synthesistoolsmachiningDao.searchListByInfo( entity );
            if (list.size () <= 0) {
                list = new ArrayList<Synthesistoolsmachininginfo> ();
                vtoolsmachining = new Synthesistoolsmachininginfo ();
                vtoolsmachining.setMessageCode ( IConstant.EMSG0001 );
                vtoolsmachining.setRetErrFlag ( true );
                list.add ( vtoolsmachining );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );

            } else {

                int total = synthesistoolsmachiningDao.searchListByInfoCount ( entity );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );

            }

        } catch (SQLException e) {
            List<Synthesistoolsmachininginfo> list = new ArrayList<Synthesistoolsmachininginfo> ();
            Synthesistoolsmachininginfo vprocessingabnormalalarm = new Synthesistoolsmachininginfo ();
            vprocessingabnormalalarm.setMessageCode ( IConstant.EMSG0004 );
            vprocessingabnormalalarm.setRetErrFlag ( true );
            vprocessingabnormalalarm.setExceMessage ( e.getMessage () );
            list.add ( vprocessingabnormalalarm );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );

        }
        return rtn;
    }
}
