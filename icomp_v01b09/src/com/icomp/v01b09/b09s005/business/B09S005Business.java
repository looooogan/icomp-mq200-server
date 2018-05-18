package com.icomp.v01b09.b09s005.business;

import com.icomp.common.exception.BusinessException;

import java.util.Map;


public interface B09S005Business {
    /**
     * 取得列表
     * @param param 页面检索条件
     * @param langCode 语言编码
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)throws BusinessException;

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
    Map<String,Object> sferAdds(Map<String, Object> param,String langCode, String userID,String langValue)throws BusinessException;

    Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;
}
