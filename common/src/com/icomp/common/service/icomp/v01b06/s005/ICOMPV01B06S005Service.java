package com.icomp.common.service.icomp.v01b06.s005;

import com.icomp.entity.base.Distribution;
import com.icomp.entity.base.Vtoolrealtimedistribution;

import java.util.Map;

/**
 * 刀具实时分布状况SERVICES接口
 * @ClassName: ICOMPV01B06S005Service 
 * @author Taoyy
 * @date 2014-8-22 上午09:59:26
 */

public interface ICOMPV01B06S005Service {
/**
 * 刀具实时分布状况
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */

public Map<String, Object> getList(Vtoolrealtimedistribution entity);

    public Map<String, Object> getLists(Distribution entity);
    /**
     * 加工异常分析统计数量
     * @title getStatisticalCount
     * @param entity
     * @return
     * String
     */
    public String getStatisticalCount(Distribution entity);

    String getNumber();
}
