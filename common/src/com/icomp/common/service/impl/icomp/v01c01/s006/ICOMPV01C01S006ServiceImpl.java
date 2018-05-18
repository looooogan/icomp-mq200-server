package com.icomp.common.service.impl.icomp.v01c01.s006;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s006.ICOMPV01C01S006Service;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VgetboxmessageDao;
import com.icomp.dao.VgetboxmessagesDao;
import com.icomp.dao.VgetreturnfactorytoolDao;
import com.icomp.dao.VgetsealedsafekeepingtoolDao;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetboxmessage;
import com.icomp.entity.base.Vgetboxmessages;
import com.icomp.entity.base.Vgetreturnfactorytool;
import com.icomp.entity.base.Vgetsealedsafekeepingtool;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具返厂-Service实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S006ServiceImpl
 * @date 2014-9-24 下午07:59:38
 */
public class ICOMPV01C01S006ServiceImpl extends BaseService implements ICOMPV01C01S006Service {

    /**
     * 刀具返厂Dao
     */
    private VgetreturnfactorytoolDao vgetreturnfactorytoolDao;

    public void setVgetreturnfactorytoolDao(VgetreturnfactorytoolDao vgetreturnfactorytoolDao) {
        this.vgetreturnfactorytoolDao = vgetreturnfactorytoolDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private VgetboxmessageDao vgetboxmessageDao;
    private VgetboxmessagesDao vgetboxmessagesDao;
    private ToolprocuredDao toolprocuredDao;
    private VgetsealedsafekeepingtoolDao vgetsealedsafekeepingtoolDao;
    private KnifeinventoryDao knifeinventoryDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    private TooltransferDao tooltransferDao;

    public void setVgetsealedsafekeepingtoolDao(VgetsealedsafekeepingtoolDao vgetsealedsafekeepingtoolDao) {
        this.vgetsealedsafekeepingtoolDao = vgetsealedsafekeepingtoolDao;
    }

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    public void setVgetboxmessageDao(VgetboxmessageDao vgetboxmessageDao) {
        this.vgetboxmessageDao = vgetboxmessageDao;
    }

    public void setVgetboxmessagesDao(VgetboxmessagesDao vgetboxmessagesDao) {
        this.vgetboxmessagesDao = vgetboxmessagesDao;
    }

    /**
     * 查询待返厂刀具信息
     * getToolInfo
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Vgetreturnfactorytool> getToolInfo(Vgetreturnfactorytool entity) {
        Vgetsealedsafekeepingtool vgetsealedsafekeepingtool = new Vgetsealedsafekeepingtool();
        Vgetreturnfactorytool vr = null;
        List<Vgetreturnfactorytool> list = new ArrayList<Vgetreturnfactorytool>();
        List<Vgetsealedsafekeepingtool> list1 = null;
        try {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(entity.getRfidCode());
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            String type = rfidcontainerList.get(0).getQueryType();
            if (IConstant.STSATIC_ZERO.equals(type)) {//查询方式(0库存1流转)
                vgetsealedsafekeepingtool.setRfidCode(entity.getRfidCode());
                list1 = (List<Vgetsealedsafekeepingtool>) vgetsealedsafekeepingtoolDao.searchByList(vgetsealedsafekeepingtool);
                for (Vgetsealedsafekeepingtool v : list1) {
                    vr = new Vgetreturnfactorytool();
                    vr.setRfidCode(v.getRfidCode());
                    vr.setToolID(v.getToolID());
                    vr.setToolName(v.getToolName());
                    vr.setToolCode(v.getToolCode());
                    vr.setProcuredBatch(v.getProcuredBatch());
                    vr.setthisCount(v.getthisCount());
                    vr.setInventoryCount(v.getInventoryCount());
                    list.add(vr);
                }
            } else {
                list = (List<Vgetreturnfactorytool>) vgetreturnfactorytoolDao.searchByList(entity);
            }

            if (list == null || list.size() <= 0) {
                //待返厂刀具未找到相应数据!
                list = new ArrayList<Vgetreturnfactorytool>();
                Vgetreturnfactorytool vgetreturnfactorytool = new Vgetreturnfactorytool();
                vgetreturnfactorytool.setMessageCode(IConstant.WMSG0129);
                vgetreturnfactorytool.setRetErrFlag(true);
                list.add(vgetreturnfactorytool);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            //数据库操作异常，查询失败!
            list = new ArrayList<Vgetreturnfactorytool>();
            Vgetreturnfactorytool vgetreturnfactorytool = new Vgetreturnfactorytool();
            vgetreturnfactorytool.setMessageCode(IConstant.EMSG0004);
            vgetreturnfactorytool.setRetErrFlag(true);
            vgetreturnfactorytool.setExceMessage(e.getMessage());
            list.add(vgetreturnfactorytool);
            return list;
        }
    }

    /**
     * 取得待返厂刀具信息
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Vgetreturnfactorytool getReturnFactoryTools(Map<String, Object> map) throws Exception {
        Vgetreturnfactorytool reEntity = new Vgetreturnfactorytool();
        String rfidString = map.get("rfidString") + "";
        String toolId = map.get("toolId") + "";

        try {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(rfidString);
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            if (rfidcontainerList.size() > 0) {
                if (IConstant.STSATIC_ZERO.equals(rfidcontainerList.get(0).getQueryType())) {//0库存1流转
                    //库房中的刀具
                    Vgetboxmessages vgetboxmessages = new Vgetboxmessages();
                    vgetboxmessages.setRfidCode(rfidString);
                    List<Vgetboxmessages> vBoxNewList = (List<Vgetboxmessages>) vgetboxmessagesDao.searchByList(vgetboxmessages);
                    if (vBoxNewList.size() > 0) {
                        Toolprocured tp = new Toolprocured();
                        tp.setToolProcuredID(vBoxNewList.get(0).getToolProcuredID());
                        tp.setDelFlag(IConstant.DEL_FLAG_0);
                        tp = (Toolprocured) toolprocuredDao.searchByPrimaryKey(tp);
                        if (tp != null) {
                            reEntity.setProcuredBatch(tp.getProcuredBatch()); //批次
                        }
                        reEntity.setthisCount(new BigDecimal(vBoxNewList.size()));
                    }
                } else {
                    //流转中的刀具
                    Vgetboxmessage vgetboxmessage = new Vgetboxmessage();
                    vgetboxmessage.setRfidCode(rfidString);
                    List<Vgetboxmessage> vBoxOldList = (List<Vgetboxmessage>) vgetboxmessageDao.searchByList(vgetboxmessage);
                    if (vBoxOldList.size() > 0) {
                        Toolprocured tp = new Toolprocured();
                        tp.setToolProcuredID(vBoxOldList.get(0).getToolProcuredID());
                        tp.setDelFlag(IConstant.DEL_FLAG_0);
                        tp = (Toolprocured) toolprocuredDao.searchByPrimaryKey(tp);
                        if (tp != null) {
                            reEntity.setProcuredBatch(tp.getProcuredBatch());
                        }
                        reEntity.setthisCount(new BigDecimal(vBoxOldList.size()));
                    }
                }
                if (reEntity.getthisCount().equals(BigDecimal.ZERO)) {
                    //待返厂刀具未找到相应数据!
                    reEntity = new Vgetreturnfactorytool();
                    reEntity.setMessageCode(IConstant.WMSG0129);
                    reEntity.setRetErrFlag(true);
                }
            } else {
                //待返厂刀具未找到相应数据!
                reEntity = new Vgetreturnfactorytool();
                reEntity.setMessageCode(IConstant.WMSG0129);
                reEntity.setRetErrFlag(true);
            }

        } catch (SQLException e) {
            //数据库操作异常，查询失败!
            Vgetreturnfactorytool vgetreturnfactorytool = new Vgetreturnfactorytool();
            vgetreturnfactorytool.setMessageCode(IConstant.EMSG0004);
            vgetreturnfactorytool.setRetErrFlag(true);
            vgetreturnfactorytool.setExceMessage(e.getMessage());
        }
        return reEntity;
    }

    /**
     * 该刀具是否返厂
     *
     * @param rfidString
     * @return
     * @throws Exception
     */
    @Override
    public boolean isHasReturnFactory(String rfidString) throws Exception {
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(rfidString);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        String rfidContainerId = rfidcontainerList.get(0).getRfidContainerID();
        if (IConstant.STSATIC_ZERO.equals(rfidcontainerList.get(0).getQueryType())) {//0库存
            Knifeinventory ki = new Knifeinventory();
            ki.setRfidContainerID(rfidContainerId);
            ki.setKnifeInventoryType(IConstant.KNIFE_INVENTORY_TYPE_4);
            ki.setDelFlag(IConstant.DEL_FLAG_0);
            if (knifeinventoryDao.searchByCount(ki) > 0)
                return true;

        } else {//1流转
            //流转中的刀具
            Tooltransfer tooltransfer = new Tooltransfer();
            tooltransfer.setRfidContainerID(rfidContainerId);
            tooltransfer.setStockState(IConstant.STOCK_STATE_2);
            tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
            if (tooltransferDao.searchByCount(tooltransfer) > 0)
                return true;
        }
        return false;
    }

    /**
     * 保存返厂刀具数据
     * saveReturnToolInfo
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveReturnToolInfo(Map<String, Object> map) throws Exception {
        int reVal = 0;
        Map<String, Object> param = new HashMap<String, Object>();
        String userID = map.get("userId") + "";//UserID
        List<String> rfidList = (List<String>) map.get("rfidList");//rfidlist
        String gruantId = map.get("gruantId") + "";//授权人不id

        param.put("inParam", rfidList);
        param.put("updateTime", new Date());
        param.put("updateUser", userID);
        param.put("gruantId", gruantId);//授权人
        param.put("stockType", IConstant.KNIFE_INVENTORY_TYPE_4);
        param.put("delFlag", IConstant.DEL_FLAG_1); //返厂后删除数据
        reVal += knifeinventoryDao.updateKnifeInventoryType(param);
        param.put("stockType", IConstant.STOCK_STATE_2);
        reVal += tooltransferDao.updateStockState(param);
        return reVal;
    }
}
