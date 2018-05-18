package com.icomp.v01b07.b07s005.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s005.ICOMPV01B07S005Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.UUIDgen;
import com.icomp.entity.base.*;
import com.icomp.v01b07.b07s005.business.B07S005Business;
import org.apache.commons.lang3.StringUtils;

import java.lang.System;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 建议采购计划查询BUSINESS实现类
 *
 * @author Taoyy
 * @ClassName: B07S005BusinessImpl
 * @date 2014-9-12 上午09:33:54
 */
public class B07S005BusinessImpl implements B07S005Business {

    /**
     * 系统初始化Service
     */
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 建议采购计划查询SERVICES
     */
    private ICOMPV01B07S005Service icompv01b07s005Service;

    public void setIcompv01b07s005Service(ICOMPV01B07S005Service icompv01b07s005Service) {
        this.icompv01b07s005Service = icompv01b07s005Service;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 建议采购计划列表
     */ public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue ,int checkType) throws BusinessException {
        String dateStarStr = param.get("DateStar").toString().trim();
        String dateEndStr = param.get("DateEnd").toString().trim();
        String partsCode = param.get("partsCode").toString().trim();
        String formulaID = param.get("formulaID").toString().trim();
        String paramStringA = param.get("ParamStringA").toString().trim();
        String paramStringB = param.get("ParamStringB").toString().trim();
        String paramStringC = param.get("ParamStringC").toString().trim();

        /**
         *  设置检索条件
         */
        Vpartsmachiningmsg entity = new Vpartsmachiningmsg();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            // 申请起始时间
            if (dateStarStr != null && dateStarStr != "") {
                dateStarStr += " 00:00:00";
                entity.setDateStar(format.parse(dateStarStr));
            }
            // 申请结束时间
            if (dateEndStr != null && dateEndStr != "") {
                dateEndStr += " 23:59:59";
                entity.setDateEnd(format.parse(dateEndStr));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        entity.setPartsID(StringUtils.isEmpty(partsCode) ? null : partsCode);
        entity.setExpandSpace1(StringUtils.isEmpty(formulaID) ? null : formulaID);
        entity.setParamStringA(StringUtils.isEmpty(paramStringA) ? null : paramStringA);
        entity.setParamStringB(StringUtils.isEmpty(paramStringB) ? null : paramStringB);
        entity.setParamStringC(StringUtils.isEmpty(paramStringC) ? null : paramStringC);
        if (checkType == 1){
              // 分页起始行数
        entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
        // 分页页数
        entity.setRowCount(Integer.parseInt(param.get("rows").toString()));

        }else if (checkType == 2){

            entity.setStaIndex(0);
            entity.setRowCount(3000);
        }

        // 排序
        entity.setGroupString("ToolCode");
        // 建议采购计划列表
        Map<String, Object> rtn = icompv01b07s005Service.getList(entity);
        if (rtn.size() > 1 && rtn.get("error") != null) {
            // 检索错误时，返回
            throw new BusinessException(((List<Vpartsmachiningmsg>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
        }
        return rtn;
    }

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getGridColmun(String pageID, String userID, String langCode, String langValue) throws BusinessException {

        // 取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun(pageID, langCode, IConstant.ITEM_TYPE_1);
        if (ret.size() > 1 && ret.get("error") != null) {
            // 取得失败时，返回
            throw new BusinessException(((List<Displayeditemconfiguration>) ret.get("error")).get(0).getMessageCode(), langCode, langValue);
        }
        return ret;
    }

    @Override
    public Object addEmployeeInfo(List<Werkzeugeanforderun> list) throws BusinessException {
        try {
            Object obj = icompv01b07s005Service.werkAdd(list);
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getUpdate(Map<String, Object> werMap) throws BusinessException {
        int supdata = 0;
        Werkzeugeanforderun werEntity = new Werkzeugeanforderun();
        Werkzeugeanforderun wer = new Werkzeugeanforderun();
        try {
            for (Map.Entry<String, Object> entry : werMap.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                werEntity = (Werkzeugeanforderun) entry.getValue();
                wer.setDemandCodeWhere(werEntity.getDemandCode());
                wer.setMaterialNrWhere (werEntity.getMaterialNr());

                wer.setUnitPreis(werEntity.getUnitPreis());
                wer.setBestellBezeichnung(werEntity.getBestellBezeichnung());
                wer.setMenge(werEntity.getMenge());
                wer.setEinheit(werEntity.getEinheit());
                wer.setBetrag(werEntity.getBetrag());
                wer.setLieferant(werEntity.getLieferant());
                wer.setEinsAtzort(werEntity.getEinsAtzort());
                wer.setSubjectCode(werEntity.getSubjectCode());
                wer.setExpenseCode(werEntity.getExpenseCode());
                wer.setNotes(werEntity.getNotes());
                wer.setTypingDate(werEntity.getTypingDate());
                wer.setDelFlag(werEntity.getDelFlag());
                wer.setCreateUser(werEntity.getCreateUser());
                wer.setCreateTime(werEntity.getCreateTime());
                wer.setUpdateUser(werEntity.getUpdateUser());
                wer.setUpdateTime(werEntity.getUpdateTime());
                wer.setVersion(new BigDecimal(0));

                supdata += icompv01b07s005Service.getUpdata(wer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supdata;
    }

    @Override
    public Map<String, Object> dbWerforderun(List<Werkzeugeanforderun> infos, String langCode, String langValue, String userID) throws BusinessException {
        Map<String, Object> sMap = new HashMap<String, Object>();
        List<Werkzeugeanforderun> insertList = new ArrayList<Werkzeugeanforderun>();

        int werUpdate = 0;
        List<String> demandCodes = new ArrayList<String>();
        Map<String, Object> werMap = new HashMap<String, Object>();
        //数据库的数据
        List<Werkzeugeanforderun> werList = null;
        try {
            werList = icompv01b07s005Service.getWerList();

            //把数据库的所有需求号放入list
            for (Werkzeugeanforderun dbStr : werList) {
                demandCodes.add(dbStr.getDemandCode());
            }
            for (Werkzeugeanforderun infoDate : infos) {
                if (true == demandCodes.contains(infoDate.getDemandCode())) {
                    //如果当前list包含当前需求号
                    werMap.put(infoDate.getDemandCode(), infoDate);
                    continue;

                } else {
                    insertList.add(infoDate);
                }
            }
            if (werMap.size() > 0) {
                werUpdate = icompv01b07s005Service.getUpdate(werMap);

            }
            if (insertList.size() > 0) {
                icompv01b07s005Service.werkAdd(insertList);
            }

            sMap.put("list", insertList);
            sMap.put("total", werUpdate);

            Toolprocured toolEntiy = new Toolprocured();
            //查询订单表中的所有数据
            List<Toolprocured> toolpList = icompv01b07s005Service.getToolpro();
            List<String> tpList = new ArrayList<String>();
            //订单表里批次号放入新建list里
            for (Toolprocured tp : toolpList) {
                tpList.add(tp.getProcuredBatch());
            }

            for (Werkzeugeanforderun werslists : icompv01b07s005Service.getWerList()) {
                if (tpList.contains(werslists.getDemandCode())) {
                    //如果存在 更新
                    int C = icompv01b07s005Service.getupdateTool(werList);
                    continue;
                } else {

                    String toolpdID = UUIDgen.getId();
                    toolEntiy.setToolProcuredID(toolpdID);
                    //材料号
                    toolEntiy.setToolCode(werslists.getMaterialNr());
                    //订单号
                    toolEntiy.setToolsOrdeNO(werslists.getDemandCode());
                    //批次号
                    toolEntiy.setProcuredBatch(werslists.getDemandCode());
                    //采购日期
                    toolEntiy.setProcuredTime(Ctl.dateFormat(werslists.getTypingDate()));
                    //采购单价
                    toolEntiy.setUnitPrice(werslists.getUnitPreis());
                    //
                    toolEntiy.setProcuredCount(werslists.getMenge());
                    //是否入库
                    toolEntiy.setProcuredInto(IConstant.PROCURED_TYPE_1);
                    //是否付费
                    toolEntiy.setProcuredPaying(IConstant.PROCURED_PAYING_9);
                    //更新时间
                    toolEntiy.setUpdateTime(new Date());
                    //采购类型
                    String wer = werslists.getMaterialNr();
                    if ("X".equalsIgnoreCase(wer.substring(wer.length() - 1))) {
                        toolEntiy.setProcuredType(IConstant.PROCURED_TYPE_0);
                    } else {
                        toolEntiy.setProcuredType(IConstant.PROCURED_TYPE_1);
                    }
                    toolEntiy.setDelFlag(IConstant.DEL_FLAG_0);
                    toolEntiy.setCreateUser(userID);
                    toolEntiy.setCreateTime(new Date());
                    toolEntiy.setUpdateTime(new Date());
                    //                    采购数量
                    toolEntiy.setProcuredNumber(werslists.getMenge());
                    icompv01b07s005Service.toolproAdd(toolEntiy);
                }

            }


        } catch (Exception e) {
            System.out.println("----------------------" + e.toString());
        }
        return sMap;
    }

    @Override
    public List<Parts> getPartsList() throws SQLException {
        Parts parts = new Parts();
        parts.setDelFlag(IConstant.DEL_FLAG_0);
        return service.getPartsList(parts);
    }

    @Override
    public List<Formulas> getFormulasList() throws SQLException {
        Formulas parts = new Formulas();
        parts.setDelFlag(IConstant.DEL_FLAG_0);
        return service.getFormulasList(parts);
    }

    @Override
    public Map<String, Object> parttAdd(Map<String, Object> param, String langCode, String langValue, String customer) {
        List<Formulas> formulasList = new ArrayList<Formulas>();
        Map<String, Object> ret = icompv01b07s005Service.checkInput(param,langValue,customer,1);
        try {

        if(ret.size() > 1 && ret.get("error") != null){
            throw new BusinessException(((Formulas)ret.get("error")).getMessageCode(),"",langValue);
        }else if(ret.size() > 1 && ret.get("message") != null){
            return ret;
        }
        Formulas formulas =(Formulas) ret.get("data");

        //保存补领信息
          ret = icompv01b07s005Service.partAdd(formulas, langCode, langValue);
            formulasList = service.getFormulasList(new Formulas());
            ret.put("formulasList",formulasList);
            if (ret.size() > 0 && ret.get("error") != null) {
                //新建失败时，返回
                throw new BusinessException(((Formulas) ret.get("error")).getMessageCode(), langCode, langValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public Map<String, Object> partList(Map<String, Object> param, String langCode, String langValue, String customer) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        List<Formulas> formulasList = new ArrayList<Formulas>();
        try {
            Formulas formulas = new Formulas();
            formulas.setDelFlag(IConstant.DEL_FLAG_0);
            formulasList = service.getFormulasList(formulas);
            rtn.put("formulasLists",formulasList);
            if (rtn.size() > 1 && rtn.get("error") != null) {
                // 检索错误时，返回
                throw new BusinessException(((List<Formulas>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rtn;
    }

    @Override
    public Map<String, Object> fmolDel(Map<String, Object> param, String customer, String langCode, String langValue) {
        Formulas formulas = new Formulas();
        //要修改的值
        formulas.setDelFlag(IConstant.DEL_FLAG_1);
        formulas.setUpdateUser("55");
        formulas.setUpdateTime(new Date());
        //条件
        formulas.setFormulaIDWhere(new BigDecimal(param.get("ID").toString()));
        formulas.setDelFlagWhere(IConstant.DEL_FLAG_0);

        Map<String, Object> ret = icompv01b07s005Service.formuldel(formulas, langCode, langValue);
        if (ret.size() > 1 && ret.get("error") != null) {
            //删除失败时，返回
            throw new BusinessException(((Customer) ret.get("error")).getMessageCode(), langCode, langValue);
        }
        return ret;
    }

    @Override
    public Map<String, Object> partInfo(Map<String, Object> param, String customer, String langCode, String langValue) {
        Map<String,Object> ret = new HashMap<String, Object>();
        Formulas entity = new Formulas();
        entity.setFormulaID(new BigDecimal(param.get("ID").toString()));

        ret = icompv01b07s005Service.getKey(entity);
        if(ret.size() > 1 && ret.get("error") != null){
            //检索错误时，返回
            throw new BusinessException(((Tooloptimization)ret.get("error")).getMessageCode(),langCode,langValue);
        }
        return ret;
    }

    @Override
    public Map<String, Object> partEdit(Map<String, Object> param, String customer, String langCode, String langValue) {
        Map<String, Object> ret = icompv01b07s005Service.checkInput(param, langValue, customer, 2);
            if (ret.size() > 1 && ret.get("error") != null) {
                throw new BusinessException(((Formulas) ret.get("error")).getMessageCode(), "", langValue);
            } else if (ret.size() > 1 && ret.get("message") != null) {
                return ret;
            }
            Formulas formulas = (Formulas) ret.get("data");

            ret = icompv01b07s005Service.partEdit(formulas, "", langValue);
            if (ret.size() > 1 && ret.get("error") != null) {
                //新建失败时，返回
                throw new BusinessException(((Replacement) ret.get("error")).getMessageCode(), "", langValue);
            }
        return ret;
    }

    @Override
    public Map<String, Object> getPageSelList(String s, String s1) {
         Map<String, Object> ret = new HashMap<String, Object>();
         //取得零部件列表
        List<Parts> partsList = icompv01b07s005Service.getParts();
        if (partsList.size() > 0 && partsList.get(0).isRetErrFlag()) {
            //检索错误时，返回
            throw new BusinessException(partsList.get(0).getMessageCode(), s, s1);
        }
        ret.put("PartsList", partsList);


        return ret;

    }
}