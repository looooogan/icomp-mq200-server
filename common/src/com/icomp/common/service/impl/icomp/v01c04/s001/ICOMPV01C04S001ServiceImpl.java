package com.icomp.common.service.impl.icomp.v01c04.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c04.s001.ICOMPV01C04S001Service;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.StackDao;
import com.icomp.dao.StockingDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VgettoolinformationDao;
import com.icomp.dao.VstockinglistDao;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Stack;
import com.icomp.entity.base.Stocking;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vgettoolinformation;
import com.icomp.entity.base.Vstockinglist;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C04S001ServiceImpl extends BaseService implements ICOMPV01C04S001Service {

    private VstockinglistDao vstockinglistDao;
    private VgettoolinformationDao vgettoolinformationDao;

    public void setVgettoolinformationDao(VgettoolinformationDao vgettoolinformationDao) {
        this.vgettoolinformationDao = vgettoolinformationDao;
    }

    public void setVstockinglistDao(VstockinglistDao vstockinglistDao) {
        this.vstockinglistDao = vstockinglistDao;
    }

    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    /* rfid 载体Dao */
    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    private StockingDao stockingDao;

    public void setStockingDao(StockingDao stockingDao) {
        this.stockingDao = stockingDao;
    }

    private StackDao stackDao;

    public void setStackDao(StackDao stackDao) {
        this.stackDao = stackDao;
    }

    /**
     * 取得当前扫描刀具数据
     *
     * @param
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Vstockinglist> getToolList(Vstockinglist entity) {
        try {
            // 取得当前扫描刀具数据
            List<Vstockinglist> list = (List<Vstockinglist>) vstockinglistDao.searchByStockingList(entity);
            if (list == null || list.size() <= 0) {
                // 当前扫描刀具数据取得失败!
                list = new ArrayList<Vstockinglist>();
                Vstockinglist vstockinglist = new Vstockinglist();
                vstockinglist.setMessageCode(IConstant.WMSG0162);
                vstockinglist.setRetErrFlag(true);
                list.add(vstockinglist);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vstockinglist> list = new ArrayList<Vstockinglist>();
            Vstockinglist vstockinglist = new Vstockinglist();
            vstockinglist.setMessageCode(IConstant.EMSG0004);
            vstockinglist.setRetErrFlag(true);
            vstockinglist.setExceMessage(e.getMessage());
            list.add(vstockinglist);
            return list;
        }
    }

    /**
     * 取得盘点数据列表
     *
     * @param
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Vstockinglist> getStockingList(List<String> rfids) {
        try {
            // 取得盘点数据列表
            List<Vstockinglist> list = (List<Vstockinglist>) vstockinglistDao.searchByStockingToolList(rfids);
            if (list == null || list.size() <= 0) {
                // 盘点数据取得失败!
                list = new ArrayList<Vstockinglist>();
                Vstockinglist vstockinglist = new Vstockinglist();
                vstockinglist.setMessageCode(IConstant.WMSG0163);
                vstockinglist.setRetErrFlag(true);
                list.add(vstockinglist);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vstockinglist> list = new ArrayList<Vstockinglist>();
            Vstockinglist vstockinglist = new Vstockinglist();
            vstockinglist.setMessageCode(IConstant.EMSG0004);
            vstockinglist.setRetErrFlag(true);
            vstockinglist.setExceMessage(e.getMessage());
            list.add(vstockinglist);
            return list;
        }
    }

    /**
     * 取得已扫描盘点数据列表
     *
     * @param
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Vstockinglist> searchByOldToolList(List<String> rfids) {
        try {
            // 取得盘点数据列表
            List<Vstockinglist> list = (List<Vstockinglist>) vstockinglistDao.searchByOldToolList(rfids);
            if (list == null || list.size() <= 0) {
                // 已扫描盘点数据取得失败!
                list = new ArrayList<Vstockinglist>();
                Vstockinglist vstockinglist = new Vstockinglist();
                vstockinglist.setMessageCode(IConstant.WMSG0164);
                vstockinglist.setRetErrFlag(true);
                list.add(vstockinglist);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vstockinglist> list = new ArrayList<Vstockinglist>();
            Vstockinglist vstockinglist = new Vstockinglist();
            vstockinglist.setMessageCode(IConstant.EMSG0004);
            vstockinglist.setRetErrFlag(true);
            vstockinglist.setExceMessage(e.getMessage());
            list.add(vstockinglist);
            return list;
        }
    }

    /**
     * 保存盘点数据列表
     *
     * @param
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> saveStockingList(List<String> rfids, List<Map<String, Object>> stockings, String customerID, String langCode, String langValue, String handsetid, String gruantUserID) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            for (Map<String, Object> map : stockings) {
                // 判断刀具类型
                String toolCode = (String) map.get("toolCode");
                Tool tool = new Tool();
                tool.setToolCode(toolCode);
                List<Tool> toolList = (List<Tool>) toolDao.searchByList(tool);
                if (toolList == null || toolList.size() <= 0) {
                    // 当前刀具编码未记录!
                    result.put("status", IConstant.RESULT_CODE_1);
                    result.put("messagetext", IConstant.WMSG0116);
                    return result;
                }
                tool = toolList.get(0);
                // 取得当前刀具编码的库存数量
                Vstockinglist vstockinglist = new Vstockinglist();
                vstockinglist.setToolCode(toolCode);
                int storeCount = vstockinglistDao.searchByCount(vstockinglist);
                int stockingCount = Integer.valueOf(map.get("count").toString());// 盘点数量
                // 刀具
                if (IConstant.TOOL_TYPE_0.equals(tool.getToolType())) {

                    // 去除盘亏数据
                    // 根据刀具编码取出对应RFID列表
                    List<Vstockinglist> list = (List<Vstockinglist>) vstockinglistDao.searchByList(vstockinglist);
                    if (list == null || list.size() <= 0) {
                        // 盘亏数据取得失败!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0165);
                        return result;
                    }
                    List<String> rfidList = new ArrayList<String>();
                    List<String> pdList = new ArrayList<String>();
                    for (Vstockinglist vstockinglist2 : list) {
                        if (!rfids.contains(vstockinglist2.getRfidCode()) && !rfidList.contains(vstockinglist2.getRfidCode())) {
                            rfidList.add(vstockinglist2.getRfidCode());
                        } else {// 记录盘点数据
                            if (rfids.contains(vstockinglist2.getRfidCode()) && !pdList.contains(vstockinglist2.getRfidCode())) {
                                pdList.add(vstockinglist2.getRfidCode());
                            }
                        }
                    }
                    for (String rfid : pdList) {
                        // 取得rfid绑定形式
                        Rfidcontainer rfidcontainer = new Rfidcontainer();
                        rfidcontainer.setRfidCode(rfid);
                        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                        rfidcontainer = rfidcontainerList.get(0);
                        String rfidID = rfidcontainer.getRfidContainerID();
                        saveStocking(rfidID, tool.getToolUnitnumber().intValue(), tool.getToolUnitnumber().intValue(), tool, customerID, gruantUserID);
                    }
                    // 根据rfid 清除盘亏数据
                    for (String rfid : rfidList) {
                        // 取得rfid绑定形式
                        Rfidcontainer rfidcontainer = new Rfidcontainer();
                        rfidcontainer.setRfidCode(rfid);
                        List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                        rfidcontainer = rfidcontainerList.get(0);
                        String rfidID = rfidcontainer.getRfidContainerID();
                        String queryType = rfidcontainer.getQueryType();
                        // 盘亏
                        if (storeCount > stockingCount) {
                            if (IConstant.QUERY_TYPE_0.equals(queryType)) {// 库存
                                // 删除库存表中的盘亏数据
                                Knifeinventory knifeinventory = new Knifeinventory();
                                knifeinventory.setRfidContainerIDWhere(rfidID);
                                knifeinventory.setDelFlag(IConstant.DEL_FLAG_1);
                                knifeinventoryDao.updateNonQuery(knifeinventory);
                            } else {// 流转
                                // 删除流转表中的盘亏数据
                                Tooltransfer tooltransfer = new Tooltransfer();
                                tooltransfer.setRfidContainerIDWhere(rfidID);
                                tooltransfer.setDelFlag(IConstant.DEL_FLAG_1);
                                tooltransferDao.updateNonQuery(tooltransfer);
                            }
                            // 释放当前rfid状态
                            rfidcontainer.setRfidContainerIDWhere(rfidID);
                            rfidcontainer.setRfidReCount(rfidcontainer.getRfidReCount().add(BigDecimal.ONE));
                            rfidcontainer.setUpdateTime(new Date());
                            rfidcontainer.setUpdateUser(customerID);
                            rfidcontainer.setDelFlag(IConstant.DEL_FLAG_1);
                            rfidcontainer.setVersion(rfidcontainer.getVersion().add(BigDecimal.ONE));
                            rfidcontainerDao.updateNonQuery(rfidcontainer);
                        } else if (storeCount < stockingCount) {// 盘盈
                            // 添加盘盈数据
                        }
                        // 记录盘点数据
                        saveStocking(rfidID, tool.getToolUnitnumber().intValue(), 0, tool, customerID, gruantUserID);
                    }

                } else {// 辅具、配套

                    // 去除盘亏数据
                    // 根据刀具编码取出对应RFID列表
                    List<Vstockinglist> list = (List<Vstockinglist>) vstockinglistDao.searchByList(vstockinglist);
                    if (list == null || list.size() <= 0) {
                        // 盘亏数据取得失败!
                        result.put("status", IConstant.RESULT_CODE_1);
                        result.put("messagetext", IConstant.WMSG0165);
                        return result;
                    }
                    // 根据rfid 修复库存数据
                    String rfid = list.get(0).getRfidCode();
                    // 取得rfid绑定形式
                    Rfidcontainer rfidcontainer = new Rfidcontainer();
                    rfidcontainer.setRfidCode(rfid);
                    List<Rfidcontainer> rfidcontainerList = (List<Rfidcontainer>) rfidcontainerDao.searchByList(rfidcontainer);
                    rfidcontainer = rfidcontainerList.get(0);
                    String rfidID = rfidcontainer.getRfidContainerID();
                    String queryType = rfidcontainer.getQueryType();
                    // 盘亏
                    if (storeCount > stockingCount) {
                        if (IConstant.QUERY_TYPE_0.equals(queryType)) {// 库存
                            // 删除库存表中的盘亏数据
                            Knifeinventory knifeinventory = new Knifeinventory();
                            knifeinventory.setRfidContainerIDWhere(rfidID);
                            knifeinventory.setOrderString("ToolProcuredID");
                            List<Knifeinventory> knifeinventoryList = (List<Knifeinventory>) knifeinventoryDao.searchByList(knifeinventory);
                            for (int i = 0; i < storeCount - stockingCount; i++) {
                                knifeinventory.setKnifeInventoryCodeWhere(knifeinventoryList.get(i).getKnifeInventoryCode());
                                knifeinventory.setDelFlag(IConstant.DEL_FLAG_1);
                                knifeinventoryDao.updateNonQuery(knifeinventory);
                            }
                        } else {// 流转
                            // 删除流转表中的盘亏数据
                            Tooltransfer tooltransfer = new Tooltransfer();
                            tooltransfer.setRfidContainerIDWhere(rfidID);
                            tooltransfer.setOrderString("ToolProcuredID");
                            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);
                            for (int i = 0; i < storeCount - stockingCount; i++) {
                                tooltransfer.setKnifeInventoryCodeWhere(tooltransferList.get(i).getKnifeInventoryCode());
                                tooltransfer.setDelFlag(IConstant.DEL_FLAG_1);
                                tooltransferDao.updateNonQuery(tooltransfer);
                            }
                        }
                    } else if (storeCount < stockingCount) {// 盘盈
                        if (IConstant.QUERY_TYPE_0.equals(queryType)) {// 库存
                            // 新建库存表中的盘盈数据
                            Knifeinventory knifeinventory = new Knifeinventory();
                            knifeinventory.setRfidContainerIDWhere(rfidID);
                            knifeinventory.setOrderString("ToolProcuredID");
                            List<Knifeinventory> knifeinventoryList = (List<Knifeinventory>) knifeinventoryDao.searchByList(knifeinventory);
                            for (int i = 0; i < storeCount - stockingCount; i++) {
                                knifeinventory = knifeinventoryList.get(0);
                                knifeinventory.setKnifeInventoryCode(NextKeyValue.getNextkeyvalue(IConstant.KNIFEINVENTORY, IConstant.KNIFEINVENTORYCODE, customerID));
                                knifeinventory.setCreateTime(new Date());
                                knifeinventory.setUpdateTime(new Date());
                                knifeinventory.setCreateUser(customerID);
                                knifeinventory.setUpdateUser(customerID);
                                knifeinventory.setVersion(BigDecimal.ZERO);
                                knifeinventoryDao.insert(knifeinventory);
                            }
                        } else {// 流转
                            // 新建库存表中的盘盈数据
                            Tooltransfer tooltransfer = new Tooltransfer();
                            tooltransfer.setRfidContainerIDWhere(rfidID);
                            tooltransfer.setOrderString("ToolProcuredID");
                            List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);
                            for (int i = 0; i < storeCount - stockingCount; i++) {
                                tooltransfer = tooltransferList.get(0);
                                tooltransfer.setKnifeInventoryCode(NextKeyValue.getNextkeyvalue(IConstant.KNIFEINVENTORY, IConstant.KNIFEINVENTORYCODE, customerID));
                                tooltransfer.setCreateTime(new Date());
                                tooltransfer.setUpdateTime(new Date());
                                tooltransfer.setCreateUser(customerID);
                                tooltransfer.setUpdateUser(customerID);
                                tooltransfer.setVersion(BigDecimal.ZERO);
                                tooltransferDao.insert(tooltransfer);
                            }
                        }
                    }
                    // 记录盘点数据
                    saveStocking(rfidID, storeCount, stockingCount, tool, customerID, gruantUserID);

                }
            }
            // 盘点结束
            result.put("status", IConstant.RESULT_CODE_0);
            result.put("messagetext", IConstant.WMSG0226_1);
            return result;
        } catch (SQLException e) {
            result.put("status", IConstant.RESULT_CODE_1);
            result.put("messagetext", IConstant.EMSG0004);
            return result;
        }
    }

    /**
     * 查询库位标签信息
     *
     * @param k
     * @return
     * @throws Exception
     */
    @Override
    public Knifeinventory getKNMsg(Knifeinventory k) throws Exception {
        return knifeinventoryDao.getKNMsg(k);
    }

    /**
     * 查询库位标签信息
     *
     * @param k
     * @return
     * @throws Exception
     */
    @Override
    public List<Knifeinventory> getKNMsgs(Knifeinventory k) throws Exception {

        return knifeinventoryDao.getKNMsgs(k);
    }

    @Override
    public List<Tool> getToolIDByToolCode(Tool t) throws Exception {
        return (List<Tool>) toolDao.getToolIDByToolCode(t);
    }

    @Override
    public List<Rfidcontainer> rfidList(List<Rfidcontainer> recodeList) throws Exception {
        return rfidcontainerDao.searchListBySamle1(recodeList);
    }

    @Override
    public int getupdateDel(Map<String, Object> rfMap) throws Exception {
        int rfVal = rfidcontainerDao.deleteBatchByHasRfidCode(rfMap);
        rfVal += knifeinventoryDao.getupdateDel(rfMap);
        return rfVal;
    }

    /**
     * 查询单品刀信息
     *
     * @param r
     * @return
     * @throws Exception
     */
    @Override
    public Vgettoolinformation gettoolinformation(Vgettoolinformation r) throws Exception {
        return vgettoolinformationDao.gettoolinformation(r);
    }

    @Override
    public int getDelRFIDAndKn(Map<String, Object> rfMap) throws SQLException {
        int reval = rfidcontainerDao.deleteBatchByRfidCode(rfMap);
        reval += knifeinventoryDao.getDelRFIDAndKn(rfMap);
        return reval;
    }

    /**
     * 根据刀具ID查询材料号
     *
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public Tool getToolCode(Tool t) throws Exception {
        return toolDao.getToolCode(t);
    }

    /**
     * 提交在库盘点刀具信息
     *
     * @param kn
     * @return
     * @throws Exception
     */
    @Override
    public int submitCheckToolDate(Knifeinventory kn) throws Exception {
        return knifeinventoryDao.updateNonQuery(kn);
    }

    /**
     * 记录盘点数据
     *
     * @param rfidString
     * @param count         应在库数量
     * @param stockingCount 实际在库数量
     * @param tool          刀具参数
     * @param customerID
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    private void saveStocking(String rfidString, int count, int stockingCount, Tool tool, String customerID, String gruantUserID) throws SQLException {
        // 记录盘点数据
        Stocking stocking = new Stocking();
        stocking.setStockingID(NextKeyValue.getNextkeyvalue(IConstant.STOCKING, IConstant.STOCKINGID, customerID));
        stocking.setRfidContainerID(rfidString);
        stocking.setCheckTime(new Date());
        stocking.setCheckUser(customerID);
        stocking.setLibraryCount(new BigDecimal(count));
        stocking.setRealLibraryCount(new BigDecimal(stockingCount));
        if (count != stockingCount) {
            stocking.setRemoveUser(gruantUserID);// 授权人
        }
        Stack stack = new Stack();
        stack.setLibraryCodeID(tool.getLibraryCodeID());
        List<Stack> stackList = (List<Stack>) stackDao.searchByList(stack);
        // 厂区
        stocking.setComplex(stackList.get(0).getComplex());
        // 库房号
        stocking.setDepot(stackList.get(0).getDepot());
        // 货架
        stocking.setShelf(stackList.get(0).getShelf());
        // 层
        stocking.setLayer(stackList.get(0).getLayer());
        // 货位
        stocking.setStack(stackList.get(0).getStack());
        //  批次 单价 在库金额 暂时不做
        stocking.setDelFlag(IConstant.DEL_FLAG_0);
        stocking.setCreateTime(new Date());
        stocking.setUpdateTime(new Date());
        stocking.setCreateUser(customerID);
        stocking.setUpdateUser(customerID);
        stocking.setSystemLogUser(customerID);
        stocking.setVersion(BigDecimal.ZERO);
        stockingDao.insert(stocking);
    }
}
