package com.icomp.common.service.impl.icomp.v01b06.s009;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s009.ICOMPV01B06S009Service;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成本摊销SERVICES实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B06S009ServiceImpl
 * @date 2014-8-22 上午10:27:29
 */

public class ICOMPV01B06S009ServiceImpl extends BaseService implements ICOMPV01B06S009Service {

    /**
     * 成本摊销DAO
     */
    private VcostabsorptionDao vcostabsorptionDao;
    private VcostamortizationDao vcostamortizationDao;
    private AssemblylineDao assemblylineDao;
    private AxleDao axleDao;
    private ProcessDao processDao;
    private PartsDao partsDao;

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
        this.assemblylineDao = assemblylineDao;
    }

    public void setAxleDao(AxleDao axleDao) {
        this.axleDao = axleDao;
    }

    public void setProcessDao(ProcessDao processDao) {
        this.processDao = processDao;
    }

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setVcostabsorptionDao(VcostabsorptionDao vcostabsorptionDao) {
        this.vcostabsorptionDao = vcostabsorptionDao;
    }

    public void setVcostamortizationDao(VcostamortizationDao vcostamortizationDao) {
        this.vcostamortizationDao = vcostamortizationDao;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getList(Vcostamortization entity, String yield) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        List<Vcostamortization> lists = null;
        double s = 0, n = 0;
        try {

            List<Vcostamortization> list = vcostamortizationDao.searchByLists ( entity );
            if (list.size () > 0) {
                for (Vcostamortization vc : list) {
                    vc.setToolType ( String.valueOf ( vc.getToolType ().charAt ( 0 ) ) );
                    BigDecimal db = new BigDecimal ( vc.getUnitPrice () );
                    //加工一次消耗/元 = 平均价/刃口数
                    vc.setUnitPrice ( String.valueOf ( db.setScale ( 2, BigDecimal.ROUND_HALF_UP ) ) );
                    if (vc.getUserNumber () != null && vc.getUnitPrice () != null) {
                        //消耗次数:
                        //	 s = Double.parseDouble(yield)/vc.getUserNumber().doubleValue();
                        // 消耗次数 = 当前的加工次数和产量没有关于 20161208
                        s = vc.getUserNumber ().doubleValue ();

                        // （消耗次数*单价）/产量 = 摊销成本
                        n = ((s * Double.parseDouble ( vc.getUnitPrice () ))/ Double.parseDouble(yield))/10000;
                        BigDecimal bd = new BigDecimal ( s );
                        BigDecimal bc = new BigDecimal ( n );
                        vc.setUserNumber ( bd.setScale ( 0, BigDecimal.ROUND_HALF_UP ) );
                        vc.setAmortizationRMB ( String.valueOf ( bc.setScale ( 2, BigDecimal.ROUND_HALF_UP ).doubleValue () ) );

                    } else {
                        vc.setUserNumber ( new BigDecimal ( 0 ) );
                        vc.setProcessAmount ( new BigDecimal ( 0 ) );
                    }
                }
                //总金额


            }

            if (list.size () <= 0) {
                list = new ArrayList<Vcostamortization> ();
                Vcostamortization vcostamortization = new Vcostamortization ();
                vcostamortization.setMessageCode ( IConstant.EMSG0001 );
                vcostamortization.setRetErrFlag ( true );
                list.add ( vcostamortization );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );

            } else {
                Vcostamortization vc = new Vcostamortization ();
                vc.setPartsID ( entity.getPartsID () );
                //总数量
                int total = vcostamortizationDao.searchByCount ( vc );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );

            }
            return rtn;
        } catch (SQLException e) {
            List<Vcostamortization> list = new ArrayList<Vcostamortization> ();
            Vcostamortization vcostamortization = new Vcostamortization ();
            vcostamortization.setMessageCode ( IConstant.EMSG0004 );
            vcostamortization.setRetErrFlag ( true );
            vcostamortization.setExceMessage ( e.getMessage () );
            list.add ( vcostamortization );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    public Map<String, Object> getList2(Vcostamortization entity, String yield) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        List<Vcostamortization> lists = null;
        double s = 0, n = 0;
        try {

            List<Vcostamortization> list = vcostamortizationDao.searchByLists2 ( entity );
            if (list.size () > 0) {
                for (Vcostamortization vc : list) {
                    vc.setToolType ( String.valueOf ( vc.getToolType ().charAt ( 0 ) ) );
                    BigDecimal db = new BigDecimal ( vc.getUnitPrice () );
                    //加工一次消耗/元 = 平均价/刃口数
                    vc.setUnitPrice ( String.valueOf ( db.setScale ( 2, BigDecimal.ROUND_HALF_UP ) ) );
                    if (vc.getUserNumber () != null && vc.getUnitPrice () != null) {
                        //消耗次数:
                        //	 s = Double.parseDouble(yield)/vc.getUserNumber().doubleValue();
                        // 消耗次数 = 当前的加工次数和产量没有关于 20161208
                        s = vc.getUserNumber ().doubleValue ();

                        // （消耗次数*单价）/产量 = 摊销成本
                        n = ((s * Double.parseDouble ( vc.getUnitPrice () ))/ Double.parseDouble(yield));
                        BigDecimal bd = new BigDecimal ( s );
                        BigDecimal bc = new BigDecimal ( n );
                        vc.setUserNumber ( bd.setScale ( 0, BigDecimal.ROUND_HALF_UP ) );
                        vc.setAmortizationRMB ( String.valueOf ( bc.setScale ( 2, BigDecimal.ROUND_HALF_UP ).doubleValue () ) );

                    } else {
                        vc.setUserNumber ( new BigDecimal ( 0 ) );
                        vc.setProcessAmount ( new BigDecimal ( 0 ) );
                    }
                }
                //总金额


            }

            if (list.size () <= 0) {
                list = new ArrayList<Vcostamortization> ();
                Vcostamortization vcostamortization = new Vcostamortization ();
                vcostamortization.setMessageCode ( IConstant.EMSG0001 );
                vcostamortization.setRetErrFlag ( true );
                list.add ( vcostamortization );
                rtn.put ( "rows", null );
                rtn.put ( "error", list );

            } else {
                Vcostamortization vc = new Vcostamortization ();
                vc.setPartsID ( entity.getPartsID () );
                //总数量
                int total = vcostamortizationDao.searchByCount2 ( vc );
                rtn.put ( "rows", list );
                rtn.put ( "total", total );
                rtn.put ( "page", (entity.getStaIndex () + IConstant.ROWSIZE) / IConstant.ROWSIZE );

            }
            return rtn;
        } catch (SQLException e) {
            List<Vcostamortization> list = new ArrayList<Vcostamortization> ();
            Vcostamortization vcostamortization = new Vcostamortization ();
            vcostamortization.setMessageCode ( IConstant.EMSG0004 );
            vcostamortization.setRetErrFlag ( true );
            vcostamortization.setExceMessage ( e.getMessage () );
            list.add ( vcostamortization );
            rtn.put ( "rows", null );
            rtn.put ( "error", list );
            return rtn;
        }
    }

    public List<Assemblyline> getAssemblyline() {
        Assemblyline entity = null;
        Assemblyline assemblyline = null;
        try {
            entity = new Assemblyline ();
            entity.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList ( entity );

            if (list.size () <= 0) {
                list = new ArrayList<Assemblyline> ();
                assemblyline = new Assemblyline ();
                // 消息：检索为0
                assemblyline.setMessageCode ( IConstant.EMSG0001 );
                assemblyline.setRetErrFlag ( false );
                list.add ( assemblyline );
                return list;
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


}
