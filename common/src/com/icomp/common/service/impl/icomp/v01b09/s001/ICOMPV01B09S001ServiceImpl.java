package com.icomp.common.service.impl.icomp.v01b09.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b09.s001.ICOMPV01B09S001Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.ToolDao;
import com.icomp.dao.VlibrarycodeDao;
import com.icomp.dao.VtoolDao;
import com.icomp.entity.base.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.*;

public class ICOMPV01B09S001ServiceImpl extends BaseService implements
        ICOMPV01B09S001Service {

    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private VtoolDao vtoolDao;

    public void setVtoolDao(VtoolDao vtoolDao) {
        this.vtoolDao = vtoolDao;
    }

    private VlibrarycodeDao vlibrarycodeDao;


    public void setVlibrarycodeDao(VlibrarycodeDao vlibrarycodeDao) {
        this.vlibrarycodeDao = vlibrarycodeDao;
    }

    /**
     * toolcode模糊查询
     *
     * @param entity 查询条件
     * @return 查询结果
     */
    public Map<String, Object> getListToolcodeF(Vtool entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Vtool> list = (List<Vtool>) vtoolDao.searchByList(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Vtool>();
                Vtool languagetable = new Vtool();
                //消息：检索为0
                languagetable.setMessageCode(IConstant.EMSG0001);
                languagetable.setRetErrFlag(true);
                list.add(languagetable);
                rtn.put("rows", null);
                rtn.put("error", list);

            } else {
                int total = vtoolDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
                        / IConstant.ROWSIZE);

            }
            return rtn;
        } catch (SQLException e) {
            List<Vtool> list = new ArrayList<Vtool>();
            Vtool comlist = new Vtool();
            //错误消息：数据库操作异常，查询失败!
            comlist.setMessageCode(IConstant.EMSG0004);
            comlist.setRetErrFlag(true);
            comlist.setExceMessage(e.getMessage());
            list.add(comlist);
            rtn.put("rows", null);
            rtn.put("error", list);

        }
        return rtn;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getList(Vtool entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Vtool> list = (List<Vtool>) vtoolDao.searchByList(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Vtool>();
                Vtool languagetable = new Vtool();
                //消息：检索为0
                languagetable.setMessageCode(IConstant.EMSG0001);
                languagetable.setRetErrFlag(true);
                list.add(languagetable);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;
            } else {
                int total = vtoolDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
                        / IConstant.ROWSIZE);
                return rtn;
            }

        } catch (SQLException e) {
            List<Vtool> list = new ArrayList<Vtool>();
            Vtool comlist = new Vtool();
            //错误消息：数据库操作异常，查询失败!
            comlist.setMessageCode(IConstant.EMSG0004);
            comlist.setRetErrFlag(true);
            comlist.setExceMessage(e.getMessage());
            list.add(comlist);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }

    }

    /**
     * 刀具参数验证
     *
     * @param param
     * @param langValue
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> checkInput(Map<String, Object> param, String uploadFileName,
                                          String langCode, String langValue, String userId, int checkType)
            throws BusinessException {
        Map<String, Object> rtn = new HashMap<String, Object>();

        Tool tool = new Tool();
        Map<String, String> map = new HashMap<String, String>();
        try {
            //图片类型
            if (StringUtils.isEmpty(uploadFileName)) {
            } else {
                String str = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
               /* if (" .jpg .jpeg .gif .png .bmp".indexOf(str) == -1) {
                    //请上传.jpg .jpeg .gif .png .bmp格式的图片!
                    map.put("Div", MessageReSource.getMessageBox(
                            IConstant.EWMSG0262, langCode, langValue));
                }*/
            }
            //刀具编码(新建做唯一性验证,编辑不可变更)
            if (checkType == 1)
                if (StringUtils.isEmpty(param.get("DivToolCode").toString())) {
                    map.put("DivToolCode", MessageReSource.getMessageBox(
                            IConstant.WMSG0055, langCode, langValue));
                } else {
                    //唯一性验证
                    tool.setToolCode(param.get("DivToolCode").toString());
                    tool.setDelFlag(IConstant.DEL_FLAG_0);
                    List<Tool> list = (List<Tool>) toolDao.searchByList(tool);
                    if (list.size() > 0) {
                        //您所新建的合成刀具编码已存在!
                        map.put("DivToolCode", MessageReSource.getMessageBox(
                                IConstant.WMSG0182, langCode, langValue));
                    }
                    tool.setToolCode(param.get("DivToolCode").toString());
                }

            // 验证刀具名称
            if (StringUtils.isEmpty(param.get("DivToolName").toString())) {
                map.put("DivToolName", MessageReSource.getMessageBox(
                        IConstant.WMSG0081, langCode, langValue));
            } else {
                tool.setToolName(param.get("DivToolName").toString());
            }
            // 验证刀具分类
            if (StringUtils.isEmpty(param.get("DivToolType").toString())) {
                map.put("DivToolType", MessageReSource.getMessageBox(
                        IConstant.WMSG0056, langCode, langValue));
            } else {
                tool.setToolType(param.get("DivToolType").toString());
            }

            // 验证刀具规格型号
            if (StringUtils.isEmpty(param.get("DivToolSpecifications").toString())) {
                map.put("DivToolSpecifications", MessageReSource.getMessageBox(
                        IConstant.WMSG0057, langCode, langValue));
            } else {
                tool.setToolSpecifications(param.get("DivToolSpecifications").toString());
            }
//            // 验证采购周期
//            if (StringUtils.isEmpty(param.get("DivPurchasingCycle").toString())) {
//                //请输入采购周期!
//                map.put("DivPurchasingCycle", MessageReSource.getMessageBox(
//                        IConstant.EWMSG0263, langCode, langValue));
//            } else if (!checkOutNum(param.get("DivPurchasingCycle").toString())) {
//                //采购周期请填入数字!
//                map.put("DivPurchasingCycle", MessageReSource.getMessageBox(
//                        IConstant.EWMSG0264, langCode, langValue));
//            } else if (new BigDecimal(param.get("DivPurchasingCycle").toString()).compareTo(BigDecimal.ZERO) != 1) {//不大于0
//                //采购周期应该大于0!
//                map.put("DivPurchasingCycle", "采购周期应该大于0!");
//            } else {
//                tool.setPurchasingCycle(new BigDecimal(param.get("DivPurchasingCycle").toString()));
//            }
            // 刀具每盒数量(改为刃口数)
            if (StringUtils.isEmpty(param.get("DivToolCutNumber").toString())) {
                map.put("DivToolCutNumber", MessageReSource.getMessageBox(
                        IConstant.WMSG0059, langCode, langValue));
            } else if (!checkOutNum(param.get("DivToolCutNumber").toString())) {
                map.put("DivToolCutNumber", MessageReSource.getMessageBox(
                        IConstant.WMSG0060, langCode, langValue));
            } else if (new BigDecimal(param.get("DivToolCutNumber").toString()).compareTo(BigDecimal.ZERO) != 1) {//DivToolSharpenCriterion不大于0
                //每盒数量应该大于0!
                map.put("DivToolCutNumber", "每盒数量应该大于0!");
            } else {
                //刃口数量
                tool.setToolCutNumber(new BigDecimal(param.get("DivToolCutNumber").toString()));
            }
            //最大值


            if (StringUtils.isEmpty(param.get("DivToolMax").toString())) {
                map.put("DivToolMax", MessageReSource.getMessageBox(IConstant.EWMSGL0001, langCode, langValue));
            } else if (!checkOutNum(param.get("DivToolMax").toString())){map.put("DivToolMax", MessageReSource.getMessageBox(IConstant.EWMSGL0002, langCode, langValue));
            }else if(new BigDecimal(param.get("DivToolMax").toString()).compareTo(BigDecimal.ZERO) != 1) {
                int tm = Integer.parseInt(param.get("DivToolMax").toString());
                if (tm < 0) {
                    map.put("DivToolMax", MessageReSource.getMessageBox(IConstant.EWMSGL0003, langCode, langValue));

                } else if (tm > 1000) {
                    map.put("DivToolMax", MessageReSource.getMessageBox(IConstant.EWMSGL0004, langCode, langValue));
                }
            }else{
                tool.setToolMax(new BigDecimal(param.get("DivToolMax").toString()));
            }
            //最小值
            if (StringUtils.isEmpty(param.get("DivToolMin").toString())) {
                map.put("DivToolMin", MessageReSource.getMessageBox(IConstant.EWMSGL0005, langCode, langValue));
            } else if (!checkOutNum(param.get("DivToolMin").toString())) {map.put("DivToolMax", MessageReSource.getMessageBox(
                    IConstant.EWMSGL0006, langCode, langValue));
            } else if (Integer.parseInt(param.get("DivToolMin").toString())<0 ) {//DivToolLength不大于0
                //刀具长度应大于0
                map.put("DivToolMin", MessageReSource.getMessageBox(
                        IConstant.EWMSGL0008, langCode, langValue));
            } else {
                tool.setToolMin(new BigDecimal(param.get("DivToolMin").toString()));
            }
            //备刀库最小值
            if (StringUtils.isEmpty(param.get("DivBMin").toString())) {
                map.put("DivBMin", MessageReSource.getMessageBox(IConstant.EWMSGL0014, langCode, langValue));
            } else if (!checkOutNum(param.get("DivBMin").toString())) {map.put("DivBMin", MessageReSource.getMessageBox(
                    IConstant.EWMSGL0012, langCode, langValue));
            } else if (Integer.parseInt(param.get("DivBMin").toString())<0 ) {//DivToolLength不大于0
                //刀具长度应大于0
                map.put("DivBMin", MessageReSource.getMessageBox(
                        IConstant.EWMSGL0013, langCode, langValue));
            } else {
                tool.setBeiMin(new BigDecimal(param.get("DivBMin").toString()));
            }
            //备刀库最大值
            if (StringUtils.isEmpty(param.get("DivBMax").toString())) {
                map.put("DivBMax", MessageReSource.getMessageBox(IConstant.EWMSGL0010, langCode, langValue));
            } else if (!checkOutNum(param.get("DivBMax").toString())) {map.put("DivBMax", MessageReSource.getMessageBox(
                    IConstant.EWMSGL0011, langCode, langValue));
            } else if (Integer.parseInt(param.get("DivBMax").toString())<0 ) {//DivToolLength不大于0
                //刀具长度应大于0
                map.put("DivBMax", MessageReSource.getMessageBox(
                        IConstant.EWMSGL0009, langCode, langValue));
            } else {
                tool.setBeiMax(new BigDecimal(param.get("DivBMax").toString()));
            }
            // 验证刀具供应商
//			if (StringUtils.isEmpty(param.get("DivToolSupplier").toString())) {
//				map.put("DivToolSupplier", MessageReSource.getMessageBox(
//						IConstant.WMSG0061, langCode, langValue));
//			}else{
//				tool.setToolSupplier(param.get("DivToolSupplier").toString());
//			}
//			// 验证刀具品牌
//			if (StringUtils.isEmpty(param.get("DivToolBrand").toString())) {
//				map.put("DivToolBrand", MessageReSource.getMessageBox(
//						IConstant.WMSG0062, langCode, langValue));
//			}else{
//				tool.setToolBrand(param.get("DivToolBrand").toString());
//			}
            // 验证刀具消耗类别
            if (StringUtils.isEmpty(param.get("DivToolConsumetype").toString())) {
                map.put("DivToolConsumetype", MessageReSource.getMessageBox(
                        IConstant.WMSG0063, langCode, langValue));
            } else {
                tool.setToolConsumetype(param.get("DivToolConsumetype").toString());
            }

            if (StringUtils.isEmpty(param.get("DivLibraryCode").toString())) {
                tool.setLibraryCodeID("");
            } else {
                tool.setLibraryCodeID(param.get("DivLibraryCode").toString());
//                List<Tool> toolList = (List<Tool>) toolDao.searchByList(searchentity);
//                if ((checkType == 1 && toolList.size() > 0)) {
//                    //该库位码已经被占用!
//                    map.put("DivLibraryCode", MessageReSource.getMessageBox(
//                            IConstant.EWMSG0265, langCode, langValue));
//                }
//                if (checkType == 2 && toolList.size() > 1) {
//                    //该库位码已经被占用!
//                    for (Tool tentity : toolList) {
//                        if (!tentity.getToolID().equals(param.get("DivToolID").toString())) {
//                            map.put("DivLibraryCode", MessageReSource.getMessageBox(
//                                    IConstant.EWMSG0265, langCode, langValue));
//                            break; //结束循环
//                        }
//                    }
//                    map.put("DivSysteCodeShow", MessageReSource.getMessageBox(
//                            IConstant.EWMSG0265, langCode, langValue));
//                }

            }

            // 2017/11/15 王冉 追加↓↓↓　dazhong@YMSC
            //刀具单价
            if (!checkOutNum(param.get("DivToolPrice").toString())) {

                map.put("DivToolPrice",IConstant.EWMSGL004);
            } else if (Double.valueOf(param.get("DivToolPrice").toString())<0 ) {//DivToolLength不大于0
                //刀具单价大于0
                map.put("DivToolPrice",IConstant.EWMSGL006);
            } else {
                tool.setToolPrice(new BigDecimal(param.get("DivToolPrice").toString()));
            }

            //平均修磨单价
            if (StringUtils.isEmpty(param.get("DivToolAveragePrice").toString())) {
                tool.setToolAveragePrice(new BigDecimal(0));
            }
            else if (!checkOutNum(param.get("DivToolAveragePrice").toString())) {
                map.put("DivToolAveragePrice",IConstant.EWMSGL005);
            } else if (Double.valueOf(param.get("DivToolAveragePrice").toString())<0 ) {//DivToolLength不大于0
                //平均修磨单价大于0
                map.put("DivToolAveragePrice",IConstant.EWMSGL007);
            } else {
                tool.setToolAveragePrice(new BigDecimal(param.get("DivToolAveragePrice").toString()));
            }

            tool.setToolParametersType(param.get("DivToolParametersType").toString());
            // 2017/11/15 王冉 追加↑↑↑　dazhong@YMSC


            /**
             *		如果是0刀具-0可刃磨钻头:验证"周转量 "、"复磨标准 "、“可刃磨长度”、“刀具长度 ”
             *		如果是0刀具-非钻头:验证"周转量 "、“可使用次数”
             */

            if (tool.getToolType() != null && tool.getToolType() != null) {
                //刀具类型
                if (tool.getToolType().equals(IConstant.STRING_0)) {//刀具
                    /**
                     * 周转量(非空验证,数字验证)
                     * 刀具都有周转量
                     */
//                    if (StringUtils.isEmpty(param.get("DivToolTurnover").toString())) {
//                        map.put("DivToolTurnover", MessageReSource.getMessageBox(
//                                IConstant.WMSG0074, langCode, langValue));
//                    } else if (!checkOutNum(param.get("DivToolTurnover").toString())) {
//                        map.put("DivToolTurnover", MessageReSource.getMessageBox(
//                                IConstant.WMSG0075, langCode, langValue));
//                    } else {
//                        tool.setToolTurnover(new BigDecimal(param.get("DivToolTurnover").toString()));
//                    }

                    //消耗类型
                    if (tool.getToolConsumetype().equals(IConstant.STRING_0)) {//0可刃磨钻头
                        /**
                         *如果是0刀具-0可刃磨钻头:验证"周转量 "、"复磨标准 "、“可刃磨长度”、“刀具长度 ”
                         *“可使用次数”计算得出
                         */
                        // 复磨标准(非空验证,数字验证)
                        if (StringUtils.isEmpty(param.get("DivToolSharpenCriterion").toString())) {
                            map.put("DivToolSharpenCriterion", MessageReSource.getMessageBox(
                                    IConstant.WMSG0068, langCode, langValue));
                        } else if (!checkOutNum(param.get("DivToolSharpenCriterion").toString())) {
                            map.put("DivToolSharpenCriterion", MessageReSource
                                    .getMessageBox(IConstant.WMSG0069, langCode, langValue));
                        } else if (new BigDecimal(param.get("DivToolSharpenCriterion").toString()).compareTo(BigDecimal.ZERO) != 1) {//DivToolSharpenCriterion不大于0
                            //复磨标准应大于0!
                            map.put("DivToolSharpenCriterion", MessageReSource.getMessageBox(
                                    IConstant.EWMSG0266, langCode, langValue));
                        } else {
                            tool.setToolSharpenCriterion(new BigDecimal(param.get("DivToolSharpenCriterion").toString()));
                        }
                        // 刀具长度(非空验证,数字验证)
//                        if (StringUtils.isEmpty(param.get("DivToolLength").toString())) {
//                            map.put("DivToolLength", MessageReSource.getMessageBox(
//                                    IConstant.WMSG0070, langCode, langValue));
//                        } else if (!checkOutNum(param.get("DivToolLength").toString())) {
//                            map.put("DivToolLength", MessageReSource.getMessageBox(
//                                    IConstant.WMSG0071, langCode, langValue));
//                        } else if (new BigDecimal(param.get("DivToolLength").toString()).compareTo(BigDecimal.ZERO) != 1) {//DivToolLength不大于0
//                            //刀具长度应大于0
//                            map.put("DivToolLength", MessageReSource.getMessageBox(
//                                    IConstant.WMSG0257, langCode, langValue));
//                        } else {
//                            tool.setToolLength(new BigDecimal(param.get("DivToolLength").toString()));
//                        }
                        //可刃磨次数
                        if (StringUtils.isEmpty(param.get("DivToolNumeber").toString())) {
                            // 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
                            map.put("DivToolLength",IConstant.EWMSGL001);
//                            map.put("DivToolLength", MessageReSource.getMessageBox(
//                                    IConstant.EWMSGL001, langCode, langValue));
                            // 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC
                        } else if (!checkOutNum(param.get("DivToolNumeber").toString())) {
                            map.put("DivToolLength", MessageReSource.getMessageBox(
                                    IConstant.EWMSGL002, langCode, langValue));
                        } else if (new BigDecimal(param.get("DivToolNumeber").toString()).compareTo(BigDecimal.ZERO) != 1) {//DivToolLength不大于0
                            //次数应大于0
                            map.put("DivToolNumeber", MessageReSource.getMessageBox(
                                    IConstant.EWMSGL003, langCode, langValue));
                        } else {
                            tool.setToolNumber(new BigDecimal(param.get("DivToolNumeber").toString()));
                        }

                        // 验证可刃磨长度(非空验证,数字验证)
                        if (StringUtils.isEmpty(param.get("DivToolSharpenLength").toString())) {
                            map.put("DivToolSharpenLength", MessageReSource.getMessageBox(
                                    IConstant.WMSG0072, langCode, langValue));
                        } else if (!checkOutNum(param.get("DivToolSharpenLength").toString())) {
                            map.put("DivToolSharpenLength", MessageReSource.getMessageBox(
                                    IConstant.WMSG0073, langCode, langValue));
                        } else if (new BigDecimal(param.get("DivToolSharpenLength").toString()).compareTo(BigDecimal.ZERO) != 1) {//DivToolSharpenLength不大于0
                            //可刃磨长度应大于0
                            map.put("DivToolSharpenLength", MessageReSource.getMessageBox(
                                    IConstant.WMSG0258, langCode, langValue));
                        } else {
                            tool.setToolSharpenLength(new BigDecimal(param.get("DivToolSharpenLength").toString()));
                        }
                        //刀具长度 大于 可刃磨长度
//                        if (map.size() <= 0
//                                && !StringUtils.isEmpty(param.get("DivToolLength").toString())//刀具长度
//                                && !StringUtils.isEmpty(param.get("DivToolSharpenLength").toString())//可刃磨长度
//                                ) {
//                            BigDecimal toolLength = new BigDecimal(param.get("DivToolLength").toString());
//                            BigDecimal toolSharpenLength = new BigDecimal(param.get("DivToolSharpenLength").toString());
//                            if (toolLength.compareTo(toolSharpenLength) < 0) { //toolLength<toolSharpenLength
//                                //刀具长度应大于可刃磨长度!
//                                map.put("DivToolLength", "刀具长度应大于 可刃磨长度!");
//                            }
                        if (StringUtils.isEmpty(param.get("DivToolGrinding").toString())) {
                            map.put("DivToolGrinding", MessageReSource.getMessageBox(
                                    IConstant.WMSG0063, langCode, langValue));
                        } else {
                            tool.setToolGrinding(param.get("DivToolGrinding").toString());
                        }
//
//                        }
                        //如果是刀具-可刃磨钻头，其"可使用次数"后台算出
                        if (map.size() <= 0
                                && !StringUtils.isEmpty(param.get("DivToolSharpenLength").toString())
                                && !StringUtils.isEmpty(param.get("DivToolSharpenCriterion").toString())) {
                            //可使用次数=可刃磨长度/复磨标准
                            //divide 除法无论正负,只要整数
                            BigDecimal toolSharpennum = new BigDecimal(param.get("DivToolSharpenLength").toString()).divide(new BigDecimal(param.get("DivToolSharpenCriterion").toString()), 0, RoundingMode.DOWN);
                            //toolSharpennum小于1
                            if (toolSharpennum.compareTo(BigDecimal.ONE) == -1) {
                                //请调整可刃磨长度与复磨标准的比例,至少为1
                                map.put("DivToolSharpenCriterion", MessageReSource.getMessageBox(
                                        IConstant.EWMSG0267, langCode, langValue));
                                map.put("DivToolSharpenLength", "");
                            } else {
                                tool.setToolSharpennum(toolSharpennum);//可使用次数
                            }
                        }
                    } else {
                        /**
                         *如果是0刀具-非钻头:验证"周转量 "、“可使用次数”
                         */
                        // 验证可使用次数(非空验证,数字验证)
                        if (StringUtils.isEmpty(param.get("DivToolSharpennum").toString())) {
                            map.put("DivToolSharpennum", MessageReSource.getMessageBox(
                                    IConstant.WMSG0066, langCode, langValue));
                        } else if (!isPositiveInteger(param.get("DivToolSharpennum").toString())) {
                            //请输入整数
                            map.put("DivToolSharpennum", MessageReSource.getMessageBox(
                                    IConstant.EWMSG0268, langCode, langValue));
                        } else if (new BigDecimal(param.get("DivToolSharpennum").toString()).compareTo(BigDecimal.ONE) == -1) {//DivToolSharpennum小于1
                            //可使用次数至少为1
                            map.put("DivToolSharpennum", MessageReSource.getMessageBox(
                                    IConstant.EWMSG0269, langCode, langValue));
                        } else {
                            tool.setToolSharpennum(new BigDecimal(param.get("DivToolSharpennum").toString()));
                        }
                        String divToolNumeber = (String) param.get("DivToolNumeber");
                        if (StringUtils.isEmpty(divToolNumeber)) {
                            // 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
                            map.put("DivToolLength",IConstant.EWMSGL001);
//                            map.put("DivToolLength", MessageReSource.getMessageBox(
//                                    IConstant.EWMSGL001, langCode, langValue));
                            // 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC
                        } else if (!checkOutNum(divToolNumeber)) {
                            map.put("DivToolLength", MessageReSource.getMessageBox(
                                    IConstant.EWMSGL002, langCode, langValue));
                        } else if (Integer.parseInt(divToolNumeber) < 1) {//DivToolLength不大于0
                            //次数应大于0
                            map.put("DivToolNumeber", "刃磨次不能少于1次");
                        } else {
                            tool.setToolNumber(new BigDecimal(param.get("DivToolNumeber").toString()));
                        }
                        tool.setToolSharpenLength(BigDecimal.ZERO);// 复磨标准(非空验证,数字验证)
                        tool.setToolLength(BigDecimal.ZERO);// 刀具长度(非空验证,数字验证)
                        tool.setToolSharpenCriterion(BigDecimal.ZERO);// 验证可刃磨长度(非空验证,数字验证)
                        // 2017/08/26 宋健 追加↓↓↓　dazhong@YMSC
                        if (StringUtils.isEmpty(param.get("DivToolGrinding").toString())) {
                            map.put("DivToolGrinding", MessageReSource.getMessageBox(
                                    IConstant.WMSG0063, langCode, langValue));
                        } else {
                            tool.setToolGrinding(param.get("DivToolGrinding").toString());
                        }
                        // 2017/08/26 宋健 追加↑↑↑　dazhong@YMSC
                    }
                } else {
                    // 2017/08/26 宋健 变更↓↓↓　dazhong@YMSC
                    String divToolNumeber = (String) param.get("DivToolNumeber");
                    if (StringUtils.isEmpty(divToolNumeber)) {
                        map.put("DivToolLength",IConstant.EWMSGL001);
                    } else if (!checkOutNum(divToolNumeber)) {
                        map.put("DivToolLength", MessageReSource.getMessageBox(
                                IConstant.EWMSGL002, langCode, langValue));
                    } else if (Integer.parseInt(divToolNumeber) < 1) {//DivToolLength不大于0
                        //次数应大于0
                        map.put("DivToolNumeber", "刃磨次不能少于1次");
                    } else {
                        tool.setToolNumber(new BigDecimal(param.get("DivToolNumeber").toString()));
                    }
                    if (StringUtils.isEmpty(param.get("DivToolGrinding").toString())) {
                        map.put("DivToolGrinding", MessageReSource.getMessageBox(
                                IConstant.WMSG0063, langCode, langValue));
                    } else {
                        tool.setToolGrinding(param.get("DivToolGrinding").toString());
                    }
                    // 2017/08/26 宋健 变更↑↑↑　dazhong@YMSC
                    tool.setToolSharpennum(new BigDecimal("9999"));
                    tool.setToolSharpenLength(BigDecimal.ZERO);// 复磨标准(非空验证,数字验证)
                    tool.setToolLength(BigDecimal.ZERO);// 刀具长度(非空验证,数字验证)
                    tool.setToolSharpenCriterion(BigDecimal.ZERO);// 验证可刃磨长度(非空验证,数字验证)

                }
            }

            if (map.size() > 0) {//返回错误消息
                rtn.put("message", map);
                rtn.put("status", IConstant.RESULT_CODE_2);
                return rtn;
            } else if (map.size() <= 0 && checkType == 1) {// 如果是新增
                tool.setToolID(NextKeyValue.getNextkeyvalue(IConstant.TOOL, IConstant.TOOL_ID, userId));// 取得表主键
                tool.setToolIDWhere(tool.getToolID());
                tool.setCreateTime(new Date());// 创建时间
                tool.setCreateUser(userId);// 创建者
                tool.setUpdateTime(new Date());// 更新时间
                tool.setUpdateUser(userId);// 更新者
                tool.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tool.setVersion(BigDecimal.ZERO);// 版本号
                rtn.put("data", tool);
                rtn.put("status", IConstant.RESULT_CODE_2);
                return rtn;
            } else if (map.size() <= 0 && checkType == 2) {// 如果是编辑
                // 编辑后的组装参数于新增后不同
                tool.setUpdateTime(new Date());// 更新时间
                tool.setUpdateUser(userId);// 更新者
                tool.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分
                tool.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
                tool.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
                tool.setToolID(param.get("DivToolID").toString());
                // 查询条件
                tool.setToolIDWhere(param.get("DivToolID").toString());
                tool.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
                tool.setUpdateUserWhere(param.get("DivUpdateUser").toString());
                rtn.put("data", tool);
                rtn.put("status", IConstant.RESULT_CODE_2);
                return rtn;
            }
        } catch (SQLException e) {
            Tool entity = new Tool();
            //错误消息：数据库操作异常，查询失败!
            entity.setMessageCode(IConstant.EMSG0004);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
        return rtn;

    }


    /**
     * 新建刀具参数信息
     *
     * @param tool
     * @param langValue
     * @return
     */
    @Override
    public Map<String, Object> toolAdd(Tool tool, String langCode,String langValue) throws BusinessException {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            toolDao.insert(tool);
            //成功消息：插入成功
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0004, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            e.printStackTrace();
            Tool entity = new Tool();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode(IConstant.EMSG0007);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

    /**
     * 根据ID获取刀具信息
     *
     * @param entity 页面查询条件
     * @return 项目打印信息
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getVtoolInfo(Vtool entity)
            throws BusinessException {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Vtool> list = (List<Vtool>) vtoolDao.searchByList(entity);
            if (list.size() <= 0) {
                Vtool vtool = new Vtool();
                //消息：检索为0
                vtool.setMessageCode(IConstant.EMSG0001);
                vtool.setRetErrFlag(true);
                rtn.put("data", null);
                rtn.put("error", vtool);

            } else {
                Vtool tool = list.get(0);
                rtn.put("data", tool);
                return rtn;
            }
        } catch (SQLException e) {
            Vtool vtool = new Vtool();
            //错误消息：数据库操作异常，查询失败!
            vtool.setMessageCode(IConstant.EMSG0004);
            vtool.setRetErrFlag(true);
            vtool.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", vtool);

        }
        return rtn;
    }

    /**
     * 根据ID获取刀具信息
     *
     * @param entity 页面查询条件
     * @return 项目打印信息
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getToolInfo(Tool entity)
            throws BusinessException {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Vtool> list = (List<Vtool>) vtoolDao.searchByList(entity);
            if (list.size() <= 0) {
                Vtool vtool = new Vtool();
                //消息：检索为0
                vtool.setMessageCode(IConstant.EMSG0001);
                vtool.setRetErrFlag(true);
                rtn.put("data", null);
                rtn.put("error", vtool);
                return rtn;
            } else {
                Vtool tool = list.get(0);
                rtn.put("data", tool);
                return rtn;
            }
        } catch (SQLException e) {
            Vtool vtool = new Vtool();
            //错误消息：数据库操作异常，查询失败!
            vtool.setMessageCode(IConstant.EMSG0004);
            vtool.setRetErrFlag(true);
            vtool.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", vtool);
            return rtn;
        }

    }


    /**
     * 编辑刀具参数信息
     *
     * @param tool
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> toolEdit(Tool tool, String langCode,
                                        String langValue) throws BusinessException {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            // 更新失败! 进行数据排他验证
            Tool entity = new Tool();
            entity.setToolID(tool.getToolIDWhere());
            entity.setVersion(tool.getVersionWhere());
            List<Tool> list = (List<Tool>) toolDao.searchByList(entity);
            if (list == null || list.size() == 0) {
                entity = new Tool();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);
                return rtn;
            }
            // 成功消息：更新成功
            @SuppressWarnings("unused")
            int ret = toolDao.updateNonQuery(tool);
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0005, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            Tool entity = new Tool();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode(IConstant.EMSG0006);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }

    }

    /**
     * 刀具参数删除
     *
     * @param tool 页面查询条件
     * @return 刀具参数信息
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> toolDelete(Tool tool, String langCode,
                                          String langValue) throws BusinessException {

        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 删除失败! 进行数据排他验证
            Tool entity = new Tool();
            entity.setToolID(tool.getToolIDWhere());
            entity.setUpdateTime(tool.getUpdateTimeWhere());
            entity.setUpdateUser(tool.getUpdateUserWhere());
            entity.setVersion(tool.getVersionWhere());
            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) toolDao
                    .searchByList(entity);
            if (list == null || list.size() == 0) {
                entity = new Tool();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);
                return rtn;
            }
            // 删除成功
            @SuppressWarnings("unused")
            int ret = toolDao.updateNonQuery(tool);
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0003, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            Position entity = new Position();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode(IConstant.EMSG0008);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

    /**
     * 获取库位码列表
     *
     * @param param 页面查询条件
     * @return 刀具参数信息
     * @throws BusinessException
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
                                                  String langValue) throws BusinessException {
        try {
            Vlibrarycode entity = new Vlibrarycode();
            List<Vlibrarycode> list = (List<Vlibrarycode>) vlibrarycodeDao
                    .searchByList_new(entity);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
