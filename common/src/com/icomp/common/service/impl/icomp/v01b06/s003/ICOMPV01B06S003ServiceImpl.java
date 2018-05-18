package com.icomp.common.service.impl.icomp.v01b06.s003;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s003.ICOMPV01B06S003Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.ComlistDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.PartsDao;
import com.icomp.dao.ProcurementplansDao;
import com.icomp.dao.SubAvgProcessAmountDao;
import com.icomp.dao.SubProductionDesignDao;
import com.icomp.dao.SubToolAvgToolSharpennumDao;
import com.icomp.dao.SubToolProcessAmountDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.EntityProcurementplansWhere;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Procurementplans;
import com.icomp.entity.base.SubAvgProcessAmount;
import com.icomp.entity.base.SubProductionDesign;
import com.icomp.entity.base.SubToolAvgToolSharpennum;
import com.icomp.entity.base.SubToolProcessAmount;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;

/**
 * 建议采购计划SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B06S003ServiceImpl
 * @date 2014-9-9 上午10:38:30
 */
@SuppressWarnings("unchecked")
public class ICOMPV01B06S003ServiceImpl extends BaseService implements ICOMPV01B06S003Service {
    /**
     * 采购计划DAO
     */
    private ProcurementplansDao procurementplansDao;

    public void setProcurementplansDao(ProcurementplansDao procurementplansDao) {
        this.procurementplansDao = procurementplansDao;
    }

    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 加工零部件Dao
     */
    @SuppressWarnings("unused")
    private PartsDao partsDao;

    public void setPartsDao(PartsDao partsDao) {
        this.partsDao = partsDao;
    }

    /* 系统区分Dao */
    private ComlistDao comlistDao;

    /**
     * 系统区分Dao 设定
     *
     * @param
     */
    public void setComlistDao(ComlistDao comlistDao) {
        this.comlistDao = comlistDao;
    }

    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao;

    public void setSubToolAvgToolSharpennumDao(SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao) {
        this.subToolAvgToolSharpennumDao = subToolAvgToolSharpennumDao;
    }

    private SubToolProcessAmountDao subToolProcessAmountDao;

    public void setSubToolProcessAmountDao(SubToolProcessAmountDao subToolProcessAmountDao) {
        this.subToolProcessAmountDao = subToolProcessAmountDao;
    }

    private SubProductionDesignDao subProductionDesignDao;

    public void setSubProductionDesignDao(SubProductionDesignDao subProductionDesignDao) {
        this.subProductionDesignDao = subProductionDesignDao;
    }

    private SubAvgProcessAmountDao subAvgProcessAmountDao;

    public void setSubAvgProcessAmountDao(SubAvgProcessAmountDao subAvgProcessAmountDao) {
        this.subAvgProcessAmountDao = subAvgProcessAmountDao;
    }

    /* 新刀具库存表 */
    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    @Override
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            MathContext mc = new MathContext(3, RoundingMode.HALF_DOWN);
            // 取得刃磨周期天数
            Comlist comlist = new Comlist();
            comlist.setLanguageCode(langCode);
            comlist.setComListType("GrindingTime");
            List<Comlist> list = (List<Comlist>) comlistDao.searchByList(comlist);
            comlist = list.get(0);
            //刃磨周期(自然日),刃磨周期定义在comlist表中
            int grindingTime = Integer.parseInt(comlist.getComListValue());
            
            Tool tool = new Tool();
            tool.setDelFlag(IConstant.DEL_FLAG_0);//删除区分-有效
            tool.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString()) ? null : param.get("ToolCode").toString());
            //ToolCode模糊查询
            List<Tool> toolList = (List<Tool>) toolDao.searchByList_F(tool);
            
            List<Map<String, Object>> grindingList = new ArrayList<Map<String, Object>>();
            for (Tool toolE : toolList) {
            	
                Map<String, Object> grinding = new HashMap<String, Object>();
                grinding.put("toolID", toolE.getToolID());
                grinding.put("toolCode", toolE.getToolCode());
                
                //采购周期(自然日)
                BigDecimal purchasingCycles = null;
                //采购周期(自然日)默认为tool表中的，如果tool表中没有赋值，默认为60天
                if (toolE.getPurchasingCycle() != null) {
                    purchasingCycles = toolE.getPurchasingCycle();
                } else {
                	purchasingCycles = new BigDecimal(60);
                }
                
               
                // 采购周期内可使用次数 = （采购周期天数/刃磨周期天数）
                BigDecimal toolGrinding = purchasingCycles.divide(new BigDecimal(grindingTime));  // 采购周期内可使用次数
                
                
                if (toolGrinding.intValue() == 0) {
                    toolGrinding = BigDecimal.ONE;
                }
                
                /***库存单体刀具残量换算新刀比例 = (库存单体刀具残 >（采购周期天数/刃磨周期天数）)?1:剩余次数/采购周期内可使用次数
                 *  库存刀具个数 = SUM(库存单体刀具残量换算新刀比例)
                 *  取得流转中已回库刀具(即库存状态为：正常)
                 **/
               
                //刀具流转查询
                Tooltransfer tooltransfer = new Tooltransfer();
                tooltransfer.setToolID(toolE.getToolID());
                tooltransfer.setStockState(IConstant.STOCK_STATE_0);
                List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);// 取得库存所有可流转刀具
               
              
                /**
                 * * 现有库存量=tooltransfer的库存量+knifeinventory库存量
                 */
                //tooltransfer的库存量
                float toolCount = getToolCountFrom_Ttooltransfer(toolE,tooltransferList,toolGrinding,mc);
               
                // 取得所有库存新刀
                Knifeinventory knifeInventory = new Knifeinventory();
                knifeInventory.setToolID(toolE.getToolID());
                knifeInventory.setDelFlag(IConstant.DEL_FLAG_0);
                List<Knifeinventory> knifeinventoryList = (List<Knifeinventory>) knifeinventoryDao.searchByList(knifeInventory);
                
                //再加上knifeinventory库存量
                toolCount += getToolCountFrom_Tknifeinventory(toolE,knifeinventoryList,toolGrinding,mc);

                grinding.put("toolCount", (int) toolCount);// 现有库存量
                
                /** 
                 * 刀具消耗量 = 采购周期周期天数 * 平均每天使用刀具次数/刀具平均使用次数
                 * */
                SubToolAvgToolSharpennum subToolAvgToolSharpennum = new SubToolAvgToolSharpennum();
                subToolAvgToolSharpennum.setToolCode(toolE.getToolCode());
                List<SubToolAvgToolSharpennum> subToolAvgToolSharpennumList = 
                		(List<SubToolAvgToolSharpennum>) subToolAvgToolSharpennumDao.searchByList(subToolAvgToolSharpennum);
                
                
                int avgcs = 0;// 刀具平均使用次数
                int purchasingCycle = 30;// 采购周期周期天数:初始值为30天
                
                if (subToolAvgToolSharpennumList.size() > 0) {
                    // 采购周期周期天数
                    purchasingCycle = subToolAvgToolSharpennumList.get(0).getPurchasingCycle().intValue();
                    // 刀具平均使用次数
                    avgcs = subToolAvgToolSharpennumList.get(0).getAvgcs().intValue();
                } else {
                }
                grinding.put("purchasingCycle", purchasingCycle);
                /*** 平均每天使用刀具次数 = sum(刀具每天安上设备次数)/天数*/
                // 根据刀具编码取得 该类刀具的安上次数及间隔天数
                SubToolProcessAmount subToolProcessAmount = new SubToolProcessAmount();
                subToolProcessAmount.setToolCode(tool.getToolCode());
                List<SubToolProcessAmount> subToolProcessAmountList = 
                		(List<SubToolProcessAmount>) subToolProcessAmountDao.searchByList(subToolProcessAmount);
                String staTime = IConstant.STRING_0, endTime = IConstant.STRING_1;
                if (subToolProcessAmountList.size() > 0) {
                	if(subToolProcessAmountList.get(0).getLoadTime()!=null)
                    staTime = subToolProcessAmountList.get(0).getLoadTime(); // 开始时间
                	if(subToolProcessAmountList.get(subToolProcessAmountList.size() - 1).getLoadTime()!=null)
                    endTime = subToolProcessAmountList.get(subToolProcessAmountList.size() - 1).getLoadTime();// 结束时间
                }
                
                int loadTime = Integer.parseInt(endTime) - Integer.parseInt(staTime);// 间隔天数
                
                int loadCount = 0; // 安装次数
                for (SubToolProcessAmount subToolProcessAmountEntity : subToolProcessAmountList) {
                    loadCount += subToolProcessAmountEntity.getLoadCount().intValue();
                }
                
                //平均每天使用刀具次数 = sum(刀具每天安上设备次数)/天数
                int avgToolCount = loadCount / loadTime;// 平均每天使用刀具次数
                
                if (avgcs == 0) {
                    if (IConstant.TOOL_CONSUME_TYPE_2.equals(toolE.getToolConsumetype())) {// 一次性刀片
                        avgcs = toolE.getToolSharpennum().intValue();
                    } else if (IConstant.TOOL_CONSUME_TYPE_0.equals(toolE.getToolConsumetype())) {// 可刃磨钻头
                        avgcs = toolE.getToolSharpenLength().divide(toolE.getToolSharpenCriterion(),mc).intValue();
                    } else if (IConstant.TOOL_CONSUME_TYPE_1.equals(toolE.getToolConsumetype())) {// 可刃磨刀片
                        avgcs = toolE.getToolSharpennum().intValue();
                    }
                }
                
                // 刀具消耗量
                float toolUseCount = Float.parseFloat("0.00");
                if (avgcs != 0) {
                    toolUseCount = purchasingCycle * avgToolCount / avgcs;
                }
                // 采购周期内需要总数量 = (采购周内刀具消耗量 + 到货周期消耗量)* 最高产量 * 计划产量 / 平均产量 * 平均产量
                // 采购周期内需要总数量
                int grindingCount = 0;
                Date date = new Date();
                // 取得当前年月
                String yearMonth = Ctl.dateFormat(date, "yyyyMM");
                // 取得下一周期年月
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_MONTH, toolE.getPurchasingCycle().intValue());
                String newYearMonth = Ctl.dateFormat(calendar.getTime(), "yyyyMM");
                // 计划产量
                SubProductionDesign subProductionDesign = new SubProductionDesign();
                subProductionDesign.setToolCode(toolE.getToolCode());
                subProductionDesign.setProductiontime(yearMonth);
                subProductionDesign.setNewProductiontime(newYearMonth);
                List<SubProductionDesign> subProductionDesignList = (List<SubProductionDesign>) subProductionDesignDao.searchByList(subProductionDesign);
                // 到下一采购周期的计划产量
                int productionCount = 0;
                for (SubProductionDesign subProductionDesignEntity : subProductionDesignList) {
                    productionCount += subProductionDesignEntity.getProduction().intValue();
                }
                //if (productionCount > 0) {
                grindingList.add(grinding);
                //}
                // 计划产量
                if (subProductionDesignList.size() > 0) {
                    productionCount = productionCount * toolE.getPurchasingCycle().intValue() / (subProductionDesignList.size() * 30);
                    grinding.put("assemblyLineName", subProductionDesignList.get(0).getAssemblyLineName());
                }
                // 最高产量 平均产量 取得
                SubAvgProcessAmount subAvgProcessAmount = new SubAvgProcessAmount();
                subAvgProcessAmount.setToolCode(toolE.getToolCode());
                List<SubAvgProcessAmount> subAvgProcessAmountList = (List<SubAvgProcessAmount>) subAvgProcessAmountDao.searchByList(subAvgProcessAmount);
                int purchaseCount = 0;
                if (subAvgProcessAmountList.size() > 0) {
                    // 最高产量
                    int maxProcessAmount = subAvgProcessAmountList.get(0).getMaxProcessAmount().intValue();
                    // 平均产量
                    int avgProcessAmount = subAvgProcessAmountList.get(0).getAvgProcessAmount().intValue();
                    // (采购周内刀具消耗量 + 到货周期消耗量)
                    grindingCount = (int) ((toolUseCount + grindingTime) * purchasingCycle * maxProcessAmount * productionCount / (avgProcessAmount * avgProcessAmount));
                    // 采购数量 = 采购周期内需要总数量 - 现有库存量
                    purchaseCount = grindingCount - (int) toolCount;
                    if (purchaseCount > 0) {
                        grinding.put("purchaseCount", purchaseCount);
                    } else {
                        grinding.put("purchaseCount", 0);
                    }
                } else {
                    grinding.put("purchaseCount", 0);
                }

            }
            rtn.put("rows", grindingList);
            return rtn;

        } catch (SQLException e) {
            List<EntityProcurementplansWhere> list = new ArrayList<EntityProcurementplansWhere>();
            EntityProcurementplansWhere entity = new EntityProcurementplansWhere();
            entity.setMessageCode(IConstant.EMSG0004);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            list.add(entity);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
    }

    private float getToolCountFrom_Tknifeinventory(Tool toolE,
			List<Knifeinventory> knifeinventoryList, BigDecimal toolGrinding,
			MathContext mc) {
    	int toolCount=0;
        for (@SuppressWarnings("unused") Knifeinventory knifeinventory2 : knifeinventoryList) {
            if (IConstant.TOOL_TYPE_0.equals(toolE.getToolType())) {
                int toolSharpennum = 0;// 剩余次数
                if (IConstant.TOOL_CONSUME_TYPE_2.equals(toolE.getToolConsumetype())) {// 一次性刀片
                    if (toolE.getToolSharpennum().subtract(toolGrinding).intValue() > 0) {
                        toolCount++;
                    } else {
                        toolCount += toolE.getToolSharpennum().intValue() / toolGrinding.intValue();
                    }
                } else if (IConstant.TOOL_CONSUME_TYPE_0.equals(toolE.getToolConsumetype())) {// 可刃磨钻头
                    toolSharpennum = toolE.getToolSharpenLength().divide(toolE.getToolSharpenCriterion(),mc).intValue();
                    if (toolSharpennum - toolGrinding.intValue() > 0) {
                        toolCount++;
                    } else {
                        toolCount += toolSharpennum / toolGrinding.intValue();
                    }
                } else if (IConstant.TOOL_CONSUME_TYPE_1.equals(toolE.getToolConsumetype())) {// 可刃磨刀片
                    if (toolGrinding.intValue() >= toolE.getToolSharpennum().intValue()) {
                        if (toolE.getToolSharpennum().intValue() == toolGrinding.intValue()) {
                            toolCount++;
                        } else {
                            toolCount += toolE.getToolSharpennum().intValue() / toolGrinding.intValue();
                        }
                    } else {
                        toolCount++;
                    }
                }
            } else {
                toolCount++;
            }

        }
        return toolCount;
	}

	/***
     * 求现有库存量
     * @param toolE
     * @param tooltransferList
     * @param toolGrinding
     * @param mc
     * @return
     */
    private float getToolCountFrom_Ttooltransfer(Tool toolE,
			List<Tooltransfer> tooltransferList, BigDecimal toolGrinding,
			MathContext mc) {
		 int toolCount=0;
		 for (Tooltransfer tooltransferEntity : tooltransferList) {
             if (IConstant.TOOL_TYPE_0.equals(toolE.getToolType())) {
                 int toolSharpennum = 0;// 剩余次数
                 if (IConstant.TOOL_CONSUME_TYPE_2.equals(toolE.getToolConsumetype())) {// 一次性刀片
                     if (tooltransferEntity.getToolSharpennum().subtract(toolGrinding).intValue() > 0) {
                         toolCount++;
                     } else {
                         toolCount += tooltransferEntity.getToolSharpennum().intValue() / toolGrinding.intValue();
                     }
                     
                 } else if (IConstant.TOOL_CONSUME_TYPE_0.equals(toolE.getToolConsumetype())) {// 可刃磨钻头
                     toolSharpennum = tooltransferEntity.getToolSharpenLength().divide(tooltransferEntity.getToolSharpenCriterion(),mc).intValue();
                     if (toolSharpennum - toolGrinding.intValue() > 0) {
                         toolCount++;
                     } else if (toolSharpennum != 0) {
                         toolCount += toolSharpennum / toolGrinding.intValue();
                     }
                 } else if (IConstant.TOOL_CONSUME_TYPE_1.equals(toolE.getToolConsumetype())) {// 可刃磨刀片
                     if (toolGrinding.intValue() >= tooltransferEntity.getToolSharpennum().intValue()) {
                         if (tooltransferEntity.getToolSharpennum().intValue() == toolGrinding.intValue()) {
                             toolCount++;
                         } else {
                             toolCount += tooltransferEntity.getToolSharpennum().intValue() / toolGrinding.intValue();
                         }
                     } else {
                         toolCount++;
                     }
                 }
             } else {
                 toolCount++;
             }
         }
		 return toolCount;
	}

	/**
     * 取得页面grid显示项目列表
     */
    @Override
    public Map<String, Object> getGridColmun(String pageID, String lang) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            Displayeditemconfiguration entity = new Displayeditemconfiguration();
            entity.setPageName(pageID);
            entity.setLanguageCode(lang);

            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList(entity);
            if (list.size() <= 0) {
                // 列表取得失败!
                list = new ArrayList<Displayeditemconfiguration>();
                Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
                displayeditemconfiguration.setMessageCode(IConstant.WMSG0008);
                displayeditemconfiguration.setRetErrFlag(true);
                list.add(displayeditemconfiguration);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;
            } else {
                for (Displayeditemconfiguration displayeditemconfiguration : list) {
                    rtn.put(displayeditemconfiguration.getColName(), IConstant.DISPLAYED_FLAG_0.equals(displayeditemconfiguration.getDisplayedFlag()) ? true : false);
                }
                return rtn;
            }

        } catch (SQLException e) {
            List<Displayeditemconfiguration> list = new ArrayList<Displayeditemconfiguration>();
            Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
            displayeditemconfiguration.setMessageCode(IConstant.EMSG0004);
            displayeditemconfiguration.setRetErrFlag(true);
            displayeditemconfiguration.setExceMessage(e.getMessage());
            list.add(displayeditemconfiguration);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;

        }
    }

    /**
     * 批量增加建议采购计划
     */
    @Override
    public Map<String, Object> saveAll(List<Procurementplans> list, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            // 批量增加
            procurementplansDao.batchInsert(list);
            // 插入成功 返回信息
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0004, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            Procurementplans entity = new Procurementplans();
            entity.setMessageCode(IConstant.EMSG0007);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

}
