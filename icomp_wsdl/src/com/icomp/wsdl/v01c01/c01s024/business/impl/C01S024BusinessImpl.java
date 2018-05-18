package com.icomp.wsdl.v01c01.c01s024.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s024.ICOMPV01C01S024Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Noticeequipment;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisparameters;
import com.icomp.entity.base.Vgetcontainercarrierinfo;
import com.icomp.entity.base.Vgetcustomermsg;
import com.icomp.entity.base.Vgetequipmentinfo;
import com.icomp.entity.base.Vgetinventorymsg;
import com.icomp.entity.base.Vgetknifeinventoryinfo;
import com.icomp.entity.base.Vgetsynthesisexperience;
import com.icomp.entity.base.Vgetsynthsisinfo;
import com.icomp.entity.base.Vgetsynthsistooltransferinfo;
import com.icomp.entity.base.Vgettoolinformation;
import com.icomp.wsdl.v01c01.c01s024.business.C01S024Business;
import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Request;
import com.icomp.wsdl.v01c01.c01s024.endpoint.C01S024Respons;
import com.icomp.wsdl.v01c01.c01s024.endpoint.SynthesisHistory;
import com.icomp.wsdl.v01c01.c01s024.endpoint.TypeEntity;

import org.apache.cxf.common.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 刀具管理-刀具状态查询-Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S024BusinessImpl
 * @date 2014-9-23 下午04:29:02
 */
public class C01S024BusinessImpl implements C01S024Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S024Service iCOMPV01C01S024Service;

    public void setiCOMPV01C01S024Service(ICOMPV01C01S024Service iCOMPV01C01S024Service) {
        this.iCOMPV01C01S024Service = iCOMPV01C01S024Service;
    }

    /**
     * 取得要查询的信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C01S024Respons getInformation(C01S024Request request) throws Exception {
        C01S024Respons respons = new C01S024Respons ();
        List<TypeEntity> reLists = new ArrayList<TypeEntity> ();
        TypeEntity reEntitys = null;
        TypeEntity reEntity = null;
        TypeEntity reEntit = null;
        TypeEntity reEnti = null;
        TypeEntity reEnt = null;
        TypeEntity reEn = null;
        TypeEntity reE = null;
        TypeEntity re = null;
        //2017/09/14 王冉 追加↓↓↓　dazhong@YMSC
        TypeEntity dpCode = null;
        TypeEntity xmSum = null;
        TypeEntity pSum = null;
        //2017/09/14 王冉 追加↑↑↑　dazhong@YMSC
        SimpleDateFormat time = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );

        // 参数验证
        if (StringUtils.isEmpty ( request.getRfidCode () )) {
            throw new BusinessException ( IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH );
        }
        Rfidcontainer entity = new Rfidcontainer ();
        // RFID标签
        entity.setRfidCode ( request.getRfidCode () );
        // 删除区分
        entity.setDelFlag ( IConstant.DEL_FLAG_0 );
        Rfidcontainer reVal = service.getRfidContainerByRfidCode ( entity );
        if (null == reVal) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "当前标签未初始化" );
            return respons;
        }
        String rfidConner = reVal.getRfidContainerID ();
        String queryType = reVal.getQueryType ();

        //单品刀
        if (IConstant.STRING_1.equals ( queryType )) {
            Vgettoolinformation vv = new Vgettoolinformation ();
            vv.setRfidContainerID ( rfidConner );
            Vgettoolinformation v = iCOMPV01C01S024Service.gettoolinformation ( vv );
            if (null != v) {
                //旧刀
                reEntitys = new TypeEntity ();
                reEntitys.setTypeName ( "单品ID" );
                reEntitys.setTypeCount ( v.getKnifeInventoryCode () );
                reLists.add ( reEntitys );
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "材料号" );
                reEntity.setTypeCount ( v.getToolCode () );
                reLists.add ( reEntity );
                reEntit = new TypeEntity ();
                Synthesisparameters sp = new Synthesisparameters ();
                if (v.getToolCode () != null) {
                    sp.setSynthesisParametersCode ( v.getToolCode () );
                    List<Synthesisparameters> list = iCOMPV01C01S024Service.getSynthsisTools ( sp );
                    if (list != null) {
                        for (Synthesisparameters spt : list) {
                            reEntity = new TypeEntity ();
                            reEntity.setTypeName ( "合成刀编码" );
                            reEntity.setTypeCount ( spt.getSynthesisParametersCode ());
                            reLists.add ( reEntity );
                        }
                    }
                }
                String toolState = v.getToolState ();
                reEntit.setTypeName ( "刀具状态" );
                if (IConstant.STRING_0.equals ( toolState )) {
                    reEntit.setTypeCount ( "断刀" );
                } else if (IConstant.STRING_1.equals ( toolState )) {
                    reEntit.setTypeCount ( "丢刀" );
                } else if (IConstant.STRING_2.equals ( toolState )) {
                    reEntit.setTypeCount ( "不合格" );
                } else if (IConstant.STRING_3.equals ( toolState )) {
                    reEntit.setTypeCount ( "待分拣" );
                } else if (IConstant.STRING_4.equals ( toolState )) {
                    reEntit.setTypeCount ( "待换装" );
                } else if (IConstant.STRING_5.equals ( toolState )) {
                    reEntit.setTypeCount ( "到寿" );
                } else if (IConstant.STRING_6.equals ( toolState )) {
                    reEntit.setTypeCount ( "厂内待刃磨" );
                } else if (IConstant.STRING_7.equals ( toolState )) {
                    reEntit.setTypeCount ( "厂外待刃磨" );
                } else if (IConstant.STRING_8.equals ( toolState )) {
                    reEntit.setTypeCount ( "刃磨完毕" );
                } else if (IConstant.STRING_9.equals ( toolState )) {
                    reEntit.setTypeCount ( "其他" );
                } else if (IConstant.STRING_10.equals ( toolState )) {
                    reEntit.setTypeCount ( "已出厂修磨" );
                } else if (IConstant.STRING_11.equals ( toolState )) {
                    reEntit.setTypeCount ( "厂外待涂层" );
                } else if (IConstant.STRING_12.equals ( toolState )) {
                    reEntit.setTypeCount ( "出库报废" );
                }
                reLists.add ( reEntit );
                reEnti = new TypeEntity ();
                reEnti.setTypeName ( "加工数量" );
                if (v.getProcessAmount () == null) {
                    reEnti.setTypeCount ( IConstant.STRING_0 );
                } else {
                    reEnti.setTypeCount ( String.valueOf ( v.getProcessAmount () ) );
                }
                reLists.add ( reEnti );
                reEnt = new TypeEntity ();
                reEnt.setTypeName ( "刃磨次数" );
                if (v.getUsageCounter () == null) {
                    reEnt.setTypeCount ( IConstant.STRING_0 );
                } else {
                    reEnt.setTypeCount ( String.valueOf ( v.getUsageCounter () ) );
                }
                reLists.add ( reEnt );

                reLists.add ( reToName ( v.getBusinessFlowLnkID () ) );
                reE = new TypeEntity ();
                reE.setTypeName ( "最后操作时间" );
                reE.setTypeCount ( time.format ( v.getUpdateTime () ) );
                reLists.add ( reE );
                re = new TypeEntity ();
                re.setTypeName ( "最后操作人" );
                re.setTypeCount ( v.getUpdateUser () );
                reLists.add ( re );
            } else {
                //新刀
                Vgetknifeinventoryinfo vvv = new Vgetknifeinventoryinfo ();
                vvv.setRfidContainerID ( rfidConner );
                Vgetknifeinventoryinfo kentity = iCOMPV01C01S024Service.getKnifeInfo ( vvv );
                if (kentity != null && kentity.getRfidContainerID () != null) {
                    reEntitys = new TypeEntity ();
                    reEntitys.setTypeName ( "单品ID" );
                    reEntitys.setTypeCount ( kentity.getKnifeInventoryCode () );
                    reLists.add ( reEntitys );
                    reEntity = new TypeEntity ();
                    reEntity.setTypeName ( "材料号" );
                    reEntity.setTypeCount ( kentity.getToolCode () );
                    reLists.add ( reEntity );
                    reEntit = new TypeEntity ();
                    reEntit.setTypeName ( "刀具状态" );
                    reEntit.setTypeCount ( "库存新刀" );
                    reLists.add ( reEntit );
                    reEnti = new TypeEntity ();
                    reEnti.setTypeName ( "加工数量" );
                    reEnti.setTypeCount ( String.valueOf ( 0 ) );
                    reLists.add ( reEnti );
                    reEnt = new TypeEntity ();
                    reEnt.setTypeName ( "刃磨次数" );
                    reEnt.setTypeCount ( String.valueOf ( 0 ) );
                    reLists.add ( reEnt );
                    reEn = new TypeEntity ();
                    reEn.setTypeName ( "最后业务流程" );
                    reEn.setTypeCount ( "库存新刀" );
                    reLists.add ( reEn );
                    reE = new TypeEntity ();
                    reE.setTypeName ( "最后操作时间" );
                    reE.setTypeCount ( time.format ( kentity.getUpdateTime () ) );
                    reLists.add ( reE );
                    re = new TypeEntity ();
                    re.setTypeName ( "最后操作人" );
                    re.setTypeCount ( kentity.getUpdateUser () );
                    reLists.add ( re );
                }
            }
        } else if (IConstant.STRING_0.equals ( queryType )) {
            //库位标签
            Vgetinventorymsg vv = new Vgetinventorymsg ();
            vv.setRfidContainerID ( rfidConner );
            Vgetinventorymsg v = iCOMPV01C01S024Service.getInventoryMsg ( vv );
            reEntitys = new TypeEntity ();
            reEntitys.setTypeName ( "材料号" );
            reEntitys.setTypeCount ( v.getToolCode () );
            reLists.add ( reEntitys );
            //根据材料号获取数量
            Vgetinventorymsg msg = new Vgetinventorymsg ();
            msg.setToolCode ( v.getToolCode () );
            List<Vgetinventorymsg> msgList = iCOMPV01C01S024Service.getNumber ( msg );
            if (msgList.size () <= 0) {
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "数量" );
                reEntity.setTypeCount ( IConstant.STRING_0 );
                reLists.add ( reEntity );
            } else {
                //总数量
                BigDecimal count = BigDecimal.ZERO;
                for (Vgetinventorymsg vgetinventorymsg : msgList) {
                    count = count.add ( vgetinventorymsg.getKnifelnventoryNumber () );
                }
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "数量" );
                reEntity.setTypeCount ( String.valueOf ( count ) );
                reLists.add ( reEntity );
            }
            reEntit = new TypeEntity ();
            reEntit.setTypeName ( "刀具名称" );
            reEntit.setTypeCount ( v.getToolName () );
            reLists.add ( reEntit );
            reEnti = new TypeEntity ();
            reEnti.setTypeName ( "规格型号" );
            reEnti.setTypeCount ( v.getToolSpecifications () );
            reLists.add ( reEnti );
        } else if (IConstant.STRING_3.equals ( queryType )) {
            //员工卡
            Vgetcustomermsg vv = new Vgetcustomermsg ();
            vv.setRfidContainerID ( rfidConner );
            Vgetcustomermsg v = iCOMPV01C01S024Service.getUserInfo ( vv );

            if (v == null) {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "未找到查询信息" );
                return respons;
            }
            reEntitys = new TypeEntity ();
            reEntitys.setTypeName ( "员工卡号" );
            reEntitys.setTypeCount ( v.getEmployeeCard () );
            reLists.add ( reEntitys );
            reEntit = new TypeEntity ();
            reEntit.setTypeName ( "姓名" );
            reEntit.setTypeCount ( v.getUserName () );
            reLists.add ( reEntit );
            reEntit = new TypeEntity ();
            reEntit.setTypeName ( "部门" );
            reEntit.setTypeCount ( v.getDepartmentName () );
            reLists.add ( reEntit );
            reEntit = new TypeEntity ();
            reEntit.setTypeName ( "职务名称" );
            reEntit.setTypeCount ( v.getPositionName () );
            reLists.add ( reEntit );
            respons.setCon ( reLists );
        } else if (IConstant.STRING_2.equals ( queryType )) {
            //合成刀
            Vgetsynthsisinfo vv = new Vgetsynthsisinfo ();
            vv.setRfid ( rfidConner );
            Vgetsynthsisinfo v = iCOMPV01C01S024Service.getsynthsisinfo ( vv );
            if (null == v) {

                //没有加工信息,先查找流转信息
                Vgetsynthsistooltransferinfo vtt = new Vgetsynthsistooltransferinfo ();
                vtt.setRfid ( rfidConner );
                List<Vgetsynthsistooltransferinfo> vttList = iCOMPV01C01S024Service.getSynthsisTooltransferInfo ( vtt );
                if (vttList.size () <= 0) {
                    respons.setStateCode ( IConstant.STRING_1 );
                    respons.setStateMsg ( "查询不到该合成刀的流转信息" );
                    return respons;
                } else {
                    Vgetsynthsistooltransferinfo vttEntity = vttList.get ( 0 );
                    reEntitys = new TypeEntity ();
                    reEntitys.setTypeName ( "合成刀具编码" );
                    reEntitys.setTypeCount ( vttEntity.getSynthesisParametersCode () );
                    reLists.add ( reEntitys );
                    reEntity = new TypeEntity ();
                    reEntity.setTypeName ( "合成刀具编号" );
                    reEntity.setTypeCount ( vttEntity.getSynthesisParametersID () );

                    //2017/09/14 王冉 追加↓↓↓　dazhong@YMSC
                    Synthesisparameters sp = new Synthesisparameters();
                    sp.setSynthesisParametersCode(vttEntity.getSynthesisParametersCode ());
                    sp.setDelFlag("0");
                    List<Synthesisparameters> list = iCOMPV01C01S024Service.getSynthsisTools(sp);


                    // 刀具为一体刀的场合
                    if("4".equals(list.get(0).getCreateType())){
                        // 查询载体
                        Rfidcontainer rfe = new Rfidcontainer();
                        rfe.setRfidCode(request.getRfidCode());
                        rfe.setDelFlag(IConstant.DEL_FLAG_0);
                        Rfidcontainer rf = service.getRfidContainerByRfidCode(rfe);
                        dpCode = new TypeEntity ();
                        dpCode.setTypeName ( "单品编码" );
                        dpCode.setTypeCount ( rf.getLaserIdentificationCode() );
                        reLists.add ( dpCode );

                        xmSum = new TypeEntity ();
                        xmSum.setTypeName ( "修磨次数" );
                        xmSum.setTypeCount ( vttEntity.getUsageCounter() );
                        reLists.add ( xmSum );
                    }
                    //2017/09/14 王冉 追加↑↑↑　dazhong@YMSC

                    reLists.add ( reEntity );
                    reEntit = new TypeEntity ();
                    reEntit.setTypeName ( "当前状态" );
                    String businessFlow = vttEntity.getBusinessFlowLnkID ();
                    if (IConstant.C03S001.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C03S001_TEXT );
                    } else if (IConstant.C01S010.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S010_TEXT );
                    } else if (IConstant.C01S006.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S006_TEXT );
                    } else if (IConstant.C01S007.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S007_TEXT );
                    }
                    //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
                    else if (IConstant.C01S003.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S003_TEXT );
                    } else if (IConstant.C01S004.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S004_TEXT );
                    } else if (IConstant.C01S011.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S011_TEXT );
                    } else if (IConstant.C01S013.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S013_TEXT );
                    } else if (IConstant.C01S014.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S014_TEXT );
                    } else if (IConstant.C01S018.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S018_TEXT );
                    } else if (IConstant.C01S027.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S027_TEXT );
                    } else if (IConstant.C01S016.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S016_TEXT );
                    } else if (IConstant.C01S005.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S005_TEXT );
                    } else if (IConstant.C01S020.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S020_TEXT );
                    } else if (IConstant.C01S019.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S019_TEXT );
                    } else if (IConstant.C01S006.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S006_TEXT );
                    }else if (IConstant.C01S023.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S023_TEXT );
                    } else if (IConstant.C01S017.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S017_TEXT );
                    }else if (IConstant.C01S008.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S008_TEXT );
                    }else if (IConstant.C01S009.equals ( businessFlow )) {
                        reEntit.setTypeCount ( IConstant.C01S009_TEXT );
                    }
                    //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

                    reLists.add ( reEntit );
                    reEnti = new TypeEntity ();
                    if (null == vttEntity.getProcessAmount ()) {
                        reEnti.setTypeName ( "最后一次加工数量" );
                        reEnti.setTypeCount ( String.valueOf ( 0 ) );
                        reLists.add ( reEnti );
                    } else {
                        reEnti.setTypeName ( "最后一次加工数量" );
                        reEnti.setTypeCount ( String.valueOf ( vttEntity.getProcessAmount2 () ) );
                        reLists.add ( reEnti );
                    }
                    pSum = new TypeEntity ();
                    pSum.setTypeName ( "累计加工数量" );
                    if (null == vttEntity.getProcessAmount ()) {
                        pSum.setTypeCount ( String.valueOf ( 0 ) );
                    } else {
                        pSum.setTypeCount ( String.valueOf ( vttEntity.getProcessAmount () ) );
                    }
                    reLists.add ( pSum );
                    reEnt = new TypeEntity ();
                    reEnt.setTypeName ( "最后业务流程" );
                    reEnt.setTypeCount ( reEntit.getTypeCount () );
                    reLists.add ( reEnt );
                    reEn = new TypeEntity ();
                    reEn.setTypeName ( "最后操作时间" );
                    reEn.setTypeCount ( time.format ( vttEntity.getUpdateTime () ) );
                    reLists.add ( reEn );
                    reE = new TypeEntity ();
                    reE.setTypeName ( "最后操作人" );
                    reE.setTypeCount ( vttEntity.getUpdateUser () );
                    reLists.add ( reE );
                }
            } else {
                reEntitys = new TypeEntity ();
                reEntitys.setTypeName ( "合成刀具编码" );
                reEntitys.setTypeCount ( v.getSynthesisParametersCode () );
                reLists.add ( reEntitys );
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "合成刀具编号" );
                reEntity.setTypeCount ( v.getSynthesisParametersID () );
                reLists.add ( reEntity );
                reEntit = new TypeEntity ();


                //2017/09/14 王冉 追加↓↓↓　dazhong@YMSC
                Synthesisparameters sp = new Synthesisparameters();
                sp.setSynthesisParametersCode(v.getSynthesisParametersCode ());
                sp.setDelFlag("0");
                List<Synthesisparameters> list = (List<Synthesisparameters>) iCOMPV01C01S024Service.getSynthsisTools(sp);

                //没有加工信息,先查找流转信息
                Vgetsynthsistooltransferinfo vtt = new Vgetsynthsistooltransferinfo ();
                vtt.setRfid ( rfidConner );
                List<Vgetsynthsistooltransferinfo> vttList = iCOMPV01C01S024Service.getSynthsisTooltransferInfo ( vtt );

                // 刀具为一体刀的场合
                if("4".equals(list.get(0).getCreateType())){

                    // 查询载体
                    Rfidcontainer rfe = new Rfidcontainer();
                    rfe.setRfidCode(request.getRfidCode());
                    rfe.setDelFlag(IConstant.DEL_FLAG_0);
                    Rfidcontainer rf = service.getRfidContainerByRfidCode(rfe);
                    dpCode = new TypeEntity ();
                    dpCode.setTypeName ( "单品编码" );
                    dpCode.setTypeCount ( rf.getLaserIdentificationCode() );
                    reLists.add ( dpCode );

                    xmSum = new TypeEntity ();
                    xmSum.setTypeName ( "修磨次数" );
                    xmSum.setTypeCount ( vttList.get(0).getUsageCounter() );
                    reLists.add ( xmSum );
                }

                //2017/09/14 王冉 追加↑↑↑　dazhong@YMSC

                reLists.add ( reEntit );
                reEnti = new TypeEntity ();
                //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                reEnti.setTypeName ( "最后一次加工数量" );
                //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                if (v.getProcessAmount () != null) {
                    reEnti.setTypeCount ( v.getProcessAmount ().toString () );
                } else {
                    reEnti.setTypeCount ( IConstant.DEL_FLAG_0 );
                }
                reLists.add ( reEnti );
                pSum = new TypeEntity ();
                pSum.setTypeName ( "累计加工数量" );
                if (null == vttList.get(0).getProcessAmount ()) {
                    pSum.setTypeCount ( String.valueOf ( 0 ) );
                } else {
                    pSum.setTypeCount ( String.valueOf ( vttList.get(0).getProcessAmount () ) );
                }
                reLists.add ( pSum );
                String businessFlowLnkID = v.getBusinessFlowLnkID ();

                reEntit.setTypeName ( "当前状态" );
                if (IConstant.STRING_0.equals ( v.getLoadState () )) {
                    //设备安上
                    reEntit.setTypeCount ( "设备装入" );
                } else if (IConstant.STRING_1.equals ( v.getLoadState () )) {
                    //设备卸下
                    reEntit.setTypeCount ( "设备卸下" );
                    //2017/08/14 王冉 变更↓↓↓　dazhong@YMSC
                } else if (IConstant.STRING_9.equals ( v.getLoadState () )) {
                    //2017/08/14 王冉 变更↑↑↑　dazhong@YMSC
                    //刀具换装
                    reEntit.setTypeCount ( "刀具换装" );
                }
                //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
                else if (IConstant.STRING_8.equals ( v.getLoadState () )) {
                    //刀具修磨
                    reEntit.setTypeCount ( "厂外修磨已回厂" );
                }
                else if (IConstant.STRING_7.equals ( v.getLoadState () )) {
                    //刀具修磨
                    reEntit.setTypeCount ( "厂外修磨" );
                }
                else if (IConstant.STRING_6.equals ( v.getLoadState () )) {
                    //刀具拆分
                    reEntit.setTypeCount ( "刀具拆分" );
                }
                else if (IConstant.STRING_5.equals ( v.getLoadState () )) {
                    //刀具组装
                    reEntit.setTypeCount ( "刀具组装" );
                }
                else if (IConstant.STRING_4.equals ( v.getLoadState () )) {
                    //厂内修磨
                    reEntit.setTypeCount ( "厂内修磨" );
                }
                else if (IConstant.STRING_10.equals ( v.getLoadState () )) {
                    //厂外待修磨
                    reEntit.setTypeCount ( "厂外待修磨" );
                }else if (IConstant.STRING_11.equals ( v.getLoadState () )) {
                    //厂外待修磨
                    reEntit.setTypeCount ( "报废" );
                }else if (IConstant.STRING_12.equals ( v.getLoadState () )) {
                    //厂外待修磨
                    reEntit.setTypeCount ( "单品绑定" );
                }
                //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
                //最后流程
                reLists.add ( reToName ( v.getBusinessFlowLnkID () ) );
                reEn = new TypeEntity ();
                reEn.setTypeName ( "最后操作时间" );
                reEn.setTypeCount ( time.format ( v.getUpdateTime () ) );
                reLists.add ( reEn );
                reE = new TypeEntity ();
                reE.setTypeName ( "最后操作人" );
                reE.setTypeCount ( v.getUpdateUser () );
                reLists.add ( reE );
            }
        } else if (IConstant.STRING_4.equals ( queryType )) {
            //设备
            Vgetequipmentinfo vv = new Vgetequipmentinfo ();
            vv.setRfidContainerID ( rfidConner );
            List<Vgetequipmentinfo> v = iCOMPV01C01S024Service.getequipmentinfo ( vv );
            if (v.size () <= 0) {
                Noticeequipment ne = new Noticeequipment ();
                ne.setRfidContainerID ( rfidConner );
                ne.setDelFlag ( IConstant.DEL_FLAG_0 );
                Noticeequipment nentity = iCOMPV01C01S024Service.getNoticeEqu ( ne );
                if (null == nentity) {
                    respons.setStateCode ( IConstant.DEL_FLAG_1 );
                    respons.setStateMsg ( "未找到查询信息" );
                    return respons;
                }
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "设备编码" );
                reEntity.setTypeCount ( nentity.getEquipmentCode () );
                reLists.add ( reEntity );
                reEntit = new TypeEntity ();
                reEntit.setTypeName ( "设备名称" );
                reEntit.setTypeCount ( nentity.getEquipmentName () );
                reLists.add ( reEntit );
            } else {
                reEntitys = new TypeEntity ();
                List<Vgetequipmentinfo> list = iCOMPV01C01S024Service.getequipmentinfolist ( vv );
                reEntitys.setTypeName ( "轴数" );
                reEntitys.setTypeCount ( String.valueOf ( list.size () ) );
                reLists.add ( reEntitys );
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "设备编码" );
                reEntity.setTypeCount ( v.get ( 0 ).getEquipmentCode () );
                reLists.add ( reEntity );
                reEntit = new TypeEntity ();
                reEntit.setTypeName ( "设备名称" );
                reEntit.setTypeCount ( v.get ( 0 ).getEquipmentName () );
                reLists.add ( reEntit );
            }
        } else if (IConstant.STRING_5.equals ( queryType )) {
            //容器
            Containercarrier cc = new Containercarrier ();
            cc.setRfidContainerID ( rfidConner );
            cc.setDelFlag ( IConstant.DEL_FLAG_0 );
            Containercarrier centity = iCOMPV01C01S024Service.getContainerName ( cc );
            reEntitys = new TypeEntity ();
            reEntitys.setTypeName ( "容器名称" );
            reEntitys.setTypeCount ( centity.getContainerCarrierName () );
            reLists.add ( reEntitys );
            reEntitys = new TypeEntity ();
            reEntitys.setTypeName ( "容器类型" );
            if (IConstant.STRING_0.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "备用刀" );
            } else if (IConstant.STRING_1.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "一次性报废" );
            } else if (IConstant.STRING_2.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "待分拣容器" );
            } else if (IConstant.STRING_3.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "厂内待刃磨" );
            } else if (IConstant.STRING_4.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "厂外待刃磨" );
            } else if (IConstant.STRING_5.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "刃磨完毕" );
            } else if (IConstant.STRING_6.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "刃磨报废" );
            } else if (IConstant.STRING_7.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "待涂层" );
            } else if (IConstant.STRING_8.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "库房报废" );
            } else if (IConstant.STRING_9.equals ( centity.getContainerCarrierType () )) {
                reEntitys.setTypeCount ( "其他" );
            }
            reLists.add ( reEntitys );
            Vgetcontainercarrierinfo vv = new Vgetcontainercarrierinfo ();
            vv.setRfidContainerID ( rfidConner );
            List<Vgetcontainercarrierinfo> clist = iCOMPV01C01S024Service.getcontainercarrierinfolist1 ( vv );
            if (clist.size () < 1) {
                respons.setCon ( reLists );
                respons.setStateCode ( IConstant.STRING_0 );
                return respons;
            }
            for (Vgetcontainercarrierinfo vc : clist) {
                reEntit = new TypeEntity ();
                reEntit.setTypeName ( "材料号" );
                reEntit.setTypeCount ( vc.getToolCode () );
                reLists.add ( reEntit );
                reEntit = new TypeEntity ();
                String toolState = vc.getExpandSpace1 ();
                reEntit.setTypeName ( "刀具状态" );
                if (IConstant.STRING_0.equals ( toolState )) {
                    reEntit.setTypeCount ( "断刀" );
                } else if (IConstant.STRING_1.equals ( toolState )) {
                    reEntit.setTypeCount ( "丢刀" );
                } else if (IConstant.STRING_2.equals ( toolState )) {
                    reEntit.setTypeCount ( "不合格" );
                } else if (IConstant.STRING_3.equals ( toolState )) {
                    reEntit.setTypeCount ( "待分拣" );
                } else if (IConstant.STRING_4.equals ( toolState )) {
                    reEntit.setTypeCount ( "待换装" );
                } else if (IConstant.STRING_5.equals ( toolState )) {
                    reEntit.setTypeCount ( "到寿" );
                } else if (IConstant.STRING_6.equals ( toolState )) {
                    reEntit.setTypeCount ( "厂内待刃磨" );
                } else if (IConstant.STRING_7.equals ( toolState )) {
                    reEntit.setTypeCount ( "厂外待刃磨" );
                } else if (IConstant.STRING_8.equals ( toolState )) {
                    reEntit.setTypeCount ( "刃磨完毕" );
                } else if (IConstant.STRING_9.equals ( toolState )) {
                    reEntit.setTypeCount ( "其他" );
                }
                reLists.add ( reEntit );
                reEntity = new TypeEntity ();
                reEntity.setTypeName ( "数量" );
                reEntity.setTypeCount ( String.valueOf ( vc.getToolDurable () ) );
                reLists.add ( reEntity );
            }
        }
        if (reLists == null || reLists.size () < 1) {
            respons.setStateCode ( IConstant.DEL_FLAG_1 );
            respons.setStateMsg ( "未找到查询信息" );
            return respons;
        } else {
            respons.setCon ( reLists );
        }
        respons.setQueryType ( queryType );
        respons.setStateCode ( IConstant.STOCK_STATE_0 );
        respons.setStateMsg ( "查询成功" );
        return respons;
    }

    private TypeEntity reToName(String businessFlowLnkID) {
        TypeEntity reEnt = new TypeEntity ();
        reEnt.setTypeName ( "最后业务流程" );
        if (IConstant.C03S001.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C03S001_TEXT );
        } else if (IConstant.C01S003.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S003_TEXT );
        } else if (IConstant.C01S004.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S004_TEXT );
        } else if (IConstant.C01S011.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S011_TEXT );
        } else if (IConstant.C01S013.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S013_TEXT );
        } else if (IConstant.C01S010.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S010_TEXT );
        } else if (IConstant.C01S014.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S014_TEXT );
        } else if (IConstant.C01S018.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S018_TEXT );
        } else if (IConstant.C01S027.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S027_TEXT );
        } else if (IConstant.C01S016.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S016_TEXT );
        } else if (IConstant.C01S005.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S005_TEXT );
        } else if (IConstant.C01S020.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S020_TEXT );
        } else if (IConstant.C01S019.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S019_TEXT );
        } else if (IConstant.C01S006.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S006_TEXT );
        } else if (IConstant.C01S007.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S007_TEXT );
        }
        //2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
        else if (IConstant.C01S023.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S023_TEXT );
        }
        else if (IConstant.C01S017.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S017_TEXT );
        }
        else if (IConstant.C01S008.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S008_TEXT );
        }
        else if (IConstant.C01S009.equals ( businessFlowLnkID )) {
            reEnt.setTypeCount ( IConstant.C01S009_TEXT );
        }
        //2017/08/14 王冉 追加↑↑↑　dazhong@YMSC

        return reEnt;

    }

    public C01S024Respons getToolInfo(C01S024Request request) throws Exception {
        C01S024Respons respons = new C01S024Respons ();
        String rfidString = request.getRfidString ();
        //参数验证
        if (rfidString == null || "".equals ( rfidString )) {
            throw new BusinessException ( IConstant.WMSG0221, request.getLanguageCode (), request.getLanguageValue () );
        }
        //判断扫描的刀具类型
        if (request.getRfidString () != null && !"".equals ( request.getRfidString ().trim () )) {
            String toolType = service.getToolsTypeByRfid ( request.getRfidString () );
            if (toolType.equals ( IConstant.TOOL_KIND_0 )) { //未初始化
                throw new BusinessException ( IConstant.WMSG0247, request.getLanguageCode (), request.getLanguageValue () );
            }
            if (toolType.equals ( IConstant.TOOL_KIND_3 )) {//辅具
                throw new BusinessException ( IConstant.WMSGC01S024_2, request.getLanguageCode (), request.getLanguageValue () );
            }
            if (toolType.equals ( IConstant.TOOL_KIND_4 )) {//配套
                throw new BusinessException ( IConstant.WMSGC01S024_3, request.getLanguageCode (), request.getLanguageValue () );
            }
            if (toolType.equals ( IConstant.TOOL_KIND_5 )) {//设备
                throw new BusinessException ( IConstant.WMSGC01S024_4, request.getLanguageCode (), request.getLanguageValue () );
            }
        }

        Map<String, Object> ret = iCOMPV01C01S024Service.getToolInfo ( rfidString, request.getLanguageCode (), request.getLanguageValue () );
        if (ret.size () > 0 && Integer.valueOf ( ret.get ( "status" ).toString () ) < 0) {
            throw new BusinessException ( (String) ret.get ( "messageCode" ), request.getLanguageCode (), request.getLanguageValue () );
        }
        try {
            respons.setToolType ( MessageReSource.getMessageBox ( ret.get ( "ToolType" ).toString (), request.getLanguageCode (), request.getLanguageValue () ) );//刀具类型
            //		if (IConstant.STRING_3.equals(ret.get("DisplayType").toString())==false) {
            //			respons.setQuotaProcessingVolume(Integer.valueOf(ret.get("QuotaProcessingVolume").toString()));//定额加工量
            //		}

            respons.setToolStauts ( ret.get ( "ToolStaut" ) + "" );//当前状态
            respons.setToolRepairNoticeUser ( ret.get ( "UserName" ).toString () );// 当前操作者
            respons.setQueryType ( ret.get ( "QueryType" ).toString () );//显示类型
            respons.setToolCode ( ret.get ( "ToolCode" ).toString () );// 刀具(合成)编码
            respons.setDisplayType ( ret.get ( "DisplayType" ).toString () );
            // 加工数量
            respons.setProcessingVolume ( Integer.valueOf ( ret.get ( "MachiningCount" ).toString () ) );
            if (IConstant.STRING_3.equals ( ret.get ( "DisplayType" ).toString () )) {//合成刀具
                respons.setxPoint ( Double.valueOf ( ret.get ( "xPoint" ) == null ? IConstant.STRING_0 : ret.get ( "xPoint" ).toString () ) );// X坐标
                respons.setyPoint ( Double.valueOf ( ret.get ( "yPoint" ) == null ? IConstant.STRING_0 : ret.get ( "yPoint" ).toString () ) );// Y坐标
                //			respons.setSynthesisCount(Integer.valueOf(ret.get("SynthesisCount").toString()));//孔位数
                //			respons.setTechnologyCount(Integer.valueOf(ret.get("Auxiliary").toString()));// 辅具数
                //			respons.setBoringCrownCount(Integer.valueOf(ret.get("drill").toString()));// 钻头数
                //			respons.setBladeCount(Integer.valueOf(ret.get("blades").toString()));// 刀片数

                //根据RFID获取当前走过的流程
                List<SynthesisHistory> synthesisHistoryList = new ArrayList<SynthesisHistory> ();
                SynthesisHistory sh = null;
                List<Vgetsynthesisexperience> selist = service.getSynthesisHistory ( rfidString );

                if (selist.size () > 0) {
                    for (Vgetsynthesisexperience vs : selist) {
                        sh = new SynthesisHistory ();
                        sh.setSynthesisParametersCode ( vs.getSynthesisParametersCode () );
                        sh.setSynthesisParametersNumber ( vs.getSynthesisParametersNumber () );
                        sh.setBusinessName ( vs.getBusinessName () );
                        sh.setUserName ( vs.getUserName () );
                        synthesisHistoryList.add ( sh );
                    }
                    respons.setShList ( synthesisHistoryList );
                }
            } else {//单品刀具
                Comlist comlist = new Comlist ();
                comlist.setDelFlag ( IConstant.DEL_FLAG_0 );
                comlist.setLanguageCode ( request.getLanguageCode () );
                String knifeInventoryType = null;
                if (ret.get ( "knifeInventoryType" ) != null) {
                    knifeInventoryType = ret.get ( "knifeInventoryType" ).toString ();
                }
                if (null != knifeInventoryType && !"".equals ( knifeInventoryType )) {
                    comlist.setComListType ( IConstant.KNIFE_INVENTORY_TYPE );
                    comlist.setComListValue ( knifeInventoryType );
                }
                StringBuffer stateText = new StringBuffer (); //状态
                //库存状态
                String stockState = null;
                if (ret.get ( "stockState" ) != null) {
                    stockState = ret.get ( "stockState" ).toString ();
                }
                String stockStateText = null;
                if (null != stockState && !"".equals ( stockState )) {
                    comlist.setComListType ( IConstant.STOCK_STATE );
                    comlist.setComListValue ( stockState );
                    try {
                        stockStateText = service.getComListText ( comlist );
                    } catch (Exception e) {
                        stockStateText = null;
                    }
                }
                //刀具状态
                String toolState = null;
                if (ret.get ( "toolState" ) != null) {
                    toolState = ret.get ( "toolState" ).toString ();
                }
                String toolStateText = null;
                if (null != toolState && !"".equals ( toolState )) {
                    comlist.setComListType ( IConstant.TOOL_STATE );
                    comlist.setComListValue ( toolState );
                    try {
                        toolStateText = service.getComListText ( comlist );
                    } catch (Exception e) {
                        toolStateText = null;
                    }
                }
                stateText.append ( ret.get ( "ToolStaut" ).toString () );
                if (null != stockStateText && !"".equals ( stockStateText ) && !("报废".equals ( stockStateText ))) {
                    stateText.append ( "(" + stockStateText );
                    if (null != toolStateText && !"".equals ( toolStateText )) {
                        stateText.append ( "-" + toolStateText );
                    }
                    stateText.append ( ")" );
                } else {
                    if (stockStateText != null)
                        stateText.append ( "(" + stockStateText + ")" );
                }
                respons.setToolStauts ( stateText.toString () );//当前状态(库存+刀具)
                // respons.setSynthesisCount(Integer.valueOf(ret.get("SynthesisCount").toString()));
                respons.setSynthesisCount ( Integer.parseInt ( ret.get ( "toolCount" ) + "" ) ); //盒中的数量
                respons.setUsageCounter ( Integer.valueOf ( ret.get ( "UsageCounter" ).toString () ) );//已刃磨次数
                if (IConstant.STRING_0.equals ( ret.get ( "DisplayType" ).toString () )) {//
                    respons.setToolSharpennum ( Integer.valueOf ( ret.get ( "ToolSharpennum" ).toString () ) );
                } else if (IConstant.STRING_1.equals ( ret.get ( "DisplayType" ).toString () )) {//
                    respons.setToolSharpennum ( Integer.valueOf ( ret.get ( "ToolSharpennum" ).toString () ) );
                    if (ret.get ( "ToolSharpennumLength" ) != null && !"".equals ( ret.get ( "ToolSharpennumLength" ) )) {
                        respons.setToolSharpennumLength ( Double.valueOf ( ret.get ( "ToolSharpennumLength" ).toString () ) );
                    }
                    if (IConstant.STRING_1.equals ( ret.get ( "QueryType" ).toString () )) {
                        if (ret.get ( "ToolGrindingLength" ) != null && !"".equals ( ret.get ( "ToolGrindingLength" ) )) {
                            respons.setToolGrindingLength ( Double.valueOf ( ret.get ( "ToolGrindingLength" ).toString () ) );
                        }
                    }
                } else {
                    respons.setToolSharpennum ( Integer.valueOf ( ret.get ( "ToolSharpennum" ).toString () ) );
                    if (ret.get ( "ToolSharpennumLength" ) != null && !"".equals ( ret.get ( "ToolSharpennumLength" ) )) {
                        respons.setToolSharpennumLength ( Double.valueOf ( ret.get ( "ToolSharpennumLength" ).toString () ) );
                    }
                    if (IConstant.STRING_1.equals ( ret.get ( "QueryType" ).toString () )) {
                        if (ret.get ( "ToolGrindingLength" ) != null && !"".equals ( ret.get ( "ToolGrindingLength" ) )) {
                            respons.setToolGrindingLength ( Double.valueOf ( ret.get ( "ToolGrindingLength" ).toString () ) );
                        }
                    }
                }
                if (ret.get ( "toolNoticeCount" ) != null) {
                    respons.setToolNoticeCount ( Integer.valueOf ( ret.get ( "toolNoticeCount" ).toString () ) );
                }
            }
        } catch (Exception e) {
            System.out.printf ( "C01S024BusinessImpl--" + e.toString () );
            throw new BusinessException ( IConstant.EMSG0004, request.getLanguageCode (), request.getLanguageValue () );
        }
        return respons;
    }


}
