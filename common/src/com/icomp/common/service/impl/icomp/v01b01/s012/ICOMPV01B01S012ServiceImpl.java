package com.icomp.common.service.impl.icomp.v01b01.s012;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s012.ICOMPV01B01S012Service;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 库存异常报警SERVICE实现类
 * 
 * @ClassName: ICOMPV01B01S012ServiceImpl
 * @author Taoyy
 * @date 2014-8-14 下午04:20:08
 */
public class ICOMPV01B01S012ServiceImpl extends BaseService implements
		ICOMPV01B01S012Service {
    private VinventoryalarmDao vinventoryalarmDao;

    public void setVinventoryalarmDao(VinventoryalarmDao vinventoryalarmDao) {
        this.vinventoryalarmDao = vinventoryalarmDao;
    }
    private SubToolProcessAmountDao subToolProcessAmountDao;

    public void setSubToolProcessAmountDao(SubToolProcessAmountDao subToolProcessAmountDao) {
        this.subToolProcessAmountDao = subToolProcessAmountDao;
    }
    private SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao;

    public void setSubToolAvgToolSharpennumDao(SubToolAvgToolSharpennumDao subToolAvgToolSharpennumDao) {
        this.subToolAvgToolSharpennumDao = subToolAvgToolSharpennumDao;
    }
    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    /**
     * 授权列表模糊查询
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getInventoryCountList(Vinventoryalarm entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
        	//ToolCode模糊查询
            List<Vinventoryalarm> list = (List<Vinventoryalarm>) vinventoryalarmDao.searchByList_F(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Vinventoryalarm>();
                Vinventoryalarm vinventoryalarm = new Vinventoryalarm();
                vinventoryalarm.setMessageCode(IConstant.EMSG0001);
                vinventoryalarm.setRetErrFlag(true);
                list.add(vinventoryalarm);
                rtn.put("status", IConstant.RESULT_CODE_1);//条数为0
                rtn.put("rows", null);
                rtn.put("error", list);
            } else {
                List<Vinventoryalarm> resultList = new ArrayList<Vinventoryalarm>();
                for (Vinventoryalarm temp : list) {
                    // 根据刀具编码取得 该类刀具的安上次数及间隔天数
                    SubToolProcessAmount subToolProcessAmount = new SubToolProcessAmount();
                    subToolProcessAmount.setToolCode(temp.getToolCode());
                    List<SubToolProcessAmount> subToolProcessAmountList = (List<SubToolProcessAmount>) subToolProcessAmountDao.searchByList(subToolProcessAmount);
                    String staTime = IConstant.STRING_0, endTime = IConstant.STRING_1;
                    if (subToolProcessAmountList.size() > 0) {
                        if (subToolProcessAmountList.get(0).getLoadTime() != null && !subToolProcessAmountList.get(0).getLoadTime().equals("")) {
                            staTime = subToolProcessAmountList.get(0).getLoadTime(); // 开始时间
                            endTime = subToolProcessAmountList.get(subToolProcessAmountList.size() - 1).getLoadTime();// 结束时间
                        }
                    }
                    // 间隔天数
                    int loadTime = Integer.parseInt(endTime) - Integer.parseInt(staTime);
                    int loadCount = 0; // 安装次数
                    for (SubToolProcessAmount subToolProcessAmountEntity : subToolProcessAmountList) {
                        loadCount += subToolProcessAmountEntity.getLoadCount().intValue();
                    }
                    // 平均每天使用刀具次数
                    int avgToolCount = 0;
                    if (loadTime != 0) {
                        avgToolCount = loadCount / loadTime;
                    }

                    SubToolAvgToolSharpennum subToolAvgToolSharpennum = new SubToolAvgToolSharpennum();
                    subToolAvgToolSharpennum.setToolCode(temp.getToolCode());
                    List<SubToolAvgToolSharpennum> subToolAvgToolSharpennumList = (List<SubToolAvgToolSharpennum>) subToolAvgToolSharpennumDao.searchByList(subToolAvgToolSharpennum);
                    int purchasingCycle = 30;// 初始值
                    int avgcs = 1;// 初始值
                    if (subToolAvgToolSharpennumList.size() > 0) {
                        // 采购周期(天数)
                        purchasingCycle = subToolAvgToolSharpennumList.get(0).getPurchasingCycle().intValue();
                        // 刀具平均使用次数
                        avgcs = subToolAvgToolSharpennumList.get(0).getAvgcs().intValue();
                    } else {

                    }
                    if (avgcs != 0 && avgToolCount != 0 && purchasingCycle != 0) {// 如果分母或分子不等于0,才更新周转量
                        // 周转量= 采购周期(天) * 平均每天使用刀具次数/刀具平均使用次数
                        int toolTurnover = purchasingCycle * avgToolCount / avgcs;
                        // 赋值周转量
                        temp.setToolTurnover(new BigDecimal(toolTurnover));
                    }
                    //刀具是否告警
                    temp.setStates(getThisStatusString(temp));
                    resultList.add(temp);
                }
                Collections.sort(resultList);
                int total = vinventoryalarmDao.searchByCount_F(entity);
                rtn.put("rows", resultList);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

            }

        } catch (SQLException e) {
        	e.printStackTrace();
            List<Vinventoryalarm> list = new ArrayList<Vinventoryalarm>();
            Vinventoryalarm vinventoryalarm = new Vinventoryalarm();
            vinventoryalarm.setMessageCode(IConstant.EMSG0004);
            vinventoryalarm.setRetErrFlag(true);
            vinventoryalarm.setExceMessage(e.getMessage());
            list.add(vinventoryalarm);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
        return rtn;
    }
    private VauthorizationDao vauthorizationDao;

    public void setVauthorizationDao(VauthorizationDao vauthorizationDao) {
        this.vauthorizationDao = vauthorizationDao;
    }

    @Override
    public Map<String, Object> getInventoryCountLists(Vauthorization entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        Vauthorization vauthorization = new Vauthorization();
        try {
            //模糊查询
            List<Vauthorization> list = (List<Vauthorization>) vauthorizationDao.searchByList(entity);
            for (Vauthorization vList : list) {

                if (IConstant.C03S001.equals(vList.getBusinessCode())) {
                    vList.setBusinessCode(IConstant.C03S001_TEXT);
                } else if (IConstant.C01S011.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S011_TEXT);
                } else if (IConstant.C01S013.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S013_TEXT);

                } else if (IConstant.C01S010.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S010_TEXT);
                } else if (IConstant.C01S014.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S014_TEXT);
                } else if (IConstant.C01S018.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S018_TEXT);
                } else if (IConstant.C01S027.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S027_TEXT);
                } else if (IConstant.C01S016.equals(vList.getBusinessCode())) {
                    vList.setBusinessCode(IConstant.C01S016_TEXT);
                } else if (IConstant.C01S005.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S005_TEXT);
                } else if (IConstant.C01S020.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S020_TEXT);
                } else if (IConstant.C01S019.equals(vList.getBusinessCode())) {
                      vList.setBusinessCode(IConstant.C01S019_TEXT);
                }
                //2017/09/18 王冉 追加↓↓↓　dazhong@YMSC
                else if (IConstant.C01S008.equals(vList.getBusinessCode())) {
                    vList.setBusinessCode(IConstant.C01S008_TEXT);
                }
                //2017/09/18 王冉 追加↑↑↑　dazhong@YMSC
            }

            if (list.size() <= 0) {
                list = new ArrayList<Vauthorization>();
                vauthorization.setMessageCode(IConstant.EMSG0001);
                vauthorization.setRetErrFlag(true);
                list.add(vauthorization);
                rtn.put("rows", null);
                rtn.put("error", list);
            } else {
                int total = vauthorizationDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
            }
            return rtn;
        } catch (SQLException e) {
            List<Vauthorization> list = new ArrayList<Vauthorization>();
            vauthorization.setMessageCode(IConstant.EMSG0004);
            vauthorization.setRetErrFlag(true);
            vauthorization.setExceMessage(e.getMessage());
            list.add(vauthorization);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }


    }

    @Override
    public List<Business> getBusiness() {
        Business entity = null;
        Business businessList = null;
        try {
            entity = new Business();
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            List<Business> list = (List<Business>) businessDao.searchByList(entity);
//			for (Equipment equipment : list2) {
//				list.add(equipment);
//			}
            if (list.size() <= 0) {
                list = new ArrayList<Business>();
                businessList = new Business();
                // 消息：检索为0
                businessList.setMessageCode(IConstant.EMSG0001);
                businessList.setRetErrFlag(false);
                list.add(businessList);
                return list;
            }
            return list;

        } catch (SQLException e) {
            List<Business> list = new ArrayList<Business>();
            businessList = new Business();
            // 错误消息：数据库操作异常，查询失败!
            businessList.setMessageCode(IConstant.EMSG0004);
            businessList.setRetErrFlag(true);
            businessList.setExceMessage(e.getMessage());
            list.add(businessList);
            return list;
        }

    }

    @Override
    public String getNumber() {
        int total =0;
        try {
            total = vauthorizationDao.searchByCount(new Vauthorization());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(total);
    }
}
