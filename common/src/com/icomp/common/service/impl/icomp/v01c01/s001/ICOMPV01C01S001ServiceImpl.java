package com.icomp.common.service.impl.icomp.v01c01.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s001.ICOMPV01C01S001Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.StoragerecordDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Storagerecord;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Toolwholelifecycle;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01C01S001ServiceImpl extends BaseService implements ICOMPV01C01S001Service {
    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    /* 批次Dao */
    private ToolprocuredDao toolprocuredDao;

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    /* rfid 载体Dao */
    private RfidcontainerDao rfidcontainerDao;

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    /* 新刀具库存表 */
    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    /* 刀具流转表 */
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    /* 入库履历dao */
    private StoragerecordDao storagerecordDao;

    public void setStoragerecordDao(StoragerecordDao storagerecordDao) {
        this.storagerecordDao = storagerecordDao;
    }

    /* 生命周期dao */
    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    /**
     * 取得系统当前可选批次列表
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Toolprocured> getProcuredBatchList(Toolprocured entity) {
        List<Toolprocured> list = null;
        try {
            list = (List<Toolprocured>) toolprocuredDao.searchByList ( entity );
        } catch (SQLException e) {
            // 数据库操作异常,查询失败!
            list = new ArrayList<Toolprocured> ();
            Toolprocured vbatchlist = new Toolprocured ();
            vbatchlist.setMessageCode ( IConstant.EMSG0004 );
            vbatchlist.setRetErrFlag ( true );
            vbatchlist.setExceMessage ( e.getMessage () );
            list.add ( vbatchlist );
        }

        return list;
    }

    /**
     * 提交钻头入库信息
     *
     * @param toolList
     * @return
     * @throws Exception
     */
    public Map<String, Object> setBitInputInf(List<Map<String, Object>> toolList, Knifeinventory entity) {
        Map<String, Object> result = new HashMap<String, Object> ();
        Knifeinventory kv = null;
        List<Knifeinventory> kvList = new ArrayList<Knifeinventory> ();
        String userID = entity.getCreateUser ();
        //采购批次
        String procuredBatch = entity.getProcuredBatch ();
        String toolID = entity.getToolID ();
        Rfidcontainer rfidcontainer = null;
        List<Rfidcontainer> rfList = new ArrayList<Rfidcontainer> ();
        Toolwholelifecycle toolwholelifecycle = null;
        List<Toolwholelifecycle> twlList = new ArrayList<Toolwholelifecycle> ();
        //材料号
        String toolCode = null;
        //刀具入库编码
        try {
            for (Map<String, Object> map : toolList) {
                try {
                    Thread.sleep ( 1 );
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                String knifeInventoryCode = UUIDgen.getTimes ();
                String rfidContainerID = UUIDgen.getId ();
                //插入RFID载体表
                rfidcontainer = new Rfidcontainer ();
                //RFID载体ID
                rfidcontainer.setRfidContainerID ( rfidContainerID );
                //RFID标签ID
                rfidcontainer.setRfidCode ( map.get ( "RfidCode" ).toString () );
                //RFID重用次数
                rfidcontainer.setRfidReCount ( BigDecimal.ZERO );
                //绑定类型(0RFID 1 激光码 2 工具盘 9 其他
                rfidcontainer.setBandType ( IConstant.DEL_FLAG_0 );
                //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
                rfidcontainer.setQueryType ( IConstant.DEL_FLAG_1 );
                //删除区分(0有效1删除)
                rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
                //更新者
                rfidcontainer.setUpdateUser ( userID );
                //更新时间
                rfidcontainer.setUpdateTime ( new Date () );
                //操作人
                rfidcontainer.setSystemLogUser ( userID );
                rfList.add ( rfidcontainer );

                kv = new Knifeinventory ();
                //RFID载体ID
                kv.setRfidContainerID ( rfidContainerID );
                //刀具入库编码
                kv.setKnifeInventoryCode ( knifeInventoryCode );
                //采购批次
                kv.setProcuredBatch ( procuredBatch );
                //刀具ID
                toolID = (String) map.get ( "ToolID" );
                kv.setToolID ( toolID );
                //库存类型(0新刀1出厂回库2封存3返厂4外借5借入9其他)
                kv.setKnifeInventoryType ( IConstant.DEL_FLAG_0 );
                //库存数量(钻头数量为1，刀片为当前数量)
                kv.setKnifelnventoryNumber ( String.valueOf ( map.get ( "Unitnumber" ) ) );
                //复磨次数
                kv.setToolSharpennum ( new BigDecimal ( 0 ) );
                //复磨标准
                kv.setToolSharpenCriterion ( new BigDecimal ( 0 ) );
                //刀具长度
                kv.setToolLength ( new BigDecimal ( 0 ) );
                //可刃磨长度
                kv.setToolSharpenLength ( new BigDecimal ( 0 ) );
                //删除区分(0有效1删除)
                kv.setDelFlag ( IConstant.DEL_FLAG_0 );
                //更新时间
                kv.setUpdateTime ( new Date () );
                //更新者
                kv.setUpdateUser ( userID );
                //创建时间
                kv.setCreateTime ( new Date () );
                //创建者
                kv.setCreateUser ( userID );
                //版本号
                kv.setVersion ( BigDecimal.ONE );
                kvList.add ( kv );

                toolCode = String.valueOf ( map.get ( "MaterialNum" ) );

                toolwholelifecycle = new Toolwholelifecycle ();
                //生命周期id
                toolwholelifecycle.setToolWholeLifecycleID ( UUIDgen.getId () );
                //刀具入库编码
                toolwholelifecycle.setKnifeInventoryCode ( knifeInventoryCode );
                //流程id
                toolwholelifecycle.setBusinessFlowLnkID ( IConstant.C01S001 );
                //手持机id
                toolwholelifecycle.setHandSetID ( (String) map.get ( "HandSetID" ) );
                //刀具id
                toolwholelifecycle.setToolID ( toolID );
                //零部件id
                toolwholelifecycle.setPartsID ( "" );
                //加工数量
                toolwholelifecycle.setProcessAmount ( "0" );
                //删除区分(0有效1删除)
                toolwholelifecycle.setDelFlag ( IConstant.DEL_FLAG_0 );
                //更新时间
                toolwholelifecycle.setUpdateTime ( new Date () );
                //更新者
                toolwholelifecycle.setUpdateUser ( userID );
                //创建时间
                toolwholelifecycle.setCreateTime ( new Date () );
                //创建者
                toolwholelifecycle.setCreateUser ( userID );
                //刃磨次数
                toolwholelifecycle.setVersion ( BigDecimal.ZERO );
                twlList.add ( toolwholelifecycle );
            }
            if (rfList.size () > 0) {
                //载体Id批量插入
                rfidcontainerDao.insertBatchs ( rfList );
            }
            if (kvList.size () > 0) {
                //新刀入库批量插入
                knifeinventoryDao.batchInserts ( kvList );
            }
            if (twlList.size () > 0) {
                //生命周期批量插入
                toolwholelifecycleDao.insertBatchs ( twlList );
            }

            // 更新采购数量
            Toolprocured toolprocured = new Toolprocured ();
            toolprocured.setToolCode ( toolCode );// 材料号
            toolprocured.setToolsOrdeNO ( procuredBatch);// 批次
            List<Toolprocured> tpList = (List<Toolprocured>) toolprocuredDao.searchByList ( toolprocured );
            if (tpList.size () > 0) {
                // 获取采购但未入库的剩余刀具数量
                BigDecimal count = tpList.get ( 0 ).getProcuredCount ();

                toolprocured.setToolCodeWhere ( toolCode );
                toolprocured.setToolsOrdeNOWhere ( procuredBatch );
                // 数量相减
                toolprocured.setProcuredCount ( count.subtract ( new BigDecimal ( toolList.size () ) ) );
                // 是否入库的状态变为是
                toolprocured.setProcuredInto ( IConstant.STRING_0 );
                // 如果采购数量为0，将该采购单逻辑删除
                if (count.subtract ( new BigDecimal ( toolList.size () ) ).intValue () == 0) {
                    toolprocured.setDelFlag ( IConstant.DEL_FLAG_1 );
                }
                // 更新者
                toolprocured.setUpdateUser ( userID );
                // 更新时间
                toolprocured.setUpdateTime ( new Date () );
                toolprocuredDao.updateNonQuery ( toolprocured );
            }

            // 新建入库履历
            Storagerecord storagerecord = new Storagerecord ();
            // 入库履历id
            storagerecord.setStorageID ( UUIDgen.getId () );
            // 刀具id
            storagerecord.setToolID ( toolID );
            // 材料号
            storagerecord.setToolCode ( toolCode );
            // 刀具类型
            storagerecord.setStorageType ( String.valueOf ( toolCode.charAt ( 0 ) ) );
            // 批次(订单号)
            storagerecord.setToolsOrdeNO ( procuredBatch );
            // 库存状态(新刀)
            storagerecord.setStorageState ( IConstant.STRING_0 );
            // 刀具入库编码
            storagerecord.setKnifeInventoryCode ( "-" );
            // 入库数量
            storagerecord.setStorageNum ( new BigDecimal ( toolList.size () ) );
            storagerecord.setDelFlag ( IConstant.STRING_0 );
            storagerecord.setCreateTime ( new Date () );
            storagerecord.setCreateUser ( userID );
            storagerecord.setUpdateTime ( new Date () );
            storagerecord.setUpdateUser ( userID );
            storagerecordDao.insert ( storagerecord );

            result.put ( "status", IConstant.RESULT_CODE_0 );
            // 入库成功！
            result.put ( "messagetext", IConstant.WMSG0227 );
            return result;
        } catch (SQLException e) {
            e.printStackTrace ();
            result.put ( "status", IConstant.RESULT_CODE_2 );
            // 数据库操作异常,查询失败!
            result.put ( "messagetext", IConstant.WMSG0228 );
            return result;
        }
    }

    /**
     * 提交刀片入库信息
     *
     * @param
     * @return
     * @throws Exception
     */
    public Map<String, Object> setToolInputInf(Knifeinventory entity, String toolCode) {
        Map<String, Object> result = new HashMap<String, Object> ();
        Knifeinventory knifeinventory = new Knifeinventory ();
        String userID = entity.getCreateUser ();
        //采购批次
        String procuredBatch = entity.getProcuredBatch ();
        try {
            //判断入库的刀片是否有对应的库位标签
            //刀具ID
            knifeinventory.setToolID ( entity.getToolID () );
            //删除区分(0有效1删除)
            knifeinventory.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Knifeinventory> kList = (List<Knifeinventory>) knifeinventoryDao.searchByList ( knifeinventory );
            if (kList.size () <= 0) {
                //没有找到对应的库位标签，不能入库
                result.put ( "status", IConstant.RESULT_CODE_2 );
                result.put ( "messagetext", "入库的刀具没有对应的标签，请先进行库位标签初始化" );
                return result;
            }
            //获取该刀具原有的在库数量
            String number = kList.get ( 0 ).getKnifelnventoryNumber ();
            //获取载体id作为更新条件
            String rfidcontainerId = kList.get ( 0 ).getRfidContainerID ();
            knifeinventory.setRfidContainerIDWhere ( rfidcontainerId );
            //采购批次
            knifeinventory.setProcuredBatch ( procuredBatch );
            //库存数量
            knifeinventory.setKnifelnventoryNumber ( (Integer.parseInt ( entity.getKnifelnventoryNumber () ) + Integer.parseInt ( number )) + "" );
            //更新时间
            knifeinventory.setUpdateTime ( new Date () );
            //更新者
            knifeinventory.setUpdateUser ( userID );

            // 更新新刀库存表表
            knifeinventoryDao.updateNonQuery ( knifeinventory );

            // 更新采购数量
            Toolprocured toolprocured = new Toolprocured ();
            toolprocured.setToolCode ( toolCode );// 材料号
            toolprocured.setToolsOrdeNO ( procuredBatch);// 批次
            List<Toolprocured> tpList = (List<Toolprocured>) toolprocuredDao.searchByList ( toolprocured );
            if (tpList.size () > 0) {
                // 获取采购但未入库的剩余刀具数量
                BigDecimal count = tpList.get ( 0 ).getProcuredCount ();

                toolprocured.setToolCodeWhere ( toolCode );
                toolprocured.setToolsOrdeNOWhere ( procuredBatch );
                // 数量相减
                toolprocured.setProcuredCount ( count.subtract ( new BigDecimal ( entity.getKnifelnventoryNumber () ) ) );
                // 是否入库的状态变为是
                toolprocured.setProcuredInto ( IConstant.STRING_0 );
                // 如果采购数量为0，将该采购单逻辑删除
                if (count.subtract ( new BigDecimal ( entity.getKnifelnventoryNumber () ) ).intValue () == 0) {
                    toolprocured.setDelFlag ( IConstant.DEL_FLAG_1 );
                }
                // 更新者
                toolprocured.setUpdateUser ( userID );
                // 更新时间
                toolprocured.setUpdateTime ( new Date () );
                toolprocuredDao.updateNonQuery ( toolprocured );
            }

            // 新建入库履历
            Storagerecord storagerecord = new Storagerecord ();
            // 入库履历id
            storagerecord.setStorageID ( UUIDgen.getId () );
            // 刀具id
            storagerecord.setToolID ( entity.getToolID () );
            // 材料号
            storagerecord.setToolCode ( toolCode );
            // 刀具类型
            storagerecord.setStorageType ( String.valueOf ( toolCode.charAt ( 0 ) ) );
            // 批次(订单号)
            storagerecord.setToolsOrdeNO ( procuredBatch );
            // 库存状态(新刀)
            storagerecord.setStorageState ( IConstant.STRING_0 );
            // 刀具入库编码
            storagerecord.setKnifeInventoryCode ( kList.get ( 0 ).getKnifeInventoryCode () );
            // 入库数量
            storagerecord.setStorageNum ( new BigDecimal ( entity.getKnifelnventoryNumber () ) );
            storagerecord.setDelFlag ( IConstant.STRING_0 );
            storagerecord.setCreateTime ( new Date () );
            storagerecord.setCreateUser ( userID );
            storagerecord.setUpdateTime ( new Date () );
            storagerecord.setUpdateUser ( userID );
            storagerecordDao.insert ( storagerecord );

            result.put ( "status", IConstant.RESULT_CODE_0 );
            // 入库成功！
            result.put ( "messagetext", IConstant.WMSG0227 );
            return result;
        } catch (SQLException e) {
            e.printStackTrace ();
            result.put ( "status", IConstant.RESULT_CODE_2 );
            // 数据库操作异常,查询失败!
            result.put ( "messagetext", IConstant.WMSG0228 );
            return result;
        }
    }

    /**
     * 取得钻头(刀片)入库的信息
     *
     * @param entity
     * @return
     */
    public Rfidcontainer getBitInputInf(Rfidcontainer entity) {
        try {
            Rfidcontainer entity1 = new Rfidcontainer ();
            entity1.setRfidContainerID ( entity.getRfidContainerID () );
            entity1.setDelFlag ( IConstant.DEL_FLAG_0 );
            List<Rfidcontainer> list = (List<Rfidcontainer>) rfidcontainerDao.searchByList2 ( entity1 );
            if (list == null || list.size () <= 0) {
                // 您所查询的信息不存在!
                Rfidcontainer rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setMessageCode ( IConstant.WMSG0122 );
                rfidcontainer.setRetErrFlag ( true );
                return rfidcontainer;
            } else {
                return list.get ( 0 );
            }

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!

            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            e.printStackTrace ();
            rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            rfidcontainer.setRetErrFlag ( true );
            rfidcontainer.setExceMessage ( e.getMessage () );
            return rfidcontainer;
        }
    }

    /**
     * 取得RFID的信息
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer getRfidExist(Rfidcontainer entity) {
        try {
            List<Rfidcontainer> list = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
            if (list == null || list.size () <= 0) {
                // 您所查询的RFID类型不存在!
                Rfidcontainer rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setMessageCode ( IConstant.WMSG0122 );
                rfidcontainer.setRetErrFlag ( true );
                return rfidcontainer;
            } else {
                return list.get ( 0 );
            }

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            rfidcontainer.setRetErrFlag ( true );
            rfidcontainer.setExceMessage ( e.getMessage () );
            return rfidcontainer;
        }
    }

    /**
     * 查询钻头(刀片)入库的信息
     *
     * @param entity
     * @return
     */
    public Tool searchBitInputInf(Tool entity) {
        try {
            List<Tool> list = toolDao.searchBitInputInf ( entity );
            if (list == null || list.size () <= 0) {
                // 您所查询的信息不存在!
                Tool tool = new Tool ();
                tool.setMessageCode ( IConstant.WMSG0122 );
                tool.setRetErrFlag ( true );
                return tool;
            } else {
                return list.get ( 0 );
            }

        } catch (SQLException e) {
            // 数据库操作异常，查询失败!
            e.printStackTrace ();
            Tool tool = new Tool ();
            tool.setMessageCode ( IConstant.EMSG0004 );
            tool.setRetErrFlag ( true );
            tool.setExceMessage ( e.getMessage () );
            return tool;
        }
    }

    @Override
    public List<Knifeinventory> getKnifeinventoryInfo(Knifeinventory ki) throws Exception {
        List<Knifeinventory> kiList = (List<Knifeinventory>) knifeinventoryDao.searchByList ( ki );
        return kiList;
    }

    @Override
    public List<Tooltransfer> getTooltransferInfo(Tooltransfer tt) throws Exception {
        List<Tooltransfer> ttList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
        return ttList;
    }

    @Override
    public List<Tool> getToolInfo(Tool tool) throws Exception {
        List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
        return toolList;
    }

}
