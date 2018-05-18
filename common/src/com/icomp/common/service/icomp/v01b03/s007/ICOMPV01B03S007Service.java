package com.icomp.common.service.icomp.v01b03.s007;

import com.icomp.entity.base.Tubedetailinfo;
import com.icomp.entity.base.Vgrindingquicksearch;

import java.util.Map;

/**
 * 筒刀拆装记录查询SERVICES接口
 * @ClassName: ICOMPV01B03S007Service
 * @author Sj
 * @date 2017-7-7 下午04:21:51
 */
public interface ICOMPV01B03S007Service {
/**
 * 加工信息快速查询
 * @title getList 
 * @param entity
 * @return
 * Map<String,Object>
 */
public	Map<String, Object> getList(Vgrindingquicksearch entity);

    /**
     * @param entity
     * @return
     */


    public Map<String, Object> getlistsMer(Tubedetailinfo entity);

    String getMnumber();

    // 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
    public Map<String, Object> getDetailInfo(Tubedetailinfo entity);

    public Map<String, Object> getTotalInfo(Tubedetailinfo entity);
    // 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC

}
