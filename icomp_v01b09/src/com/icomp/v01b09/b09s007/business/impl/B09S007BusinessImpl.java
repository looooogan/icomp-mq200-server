package com.icomp.v01b09.b09s007.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s007.ICOMPV01B09S007Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.entity.base.*;
import com.icomp.v01b09.b09s007.business.B09S007Business;
import org.apache.commons.lang3.StringUtils;

import java.lang.System;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.icomp.common.utils.UUIDgen.getId;

/**
 * 修复通知单查询BUSINESS实现类
 *
 * @author Taoyy
 * @ClassName: B09S007BusinessImpl
 * @date 2014-8-14 下午02:02:34
 */
public class B09S007BusinessImpl implements B09S007Business {


	/**
	 * 修复通知单查询SERVICE
	 */
	private ICOMPV01B09S007Service icompv01b09S007Service;


	public void setIcompv01b09S007Service(ICOMPV01B09S007Service icompv01b09S007Service) {
		this.icompv01b09S007Service = icompv01b09S007Service;
	}

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 修复通知单查询列表
	 */
	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue, int checkType) throws BusinessException {

		// 2017/09/14 宋健 变更↓↓↓　dazhong@YMSC
		/**
		 * 设置检索条件
		 */
		String dateStarStr = param.get("dateStar").toString().trim();

		Outsidefactory entity = new Outsidefactory();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		if(!StringUtils.isEmpty(param.get("dateStar").toString())){
			entity.setManufactureDate(Ctl.strToDate(dateStarStr));

		}

		// 单号
		entity.setOutDoorNom(StringUtils.isEmpty(param.get("outDoorNom").toString()) ? null : param.get("outDoorNom").toString());
		// 修磨厂家名称
		entity.setMerchantsID(StringUtils.isEmpty(param.get("grindingName").toString()) ? null : param.get("grindingName").toString());
		// 经手人
		entity.setApprover(StringUtils.isEmpty(param.get("approver").toString()) ? null : param.get("approver").toString());
		// 邮寄人
		entity.setSendUser(StringUtils.isEmpty(param.get("sendUser").toString()) ? null : param.get("sendUser").toString());

		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 2017/09/14 宋健 变更↑↑↑　dazhong@YMSC
		entity.setOrderString("manufactureDate desc");
		if (checkType == 1) {

			// 分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			// 分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
			// 排序

		} else if (checkType == 2) {
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		// 出库信息列表
		Map<String, Object> rtn = icompv01b09S007Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Outsidefactory>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> getListMerchants(Map<String, Object> param, String langCode, String langValue, int checkType) throws BusinessException {
		Merchants entity = new Merchants();
		//商家编码
		entity.setMerchantsCold(StringUtils.isEmpty(param.get("merchantsCold").toString()) ? null : param.get("merchantsCold").toString());
		//商家名称
		entity.setMerchantsName(StringUtils.isEmpty(param.get("merchantsName").toString()) ? null : param.get("merchantsName").toString());
		//联系人
		entity.setInnerName(StringUtils.isEmpty(param.get("innerName").toString()) ? null : param.get("innerName").toString());
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		entity.setOrderString("MerchantsCold");
		if (checkType == 1) {
			// 分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			// 分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		} else if (checkType == 2) {
			entity.setStaIndex(0);
			entity.setRowCount(3000);
		}
		// 商家列表
		Map<String, Object> rtn = icompv01b09S007Service.getlistsMer(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Merchants>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 取得页面grid显示项目列表
	 *
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String userID,
											 String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode, IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> outFactoryAdd(Map<String, Object> param, String customerId, String langCode, String langValue) throws BusinessException {

        param.put("manageNo",param.get("manageNo").toString().toUpperCase());
        param.put("materialNum",param.get("materialNum").toString().toUpperCase());
		Map<String, Object> ret = new HashMap<String, Object>();

		//check单号是否重复
		Outsidefactory outEntity = new Outsidefactory();
		outEntity.setOutDoorNom(param.get("no").toString());
		ret = icompv01b09S007Service.getOutList(outEntity);
		if("0".equals(param.get("length").toString())){
			if (ret.size() == 1 && ret.get("error") == null) {
				ret.put(IConstant.MESSAGE_STR, "单号重复，不可添加");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			}
		}


		// 2017/09/12 宋健 变更↓↓↓　dazhong@YMSC
		//刀具类型
		String toolType = null;
		//材料号
		String toolCode = null;
		//RFID载体ID
		String rfId = null;
		//刀具ID
		String toolId = null;
		//一体刀的场合
		if (StringUtils.isNotEmpty(param.get("manageNo").toString())) {
			Rfidcontainer rf = new Rfidcontainer();
			rf.setLaserIdentificationCode(param.get("manageNo").toString());
			rf.setDelFlag(IConstant.DEL_FLAG_0);

			// RFID标签有效验证
			Map<String, Object> map = icompv01b09S007Service
					.getRfidcontainerList(rf);//调共通
			List<Rfidcontainer> list = (List<Rfidcontainer>) map.get("data");
			// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
			if (list.get(0).getRfidContainerID() == null) {
				ret.put(IConstant.MESSAGE_STR, "无效的刀具管理号");
				// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			} else if (!"2".equals(list.get(0).getQueryType())) {
				// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
				ret.put(IConstant.MESSAGE_STR, "刀具管理号非合成刀具");
				// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			} else {
				// RFID取得
				rfId = list.get(0).getRfidContainerID();
			}

			toolType = "1";
			// 是否需要授权flg
			String code = null;
			;
			// 根据激光码查询合成刀具信息
			Synthesisknife skentity = new Synthesisknife();
			// 刀具管理号（激光码）
			skentity.setrFID(rfId);
			Synthesisknife reVal = null;
			try {
				reVal = icompv01b09S007Service.
						getSynByRfidConner(skentity);// SQL--1
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (null == reVal) {
				ret.put(IConstant.MESSAGE_STR, "未找到合成刀数据");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			} else {
				// 非一体刀
				if (!"4".equals(reVal.getCreateType())) {
					ret.put(IConstant.MESSAGE_STR, "非一体刀的刀具管理号，不可出厂");
					ret.put("status", IConstant.RESULT_CODE_1);
					return ret;
				}

				// 未卸下不可修磨
				if (!"1".equals(reVal.getInstallFlag())) {
					ret.put(IConstant.MESSAGE_STR, "该刀具未卸下，不可厂外修磨");
					ret.put("status", IConstant.RESULT_CODE_1);
					return ret;
				}

				// 已出厂
				if ("7".equals(reVal.getLoadState())) {
					ret.put(IConstant.MESSAGE_STR, "该刀具已出厂");
					ret.put("status", IConstant.RESULT_CODE_1);
					return ret;
				}

				// 厂外修磨回厂后，再出厂修磨的场合 需授权
				if ("8".equals(reVal.getLoadState())) {
					code = "0";
				} else {
					code = "1";
				}
			}
			// 材料号(刀具编码)
			toolCode = reVal.getSynthesisParametersCode();
			// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
			if (!toolCode.equals(param.get("materialNum").toString())) {
				// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
				ret.put(IConstant.MESSAGE_STR, "材料号与刀具管理号不匹配,请确认");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			}

			// 根据合成刀具码查询刀具信息
			Tool tool = icompv01b09S007Service.searchToolInfoBySpcode(toolCode); // sql -- 2
			// 刀具id
			toolId = tool.getToolID();
			String toolGrinding = tool.getToolGrinding();
			// 刀具修磨类别为厂内修磨时，不可出厂修磨
			if ("0".equals(toolGrinding)) {
				ret.put(IConstant.MESSAGE_STR, "该刀具修磨类别为厂内修磨，不可出厂");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			}

			// 刀具类型为厂外涂层时 先厂内修磨后才可出厂
			if ("2".equals(toolGrinding)) {
				if (!"4".equals(reVal.getLoadState())
						&& !"8".equals(reVal.getLoadState()) && !"10".equals(reVal.getLoadState()) ) {
					ret.put(IConstant.MESSAGE_STR, "厂外涂层的一体刀,需先进行厂内修磨方可出厂");
					ret.put("status", IConstant.RESULT_CODE_1);
					return ret;
				}

			}

			Synthesisknife sk = new Synthesisknife();
			// 更新条件 - RFID
			// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
			sk.setrFIDWhere(rfId);
			// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
			// 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上6:已拆分7:已出厂修磨)
			sk.setLoadState("7");
			// 更新者
			sk.setUpdateUser(customerId);
			sk.setBusinessFlowLnkID("C01S019");
			// 更新合成刀库表是否安装为0设备装入
			icompv01b09S007Service.updateSynthesisknife(sk);

			// 需要授权的场合
			if ("0".equals(code)) {
				Authorization authorization = new Authorization();
				// 授权ID 系统生成
				authorization.setAuthorizationID(getId());
				// 授权人ID
				authorization.setAuthorizationUserID(customerId);
				// 授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
				authorization.setAuthorizedReason("6");
				// 授权时间
				authorization.setAuthorizedTime(new Date());
				// 创建人
				authorization.setCreateUserID(customerId);
				// 刀具ID
				authorization.setToolID(toolId);
				// 材料号
				authorization.setToolCode(toolCode);
				// 流程ID
				authorization.setBusinessCode("C01S018");
				// 插入授权表
				icompv01b09S007Service
						.insertAuthorizationDao(authorization);
			}


			Tooltransfer ttEntity = new Tooltransfer();
			ttEntity.setRfidContainerID(rfId);
			ttEntity.setToolID(toolId);
			ttEntity.setDelFlag("0");
			List<Tooltransfer> ttList = icompv01b09S007Service
					.searchTooltransferList(ttEntity); // sql -- 3
			if (ttList.size() > 0) {

				Tooltransfer tt = new Tooltransfer();
				// 更新者
				tt.setUpdateUser(customerId);
				// 最后执行业务流程
				tt.setBusinessFlowLnkID("C01S019");
				tt.setToolState("10");
				// 更新条件
				// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
				tt.setRfidContainerIDWhere(rfId);
				tt.setDelFlagWhere("0");
				tt.setToolIDWhere(tool.getToolID());
				// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
				// 更新流转表
				icompv01b09S007Service.updateTooltransfer(tt);
			}

			// 更新一体刀编号对应流转信息
			// 根据一体刀编号查询流转统计表数据
			TooltransferTotal t = new TooltransferTotal();
			t.setToolCode(tool.getToolCode());
			TooltransferTotal tst = icompv01b09S007Service
					.getTooltransferTotalInfoByToolCode(t);
			if (null != tst) {
				// 更新条件-刀具材料号
				tst.setToolCode(toolCode);
				// 新厂外修磨数量 = 当前厂外修磨数量+修磨数量
				tst.setExternalGrindingSum(tst
						.getExternalGrindingSum().add(BigDecimal.ONE));

				// 厂外修磨回厂后再出厂的场合
				if ("0".equals(code)) {
					// 新备刀数量 = 当前备刀数量-修磨数量
					tst.setSpareKnifeSum(tst.getSpareKnifeSum().subtract(BigDecimal.ONE));

				}else{
					// 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
					tst.setStayExternalGrindingSum(tst
							.getStayExternalGrindingSum().subtract(BigDecimal.ONE));
				}
				tst.setUpdateUser(customerId);
				// 更新流转统计表数据
				icompv01b09S007Service.updateTooltransferTotalInfo(tst);
			}

		}
		//非单品
		else if (StringUtils.isNotEmpty(param.get("materialNum").toString())) {
			String materialNum = param.get("materialNum").toString();
			Tool entity = new Tool();
			// 材料号
			entity.setToolCode(materialNum);
			Tool tool = icompv01b09S007Service.searchBitInputInf(entity);//sql--4

			if (tool == null) {
				ret.put(IConstant.MESSAGE_STR, "未找到相应的材料号信息");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			} else {
				rfId = tool.getRfidContainerId();
				if (rfId == null) {
					ret.put(IConstant.MESSAGE_STR, "材料号：" + materialNum
							+ "标签未初始化");
					ret.put("status", IConstant.RESULT_CODE_1);
					return ret;
				}
			}

			// 刀具类型
			toolType = "0";
			// 刀具id
			toolId = tool.getToolID();
			// 材料号(刀具编码)
			toolCode = tool.getToolCode();
			// 刀具修磨类别为厂内修磨时，不可出厂修磨
			if ("0".equals(tool.getToolGrinding())) {
				ret.put(IConstant.MESSAGE_STR, "该刀具修磨类别为厂内修磨，不可出厂修磨");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			}
			// 材料号为辅具不可厂外修磨
			if ("1".equals(tool.getToolType())) {
				ret.put(IConstant.MESSAGE_STR, "该刀具为辅具，不可出厂修磨");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			}

			String toolGrinding = tool.getToolGrinding();

			// 根据材料号查询流转统计表数据
			TooltransferTotal t = new TooltransferTotal();
			t.setToolCode(tool.getToolCode());
			TooltransferTotal tst = icompv01b09S007Service
					.getTooltransferTotalInfoByToolCode(t);
			// 发出数量
			String number = param.get("num").toString();
			if (null != tst) {
				// 待厂外修磨数量小于出厂数量时
				if (tst.getStayExternalGrindingSum().intValue() < Integer.valueOf(number)) {
					ret.put(IConstant.MESSAGE_STR, "材料号："
							+ toolCode + "修磨数量大于当前待修磨数量");
					ret.put("status", IConstant.RESULT_CODE_1);
					return ret;
				}
				// 更新条件-刀具材料号
				tst.setToolCode(toolCode);
				// 新厂外修磨 = 当前厂外修磨数量+修磨数量
				tst.setExternalGrindingSum(BigDecimal.valueOf(tst
						.getExternalGrindingSum().intValue()
						+ Integer.valueOf(number)));
				// 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
				tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst
						.getStayExternalGrindingSum().intValue() - Integer.valueOf(number)));
				tst.setUpdateUser(customerId);
				// 更新流转统计表数据
				icompv01b09S007Service.updateTooltransferTotalInfo(tst);
			} else {
				ret.put(IConstant.MESSAGE_STR, "未找到材料号："
						+ toolCode + "的流转信息");
				ret.put("status", IConstant.RESULT_CODE_1);
				return ret;
			}
		}

		//赋值
		Outsidefactory outsidefactory = new Outsidefactory();

		//厂外修复ID
		outsidefactory.setOutsideFactoryID(getId());
		//单号
		outsidefactory.setOutDoorNom(param.get("no").toString());
		//修磨商家
		outsidefactory.setMerchantsID(param.get("merchants").toString());
		//出厂时间
		String ghfg = param.get("date").toString();
		DateFormat format1 = new SimpleDateFormat("hh:mm:ss");
		Date date1 = new Date();
		ghfg += " " + format1.format(date1);
		outsidefactory.setManufactureDate(Ctl.strToDate(ghfg));
		//经手人
		outsidefactory.setApprover(param.get("approver").toString());
		//邮寄人
		outsidefactory.setSendUser(param.get("sendUser").toString());
		//材料号
		outsidefactory.setMaterialNum(StringUtils.isEmpty(param.get("materialNum").toString()) ? null : param.get("materialNum").toString());
		//刀具编号
		outsidefactory.setToolID(toolId);
		//名称
		outsidefactory.setToolName(StringUtils.isEmpty(param.get("name").toString()) ? null : param.get("name").toString());
		//描述
		outsidefactory.setDescr(StringUtils.isEmpty(param.get("desc").toString()) ? null : param.get("desc").toString());
		//刀具管理号
		outsidefactory.setLaserCode(StringUtils.isEmpty(param.get("manageNo").toString()) ? null : param.get("manageNo").toString());
		//发出数量
		outsidefactory.setNumberGrinding(StringUtils.isEmpty(param.get("num").toString()) ? null : param.get("num").toString());
		//备注
		outsidefactory.setNote(StringUtils.isEmpty(param.get("note").toString()) ? null : param.get("note").toString());
		//创建人
		outsidefactory.setCreateUser(customerId);
		// 2017/09/12 王冉 追加↓↓↓　dazhong@YMSC
		outsidefactory.setToolType(toolType);
		outsidefactory.setRepairState("1");
		// 2017/09/12 王冉 追加↓↓↓　dazhong@YMSC
		//创建时间
		outsidefactory.setCreateTime(new Date());
		//版本号
		outsidefactory.setVersion(BigDecimal.ZERO);
		//删除分区
		outsidefactory.setDelFlag(IConstant.DEL_FLAG_0);


		//插入厂外通知数据
		ret = icompv01b09S007Service.outFactoryAdd(outsidefactory, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		//返回信息
		return ret;
		// 2017/09/12 宋健 变更↑↑↑　dazhong@YMSC
	}

	/**
	 * 添加厂家
	 *
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Map<String, Object> merchantsAdd(Map<String, Object> param, String langCode, String langValue, String userID) throws BusinessException {

		Map<String, Object> ret = icompv01b09S007Service.checkInput(param, langCode, langValue, 1, userID);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Displayeditemconfiguration) ret.get("error")).getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}

		//赋值
		Merchants merchants = (Merchants) ret.get("data");

		merchants.setCreateTime(new Date());
		//版本号
		merchants.setVersion(BigDecimal.ZERO);
		//删除分区
		merchants.setDelFlag(IConstant.DEL_FLAG_0);
		//插入新建厂家数据
		ret = icompv01b09S007Service.merchantsAdd(merchants, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Position) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		//返回信息
		return ret;
	}

	/**
	 * 查询
	 *
	 * @param param
	 * @return
	 */
	public Map<String, Object> merchantsEdit(Map<String, Object> param, String langCode, String langValue, String userID) throws BusinessException {
		//用户输入验证
		Map<String, Object> ret = icompv01b09S007Service.checkInput(param, langCode, langValue, 2, userID);
		if (ret.size() > 1 && ret.get("error") != null) {
			throw new BusinessException(((Merchants) ret.get("error")).getMessageCode(), langCode, langValue);
		} else if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}
		Merchants merchants = new Merchants();
		//条件
		System.out.println(param.get("DIVmerchantsID").toString());
		merchants.setMerchantsIDWhere(param.get("DIVmerchantsID").toString());


		//要更新的值
		merchants.setMerchantsCold(param.get("DIVmerchantsCode").toString());
		merchants.setMerchantsName(param.get("DIVmerchantsName").toString());
		merchants.setMerchantsType(param.get("DIVmerchantsType").toString());
		merchants.setInnerName(param.get("DIVmerchantsUser").toString());
		merchants.setMerchantsTel(param.get("DIVmerchantsTel").toString());
		merchants.setMerchantsAddrss(param.get("DIVmerchantsAdd").toString());
		merchants.setUpdateTime(new Date());
		merchants.setUpdateUser(param.get("userID").toString());

		//更新信息
		ret = icompv01b09S007Service.merchantEdit(merchants, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Customer) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}


	/**
	 * 新建通知单验证
	 *
	 * @param param
	 * @param checkType
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 页面输入项目验证
		Map<String, String> map = new HashMap<String, String>();
		if (checkType == 1) {
			if (StringUtils.isEmpty(param.get("DIVorderNum").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC001, "", ""));
			} else {
				if (StringUtils.isEmpty(param.get("DIVmaterialNum").toString())) {
					map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
							IConstant.REPLLC002, "", ""));
				} else {
					if (!StringUtils.isEmpty(param.get("DIVmaterialNum").toString())) {
						Tool t = new Tool();
						t.setToolCode(param.get("DIVmaterialNum").toString());
						List<Tool> toolList = icompv01b09S007Service.toolListB(t);
						if (toolList.size() == 0) {
							map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
									IConstant.DJYH04, "", ""));
						}
						Outsidefactory out = new Outsidefactory();
						out.setMerchantsID(param.get("DIVorderNum").toString());
						out.setMaterialNum(param.get("DIVmaterialNum").toString());

						List<Outsidefactory> outList = icompv01b09S007Service.outFactoryList(out);
						if (outList.size() != 0) {
							map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
									IConstant.REPLLC008, "", ""));
						}

					}

				}

			}

			if (StringUtils.isEmpty(param.get("DIVmerchantsID").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC003, "", ""));

			}

			if (StringUtils.isEmpty(param.get("DIVnumberGrinding").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC004, "", ""));

			}
			if (Ctl.checkString(0, param.get("DIVnumberGrinding").toString()) == false) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC009, "", ""));

			}
			if (StringUtils.isEmpty(param.get("DIVgrindingType").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC005, "", ""));

			}
			if (StringUtils.isEmpty(param.get("DIVtype").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC005, "", ""));

			}
			if (IConstant.STRING_1.equals(param.get("DIVtype").toString())) {
				if (StringUtils.isEmpty(param.get("DIVmanufactureDate").toString())) {
					map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
							IConstant.REPLLC006, "", ""));

				}
			}

			if (StringUtils.isEmpty(param.get("DIVapprover").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.REPLLC007, "", ""));

			}
		}
		if (checkType == 2) {
			//通知单号
			if (StringUtils.isEmpty(param.get("DIVorderNum").toString())) {
				map.put("DIVorderNum", MessageReSource.getMessageBox(
						IConstant.REPLLC001, "", ""));
			}
			//材料号
			if (StringUtils.isEmpty(param.get("DIVmaterialNums").toString())) {
				map.put("DIVmaterialNum", MessageReSource.getMessageBox(
						IConstant.REPLLC002, "", ""));
			}
			//商家id
			if (StringUtils.isEmpty(param.get("DIVmerchantsID").toString())) {
				map.put("DIVmerchantsID", MessageReSource.getMessageBox(
						IConstant.REPLLC003, "", ""));
			}
			//数量
			if (StringUtils.isEmpty(param.get("DIVnumberGrindings").toString())) {
				map.put("DIVnumberGrindings", MessageReSource.getMessageBox(
						IConstant.REPLLC004, "", ""));
			}
			//修磨类型
			if (StringUtils.isEmpty(param.get("DIVgrindingType").toString())) {
				map.put("DIVgrindingType", MessageReSource.getMessageBox(
						IConstant.REPLLC005, "", ""));

			}
			//出厂时间
			if (StringUtils.isEmpty(param.get("DIVmanufactureDate").toString())) {
				map.put("DIVmanufactureDate", MessageReSource.getMessageBox(
						IConstant.REPLLC006, "", ""));
			}
			//经办人
			if (StringUtils.isEmpty(param.get("DIVapprover").toString())) {
				map.put("DIVapprover", MessageReSource.getMessageBox(
						IConstant.REPLLC007, "", ""));
			}
		}
		if (map.size() > 0) {
			rtn.put(IConstant.MESSAGE_STR, map);
			rtn.put(IConstant.STATUS_STR, IConstant.RESULT_CODE_STR_3);
		}
		return rtn;
	}

	public Map<String, Object> checkInputMer(Map<String, Object> param, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 页面输入项目验证
		Map<String, String> map = new HashMap<String, String>();
		if (checkType == 1) {
			if (StringUtils.isEmpty(param.get("DIVmerchantsName").toString())) {//如果商家未填写
				map.put(" DIVmerchantsName", IConstant.ERROR_MSG_07);
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsType").toString())) {//如果商家类型未填写
				map.put(" DIVmerchantsType", IConstant.ERROR_MSG_07);
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsUser").toString())) {//如果经办人未填写
				map.put(" DIVmerchantsUser", IConstant.ERROR_MSG_07);
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsTel").toString())) {//如果联系电话未填写
				map.put(" DIVmerchantsTel", IConstant.ERROR_MSG_07);
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsAdd").toString())) {//如果地址未填写
				map.put(" DIVmerchantsAdd", IConstant.ERROR_MSG_07);
			}
		}
		if (map.size() > 0) {
			rtn.put(IConstant.MESSAGE_STR, map);
			rtn.put(IConstant.STATUS_STR, IConstant.RESULT_CODE_STR_3);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> merchantDelete(Map<String, Object> param, String userID, String langCode, String langValue) throws BusinessException {

		Merchants merchants = new Merchants();
		//要修改的值
		merchants.setDelFlag(IConstant.DEL_FLAG_1);
		merchants.setUpdateUser(userID);
		merchants.setUpdateTime(new Date());
		//条件
		merchants.setMerchantsIDWhere(param.get("merchantsID").toString());
		merchants.setDelFlagWhere(IConstant.DEL_FLAG_0);

//       merchants.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
//        merchants.setCreateUserWhere(userID);
		//  merchants.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		// merchants.setUpdateUserWhere(param.get("updateuser").toString());
		// merchants.setVersionWhere(new BigDecimal(param.get("version").toString()));
		Map<String, Object> ret = icompv01b09S007Service.merchantDel(merchants, langCode, langValue, userID);
		if (ret.size() > 1 && ret.get("error") != null) {
			//删除失败时，返回
			throw new BusinessException(((Merchants) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> merchantsInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();
		String merchantsID = param.get("merchantsID").toString();
		System.out.println(merchantsID);
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			//取得待编辑用户信息
			Merchants entity = new Merchants();
			entity.setMerchantsID(merchantsID);
			ret = icompv01b09S007Service.getMerchantsInfo(entity);
			if (ret.size() > 1 && ret.get("error") != null) {
				//检索错误时，返回
				throw new BusinessException(((Vcustomer) ret.get("error")).getMessageCode(), langCode, langValue);
			}
//        }else{//取得待编辑用户详细信息
//            Userdetail entity = new Userdetail();
//            entity.setCustomerID(userID);
//            ret = icompv01b09S007Service.getUserdetail(entity);
//            if(ret.size() > 1 && ret.get("error") != null){//查询失败
//                throw new BusinessException(((List<Userdetail>)ret.get("error")).get(0).getMessageCode(), langCode, langValue);
//            }
		}
		return ret;
	}

	/**
	 * 取得页面下拉列表内容
	 *
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();
		//取得零部件列表
		List<Merchants> merchantsesList = icompv01b09S007Service.getPartsLine();
		if (merchantsesList.size() > 0 && merchantsesList.get(0).isRetErrFlag()) {
			//检索错误时，返回
			throw new BusinessException(merchantsesList.get(0).getMessageCode(), langCode, langValue);
		}
		ret.put("merchantsesList", merchantsesList);
		return ret;
	}

	@Override
	public Map<String, Object> outInfo(Map<String, Object> param, String langCode, String langValue) {
		Map<String, Object> ret = new HashMap<String, Object>();

		//取得待编信息
		Outsidefactory entity = new Outsidefactory();
		// 2017/09/12 宋健 变更↓↓↓　dazhong@YMSC
		entity.setOutDoorNom(param.get("outDoorNum").toString());
		// 2017/09/12 宋健 变更↑↑↑　dazhong@YMSC
		ret = icompv01b09S007Service.getOutList(entity);

		if (ret.size() > 1 && ret.get("error") != null) {
			//检索错误时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}

		return ret;

	}

	// 2017/09/15 宋健 变更↓↓↓　dazhong@YMSC
	// 编辑
	public Map<String, Object> outFactoryEdit(Map<String, Object> param, String langCode, String langValue, String userID) {

        //param.put("manageNo",param.get("manageNo").toString().toUpperCase());
		param.put("materialNum",param.get("materialNum").toString().toUpperCase());

		Map<String, Object> ret = new HashMap<String, Object>();

		Outsidefactory uf = new Outsidefactory();

		TooltransferTotal t = new TooltransferTotal();
		t.setToolCode(param.get("materialNum").toString().trim());

		int number = Integer.valueOf(param.get("numberGrinding").toString());
		int oldNumber = Integer.valueOf(param.get("hNumberGrinding").toString());

		//非单品
		if("0".equals(param.get("toolType").toString())){
			//如果发出数量产生变化
			if(Integer.valueOf(param.get("hNumberGrinding").toString()) != Integer.valueOf(param.get("numberGrinding").toString())){
				// 根据材料号查询流转统计表数据
				TooltransferTotal tst = icompv01b09S007Service.getTooltransferTotalInfoByToolCode(t);
				if(Integer.valueOf(param.get("numberGrinding").toString()) > Integer.valueOf(param.get("hNumberGrinding").toString())){
					//判断待修磨数是否足够
					//待厂外修磨数量小于出厂数量时
					if (tst.getStayExternalGrindingSum().intValue() < (Integer.valueOf(param.get("numberGrinding").toString())-Integer.valueOf(param.get("hNumberGrinding").toString()))) {
						ret.put(IConstant.MESSAGE_STR, "材料号："
								+ param.get("materialNum").toString().trim() + "修磨数量大于当前待修磨数量");
						return ret;
					}
					//如果足够 更新流转统计表
					// 新厂外修磨 = 当前厂外修磨数量+修磨数量
					tst.setExternalGrindingSum(BigDecimal.valueOf(tst.getExternalGrindingSum().intValue()+ (number-oldNumber)));
					// 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
					tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst.getStayExternalGrindingSum().intValue() - (number-oldNumber)));
				}else{
					// 新厂外修磨 = 当前厂外修磨数量+修磨数量
					tst.setExternalGrindingSum(BigDecimal.valueOf(tst.getExternalGrindingSum().intValue()+ (number-oldNumber)));
					// 待厂外修磨数量 = 当前待厂外修磨数量-修磨数量
					tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst.getStayExternalGrindingSum().intValue() - (number-oldNumber)));
				}
				// 更新流转统计表
				icompv01b09S007Service.updateTooltransferTotalInfo(tst);

			}
			//一体刀
		}else if("1".equals(param.get("toolType").toString())){
			uf.setNumberGrinding("1");
		}

		// 主键Id
		uf.setOutsideFactoryID(param.get("outId").toString());
		// 描述
		uf.setDescr(param.get("descr").toString());
		// 备注
		uf.setNote(param.get("note").toString());
		// 发出数量
		uf.setNumberGrinding(param.get("numberGrinding").toString());
		// 名称
		uf.setToolName(param.get("toolName").toString());

		uf.setDelFlag(IConstant.DEL_FLAG_0);
		uf.setUpdateTime(new Date());
		uf.setUpdateUser(userID);

		//更新信息
		ret = icompv01b09S007Service.outsidefactoryEdid(uf, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	public Map<String, Object> outFactoryEdit2(Map<String, Object> param, String langCode, String langValue, String userID) throws ParseException{


		Map<String, Object> ret = new HashMap<String, Object>();

		Outsidefactory uf = new Outsidefactory();

		// 出门单号
		uf.setOutDoorNom(param.get("outDoorNom").toString());
		// 厂家ID
		uf.setMerchantsID(param.get("merchants").toString());
		// 出厂时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(param.get("date").toString());
		uf.setManufactureDate(date);
		// 审批人
		uf.setApprover(param.get("approver").toString());
		// 邮寄人
		uf.setSendUser(param.get("sendUser").toString());

		uf.setUpdateTime(new Date());
		uf.setUpdateUser(userID);

		//更新信息
		ret = icompv01b09S007Service.outsidefactoryEdid2(uf, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	// 2017/09/15 宋健 变更↑↑↑　dazhong@YMSC

	@Override
	public List<Merchants> outMerchants(Merchants mer) throws BusinessException {
		return icompv01b09S007Service.getMerchan(mer);
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b09S007Service.getNumber();
	}

	@Override
	public String getMnumber() throws BusinessException {
		return icompv01b09S007Service.getMnumber();
	}

	@Override
	public Map<String, Object> getOutsideFactoryList(Outsidefactory outsidefactory) {
		return icompv01b09S007Service.getOutsideFactoryList(outsidefactory);
	}

	// 2017/09/13 宋健 追加↓↓↓　dazhong@YMSC
	@Override
	public Map<String, Object> outFactoryDel(Map<String, Object> param, String langCode, String langValue, String userID) throws BusinessException {

		Map<String, Object> ret = new HashMap<String, Object>();

		String flag = param.get("opt").toString();

		if("all".equals(flag)){
			//取得待编信息
			Outsidefactory out = new Outsidefactory();
			out.setOutDoorNom(param.get("outDoorNum").toString());

			ret = icompv01b09S007Service.getOutList(out);
			List<Outsidefactory> list = (List<Outsidefactory>)ret.get("data");
			if(list != null){
				for (int i = 0;i<list.size();i++){
					Outsidefactory outsidefactory = new Outsidefactory();
					// 主键Id
					outsidefactory.setOutsideFactoryID(list.get(i).getOutsideFactoryID());

					outsidefactory.setDelFlag(IConstant.DEL_FLAG_1);
					outsidefactory.setUpdateTime(new Date());
					outsidefactory.setUpdateUser(userID);

					//更新信息
					ret = icompv01b09S007Service.outsidefactoryEdid(outsidefactory, langCode, langValue);

					// 发出数量
					Integer outNumber = Integer.valueOf(list.get(i).getNumberGrinding());
					//根据厂外修复ID查询厂外修复信息
					//Outsidefactory entity = new Outsidefactory();
					//entity.setOutsideFactoryID(param.get("outId").toString());
					//Map<String,Object> m = icompv01b09S007Service.getList(entity);
					//List<Outsidefactory> list = (List<Outsidefactory>)m.get("rows");
					//Outsidefactory outsidefactory = list.get(0);
					//累积返厂数量
					Integer backNumber = Integer.valueOf(list.get(i).getReceiveNumber());

					TooltransferTotal t = null;
					if(!"".equals(list.get(i).getMaterialNum())){
						t = new TooltransferTotal();
						t.setToolCode(list.get(i).getMaterialNum());
					}

					//非单品
					if(!"".equals(list.get(i).getMaterialNum()) && "".equals(list.get(i).getLaserCode())){

						if (null != t) {
							// 根据材料号查询流转统计表数据
							TooltransferTotal tst = icompv01b09S007Service.getTooltransferTotalInfoByToolCode(t);
							// 更新条件-刀具材料号
							tst.setToolCode(list.get(i).getMaterialNum());
							// 新厂外修磨数量 = 当前厂外修磨数量-发出数量+累积返厂数量
							tst.setExternalGrindingSum(BigDecimal.valueOf(tst.getExternalGrindingSum().intValue()- outNumber + backNumber));
							// 待厂外修磨数量 = 当前待厂外修磨数量+发出数量
							tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst.getStayExternalGrindingSum().intValue() + outNumber));
							// 备刀数量
							if(backNumber > 0){
								tst.setSpareKnifeSum(BigDecimal.valueOf(tst.getSpareKnifeSum().intValue() - backNumber));
							}
							tst.setUpdateUser(userID);
							// 更新流转统计表数据
							icompv01b09S007Service.updateTooltransferTotalInfo(tst);
						}

						//一体刀
					}else if(!"".equals(list.get(i).getLaserCode())){
						// 根据材料号查询流转统计表数据
						TooltransferTotal tst = icompv01b09S007Service.getTooltransferTotalInfoByToolCode(t);
						if (null != tst) {
							// 更新条件-材料号
							tst.setToolCode(list.get(i).getMaterialNum());
							// 新厂外修磨数量 = 当前厂外修磨数量-发出数量+累积返厂数量
							tst.setExternalGrindingSum(BigDecimal.valueOf(tst.getExternalGrindingSum().intValue()- outNumber + backNumber));
							// 待厂外修磨数量 = 当前待厂外修磨数量+发出数量
							tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst.getStayExternalGrindingSum().intValue() + outNumber));
							// 备刀数量
							if(backNumber > 0){
								tst.setSpareKnifeSum(BigDecimal.valueOf(tst.getSpareKnifeSum().intValue() - backNumber));
							}
							tst.setUpdateUser(userID);
							// 更新流转统计表数据
							icompv01b09S007Service.updateTooltransferTotalInfo(tst);
						}

						Tool tool = icompv01b09S007Service.searchToolInfoBySpcode(list.get(i).getMaterialNum());

						Rfidcontainer rf = new Rfidcontainer();
						rf.setLaserIdentificationCode(list.get(i).getLaserCode());
						rf.setDelFlag(IConstant.DEL_FLAG_0);

						// RFID标签有效验证
						Map<String, Object> map = icompv01b09S007Service
								.getRfidcontainerList(rf);//调共通
						List<Rfidcontainer> rList = (List<Rfidcontainer>) map.get("data");

						Synthesisknife sk = new Synthesisknife();
						// 更新条件 - RFID
						// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
						sk.setrFIDWhere(rList.get(0).getRfidContainerID());
						// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
						// 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4厂内修磨5车间待安上6已拆分7出厂修磨8已回厂9已换装10厂外待修磨11报废)
						// 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层
						if ("1".equals(tool.getToolGrinding())) {
							sk.setLoadState("1");
						} else {
							sk.setLoadState("4");
						}

						// 更新者
						sk.setUpdateUser(userID);
						// 更新合成刀库表是否安装为0设备装入
						icompv01b09S007Service.updateSynthesisknife(sk);

					}

					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date = null;
					outsidefactory = new Outsidefactory();

					// 主键Id
					outsidefactory.setOutsideFactoryID(list.get(i).getOutsideFactoryID());

					outsidefactory.setDelFlag(IConstant.DEL_FLAG_1);
					outsidefactory.setUpdateTime(new Date());
					outsidefactory.setUpdateUser(userID);

					//更新信息
					ret = icompv01b09S007Service.outsidefactoryEdid(outsidefactory, langCode, langValue);

				}
			}
		}else{
			// 发出数量
			Integer outNumber = Integer.valueOf(param.get("numberGrinding").toString());
			//根据厂外修复ID查询厂外修复信息
			Outsidefactory entity = new Outsidefactory();
			entity.setOutsideFactoryID(param.get("outId").toString());
			Map<String,Object> m = icompv01b09S007Service.getList(entity);
			List<Outsidefactory> list = (List<Outsidefactory>)m.get("rows");
			Outsidefactory outsidefactory = list.get(0);
			//累积返厂数量
			Integer backNumber = Integer.valueOf(outsidefactory.getReceiveNumber());

			TooltransferTotal t = null;
			if(!"".equals(param.get("materialNum").toString())){
				t = new TooltransferTotal();
				t.setToolCode(param.get("materialNum").toString());
			}

			//非单品
			if("0".equals(param.get("toolType").toString())){

				if (null != t) {
					// 根据材料号查询流转统计表数据
					TooltransferTotal tst = icompv01b09S007Service.getTooltransferTotalInfoByToolCode(t);
					// 更新条件-刀具材料号
					tst.setToolCode(param.get("materialNum").toString());
					// 新厂外修磨数量 = 当前厂外修磨数量-发出数量+累积返厂数量
					tst.setExternalGrindingSum(BigDecimal.valueOf(tst.getExternalGrindingSum().intValue()- outNumber + backNumber));
					// 待厂外修磨数量 = 当前待厂外修磨数量+发出数量
					tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst.getStayExternalGrindingSum().intValue() + outNumber));
					// 备刀数量
					if(backNumber > 0){
						tst.setSpareKnifeSum(BigDecimal.valueOf(tst.getSpareKnifeSum().intValue() - backNumber));
					}
					tst.setUpdateUser(userID);
					// 更新流转统计表数据
					icompv01b09S007Service.updateTooltransferTotalInfo(tst);
				}

				//一体刀
			}else if("1".equals(param.get("toolType").toString())){
				// 根据材料号查询流转统计表数据
				TooltransferTotal tst = icompv01b09S007Service.getTooltransferTotalInfoByToolCode(t);
				if (null != tst) {
					// 更新条件-材料号
					tst.setToolCode(param.get("materialNum").toString());
					// 新厂外修磨数量 = 当前厂外修磨数量-发出数量+累积返厂数量
					tst.setExternalGrindingSum(BigDecimal.valueOf(tst.getExternalGrindingSum().intValue()- outNumber + backNumber));
					// 待厂外修磨数量 = 当前待厂外修磨数量+发出数量
					tst.setStayExternalGrindingSum(BigDecimal.valueOf(tst.getStayExternalGrindingSum().intValue() + outNumber));
					// 备刀数量
					if(backNumber > 0){
						tst.setSpareKnifeSum(BigDecimal.valueOf(tst.getSpareKnifeSum().intValue() - backNumber));
					}
					tst.setUpdateUser(userID);
					// 更新流转统计表数据
					icompv01b09S007Service.updateTooltransferTotalInfo(tst);
				}

				Tool tool = icompv01b09S007Service.searchToolInfoBySpcode(param.get("materialNum").toString()); // sql -- 2

				Rfidcontainer rf = new Rfidcontainer();
				rf.setLaserIdentificationCode(param.get("laserCode").toString());
				rf.setDelFlag(IConstant.DEL_FLAG_0);

				// RFID标签有效验证
				Map<String, Object> map = icompv01b09S007Service
						.getRfidcontainerList(rf);//调共通
				List<Rfidcontainer> rList = (List<Rfidcontainer>) map.get("data");

				Synthesisknife sk = new Synthesisknife();
				// 更新条件 - RFID
				// 2017/09/12 王冉 变更↓↓↓　dazhong@YMSC
				sk.setrFIDWhere(rList.get(0).getRfidContainerID());
				// 2017/09/12 王冉 变更↑↑↑　dazhong@YMSC
				// 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4厂内修磨5车间待安上6已拆分7出厂修磨8已回厂9已换装10厂外待修磨11报废)
				// 修磨类别(0:厂内修磨，1厂外修磨，2厂外涂层
				if ("1".equals(tool.getToolGrinding())) {
					sk.setLoadState("1");
				} else {
					sk.setLoadState("4");
				}

				// 更新者
				sk.setUpdateUser(userID);
				// 更新合成刀库表是否安装为0设备装入
				icompv01b09S007Service.updateSynthesisknife(sk);

			}

			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			outsidefactory = new Outsidefactory();

			// 主键Id
			outsidefactory.setOutsideFactoryID(param.get("outId").toString());

			outsidefactory.setDelFlag(IConstant.DEL_FLAG_1);
			outsidefactory.setUpdateTime(new Date());
			outsidefactory.setUpdateUser(userID);

			//更新信息
			ret = icompv01b09S007Service.outsidefactoryEdid(outsidefactory, langCode, langValue);
			if (ret.size() > 1 && ret.get("error") != null) {
				//新建失败时，返回
				throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
			}
		}
		return ret;
	}
	// 2017/09/13 宋健 追加↑↑↑　dazhong@YMSC

	//编辑查询
	public Map<String, Object> merchantsFind(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Merchants entity = new Merchants();
		entity.setMerchantsID(param.get("merchantsID") + "");
		return icompv01b09S007Service.merchantsFind(entity);
	}

}