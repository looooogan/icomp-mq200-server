package com.icomp.common.service.impl.icomp.v01c01.s019;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c01.s019.ICOMPV01C01S019Service;
import com.icomp.common.utils.UUIDgen;
import com.icomp.dao.KnifeinventoryDao;
import com.icomp.dao.LeasertabeDao;
import com.icomp.dao.OutsidefactoryDao;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolDao;
import com.icomp.dao.ToolprocuredDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.ToolwholelifecycleDao;
import com.icomp.dao.VgettoolbindinginfoDao;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Leasertabe;
import com.icomp.entity.base.Outsidefactory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Toolwholelifecycle;
import com.icomp.entity.base.Vgettoolbindinginfo;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Transactional
public class ICOMPV01C01S019ServiceImpl extends BaseService implements ICOMPV01C01S019Service {

    private RfidcontainerDao rfidcontainerDao;
    private VgettoolbindinginfoDao vgettoolbindinginfoDao;

    public void setVgettoolbindinginfoDao(VgettoolbindinginfoDao vgettoolbindinginfoDao) {
        this.vgettoolbindinginfoDao = vgettoolbindinginfoDao;
    }

    public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
        this.rfidcontainerDao = rfidcontainerDao;
    }

    private TooltransferDao tooltransferDao;
    private LeasertabeDao leasertabeDao;

    public void setLeasertabeDao(LeasertabeDao leasertabeDao) {
        this.leasertabeDao = leasertabeDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    /* 刀具Dao */
    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    private KnifeinventoryDao knifeinventoryDao;

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    private ToolprocuredDao toolprocuredDao;

    public void setToolprocuredDao(ToolprocuredDao toolprocuredDao) {
        this.toolprocuredDao = toolprocuredDao;
    }

    private OutsidefactoryDao outsidefactoryDao;

    public void setOutsidefactoryDao(OutsidefactoryDao outsidefactoryDao) {
        this.outsidefactoryDao = outsidefactoryDao;
    }

    private ToolwholelifecycleDao toolwholelifecycleDao;

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    /**
     * 刀具状态查询
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer getToolInfo(Rfidcontainer entity) {
        Rfidcontainer rfidcontainer;
        try {
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( entity );
            if (rfidList == null || rfidList.size () == 0) {
                // 当前扫描的RFID未绑定刀具!
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.WMSG0143 );
                return rfidcontainer;
            }
            rfidcontainer = rfidList.get ( 0 );
            if (rfidcontainer.getLaserIdentificationCode () != null) {
                // 当前扫描的RFID已绑定激光码!
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.WMSG0144 );
                return rfidcontainer;
            }
            String toolID;
            // 判断当前扫描刀具是否为钻头类刀具
            if (IConstant.QUERY_TYPE_0.equals ( (rfidcontainer.getQueryType ()) )) {// 库存形式
                // 取得库存数据
                // 取得当前刀具的刀具参数信息
                Knifeinventory knifeinventory = new Knifeinventory ();
                knifeinventory.setRfidContainerID ( rfidcontainer.getRfidContainerID () );
                List<Knifeinventory> knifeinventoryList = (List<Knifeinventory>) knifeinventoryDao.searchByList ( knifeinventory );
                knifeinventory = knifeinventoryList.get ( 0 );
                toolID = knifeinventory.getToolID ();
            } else {// 流转中
                // 取得流转刀具信息
                Tooltransfer tooltransfer = new Tooltransfer ();
                tooltransfer.setRfidContainerID ( rfidcontainer.getRfidContainerID () );// 取得载体ID
                List<Tooltransfer> tooltransferList = (List<Tooltransfer>) tooltransferDao.searchByList ( tooltransfer );
                tooltransfer = tooltransferList.get ( 0 );
             /*   if (IConstant.INSTALLATION_STATE_0.equals(tooltransfer.getInstallationState())) {
                    // 当前扫描的RFID已绑定为合成刀具!
                    rfidcontainer = new Rfidcontainer();
                    rfidcontainer.setRetErrFlag(true);
                    rfidcontainer.setMessageCode(IConstant.WMSG0145);
                    return rfidcontainer;
                }*/
                toolID = tooltransfer.getToolID ();

            }
            // 取得刀具参数信息
            Tool tool = new Tool ();
            tool.setToolID ( toolID );
            List<Tool> toolList = (List<Tool>) toolDao.searchByList ( tool );
            if (toolList == null || toolList.size () <= 0) {
                //  当前刀具编码未记录!
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.WMSG0116 );
                return rfidcontainer;
            } else {
                tool = toolList.get ( 0 );
                if (!IConstant.TOOL_CONSUME_TYPE_0.equals ( tool.getToolConsumetype () )) {
                    // 只有钻头类刀具才可以打激光码!
                    rfidcontainer = new Rfidcontainer ();
                    rfidcontainer.setRetErrFlag ( true );
                    rfidcontainer.setMessageCode ( IConstant.WMSG0146 );
                    return rfidcontainer;
                }
            }
            return rfidcontainer;
        } catch (SQLException e) {
            rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setRetErrFlag ( true );
            rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            rfidcontainer.setExceMessage ( e.getMessage () );
            return rfidcontainer;
        }
    }

    /**
     * 刀具激光码保存
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Rfidcontainer saveToolInfo(Rfidcontainer entity) {
        Rfidcontainer rfidcontainer = new Rfidcontainer ();
        try {
            rfidcontainer.setRfidCode ( entity.getRfidCode () );
            List<Rfidcontainer> rfidList = (List<Rfidcontainer>) rfidcontainerDao.searchByList ( rfidcontainer );
            if (rfidList == null || rfidList.size () == 0) {
                // 当前扫描的RFID未绑定刀具!
                rfidcontainer = new Rfidcontainer ();
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.WMSG0143 );
                return rfidcontainer;
            }
            rfidcontainer = rfidList.get ( 0 );
            entity.setRfidContainerIDWhere ( rfidcontainer.getRfidContainerID () );
            entity.setVersion ( rfidcontainer.getVersion ().add ( BigDecimal.ONE ) );
            entity.setBandType ( IConstant.BAND_TYPE_1 );
            if (rfidcontainerDao.updateNonQuery ( entity ) < 1) {
                rfidcontainer.setRetErrFlag ( true );
                rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            }
            return rfidcontainer;
        } catch (SQLException e) {
            rfidcontainer.setRetErrFlag ( true );
            rfidcontainer.setMessageCode ( IConstant.EMSG0004 );
            rfidcontainer.setExceMessage ( e.getMessage () );
            return rfidcontainer;
        }
    }

    @Override
    public List<Vgettoolbindinginfo> gettoolbindinginfo(Vgettoolbindinginfo r) throws Exception {
        return (List<Vgettoolbindinginfo>) vgettoolbindinginfoDao.searchByList ( r );
    }

    @Override
    public int submitToolBindingInfo(Rfidcontainer rt, String toolCode) throws SQLException {
        try {
            if (rt.getLaserIdentificationCodeWhere () == null || rt.getLaserIdentificationCode ().equals ( rt.getLaserIdentificationCodeWhere () )) {
                //如果生成激光码或不修改激光码，那么
                //设置激光码并置空rfidCode
                rfidcontainerDao.updateNonQuery ( rt );
            } else {
                //修改激光码
                //断开新激光码对应的单品信息(激光码置空)
                Rfidcontainer entity = new Rfidcontainer ();
                //新激光码
                entity.setLaserIdentificationCodeWhere ( rt.getLaserIdentificationCode () );
                //置空
                entity.setLaserIdentificationCode ( "" );
                rfidcontainerDao.updateNonQuery ( entity );

                //新激光码替换原有激光码
                Rfidcontainer search = new Rfidcontainer ();
                //原有激光码
                search.setLaserIdentificationCodeWhere ( rt.getLaserIdentificationCodeWhere () );
                //新激光码
                search.setLaserIdentificationCode ( rt.getLaserIdentificationCode () );
                rfidcontainerDao.updateNonQuery ( search );
            }

            //更新流转表
            Tooltransfer tt = new Tooltransfer ();
            //更新条件：载体id
            tt.setRfidContainerIDWhere ( rt.getRfidContainerIDWhere () );
            //将刀具状态设置成厂外待刃磨
            tt.setToolState ( IConstant.STRING_10 );
            tt.setBusinessFlowLnkID ( IConstant.C01S019 );
            //更新者
            tt.setUpdateUser ( rt.getUpdateUser () );
            //更新时间
            tt.setUpdateTime ( new Date () );
            tooltransferDao.updateNonQuery ( tt );

            //根据刀具编码获取刀具id和修磨方式
            Tool t = new Tool ();
            t.setToolCode ( toolCode );
            List<Tool> tList = (List<Tool>) toolDao.searchByList ( t );
            //新建出厂修磨单
            Outsidefactory of = new Outsidefactory ();
            //厂外修复ID
            of.setOutsideFactoryID ( UUIDgen.getId () );
            if (tList.size () > 0) {
                t = tList.get ( 0 );
                //刀具id
                of.setToolID ( t.getToolID () );
                //出厂修复表的修复类型（0.厂外图层1.厂外复磨）
                //此处应特别注意刀具参数表中的修复类型(0:厂内修磨，1厂外修磨，2厂外涂层)
                if (IConstant.STRING_1.equals ( t.getToolGrinding () )) {
                    //厂外修磨
                    of.setGrindingType ( IConstant.STRING_1 );
                } else if (IConstant.STRING_2.equals ( t.getToolGrinding () )) {
                    //厂外涂层
                    of.setGrindingType ( IConstant.STRING_0 );
                }
            }
            //材料号
            of.setMaterialNum ( toolCode );
            //修磨数量
            of.setNumberGrinding ( IConstant.STRING_1 );
            //激光码
            of.setLaserCode ( rt.getLaserIdentificationCode () );
            //刀具类型(0.钻头1.刀片)
            of.setToolType ( IConstant.STRING_0 );
            //修复状态(0.未修复1.已修复2.已送回）
            of.setRepairState ( IConstant.STRING_0 );
            //删除区分(0有效1删除)
            of.setDelFlag ( IConstant.STRING_0 );
            //创建者
            of.setCreateUser ( rt.getUpdateUser () );
            //创建时间
            of.setCreateTime ( new Date () );
            //更新者
            of.setUpdateUser ( rt.getUpdateUser () );
            //更新时间
            of.setUpdateTime ( new Date () );
            //版本号
            of.setVersion ( BigDecimal.ONE );
            outsidefactoryDao.insert ( of );

            //查询刀具入库编码
            String knifeInventoryCode = null;
            tt = new Tooltransfer ();
            tt.setRfidContainerID ( rt.getRfidContainerIDWhere () );
            List<Tooltransfer> ttList2 = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
            if (ttList2.size () > 0) {
                knifeInventoryCode = ttList2.get ( 0 ).getKnifeInventoryCode ();
            }

            //建立生命周期
            Toolwholelifecycle twl = new Toolwholelifecycle ();
            // 刀具全生命周期id
            twl.setToolWholeLifecycleID ( UUIDgen.getId () );
            // 刀具入库编码
            if (knifeInventoryCode != null) {
                twl.setKnifeInventoryCode ( knifeInventoryCode );
            } else {
                twl.setKnifeInventoryCode ( "" );
            }
            // 流程id
            twl.setBusinessFlowLnkID ( IConstant.C01S019 );
            // 手持机id
            twl.setHandSetID ( rt.getExpandSpace1 () );
            // 刀具id
            twl.setToolID ( tList.get ( 0 ).getToolID () );
            //零部件id
            twl.setPartsID ( "" );
            //加工数量
            twl.setProcessAmount ( "0" );
            //删除区分(0有效1删除)
            twl.setDelFlag ( IConstant.DEL_FLAG_0 );
            //更新时间
            twl.setUpdateTime ( new Date () );
            //更新者
            twl.setUpdateUser ( rt.getUpdateUser () );
            //创建时间
            twl.setCreateTime ( new Date () );
            //创建者
            twl.setCreateUser ( rt.getUpdateUser () );
            //版本号
            twl.setVersion ( BigDecimal.ONE );
            toolwholelifecycleDao.insert ( twl );

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Tooltransfer> getToolInfomation(Tooltransfer tt) throws Exception {
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList ( tt );
        return reList;
    }

    @Override
    public Tool getToolCode(Tool t) throws Exception {
        Tool reEntity = new Tool ();
        List<Tool> reList = (List<Tool>) toolDao.searchByList ( t );
        if (reList.size () < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    @Override
    public Tooltransfer getToolPB(Tooltransfer tf) throws Exception {
        Tooltransfer reEntity = new Tooltransfer ();
        List<Tooltransfer> reList = (List<Tooltransfer>) tooltransferDao.searchByList ( tf );
        if (reList.size () < 1) {
            // 未找到相应数据
            reEntity.setRetErrFlag ( true );
        } else {
            reEntity = reList.get ( 0 );
        }
        return reEntity;
    }

    @Override
    public List<Rfidcontainer> getLacerCode(Rfidcontainer rfidcontainer) throws Exception {
        List<Rfidcontainer> reList = (List<Rfidcontainer>) rfidcontainerDao.searchByLikeList ( rfidcontainer );
        return reList;
    }

    @Override
    public List<Toolprocured> getProcured(Toolprocured tp) throws Exception {
        List<Toolprocured> tpList = (List<Toolprocured>) toolprocuredDao.searchByList ( tp );
        return tpList;
    }

    @Override
    public Object leasertabeInsert(Leasertabe lt) throws Exception {
        return leasertabeDao.insert ( lt );
    }

    @Override
    public String getLacerCodeState(Leasertabe leasertabe) throws Exception {
        List<Leasertabe> reVal = (List<Leasertabe>) leasertabeDao.searchByList ( leasertabe );
        if (reVal == null || reVal.size () < 1) {
            return null;
        } else {
            //激光码状态（0 激活 1未激活）取得
            return reVal.get ( 0 ).getLaserState ();
        }
    }

    @Override
    public int getLaserCodeInfo(Leasertabe entity) throws Exception {
        return leasertabeDao.searchByCount ( entity );
    }

    @Override
    public int submitOutFackterTools(Map<String, Object> params) throws SQLException {
        int reval = 0;
        //用户ID
        String userID = (String) params.get ( "userID" );
        //RFIDCodes
        List<String> rfidCodes = (List<String>) params.get ( "rfidCodes" );
        //出厂列表
        List<Outsidefactory> list = (List<Outsidefactory>) params.get ( "toolNoticeInfo" );
        //插入到厂外修复表中
        if (list != null && list.size () > 0) {
            outsidefactoryDao.insertBatchs ( list );
        }
            Map<String, Object> param = new HashedMap ();
            param.put ( "userID", userID );
            param.put ( "list", rfidCodes );
            param.put ( "ToolState", IConstant.STRING_11 );
            reval += tooltransferDao.updateToolStateBatchByRfid (param);
        if (reval > 0) {
            reval += rfidcontainerDao.deleteByRfidCodeList ( rfidCodes );
        }
        return reval;
    }


}

