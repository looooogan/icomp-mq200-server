package com.icomp.wsdl.v01c01.c01s016.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s010.ICOMPV01C01S010Service;
import com.icomp.common.service.icomp.v01c01.s016.ICOMPV01C01S016Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.wsdl.v01c01.c01s016.business.C01S016Business;
import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Request;
import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Respons;
import com.icomp.wsdl.v01c01.c01s016.endpoint.InputTool;
import com.icomp.wsdl.v01c01.c01s016.endpoint.ToolJoint;

import org.apache.cxf.common.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具回库-Business实现类
 * 
 * @author Taoyy
 * @ClassName: C01S016BusinessImpl
 * @date 2016-3-1 下午03:14:41
 */
@SuppressWarnings("unchecked")
public class C01S016BusinessImpl implements C01S016Business {

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	private ICOMPV01C01S016Service iCOMPV01C01S016Service;

	public void setiCOMPV01C01S016Service(
			ICOMPV01C01S016Service iCOMPV01C01S016Service) {
		this.iCOMPV01C01S016Service = iCOMPV01C01S016Service;
	}
	
	private ICOMPV01C01S010Service iCOMPV01C01S010Service;

	public void setiCOMPV01C01S010Service(
			ICOMPV01C01S010Service iCOMPV01C01S010Service) {
		this.iCOMPV01C01S010Service = iCOMPV01C01S010Service;
	}

	public C01S016Respons getToolInfo(C01S016Request request) throws Exception {
		// 判断扫描的刀具类型
		if (request.getRfidString() != null
				&& !"".equals(request.getRfidString().trim())) {
			String toolType = service.getToolsTypeByRfid(request
					.getRfidString());
			if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
				throw new BusinessException(IConstant.WMSG0247, request
						.getLanguageCode(), request.getLanguageValue());
			}
			if (!toolType.equals(IConstant.TOOL_KIND_2)) {
				throw new BusinessException(IConstant.WMSG0245, request
						.getLanguageCode(), request.getLanguageValue());
			}
		}

		C01S016Respons respons = new C01S016Respons();
		// 取得并判断刀具当前扫描刀具是否可以进行【旧刀入库交接】业务
		Map<String, Object> ret = service.checkToolStauts(request
				.getRfidString(), "C01S016", request.getLanguageCode());
		if (ret.size() > 0
				&& !(Boolean.valueOf(ret.get("agreeFlag").toString())
						.booleanValue())) {
			if (ret.get("messageText") == null) {
				throw new BusinessException((String) ret.get("messageCode"),
						request.getLanguageCode(), request.getLanguageValue());
			} else {
				throw new BusinessException((String) ret.get("messageCode"),
						request.getLanguageCode(), request.getLanguageValue(),
						(String) ret.get("newFlowText"), (String) ret
								.get("lastFlowText"), (String) ret
								.get("messageText"));
			}
		}

		ret = iCOMPV01C01S016Service.getToolInfo(request.getRfidString(),
				request.getLanguageCode());
		if (Integer.parseInt(ret.get("status").toString()) < 0) {
			throw new BusinessException(ret.get("messageCode").toString(),
					request.getLanguageCode(), request.getLanguageValue());
		}
		if (ret.get("ToolCode") != null) {
			respons.setToolCode(ret.get("ToolCode").toString());// 刀具编码
		}
		if (ret.get("LostCount") != null) {
			respons.setLostCount(Integer.parseInt(ret.get("LostCount")
					.toString()));// 送回数量
		}

		if (ret.get("ToolStatus") != null) {
			respons.setToolStatus(ret.get("ToolStatus").toString());// 刀具状态
		}
		if (ret.get("ToolStatusText") != null) {// 刀具状态名称
			respons.setToolStatusText(MessageReSource.getMessageBox(ret.get(
					"ToolStatusText").toString(), request.getLanguageCode(),
					request.getLanguageValue()));
		}
		if (ret.get("ReplacementFlag") != null) {
			respons.setReplacementFlag(ret.get("ReplacementFlag").toString());// 处理方式
		}
		if (ret.get("ReplacementFlagText") != null) {// 处理方式名称
			respons.setReplacementFlagText(ret.get("ReplacementFlagText")
					.toString());
		}
		if (ret.get("SentBackNumber") != null) {
			respons.setSentBackNumber(Integer.parseInt(ret
					.get("SentBackNumber").toString()));// 领取数量
		}
		if (ret.get("ToolRepairNoticeID") != null) {
			respons.setToolRepairNoticeID(ret.get("ToolRepairNoticeID")
					.toString());// 修复通知单号
		}
		if (ret.get("IdentifyingUserId") != null) {
			respons.setIdentifyingUserId(ret.get("IdentifyingUserId")
					.toString());// 确认人
			respons.setIdentifyingUserText(service.getUserName(ret.get(
					"IdentifyingUserId").toString()));
		}
		respons.setStatus(IConstant.RESULT_CODE_0);
		return respons;
	}

	/**
	 * 非单品-回库处理
	 */
	public C01S016Respons getToolInfoDetail(C01S016Request request)
			throws Exception {

		C01S016Respons respons = new C01S016Respons();
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("rfidString", request.getRfidString());
		rtn.put("request", request);
		String toolType = service.getToolsTypeByRfid(request.getRfidString());
		if (toolType.equals(IConstant.TOOL_KIND_0)) { // 未初始化
			throw new BusinessException(IConstant.WMSG0247, request
					.getLanguageCode(), request.getLanguageValue());
		}
		// 0:非容器 1:正常容器 2:报废容器 3:空容器
		toolType = service.getToolsContainerByRfid(request.getRfidString(),
				request.getCustomerID());
		if (toolType.equals(IConstant.TOOL_KIND_0)) {
			throw new BusinessException(IConstant.WMSG0247_1, request
					.getLanguageCode(), request.getLanguageValue());
		}
		if (toolType.equals(IConstant.TOOL_KIND_3)) {
			throw new BusinessException(IConstant.WMSG0247_2, request
					.getLanguageCode(), request.getLanguageValue());
		}
		if (!toolType.equals(IConstant.STSATIC_TWO)) {
			// 可刃磨刀具不能从对刀室直接进行回库处理
			throw new BusinessException(IConstant.WMSG0247_3, request
					.getLanguageCode(), request.getLanguageValue());
		}

		Map<String, Object> ret = iCOMPV01C01S016Service.getToolInfoDetail(rtn);
		if (Integer.parseInt(ret.get("status").toString()) < 0) {
			throw new BusinessException(ret.get("messageCode").toString(),
					request.getLanguageCode(), request.getLanguageValue());
		}
		if (ret.get("ToolCode") != null) {
			respons.setToolCode(ret.get("ToolCode").toString());// 刀具编码
		}
		if (ret.get("ToolThisState") != null) {
			respons.setToolThisState(ret.get("ToolThisState").toString());// 刀具部门
		}
		respons.setStatus(IConstant.RESULT_CODE_0);
		List<Tooltransfer> tooltransferList = (List<Tooltransfer>) ret
				.get("ToolInfoDetailList");
		respons.setToolInfoDetailList(tooltransferList);
		return respons;
	}

	/**
	 * 非单品-回库处理-刀具回库
	 */
	public C01S016Respons saveToolInfoDetail(C01S016Request request)
			throws Exception {
		Map<String, Object> ret;
		C01S016Respons respons = new C01S016Respons();
		Map<String, Object> rtn = new HashMap<String, Object>();

		rtn.put("request", request);
		// 用户id
		String userId = request.getCustomerID();
		String handerId = request.getHandSetId();
		// 申请人
		String gruantUserID = request.getGruantUserID();
		// 载体id
		rtn .put("rfidContarnerId", service.getrfidContainerIdByRfid(request
				.getRfidString()));
		// userId
		rtn.put("userId", request.getCustomerID());
		rtn.put("handerId", handerId);
		try {
			// --------------建立换领申请-----start-----
			for (Tooltransfer element : request.getToolInfoDetailList()) {
				rtn.put("redemptionapplied", element.getToolThisState());// 刀具部门(0库存,1对刀室,2刃磨室,3车间)
				Redemptionapplied entity = new Redemptionapplied();
				entity.setToolCode(element.getExpandSpace3());// 刀具编码
				entity.setAppliedNumber(new BigDecimal(element
						.getExpandSpace4()));// 申请数量
				entity.setRedemptionAppliedID(NextKeyValue.getNextkeyvalueNo(
						IConstant.REDEMPTION_APPLIED,
						IConstant.REDEMPTION_APPLIED_ID, userId));
				entity.setApplyTime(new Date());
				entity.setApplyUser(gruantUserID);
				entity.setStockNumber(BigDecimal.ZERO);
				entity.setReturnNumber(BigDecimal.ZERO);
				entity.setReceiveNumber(BigDecimal.ZERO);
				entity.setBrokenNumber(BigDecimal.ZERO);
				entity.setLostNumber(StringUtils.isEmpty(element
						.getExpandSpace2()) ? BigDecimal.ZERO : new BigDecimal(
						element.getExpandSpace2().toString()));// 丢失数量
				entity.setProcessingStatus(IConstant.PROCESSING_STATUS_0);
				entity.setDelFlag(IConstant.DEL_FLAG_0);
				entity.setUpdateTime(new Date());
				entity.setUpdateUser(userId);
				entity.setCreateTime(new Date());
				entity.setCreateUser(userId);
				entity.setVersion(BigDecimal.ZERO);
				rtn.put("redemptionapplied", entity);// 插入换领申请对象
				ret = iCOMPV01C01S016Service.saveToolInfoDetail(rtn);

				if (Integer.parseInt(ret.get("status").toString()) < 0) {
					throw new BusinessException(ret.get("messageCode")
							.toString(), request.getLanguageCode(), request
							.getLanguageValue());
				}
				rtn.put("toolCode", element.getExpandSpace3());// 刀具编码
				rtn.put("toolId", element.getToolID());// 刀具编码
				rtn.put("suerNum", element.getExpandSpace1());// 确认数量
				rtn.put("lostNum", element.getExpandSpace2());// 丢失数量
				rtn.put("appliedNumber", element.getExpandSpace4());// 申请数量
				rtn.put("gruantUserID", gruantUserID);// 授权人
				// 更新流转表
				ret = iCOMPV01C01S016Service.updateTooltransfer(rtn);
				if (Integer.parseInt(ret.get("status").toString()) < 0) {
					throw new BusinessException(ret.get("messageCode")
							.toString(), request.getLanguageCode(), request
							.getLanguageValue());
				}
			}// --------------建立换领申请-----end-----

			respons.setStatus(IConstant.RESULT_CODE_0);
			respons.setMessageText(IConstant.WMSG0227, request
					.getLanguageCode(), request.getLanguageValue());
			return respons;
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new BusinessException(IConstant.WMSG0228, request
					.getLanguageCode(), request.getLanguageValue());
		}
	}

	public C01S016Respons saveToolJoint(C01S016Request regSwitch)
			throws Exception {
		C01S016Respons respons = new C01S016Respons();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ToolJoint toolJoint : regSwitch.getToolJointList()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ToolRepairNoticeID", toolJoint.getToolRepairNoticeID());// 修复通知单号
			map.put("ToolCode", toolJoint.getToolCode());// 刀具编码
			map.put("SentBackNumber", toolJoint.getSentBackNumber());// 领取数量
			map.put("RfidStringList", toolJoint.getRfidString());// rfid列表
			map.put("returnCountList", toolJoint.getReturnCountList());// 送回数量列表
			map.put("ReturnCount", toolJoint.getReturnCount());// 送回数量
			map.put("OldCount", toolJoint.getOldCount());// 入旧刀库数量
			map.put("NewCount", toolJoint.getNewCount());// 入新刀库数量
			map.put("LostCount", toolJoint.getLostCount());// 丢失数量
			map.put("GruantUserID", toolJoint.getGruantUserID());// 授权人ID
			map.put("DelCount", toolJoint.getDelCount());// 报废数量
			map.put("UpdateUser", regSwitch.getCustomerID());// 更新者
			map.put("handsetid", regSwitch.getHandSetId());// 手持机ID
			list.add(map);
		}
		Map<String, Object> ret = iCOMPV01C01S016Service.saveToolJoint(list);
		if (Integer.parseInt(ret.get("status").toString()) < 0) {
			throw new BusinessException(ret.get("messageCode").toString(),
					regSwitch.getLanguageCode(), regSwitch.getLanguageValue());
		}
		respons.setStatus(IConstant.RESULT_CODE_0);
		respons.setMessageText(IConstant.CIMSG0085,
				regSwitch.getLanguageCode(), regSwitch.getLanguageValue());
		return respons;
	}

	/**
	 * 取得待报废刀具信息
	 */
	@Override
	public C01S016Respons getToolLibraryInfo(C01S016Request request)
			throws Exception {
		C01S016Respons respons = new C01S016Respons();// 返回参数
		Rfidcontainer entity = new Rfidcontainer();
		// 参数验证
		if (StringUtils.isEmpty(request.getRfidCode())
				|| StringUtils.isEmpty(request.getCustomerID())) {
			throw new BusinessException(IConstant.WMSG0221,
					IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
		}
		// RFID标签
		entity.setRfidCode(request.getRfidCode());
		// 删除区分
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 验证RFID标签是否存在
		String RfidContainerID = service.getRfidContainerIDByRfidCode(entity);
		if (null==RfidContainerID) {
			respons.setStateCode(IConstant.STRING_1);
			respons.setStateMsg("当前标签未初始化");
			return respons;
		}
		// 不是容器或单品刀具
		Rfidcontainer rc = service.getRfidContainerByRfidCode(entity);
		if (!IConstant.STRING_1.equals(rc.getQueryType()) && !IConstant.STRING_5.equals(rc.getQueryType())) {
			respons.setStateCode(IConstant.STSATIC_ONE);
			respons.setStateMsg("请扫描一次性报废容器或报废的单品刀具");
			return respons;
		}
		
		// 流程控制
		Map<String, String> param = new HashMap<String, String>();
        param.put("businessCode", IConstant.C01S016);
        param.put("rfidCode", request.getRfidCode());
        Map<String, String> reBuss = service.processControlBussinesCode(param);
        if (reBuss == null) {
            respons.setStateCode(IConstant.DEL_FLAG_1);
            respons.setStateMsg("查询失败，请联系管理员");
            return respons;
        } else {
            //0 正常流程 1.需要授权 2.不能执行当前流程 9.未知错误
            String buss = reBuss.get(IConstant.STATE_CODE);
            if (IConstant.STRING_1.equals(buss)) {
                respons.setStateCode(IConstant.STRING_5);
                respons.setStateMsg("需要授权");
                return respons;
            } else if (IConstant.STRING_2.equals(buss) || IConstant.BAND_TYPE_9.equals(buss)) {
                respons.setStateCode(IConstant.STRING_1);
                respons.setStateMsg(reBuss.get(IConstant.STATE_MSG));
                return respons;
            }
        }
		// 刀具流转表
		Tooltransfer tfentity = new Tooltransfer();
		// RFID载体ID
		tfentity.setRfidContainerID(RfidContainerID);
		// 删除区分
		tfentity.setDelFlag(IConstant.DEL_FLAG_0);
		// 库存状态(0正常1报废2返厂3封存4.流转9其他)
		tfentity.setStockState(IConstant.DEL_FLAG_1);
		// 取得数据
		List<Tooltransfer> reList = iCOMPV01C01S016Service.getToolTransferList(tfentity);
		if (reList == null || reList.size() < 1) {
			respons.setStateCode(IConstant.DEL_FLAG_1);
			respons.setStateMsg("请扫描装有报废刀具的一次性报废容器或报废的单品刀具");
			return respons;
		} else {
			// 取得待报废刀具列表信息
			// 输出的信息list
			List<ToolJoint> retlist = new ArrayList<ToolJoint>();
			ToolJoint reEntity = new ToolJoint();
			for (Tooltransfer to : reList) {
				// 刀具流转表
				Tooltransfer trentity = new Tooltransfer();
				// 报废钻头进行回库处理
				if ((IConstant.KNIFE_INVENTORY_TYPE_1).equals(rc.getQueryType())) {
					Tool tl = new Tool();
					// 刀具id
					tl.setToolID(to.getToolID());
					// 删除区分
					tl.setDelFlag(IConstant.DEL_FLAG_0); 
					// 获取材料号和刀具类型
					tl = iCOMPV01C01S010Service.getTool(tl);
					// 刀具id
					reEntity.setToolID(tl.getToolID());
					// 材料号
					reEntity.setMaterialNumber(tl.getToolCode());
					// 报废数量
					reEntity.setScrapCount(to.getToolDurable().toString());
					retlist.add(reEntity);
					// 刀具部门（刃磨室）
					respons.setToolThisState(IConstant.STRING_2);
				}else if ((IConstant.KNIFE_INVENTORY_TYPE_5).equals(rc.getQueryType())) {
					// 容器进行回库处理
					// 判断是否有丢刀信息
					// 载体id
					trentity.setRfidContainerID(RfidContainerID);
					// 刀具状态：丢刀
					trentity.setToolState(IConstant.STRING_1);
					// 刀具部门：对刀室
					trentity.setToolThisState(IConstant.STRING_1);
					// 取得丢刀信息
					trentity = iCOMPV01C01S016Service.getToolTransfer(trentity);
					if (trentity.isRetErrFlag()==false) {
						reEntity = new ToolJoint();
						// 刀具ID
						reEntity.setToolID(to.getToolID());
						Tool tl = new Tool();
						// 刀具id
						tl.setToolID(to.getToolID());
						// 删除区分
						tl.setDelFlag(IConstant.DEL_FLAG_0); 
						// 获取材料号和刀具类型
						tl = iCOMPV01C01S010Service.getTool(tl);
						if (IConstant.STRING_5.equals(to.getToolState())) {
							// 刀具状态：到寿(即报废)
							// 材料号
							reEntity.setMaterialNumber(tl.getToolCode());
							// 报废数量
							reEntity.setScrapCount(to.getToolDurable().toString());
							// 丢刀数量
							reEntity.setLostCount(IConstant.STRING_0);
							// 丟刀确认人
							if (to.getConfirmedUser()!=null) {
								reEntity.setLostIdentifyingUser(service.getUserName(to.getConfirmedUser()));
							}else {
								reEntity.setLostIdentifyingUser(to.getConfirmedUser());
							}
							//  刀具状态
							reEntity.setToolState(to.getToolState());
						} else if (IConstant.STRING_1.equals(to.getToolState())) {
							// 刀具状态：丢刀
							// 材料号
							reEntity.setMaterialNumber(tl.getToolCode());
							// 报废数量
							reEntity.setScrapCount(IConstant.STRING_0);
							// 丢刀数量
							reEntity.setLostCount(to.getToolDurable().toString());
							// 丟刀确认人(根据customerId查找用户的真实姓名)
							if (to.getConfirmedUser()!=null) {
								reEntity.setLostIdentifyingUser(service.getUserName(to.getConfirmedUser()));
							}else {
								reEntity.setLostIdentifyingUser(to.getConfirmedUser());
							}
							// 刀具状态
							reEntity.setToolState(to.getToolState());
						}
					}else {
						reEntity = new ToolJoint();
						// 刀具ID
						reEntity.setToolID(to.getToolID());
						Tool tl = new Tool();
						// 刀具id
						tl.setToolID(to.getToolID());
						// 删除区分
						tl.setDelFlag(IConstant.DEL_FLAG_0); 
						// 获取材料号和刀具类型
						tl = iCOMPV01C01S010Service.getTool(tl);
						if (IConstant.STRING_5.equals(to.getToolState())) {
							// 刀具状态：到寿(即报废)
							// 材料号
							reEntity.setMaterialNumber(tl.getToolCode());
							// 报废数量
							reEntity.setScrapCount(to.getToolDurable().toString());
							// 丢刀数量
							reEntity.setLostCount(IConstant.STRING_0);
							// 丟刀确认人
							if (to.getConfirmedUser()!=null) {
								reEntity.setLostIdentifyingUser(service.getUserName(to.getConfirmedUser()));
							}else {
								reEntity.setLostIdentifyingUser(to.getConfirmedUser());
							}
							reEntity.setLostIdentifyingUser(tfentity.getConfirmedUser());
							//  刀具状态
							reEntity.setToolState(to.getToolState());
						} 
					}
					retlist.add(reEntity);
					// 刀具部门：对刀室
					respons.setToolThisState(IConstant.STRING_1);
				}
				//TODO 不是容器或单品刀具
			}

			List<String> toolCodeList = new ArrayList<String>();
			for (ToolJoint tjo : retlist) {
				if (toolCodeList.contains(tjo.getMaterialNumber())){
					// 如果材料号相同，则将记录合并
					// 遍历retlist，找到材料号相同的记录
					for (ToolJoint tjList : retlist) {
						// 材料号相同
						if (tjo.getMaterialNumber().equals(tjList.getMaterialNumber())){
							// 如果刀具状态为报废状态(到寿)，则添加报废数量
							if (IConstant.STRING_5.equals(tjo.getToolState())){
								tjList.setScrapCount(tjo.getScrapCount());
							}else if (IConstant.STRING_1.equals(tjo.getToolState())){
								// 如果刀具状态为丟刀状态，则添加丟刀数量和丢刀确认人
								tjList.setLostCount(tjo.getLostCount());// 丢刀数量
								tjList.setLostIdentifyingUser(tjo.getLostIdentifyingUser());// 丢刀确认人
							}
						}
					}

				}else{
					toolCodeList.add(tjo.getMaterialNumber());
				}
			}
			//去重
			for(int i = retlist.size() - 1; i > 0; i--) {
				String toolCode = retlist.get(i).getMaterialNumber();
				for(int j = i - 1; j >= 0; j--) {
					if(toolCode.equals(retlist.get(j).getMaterialNumber())) {
						retlist.remove(i);
						break;
					}
				}
			}

			respons.setToolJoint(retlist);
			// 如果成功则返回0
			respons.setStateCode(IConstant.STOCK_STATE_0);
			respons.setStateMsg("查询成功");
		}
		return respons;
	}

	/**
	 * 提交回库处理刀具信息
	 */
	@Override
	public C01S016Respons saveToolLibraryInfo(C01S016Request regSwitch)
			throws Exception {
		C01S016Respons respons = new C01S016Respons();
		// 参数验证
		if (StringUtils.isEmpty(regSwitch.getCustomerID())) {
			throw new BusinessException(IConstant.WMSG0221,
					IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (InputTool inputTool : regSwitch.getInputToolList()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ToolID", inputTool.getToolID());// 刀具ID
			map.put("RfidCode", inputTool.getRfidCode());// RFID标签
			map.put("MaterialNum", inputTool.getMaterialNum());// 材料号
			map.put("ScrapCount", inputTool.getScrapCount());// 报废数量
			map.put("LostCount", inputTool.getLostCount());// 丢刀数量
			map.put("LostUser", inputTool.getLostUser());// 丢刀确认人
			map.put("ConfirmCount", inputTool.getConfirmCount());// 确认数量
			map.put("SignID", regSwitch.getGruantUserID());//签收人id
			map.put("HandSetID", regSwitch.getHandSetId());//手持机id
			list.add(map);
		}
		Map<String, Object> ret = iCOMPV01C01S016Service.saveToolLibraryInfo(regSwitch.getCustomerID(),list);
		if (Integer.parseInt(ret.get("status").toString()) < 0) {
			throw new BusinessException(ret.get("messageCode").toString(),
					regSwitch.getLanguageCode(), regSwitch.getLanguageValue());
		}
		
		//回库处理签收，不需要授权
//		if (regSwitch.getGruantUserID() != null) {
//            //授权记录插入
//            Authorization auth = new Authorization();
//            //授权人ID
//            auth.setAuthorizationUserID(regSwitch.getGruantUserID());
//            //授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
//            auth.setAuthorizedReason(IConstant.STRING_1);
//            //刀具类型（0单品，1合成刀具）
//            auth.setTooltype(IConstant.DEL_FLAG_0);
//            //材料号或合成刀具编码
//            auth.setToolCode(regSwitch.getToolCode());
//            //业务流程编码
//            auth.setBusinessCode("C01S016");
//            auth.setCreateUserID(regSwitch.getCustomerID());
//            //备注
//            auth.setNote("回库处理");
//            service.innsetGruant(auth);
//        }
		respons.setStateCode(IConstant.DEL_FLAG_0);
		respons.setStateMsg("回库处理完成");
		return respons;
	}
}
