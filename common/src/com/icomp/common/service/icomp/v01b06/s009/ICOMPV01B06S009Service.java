package com.icomp.common.service.icomp.v01b06.s009;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;

/**
 * 成本摊销SERVICES接口
 * @ClassName: ICOMPV01B06S009Service 
 * @author Taoyy
 * @date 2014-8-22 上午10:27:15
 */

public interface ICOMPV01B06S009Service {
/**
 * 成本摊销
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */
    public Map<String, Object> getList(Vcostamortization entity,String yield);
    public Map<String, Object> getList2(Vcostamortization entity,String yield);
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
     * 取得生产线
     * @return
     */
    public List<Assemblyline> getAssemblyline();



}
