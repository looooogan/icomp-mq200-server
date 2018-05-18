package com.icomp.wsdl.v01c01.c01s004.business.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s003.ICOMPV01C01S003Service;
import com.icomp.common.service.icomp.v01c01.s004.ICOMPV01C01S004Service;
import com.icomp.common.service.icomp.v01c01.s010.ICOMPV01C01S010Service;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Replacement;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Vgetboxmessage;
import com.icomp.entity.base.Vgetshelfinformation;
import com.icomp.entity.base.Vreplacement;
import com.icomp.wsdl.v01c01.c01s003.endpoint.TempToolTransfer;
import com.icomp.wsdl.v01c01.c01s004.business.C01S004Business;
import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Request;
import com.icomp.wsdl.v01c01.c01s004.endpoint.C01S004Respons;
import com.icomp.wsdl.v01c01.c01s004.endpoint.ReplacementApply;
import com.icomp.wsdl.v01c01.c01s004.endpoint.ReplacementApplyInfo;
import com.icomp.wsdl.v01c01.c01s004.endpoint.ReplacementToolInfo;

/**
 * 补领出库Business实现类
 *
 * @author Taoyy
 * @ClassName: C01S004BusinessImpl
 * @date 2016-3-8 下午01:42:04
 */
public class C01S004BusinessImpl implements C01S004Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S004Service iCOMPV01C01S004Service;
    private ICOMPV01C01S010Service icompv01c01s010Service;
    private ICOMPV01C01S003Service iCOMPV01C01S003Service;

    public void setiCOMPV01C01S004Service(ICOMPV01C01S004Service iCOMPV01C01S004Service) {
        this.iCOMPV01C01S004Service = iCOMPV01C01S004Service;
    }

    public void setIcompv01c01s010Service(ICOMPV01C01S010Service icompv01c01s010Service) {
        this.icompv01c01s010Service = icompv01c01s010Service;
    }

    public void setiCOMPV01C01S003Service(ICOMPV01C01S003Service iCOMPV01C01S003Service) {
        this.iCOMPV01C01S003Service = iCOMPV01C01S003Service;
    }

    /**
     * 生成申领单号
     * getApplyNumber
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S004Respons getApplyNumber(C01S004Request request) throws Exception {
        C01S004Respons respons = new C01S004Respons();
        // 获取生成申领单号
        String replacementID = iCOMPV01C01S004Service.getApplyNumber(request.getCustomerID());
        if (replacementID.length() < 1) {
            // 获取失败
            throw new BusinessException(IConstant.CEMSG0008, request.getLanguageCode(), request.getLanguageValue());
        } else {
            // 获取成功
            respons.setStatus(IConstant.RESULT_CODE_0);
            respons.setMessageText(IConstant.CIMSG0019, request.getLanguageCode(), request.getLanguageValue());
            respons.setReplacementID(replacementID);
        }
        return respons;
    }

    /**
     * 取得待申领刀具信息
     * getApplyToolInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S004Respons getApplyToolInfo(C01S004Request request) throws Exception {
        C01S004Respons respons = new C01S004Respons();// 返回数据
        Replacement replacement = new Replacement();
        Map<String, Object> map = new HashMap<String, Object>();
        List<ReplacementToolInfo> reList = new ArrayList<ReplacementToolInfo>();
        // 参数验证
        if (chickParams(request, 0)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }
        // 赋值
        map.put("toolCood", request.getToolCode());// 刀具编码
        map.put("liberCocd", request.getLibraryCode());//库位码
        map.put("appleNumber", request.getAppliedNumber());// 申请数量

        // 取得待申领刀具信息
        List<Vgetshelfinformation> list = iCOMPV01C01S004Service.getApplyToolInfo(map);
        // 处理区分(true:成功 false:失败)
        if (list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        } else {
            ReplacementToolInfo info = null;
            for (Vgetshelfinformation vs : list) {
                info = new ReplacementToolInfo();
                info.setExistingNumber_A(vs.getA_inverntoryCount().intValue());
                info.setExistingNumber_B(vs.getB_inverntoryCount().intValue());
                info.setLayer(vs.getLayerText());
                if(vs.getCustomerCode() != null){
                	info.setLibraryCode(vs.getCustomerCode());
                }else{
                    info.setLibraryCode(vs.getSysteCode());
                }
                info.setShelf(vs.getShelfText());
                info.setStack(vs.getStackText());
                reList.add(info);
            }
            respons.setToolCode(list.get(0).getToolCode());
            respons.setReplacementToolInfoList(reList);
            respons.setStatus(IConstant.RESULT_CODE_0);
            //待申领刀具信息取得成功
            respons.setMessageText(IConstant.CIMSG0020, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 扫描rfid，取得当前rfid对应的信息
     * saveStockingToolStauts
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S004Respons getRfidToolInfo(C01S004Request request) throws Exception {
        C01S004Respons respons = new C01S004Respons();// 返回数据
        Vgetboxmessage entity = new Vgetboxmessage();
        List<ReplacementToolInfo> reList = new ArrayList<ReplacementToolInfo>();
        // 参数验证
        if (chickParams(request, 3)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }

        //判断扫描的刀具类型
        if (request.getRfidString() != null) {
            String toolType = service.getToolsTypeByRfid(request.getRfidString());
            if (toolType.equals(IConstant.TOOL_KIND_0)) { //未初始化
                throw new BusinessException(IConstant.WMSG0247, request.getLanguageCode(), request.getLanguageValue());
            }
            if (!toolType.equals(IConstant.TOOL_KIND_2)) {
                throw new BusinessException(IConstant.WMSG0245, request.getLanguageCode(), request.getLanguageValue());
            }
        }

        // 刀具编码
        entity.setRfidCode(request.getRfidString());
        // 查询单品刀具信息
        //List<Vgetboxmessage> lists = icompv01c01s010Service.getBoxMessage(entity);
        List<Vgetboxmessage> lists = null;
        if (lists.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(lists.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        }
        // 取得货架信息
        Vgetshelfinformation entity1 = new Vgetshelfinformation();
        entity1.setToolCode(lists.get(0).getToolCode());// 刀具编码
        List<Vgetshelfinformation> shelfList = iCOMPV01C01S003Service.getRedemptionToolInfo(entity1);
        if (shelfList.get(0).isRetErrFlag()) {
            // 查询失败
            throw new BusinessException(shelfList.get(0).getMessageCode(), request.getLanguageCode(), request.getLanguageValue());
        } else {
            // 查询成功
            ReplacementToolInfo rtInfo = null;
            for (Vgetshelfinformation info : shelfList) {
                rtInfo = new ReplacementToolInfo();
                rtInfo.setLibraryCode(info.getLibraryCodeID());// 入库码
                rtInfo.setLayer(info.getLayerText());// 层
                rtInfo.setShelf(info.getShelfText());// 货架
                rtInfo.setStack(info.getStackText());// 货位
                rtInfo.setExistingNumber_A(info.getA_inverntoryCount().intValue());// A库
                rtInfo.setExistingNumber_B(info.getB_inverntoryCount().intValue());// B库
                reList.add(rtInfo);
            }
            respons.setReplacementToolInfoList(reList);
            respons.setToolCode(lists.get(0).getToolCode());
            respons.setToolCount(lists.size());
            respons.setStatus(IConstant.RESULT_CODE_0);
            //当前rfid对应的信息查询成功
            respons.setMessageText(IConstant.CIMSG0021, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 更新备货刀具状态
     * saveStockingToolStauts
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S004Respons saveStockingToolStauts(C01S004Request request) throws Exception {
        C01S004Respons respons = new C01S004Respons();// 返回数据
        @SuppressWarnings("unused")
        Vreplacement entity = new Vreplacement();// VIEW实体类
        return respons;
    }

    /**
     * 用旧RFID换新的
     * saveOutputStockingTool
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S004Respons saveOutputStockingTool(C01S004Request request) throws Exception {
        C01S004Respons respons = new C01S004Respons();
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            // 参数验证
            if (chickParams(request, 4)) {
                throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
            }
            map.put("newRfid", request.getNewRfidString());
            map.put("oldRfid", request.getRfidString());
            map.put("tempNumbe", request.getAppliedNumber());
            map.put("userId", request.getCustomerID());
            map.put("BusinessCode", IConstant.C01S004);
            // 新旧RFID交换
            boolean reVal = service.saveSplitBoxTool(map);
            if (reVal) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.CIMSG0022, request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.CEMSG0010, request.getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            throw new BusinessException(IConstant.CEMSG0010, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 申领结束，记录申请单
     * saveApplyInfo
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S004Respons saveApplyInfo(C01S004Request request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        C01S004Respons respons = new C01S004Respons();// 返回数据
        List<Replacement> replacementList = new ArrayList<Replacement>();
        // 参数验证
        if (chickParams(request, 1)) {
            throw new BusinessException(IConstant.CEMSG0005, request.getLanguageCode(), request.getLanguageValue());
        }

        Replacement rep = null;
        for (TempToolTransfer tt : request.getToolTransfers()) {
            rep = new Replacement();
            rep.setReplacementID(request.getReplacementID());
            rep.setToolCode(tt.getToolCode());
            rep.setAppliedNumber(new BigDecimal(tt.getAppliedNumber()));
            rep.setApplyUser(request.getGruantUserID());//申请人=授权人
            rep.setApplyTime(new Date());
            rep.setReplacementReason(request.getAppliendReason() + "");//申领原因
            rep.setReceiveTime(new Date());
            rep.setReceiveUser(request.getGruantUserID());
            rep.setProcessingStatus(IConstant.PROCESSING_STATUS_1);//申领状态
            rep.setReplacementFlag(request.getAppliendReason() + ""); //申领区分(0扩能1外借2工艺试验)
            rep.setUpdateUser(request.getCustomerID());
            rep.setUpdateTime(new Date());
            rep.setDelFlag(IConstant.DEL_FLAG_0);
            rep.setCreateTime(new Date());
            rep.setCreateUser(request.getCustomerID());
            rep.setVersion(BigDecimal.ZERO);
            replacementList.add(rep);
        }
        map.put("rfidList", request.getRfidList()); //所有扫描的RFID
        map.put("userId", request.getCustomerID()); //操作人
        map.put("gruantUserID", request.getGruantUserID());//授权人
        map.put("appliendReason", request.getAppliendReason());//申请原因
        map.put("replacementList", replacementList);//申领信息
        map.put("handerId", request.getHandSetId());

        // 申领结束，更新申请单
        try {
            int reVal = iCOMPV01C01S004Service.saveApplyInfo(map);
            if (reVal > 0) {
                respons.setStatus(IConstant.RESULT_CODE_0);
                respons.setMessageText(IConstant.CIMSG0023, request.getLanguageCode(), request.getLanguageValue());
            } else {
                throw new BusinessException(IConstant.CEMSG0012, request.getLanguageCode(), request.getLanguageValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(IConstant.CEMSG0012, request.getLanguageCode(), request.getLanguageValue());
        }
        return respons;
    }

    /**
     * 参数验证
     *
     * @return
     */
    private boolean chickParams(C01S004Request request, int state) {
        boolean retParams = false;
        if (request.getCustomerID() == null || request.getCustomerID() == "") {
            retParams = true;// 用户ID
        }
        if (request.getLanguageCode() == null || request.getLanguageCode() == "") {
            retParams = true;// 语言编码（01）
        }
        if (request.getLanguageValue() == null || request.getLanguageValue() == "") {
            retParams = true;// 语言值（zh_en）
        }
        if (state == 0) {
            if (request.getReplacementID() == null || request.getReplacementID() == "") {
                retParams = true;// 刀具编码
            }
        }
        if (state == 1) {
            if (request.getRfidList() == null) {
                retParams = true; //RFID的List
            }
            if (request.getToolTransfers() == null) {
                retParams = true; //申请的详细信息
            }
            if (request.getReplacementID() == null || request.getReplacementID() == "") {
                retParams = true;// 申请id
            }
        }
        if (state == 3) {
            if (request.getRfidString() == null || request.getRfidString() == "") {
                retParams = true;// 扫描RFID
            }
        }
        if (state == 4) {
            if (request.getNewRfidString() == null || request.getNewRfidString() == "") {
                retParams = true;// 新RFID
            }

            if (request.getRfidString() == null || request.getRfidString() == "") {
                retParams = true;// 旧RFID
            }
            if (request.getAppliedNumber() == 0) {
                retParams = true;// 交换数量
            }

        }
        return retParams;
    }

    /**
     * 取得补领出库申请列表
     * getReplacementList
     *
     * @param request
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	@Override
	public C01S004Respons getReplacementList(C01S004Request request)
			throws Exception {
		C01S004Respons respons = new C01S004Respons();
		// 时间格式化
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> rtn = iCOMPV01C01S004Service.getReplacementList();
		if (Integer.parseInt(rtn.get("status").toString()) < 0) {
			throw new BusinessException(IConstant.EMSG0004_A, request
					.getLanguageCode(), request.getLanguageValue());
		}
		List<Replacement> list = (List<Replacement>) rtn
				.get("data");
		respons.setStatus(Integer.parseInt(rtn.get("status").toString()));
		List<Map<String, Object>> replacementList = new ArrayList<Map<String,Object>>();
		//将申请时间由Date类型转化为String类型
		for (Replacement replacement : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("applyUser", replacement.getApplyUser());
			map.put("applyTime", replacement.getApplyTime()==null?"":format.format(replacement.getApplyTime()));
			replacementList.add(map);
		}
		respons.setrList(replacementList);
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("取得补领列表成功");
		return respons;
	}

	/**
     * 取得补领出库申请单信息
     * getReplacementApply
     *
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public C01S004Respons getReplacementApply(C01S004Request request)
			throws Exception {
		C01S004Respons respons = new C01S004Respons();
//		Replacement entity = new Replacement();
		// 参数验证
		if (StringUtils.isEmpty(request.getApplyUser())
				|| StringUtils.isEmpty(request.getApplyTime())) {
			throw new BusinessException(IConstant.WMSG0221,
					IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
		}
		// 姓名
//		entity.setApplyUser(request.getApplyUser());
		// 删除区分(0有效1删除)
//		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 验证用户是否存在
//		Replacement userdetail = iCOMPV01C01S004Service.searchUserExitq(entity);
//		if (userdetail.isRetErrFlag()) {
//			throw new BusinessException(userdetail.getMessageCode(),
//					IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
//		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 申请人名称
		map.put("applyUser", request.getApplyUser());
		// 申请时间
		map.put("applyTime", request.getApplyTime());
		// 查询补领申请表
		Map<String, Object> rtn = iCOMPV01C01S004Service.getReplacementApply(map);
		List<Replacement> list = (List<Replacement>) rtn.get("data");
		List<ReplacementApplyInfo> rep = new ArrayList<ReplacementApplyInfo>();
		for (Replacement ra : list) {
            ReplacementApplyInfo ap = new ReplacementApplyInfo();
            // 补领单号
            ap.setReplacementNumber(ra.getReplacementID());
			// 刀具ID
			ap.setToolID(ra.getExpandSpace1());
			// 材料号
			ap.setMaterialNum(ra.getToolCode());
			// 库位码
			ap.setLibraryCodeID(ra.getExpandSpace2());
			// 申请数量
			ap.setAppliedCount(ra.getAppliedNumber().toString());
            //消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他)
            ap.setToolType(ra.getExpandSpace4());
			rep.add(ap);
		}
		respons.setStatus(Integer.parseInt(rtn.get("status").toString()));
		respons.setReplacementApplyInfoList(rep);
        respons.setStateCode(IConstant.DEL_FLAG_0);
        respons.setStateMsg("取得补领列表信息成功");
		return respons;
	}

	/**
     * 取得要补领出库的刀具信息
     * getReplacementTool
     *
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public C01S004Respons getReplacementTool(C01S004Request request)
			throws Exception {
		C01S004Respons respons = new C01S004Respons();
		Rfidcontainer entity = new Rfidcontainer();
		// 参数验证
		if (StringUtils.isEmpty(request.getCustomerID())
				|| StringUtils.isEmpty(request.getRfidCode())
				|| StringUtils.isEmpty(request.getQueryType())) {
			throw new BusinessException(IConstant.WMSG0221,
					IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
		}
		// 0库位标签
//		if (IConstant.DEL_FLAG_0.equals(request.getQueryType())) {
//			// 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
//			entity.setQueryType(IConstant.DEL_FLAG_0);
//		}else if(IConstant.DEL_FLAG_1.equals(request.getQueryType())){
//			// 标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
//			entity.setQueryType(IConstant.DEL_FLAG_1);
//		}
		// RFID标签
		entity.setRfidCode(request.getRfidCode());
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
		if (StringUtils.isEmpty(RfidContainerID)) {
			respons.setStateCode(IConstant.STRING_1);
			respons.setStateMsg("当前标签未初始化");
			return respons;
		}
		// 新刀库存表
		Knifeinventory kfentity = new Knifeinventory();
		// RFID标签
		kfentity.setRfidContainerID(RfidContainerID);
		// 删除区分
		kfentity.setDelFlag(IConstant.DEL_FLAG_0);
		// 取得刀具ID和库存数量
		Knifeinventory knifeinventory = iCOMPV01C01S003Service.searchToolIn(kfentity);
		if (knifeinventory.isRetErrFlag()) {
			respons.setStateCode(IConstant.USER_BLOOD_GROUP_2);
			respons.setStateMsg("未找到库存信息");
			return respons;
		}else{
			// 取得要补领出库的刀具信息
			Tool tool = new Tool();
			tool.setToolID(knifeinventory.getToolID());
			tool = iCOMPV01C01S003Service.getRedemptionapplyInfo(tool);
			if (tool.isRetErrFlag()) {
				respons.setStateCode(IConstant.USER_BLOOD_GROUP_2);
				respons.setStateMsg("未找到要补领出库的刀具信息");
				return respons;
			}else{
				// 新刀库存表
            	Knifeinventory ki = new Knifeinventory();
            	ki.setToolID(knifeinventory.getToolID());
            	ki.setDelFlag(IConstant.STRING_0);
            	List<Knifeinventory> kiList = iCOMPV01C01S003Service.getKnifeinventoryInfo(ki);
            	if (kiList == null && kiList.isEmpty()) {
            		respons.setStateCode(IConstant.USER_BLOOD_GROUP_2);
                    respons.setStateMsg("库存中找不到相应的刀具信息");
                    return respons;
				}else {
					// 库存量
					int sum = 0;
					if (IConstant.STRING_0.equals(tool.getToolConsumetype())) {
						//钻头
						sum = kiList.size();
					}else {
						//刀片
						for (Knifeinventory ki2 : kiList) {
							sum = sum + Integer.parseInt(ki2.getKnifelnventoryNumber());
						}
					}
				
				// 刀具ID
				respons.setToolID(tool.getToolID());
				//材料号
				respons.setMaterialNum(tool.getToolCode());
				//库存量
				respons.setInventory(sum+"");
				//刀具类型（实际为刀具消耗类别：(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他）
				respons.setToolType(tool.getToolConsumetype());

				//库位码
				respons.setLibraryCodeID(tool.getLibraryCodeID());

                respons.setToolGrinding(tool.getToolGrinding());
				}		
			}
		}
		respons.setStateCode(IConstant.STOCK_STATE_0);
		respons.setStateMsg("取得成功");
		return respons;
	}

	/**
     * 提交补领出库的刀具信息
     * saveReplacementTool
     *
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public C01S004Respons saveReplacementTool(C01S004Request request)
			throws Exception {
		C01S004Respons respons = new C01S004Respons();
		Rfidcontainer entity = new Rfidcontainer();
		// 参数验证
		if (StringUtils.isEmpty(request.getCustomerID())
				|| StringUtils.isEmpty(request.getGruantUserID())) {
			throw new BusinessException(IConstant.WMSG0221,
					IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
		}

        List<Map<String, Object>> toolList = new ArrayList<Map<String, Object>>();

        for (ReplacementApply ra : request.getReplacementApplyInputList()) {
		// RFID标签
		entity.setRfidCode(ra.getRfidCode());
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
		if (StringUtils.isEmpty(RfidContainerID)) {
			throw new BusinessException("未找到相应的RFID载体");
		}
		// 取得前台扫描的列表
		Map<String, Object> map = new HashMap<String, Object>();


		
			if (request.getReplacementApplyInputList() != null) {

                Map<String, Object> re = new HashMap<String, Object>();
                // 条件
                re.put("ToolID", ra.getToolID());// 刀具ID
                re.put("RfidCode", ra.getRfidCode());// RFID标签
                re.put("MaterialNum", ra.getMaterialNum());// 材料号
                re.put("AppliedNumber", ra.getAppliedNumber());// 申请数量
                re.put("ReceiveCount", ra.getReceiveCount());// 出库数量
                re.put("CustomerID", request.getCustomerID());
                re.put("gruantUserID", request.getGruantUserID());// 授权人id
                re.put("HandSetID", request.getHandSetId());
                re.put("SignID", request.getGruantUserID());
                re.put("RfidContainerID", RfidContainerID);
                re.put("ReplacementNumber", ra.getReplacementNumber());
                toolList.add(re);
            }
			}
        
      //补领出库签收，不需要授权
//        if (request.getGruantUserID() != null) {
//            //授权记录插入
//            Authorization auth = new Authorization();
//            //授权人ID
//            auth.setAuthorizationUserID(request.getGruantUserID());
//            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
//            auth.setAuthorizedReason(IConstant.STRING_2);
//            //刀具类型（0单品，1合成刀具）
//            auth.setTooltype(IConstant.DEL_FLAG_0);
//            //材料号或合成刀具编码
//            auth.setToolCode(request.getToolCode());
//            //业务流程编码
//            auth.setBusinessCode("C01S004");
//            auth.setCreateUserID(request.getCustomerID());
//            //备注
//            auth.setNote("补领出库");
//            service.innsetGruant(auth);
//        }

			// 提交补领出库的刀具信息
			Map<String, Object> ret = iCOMPV01C01S004Service.saveReplacementapplyInfo(toolList);
			if (Integer.parseInt(ret.get("status").toString()) < 0) {
				throw new BusinessException(ret.get("messagetext").toString(),
						request.getLanguageCode(), request.getLanguageValue());
			}
			respons.setStateCode(ret.get("status").toString());
			respons.setStateMsg(ret.get("messagetext").toString());
		return respons;
	}
}
