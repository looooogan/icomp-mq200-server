package com.icomp.common.service.impl.icomp.v01c01.s007;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s007.ICOMPV01C01S007Service;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VgetreturnfactorytoolDao;
import com.icomp.dao.VgetsealedsafekeepingtoolDao;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgetreturnfactorytool;
import com.icomp.entity.base.Vgetsealedsafekeepingtool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封存刀具-Services实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S007ServiceImpl
 * @date 2014-9-25 上午11:22:44
 */
public class ICOMPV01C01S007ServiceImpl extends BaseService implements ICOMPV01C01S007Service {

    private VgetsealedsafekeepingtoolDao vgetsealedsafekeepingtoolDao;
    private RfidcontainerDao rfidcontainerDao;
    private VgetreturnfactorytoolDao vgetreturnfactorytoolDao;
    private KnifeinventoryDao knifeinventoryDao;
    private TooltransferDao tooltransferDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setVgetreturnfactorytoolDao(VgetreturnfactorytoolDao vgetreturnfactorytoolDao) {
        this.vgetreturnfactorytoolDao = vgetreturnfactorytoolDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    public void setVgetsealedsafekeepingtoolDao(VgetsealedsafekeepingtoolDao vgetsealedsafekeepingtoolDao) {
        this.vgetsealedsafekeepingtoolDao = vgetsealedsafekeepingtoolDao;
    }

    /**
     * 取得待封存刀具信息
     * getToolInfo
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Vgetsealedsafekeepingtool> getToolInfo(Vgetsealedsafekeepingtool entity) throws Exception {
        Vgetreturnfactorytool vgetreturnfactorytool = new Vgetreturnfactorytool();
        Vgetsealedsafekeepingtool vr = null;
        List<Vgetsealedsafekeepingtool> list = new ArrayList<Vgetsealedsafekeepingtool>();
        List<Vgetreturnfactorytool> list1 = null;
        try {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(entity.getRfidCode());
            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
            String type = rfidcontainerList.get(0).getQueryType();
            if (IConstant.STSATIC_ZERO.equals(type)) {//查询方式(0库存1流转)
                list = (List<Vgetsealedsafekeepingtool>) vgetsealedsafekeepingtoolDao.searchByList(entity);
            } else {
                vgetreturnfactorytool.setRfidCode(entity.getRfidCode());
                list1 = (List<Vgetreturnfactorytool>) vgetreturnfactorytoolDao.searchByList(vgetreturnfactorytool);
                for (Vgetreturnfactorytool v : list1) {
                    vr = new Vgetsealedsafekeepingtool();
                    vr.setRfidCode(v.getRfidCode());
                    vr.setToolID(v.getToolID());
                    vr.setToolName(v.getToolName());
                    vr.setToolCode(v.getToolCode());
                    vr.setProcuredBatch(v.getProcuredBatch());
                    vr.setthisCount(v.getthisCount());
                    vr.setInventoryCount(v.getInventoryCount());
                    list.add(vr);
                }
            }
            if (list == null || list.size() <= 0) {
                //待封存刀具未找到相应数据!
                list = new ArrayList<Vgetsealedsafekeepingtool>();
                Vgetsealedsafekeepingtool vgetsealedsafekeepingtool = new Vgetsealedsafekeepingtool();
                vgetsealedsafekeepingtool.setMessageCode(IConstant.WMSG0130);
                vgetsealedsafekeepingtool.setRetErrFlag(true);
                list.add(vgetsealedsafekeepingtool);
            }

        } catch (SQLException e) {
            //数据库操作异常，查询失败!
            list = new ArrayList<Vgetsealedsafekeepingtool>();
            Vgetsealedsafekeepingtool vgetsealedsafekeepingtool = new Vgetsealedsafekeepingtool();
            vgetsealedsafekeepingtool.setMessageCode(IConstant.EMSG0004);
            vgetsealedsafekeepingtool.setRetErrFlag(true);
            vgetsealedsafekeepingtool.setExceMessage(e.getMessage());
            list.add(vgetsealedsafekeepingtool);
        }
        return list;
    }

    /**
     * 该刀具是否封存
     *
     * @param rfidString
     * @return
     * @throws Exception
     */
    @Override
    public boolean isHasSaveTools(String rfidString) throws Exception {
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(rfidString);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        String rfidContainerId = rfidcontainerList.get(0).getRfidContainerID();
        if (IConstant.STSATIC_ZERO.equals(rfidcontainerList.get(0).getQueryType())) {//0库存
            Knifeinventory ki = new Knifeinventory();
            ki.setRfidContainerID(rfidContainerId);
            ki.setKnifeInventoryType(IConstant.KNIFE_INVENTORY_TYPE_3);
            ki.setDelFlag(IConstant.DEL_FLAG_0);
            if (knifeinventoryDao.searchByCount(ki) > 0)
                return true;

        } else {//1流转
            //流转中的刀具
            Tooltransfer tooltransfer = new Tooltransfer();
            tooltransfer.setRfidContainerID(rfidContainerId);
            tooltransfer.setStockState(IConstant.STOCK_STATE_3);
            tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
            if (tooltransferDao.searchByCount(tooltransfer) > 0)
                return true;
        }
        return false;
    }

    /**
     * 保存待封存刀具信息
     * saveReturnToolInfo
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int saveReturnToolInfo(Map<String, Object> map) throws Exception {
        String userID = map.get("userId") + "";//UserID
        List<String> rfidList = (List<String>) map.get("rfidList");//rfidlist
        String gruantId = map.get("gruantId") + "";//授权人不id
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("inParam", rfidList);
        param.put("updateTime", new Date());
        param.put("updateUser", userID);
        param.put("gruantId", gruantId);//授权人
        param.put("stockType", IConstant.KNIFE_INVENTORY_TYPE_3);
        param.put("delFlag", IConstant.DEL_FLAG_0);//删除区分
        int reVal = knifeinventoryDao.updateKnifeInventoryType(param);
        param.put("stockType", IConstant.STOCK_STATE_3);
        reVal += tooltransferDao.updateStockState(param);
        return reVal;
    }

}


