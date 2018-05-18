package com.icomp.common.service.impl.icomp.v01c03.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c03.s001.ICOMPV01C03S001Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.BusinessflowlnkDao;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.OplinkDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.SynthesiscutterlocationDao;
import com.icomp.dao.SynthesisexperienceDao;
import com.icomp.dao.SynthesisknifeDao;
import com.icomp.dao.SynthesisparametersDao;
import com.icomp.dao.SynthesistoolsmachiningDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgetsynsistoolmsgDao;
import com.icomp.dao.VknifeinventoryinfoDao;
import com.icomp.dao.VsynthesisparametersDao;
import com.icomp.dao.VtoolparamDao;
import com.icomp.dao.VtoolstackDao;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Businessflowlnk;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Oplink;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesiscutterlocation;
import com.icomp.entity.base.Synthesisexperience;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Synthesisparameters;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgetsynsistoolmsg;
import com.icomp.entity.base.Vknifeinventoryinfo;
import com.icomp.entity.base.Vsynthesisparameters;
import com.icomp.entity.base.Vtoolparam;
import com.icomp.entity.base.Vtoolstack;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C03S001ServiceImpl extends BaseService implements ICOMPV01C03S001Service {
    private SynthesisexperienceDao synthesisexperienceDao;
    private SynthesistoolsmachiningDao synthesistoolsmachiningDao;

    public void setOplinkDao(OplinkDao oplinkDao) {
        this.oplinkDao = oplinkDao;
    }

    private OplinkDao oplinkDao;
    private VsynthesisparametersDao vsynthesisparametersDao;

    public void setVsynthesisparametersDao(VsynthesisparametersDao vsynthesisparametersDao) {
        this.vsynthesisparametersDao = vsynthesisparametersDao;
    }

    public void setSynthesistoolsmachiningDao(SynthesistoolsmachiningDao synthesistoolsmachiningDao) {
        this.synthesistoolsmachiningDao = synthesistoolsmachiningDao;
    }

    public void setSynthesisexperienceDao(SynthesisexperienceDao synthesisexperienceDao) {
        this.synthesisexperienceDao = synthesisexperienceDao;
    }

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    private ToolprocuredDao toolprocuredDao;

    public void setVgetsynsistoolmsgDao(VgetsynsistoolmsgDao vgetsynsistoolmsgDao) {
        this.vgetsynsistoolmsgDao = vgetsynsistoolmsgDao;
    }

    private RfidcontainerDao rfidcontainerDao;
    private VgetsynsistoolmsgDao vgetsynsistoolmsgDao;

    public void setSynthesiscutterlocationDao(SynthesiscutterlocationDao synthesiscutterlocationDao) {
        this.synthesiscutterlocationDao = synthesiscutterlocationDao;
    }

    private SynthesiscutterlocationDao synthesiscutterlocationDao;

    public void setSynthesisparametersDao(SynthesisparametersDao synthesisparametersDao) {
        this.synthesisparametersDao = synthesisparametersDao;
    }

    private SynthesisparametersDao synthesisparametersDao;

    public void setSynthesisknifeDao(SynthesisknifeDao synthesisknifeDao) {
        this.synthesisknifeDao = synthesisknifeDao;
    }

    private SynthesisknifeDao synthesisknifeDao;

    public void setVknifeinventoryinfoDao(VknifeinventoryinfoDao vknifeinventoryinfoDao) {
        this.vknifeinventoryinfoDao = vknifeinventoryinfoDao;
    }

    private VknifeinventoryinfoDao vknifeinventoryinfoDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private VtoolparamDao vtoolparamDao;

    public void setVtoolparamDao(VtoolparamDao vtoolparamDao) {
        this.vtoolparamDao = vtoolparamDao;
    }

    private VtoolstackDao vtoolstackDao;

    public void setVtoolstackDao(VtoolstackDao vtoolstackDao) {
        this.vtoolstackDao = vtoolstackDao;
    }

    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    /* 新刀具库存表 */
    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private BusinessflowlnkDao businessflowlnkDao;

    public void setBusinessflowlnkDao(BusinessflowlnkDao businessflowlnkDao) {
        this.businessflowlnkDao = businessflowlnkDao;
    }

    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    /**
     * 验证RFID是否可用
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer checkRfid(Rfidcontainer entity) {

        try {
            List<Rfidcontainer> list = (List<Rfidcontainer>) rfidcontainerDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                return new Rfidcontainer();
            } else {
                // 您所使用的RFID已被占用!
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setMessageCode(IConstant.WMSG0158);
                rfidcontainer.setRetErrFlag(true);
                return rfidcontainer;
            }

        } catch (SQLException e) {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setMessageCode(IConstant.EMSG0004);
            rfidcontainer.setRetErrFlag(true);
            rfidcontainer.setExceMessage(e.getMessage());
            return rfidcontainer;
        }

    }

    /**
     * 取得系统当前可选批次列表
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Vtoolparam getToolInfo(Vtoolparam entity) {
        try {
            List<Vtoolparam> list = (List<Vtoolparam>) vtoolparamDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 系统当前可选批次未找到相应数据!
                Vtoolparam vtoolparam = new Vtoolparam();
                vtoolparam.setMessageCode(IConstant.WMSG0159);
                vtoolparam.setRetErrFlag(true);
                return vtoolparam;
            } else {
                return list.get(0);
            }

        } catch (SQLException e) {
            Vtoolparam vtoolparam = new Vtoolparam();
            vtoolparam.setMessageCode(IConstant.EMSG0004);
            vtoolparam.setRetErrFlag(true);
            vtoolparam.setExceMessage(e.getMessage());
            return vtoolparam;
        }
    }

    /**
     * 取得刀具参数信息
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Vtoolstack getRfidType(Vtoolstack entity) {
        Vtoolstack vtoolstack = new Vtoolstack();
        try {
            List<Vtoolstack> list = (List<Vtoolstack>) vtoolstackDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                // 刀具参数未找到相应数据!
                vtoolstack.setMessageCode(IConstant.WMSG0122);
                vtoolstack.setRetErrFlag(true);
                return vtoolstack;
            } else if (IConstant.TOOL_CONSUME_TYPE_9.equals(list.get(0).getToolConsumetype()) && IConstant.STSATIC_TWO.equals(entity.getQueryTypeWhere())) {
                // 辅具和配置暂时不支持旧刀初始化
                vtoolstack.setMessageCode(IConstant.WMSG0120_1);
                vtoolstack.setRetErrFlag(true);
                return vtoolstack;
            } else {
                return list.get(0);
            }

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            vtoolstack = new Vtoolstack();
            vtoolstack.setMessageCode(IConstant.EMSG0004);
            vtoolstack.setRetErrFlag(true);
            vtoolstack.setExceMessage(e.getMessage());
            return vtoolstack;
        }
    }

    /**
     * 刀具初始化处理
     *
     * @param rfidList
     * @param customerID
     * @param langCode
     * @param langValue
     * @param handsetid
     * @return
     */
    public Map<String, Object> saveInitialization(List<Map<String, Object>> rfidList, String customerID, String langCode, String langValue, String handsetid) {
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            for (Map<String, Object> map : rfidList) {
                // 判断初始化类型
                boolean returnFlag = true;
                String inputType = (String) map.get("InputType");
                switch (inputType.charAt(0)) {
                    case '1':// 库房新刀初始化
                        returnFlag = this.warehouseToolInitialization(result, map, inputType, customerID, langCode, langValue, handsetid);
                        if (!returnFlag) {
                            return result;
                        }
                        break;
                    case '2':// 库房旧刀
                        returnFlag = this.warehouseToolInitialization(result, map, inputType, customerID, langCode, langValue, handsetid);
                        if (!returnFlag) {
                            return result;
                        }
                        break;
                    case '3':// 刃磨室待复磨
                        returnFlag = this.grindingToolInitialization(result, map, inputType, customerID, langCode, langValue, handsetid);
                        if (!returnFlag) {
                            return result;
                        }
                        break;
                    case '4':// 刃磨室待送回
                        returnFlag = this.grindingToolInitialization(result, map, inputType, customerID, langCode, langValue, handsetid);
                        if (!returnFlag) {
                            return result;
                        }
                        break;
                    case '5':// 刃磨室待报废
                        returnFlag = this.grindingToolInitialization(result, map, inputType, customerID, langCode, langValue, handsetid);
                        if (!returnFlag) {
                            return result;
                        }
                        break;
                    default:
                        break;
                }
            }
            result.put("status", IConstant.RESULT_CODE_0);
            result.put("messagetext", IConstant.CIMSG0092);//
            // 入库成功！
            return result;
        } catch (SQLException e) {
            result.put("status", IConstant.RESULT_CODE_1);
            result.put("messagetext", IConstant.EMSG0004);
            return result;
        }
    }

    /**
     * 根据材料号查询流转旧刀信息
     *
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public Tool getOldToolMsg(Tool t) throws Exception {
        return toolDao.getOldToolMsg(t);
    }

    /**
     * 提交流转旧刀初始化
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> submitOldRunInItDate(Map<String, Object> param) throws Exception {
        Map<String, Object> reVal = new HashMap<String, Object>();
        //rfid标签集合
        List<String> rfidCodeList = (List<String>) param.get("rfidCodeList");
        //标签类型(1单品刀)
        String queryType = (String) param.get("queryType");
        //材料号
        String toolCode = (String) param.get("toolCode");
        //用户ID
        String userID = (String) param.get("userID");
        //刀具类型（消耗类别）
        String toolConsumeType = (String) param.get("toolConsumeType");
        //初始化类型（0备用刀，1其它）
        String initializeType = (String) param.get("initializeType");
        //手持机ID
        String handSetId = (String) param.get("handSetId");
        //用户ID
        String customerID = (String) param.get("customerID");
        //刀具ID
        String toolID = (String) param.get("toolID");
        //查询刀具信息
        Tool t = new Tool();
        t.setToolCode(toolCode);
        Tool tool = getToolIDByToolCode(t);
        if (null == tool) {
            reVal.put(IConstant.STATE_CODE, IConstant.STOCK_STATE_1);
            reVal.put(IConstant.STATE_MSG, "未找到当前材料号信息");
            return reVal;
        }

        Rfidcontainer rfidcontainer = null;
        List<Rfidcontainer> rrlist = new ArrayList<Rfidcontainer>();
        List<Tooltransfer> ttlist = new ArrayList<Tooltransfer>();
        List<String> ttRfidConID = new ArrayList<String>();
        Tooltransfer tt = null;
        for (String str : rfidCodeList) {
            rfidcontainer = new Rfidcontainer();
            //单品刀
            rfidcontainer.setQueryType(IConstant.STOCK_STATE_1);
            rfidcontainer.setRfidCode(str);
            List<Rfidcontainer> rfidcontainers = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            // 每插入一条数据，重新生成一个rfidcontainerID
            String rfidcontainerID = null;
            if (rfidcontainers == null || rfidcontainers.size() < 1) {
                rfidcontainerID = UUIDgen.getId().toString();
                // 先插入到rfid载体
                rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidContainerID(rfidcontainerID);
                rfidcontainer.setRfidCode(str);
                rfidcontainer.setQueryType(IConstant.QUERY_TYPE_1);
                rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                rfidcontainer.setRfidReCount(BigDecimal.ZERO);
                rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                rfidcontainer.setUpdateUser(userID);
                rfidcontainer.setUpdateTime(new Date());
                rfidcontainer.setCreateUser(userID);
                rfidcontainer.setCreateTime(new Date());
                rfidcontainer.setSystemLogUser(userID);
                rrlist.add(rfidcontainer);
            } else {
                rfidcontainerID = rfidcontainers.get(0).getRfidContainerID();
            }
            //载体ID
            ttRfidConID.add(rfidcontainerID);
            tt = new Tooltransfer();
            //rfid载体id
            tt.setRfidContainerID(rfidcontainerID);
            tt.setToolID(tool.getToolID());
            tt.setInstallationState(IConstant.INSTALLATION_STATE_0);
            if (IConstant.STRING_0.equals(initializeType)) {
                //0备用刀
                //刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他10.已出厂修磨 11.厂外待涂层)
                tt.setToolState(IConstant.TOOL_STATE_4);
                //刀具部门(0库存,1对刀室,2刃磨室,3,车间5.初始化)
                tt.setToolThisState(IConstant.TOOL_KIND_1);
            } else {
                //1其它
                tt.setToolState(IConstant.TOOL_STATE_9);
                tt.setToolThisState(IConstant.TOOL_KIND_5);
            }
            tt.setKnifeInventoryCode(String.valueOf(UUIDgen.getTimes()));
            tt.setBusinessFlowLnkID(IConstant.C03S001);
            tt.setProcuredBatch(IConstant.INIT_PROCURED_BATCH);
            tt.setStockState(IConstant.STRING_4);
            tt.setDelFlag(IConstant.DEL_FLAG_0);
            tt.setCreateTime(new Date());
            tt.setCreateUser(userID);
            tt.setUpdateTime(new Date());
            tt.setUpdateUser(userID);
            ttlist.add(tt);//TODO
            //插入到生命周期表  记录刀具生命周期
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(IConstant.C03S001);
            toolwholelifecycle.setHandSetID(handSetId);
            //  toolwholelifecycle.setToolCode(toolCode);
            //  toolwholelifecycle.setToolName(toolCode);

            toolwholelifecycle.setKnifeInventoryCode(tt.getKnifeInventoryCode());
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(customerID);
            toolwholelifecycle.setUpdateUser(customerID);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            toolwholelifecycle.setToolID(toolID);
            toolwholelifecycle.setPartsID("");
            String toolWholeLifecycleID = UUIDgen.getId();
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            toolwholelifecycleDao.insert(toolwholelifecycle);
        }
        //判断已有刀具将怎么处理 删除
        if (ttRfidConID.size() > 0) {
            tooltransferDao.updateBatchbyttRfidConID(ttRfidConID);
        }
        //判断已有刀具将怎么处理 删除
        if (ttRfidConID.size() > 0) {
            knifeinventoryDao.updateBatchbykn(ttRfidConID);
        }

        if (rrlist.size() > 0) {
            submitRfidConer(rrlist);
        }
        if (ttlist.size() > 0) {
            tooltransferDao.insertBatchss(ttlist);
        }
        return reVal;
    }

    /**
     * 查询库存新刀信息
     *
     * @param kentity
     * @return
     * @throws Exception
     */
    @Override
    public List<Vknifeinventoryinfo> getknifeinventoryinfo(Vknifeinventoryinfo kentity) throws Exception {
        List<Vknifeinventoryinfo> reList = vknifeinventoryinfoDao.searchListByToolCode(kentity);
        return reList;
    }

    /**
     * 库存新刀初始化批量加入
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> submitNewVentoryInItDate(Map<String, Object> param) throws Exception {
        Map<String, Object> reVal = new HashMap<String, Object>();
        //1）rfid标签集合
        List<String> rfidList = (List<String>) param.get("rfidCodeList");
        //2）标签类型(1单品刀)
        String queryType = (String) param.get("queryType");
        //3）材料号
        String toolCode = (String) param.get("toolCode");
        //4）用户ID
        String userID = (String) param.get("userID");
        //5）刀具ID
        String toolID = (String) param.get("toolID");
        //5）创建人ID
        String customerID = (String) param.get("customerID");

        //5）手持机ID
        String handSetId = (String) param.get("handSetId");
        Map<String, Object> par = new HashMap<String, Object>();
        par.put("queryType", queryType);
        par.put("list", rfidList);
        List<Rfidcontainer> rfidcontainerList = rfidcontainerDao.searchListBySamle(par);
        if (rfidcontainerList != null && rfidcontainerList.size() > 0) {
            reVal.put(IConstant.STATE_CODE, IConstant.STOCK_STATE_1);
            reVal.put(IConstant.STATE_MSG, "当前扫描的刀具中有非刀具标签");
            return reVal;
        }
        //查询刀具信息
        Tool t = new Tool();
        t.setToolCode(toolCode);
        Tool re = getToolIDByToolCode(t);
        if (null == re) {
            reVal.put(IConstant.STATE_CODE, IConstant.STOCK_STATE_1);
            reVal.put(IConstant.STATE_MSG, "未找到当前材料号信息");
            return reVal;
        }
        List<Rfidcontainer> rList = new ArrayList<Rfidcontainer>();
        List<Knifeinventory> kList = new ArrayList<Knifeinventory>();
        List<String> rfidConIDList = new ArrayList<String>();
        Rfidcontainer rfidcontainer = null;
        Knifeinventory knifeinventory = null;
        // 遍历rfidCodeList，将数据插入到rfid载体表和新到库存表
        for (String str : rfidList) {
            //时间戳
            Thread.sleep(1);
            String getTime = String.valueOf(UUIDgen.getTimes());
            String rfidcontainerID = UUIDgen.getId().toString();
            // 先插入到rfid载体
            rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidContainerID(rfidcontainerID);
            rfidcontainer.setRfidCode(str);
            rfidcontainer.setQueryType(IConstant.QUERY_TYPE_1);
            rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
            rfidcontainer.setRfidReCount(BigDecimal.ZERO);
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            rfidcontainer.setUpdateUser(userID);
            rfidcontainer.setUpdateTime(new Date());
            rfidcontainer.setCreateUser(userID);
            rfidcontainer.setCreateTime(new Date());
            rfidcontainer.setSystemLogUser(userID);
            rList.add(rfidcontainer);

            knifeinventory = new Knifeinventory();
            knifeinventory.setRfidContainerID(rfidcontainerID);
            knifeinventory.setToolID(toolID);
            knifeinventory.setKnifeInventoryCode(getTime);
            knifeinventory.setProcuredBatch(IConstant.INIT_PROCURED_BATCH);
            knifeinventory.setKnifeInventoryType(IConstant.STRING_0);
            knifeinventory.setDelFlag(IConstant.DEL_FLAG_0);
            knifeinventory.setUpdateUser(userID);
            knifeinventory.setUpdateTime(new Date());
            knifeinventory.setCreateUser(userID);
            if (re.getToolLength() == null) {
                re.setToolLength(new BigDecimal(20));
            }
            knifeinventory.setToolLength(re.getToolLength());
            knifeinventory.setCreateTime(new Date());
            knifeinventory.setVersion(new BigDecimal(1));
            knifeinventory.setKnifelnventoryNumber(IConstant.STRING_1);
            knifeinventory.setToolDurable(re.getToolNumber());
            knifeinventory.setToolSharpennum(new BigDecimal(0));
            knifeinventory.setToolSharpenCriterion(re.getToolSharpenCriterion());
            if (re.getToolSharpenLength() == null) {
                re.setToolSharpenLength(new BigDecimal(IConstant.STRING_5));
            }
            knifeinventory.setToolSharpenLength(re.getToolSharpenLength());
            kList.add(knifeinventory);
            //插入到生命周期表  记录刀具生命周期
            Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
            toolwholelifecycle.setBusinessFlowLnkID(IConstant.C03S001);
            toolwholelifecycle.setHandSetID(handSetId);
            toolwholelifecycle.setProcessAmount(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setKnifeInventoryCode(getTime);
            toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
            toolwholelifecycle.setCreateTime(new Date());
            toolwholelifecycle.setUpdateTime(new Date());
            toolwholelifecycle.setCreateUser(customerID);
            toolwholelifecycle.setUpdateUser(customerID);
            toolwholelifecycle.setVersion(BigDecimal.ZERO);
            toolwholelifecycle.setToolID(toolID);
            toolwholelifecycle.setPartsID("");
            String toolWholeLifecycleID = UUIDgen.getId();
            toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
            toolwholelifecycleDao.insert(toolwholelifecycle);
        }
        if (rfidList.size() > 0) {
            //删除载体id
            rfidcontainerDao.deleteByRfidCodeList(rfidList);
            //删除流转中的刀具信息
            tooltransferDao.deleteByRfidCodeList(rfidList);
            //删除新刀的信息
            knifeinventoryDao.deleteByRfidCodeList(rfidList);
        }

        if (rList.size() > 0) {
            submitRfidConer(rList);
        }
   /*     if (rfidConIDList.size() > 0) {
            List<Knifeinventory> rfidConlist = knifeinventoryDao.getRfidContainerEd(rfidConIDList);
            if (rfidConlist != null && rfidConlist.size() > 0) {
                reVal.put(IConstant.STATE_CODE, IConstant.STOCK_STATE_1);
                reVal.put(IConstant.STATE_MSG, "当前扫描的标签中已有已初始化的刀具");
                return reVal;
            }
        }*/

        if (kList.size() > 0) {
            knifeinventoryDao.insertBatch1(kList);
            //TODO

        }

        return reVal;
    }

    /**
     * 查询刀具信息
     *
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public Tool getToolIDByToolCode(Tool t) throws Exception {
        Tool reEntity = new Tool();
        // 根据刀具ID查询材料号
        List<Tool> reList = (List<Tool>) toolDao.searchByList(t);
        if (reList == null || reList.size() < 1) {
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    /**
     * 提交库位标签初始化数据
     *
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> submitLibraryCodeMsg(Map<String, Object> param) throws Exception {
        Map<String, Object> reVal = new HashMap<String, Object>();

        //用户ID
        String userID = (String) param.get("userID");
        //RFIDCode
        String rfidCode = (String) param.get("rfidCode");
        //标签类型(0 库位标签)
        //String queryType = (String) param.get("queryType");
        //材料号
        String toolCode = (String) param.get("toolCode");
        //初始化数量
        String knifelnventoryNumber = (String) param.get("knifelnventoryNumber");

        //检查当前是否有载体
        Rfidcontainer entity = new Rfidcontainer();
        // RFID标签
        entity.setRfidCode(rfidCode);
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        //查询刀具信息
        Tool t = new Tool();
        t.setToolCode(toolCode);
        t.setDelFlag(IConstant.DEL_FLAG_0);
        Tool re = getToolIDByToolCode(t);
        if (null == re) {
            reVal.put("stateCode", IConstant.DEL_FLAG_1);
            reVal.put("stateMsg", "未查到当前材料号信息");
            return reVal;
        }
        Knifeinventory k1 = new Knifeinventory();
        k1.setDelFlag(IConstant.DEL_FLAG_0);
        k1.setToolID(re.getToolID());
        List<Knifeinventory> list = (List<Knifeinventory>) knifeinventoryDao.searchByList(k1);
        if (list != null && list.size() > 0) {
            k1 = new Knifeinventory();
            k1.setToolIDWhere(re.getToolID());
            knifeinventoryDao.delete(k1);
            Rfidcontainer rf = new Rfidcontainer();
            rf.setRfidContainerIDWhere(list.get(0).getRfidContainerID());
            rfidcontainerDao.delete(rf);
        }

        Rfidcontainer rfidcontainer = null;
        List<Rfidcontainer> rfidcontainers = (List<Rfidcontainer>) rfidcontainerDao.searchByList(entity);
        String rifdConnerID = null;
        if (rfidcontainers != null && rfidcontainers.size() > 0 && rfidcontainers.get(0) != null && (IConstant.QUERY_TYPE_0.equals(rfidcontainers.get(0).getQueryType()))) {
            rfidcontainer = rfidcontainers.get(0);
            //已初始化过标签
            rifdConnerID = rfidcontainer.getRfidContainerID();
        } else {
            rfidcontainer = new Rfidcontainer();
            rifdConnerID = UUIDgen.getId();
            //RFID载体ID
            rfidcontainer.setRfidContainerID(rifdConnerID);
            //RFID标签ID
            rfidcontainer.setRfidCode(rfidCode);
            //RFID重用次数
            rfidcontainer.setRfidReCount(BigDecimal.ONE);
            //绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
            rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
            //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rfidcontainer.setQueryType(IConstant.KNIFE_INVENTORY_TYPE_0);
            //删除区分(0有效1删除)
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            rfidcontainer.setCreateTime(new Date());
            rfidcontainer.setUpdateTime(new Date());
            rfidcontainer.setCreateUser(userID);
            rfidcontainer.setUpdateUser(userID);
            rfidcontainer.setVersion(BigDecimal.ZERO);
            //加入载体表
            rfidcontainerDao.insert(rfidcontainer);
        }

        //查询是否已有初始化库位标签
        Knifeinventory knifeinventory = new Knifeinventory();
        knifeinventory.setToolID(re.getToolID());
        knifeinventory.setRfidContainerID(rifdConnerID);
        knifeinventory.setDelFlag(IConstant.DEL_FLAG_0);
        List<Knifeinventory> knifeinventories = (List<Knifeinventory>) knifeinventoryDao.searchByList(knifeinventory);
        if (knifeinventories != null && knifeinventories.size() > 0) {
            Knifeinventory k2 = knifeinventories.get(0);
            knifeinventory = new Knifeinventory();
            knifeinventory.setRfidContainerIDWhere(rifdConnerID);
            knifeinventory.setProcuredBatch(IConstant.INIT_PROCURED_BATCH);
            knifeinventory.setDelFlagWhere(IConstant.DEL_FLAG_0);
            knifeinventory.setToolIDWhere(re.getToolID());
            if (k2.getKnifelnventoryNumber() == null) {
                k2.setKnifelnventoryNumber(IConstant.DEL_FLAG_0);
            }
            //   knifeinventory.setKnifelnventoryNumber((Integer.parseInt(k2.getKnifelnventoryNumber()) + Integer.parseInt(knifelnventoryNumber)) + "");
            knifeinventory.setKnifelnventoryNumber(knifelnventoryNumber);
            knifeinventory.setUpdateUser(userID);
            knifeinventory.setUpdateTime(new Date());
            knifeinventoryDao.updateNonQuery(knifeinventory);
        } else {
            knifeinventory = new Knifeinventory();
            knifeinventory.setRfidContainerID(rifdConnerID);
            knifeinventory.setToolID(re.getToolID());
            knifeinventory.setKnifeInventoryCode(String.valueOf(UUIDgen.getTimes()));
            knifeinventory.setProcuredBatch(IConstant.INIT_PROCURED_BATCH);
            knifeinventory.setKnifelnventoryNumber(knifelnventoryNumber);
            knifeinventory.setKnifeInventoryType(IConstant.KNIFE_INVENTORY_TYPE_0);
            knifeinventory.setToolDurable(re.getToolNumber());
            knifeinventory.setToolSharpennum(new BigDecimal(0));
            knifeinventory.setToolSharpenCriterion(re.getToolSharpenCriterion());
            if (re.getToolLength() == null) {
                re.setToolLength(new BigDecimal(20));
            }
            knifeinventory.setToolLength(re.getToolLength());
            if (re.getToolSharpenLength() == null) {
                re.setToolSharpenLength(new BigDecimal(5));
            }
            knifeinventory.setToolSharpenLength(re.getToolSharpenLength());
            if (re.getToolSharpenCriterion() == null) {
                re.setToolSharpenCriterion(new BigDecimal(5));
            }
            knifeinventory.setToolSharpenCriterion(re.getToolSharpenCriterion());
            knifeinventory.setDelFlag(IConstant.DEL_FLAG_0);
            knifeinventory.setUpdateUser(userID);
            knifeinventory.setUpdateTime(new Date());
            knifeinventory.setCreateUser(userID);
            knifeinventory.setCreateTime(new Date());
            knifeinventory.setVersion(BigDecimal.ZERO);

            knifeinventoryDao.insert(knifeinventory);
        }
        return reVal;
    }

    /**
     * 根据载体ID查询合成刀具编码
     *
     * @param skentity
     * @return
     * @throws Exception
     */
    @Override
    public Synthesisknife getSynCodeByRfidConner(Synthesisknife skentity) throws Exception {
        Synthesisknife reEntity = new Synthesisknife();
        // 根据刀具ID查询材料号
        List<Synthesisknife> reList = (List<Synthesisknife>) synthesisknifeDao.searchByList(skentity);
        if (reList == null || reList.size() < 1) {
            reEntity.setRetErrFlag(true);
        } else {
            reEntity = reList.get(0);
        }
        return reEntity;
    }

    /**
     * 根据合成刀具ID查询合成刀具位置信息
     *
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<Vgetsynsistoolmsg> getSynLocationMsg(Vgetsynsistoolmsg entity) throws Exception {
        return vgetsynsistoolmsgDao.getSynLocationMsg(entity);
    }

    /**
     * 提交合成刀具初始化信息
     *
     * @param
     * @return
     * @throws SQLException
     */
    public Map<String, Object> submitInitSynthesis(Map<String, Object> map) throws Exception {
        List<String> rfidList = (List<String>) map.get("rfidList");
        List<String> toolCodeList = (List<String>) map.get("toolCodeList");
        String handSetId = (String) map.get("handSetId");
        String customerID = (String) map.get("customerID");
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("delFlag", IConstant.DEL_FLAG_1);
        map2.put("userId", customerID);
        map2.put("updateTime", new Date());
        map2.put("list", rfidList);
        //  try {
        // 查询已经有的合成刀具信息
        List<Synthesisknife> skList = synthesisknifeDao.findskListByRfidList(rfidList);
        if (skList.size() > 0) {
            //删除流转中的数据
            tooltransferDao.updateBatchDeFlagByRfid(map2);
            Synthesisknife sk1 = null;
            Synthesisexperience se = null;
            //删除合成刀库中的数据
            for (Synthesisknife sk : skList) {
                //合成刀库
                sk1 = new Synthesisknife();
                sk1.setDelFlag(IConstant.DEL_FLAG_1);
                sk1.setUpdateTime(new Date());
                sk1.setUpdateUser(customerID);
                sk1.setSynthesisParametersCodeWhere(sk.getSynthesisParametersCode());
                sk1.setSynthesisParametersNumberWhere(sk.getSynthesisParametersNumber());
                synthesisknifeDao.updateNonQuery(sk1);
            }
        }

        for (int i = 0; i < rfidList.size(); i++) {
        /*    // 根据入库类型判断最后业务流程
            // 取得当前业务对应的流程ID
          //  Businessflowlnk businessflowlnk = new Businessflowlnk();
            Business business = new Business();
            business.setBusinessCode(IConstant.C03S002);
            List<Business> businessList = (List<Business>) businessDao.searchByList(business);
            if (businessList == null || businessList.size() <= 0) {
                // 当前流程不存在!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", "当前流程不存在");
                return result;
            } else {
                business = businessList.get(0);// 取出流程ID
                businessflowlnk.setBusinessID(business.getBusinessID());
                List<Businessflowlnk> businessflowlnkList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnk);
                if (businessflowlnkList == null || businessflowlnkList.size() <= 0) {
                    // 当前流程不存在!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", "当前流程不存在");
                    return result;
                } else {
                    businessflowlnk = businessflowlnkList.get(0);
                }
            }*/
            // 当前合成刀具RFID
            String rfidString = rfidList.get(i);
            // 当前合成刀具编码
            String toolCode = toolCodeList.get(0);
            // 取得当前合成刀具组成
            Synthesisparameters synthesisparameters = new Synthesisparameters();
            synthesisparameters.setSynthesisParametersCode(toolCode);
            synthesisparameters.setDelFlag(IConstant.DEL_FLAG_0);
            List<Synthesisparameters> synthesisparametersList = (List<Synthesisparameters>) synthesisparametersDao.searchByListPoint(synthesisparameters);
            if (synthesisparametersList == null || synthesisparametersList.size() <= 0) {
                // 当前合成刀不存在!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", "当前流程不存在");
                return result;
            }
            String synthesisparametersID = synthesisparametersList.get(0).getSynthesisParametersID();
            //为刀具生命周期查询零部件id
            Oplink oplink = new Oplink();
            oplink.setSynthesisParametersID(synthesisparametersID);
            List<Oplink> oplinklist = (List<Oplink>) oplinkDao.searchByList(oplink);
            if (oplinklist == null || oplinklist.size() <= 0) {
                // 当前合成刀不存在!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", "当前合成刀具编码没有配置生产关联，请联系管理员");
                return result;
            }
            String partsID = oplinklist.get(0).getPartsID();
            Synthesiscutterlocation synthesiscutterlocation = new Synthesiscutterlocation();
            synthesiscutterlocation.setSynthesisParametersID(synthesisparametersID);
            List<Synthesiscutterlocation> synthesiscutterlocationList = (List<Synthesiscutterlocation>) synthesiscutterlocationDao.searchByList(synthesiscutterlocation);
            if (synthesiscutterlocationList == null || synthesiscutterlocationList.size() <= 0) {
                // 位置信息取得失败!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", "位置信息取得失败");
                return result;
            }
            List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();
            String rfidID = null;
            // 获取RFID载体ID 如果不存在则新建数据
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(rfidString);
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            if (rfidcontainerList == null || rfidcontainerList.size() <= 0) {
                // 新建载体数据
                rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                rfidcontainer.setQueryType(IConstant.BAND_TYPE_2);
                rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                rfidcontainer.setVersion(BigDecimal.ZERO);
                rfidcontainer.setUpdateTime(new Date());
                rfidcontainer.setUpdateUser(customerID);
                rfidcontainer.setSystemLogUser(customerID);
                rfidcontainer.setRfidReCount(BigDecimal.ONE);
                rfidID = NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, customerID);
                rfidcontainer.setRfidContainerID(rfidID);
                rfidcontainerDao.insert(rfidcontainer);
            } else {
                // 如果删除区分为无效
                rfidcontainer = rfidcontainerList.get(0);
                if (IConstant.DEL_FLAG_1.equals(rfidcontainer.getDelFlag())) {
                    rfidID = rfidcontainer.getRfidContainerID();
                    Rfidcontainer entity = new Rfidcontainer();
                    if (rfidcontainer.getRfidReCount() == null) {
                        entity.setRfidReCount(BigDecimal.ONE);
                    } else {
                        entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                    }
                    entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                    entity.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainerDao.updateNonQuery(entity);
                } else {
                    rfidID = rfidcontainer.getRfidContainerID();
                    Rfidcontainer entity = new Rfidcontainer();
                    entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                    entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                    entity.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainerDao.updateNonQuery(entity);
                }
            }
            // 建立组成该合成刀具的流转刀具数据
            for (Synthesiscutterlocation synthesiscutterlocation2 : synthesiscutterlocationList) {
                // 取得刀具参数ID
                Tool tool = new Tool();
                tool.setToolCode(synthesiscutterlocation2.getToolCode());
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList == null || toolList.size() <= 0) {
                    //  当前刀具编码未记录!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", "当前刀具编码未记录");
                    return result;
                }
                tool = toolList.get(0);

                Tooltransfer tooltransfer = new Tooltransfer();
                tooltransfer.setToolID(tool.getToolID());// 刀具编码
                tooltransfer.setToolSharpennum(tool.getToolSharpennum());// 可使用(刃磨)次数
                tooltransfer.setToolSharpenCriterion(tool.getToolSharpenCriterion());// 复磨标准
                tooltransfer.setBusinessFlowLnkID(IConstant.C03S001);// 最后业务流程
                tooltransfer.setToolDurable(BigDecimal.ONE);//数量
                tooltransfer.setProcuredBatch(IConstant.INIT_PROCURED_BATCH);
                tooltransfer.setToolLength(tool.getToolLength());// 刀具长度
                tooltransfer.setToolSharpenLength(tool.getToolSharpenLength());// 可刃磨长度
                tooltransfer.setStockState(IConstant.STOCK_STATE_4);// 库存状态
                tooltransfer.setToolGrindingLength(BigDecimal.ZERO);
                tooltransfer.setUsageCounter(BigDecimal.ZERO);
                tooltransfer.setInstallationState(IConstant.INSTALLATION_STATE_0);// 刀具安装状态(未安装)
                tooltransfer.setToolState(IConstant.TOOL_STATE_3);// 待分拣(在生产线上)
                tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
                tooltransfer.setCreateTime(new Date());
                tooltransfer.setUpdateTime(new Date());
                tooltransfer.setCreateUser(customerID);
                tooltransfer.setUpdateUser(customerID);
                tooltransfer.setVersion(BigDecimal.ZERO);
                tooltransfer.setRfidContainerID(rfidID);
                Thread.sleep(1);
                tooltransfer.setKnifeInventoryCode(String.valueOf(UUIDgen.getTimes()));
                //车间
                tooltransfer.setToolThisState(IConstant.STSATIC_FOUR);
                inputList.add(tooltransfer);
            }
            int j = 0;//遍历位置信息使用
            //取得合成刀具序号
            Synthesisknife entity = new Synthesisknife();
            entity.setSynthesisParametersCode(toolCode);//合成刀具编码
            entity.setOrderString("ABS(SynthesisParametersNumber) desc");
            entity.setRowCount(1);
            Synthesisknife sk1 = synthesisknifeDao.searchBySynthesisknife(entity);
            String synthesisParametersNumber = "001";
            if (sk1 != null) {
                int temp = Integer.parseInt(sk1.getSynthesisParametersNumber());
                if (temp < 9) {
                    synthesisParametersNumber = "00" + (temp + 1);
                } else if (temp < 99) {
                    synthesisParametersNumber = "0" + (temp + 1);
                } else {
                    synthesisParametersNumber = (temp + 1) + "";
                }

                //   synthesisParametersNumber = synthesisParametersNumber.substring(synthesisParametersNumber.length() - 3);
            }
            List<Toolwholelifecycle> toolwholelifecycles = new ArrayList<>();
            List<Synthesisknife> synthesisknifes = new ArrayList<>();
            Toolwholelifecycle toolwholelifecycle = null;
            for (Tooltransfer tooltransfer : inputList) {
                //合成刀库数据建立
                Synthesisknife synthesisknife = new Synthesisknife();
                synthesisknife.setSynthesisParametersCode(toolCode);//合成刀具编码
                synthesisknife.setSynthesisParametersNumber(synthesisParametersNumber);
                synthesisknife.setSynthesisCutterNumber(synthesiscutterlocationList.get(j).getSynthesisCutterNumber());//位置号
                synthesisknife.setBusinessFlowLnkID(IConstant.C03S001);//最后流程ID
                synthesisknife.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());//刀具入库编码
                //RFID
                synthesisknife.setrFID(rfidID);
                //是否安装
                synthesisknife.setInstallFlag(IConstant.INSTALL_FLAG_0);
                synthesisknife.setLoadState(IConstant.STRING_3);
                synthesisknife.setOffloadType(BigDecimal.ZERO.toString());
                synthesisknife.setxPoint(BigDecimal.ZERO);
                synthesisknife.setyPoint(BigDecimal.ZERO);
                synthesisknife.setDelFlag(IConstant.DEL_FLAG_0);
                synthesisknife.setCreateTime(new Date());
                synthesisknife.setUpdateTime(new Date());
                synthesisknife.setCreateUser(customerID);
                synthesisknife.setUpdateUser(customerID);
                synthesisknife.setVersion(BigDecimal.ZERO);
                synthesisknifes.add(synthesisknife);
                j++;
                // 记录刀具生命周期
                Tool tool = new Tool();
                tool.setToolID(tooltransfer.getToolID());
                tool = (Tool) toolDao.searchByPrimaryKey(tool);
                if (tool == null) {
                    // 当前刀具编码未记录!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0116);
                    return result;
                }
                toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(IConstant.C03S001);
                toolwholelifecycle.setToolID(tool.getToolID());
                toolwholelifecycle.setHandSetID(handSetId);
                toolwholelifecycle.setPartsID(partsID);
                toolwholelifecycle.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
                toolwholelifecycle.setProcessAmount(IConstant.STRING_0);
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(customerID);
                toolwholelifecycle.setUpdateUser(customerID);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                toolwholelifecycle.setToolWholeLifecycleID(UUIDgen.getId());
                toolwholelifecycles.add(toolwholelifecycle);
            }

            if (toolwholelifecycles.size() > 0) {
                toolwholelifecycleDao.insertBatchs(toolwholelifecycles);
            }
            if (inputList.size() > 0) {
                tooltransferDao.insertBatchs(inputList);
            }
            if (synthesisknifes.size() > 0) {
                synthesisknifeDao.insertBatchs(synthesisknifes);
            }
        }
        result.put("status", IConstant.RESULT_CODE_0);
        return result;

    }

    @Override
    public Vknifeinventoryinfo getIsHasToolInit(Vknifeinventoryinfo vknifeinventoryinfo) throws Exception {
        return vknifeinventoryinfoDao.getIsHasToolInit(vknifeinventoryinfo);
    }

    @Override
    public Vknifeinventoryinfo getknifeinventoryByToolCode(Vknifeinventoryinfo entity) throws Exception {
        //材料号查询库存信息
        return vknifeinventoryinfoDao.getknifeinventoryByToolCode(entity);
    }

    @Override
    public Vknifeinventoryinfo getknifeinventoryBySamleTool(Vknifeinventoryinfo entity) throws Exception {
        //按照RFID查询库存信息
        return vknifeinventoryinfoDao.getknifeinventoryBySamleTool(entity);
    }

    @Override
    public List<Vsynthesisparameters> getSynLocationMsgs(Map<String, Object> parMap) throws Exception {
        //合成刀具编成
        String synthesisParametersCode = (String) parMap.get("synthesisParametersCode");
        Vsynthesisparameters entity = new Vsynthesisparameters();
        entity.setSynthesisParametersCode(synthesisParametersCode);
        return (List<Vsynthesisparameters>) vsynthesisparametersDao.searchByList(entity);
    }

    @Override
    public int getKinfeiverToolCount(Knifeinventory knifeinventory) throws Exception {
        return knifeinventoryDao.searchByCount(knifeinventory);
    }

    /**
     * 查询批次
     *
     * @param tp
     * @return
     * @throws Exception
     */
    @Override
    public Toolprocured getTProcuredBacth(Toolprocured tp) throws Exception {
        return toolprocuredDao.getTProcuredBacth(tp);
    }

    /**
     * 提交载体ID
     *
     * @param list
     * @return
     * @throws Exception
     */
    @Override
    public Object submitRfidConer(List<Rfidcontainer> list) throws Exception {
        return rfidcontainerDao.insertBatchRfid(list);
    }

    //查询库位标签信息
    @Override
    public Vknifeinventoryinfo getknifeinventoryinfos(Vknifeinventoryinfo v) throws Exception {
        // 根据载体ID或材料号查询信息
        List<Vknifeinventoryinfo> reList = vknifeinventoryinfoDao.searchListByToolCode(v);
        if (reList == null || reList.size() < 1) {
            v.setRetErrFlag(true);
        } else {
            v = reList.get(0);
        }
        return v;
    }

    /**
     * @param tt
     * @return
     * @throws Exception
     */
    @Override
    public Knifeinventory getToolCodeByRfidcon(Knifeinventory tt) throws Exception {
        return (Knifeinventory) knifeinventoryDao.searchByPrimaryKey(tt);
    }

    /**
     * 库房初始化处理
     *
     * @param result     处理返回值
     * @param map        初始化
     * @param inputType  初始化类型(1:库房新刀，2:库房旧刀)
     * @param customerID
     * @param langCode
     * @param langValue
     * @param handsetid
     * @return
     */
    @SuppressWarnings("unchecked")
    private boolean warehouseToolInitialization(Map<String, Object> result, Map<String, Object> map, String inputType, String customerID, String langCode, String langValue, String handsetid) throws SQLException {
        if (IConstant.STRING_1.equals(inputType)) {
            // 判断当前刀具编码 的刀具类型：刀具|辅具
            Tool tool = new Tool();
            tool.setToolCode(map.get("ToolCode").toString());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            if (toolList == null || toolList.size() <= 0) {
                // 当前刀具编码未记录!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", IConstant.WMSG0116);
                return false;
            } else {
                tool = toolList.get(0);

                // 获取RFID载体ID 如果不存在则新建数据
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidCode(map.get("RfidString").toString());
                List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                String rfidID = null;
                if (rfidcontainerList == null || rfidcontainerList.size() <= 0) {
                    // 新建载体数据
                    rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                    rfidcontainer.setQueryType(IConstant.QUERY_TYPE_0);
                    rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainer.setVersion(BigDecimal.ZERO);
                    rfidcontainer.setUpdateTime(new Date());
                    rfidcontainer.setUpdateUser(customerID);
                    rfidcontainer.setSystemLogUser(customerID);
                    rfidcontainer.setRfidReCount(BigDecimal.ONE);
                    rfidID = NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, customerID);
                    rfidcontainer.setRfidContainerID(rfidID);
                    rfidcontainerDao.insert(rfidcontainer);
                } else {
                    // 如果删除区分为无效
                    rfidcontainer = rfidcontainerList.get(0);
                    if (IConstant.DEL_FLAG_1.equals(rfidcontainer.getDelFlag())) {
                        rfidID = rfidcontainer.getRfidContainerID();
                        Rfidcontainer entity = new Rfidcontainer();
                        if (rfidcontainer.getRfidReCount() == null) {
                            rfidcontainer.setRfidReCount(BigDecimal.ZERO);
                        }
                        entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                        entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        entity.setDelFlag(IConstant.DEL_FLAG_0);
                        rfidcontainerDao.updateNonQuery(entity);
                    } else {
                        if (IConstant.TOOL_TYPE_0.equals(tool.getToolType())) {// 刀具
                            // 当前RFID已使用!
                            result.put("status", IConstant.RESULT_CODE_1);
                            result.put("messagetext", IConstant.WMSG0118);
                            return false;

                        } else {// 辅具
                            rfidID = rfidcontainer.getRfidContainerID();
                            Rfidcontainer entity = new Rfidcontainer();
                            entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                            entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                            entity.setDelFlag(IConstant.DEL_FLAG_0);
                            rfidcontainerDao.updateNonQuery(entity);
                        }
                    }
                }
                List<Knifeinventory> inputList = new ArrayList<Knifeinventory>();

                //String key = NextKeyValue.getkeyvalue(IConstant.KNIFEINVENTORY,IConstant.KNIFEINVENTORYCODE);
                int toolUnitnumber;
                // 刀具按照每盒数量分盒插入
                // 辅具按照数量完全插入
                toolUnitnumber = Integer.parseInt(map.get("ToolCount").toString());
                for (int i = 0; i < toolUnitnumber; i++) {
                    Knifeinventory knifeInventory = new Knifeinventory();
                    knifeInventory.setRfidContainerID(rfidID);
                    knifeInventory.setToolID(tool.getToolID());
                    knifeInventory.setKnifeInventoryType(IConstant.KNIFE_INVENTORY_TYPE_0);
                    knifeInventory.setToolSharpennum(BigDecimal.ZERO);
                    knifeInventory.setToolSharpenCriterion(new BigDecimal("0.5"));
                    // knifeInventory.setToolDurable(tool.getToolDurable());
                    knifeInventory.setToolLength(tool.getToolLength());// 刀具长度
                    knifeInventory.setToolSharpenLength(tool.getToolSharpenLength());// 可刃磨长度
                    knifeInventory.setDelFlag(IConstant.DEL_FLAG_0);
                    knifeInventory.setCreateTime(new Date());
                    knifeInventory.setUpdateTime(new Date());
                    knifeInventory.setCreateUser(customerID);
                    knifeInventory.setUpdateUser(customerID);
                    knifeInventory.setVersion(BigDecimal.ZERO);
                    //	key = (new BigDecimal(key).add(BigDecimal.ONE)).toString();
                    knifeInventory.setKnifeInventoryCode(String.valueOf(UUIDgen.getTimes()));
                    inputList.add(knifeInventory);
                }
                // 取得当前业务对应的流程ID
                Businessflowlnk businessflowlnk = new Businessflowlnk();
                Business business = new Business();
                business.setLanguageCode(langCode);
                business.setBusinessCode(IConstant.C03S001);
                List<Business> businessList = (List<Business>) businessDao.searchByList(business);
                if (businessList == null || businessList.size() <= 0) {
                    // 当前流程不存在!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", MessageReSource.getMessageBox(IConstant.WMSG0119, langCode, langValue));
                    return false;
                } else {
                    business = businessList.get(0);// 取出流程ID
                    businessflowlnk.setBusinessID(business.getBusinessID());
                    List<Businessflowlnk> businessflowlnkList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnk);
                    if (businessflowlnkList == null || businessflowlnkList.size() <= 0) {
                        // 当前流程不存在!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0119);
                        return false;
                    } else {
                        businessflowlnk = businessflowlnkList.get(0);
                    }
                }
                //				NextKeyValue.savekeyvalue(IConstant.KNIFEINVENTORY,
                //						IConstant.KNIFEINVENTORYCODE, key, customerID);
                for (Knifeinventory knifeInventory : inputList) {
                    knifeinventoryDao.insert(knifeInventory);// 刀具入库
                    // 记录刀具生命周期
                    Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
                    toolwholelifecycle.setBusinessFlowLnkID(IConstant.C03S001);
                    toolwholelifecycle.setHandSetID(handsetid);
                    toolwholelifecycle.setToolCode(tool.getToolCode());
                    toolwholelifecycle.setToolName(tool.getToolName());
                    toolwholelifecycle.setKnifeInventoryCode(knifeInventory.getKnifeInventoryCode());
                    toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                    toolwholelifecycle.setCreateTime(new Date());
                    toolwholelifecycle.setUpdateTime(new Date());
                    toolwholelifecycle.setCreateUser(customerID);
                    toolwholelifecycle.setUpdateUser(customerID);
                    toolwholelifecycle.setVersion(BigDecimal.ZERO);
                    String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerID);
                    toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                    toolwholelifecycleDao.insert(toolwholelifecycle);
                }
            }
            result.put("status", IConstant.RESULT_CODE_0);
            result.put("messagetext", IConstant.IMSG0009);// 入库成功！
        } else {// 库房旧刀初始化
            // 判断当前刀具编码 的刀具类型：刀具|辅具
            Tool tool = new Tool();
            tool.setToolCode(map.get("ToolCode").toString());
            List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
            if (toolList == null || toolList.size() <= 0) {
                // 当前刀具编码未记录!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", MessageReSource.getMessageBox(IConstant.WMSG0116, langCode, langValue));
                return false;
            } else {
                tool = toolList.get(0);

                // 获取RFID载体ID 如果不存在则新建数据
                Rfidcontainer rfidcontainer = new Rfidcontainer();
                rfidcontainer.setRfidCode(map.get("RfidString").toString());
                List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                String rfidID = null;
                if (rfidcontainerList == null || rfidcontainerList.size() <= 0) {
                    // 新建载体数据
                    rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                    rfidcontainer.setQueryType(IConstant.QUERY_TYPE_1);
                    rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainer.setVersion(BigDecimal.ZERO);
                    rfidcontainer.setUpdateTime(new Date());
                    rfidcontainer.setUpdateUser(customerID);
                    rfidcontainer.setSystemLogUser(customerID);
                    rfidcontainer.setRfidReCount(BigDecimal.ONE);
                    rfidID = NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, customerID);
                    rfidcontainer.setRfidContainerID(rfidID);
                    rfidcontainerDao.insert(rfidcontainer);
                } else {
                    // 如果删除区分为无效
                    rfidcontainer = rfidcontainerList.get(0);
                    if (IConstant.DEL_FLAG_1.equals(rfidcontainer.getDelFlag())) {
                        rfidID = rfidcontainer.getRfidContainerID();
                        Rfidcontainer entity = new Rfidcontainer();
                        entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                        entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        entity.setDelFlag(IConstant.DEL_FLAG_0);
                        rfidcontainerDao.updateNonQuery(entity);
                    } else {
                        if (IConstant.TOOL_TYPE_0.equals(tool.getToolType())) {// 刀具
                            // 当前RFID已使用!
                            result.put("status", IConstant.RESULT_CODE_1);
                            result.put("messagetext", IConstant.WMSG0118);
                            return false;

                        } else {// 辅具
                            rfidID = rfidcontainer.getRfidContainerID();
                            Rfidcontainer entity = new Rfidcontainer();
                            entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                            entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                            entity.setDelFlag(IConstant.DEL_FLAG_0);
                            rfidcontainerDao.updateNonQuery(entity);
                        }
                    }
                }
                List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();

                //	String key = NextKeyValue.getkeyvalue(IConstant.KNIFEINVENTORY,IConstant.KNIFEINVENTORYCODE);
                int toolUnitnumber = Integer.parseInt(map.get("ToolCount").toString());
                // 取得当前业务对应的流程ID
                Businessflowlnk businessflowlnk = new Businessflowlnk();
                Business business = new Business();
                business.setLanguageCode(langCode);
                business.setBusinessCode(IConstant.C03S001);
                List<Business> businessList = (List<Business>) businessDao.searchByList(business);
                if (businessList == null || businessList.size() <= 0) {
                    // 当前流程不存在!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0119);
                    return false;
                } else {
                    business = businessList.get(0);// 取出流程ID
                    businessflowlnk.setBusinessID(business.getBusinessID());
                    List<Businessflowlnk> businessflowlnkList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnk);
                    if (businessflowlnkList == null || businessflowlnkList.size() <= 0) {
                        // 当前流程不存在!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0119);
                        return false;
                    } else {
                        businessflowlnk = businessflowlnkList.get(0);
                    }
                }
                for (int i = 0; i < toolUnitnumber; i++) {
                    Tooltransfer tooltransfer = new Tooltransfer();
                    tooltransfer.setRfidContainerID(rfidID);// 载体ID
                    tooltransfer.setToolID(tool.getToolID());// 刀具编码
                    tooltransfer.setToolSharpennum(tool.getToolSharpennum());// 可使用(刃磨)次数
                    tooltransfer.setToolSharpenCriterion(tool.getToolSharpenCriterion());// 复磨标准
                    tooltransfer.setBusinessFlowLnkID(IConstant.C03S001);// 最后业务流程
                    // tooltransfer.setToolDurable(tool.getToolDurable());// 耐用度
                    tooltransfer.setToolLength(tool.getToolLength());// 刀具长度
                    tooltransfer.setToolSharpenLength(tool.getToolSharpenLength());//可刃磨长度
                    tooltransfer.setInstallationState(IConstant.INSTALLATION_STATE_2);// 刀具安装状态
                    tooltransfer.setToolState(IConstant.TOOL_STATE_9);
                    tooltransfer.setStockState(IConstant.STOCK_STATE_0);
                    tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
                    tooltransfer.setCreateTime(new Date());
                    tooltransfer.setUpdateTime(new Date());
                    tooltransfer.setCreateUser(customerID);
                    tooltransfer.setUpdateUser(customerID);
                    tooltransfer.setVersion(BigDecimal.ZERO);
                    tooltransfer.setToolThisState(IConstant.STSATIC_ZERO);
                    //key = (new BigDecimal(key).add(BigDecimal.ONE)).toString();
                    tooltransfer.setKnifeInventoryCode(UUIDgen.getId());
                    inputList.add(tooltransfer);
                }

                //NextKeyValue.savekeyvalue("KNIFEINVENTORY","KNIFEINVENTORYCODE", key, customerID);
                for (Tooltransfer tooltransfer : inputList) {
                    tooltransferDao.insert(tooltransfer);// 刀具入库
                    // 记录刀具生命周期
                    Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
                    toolwholelifecycle.setBusinessFlowLnkID(IConstant.C03S001);
                    toolwholelifecycle.setHandSetID(handsetid);
                    toolwholelifecycle.setToolCode(tool.getToolCode());
                    toolwholelifecycle.setToolName(tool.getToolName());
                    toolwholelifecycle.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
                    toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                    toolwholelifecycle.setCreateTime(new Date());
                    toolwholelifecycle.setUpdateTime(new Date());
                    toolwholelifecycle.setCreateUser(customerID);
                    toolwholelifecycle.setUpdateUser(customerID);
                    toolwholelifecycle.setVersion(BigDecimal.ZERO);
                    String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerID);
                    toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                    toolwholelifecycleDao.insert(toolwholelifecycle);
                }
            }
            result.put("status", IConstant.RESULT_CODE_0);
            result.put("messagetext", IConstant.IMSG0009);// 入库成功！

        }
        return true;
    }

    /**
     * 刃磨室始化处理
     *
     * @param result     处理返回值
     * @param map        初始化
     * @param inputType  初始化类型(3:刃磨室待复磨，4:刃磨室待送回，5:刃磨室待报废)
     * @param customerID
     * @param langCode
     * @param langValue
     * @param handsetid
     * @return
     */
    @SuppressWarnings("unchecked")
    private boolean grindingToolInitialization(Map<String, Object> result, Map<String, Object> map, String inputType, String customerID, String langCode, String langValue, String handsetid) throws SQLException {
        // 判断当前刀具编码 的刀具类型：刀具|辅具
        Tool tool = new Tool();
        tool.setToolCode(map.get("ToolCode").toString());
        List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
        if (toolList == null || toolList.size() <= 0) {
            // 当前刀具编码未记录!
            result.put("status", IConstant.RESULT_CODE_1);
            result.put("messagetext", IConstant.WMSG0116);
            return false;
        } else {
            tool = toolList.get(0);

            // 获取RFID载体ID 如果不存在则新建数据
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(map.get("RfidString").toString());
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            String rfidID = null;
            if (rfidcontainerList == null || rfidcontainerList.size() <= 0) {
                // 新建载体数据
                rfidcontainer.setBandType(IConstant.BAND_TYPE_0);
                rfidcontainer.setQueryType(IConstant.QUERY_TYPE_1);
                rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
                rfidcontainer.setVersion(BigDecimal.ZERO);
                rfidcontainer.setUpdateTime(new Date());
                rfidcontainer.setUpdateUser(customerID);
                rfidcontainer.setSystemLogUser(customerID);
                rfidcontainer.setRfidReCount(BigDecimal.ONE);
                rfidID = NextKeyValue.getNextkeyvalue(IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID, customerID);
                rfidcontainer.setRfidContainerID(rfidID);
                rfidcontainerDao.insert(rfidcontainer);
            } else {
                // 如果删除区分为无效
                rfidcontainer = rfidcontainerList.get(0);
                if (IConstant.DEL_FLAG_1.equals(rfidcontainer.getDelFlag())) {
                    rfidID = rfidcontainer.getRfidContainerID();
                    Rfidcontainer entity = new Rfidcontainer();
                    entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                    entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                    entity.setDelFlag(IConstant.DEL_FLAG_0);
                    rfidcontainerDao.updateNonQuery(entity);
                } else {
                    if (IConstant.TOOL_TYPE_0.equals(tool.getToolType())) {// 刀具
                        // 当前RFID已使用!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0118);
                        return false;

                    } else {// 辅具
                        rfidID = rfidcontainer.getRfidContainerID();
                        Rfidcontainer entity = new Rfidcontainer();
                        entity.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                        entity.setRfidContainerIDWhere(rfidcontainer.getRfidContainerID());
                        entity.setDelFlag(IConstant.DEL_FLAG_0);
                        rfidcontainerDao.updateNonQuery(entity);
                    }
                }
            }
            List<Tooltransfer> inputList = new ArrayList<Tooltransfer>();

            //String key = NextKeyValue.getkeyvalue(IConstant.KNIFEINVENTORY,IConstant.KNIFEINVENTORYCODE);
            int toolUnitnumber = Integer.parseInt(map.get("ToolCount").toString());
            // 取得当前业务对应的流程ID
  /*          Businessflowlnk businessflowlnk = new Businessflowlnk();
            Business business = new Business();
            business.setLanguageCode(langCode);
            business.setBusinessCode(IConstant.C03S001);

            List<Business> businessList = (List<Business>) businessDao.searchByList(business);
            if (businessList == null || businessList.size() <= 0) {
                // 当前流程不存在!
                result.put("status", IConstant.RESULT_CODE_1);
                result.put("messagetext", IConstant.WMSG0119);
                return false;
            } else {
                business = businessList.get(0);// 取出流程ID
                businessflowlnk.setBusinessID(business.getBusinessID());
                List<Businessflowlnk> businessflowlnkList = (List<Businessflowlnk>) businessflowlnkDao.searchByList(businessflowlnk);
                if (businessflowlnkList == null || businessflowlnkList.size() <= 0) {
                    // 当前流程不存在!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0119);
                    return false;
                } else {
                    businessflowlnk = businessflowlnkList.get(0);
                }
            }*/
            for (int i = 0; i < toolUnitnumber; i++) {
                Tooltransfer tooltransfer = new Tooltransfer();
                tooltransfer.setRfidContainerID(rfidID);// 载体ID
                tooltransfer.setToolID(tool.getToolID());// 刀具编码
                tooltransfer.setToolSharpennum(BigDecimal.ZERO);// 可使用(刃磨)次数
                tooltransfer.setToolSharpenCriterion(new BigDecimal("0.5"));// 复磨标准
                tooltransfer.setBusinessFlowLnkID(IConstant.C03S001);// 最后业务流程
                //  tooltransfer.setToolDurable(tool.getToolDurable());// 耐用度
                tooltransfer.setToolLength(tool.getToolLength());// 刀具长度
                if (inputType.equals(IConstant.STRING_4) || inputType.equals(IConstant.STRING_3)) {
                    tooltransfer.setToolSharpenLength(tool.getToolSharpenLength());// 可刃磨长度
                    tooltransfer.setStockState(IConstant.STOCK_STATE_0);// 库存状态
                } else if (inputType.equals(IConstant.STRING_5)) {
                    tooltransfer.setToolSharpenLength(BigDecimal.ZERO);// 可刃磨长度
                    tooltransfer.setStockState(IConstant.STOCK_STATE_1);// 库存状态
                }
                tooltransfer.setToolSharpenLength(tool.getToolSharpenLength());// 可刃磨长度
                tooltransfer.setInstallationState(IConstant.INSTALLATION_STATE_0);// 刀具安装状态
                tooltransfer.setToolState(IConstant.TOOL_STATE_9);

                tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
                tooltransfer.setCreateTime(new Date());
                tooltransfer.setUpdateTime(new Date());
                tooltransfer.setCreateUser(customerID);
                tooltransfer.setUpdateUser(customerID);
                tooltransfer.setVersion(BigDecimal.ZERO);
                //key = (new BigDecimal(key).add(BigDecimal.ONE)).toString();
                tooltransfer.setKnifeInventoryCode(UUIDgen.getId());
                inputList.add(tooltransfer);
            }

            //NextKeyValue.savekeyvalue("KNIFEINVENTORY", "KNIFEINVENTORYCODE",key, customerID);
            for (Tooltransfer tooltransfer : inputList) {
                tooltransferDao.insert(tooltransfer);// 刀具入库
                // 记录刀具生命周期
                Toolwholelifecycle toolwholelifecycle = new Toolwholelifecycle();
                toolwholelifecycle.setBusinessFlowLnkID(IConstant.C03S001);
                toolwholelifecycle.setHandSetID(handsetid);
                toolwholelifecycle.setToolCode(tool.getToolCode());
                toolwholelifecycle.setToolName(tool.getToolName());
                toolwholelifecycle.setKnifeInventoryCode(tooltransfer.getKnifeInventoryCode());
                toolwholelifecycle.setDelFlag(IConstant.DEL_FLAG_0);
                toolwholelifecycle.setCreateTime(new Date());
                toolwholelifecycle.setUpdateTime(new Date());
                toolwholelifecycle.setCreateUser(customerID);
                toolwholelifecycle.setUpdateUser(customerID);
                toolwholelifecycle.setVersion(BigDecimal.ZERO);
                String toolWholeLifecycleID = NextKeyValue.getNextkeyvalue(IConstant.TOOLWHOLELIFECYCLE, IConstant.TOOLWHOLELIFECYCLEID, customerID);
                toolwholelifecycle.setToolWholeLifecycleID(toolWholeLifecycleID);
                toolwholelifecycleDao.insert(toolwholelifecycle);
            }
        }
        result.put("status", IConstant.RESULT_CODE_0);
        result.put("messagetext", IConstant.IMSG0009);// 入库成功！
        return true;
    }

    @Override
    public Tooltransfer getToolIDByRfidcon(Tooltransfer tt) throws Exception {
        return (Tooltransfer) tooltransferDao.searchByPrimaryKey(tt);
    }

}
