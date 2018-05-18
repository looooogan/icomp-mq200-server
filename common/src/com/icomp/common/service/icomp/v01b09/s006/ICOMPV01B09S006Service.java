package com.icomp.common.service.icomp.v01b09.s006;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Tooloptimization;

import java.util.List;
import java.util.Map;


public interface ICOMPV01B09S006Service {

    Map<String, Object> getList(Tooloptimization entity);
    /**
     * 新建补领
     * @param tooloptimization
     * @param langCode
     * @param langValue
     * @return
     */
     Map<String, Object> optimizationAdd(Tooloptimization tooloptimization, String langCode, String langValue);
    /**
     * 验证新建信息
     * @param param
     * @param langValue
     * @return
     */

     Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, int i,String userID) throws BusinessException;


    Map<String,Object> getToolOpKey(Tooloptimization entity)throws BusinessException;

    Map<String,Object> optimizationEdit(Tooloptimization entity, String langCode, String langValue)throws BusinessException;

    List<Tooloptimization> getToolopList()throws BusinessException;

    Map<String,Object> potimizationDel(Tooloptimization entity, String langCode, String langValue);
}
