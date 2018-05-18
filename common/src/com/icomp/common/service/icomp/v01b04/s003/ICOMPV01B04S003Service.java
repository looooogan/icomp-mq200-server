package com.icomp.common.service.icomp.v01b04.s003;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;

/**
 * 加工量异常报警SERVICE接口
 * @ClassName: ICOMPV01B03S003Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:15:24
 */
public interface ICOMPV01B04S003Service {
/**
 * 加工量异常报警
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

public Map<String, Object> getLista(Vprocessingabnormalalarm entity);

    public Map<String, Object> getList(Vtoolsmachining entity);
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
    public List<com.icomp.entity.base.Process> getProcess();

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

    Map<String,Object> getList1(Synthesistoolsmachininginfo entity);
}
