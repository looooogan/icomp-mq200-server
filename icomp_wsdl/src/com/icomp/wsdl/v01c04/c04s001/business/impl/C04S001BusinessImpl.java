package com.icomp.wsdl.v01c04.c04s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c04.s001.ICOMPV01C04S001Service;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vstockinglist;
import com.icomp.wsdl.v01c04.c04s001.business.C04S001Business;
import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Request;
import com.icomp.wsdl.v01c04.c04s001.endpoint.C04S001Respons;
import com.icomp.wsdl.v01c04.c04s001.endpoint.StockingInfo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C04S001BusinessImpl implements C04S001Business {

    @SuppressWarnings("unused")
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C04S001Service iCOMPV01C04S001Service;

    public void setiCOMPV01C04S001Service(ICOMPV01C04S001Service iCOMPV01C04S001Service) {
        this.iCOMPV01C04S001Service = iCOMPV01C04S001Service;
    }

    /**
     * 取得当前扫描刀具数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C04S001Respons getToolList(C04S001Request request) throws Exception {
        C04S001Respons respons = new C04S001Respons();
        Vstockinglist entity = new Vstockinglist();
        entity.setRfidCode(request.getRfidString());
        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) {
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            } else if (!toolType.equals(IConstant.TOOL_KIND_2) &&
                    !toolType.equals(IConstant.TOOL_KIND_3) &&
                    !toolType.equals(IConstant.TOOL_KIND_4)) {
                throw new BusinessException(IConstant.WMSG0245, request.getLanguageCode(), request.getLanguageValue());
            }
        }
        // 取得并判断刀具当前扫描刀具是否可以进行【盘点】业务
        Map<String, Object> ret = service.checkToolStautspd(request.getRfidString(), "C04S001", request.getLanguageCode());
        if (ret.size() > 0 && !(Boolean.valueOf(ret.get("agreeFlag").toString()).booleanValue())) {
            if (ret.get("messageText") == null) {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException((String) ret.get("messageCode"), request.getLanguageCode(), request.getLanguageValue(), (String) ret.get("newFlowText"), (String) ret.get("lastFlowText"), (String) ret.get("messageText"));
            }
        }
        List<Vstockinglist> list = iCOMPV01C04S001Service.getToolList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        //库位码
        respons.setLibraryCodeID(list.get(0).getlibCode());
        //刀具类型
        respons.setToolType(list.get(0).getToolType());
        //刀具编码
        respons.setToolCode(list.get(0).getToolCode());
        //在库数量
        int count = 0;
        List<StockingInfo> stockingInfoList = new ArrayList<StockingInfo>();
        for (Vstockinglist vstockinglist : list) {
            if (vstockinglist.getRfidCode() != null && !"".equals(vstockinglist.getRfidCode())) {
                count += vstockinglist.getToolCount();
                StockingInfo stockingInfo = new StockingInfo();
                //{RFID、捆绑数量}
                stockingInfo.setCount(vstockinglist.getToolCount());
                stockingInfo.setRfidString(vstockinglist.getRfidCode());
                stockingInfoList.add(stockingInfo);
            }
        }
        respons.setToolCount(count);
        respons.setStockingInfoList(stockingInfoList);
        return respons;
    }

    /**
     * 取得盘点数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C04S001Respons getStockingList(C04S001Request request) throws Exception {
        C04S001Respons respons = new C04S001Respons();
        List<Vstockinglist> list = iCOMPV01C04S001Service.getStockingList(request.getRfids());
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        List<Vstockinglist> scanfList = iCOMPV01C04S001Service.searchByOldToolList(request.getRfids());
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        List<StockingInfo> stockingInfoList = new ArrayList<StockingInfo>();
        for (Vstockinglist vstockinglist : list) {
            StockingInfo stockingInfo = new StockingInfo();
            stockingInfo.setCount(vstockinglist.getToolCount());
            stockingInfo.setToolCode(vstockinglist.getToolCode());
            stockingInfo.setStoreType(vstockinglist.getQueryType());
            for (Vstockinglist svstockinglist : scanfList) {
                if (svstockinglist.getQueryType().equals(vstockinglist.getQueryType())) {
                    stockingInfo.setScanfCount(svstockinglist.getToolCount());
                }
            }
            stockingInfoList.add(stockingInfo);

        }
        respons.setStockingInfoList(stockingInfoList);
        return respons;
    }

    /**
     * 保存盘点数据列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C04S001Respons saveStockingList(C04S001Request request) throws Exception {
        C04S001Respons respons = new C04S001Respons();
        List<Map<String, Object>> stockings = new ArrayList<Map<String, Object>>();
        for (StockingInfo stockingInfo : request.getStockingInfoList()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("toolCode", stockingInfo.getToolCode());
            map.put("count", stockingInfo.getCount());
            stockings.add(map);
        }
        Map<String, Object> ret = iCOMPV01C04S001Service.saveStockingList(request.getRfids(), stockings, request.getCustomerID(), request.getLanguageCode(), request.getLanguageValue(), request.getHandSetId(), request.getGruantUserID());
        if (Integer.parseInt(ret.get("status").toString()) < 0) {
            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(Integer.parseInt(ret.get("status").toString()));
        respons.setMessageText(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        return respons;
    }

    /**
     * 根据材料号查询刀具在库数量
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C04S001Respons seachInitNewVentory(C04S001Request request) throws Exception {
        C04S001Respons respons = new C04S001Respons();
        String toolConsumetype = null;
        List<Tool> reval = null;
        Knifeinventory kni = new Knifeinventory();
        List<Knifeinventory> kentList = new ArrayList<Knifeinventory>();
        Tool t = new Tool();
        int sumsn = 0;
        if (IConstant.DEL_FLAG_0.equals(request.getInfoType())) {
            //扫描查询
            // 参数验证
            if (StringUtils.isEmpty(request.getRfidCode())) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            //查询载体ID
            Rfidcontainer entity = new Rfidcontainer();
            // RFID标签
            entity.setRfidCode(request.getRfidCode());
            // 删除区分
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            Rfidcontainer rfidConner = service.getRfidContainerByRfidCode(entity);
            if (null == rfidConner) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("当前标签未初始化");
                return respons;
            }
            if (!(IConstant.DEL_FLAG_1.equals(rfidConner.getQueryType())) && !(IConstant.DEL_FLAG_0.equals(rfidConner.getQueryType()))) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("请扫描库位标签或单品新刀");
                return respons;
            }

            kni.setRfidContainerID(rfidConner.getRfidContainerID());
            kni.setDelFlag(IConstant.DEL_FLAG_0);
            kentList = iCOMPV01C04S001Service.getKNMsgs(kni);
            if (null == kentList || kentList.size() < 1) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("请扫描库位标签或单品新刀");
                return respons;
            }
            t.setToolID(kentList.get(0).getToolID());
        } else {
            //输入查询

            // 参数验证
            if (StringUtils.isEmpty(request.getToolCode())) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            t.setToolCode(request.getToolCode());
        }
        t.setDelFlag(IConstant.DEL_FLAG_0);
        //刀具参数
        reval = iCOMPV01C04S001Service.getToolIDByToolCode(t);
        if (null == reval || reval.size() < 1) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到当前材料号对应信息");
            return respons;
        }

        kni = new Knifeinventory();
        kni.setToolID(reval.get(0).getToolID());
        kni.setDelFlag(IConstant.DEL_FLAG_0);
        kentList = iCOMPV01C04S001Service.getKNMsgs(kni);
        if (kentList == null) {
            kentList = new ArrayList<Knifeinventory>();
        }
        //刀具分类(0刀具1辅具2配套9其他）
        if (IConstant.EDIT_FLAG_0.equals(reval.get(0).getToolType())) {
            //消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他
            if (IConstant.STACK_0.equals(reval.get(0).getToolConsumetype())) {
                toolConsumetype = IConstant.STRING_0;
            } else {
                toolConsumetype = IConstant.STRING_1;
            }
        } else {
            //非单品
            toolConsumetype = IConstant.STRING_1;
        }
        //刀具类型（0单品刀具，1非单品刀具）
        respons.setToolConsumetype(toolConsumetype);

        //求刀片的库存数量
        if (IConstant.STRING_0.equals(reval.get(0).getToolConsumetype())) {
            for (Knifeinventory kn : kentList) {
                sumsn = sumsn + Integer.parseInt(kn.getKnifelnventoryNumber());
            }
            respons.setLibraryCount(String.valueOf(sumsn));
        } else if (!IConstant.STRING_0.equals(reval.get(0).getToolConsumetype())) {
            if (kentList.size() < 1) {
                respons.setLibraryCount(IConstant.STRING_0);
            } else {
                respons.setLibraryCount(String.valueOf(kentList.get(0).getKnifelnventoryNumber()));

            }
        }
        respons.setToolCode(reval.get(0).getToolCode());
        respons.setToolID(reval.get(0).getToolID());

        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 提交在库盘点刀具
     *
     * @param request
     * @return
     * @throws Exception
     */

    public C04S001Respons submitCheckToolDate(C04S001Request request) throws Exception {
        C04S001Respons respons = new C04S001Respons();
        //1非单品刀
        if (!IConstant.STRING_0.equals(request.getToolConsumetype())) {
            // 参数验证
            if (checkParam(request, 2)) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            Knifeinventory kn = new Knifeinventory();
            //刀具ID
            kn.setToolIDWhere(request.getToolID());
            //真实数量
            kn.setKnifelnventoryNumber(request.getRealLibraryCount());
            kn.setDelFlag(IConstant.DEL_FLAG_0);
            kn.setUpdateTime(new Date());
            kn.setUpdateUser(request.getCustomerID());
            //
            int reVal = iCOMPV01C04S001Service.submitCheckToolDate(kn);
            if (reVal < 1) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("提交在库盘点刀具信息失败");
                return respons;
            }
        }
        //0单品刀
        else {
            // 参数验证
            if (checkParam(request, 1)) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            //             单品刀具
            //            if (IConstant.STRING_0.equals(request.getQueryType())) {
            //                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            //            }
            //刪除不存在的邏輯刪除
            Map<String, Object> rfMap = new HashMap<String, Object>();
            rfMap.put("toolCode", request.getToolCode());
            rfMap.put("list", request.getRfidCodelist());
            int smap = 0;
            if (request.getRfidCodelist() == null || request.getRfidCodelist().size() < 1) {
                smap = iCOMPV01C04S001Service.getDelRFIDAndKn(rfMap);

            } else {
                smap = iCOMPV01C04S001Service.getupdateDel(rfMap);

            }

            if (smap <= 0) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("提交在库盘点刀具信息失败");
                return respons;
            }
        }

        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("提交成功");
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @param i
     * @return
     */

    private boolean checkParam(C04S001Request request, int i) {
        // 用户ID
        if (StringUtils.isEmpty(request.getCustomerID())) {
            return true;
        }
        //刀具类型（0非单品刀具，1单品刀具）
        if (StringUtils.isEmpty(request.getToolConsumetype())) {
            return true;
        }
        //材料号
        if (StringUtils.isEmpty(request.getToolCode())) {
            return true;
        }
        //刀具ID
        if (StringUtils.isEmpty(request.getToolID())) {
            return true;
        }
//        //rfid集合
//        if (i == 1) {
//            if (request.getRfidCodelist() == null || request.getRfidCodelist().size() < 1) {
//                return true;
//            } else {
//                request.setRfidCodelist(service.checkList(request.getRfidCodelist()));
//            }
//        }
        if (StringUtils.isEmpty(request.getRealLibraryCount())) {
            return true;
        }

        return false;
    }

    public C04S001Respons checkRFIDType(C04S001Request request) throws Exception {

        C04S001Respons respons = new C04S001Respons();
        String rfidCode = request.getRfidCode();
        Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(rfidCode);
        rfidcontainer.setDelFlag(IConstant.DEL_FLAG_0);
        Rfidcontainer reval = service.getRfidContainerByRfidCode(rfidcontainer);
        String queryType = null;
        if (reval == null) {
            respons.setStateCode(IConstant.STRING_9);
            respons.setStateMsg("当前标签未初始化");
        } else {
            queryType = reval.getQueryType();
            if (IConstant.STRING_3.equals(queryType) || IConstant.STRING_4.equals(queryType) || IConstant.STRING_5.equals(queryType)) {
                respons.setStateCode(queryType);
                respons.setStateMsg("0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库");
            } else {
                reval = service.checkRFIDType(rfidCode);
                if (reval == null) {
                    respons.setStateCode(IConstant.TOOL_STATE_10);
                    respons.setStateMsg("未找到相关刀具信息");
                } else {
                    respons.setToolCode(reval.getExpandSpace1());
                    respons.setStateCode(queryType);
                    if (IConstant.STRING_1.equals(reval.getDelFlagWhere())) {
                        //旧刀
                        respons.setToolConsumetype(IConstant.STRING_1);
                    } else {
                        //新刀
                        respons.setToolConsumetype(IConstant.STRING_0);
                    }
                    respons.setStateMsg("0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库");
                }
            }
        }
        return respons;
    }

}
