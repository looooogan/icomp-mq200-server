package com.icomp.wsdl.v01c03.c03s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c03.s001.ICOMPV01C03S001Service;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Synthesisknife;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vknifeinventoryinfo;
import com.icomp.entity.base.Vsynthesisparameters;
import com.icomp.entity.base.Vtoolparam;
import com.icomp.entity.base.Vtoolstack;
import com.icomp.wsdl.v01c03.c03s001.business.C03S001Business;
import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Request;
import com.icomp.wsdl.v01c03.c03s001.endpoint.C03S001Respons;
import com.icomp.wsdl.v01c03.c03s001.endpoint.InputRfid;
import com.icomp.wsdl.v01c03.c03s001.endpoint.InputTool;
import com.icomp.wsdl.v01c03.c03s001.endpoint.SynthesisEntity;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具初始化-新旧刀具
 */
public class C03S001BusinessImpl implements C03S001Business {

    @SuppressWarnings("unused")
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C03S001Service iCOMPV01C03S001Service;

    public void setiCOMPV01C03S001Service(ICOMPV01C03S001Service iCOMPV01C03S001Service) {
        this.iCOMPV01C03S001Service = iCOMPV01C03S001Service;
    }

    Map<String, Object> parMap = new HashMap<String, Object>();

    /**
     * 验证RFID是否可用
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S001Respons checkRfid(C03S001Request request) throws Exception {
        C03S001Respons ret = new C03S001Respons();
        Rfidcontainer entity = new Rfidcontainer();
        entity.setRfidCode(request.getRfidString());
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity = iCOMPV01C03S001Service.checkRfid(entity);
        if (entity.isRetErrFlag()) {
            throw new BusinessException(entity.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        return ret;
    }

    /**
     * 取得刀具基本信息webService
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S001Respons getToolInfo(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        //依据刀具库位码取得刀具基本信息
        Vtoolstack entity = new Vtoolstack();
        //验证
        entity.setLibraryCode(request.getLibraryCode());
        entity.setQueryTypeWhere(request.getInputType());
        Vtoolstack vtoolstack = iCOMPV01C03S001Service.getRfidType(entity);
        if (vtoolstack.isRetErrFlag()) {
            throw new BusinessException(vtoolstack.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setToolCode(vtoolstack.getToolCode());
        respons.setLibraryCode(vtoolstack.getLibraryCode());
        respons.setExistingNumber(vtoolstack.getToolUnitnumber().intValue());
        respons.setShelf(vtoolstack.getShelf());
        respons.setStack(vtoolstack.getStack());
        respons.setToolUnitnumber(vtoolstack.getToolUnitnumber().intValue());
        respons.setStatus(IConstant.ZERO);
        return respons;
    }

    /**
     * 判断rfid状态
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S001Respons getRfidType(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        Vtoolstack entity = new Vtoolstack();
        entity.setRfidCode(request.getRfidString());
        entity.setQueryTypeWhere(request.getInputType());
        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) {
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            }
            if (toolType.equals(IConstant.TOOL_KIND_1)) {
                throw new BusinessException(IConstant.WMSG0245, request.getLanguageCode(), request.getLanguageValue());
            }
        }
        Vtoolstack vtoolstack = iCOMPV01C03S001Service.getRfidType(entity);
        if (vtoolstack.isRetErrFlag()) {
            throw new BusinessException(vtoolstack.getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setToolCode(vtoolstack.getToolCode());
        respons.setLibraryCode(vtoolstack.getLibraryCode());
        respons.setExistingNumber(vtoolstack.getexistingNumber().intValue()); //现有数量
        respons.setToolUnitnumber(vtoolstack.getToolUnitnumber().intValue());//每盒数量
        respons.setShelf(vtoolstack.getShelf());
        respons.setStack(vtoolstack.getStack());
        respons.setStatus(IConstant.ZERO);
        return respons;
    }

    /**
     * 初始化刀具信息保存webService
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C03S001Respons saveInitialization(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        List<InputRfid> inputRfidList = request.getInputRfidList();
        List<InputTool> inputToolList = request.getInputToolList();
        List<Map<String, Object>> rfidList = new ArrayList<Map<String, Object>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (InputTool inputTool : inputToolList) {
            map.put(inputTool.getToolCode(), inputTool.getInputNumber());
        }
        for (InputRfid inputRfid : inputRfidList) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("RfidString", inputRfid.getRfidString());
            item.put("ToolCode", inputRfid.getToolCode());
            //根据刀具编码取得每盒数量
            Vtoolparam entity = new Vtoolparam();
            entity.setToolCode(inputRfid.getToolCode());
            entity = iCOMPV01C03S001Service.getToolInfo(entity);
            item.put("InputType", inputRfid.getInputType());
            if (entity.getToolType().equals(IConstant.TOOL_TYPE_0)) { //刀具
                //	int toolCount = map.get(inputRfid.getToolCode());
                int toolCount = inputRfid.getInputNumber();//盒数量
                if (toolCount < entity.getToolUnitnumber().intValue()) {
                    item.put("ToolCount", toolCount);
                } else {
                    item.put("ToolCount", entity.getToolUnitnumber().intValue());
                }
                rfidList.add(item);
            } else {
                for (InputTool inputTool : inputToolList) {
                    if (inputTool.getToolCode().equals(inputRfid.getToolCode())) {
                        item.put("ToolCount", inputTool.getInputNumber());
                        rfidList.add(item);
                    }
                }
            }
        }
        Map<String, Object> ret = iCOMPV01C03S001Service.saveInitialization(rfidList, request.getCustomerID(), request.getLanguageCode(), request.getLanguageValue(), request.getHandSetId());
        if (Integer.parseInt(ret.get("status").toString()) < 0) {
            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStatus(Integer.parseInt(ret.get("status").toString()));
        respons.setMessageText(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        return respons;
    }

    /**
     * 根据材料号查询待初始化旧刀
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons seachOldRunToolsByToolCode(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        Tool t = new Tool();
        //材料号
        t.setToolCode(request.getToolCode());
        t.setDelFlag(IConstant.DEL_FLAG_0);
        Tool reval = iCOMPV01C03S001Service.getOldToolMsg(t);
        if (reval == null) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到材料号对应信息");
            return respons;
        }
        //材料号
        respons.setToolCode(request.getToolCode());
        //刀具ID
        respons.setToolID(reval.getToolID());
        //刀具类型
        respons.setToolConsumeType(reval.getToolConsumetype());
        if (IConstant.DEL_FLAG_0.equals(reval.getToolType()) && IConstant.DEL_FLAG_0.equals(reval.getToolConsumetype())) {
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setStateMsg("查询成功");
        } else {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("流转旧刀初始化只能初始化单品刀具");
            return respons;
        }
        return respons;

    }

    /**
     * 查询当前标签是否已初始化
     * //
     *
     * @param request
     * @return
     */
    @Override
    public C03S001Respons findInitializeMsg(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (StringUtils.isEmpty(request.getRfidCode())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        Rfidcontainer entity = new Rfidcontainer();
        // RFID标签
        entity.setRfidCode(request.getRfidCode());
        //标签类型
        //  entity.setQueryType(request.getQueryType());
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        Rfidcontainer rfidConner = service.getRfidContainerByRfidCode(entity);
        if (null == rfidConner) {
            respons.setIsHas(IConstant.DEL_FLAG_0);
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setStateMsg("扫描成功");
        } else {
            if (!IConstant.DEL_FLAG_1.equals(rfidConner.getQueryType())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("请扫描单品刀具标签或空标签");
            } else {
                respons.setIsHas(IConstant.DEL_FLAG_1);
                respons.setStateCode(IConstant.DEL_FLAG_0);
                respons.setStateMsg("此标签已初始化");
            }
        }
        return respons;
    }

    /**
     * 提交流转旧刀初始化数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons submitOldRunInItDate(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (checkParam(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
 /*       Rfidcontainer rfidcontainer = new Rfidcontainer();
        rfidcontainer.setRfidCode(request.getRfidCode());
        Rfidcontainer reVals = service.getRfidContainerByRfidCode(rfidcontainer);
        if (!IConstant.DEL_FLAG_1.equals(reVals.getQueryType())) {
            throw new BusinessException(IConstant.WMSG0245, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }*/

        parMap = new HashMap<String, Object>();
        //rfid标签集合
        parMap.put("rfidCodeList", request.getRfidCodeList());
        //标签类型(1单品刀)
        parMap.put("queryType", request.getQueryType());
        //材料号
        parMap.put("toolCode", request.getToolCode());
        //用户ID
        parMap.put("userID", request.getCustomerID());
        //刀具类型（消耗类别）
        parMap.put("toolConsumeType", request.getToolConsumeType());
        //初始化类型（0备用刀，1其它）
        parMap.put("initializeType", request.getInitializeType());
        //手持机ID
        parMap.put("handSetId", request.getHandSetId());
        //用户ID
        parMap.put("customerID", request.getCustomerID());
        //刀具ID
        parMap.put("toolID", request.getToolID());
        Map<String, Object> reVal = iCOMPV01C03S001Service.submitOldRunInItDate(parMap);
        if (reVal.get(IConstant.STATE_CODE) != null) {
            respons.setStateCode(IConstant.STOCK_STATE_1);
            respons.setStateMsg(reVal.get(IConstant.STATE_MSG).toString());
            return respons;
        }
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("提交流转旧刀初始化成功");
        return respons;
    }

    /**
     * 查询待初始化库存新刀
     *
     * @param request
     * @returnC01S010
     * @throws Exception
     */
    @Override
    public C03S001Respons seachInitNewVentory(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        //查询刀具信息
        Tool t = new Tool();
        //查询
        if (IConstant.STRING_0.equals(request.getInfoType())) {
            // 参数验证
            if (StringUtils.isEmpty(request.getRfidCode())) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            Rfidcontainer entity = new Rfidcontainer();
            // RFID标签
            entity.setRfidCode(request.getRfidCode());
            // 删除区分
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            String rfidConner = service.getRfidContainerIDByRfidCode(entity);
            if (null == rfidConner) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("当前标签未初始化");
                return respons;
            }
            Rfidcontainer rc = service.getRfidContainerByRfidCode(entity);
            if (!"1".equals(rc.getQueryType())) {
            	respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("请扫描单品刀具");
                return respons;
			}
            //查询刀具ID(先判断是否能在新刀库存中查找到所需的刀具ID)
            Knifeinventory tt = new Knifeinventory();
            tt.setRfidContainerID(rfidConner);
            tt.setDelFlag(IConstant.DEL_FLAG_0);
            Knifeinventory re = iCOMPV01C03S001Service.getToolCodeByRfidcon(tt);
            if (re == null || re.isRetErrFlag()) {
            	//如果查找不到，再判断能否在流转中查找到所需的刀具ID
            	Tooltransfer tooltransfer = new Tooltransfer();
            	tooltransfer.setRfidContainerID(rfidConner);
            	tooltransfer.setDelFlag(IConstant.DEL_FLAG_0);
            	tooltransfer = iCOMPV01C03S001Service.getToolIDByRfidcon(tooltransfer);
            	if (tooltransfer == null || tooltransfer.isRetErrFlag()) {
            		respons.setStateCode(IConstant.DEL_FLAG_1);
            		respons.setStateMsg("未找到当前标签对应的刀具信息");
            		return respons;
				}else {
					t.setToolID(tooltransfer.getToolID());
				}
            	
            }else {
            	t.setToolID(re.getToolID());
			}
            t.setDelFlag(IConstant.DEL_FLAG_0);
            //查询
        } else {
            if (IConstant.STRING_1.equals(request.getInfoType())) {
                // 参数验证
                if (StringUtils.isEmpty(request.getToolCode())) {
                    throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
                }
                t = new Tool();
                t.setToolCode(request.getToolCode());
                t.setDelFlag(IConstant.DEL_FLAG_0);
            }
        }
        Tool rr = iCOMPV01C03S001Service.getToolIDByToolCode(t);
        if (rr.getToolCode() == null) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到材料号对应信息");
            return respons;
        }
        Vknifeinventoryinfo kentity = new Vknifeinventoryinfo();
        kentity.setToolCode(rr.getToolCode());
        List<Vknifeinventoryinfo> reVal = iCOMPV01C03S001Service.getknifeinventoryinfo(kentity);
        if (reVal == null || reVal.size() < 1) {
            respons.setStateCode(IConstant.STOCK_STATE_1);
            respons.setStateMsg("未查询到当前材料号的相关信息");
            return respons;
        }
        Vknifeinventoryinfo vkinfo = reVal.get(0);
        if (!IConstant.QUERY_TYPE_0.equals(vkinfo.getToolConsumetype())) {
            respons.setStateCode(IConstant.STOCK_STATE_1);
            if (IConstant.STRING_1.equals(request.getInfoType())) {
                respons.setStateMsg("当前材料号不是单品刀具");
            } else {
                respons.setStateMsg("当前标签不是单品刀具");
            }
            return respons;
        }
        //        kentity = new Vknifeinventoryinfo();
        //        kentity.setToolCode(rr.getToolCode());
        //        Vknifeinventoryinfo reEnt = iCOMPV01C03S001Service.getknifeinventoryByToolCode(kentity);
        if (vkinfo == null) {
            //库存数量
            respons.setKnifelnventoryNumber(IConstant.STRING_0);
            respons.setToolCode(rr.getToolCode());
            respons.setToolID(rr.getToolID());
            respons.setLibraryCodeID(rr.getLibraryCodeID());
        } else {
            //库存数量
            respons.setKnifelnventoryNumber(vkinfo.getKnifelnventoryNumber().toString());
            //
            respons.setToolCode(vkinfo.getToolCode());
            respons.setToolID(vkinfo.getToolID());
            respons.setLibraryCodeID(vkinfo.getLibraryCodeID());
        }
        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 提交库存新刀初始化数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons submitNewVentoryInItDate(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (checkParam(request, 2)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        // 不是单品刀具
        if (!IConstant.STRING_1.equals(request.getQueryType())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }

        parMap = new HashMap<String, Object>();
        //1）rfid标签集合
        parMap.put("rfidCodeList", request.getRfidCodeList());
        //2）标签类型(1单品刀)
        parMap.put("queryType", request.getQueryType());
        //3）材料号
        parMap.put("toolCode", request.getToolCode());
        //4）用户ID
        parMap.put("userID", request.getCustomerID());
        //5）刀具ID
        parMap.put("toolID", request.getToolID());
        //6）手持机ID
        parMap.put("handSetId", request.getHandSetId());
        //6）创建人
        parMap.put("customerID", request.getCustomerID());
        Map<String, Object> reVal = iCOMPV01C03S001Service.submitNewVentoryInItDate(parMap);
        if (reVal.get(IConstant.STATE_CODE) != null) {
            respons.setStateCode(IConstant.STOCK_STATE_1);
            respons.setStateMsg(reVal.get(IConstant.STATE_MSG).toString());
            return respons;
        }
        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 按材料号查询库存标签信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons findLibraryCodeMsg(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (StringUtils.isEmpty(request.getToolCode())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        Vknifeinventoryinfo v = new Vknifeinventoryinfo();
        v.setToolCode(request.getToolCode());
        Vknifeinventoryinfo reVal = iCOMPV01C03S001Service.getknifeinventoryinfos(v);
        if (reVal.isRetErrFlag()) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到当前材料号对应的库存信息");
            return respons;
        }
        respons.setToolCode(reVal.getToolCode());
        respons.setToolID(reVal.getToolID());
        if (IConstant.STRING_0.equals(reVal.getToolConsumetype())) {
            respons.setToolConsumeType("可刃磨钻头");
            //respons.setLibraryCodeID(reVal.getLibraryCodeID());
            respons.setStateCode(IConstant.STOCK_STATE_1);
            respons.setStateMsg("单品刀具不能进行标签初始化");
            return respons;
        } else if (IConstant.STRING_1.equals(reVal.getToolConsumetype())) {
            respons.setToolConsumeType("可刃磨刀片");
        } else if (IConstant.STRING_2.equals(reVal.getToolConsumetype())) {
            respons.setToolConsumeType("一次性刀片");
        } else if (IConstant.STRING_9.equals(reVal.getToolConsumetype())) {
            respons.setToolConsumeType("其他");
        }
        respons.setLibraryCodeID(reVal.getLibraryCodeID());
        respons.setStateCode(IConstant.STOCK_STATE_0);
        respons.setStateMsg("查询成功");

        return respons;
    }

    /**
     * 查询当前标签是否已初始化(库位标签)
     *
     * @param request
     * @return
     */
    @Override
    public C03S001Respons findLibraryInitializeMsg(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (StringUtils.isEmpty(request.getRfidCode()) || StringUtils.isEmpty(request.getToolCode()) || StringUtils.isEmpty(request.getQueryType())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        //未初始化
        Rfidcontainer entity = new Rfidcontainer();
        // RFID标签
        entity.setRfidCode(request.getRfidCode());
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        Rfidcontainer reRfid = service.getRfidContainerByRfidCode(entity);
        String rfidContainer = null;
        if (reRfid != null) {
            if (!request.getQueryType().equals(reRfid.getQueryType())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                //  respons.setIsHas(IConstant.BAND_TYPE_1);
                respons.setStateMsg("请扫描库位标签或空标签");
                return respons;
            }
            rfidContainer = reRfid.getRfidContainerID();
        }

        Vknifeinventoryinfo reVal = null;
        if (request.getToolCode() != null) {
            //查询当前刀具标准是否初始化
            Vknifeinventoryinfo vknifeinventoryinfo = new Vknifeinventoryinfo();
            vknifeinventoryinfo.setToolCode(request.getToolCode());
            reVal = iCOMPV01C03S001Service.getIsHasToolInit(vknifeinventoryinfo);
        }
        if (reVal == null) {
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setIsHas(IConstant.BAND_TYPE_0);
            respons.setStateMsg("未找到当前材料号库存信息");
            return respons;
        } else if (reVal.getRfidContainerID() == null) {
            //未初始化库位标签
            if (reRfid == null || rfidContainer == null) {
                //空标签
                respons.setIsHas(IConstant.BAND_TYPE_0);
                respons.setStateCode(IConstant.DEL_FLAG_0);
                return respons;
            } else if (!IConstant.DEL_FLAG_0.equals(reRfid.getQueryType())) {
                //是否已初始化（0未初始化，1已初始化）
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setIsHas(IConstant.BAND_TYPE_1);
                respons.setStateMsg("此标签非库位标签");
                return respons;
            } else {
                //是否已初始化（0未初始化，1已初始化）
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setIsHas(IConstant.BAND_TYPE_1);
                respons.setStateMsg("此标签已初始化");
                return respons;
            }
        } else {
            // 已初始化库位标签并且是当前标签
            respons.setStateCode(IConstant.DEL_FLAG_0);
            respons.setIsHas(IConstant.BAND_TYPE_1);
            respons.setStateMsg("是否要重新初始化");
        }

        return respons;

    }

    /**
     * 提交库存标签初始化数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons submitLibraryCodeMsg(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (checkParam(request, 3)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        try {

            //检查当前是否有载体
            parMap = new HashMap<String, Object>();
            //用户ID
            parMap.put("userID", request.getCustomerID());
            //RFIDCode
            parMap.put("rfidCode", request.getRfidCode());
            //标签类型(0 库位标签)
            parMap.put("queryType", IConstant.DEL_FLAG_0);
            //材料号
            parMap.put("toolCode", request.getToolCode());
            //初始化数量
            parMap.put("knifelnventoryNumber", request.getKnifelnventoryNumber());
            Map<String, Object> reVal = iCOMPV01C03S001Service.submitLibraryCodeMsg(parMap);
            if (reVal.get("stateCode") != null) {
                respons.setStateCode(IConstant.STOCK_STATE_1);
                respons.setStateMsg(reVal.get("stateMsg").toString());
            } else {
                respons.setStateCode(IConstant.STOCK_STATE_0);
                respons.setStateMsg("初始化成功");
            }
        } catch (Exception e) {
            System.err.println("C03S001BusinessImpl+submitLibraryCodeMsg--" + e.toString());
            throw new BusinessException(IConstant.EWMSG0277, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        return respons;
    }

    /**
     * 查询合成刀具组成信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons getSynthesisMsg(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        parMap = new HashMap<String, Object>();
        List<SynthesisEntity> relist = new ArrayList<SynthesisEntity>();
        List<SynthesisEntity> sslist = new ArrayList<SynthesisEntity>();
        SynthesisEntity reEnt = null;
        //判断输入类型
        //输入类型（0:RFID,1合成刀具编码）
        if (IConstant.STRING_0.equals(request.getInfoType())) {
            // 参数验证
            if (StringUtils.isEmpty(request.getRfidCode())) {
                throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
            }
            // 查询刀具载体
            Rfidcontainer rfe = new Rfidcontainer();
            rfe.setRfidCode(request.getRfidCode());
            // 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
            rfe.setDelFlag(IConstant.DEL_FLAG_0);
            Rfidcontainer rfidConner = service.getRfidContainerByRfidCode(rfe);
            if (null == rfidConner) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("当前标签未初始化");
                return respons;
            }
            if (!IConstant.STRING_2.equals(rfidConner.getQueryType())) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("请扫描合成刀具标签");
                return respons;
            }
            //查询合成刀具编码
            Synthesisknife sk = new Synthesisknife();
            sk.setrFID(rfidConner.getRfidContainerID());
            sk.setDelFlag(IConstant.DEL_FLAG_0);
            Synthesisknife rel = iCOMPV01C03S001Service.getSynCodeByRfidConner(sk);
            if (rel == null || rel.getSynthesisParametersCode() == null) {
                respons.setStateMsg("未找到合成刀具编码");
                respons.setStateCode(IConstant.DEL_FLAG_1);
                return respons;
            }
            request.setSynthesisParametersCode(rel.getSynthesisParametersCode());
          /*  SynthesisEntity reEntity = null;
            //合成刀具信息表
            Vgetsynsistoolmsg entity = new Vgetsynsistoolmsg();
            //rfid载体
            entity.setRfidContainerID(rfidConner);
            List<Vgetsynsistoolmsg> reVal = iCOMPV01C03S001Service.getSynLocationMsg(entity);
            if (reVal == null || reVal.size() < 1) {
                respons.setStateMsg("未找到信息");
                respons.setStateCode(IConstant.DEL_FLAG_1);
                return respons;
            }

            for (Vgetsynsistoolmsg re : reVal) {
                reEntity = new SynthesisEntity();
                //材料号
                reEntity.setToolCode(re.getToolCode());
                //类型
                reEntity.setCutterType(re.getCutterType());
                relist.add(reEntity);
            }
            sslist.add(relist.get(0));
            a:
            //数量
            for (SynthesisEntity synthesisEntity : relist) {
                if (synthesisEntity.getCounts() == 0) {
                    boolean addFlag = false;
                    for (SynthesisEntity temp : sslist) {
                        if (synthesisEntity.getToolCode().equals(temp.getToolCode())) {
                            temp.setCounts(temp.getCounts() + 1);
                            synthesisEntity.setCounts(1);
                            addFlag = false;
                            continue a;
                        } else {
                            addFlag = true;
                        }
                    }
                    if (addFlag) {
                        synthesisEntity.setCounts(1);
                        sslist.add(synthesisEntity);
                    }
                }
            }
            respons.setSynthesisParametersCode(rel.getSynthesisParametersCode());
            respons.setSynthesisList(sslist);*/
        }
        if (StringUtils.isEmpty(request.getSynthesisParametersCode())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        //合成刀具编码（输入类型为1时，必须传入）
        parMap.put("synthesisParametersCode", request.getSynthesisParametersCode());
        //按合成刀具编码查询合成刀具信息
        List<Vsynthesisparameters> reVal = iCOMPV01C03S001Service.getSynLocationMsgs(parMap);
        if (reVal == null || reVal.size() < 1) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("未找到当前合成刀具编码信息");
            return respons;
        } else {
            for (Vsynthesisparameters vp : reVal) {
                reEnt = new SynthesisEntity();
                //材料号
                reEnt.setToolCode(vp.getToolCode());
                //数量
                if (null == vp.getTempToolCode()) {
                    vp.setTempToolCode(IConstant.STRING_0);
                }
                reEnt.setCounts(Integer.parseInt(vp.getTempToolCode()));
                //组成类型(0刀片1钻头2复合刀具3热套类)
                reEnt.setCutterType(vp.getToolPic());
                sslist.add(reEnt);
            }
        }
        respons.setSynthesisList(sslist);
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setSynthesisParametersCode(request.getSynthesisParametersCode());
        respons.setStateMsg("查询成功");
        return respons;
    }

    /**
     * 查询要初始化的合成刀具
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons seachInitSynthesisByRfid(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        // 参数验证
        if (StringUtils.isEmpty(request.getRfidCode()) || StringUtils.isEmpty(request.getQueryType())) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        // 0未初始化，1已初始化，2非合成刀具标签
        //查询载体ID
        Rfidcontainer entity = new Rfidcontainer();
        // RFID标签
        entity.setRfidCode(request.getRfidCode());
        // 删除区分
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        Rfidcontainer rfidcontainer = service.getRfidContainerByRfidCode(entity);

        if (null == rfidcontainer) {
            respons.setStateCode(IConstant.STOCK_STATE_0);
            respons.setStateMsg("标签未初始化");
            return respons;
        } else if (!IConstant.STRING_2.equals(rfidcontainer.getQueryType())) {
            respons.setStateCode(IConstant.STOCK_STATE_2);
            respons.setStateMsg("请扫描合成刀具标签或空标签");
            return respons;
        } else {
            //根据载体ID查询合成刀具编码
            Synthesisknife skentity = new Synthesisknife();
            //载体ID
            skentity.setrFID(rfidcontainer.getRfidContainerID());
            skentity.setDelFlag(IConstant.DEL_FLAG_0);
            Synthesisknife reVal = iCOMPV01C03S001Service.getSynCodeByRfidConner(skentity);
            if (null == reVal) {
                respons.setStateCode(IConstant.STOCK_STATE_2);
                respons.setStateMsg("标签非合成刀具");
                return respons;
            }
            //1已初始化
            respons.setSynthesisParametersCode(reVal.getSynthesisParametersCode());
            respons.setStateCode(IConstant.DEL_FLAG_1);
        }
        return respons;
    }

    /**
     * 提交初始化合成刀具信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public C03S001Respons submitInitSynthesis(C03S001Request request) throws Exception {
        C03S001Respons respons = new C03S001Respons();
        if (checkParam(request, 4)) {
            throw new BusinessException(IConstant.CEMSG0005, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_CODE_ZH);
        }
        //rfidCodeList
        List<String> toolCodeList = new ArrayList<String>();
        //合成刀具编码
        toolCodeList.add(request.getSynthesisParametersCode());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rfidList", request.getRfidCodeList());
        map.put("toolCodeList", toolCodeList);
        map.put("customerID", request.getCustomerID());
        map.put("handSetId", request.getHandSetId());
        Map<String, Object> ret = iCOMPV01C03S001Service.submitInitSynthesis(map);
        if (ret.get("messagetext") != null) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg(ret.get("messagetext").toString());
            return respons;
        }
        if (ret.size() < 0) {
            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("提交成功了");
        return respons;
    }

    /**
     * 参数验证
     *
     * @param request
     * @param i
     * @return
     */

    private boolean checkParam(C03S001Request request, int i) {
        // 用户ID
        if (StringUtils.isEmpty(request.getCustomerID())) {
            return true;
        }
        if (i == 2 || i == 1 || i == 3) {
            //材料号
            if (StringUtils.isEmpty(request.getToolCode())) {
                return true;
            }
        }
        if (i == 2) {
            if (request.getRfidCodeList() == null || "".equals(request.getRfidCodeList())) {
                return true;
            } else {
                request.setRfidCodeList(service.checkList(request.getRfidCodeList()));
            }
            //刀具ID
            if (StringUtils.isEmpty(request.getToolID())) {
                return true;
            }
        }
        if (i == 1) {
            if (request.getRfidCodeList() == null || request.getRfidCodeList().size() < 1) {
                return true;
            } else {
                request.setRfidCodeList(service.checkList(request.getRfidCodeList()));
            }
            //刀具类型（消耗类别）
            if (StringUtils.isEmpty(request.getToolConsumeType())) {
                return true;
            }
            //初始化类型（0备用刀，1其它）
            if (StringUtils.isEmpty(request.getInitializeType())) {
                return true;
            }

        }
        if (i == 3) {
            //库存数量
            if (StringUtils.isEmpty(request.getKnifelnventoryNumber())) {
                return true;
            }
            //库存数量
            if (StringUtils.isEmpty(request.getQueryType())) {
                return true;
            }
            //库存数量
            if (StringUtils.isEmpty(request.getRfidCode())) {
                return true;
            }
        }
        if (i == 4) {
            if (request.getRfidCodeList() == null || request.getRfidCodeList().size() < 1) {
                return true;
            } else {
                request.setRfidCodeList(service.checkList(request.getRfidCodeList()));
            }
            if (StringUtils.isEmpty(request.getSynthesisParametersCode())) {
                return true;
            }
        }
        return false;
    }


}
