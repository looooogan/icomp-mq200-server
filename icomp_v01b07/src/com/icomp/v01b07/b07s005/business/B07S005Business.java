package com.icomp.v01b07.b07s005.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Formulas;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Werkzeugeanforderun;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 建议采购计划查询BUSINESS接口
 *
 * @author Taoyy
 * @ClassName: B01S005Business
 * @date 2014-8-13 下午04:45:46
 */
public interface B07S005Business {
    /**
     * 建议采购计划列表
     *
     * @param param
     * @param langValue
     * @return Map<String,Object>
     * @title getList
     */
    Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue,int checkType) throws BusinessException;

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langValue
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getGridColmun(String pageID, String customerID, String langCode, String langValue) throws BusinessException;

    Object addEmployeeInfo(List<Werkzeugeanforderun> info) throws BusinessException;

    //	List<Werkzeugeanforderun> getWerList()throws BusinessException;

    int getUpdate(Map<String, Object> werMap) throws BusinessException;

    Map<String, Object> dbWerforderun(List<Werkzeugeanforderun> infos, String langCode, String langValue, String userID) throws BusinessException;

    List<Parts> getPartsList() throws SQLException;

    List<Formulas> getFormulasList() throws SQLException;

    Map<String,Object> parttAdd(Map<String, Object> param, String langCode, String langValue, String customer);

    Map<String,Object> partList(Map<String, Object> param, String langCode, String langValue, String customer);

    Map<String,Object> fmolDel(Map<String, Object> param, String customer, String langCode, String langValue);

    Map<String,Object> partInfo(Map<String, Object> param, String customer, String langCode, String langValue);

    Map<String,Object> partEdit(Map<String, Object> param, String customer, String langCode, String langValue);

    Map<String,Object> getPageSelList(String s, String s1);
}
