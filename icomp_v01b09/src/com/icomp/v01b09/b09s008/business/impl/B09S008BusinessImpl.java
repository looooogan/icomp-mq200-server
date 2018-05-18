package com.icomp.v01b09.b09s008.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s008.ICOMPV01B09S008Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.UUIDgen;
import com.icomp.entity.base.*;
import com.icomp.v01b09.b09s008.business.B09S008Business;
import org.apache.commons.lang3.StringUtils;

import java.lang.System;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 修复通知单查询BUSINESS实现类
 *
 * @author Taoyy
 * @ClassName: B09S008BusinessImpl
 * @date 2014-8-14 下午02:02:34
 */
public class B09S008BusinessImpl implements B09S008Business {


	/**
	 * 修复通知单查询SERVICE
	 */
	private ICOMPV01B09S008Service icompv01b09S008Service;


	public void setIcompv01b09S008Service(ICOMPV01B09S008Service icompv01b09S008Service) {
		this.icompv01b09S008Service = icompv01b09S008Service;
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

		/**
		 * 设置检索条件
		 */
		String dateStarStr = param.get("dateStar").toString().trim();
		String dateEndStr = param.get("dateEnd").toString().trim();

		Outsidefactory  entity = new Outsidefactory();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 申请起始时间
			if (dateStarStr != null && !"".equals(dateStarStr)) {
				dateStarStr += " 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));
			}
			// 申请结束时间
			if (dateEndStr != null && !"".equals(dateEndStr)) {
				dateEndStr += " 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 修复通知流水号
		entity.setOrderNum(StringUtils.isEmpty(param.get("noticeNo").toString()) ? null : param.get("noticeNo").toString());

		// 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
		//通知单状态
//		entity.setRepairState(StringUtils.isEmpty(param.get("outstatus").toString()) ? null : param.get("outstatus").toString());
		// 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC
		//修磨厂家名称
		entity.setMerchantsID(StringUtils.isEmpty(param.get("grindingName").toString()) ? null : param.get("grindingName").toString());
		//经办人
		entity.setMaterialNum(StringUtils.isEmpty(param.get("materialNum").toString()) ? null : param.get("materialNum").toString());
		//出门单号
		entity.setOutDoorNom(StringUtils.isEmpty(param.get("outDoorNom").toString()) ? null : param.get("outDoorNom").toString());

//        entity.setDelFlag(IConstant.DEL_FLAG_0);
		entity.setOrderString("orderNum");
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
		Map<String, Object> rtn = icompv01b09S008Service.getList(entity);
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
		Map<String, Object> rtn = icompv01b09S008Service.getlistsMer(entity);
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
	public Map<String, Object> outFactoryAdd(Map<String, Object> param, String langCode, String langValue) throws BusinessException {

		Map<String, Object> ret = new HashMap<String, Object>();
		//参数验证
		ret = checkInput(param, 1);
		if (ret.size() > 1 && ret.get(IConstant.MESSAGE_STR) != null) {
			return ret;
		}
		//赋值
		Outsidefactory outsidefactory = new Outsidefactory();

		//厂外修复ID
		outsidefactory.setOutsideFactoryID(UUIDgen.getId());
		//通知单号

		outsidefactory.setOrderNum(param.get("DIVorderNum").toString());
		//材料号
		outsidefactory.setMaterialNum(param.get("DIVmaterialNum").toString());
		//修磨数量
		outsidefactory.setNumberGrinding(param.get("DIVnumberGrinding").toString());
		//修磨商家
		outsidefactory.setMerchantsID(param.get("DIVmerchantsID").toString());
		//修磨类型
		outsidefactory.setGrindingType(param.get("DIVgrindingType").toString());
		//修磨状态
		outsidefactory.setRepairState(param.get("DIVtype").toString());
		if (IConstant.STRING_1.equals(param.get("DIVtype").toString())) {
			//出厂时间
			String ghfg = param.get("DIVmanufactureDate").toString();
			DateFormat format1 = new SimpleDateFormat("hh:mm:ss");
			Date date1 = new Date();
			ghfg += " " + format1.format(date1);
			outsidefactory.setManufactureDate(Ctl.strToDate(ghfg));
		} else {
			outsidefactory.setManufactureDate(new Date());
		}
		//审批人
		outsidefactory.setApprover(param.get("DIVapprover").toString());

		//创建人
		//备注
		outsidefactory.setNote(param.get("DIVnote").toString());
		//创建时间
		outsidefactory.setCreateTime(new Date());
		//版本号
		outsidefactory.setVersion(BigDecimal.ZERO);
		//删除分区
		outsidefactory.setDelFlag(IConstant.DEL_FLAG_0);


		//插入厂外通知数据
		ret = icompv01b09S008Service.outFactoryAdd(outsidefactory, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		//返回信息
		return ret;
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

		Map<String, Object> ret = icompv01b09S008Service.checkInput(param, langCode, langValue, 1, userID);
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
		ret = icompv01b09S008Service.merchantsAdd(merchants, langCode, langValue);
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
		Map<String, Object> ret = icompv01b09S008Service.checkInput(param, langCode, langValue, 2, userID);
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
		ret = icompv01b09S008Service.merchantEdit(merchants, langCode, langValue);
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
						List<Tool> toolList = icompv01b09S008Service.toolListB(t);
						if (toolList.size() == 0) {
							map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
									IConstant.DJYH04, "", ""));
						}
						Outsidefactory out = new Outsidefactory();
						out.setMerchantsID(param.get("DIVorderNum").toString());
						out.setMaterialNum(param.get("DIVmaterialNum").toString());

						List<Outsidefactory> outList = icompv01b09S008Service.outFactoryList(out);
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
						IConstant.REPLLC008, "", ""));

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
						IConstant.REPLLC008, "", ""));
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
//TODO 验证不完全
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
		Map<String, Object> ret = icompv01b09S008Service.merchantDel(merchants, langCode, langValue,userID);
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
			ret = icompv01b09S008Service.getMerchantsInfo(entity);
			if (ret.size() > 1 && ret.get("error") != null) {
				//检索错误时，返回
				throw new BusinessException(((Vcustomer) ret.get("error")).getMessageCode(), langCode, langValue);
			}
//        }else{//取得待编辑用户详细信息
//            Userdetail entity = new Userdetail();
//            entity.setCustomerID(userID);
//            ret = icompv01b09S008Service.getUserdetail(entity);
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
		List<Merchants> merchantsesList = icompv01b09S008Service.getPartsLine();
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

		ret = icompv01b09S008Service.getOutList(entity);

		if (ret.size() > 1 && ret.get("error") != null) {
			//检索错误时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}

		return ret;

	}

	@Override
	public Map<String, Object> outListInfo(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Map<String, Object> ret = new HashMap<String, Object>();

		//取得待编信息
		Outsidefactory entity = new Outsidefactory();
		entity.setOrderNum(param.get("orderNum").toString());

		ret = icompv01b09S008Service.getOutListInfo(entity);

		if (ret.size() > 1 && ret.get("error") != null) {
			//检索错误时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}

		return ret;
	}

	// 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
	// 通知编辑
	public Map<String, Object> outFactoryEdit(Map<String, Object> param, String langCode, String langValue, String userID,String userName) {
		Map<String, Object> ret = new HashMap<String, Object>();

		Outsidefactory outsidefactory = new Outsidefactory();

		outsidefactory.setOutsideFactoryID(param.get("DIVid").toString()); // 厂外id
		outsidefactory.setOutDoorNom(param.get("outDoorNo").toString());
		outsidefactory.setMerchantsID(param.get("outNo").toString());
		outsidefactory.setOrderNum(param.get("orderNum").toString());

		//经办人
		outsidefactory.setApprover(userName);

		outsidefactory.setDelFlag(IConstant.DEL_FLAG_0);
		outsidefactory.setUpdateTime(new Date());
		outsidefactory.setUpdateUser(userID);



		//更新信息
		ret = icompv01b09S008Service.outsidefactoryEdid(outsidefactory, langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Outsidefactory) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	// 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC

	@Override
	public List<Merchants> outMerchants(Merchants mer)throws BusinessException {
		return icompv01b09S008Service.getMerchan(mer);
	}

	@Override
	public String getNumber() throws BusinessException {
		return icompv01b09S008Service.getNumber();
	}

	@Override
	public String getMnumber() throws BusinessException {
		return icompv01b09S008Service.getMnumber();
	}


	//编辑查询
	public Map<String, Object> merchantsFind(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
		Merchants entity = new Merchants();
		entity.setMerchantsID(param.get("merchantsID") + "");
		return icompv01b09S008Service.merchantsFind(entity);
	}

}