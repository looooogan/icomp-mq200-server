package com.icomp.common.service.icomp.v01b04.s005;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;

/**
 * 车间工作量汇总SERVICES接口
 * @ClassName: ICOMPV01B03S005Service 
 * @author Taoyy
 * @date 2014-8-20 下午04:42:36
 */
public interface ICOMPV01B04S005Service {
/**
 * 车间工作量汇总
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

public Map<String, Object> getList(Vsynthesistoolsmachining entity);

    public Map<String, Object> getLists(Vworkshopsummary  entity);
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


    String getNumber();
}
