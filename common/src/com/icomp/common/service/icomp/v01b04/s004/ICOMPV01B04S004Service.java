package com.icomp.common.service.icomp.v01b04.s004;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;

/**
 * 刀具消耗查询SERVICE接口
 * @ClassName: ICOMPV01B03S004Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:28:56
 */
public interface ICOMPV01B04S004Service {

/**
 * 刀具消耗查询列表
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

public Map<String, Object> getList(Vamortization entity);
    /**
     * 取得零部件列表
     * @return
     */
    public List<Parts> getParts();
    /**
     * 取得轴编号列表
     * @return
     */
    public List<Axle> getAxleLine();
    /**
     * 取得工序列表
     * @return
     */
    public List<Process> getProcess();

    /**
     * 取得设备列表
     * @return
     */
    public List<Equipment> getEquipment();

    /**
     * 取得生产线
     * @return
     */
    public List<Assemblyline> getAssemblyline();

    public List<Assemblyline> getAssemblylineList(Assemblyline entity);
    int getprocessAmount();//TODO 有问题

    List<Voplinkdown> getVoplinList(Voplinkdown entity);


    List<Process> getProcessList(Process entity);

    public List<Equipment> getEquipmentList(Equipment entity);

    List<Axle> getAxlelist(Axle entity);

    String getNumber();
}
