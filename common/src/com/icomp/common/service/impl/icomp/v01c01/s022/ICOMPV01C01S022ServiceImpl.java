package com.icomp.common.service.impl.icomp.v01c01.s022;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s022.ICOMPV01C01S022Service;
import com.icomp.dao.BusinessDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolshelflnkDao;
import com.icomp.dao.ToolshelfplaceDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.TooltransferhistoryDao;
import com.icomp.dao.VgettoolshelfmessageDao;
import com.icomp.dao.VreplacerfidDao;
import com.icomp.entity.base.AbnormalToolParam;
import com.icomp.entity.base.Business;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Toolshelflnk;
import com.icomp.entity.base.Toolshelfplace;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Tooltransferhistory;
import com.icomp.entity.base.Vgettoolshelfmessage;
import com.icomp.entity.base.Vreplacerfid;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 异常刀具处理-Services实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01C01S022ServiceImpl
 * @date 2014-10-31 上午11:21:05
 */
@SuppressWarnings("unchecked")
public class ICOMPV01C01S022ServiceImpl extends BaseService implements ICOMPV01C01S022Service {

    // 取得刀具盘信息
    private VgettoolshelfmessageDao vgettoolshelfmessageDao;

    public void setVgettoolshelfmessageDao(VgettoolshelfmessageDao vgettoolshelfmessageDao) {
        this.vgettoolshelfmessageDao = vgettoolshelfmessageDao;
    }

    // 工具盘位置Dao
    private ToolshelflnkDao toolshelflnkDao;

    public void setToolshelflnkDao(ToolshelflnkDao toolshelflnkDao) {
        this.toolshelflnkDao = toolshelflnkDao;
    }

    // 工具盘位置信息Dao
    private ToolshelfplaceDao toolshelfplaceDao;

    public void setToolshelfplaceDao(ToolshelfplaceDao toolshelfplaceDao) {
        this.toolshelfplaceDao = toolshelfplaceDao;
    }

    private TooltransferhistoryDao tooltransferhistoryDao;

    public void setTooltransferhistoryDao(TooltransferhistoryDao tooltransferhistoryDao) {
        this.tooltransferhistoryDao = tooltransferhistoryDao;
    }

    // 刀具流转Dao
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private VreplacerfidDao vreplacerfidDao;

    public void setVreplacerfidDao(VreplacerfidDao vreplacerfidDao) {
        this.vreplacerfidDao = vreplacerfidDao;
    }

    /**
     * 取得工具盘列表
     */
    @Override
    public List<Vgettoolshelfmessage> getToolShelfList(Vgettoolshelfmessage entity) throws Exception {
        List<Vgettoolshelfmessage> list = new ArrayList<Vgettoolshelfmessage>();
        try {
            // 待收回合成刀具信息
            list = (List<Vgettoolshelfmessage>) vgettoolshelfmessageDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                Vgettoolshelfmessage reEntity = new Vgettoolshelfmessage();
                reEntity.setMessageCode(IConstant.WMSG0225);
                reEntity.setRetErrFlag(true);
                list.add(reEntity);
            }
        } catch (SQLException e) {
            Vgettoolshelfmessage reEntity = new Vgettoolshelfmessage();
            reEntity.setMessageCode(IConstant.EMSG0004);
            reEntity.setRetErrFlag(true);
            reEntity.setExceMessage(e.getMessage());
            list.add(reEntity);
        }
        return list;
    }

    /**
     * 取得工具盘位置列表
     */
    @Override
    public List<Vgettoolshelfmessage> getToolShelfLocations(Toolshelflnk entity) throws Exception {
        List<Vgettoolshelfmessage> list = new ArrayList<Vgettoolshelfmessage>();
        try {
            // 待收回合成刀具信息
            List<Toolshelflnk> tfList = (List<Toolshelflnk>) toolshelflnkDao.searchByList(entity);
            if (tfList == null || tfList.size() <= 0) {
                Vgettoolshelfmessage reEntity = new Vgettoolshelfmessage();
                reEntity.setMessageCode(IConstant.WMSG0225);
                reEntity.setRetErrFlag(true);
                list.add(reEntity);
            } else {
                Vgettoolshelfmessage vf = null;
                for (Toolshelflnk tf : tfList) {
                    vf = new Vgettoolshelfmessage();
                    Toolshelfplace tsf = new Toolshelfplace();
                    if (tf.getKnifeInventoryCode() != null && !"".equals(tf.getKnifeInventoryCode())) {
                        tsf.setToolShelfPlaceID(tf.getToolShelfPlaceNumber());
                        tsf.setDelFlag(IConstant.DEL_FLAG_0);
                        vf.setToolShelfID(entity.getToolShelfID()); // 工具盘ID
                        vf.setPlaceNumber(new BigDecimal(tf.getToolShelfPlaceNumber()));// 工具盘位置号
                        vf.setPlaceCode(((Toolshelfplace) toolshelfplaceDao.searchByPrimaryKey(tsf)).getPlaceCode());// 工具盘位置编码
                        vf.setKnifeInventoryCode(tf.getKnifeInventoryCode());// 刀具入库编码
                        list.add(vf);
                    }

                }

            }
        } catch (SQLException e) {
            Vgettoolshelfmessage reEntity = new Vgettoolshelfmessage();
            reEntity.setMessageCode(IConstant.EMSG0004);
            reEntity.setRetErrFlag(true);
            reEntity.setExceMessage(e.getMessage());
            list.add(reEntity);
        }
        return list;
    }

    /**
     * 工具盘异常刀具处理
     */
    @Override
    public int saveToolShelfAbnormalTool(Map<String, Object> map) throws Exception {
        int reVal = 0;
        String userId = map.get("userId").toString();// 用户Id
        String rfidString = map.get("rfidString").toString();// 新盒RFID
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(rfidString);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        if (rfidcontainerList.size() < 1)
            return reVal;

        String rfidContainerId = rfidcontainerList.get(0).getRfidContainerID();
        // 更新对应的RFID
        Map<String, Object> pMap = null;
        for (AbnormalToolParam ap : (List<AbnormalToolParam>) map.get("apList")) {
            pMap = new HashMap<String, Object>();
            Tooltransferhistory tth = new Tooltransferhistory();
            if (!IConstant.STRING_0.equals(ap.getToolState()) && ap.getToolState() != null) {
                // 异常状态[0:正常,1:断刀,2:丢刀]
                if (IConstant.STRING_1.equals(ap.getToolState())) {
                    pMap.put("toolState", IConstant.TOOL_STATE_0);
                    tth.setToolState(IConstant.TOOL_STATE_0);
                } else {
                    pMap.put("toolState", IConstant.TOOL_STATE_1);
                    tth.setToolState(IConstant.TOOL_STATE_1);
                }
                pMap.put("userId", userId);// 用户Id
                pMap.put("knifeInventoryCode", ap.getKnifeInventoryCode());// 入库刀具编码
                pMap.put("rfidString", rfidString);// 新盒RFID
                reVal += tooltransferDao.updateContainerByRfid(pMap);

                tth.setDelFlagWhere(IConstant.DEL_FLAG_0);
                tth.setKnifeInventoryCodeWhere(ap.getKnifeInventoryCode());
                tth.setRfidContainerID(rfidContainerId);
                tth.setUpdateTime(new Date());
                tth.setUpdateUser(userId);
                reVal += tooltransferhistoryDao.updateNonQuery(tth);

                // 更新工具盘位置为空
                Toolshelflnk tf = new Toolshelflnk();
                tf.setToolShelfIDWhere(ap.getToolShelfID());
                tf.setToolShelfPlaceNumberWhere(ap.getToolShelfPlaceNumber());
                reVal += toolshelflnkDao.updateNonQuerys(tf);
            }
        }
        return reVal;
    }

    /**
     * 取得业务流程数据列表
     *
     * @param entity
     * @return
     * @throws Exception
     */
    public List<Business> getBusinessList(Business entity) {
        try {
            // 待收回合成刀具信息
            List<Business> list = (List<Business>) businessDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                Business reEntity = new Business();
                reEntity.setMessageCode(IConstant.WMSG0225);//
                reEntity.setRetErrFlag(true);
                list.add(reEntity);
            }
            return list;
        } catch (SQLException e) {
            List<Business> list = new ArrayList<Business>();
            Business reEntity = new Business();
            reEntity.setMessageCode(IConstant.EMSG0004);
            reEntity.setRetErrFlag(true);
            reEntity.setExceMessage(e.getMessage());
            list.add(reEntity);
            return list;
        }
    }

    /**
     * 取得待扫描标签列表
     *
     * @param businessCode
     * @return
     * @throws Exception
     */
    public Map<String, Object> getRfidList(String businessCode, String toolType) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            Vreplacerfid vreplacerfid = new Vreplacerfid();
            vreplacerfid.setBusinessFlowLnkID(businessCode);
            vreplacerfid.setToolType(toolType);
            List<Vreplacerfid> list = (List<Vreplacerfid>) vreplacerfidDao.searchByList(vreplacerfid);
            if (list == null || list.size() <= 0) {
                ret.put("error", true);
                ret.put("MessageCode", IConstant.EMSG0004);// 未找找所选条件的标签数据!
            } else {
                ret.put("status", IConstant.RESULT_CODE_0);
                List<String> rfidList = new ArrayList<String>();
                for (Vreplacerfid v : list) {
                    if (!rfidList.contains(v.getRfidCode())) {
                        rfidList.add(v.getRfidCode());
                    }
                }
                ret.put("rows", rfidList);
                ret.put("count", rfidList.size());
            }
            return ret;
        } catch (SQLException e) {
            ret.put("error", true);
            ret.put("MessageCode", IConstant.EMSG0004);
            return ret;
        }
    }

    /**
     * 保存更替标签数据
     *
     * @param newRfidString
     * @return
     * @throws Exception
     */
    public Map<String, Object> saveRfid(String rfidString, String newRfidString) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            Rfidcontainer rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCode(newRfidString);
            rfidcontainer.setRfidCodeWhere(rfidString);
            rfidcontainerDao.updateNonQuery(rfidcontainer);
            ret.put("status", IConstant.RESULT_CODE_0);
            ret.put("MessageCode", IConstant.CIMSG0011);
            return ret;
        } catch (SQLException e) {
            ret.put("error", true);
            ret.put("MessageCode", IConstant.EMSG0004);
            return ret;
        }
    }

    /**
     * 保存替换辅具
     *
     * @param map
     * @return
     * @throws SQLException
     */
    @Override
    public int saveHelpToolInfo(Map<String, Object> map) throws SQLException {
        int reVal = 0;
        String oldRfid = map.get("rfidOldString") + "";//旧RFID
        String newRfid = map.get("rfidNewString") + "";//新RFID
        String userId = map.get("userId") + "";//用户ID
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        rfidcontainer.setRfidCode(oldRfid); //合成刀具
        List<Rfidcontainer> rfList1 = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        rfidcontainer = new Rfidcontainer();
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        rfidcontainer.setRfidCode(newRfid); //辅具
        List<Rfidcontainer> rfList2 = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
        String rfidContainerId = null;
        if (rfList1.size() > 0) {  //换刀处理
            rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidCodeWhere(oldRfid);
            rfidcontainer.setDelFlagWhere(IConstant.DEL_FLAG_0);
            rfidcontainer.setRfidCode(newRfid);
            rfidcontainer.setUpdateTime(new Date());
            rfidcontainer.setUpdateUser(userId);
            rfidcontainer.setVersion(rfList1.get(0).getVersion().add(BigDecimal.ONE));
            reVal += rfidcontainerDao.updateNonQuery(rfidcontainer);
        }
        if (rfList2.size() > 0) { //换下后进行处理
            rfidContainerId = rfList2.get(0).getRfidContainerID();
            rfidcontainer = new Rfidcontainer();
            rfidcontainer.setRfidContainerIDWhere(rfidContainerId); //载体id
            rfidcontainer.setDelFlagWhere(IConstant.DEL_FLAG_0);
            rfidcontainer.setRfidCode(oldRfid);
            rfidcontainer.setUpdateTime(new Date());
            rfidcontainer.setUpdateUser(userId);
            rfidcontainer.setVersion(rfList2.get(0).getVersion().add(BigDecimal.ONE));
            Tooltransfer tooltransfer = new Tooltransfer();
            tooltransfer.setRfidContainerIDWhere(rfidContainerId);
            tooltransfer.setDelFlagWhere(IConstant.DEL_FLAG_0);
            tooltransfer.setInstallationState(IConstant.INSTALLATION_STATE_2);
            tooltransfer.setConfirmedUser(userId);
            tooltransfer.setStockState(IConstant.STOCK_STATE_1);
            tooltransferDao.updateNonQuery(tooltransfer);

            reVal = rfidcontainerDao.updateNonQuery(rfidcontainer);
        }
        return reVal;
    }
}
