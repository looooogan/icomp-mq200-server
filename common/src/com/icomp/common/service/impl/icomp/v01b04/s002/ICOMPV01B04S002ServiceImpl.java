package com.icomp.common.service.impl.icomp.v01b04.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b04.s002.ICOMPV01B04S002Service;
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
 * @ClassName: ICOMPV01B03S002ServiceImpl
 * @author Taoyy
 * @date 2014-8-20 下午03:58:41
 */
public class ICOMPV01B04S002ServiceImpl extends BaseService implements ICOMPV01B04S002Service {



    /**
     * 修复通知单DAO
     */
    private VcuttingtoolstateDao vcuttingtoolstateDao;
    private VsynthesisconditionDao vsynthesisconditionDao;
    private AssemblylineDao assemblylineDao;
    private ProcessDao processDao;
    private VoplinkdownDao voplinkdownDao;
    private SynthesisknifeDao synthesisknifeDao;

    public void setVoplinkdownDao(VoplinkdownDao voplinkdownDao) {
        this.voplinkdownDao = voplinkdownDao;
    }

    public void setProcessDao(ProcessDao processDao) {
        this.processDao = processDao;
    }

    public void setAssemblylineDao(AssemblylineDao assemblylineDao) {

        this.assemblylineDao = assemblylineDao;
    }

    public void setVcuttingtoolstateDao(VcuttingtoolstateDao vcuttingtoolstateDao) {
        this.vcuttingtoolstateDao = vcuttingtoolstateDao;
    }

    public void setVsynthesisconditionDao(VsynthesisconditionDao vsynthesisconditionDao) {
        this.vsynthesisconditionDao = vsynthesisconditionDao;
    }

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    @Override
    /**
     * 车间刀具状态查询-SynthesisParametersCode模糊查询
     * @title getList
     * @param entity
     * @return
     * Map<String,Object>
     */
    public Map<String, Object> getList(Vcuttingtoolstate entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            //SynthesisParametersCode模糊查询
            List<Vcuttingtoolstate> list = (List<Vcuttingtoolstate>) vcuttingtoolstateDao.searchByList_F(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Vcuttingtoolstate>();
                Vcuttingtoolstate vcuttingtoolstate = new Vcuttingtoolstate();
                vcuttingtoolstate.setMessageCode(IConstant.EMSG0001);
                vcuttingtoolstate.setRetErrFlag(true);
                list.add(vcuttingtoolstate);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;
            } else {
                int total = vcuttingtoolstateDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
                return rtn;
            }

        } catch (SQLException e) {
            List<Vcuttingtoolstate> list = new ArrayList<Vcuttingtoolstate>();
            Vcuttingtoolstate vcuttingtoolstate = new Vcuttingtoolstate();
            vcuttingtoolstate.setMessageCode(IConstant.EMSG0004);
            vcuttingtoolstate.setRetErrFlag(true);
            vcuttingtoolstate.setExceMessage(e.getMessage());
            list.add(vcuttingtoolstate);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
    }
    // 2017/09/16 宋健 变更↓↓↓　dazhong@YMSC
    @Override
    public Map<String, Object> getLists( Synthesisknife entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        Vsynthesiscondition vsynthesiscondition = null;
        Synthesisknife tooltransferTotal = null;
        try {
            List<Synthesisknife> list = synthesisknifeDao.searchSynthesisknifeList(entity);

            if (list.size() <= 0) {
                list = new ArrayList<Synthesisknife>();
                tooltransferTotal = new Synthesisknife();
                tooltransferTotal.setMessageCode(IConstant.EMSG0001);
                tooltransferTotal.setRetErrFlag(true);
                list.add(tooltransferTotal);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;

            } else {
                int total = synthesisknifeDao.searchSynthesisknifeListByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

            }

        } catch (SQLException e) {
            List<Vsynthesiscondition> list = new ArrayList<Vsynthesiscondition>();
            vsynthesiscondition = new Vsynthesiscondition();
            vsynthesiscondition.setMessageCode(IConstant.EMSG0004);
            vsynthesiscondition.setRetErrFlag(true);
            vsynthesiscondition.setExceMessage(e.getMessage());
            list.add(vsynthesiscondition);
            rtn.put("rows", null);
            rtn.put("error", list);

        }
        return rtn;
        // 2017/09/16 宋健 变更↑↑↑　dazhong@YMSC
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
    public List<Process> getProcess() {
        try {
            Process entity = new Process();
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            entity.setOrderString("processName");
            List<Process> list = (List<Process>) processDao.searchByList(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Process>();
                Process process = new Process();
                // 消息：检索为0
                process.setMessageCode(IConstant.EMSG0001);
                process.setRetErrFlag(false);
                list.add(process);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Process> list = new ArrayList<Process>();
            Process process = new Process();
            // 错误消息：数据库操作异常，查询失败!
            process.setMessageCode(IConstant.EMSG0004);
            process.setRetErrFlag(true);
            process.setExceMessage(e.getMessage());
            list.add(process);
            return list;
        }
    }

    @Override
    public List<Voplinkdown> getVoplinList(Voplinkdown entity) {
        try {

            List<Voplinkdown> list = (List<Voplinkdown>) voplinkdownDao.searchByList(entity);
            if (list.size() <= 0) {
                // 列表取得失败!
                list = new ArrayList<Voplinkdown>();
                Voplinkdown voplinkdown = new Voplinkdown();
                voplinkdown.setMessageCode(IConstant.WMSG0008);
                voplinkdown.setRetErrFlag(false);
                list.add(voplinkdown);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Voplinkdown> list = new ArrayList<Voplinkdown>();
            Voplinkdown voplinkdown = new Voplinkdown();
            voplinkdown.setMessageCode(IConstant.EMSG0004);
            voplinkdown.setRetErrFlag(true);
            voplinkdown.setExceMessage(e.getMessage());
            list.add(voplinkdown);
            return list;
        }
    }

    @Override
    public List<Assemblyline> getAssemblylineList(Assemblyline entity) {
        try {
            List<Assemblyline> list = (List<Assemblyline>) assemblylineDao.searchByList(entity);
            if (list.size() <= 0) {
                // 列表取得失败!
                list = new ArrayList<Assemblyline>();
                Assemblyline assemblyline = new Assemblyline();
                assemblyline.setMessageCode(IConstant.WMSG0008);
                assemblyline.setRetErrFlag(true);
                list.add(assemblyline);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Assemblyline> list = new ArrayList<Assemblyline>();
            Assemblyline assemblyline = new Assemblyline();
            assemblyline.setMessageCode(IConstant.EMSG0004);
            assemblyline.setRetErrFlag(true);
            assemblyline.setExceMessage(e.getMessage());
            list.add(assemblyline);
            return list;
        }
    }

    @Override
    public String getAnumber() {
        int total =0;
        try {
            total = vsynthesisconditionDao.searchByCount(new Vsynthesiscondition());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(total);
    }
}
