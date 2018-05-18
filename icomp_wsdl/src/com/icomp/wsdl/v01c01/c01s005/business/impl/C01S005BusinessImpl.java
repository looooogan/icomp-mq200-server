package com.icomp.wsdl.v01c01.c01s005.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s005.ICOMPV01C01S005Service;
import com.icomp.entity.base.Authorization;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Scrap;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.wsdl.v01c01.c01s005.business.C01S005Business;
import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Request;
import com.icomp.wsdl.v01c01.c01s005.endpoint.C01S005Respons;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01S005BusinessImpl implements C01S005Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S005Service iCOMPV01C01S005Service;

    public void setiCOMPV01C01S005Service(ICOMPV01C01S005Service iCOMPV01C01S005Service) {
        this.iCOMPV01C01S005Service = iCOMPV01C01S005Service;
    }

    /**
     * 报废
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S005Respons saveScrap(C01S005Request request) throws Exception {
        C01S005Respons respons = new C01S005Respons ();
        Scrap entity = new Scrap ();

        // 传入数据 存在性校验
        Map<String, Object> rtn = cuttingToolStorageCheck ( request );
        if (Integer.parseInt ( rtn.get ( "status" ).toString () ) < 0) {
            respons.setStateCode ( rtn.get ( "status" ).toString () );
            respons.setStateMsg ( rtn.get ( "messagetext" ).toString () );
            return respons;
        } else {
            // 根据传入的rfidCode,校验是否有对应的载体id
            String rfidContainerId = service.getrfidContainerIdByRfid ( request.getRfidCode () );
            if (IConstant.STRING_0.equals ( rfidContainerId )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "未找到相应的载体id" );
                return respons;
            }
            Tooltransfer tt = new Tooltransfer ();
            //Where
            tt.setRfidContainerIDWhere ( rfidContainerId );
            tt.setDelFlagWhere ( IConstant.DEL_FLAG_0 );
            tt.setToolIDWhere ( request.getToolID () );
            //set
            //报废状态（0.断刀1.丢刀2.到寿3.其他）
            String toolState = request.getScrapState ();
            if (IConstant.DEL_FLAG_0.equals ( toolState )) {
                tt.setToolState ( IConstant.TOOL_STATE_0 );
            } else if (IConstant.STRING_1.equals ( toolState )) {
                tt.setToolState ( IConstant.TOOL_STATE_1 );
            } else if (IConstant.BAND_TYPE_2.equals ( toolState )) {
                tt.setToolState ( IConstant.STRING_5 );
            } else {
                tt.setToolState ( IConstant.TOOL_STATE_9 );
            }
            tt.setToolThisState ( IConstant.STRING_1 );
            tt.setStockState ( IConstant.STOCK_STATE_1 );
            tt.setBusinessFlowLnkID ( IConstant.C01S005 );
            // 手持机id
            tt.setExpandSpace1 ( request.getHandSetId () );
            // 更新时间
            tt.setUpdateTime ( new Date () );
            // 更新者
            tt.setUpdateUser ( request.getCustomerID () );
            //已刃磨次数
            entity.setUsageCounter ( tt.getUsageCounter () );
            // 刀具类型
            entity.setToolType ( request.getToolType () );
            // 材料号
            entity.setMaterial ( request.getMaterial () );
            // 刀具ID
            entity.setToolID ( request.getToolID () );
            // 报废原因
            entity.setScrapCause ( request.getScrapCause () );
            // 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
            entity.setScrapState ( request.getScrapState () );
            // 授权人
            entity.setAuthorizationID ( request.getGruantUserID () );
            // 创建者
            entity.setCreateUser ( request.getCustomerID () );

            int ret = iCOMPV01C01S005Service.saveScrap ( entity, tt );
            if (ret > 0) {
                if (request.getGruantUserID () != null) {
                    //  授权记录插入
                    Authorization auth = new Authorization ();
                    //授权人ID
                    auth.setAuthorizationUserID ( request.getGruantUserID () );
                    //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它，11刀具报废）
                    auth.setAuthorizedReason ( IConstant.STRING_11 );
                    //刀具类型（0单品，1合成刀具）
                    auth.setTooltype ( IConstant.DEL_FLAG_0 );
                    //材料号或合成刀具编码
                    auth.setToolCode ( request.getMaterial () );
                    //业务流程编码
                    auth.setBusinessCode ( IConstant.C01S005 );
                    auth.setCreateUserID ( request.getCustomerID () );
                    //备注
                    auth.setNote ( request.getScrapCause () );
                    service.innsetGruant ( auth );
                }

                respons.setStateCode ( IConstant.DEL_FLAG_0 );
                respons.setStateMsg ( "保存成功" );
            } else {
                respons.setStateCode ( IConstant.DEL_FLAG_1 );
                respons.setStateMsg ( "报废失败" );
            }

          /*  // 刀具类型
            entity.setToolType(request.getToolType());
            // 材料号
            entity.setMaterial(request.getMaterial());
            // 刀具ID
            entity.setToolID(request.getToolID());
            // 报废原因
            entity.setScrapCause(request.getScrapCause());
            // 报废状态（0.断刀1.丢刀2.到寿3.出库报废4.其他）
            entity.setScrapState(request.getScrapState());
            // 授权人
            entity.setAuthorizationID(request.getGruantUserID());
            // 创建者
            entity.setCreateUser(request.getCustomerID());
            Map<String, Object> ret = iCOMPV01C01S005Service.saveScrap(entity, rfidContainerId);
            if (Integer.parseInt(ret.get("status").toString()) < 0) {
                throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
            }
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setStateMsg("保存成功");*/
            return respons;
        }
    }

    @Override
    public C01S005Respons getToolMsg(C01S005Request request) throws Exception {
        C01S005Respons respons = new C01S005Respons ();
        //  Scrap entity = new Scrap();

        // 传入数据 存在性校验
        if (StringUtils.isEmpty ( request.getRfidCode () ) || StringUtils.isEmpty ( request.getCustomerID () )) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "参数异常" );
        } else {
            Rfidcontainer rfidcontainer = new Rfidcontainer ();
            rfidcontainer.setDelFlag ( IConstant.DEL_FLAG_0 );
            rfidcontainer.setRfidCode ( request.getRfidCode () );
            Rfidcontainer rev = service.getRfidContainerByRfidCode ( rfidcontainer );
            if (rev == null) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "当前标签未初始化" );
            } else if (!IConstant.STRING_1.equals ( rev.getQueryType () )) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "请扫描要报废的单品刀具" );
            } else {
                Tooltransfer tt = new Tooltransfer ();
                tt.setRfidContainerID ( rev.getRfidContainerID () );
                tt.setDelFlag ( IConstant.DEL_FLAG_0 );
                List<Tooltransfer> tts = iCOMPV01C01S005Service.getToolMsg ( tt );
                if (tts == null || tts.size () < 1) {
                    respons.setStateCode ( IConstant.STRING_1 );
                    respons.setStateMsg ( "未找到刀具信息，只能报废流转中的刀具" );
                } else {
                    Tooltransfer tt1 = tts.get ( 0 );
                    //材料号
                    respons.setMaterial ( tt1.getProcuredBatch () );
                    //刀具ID
                    respons.setToolID ( tt1.getToolID () );
                    //    刀具状态(0断刀1丢失2不合格3待分拣4待换装, 5到寿, 6厂内待刃磨, 7.厂外待刃磨8刃磨完毕, 9其他)
                    String toolState = tt1.getToolState ();
                    if (IConstant.STRING_1.equals ( tt1.getStockState () ) || IConstant.DEL_FLAG_0.equals ( toolState ) || IConstant.DEL_FLAG_1.equals ( toolState )) {
                        respons.setStateMsg ( "当前刀具已报废，请勿重复报废" );
                        respons.setStateCode ( IConstant.STOCK_STATE_1 );
                    } else {
                        //刀具类型（0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）
                        respons.setToolConsumetype ( tt1.getKnifeInventoryCode () );
                        respons.setStateCode ( IConstant.STOCK_STATE_0 );
                    }
                }
            }
        }
        return respons;
    }

    @Override
    public C01S005Respons delRfidCodeIsNull(C01S005Request request) throws Exception {
        C01S005Respons respons = new C01S005Respons ();
        Map<String, Object> map = new HashedMap ();
        //验证
        //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器)
        String toolType = request.getToolType ();
        List<String> rfidCodes = request.getRfidCodeList ();
        if (StringUtils.isEmpty ( toolType ) || rfidCodes == null || rfidCodes.size () < 1) {
            respons.setStateCode ( IConstant.STRING_1 );
            respons.setStateMsg ( "参数异常" );
            return respons;
        }
        map.put ( "toolType", toolType );
        map.put ( "rfidCodes", rfidCodes );
        // 2017/09/12 王冉 追加↓↓↓　dazhong@YMSC
        map.put ( "customerID", request.getCustomerID () );
        // 2017/09/12 王冉 追加↑↑↑　dazhong@YMSC
//        //清空当前扫描的标签信息
//        int reVal = service.delRfidCodeIsNullByToolType (map);
//        if (reVal > 0) {
//            respons.setStateCode ( IConstant.STRING_0 );
//        } else {
//            respons.setStateCode ( IConstant.STRING_1 );
//            respons.setStateMsg ( "标签清空失败，请确认扫描标签和选择的类型是否相同 ");
//        }
//        return respons;


        // 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
        if(!IConstant.STRING_2.equals ( toolType )){
            //清空当前扫描的标签信息
            int reVal = service.delRfidCodeIsNullByToolType (map);
            if (reVal > 0) {
                respons.setStateCode ( IConstant.STRING_0 );
            } else {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg ( "标签清空失败，请确认扫描标签和选择的类型是否相同 ");
            }
            return respons;
            //清除合成刀具的场合
        }else{

            Map<String, Object> ret = service.delRfidCodeIsNull(map);
            if (Integer.parseInt(ret.get("status").toString()) > 0) {
                respons.setStateCode ( IConstant.STRING_1 );
                respons.setStateMsg (ret.get("message").toString());
            }else{
                respons.setStateCode ( IConstant.STRING_0 );
            }

            return respons;

        }
            // 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
    }

    /**
     * 传入数据 存在性校验
     *
     * @param request
     * @return
     * @throws Exception
     */
    private Map<String, Object> cuttingToolStorageCheck(C01S005Request request) {
        Map<String, Object> rtn = new HashMap<String, Object> ();
        String errorMsg = "";
        if (StringUtils.isEmpty ( request.getToolType () )) {
            errorMsg = "未传入刀具类型";
        }
        if (StringUtils.isEmpty ( request.getMaterial () )) {
            errorMsg = "未传入材料号";
        }
        if (StringUtils.isEmpty ( request.getToolID () )) {
            errorMsg = "未传入刀具ID";
        }
 /*       if (StringUtils.isEmpty ( request.getScrapCause () )) {
            errorMsg = "未传入报废原因";
        }*/
        if (StringUtils.isEmpty ( request.getScrapState () )) {
            errorMsg = "未传入报废状态";
        }
        if (StringUtils.isEmpty ( request.getGruantUserID () )) {
            errorMsg = "未传入授权人";
        }
        if (StringUtils.isEmpty ( request.getCustomerID () )) {
            errorMsg = "未传入用户ID";
        }

        if (!StringUtils.isEmpty ( errorMsg )) {
            rtn.put ( "status", IConstant.RESULT_CODE_1 );
            rtn.put ( "messagetext", errorMsg );
        } else {
            rtn.put ( "status", IConstant.RESULT_CODE_0 );
        }
        return rtn;
    }
}
