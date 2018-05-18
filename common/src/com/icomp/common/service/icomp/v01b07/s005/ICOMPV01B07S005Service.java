package com.icomp.common.service.icomp.v01b07.s005;

import com.icomp.entity.base.Formulas;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Vpartsmachiningmsg;
import com.icomp.entity.base.Werkzeugeanforderun;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 建议采购计划查询SERVICE接口
 *
 * @author Licc
 * @ClassName: ICOMPV01B07S003Service
 * @date 2014-8-28 下午04:17:50
 */
public interface ICOMPV01B07S005Service {
    /**
     * 建议采购计划查询列表
     *
     * @param entity
     * @return Map<String,Object>
     * @title getList
     */
    Map<String, Object> getList(Vpartsmachiningmsg entity);

    Object werkAdd(List<Werkzeugeanforderun> list) throws SQLException;

    List<Werkzeugeanforderun> getWerList() throws SQLException;

    int getUpdata(Werkzeugeanforderun werkf) throws SQLException;

    int getUpdate(Map<String, Object> werMap) throws SQLException;

    List<Toolprocured> getToolpro() throws SQLException;

    Object toolproAdd(Toolprocured toolEntiy) throws SQLException;

    int getupdateTool(List<Werkzeugeanforderun> werList) throws SQLException;

    Map<String,Object> checkInput(Map<String, Object> param, String langValue, String customer, int i);

    Map<String,Object> partAdd(Formulas formulas, String langCode, String langValue);

    Map<String,Object> partList(Formulas formulas);

    Map<String,Object> formuldel(Formulas formulas, String langCode, String langValue);

    Map<String,Object> getKey(Formulas entity);

    Map<String,Object> partEdit(Formulas formulas, String s, String langValue);

    List<Parts> getParts();


}
