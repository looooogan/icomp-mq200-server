package com.icomp.common.service.impl.icomp.v01b07.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b07.s005.ICOMPV01B07S005Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.DateFormatUtil;
import com.icomp.common.utils.EvalUtils;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.TestJava;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.FormulasDao;
import com.icomp.dao.PartsDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.ToolsmachiningDao;
import com.icomp.dao.VpartsmachiningmsgDao;
import com.icomp.dao.VsuggestionpurchaseplanDao;
import com.icomp.dao.WerkzeugeanforderunDao;
import com.icomp.entity.base.Formulas;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Toolsmachining;
import com.icomp.entity.base.Vpartsmachiningmsg;
import com.icomp.entity.base.Werkzeugeanforderun;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 建议采购计划SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B07S005ServiceImpl
 * @date 2014-9-12 上午09:42:13
 */

public class ICOMPV01B07S005ServiceImpl extends BaseService implements ICOMPV01B07S005Service {

    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    @SuppressWarnings("unused")
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;
    private WerkzeugeanforderunDao werkzeugeanforderunDao;
    private ToolprocuredDao toolprocuredDao;
    private ToolsmachiningDao toolsmachiningDao;
    private FormulasDao formulasDao;
    private PartsDao partsDao;

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    public void setFormulasDao(FormulasDao formulasDao) {
        this.formulasDao = formulasDao;
    }

    public void setToolsmachiningDao(ToolsmachiningDao toolsmachiningDao) {
        this.toolsmachiningDao = toolsmachiningDao;
    }

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    public void setWerkzeugeanforderunDao(WerkzeugeanforderunDao werkzeugeanforderunDao) {
        this.werkzeugeanforderunDao = werkzeugeanforderunDao;
    }

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 采购计划实体Dao
     */
    private VsuggestionpurchaseplanDao vsuggestionpurchaseplanDao;
    private VpartsmachiningmsgDao vpartsmachiningmsgDao;

    public void setVpartsmachiningmsgDao(VpartsmachiningmsgDao vpartsmachiningmsgDao) {
        this.vpartsmachiningmsgDao = vpartsmachiningmsgDao;
    }

    public void setVsuggestionpurchaseplanDao(VsuggestionpurchaseplanDao vsuggestionpurchaseplanDao) {
        this.vsuggestionpurchaseplanDao = vsuggestionpurchaseplanDao;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 建议采购计划列表
     */ public Map<String, Object> getList(Vpartsmachiningmsg entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();

        try {
            //按条件查询
            List<Vpartsmachiningmsg> list = vpartsmachiningmsgDao.searchListByTime(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Vpartsmachiningmsg>();
                Vpartsmachiningmsg vsuggestionpurchaseplan = new Vpartsmachiningmsg();
                // 消息：检索为0
                vsuggestionpurchaseplan.setMessageCode(IConstant.EMSG0001);
                vsuggestionpurchaseplan.setRetErrFlag(true);
                list.add(vsuggestionpurchaseplan);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;
            } else {
                int total = vpartsmachiningmsgDao.searchByCount1(entity);
                for (Vpartsmachiningmsg vp : list) {
                    //平均用次数(保留两位小数)
                    if (vp.getAvgFrequencyUse() != null) {
                        DecimalFormat df = new DecimalFormat(".##");
                        vp.setAvgFrequencyUse(df.format(Double.parseDouble(vp.getAvgFrequencyUse())));
                    }
                    //使用次数(E)
                    vp.setUsedCounts(seachUsedNumber(vp.getToolID(), entity));
                    //流转数量(G)
                    vp.setActiveCounts(getActiveNumber(vp, IConstant.STRING_0));
                    //采购周期(周)
                    if (StringUtils.isEmpty(vp.getProcuresCycle())) {
                        vp.setProcuresCycle(IConstant.PROCURES_CYCLE);
                    }
                    //在途新刀数量(H)
                    vp.setGoingNewCounts(getNewNumber(vp));
                    if (IConstant.STRING_1.equals(vp.getToolGrinding()) || IConstant.STRING_2.equals(vp.getToolGrinding())) {
                        //厂外修磨刀具
                        //在途旧刀折新数量(J)
                        vp.setGoingOldToNewCounts(getActiveNumber(vp, IConstant.STRING_1));
                    } else {
                        vp.setGoingOldToNewCounts(IConstant.STRING_0);
                    }
                    //如果有公式，则要根据公式计算出采购数量
                    if (!StringUtils.isEmpty(entity.getExpandSpace1())) {
                        vp.setExpandSpace1(entity.getExpandSpace1());
                        vp.setParamStringA(entity.getParamStringA());
                        vp.setParamStringB(entity.getParamStringB());
                        vp.setParamStringC(entity.getParamStringC());
                        //计算采购数量
                        String tatle = getPurchaseNumber(vp);
                        if (StringUtils.isEmpty(tatle)) {
                            tatle = IConstant.DEL_FLAG_0;
                        } else {
                            //
                            String[] strings = tatle.split("\\.");
                            if (strings.length > 1 && Double.parseDouble(strings[1]) > 0) {
                                tatle = (Integer.parseInt(strings[0]) + 1) + "";
                            }
                        }
                        if (Double.parseDouble ( tatle ) <= 0) {
                            tatle = IConstant.STRING_0;
                        }
                        vp.setPurchaseCounts(tatle);
                    }
                }

                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
                return rtn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            List<Vpartsmachiningmsg> list = new ArrayList<Vpartsmachiningmsg>();
            Vpartsmachiningmsg vsuggestionpurchaseplan = new Vpartsmachiningmsg();
            // 错误消息：数据库操作异常,查询失败!
            vsuggestionpurchaseplan.setMessageCode(IConstant.EMSG0004);
            vsuggestionpurchaseplan.setRetErrFlag(true);
            vsuggestionpurchaseplan.setExceMessage(e.getMessage());
            list.add(vsuggestionpurchaseplan);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
    }

    /**
     * 计算采购数量
     *
     * @param vp
     * @return
     */
    private String getPurchaseNumber(Vpartsmachiningmsg vp) {
        String str1 = vp.getExpandSpace1();
        if (StringUtils.isEmpty(str1)) {
            return IConstant.DEL_FLAG_0;
        }
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_A, vp.getParamStringA());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_B, vp.getParamStringB());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_C, vp.getParamStringC());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_D, vp.getAvgFrequencyUse());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_E, vp.getUsedCounts());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_F, vp.getStockCounts());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_G, vp.getActiveCounts());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_H, vp.getGoingNewCounts());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_I, vp.getGoingOldCounts());
        str1 = str1.replaceAll(IConstant.PROCURES_CYCLE_J, vp.getGoingOldToNewCounts());
        return EvalUtils.eval(str1);
    }

    /**
     * 1）（20160401-20160501）<= （12*7）*1/3
     * {
     * 采购数量1 =采购数量 * （1/3 ）
     * }
     * Else （12*7）*1/3  < （20160601-20160501）<= （12*7）*2/3
     * 采购数量2 =采购数量 * （2/3 ）
     * Else （12*7）*2/3  < （20160601-20160501）<= （12*7)
     * 采购数量3 = 采购数量 *1
     * 在途新刀数量 =采购数量1+采购数量2+采购数量3 ;
     *
     * @param vp
     * @return
     */
    private String getNewNumber(Vpartsmachiningmsg vp) throws SQLException {
        //采购周期(周）
        int procuresCycle = Integer.parseInt(vp.getProcuresCycle());
        int reNewNumber = 0;
        //查询订单信息
        Toolprocured tp = new Toolprocured();
        tp.setToolCode(vp.getToolCode());
        tp.setProcuredCount(BigDecimal.ZERO);
        tp.setDelFlag(IConstant.DEL_FLAG_0);
        List<Toolprocured> tplist = toolprocuredDao.searchListByToolCode(tp);
        long thisTime = new Date().getTime(); //当前时间
        //周期小于1/3
        double d1 = ((procuresCycle * 7) * (1 / (double) 3));
        //周期小于2/3
        double d2 = ((procuresCycle * 7) * (2 / (double) 3));
        double d3 = (procuresCycle * 7);
        for (Toolprocured toolprocured : tplist) {
            long procrdTime = DateFormatUtil.getXtimes(toolprocured.getProcuredTime());
            //天数
            int temp = (int) ((thisTime - procrdTime) / (1000 * 3600 * 24));
            int tempNumber = 0;
            if (toolprocured.getProcuredCount() != null) {
                //未入库数量
                tempNumber = toolprocured.getProcuredCount().intValue();
            }
            if (temp >= d3) {
              //d.当前时间距采购时间差大于采购周期的，按照0计算。
                reNewNumber += 0;
            } else if (temp < d3 && temp >= d2) {
                //当前时间距采购时间差大于采购周期的2/3，并且小于采购周期的，
                // 按照全部采购数量的1/3计算
                reNewNumber += tempNumber * (1 / (double) 3);
            } else if (temp < d2 && temp >= d1) {
                //b.当前时间距采购时间差大于采购周期的1/3，并且小于采购周期2/3的，
                // 按全部采购数量的2/3计算 
                reNewNumber += tempNumber * (2 / (double) 3);
            } else {
                //a.当前时间距采购时间差在采购周期的1/3以内，按照全部采购数量计算;
                reNewNumber += tempNumber;
            }
        }
        return reNewNumber + "";
    }

    /**
     * （刀具数量*平均使用次数－已使用次数总和）/平均使用次数”
     * (在途旧刀数量*平均使用次数－已使用次数总和）/平均使用次数;
     *
     * @param vp
     * @return
     */
    private String getActiveNumber(Vpartsmachiningmsg vp, String states) {
        //平均使用次数(以前)
        //int avgCount = (int) Double.parseDouble(vp.getAvgFrequencyUse());
       ////平均使用次数 = 刃口数(现在)
        int avgCount = (int) Double.parseDouble(vp.getAvgFrequencyUse());

        //刀具数量
        int activeNum = 0;
        if (IConstant.DEL_FLAG_0.equals(states)) {
            activeNum = Integer.parseInt(vp.getActiveCounts());
        } else {
            activeNum = Integer.parseInt(vp.getGoingOldCounts());
        }
        //已使用次数总和
        int usedNum = Integer.parseInt(vp.getUsedCounts());
        int reVal = ((activeNum * avgCount) - usedNum) / avgCount;
        if (reVal < 0) {
            return IConstant.DEL_FLAG_0;
        }
        return reVal + "";
    }

    /**
     * 单位时间内（所选时间段内）刀具的使用次数，
     * 可根据参考时间段内同种型号刀具的换装次数、加工次数或修磨次数获得。
     *
     * @param toolID
     * @return
     */
    private String seachUsedNumber(String toolID, Vpartsmachiningmsg vp) throws SQLException {
        Toolsmachining entity = new Toolsmachining();
        int count = 0;
        //开始时间
        entity.setDateStar(vp.getDateStar());
        //结束时间
        entity.setDateEnd(vp.getDateEnd());
     /*  //刀具类型
        String toolType = vp.getToolConsumetype();
        if (IConstant.BAND_TYPE_0.equals(toolType)) {
            //钻头
        } else {
            //刀片
        } */
        entity.setToolID(toolID);
        entity.setPartsID ( vp.getPartsID () );
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        if (vp.getDateEnd() != null && vp.getDateStar() != null) {
            count = toolsmachiningDao.searchCountBeWeenAnd(entity);
        } else {
            count = toolsmachiningDao.searchCountByToolID(entity);
        }
        return count + "";
    }

    @Override
    public Object werkAdd(List<Werkzeugeanforderun> list) throws SQLException {
        return werkzeugeanforderunDao.insertBatchs(list);
    }

    @Override
    public List<Werkzeugeanforderun> getWerList() throws SQLException {
        return werkzeugeanforderunDao.searchByLists();
    }

    public int getUpdata(Werkzeugeanforderun entity) throws SQLException {
        return werkzeugeanforderunDao.updateNonQuery(entity);
    }

    @Override
    public int getUpdate(Map<String, Object> werMap) throws SQLException {
        Map<String, Object> rtn = new HashMap<String, Object>();
        int supdata = 0;
        Werkzeugeanforderun werEntity = new Werkzeugeanforderun();
        Werkzeugeanforderun wer = new Werkzeugeanforderun();
        try {
            for (Map.Entry<String, Object> entry : werMap.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                //条件

                //需要修改的值map的V值
                werEntity = (Werkzeugeanforderun) entry.getValue();
                wer.setDemandCodeWhere(werEntity.getDemandCode());
                wer.setMaterialNrWhere (werEntity.getMaterialNr());
                wer.setDemandCode(werEntity.getDemandCode());
                wer.setUnitPreis(werEntity.getUnitPreis());
                wer.setBestellBezeichnung(werEntity.getBestellBezeichnung());
                wer.setMenge(werEntity.getMenge());
                wer.setEinheit(werEntity.getEinheit());
                wer.setBetrag(werEntity.getBetrag());
                wer.setLieferant(werEntity.getLieferant());
                wer.setLiefertermin(werEntity.getLiefertermin());
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

                supdata = werkzeugeanforderunDao.updates(wer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supdata;
    }

    @Override
    public List<Toolprocured> getToolpro() throws SQLException {
        return toolprocuredDao.searchByToolList();
    }

    @Override
    public Object toolproAdd(Toolprocured toolEntiy) throws SQLException {
        return toolprocuredDao.insert(toolEntiy);
    }

    @Override
    public int getupdateTool(List<Werkzeugeanforderun> werList) throws SQLException {
        int toolprod = 0;
        Toolprocured toolprocured = new Toolprocured();
        for (Werkzeugeanforderun werkzeugeanforderun : werList) {
            toolprocured.setProcuredBatchWhere(werkzeugeanforderun.getDemandCode());
            toolprocured.setToolCodeWhere(werkzeugeanforderun.getMaterialNr());
            //材料号
            toolprocured.setToolCode(werkzeugeanforderun.getMaterialNr());
            //订单号
            toolprocured.setToolsOrdeNO(werkzeugeanforderun.getDemandCode());

            //采购日期
            toolprocured.setProcuredTime(Ctl.dateFormat(werkzeugeanforderun.getTypingDate()));
            //采购单价
            toolprocured.setUnitPrice(werkzeugeanforderun.getUnitPreis());

            //是否入库
            toolprocured.setProcuredInto(IConstant.PROCURED_TYPE_1);
            //是否付费
            toolprocured.setProcuredPaying(IConstant.PROCURED_PAYING_9);
            //更新时间
            toolprocured.setUpdateTime(new Date());
            //采购类型
            String wer = werkzeugeanforderun.getMaterialNr();
            if ("X".equalsIgnoreCase(wer.substring(0, wer.length() - 1))) {
                toolprocured.setProcuredType(IConstant.PROCURED_TYPE_0);
            } else {
                toolprocured.setProcuredType(IConstant.PROCURED_TYPE_1);
            }
            toolprocured.setDelFlag(IConstant.DEL_FLAG_0);
            toolprocured.setCreateTime(new Date());
            toolprocured.setUpdateTime(new Date());
            //			采购数量
            toolprocured.setProcuredNumber(werkzeugeanforderun.getMenge());
            toolprod = +toolprocuredDao.updateNonQuery(toolprocured);
        }

        return toolprod;
    }

    @Override
    public Map<String, Object> checkInput(Map<String, Object> param, String langValue, String customer, int i) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        Map<String, String> map = new HashMap<String, String>();
        Formulas entity = new Formulas();
        try {

            if (StringUtils.isEmpty(param.get("datalr").toString())) {
                map.put("datalr", MessageReSource.getMessageBox(IConstant.ERROR_MSG_19, "", langValue));
            } else if (TestJava.validateExpression(param.get("datalr").toString()) == true) {
                entity.setFormulaMsg(param.get("datalr").toString());
            } else {
                map.put("datalr", MessageReSource.getMessageBox(IConstant.ERROR_MSG_19, "", langValue));
            }
            if (StringUtils.isEmpty(param.get("datals").toString())) {
                map.put("datals", MessageReSource.getMessageBox(IConstant.ERROR_MSG_20, "", langValue));
            } else {
                entity.setFormulaName(param.get("datals").toString());
            }
            if (StringUtils.isEmpty(param.get("twt1").toString())) {
                map.put("twt1", MessageReSource.getMessageBox(IConstant.ERROR_MSG_21, "", langValue));
            } else {
                entity.setFormulaDesc(param.get("twt1").toString());
            }

            if (i == 2) {
                entity.setFormulaIDWhere(new BigDecimal(param.get("id").toString()));
            }
            if (map.size() <= 0) {
                entity.setUpdateTime(new Date());
                entity.setUpdateUser(customer);
                entity.setCreateTime(new Date());
                entity.setCreateUser(customer);
                entity.setDelFlag(IConstant.DEL_FLAG_0);

                rtn.put("data", entity);
                rtn.put("status", IConstant.RESULT_CODE_2);
            } else {
                rtn.put("message", map);
                rtn.put("status", IConstant.USER_ERR_FLAG_1);
            }


        } catch (Exception e) {
            Formulas formulas = new Formulas();
            //错误消息：数据库操作异常，查询失败!
            formulas.setMessageCode(IConstant.EMSG0004);
            formulas.setRetErrFlag(true);
            formulas.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", formulas);
        }

        return rtn;
    }

    @Override
    public Map<String, Object> partAdd(Formulas formulas, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            formulasDao.insert(formulas);
            //成功消息：插入成功
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0004, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_2);

        } catch (SQLException e) {
            Formulas entity = new Formulas();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode(IConstant.EMSG0007);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);

        }
        return rtn;
    }

    @Override
    public Map<String, Object> partList(Formulas formulas) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            List<Formulas> list = (List<Formulas>) formulasDao.searchByList(formulas);

            if (list.size() <= 0) {
                list = new ArrayList<Formulas>();
                Formulas formulas1 = new Formulas();
                formulas1.setMessageCode(IConstant.EMSG0001);
                formulas1.setRetErrFlag(true);
                list.add(formulas1);
                rtn.put("rows", null);
                rtn.put("error", list);
                rtn.put("listerror", list);
                return rtn;
            } else {
                int total = formulasDao.searchByCount(formulas);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (formulas.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

            }

        } catch (SQLException e) {
            List<Formulas> list = new ArrayList<Formulas>();
            Formulas formulas1 = new Formulas();
            formulas1.setMessageCode(IConstant.EMSG0004);
            formulas1.setRetErrFlag(true);
            formulas1.setExceMessage(e.getMessage());
            list.add(formulas1);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
        return rtn;
    }

    @Override
    public Map<String, Object> formuldel(Formulas formulas, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 更新失败! 进行数据排他验证
            Formulas forlist = new Formulas();
            forlist.setFormulaID(formulas.getFormulaIDWhere());
            //entity.setUpdateTime(position.getUpdateTimeWhere());
            //entity.setUpdateUser(position.getUpdateUserWhere());

            List<Formulas> list = (List<Formulas>) formulasDao.searchByList(forlist);
            if (list == null || list.size() == 0) {
                forlist = new Formulas();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                forlist.setMessageCode(IConstant.WMSG0009);
                forlist.setRetErrFlag(true);
                rtn.put("error", forlist);
                rtn.put("data", null);
                return rtn;
            }
            // 删除成功
            int ret = formulasDao.updateNonQuery(formulas);
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0003, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            Formulas entity = new Formulas();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode(IConstant.EMSG0008);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

    @Override
    public Map<String, Object> getKey(Formulas entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Formulas> list = (List<Formulas>) formulasDao.searchByList(entity);
            if (list.size() <= 0) {
                Formulas formulas = new Formulas();
                //消息：检索为0
                formulas.setMessageCode(IConstant.EMSG0001);
                formulas.setRetErrFlag(true);
                rtn.put("data", null);
                rtn.put("error", formulas);
                rtn.put("status", -2);
                return rtn;

            } else {
                rtn.put("data", list.get(0));
                rtn.put("status", 0);
                return rtn;
            }

        } catch (SQLException e) {
            Formulas formulas = new Formulas();
            //错误消息：数据库操作异常，查询失败!
            formulas.setMessageCode(IConstant.EMSG0004);
            formulas.setRetErrFlag(true);
            formulas.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", formulas);
            return rtn;
        }
    }

    @Override
    public Map<String, Object> partEdit(Formulas formulas, String s, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 删除失败! 进行数据排他验证
            Formulas entity = new Formulas();

            List<Formulas> list = (List<Formulas>) formulasDao.searchByList(entity);
            if (list == null || list.size() == 0) {
                entity = new Formulas();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);
            }
            // 更新项目打印成功
            @SuppressWarnings("unused")
            int ret = formulasDao.updateNonQuery(formulas);
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0005, "", langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);


        } catch (SQLException e) {
            Formulas entity = new Formulas();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode(IConstant.EMSG0006);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);

        }
        return rtn;
    }

    @Override
    public List<Parts> getParts() {
        Parts entity = null;
		Parts parts = null;
		try {
			entity = new Parts();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Parts> list = (List<Parts>) partsDao.searchByList(entity);

//			for (Equipment equipment : list2) {
//				list.add(equipment);
//			}
			if (list.size() <= 0) {
				list = new ArrayList<Parts>();
				parts = new Parts();
				// 消息：检索为0
				parts.setMessageCode(IConstant.EMSG0001);
				parts.setRetErrFlag(false);
				list.add(parts);
				return list;
			}
			return list;

		} catch (SQLException e) {
			List<Parts> list = new ArrayList<Parts>();
			parts = new Parts();
			// 错误消息：数据库操作异常，查询失败!
			parts.setMessageCode(IConstant.EMSG0004);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			list.add(parts);
			return list;
		}
    }


}



