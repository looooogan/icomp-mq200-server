package com.icomp.v01b09.b09s006.business;

import com.icomp.common.exception.BusinessException;

import java.io.File;
import java.util.List;
import java.util.Map;


public interface B09S006Business {
    /**
     * 取得列表
     * @param param 页面检索条件
     * @param langCode 语言编码
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langValue
     * @return
     * @throws BusinessException
     */
   // public Map<String, Object> getGridColmun(String pageID,String departmentID,String langCode , String langValue) throws BusinessException;


    /**
     * 新建刀具初始化
     *
     * @param param
     * @param langValue
     * @param langCode
     * @return
     * @throws BusinessException
     */
    Map<String,Object> optimizationAdd(Map<String, Object> param, List<String> uploadFileName, List<File> upload, String langValue, String userId,
                                       String langCode)throws BusinessException;

    Map<String,Object> optimizationInfo(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

    Map<String,Object> optimizationEdit(Map<String, Object> param,List<String> uploadFileName, List<File> upload, String langCode, String customer, String langValue)throws BusinessException;

    /**
     * @param langCode
     * @param langValue
     * @return
     * @throws BusinessException
     */
    Map<String,Object> getOptimization(String langCode, String langValue)throws BusinessException;


    Map<String,Object> potimizationDel(Map<String, Object> param, String langCode, String customer, String langValue);
}


