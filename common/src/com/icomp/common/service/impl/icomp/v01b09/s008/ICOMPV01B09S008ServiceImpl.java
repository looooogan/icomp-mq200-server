package com.icomp.common.service.impl.icomp.v01b09.s008;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b09.s008.ICOMPV01B09S008Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.*;
import com.icomp.entity.base.Merchants;
import com.icomp.entity.base.Outsidefactory;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Voutsidefactory;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 修复通知单查询SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B03S002ServiceImpl
 * @date 2014-8-20 下午03:58:41
 */
public class ICOMPV01B09S008ServiceImpl extends BaseService implements ICOMPV01B09S008Service {


	/**
	 * 修复通知单DAO
	 */
	private VrepairticketDao vrepairticketDao;
	private OutsidefactoryDao outsidefactoryDao;

	private MerchantsDao merchantsDao;
	private int numbers;
	private ToolDao toolDao;

	public void setToolDao(ToolDao toolDao) {
		this.toolDao = toolDao;
	}

	public void setOutsidefactoryDao(OutsidefactoryDao outsidefactoryDao) {
		this.outsidefactoryDao = outsidefactoryDao;
	}

	public void setMerchantsDao(MerchantsDao merchantsDao) {
		this.merchantsDao = merchantsDao;
	}

	public void setVrepairticketDao(VrepairticketDao vrepairticketDao) {
		this.vrepairticketDao = vrepairticketDao;
	}

	@Override
	public Map<String, Object> getMerchantsInfo(Merchants entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Merchants> list = (List<Merchants>) merchantsDao.searchByList(entity);
			if (list.size() <= 0) {
				Merchants merchants = new Merchants();
				//消息：检索为0
				merchants.setMessageCode(IConstant.EMSG0001);
				merchants.setRetErrFlag(true);
				rtn.put("data", merchants);
				rtn.put("error", merchants);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Merchants merchants = new Merchants();
			//错误消息：数据库操作异常，查询失败!
			merchants.setMessageCode(IConstant.EMSG0004);
			merchants.setRetErrFlag(true);
			merchants.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", merchants);
			return rtn;
		}
	}

	@Override
	/**
	 * 修复通知单查询
	 * @title getList
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Outsidefactory entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Merchants mere = new Merchants();
		try {
			// 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
			List<Outsidefactory> list =  outsidefactoryDao.searchByPrimaryViewForBack(entity);
			// 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC

			for (Outsidefactory outList : list) {
				int c =Integer.parseInt(outList.getExpandSpace3());
				int s1 = Integer.parseInt(outList.getNumberGrinding());


				mere.setMerchantsID(outList.getMerchantsID());
				List<Merchants> merList = (List<Merchants>) merchantsDao.searchByList(mere);
				if (merList.size()>1||merList.size()==0){
					outList.setMerchantsID("");
				}else {
					outList.setMerchantsID(merList.get(0).getMerchantsName());

				}
			}

			if (list.size() <= 0) {
				list = new ArrayList<Outsidefactory>();
				Outsidefactory outsidefactory = new Outsidefactory();
				outsidefactory.setMessageCode(IConstant.EMSG0001);
				outsidefactory.setRetErrFlag(true);
				list.add(outsidefactory);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				//int total = outsidefactoryDao.searchByCount(entity);
				// 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
				int total = outsidefactoryDao.searchByPrimaryViewCountForBack(entity);
				// 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC

				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("numb", list.size());
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Outsidefactory> list = new ArrayList<Outsidefactory>();
			Outsidefactory outsidefactory = new Outsidefactory();
			outsidefactory.setMessageCode(IConstant.EMSG0004);
			outsidefactory.setRetErrFlag(true);
			outsidefactory.setExceMessage(e.getMessage());
			list.add(outsidefactory);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	private VoutsidefactoryDao voutsidefactoryDao;

	public void setVoutsidefactoryDao(VoutsidefactoryDao voutsidefactoryDao) {
		this.voutsidefactoryDao = voutsidefactoryDao;
	}

	@Override
	public Map<String, Object> getLists(Voutsidefactory entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Voutsidefactory voutsidefactory = null;
		try {
			List<Voutsidefactory> list = (List<Voutsidefactory>) voutsidefactoryDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Voutsidefactory>();
				voutsidefactory = new Voutsidefactory();
				voutsidefactory.setMessageCode(IConstant.EMSG0001);
				voutsidefactory.setRetErrFlag(true);
				list.add(voutsidefactory);
				rtn.put("rows", null);
				rtn.put("error", list);
			} else {
				int total = voutsidefactoryDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Voutsidefactory> list = new ArrayList<Voutsidefactory>();
			voutsidefactory = new Voutsidefactory();
			voutsidefactory.setMessageCode(IConstant.EMSG0004);
			voutsidefactory.setRetErrFlag(true);
			voutsidefactory.setExceMessage(e.getMessage());
			list.add(voutsidefactory);
			rtn.put("rows", null);
			rtn.put("error", list);
		}
		return rtn;
	}





	@Override
	public Map<String, Object> getlistsMer(Merchants entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Merchants merchants = null;
		try {
			List<Merchants> list = (List<Merchants>) merchantsDao.searchByList(entity);

			if (list.size() <= 0) {
				list = new ArrayList<Merchants>();
				merchants = new Merchants();
				merchants.setMessageCode(IConstant.EMSG0001);
				merchants.setRetErrFlag(true);
				list.add(merchants);
				rtn.put("rows", null);
				rtn.put("error", list);
			} else {
				int total = merchantsDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Merchants> list = new ArrayList<Merchants>();
			merchants = new Merchants();
			merchants.setMessageCode(IConstant.EMSG0004);
			merchants.setRetErrFlag(true);
			merchants.setExceMessage(e.getMessage());
			list.add(merchants);
			rtn.put("rows", null);
			rtn.put("error", list);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> outFactoryAdd(Outsidefactory outsidefactory, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//成功消息：插入成功
			outsidefactoryDao.insert(outsidefactory);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

		} catch (SQLException e) {
			Outsidefactory entity = new Outsidefactory();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
		}
		return rtn;
	}

	/**
	 * 商家添加
	 *
	 * @param merchants
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	@Override
	public Map<String, Object> merchantsAdd(Merchants merchants, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//成功消息：插入成功
			merchantsDao.insert(merchants);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
		} catch (SQLException e) {
			Merchants entity = new Merchants();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
		}
		return rtn;
	}

	/**
	 * 商家编辑
	 *
	 * @param merchants
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	@Override
	public Map<String, Object> merchantEdit(Merchants merchants, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Merchants entity = null;
		int reVal = 0;
		try {
			reVal = merchantsDao.updateNonQuery(merchants);
			if (reVal > 0) {
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0005, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
			} else {
				entity = new Merchants();
				//错误消息：数据库操作异常，更新失败!
				entity.setMessageCode(IConstant.EMSG0006);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
			}
		} catch (SQLException e) {
			entity = new Merchants();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> merchantDel(Merchants merchants, String langCode, String langValue,String userID) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 更新失败! 进行数据排他验证
			Merchants entity = new Merchants();
			//      entity.setMerchantsID(merchants.getMerchantsIDWhere());
			//   entity.setUpdateTime(merchants.getUpdateTimeWhere());
			//   entity.setUpdateUser(merchants.getUpdateUserWhere());
			//   entity.setVersion(merchants.getVersionWhere());
         /*   List<Merchants> list = (List<Merchants>) merchantsDao
                    .searchByList(entity);
            if (list == null || list.size() == 0) {
                entity = new Merchants();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);
                return rtn;
            }*/
			// 删除成功
			merchantsDao.updateNonQuery(merchants);
			merchants = new Merchants();
			List<Merchants> ulist = (List<Merchants>) merchantsDao.searchByList(merchants);
			if (ulist == null || ulist.size() == 0) {
				merchants = new Merchants();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				merchants.setMessageCode(IConstant.WMSG0009);
				merchants.setRetErrFlag(true);
				rtn.put("error", merchants);
				rtn.put("data", null);
				rtn.put("status", IConstant.RESULT_CODE_1);

			}else {
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0003, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
			}

			return rtn;
		} catch (SQLException e) {
			Merchants entity = new Merchants();
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);

		}
		return rtn;
	}

	@Override
	public List<Merchants> getPartsLine() {
		List<Merchants> list = null;
		try {
			Merchants entity = new Merchants();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			list = (List<Merchants>) merchantsDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Merchants>();
				Merchants merchants = new Merchants();
				// 消息：检索为0
				merchants.setMessageCode(IConstant.EMSG0001);
				merchants.setRetErrFlag(false);
				list.add(merchants);
			}
			return list;
		} catch (SQLException e) {
			list = new ArrayList<Merchants>();
			Merchants merchants = new Merchants();
			// 错误消息：数据库操作异常，查询失败!
			merchants.setMessageCode(IConstant.EMSG0004);
			merchants.setRetErrFlag(true);
			merchants.setExceMessage(e.getMessage());
			list.add(merchants);

		}
		return list;
	}

	@Override
	public Map<String, Object> merchantsFind(Merchants param) {
		Map<String, Object> rtn = new HashMap<String, Object>();

		Merchants entity = new Merchants();
		try {
			// 更新失败! 进行数据排他验证
			List<Merchants> list = (List<Merchants>) merchantsDao.searchByList(param);
			if (list == null || list.size() == 0) {
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
			} else {
				rtn.put("data", list.get(0));
			}
		} catch (SQLException e) {
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
		}
		return rtn;
	}

	@Override
	public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, int checkType,String userID) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 错误信息
		Map<String, String> map = new HashMap<String, String>();
		Merchants entity = new Merchants();
		if (checkType == 1){
			// 页面名称
			if (StringUtils.isEmpty(param.get("DIVmerchantsCode").toString())) {
				map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
						IConstant.MARSGL0001, langCode, langValue));
			}else{
				try {
					Merchants mer = new Merchants();
					mer.setMerchantsCold(param.get("DIVmerchantsCode").toString());
					mer.setDelFlag(IConstant.STRING_0);
					List<Merchants> mList = (List<Merchants>)merchantsDao.searchByList(mer);
					if (mList.size()>0){
						map.put("DIVmerchantsCode", MessageReSource.getMessageBox(
								IConstant.MARSGLS0008, langCode, langValue));
					}else {
						entity.setMerchantsCold(param.get("DIVmerchantsCode").toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				entity.setMerchantsCold(param.get("DIVmerchantsCode").toString());
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsName").toString())) {
				map.put("DIVmerchantsName", MessageReSource.getMessageBox(
						IConstant.MARSGL0002, langCode, langValue));
			}else{
				entity.setMerchantsName(param.get("DIVmerchantsName").toString());
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsType").toString())) {
				map.put("DIVmerchantsType", MessageReSource.getMessageBox(
						IConstant.MARSGL0003, langCode, langValue));
			}else{
				entity.setMerchantsType(param.get("DIVmerchantsType").toString());
			}


			if (StringUtils.isEmpty(param.get("DIVmerchantsUser").toString())) {
				map.put("DIVmerchantsUser", MessageReSource.getMessageBox(
						IConstant.MARSGL0004, langCode, langValue));
			}else{
				entity.setInnerName(param.get("DIVmerchantsUser").toString());
			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsTel").toString())) {
				map.put("DIVmerchantsTel", MessageReSource.getMessageBox(
						IConstant.MARSGL0005, langCode, langValue));
			}else{
				if (Ctl.checkString(0,param.get("DIVmerchantsTel").toString())){
					entity.setMerchantsTel(param.get("DIVmerchantsTel").toString());
				}else {
					map.put("DIVmerchantsTel", MessageReSource.getMessageBox(
							IConstant.MARSGLS0008, langCode, langValue));
				}

			}
			if (StringUtils.isEmpty(param.get("DIVmerchantsAdd").toString())) {//地址
				map.put("DIVmerchantsAdd", MessageReSource.getMessageBox(
						IConstant.MARSGL0006, langCode, langValue));
			}else{
				entity.setMerchantsAddrss(param.get("DIVmerchantsAdd").toString());
			}


			// 如果是新增
			if (map.size() <= 0) {
				entity.setVersion(BigDecimal.ZERO);// 版本号
				entity.setDelFlag(IConstant.DEL_FLAG_0);
				entity.setMerchantsID(NextKeyValue.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION,
						IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity.getUpdateUser()));// 取得主键
				entity.setCreateTime(new Date());// 创建时间
				entity.setCreateUser(userID);// 创建者
				entity.setUpdateTime(new Date());// 更新时间
				entity.setUpdateUser(userID);// 更新者
			} else {
				rtn.put("message", map);
			}

		} else if (checkType == 2) {
			// 如果是编辑
			entity.setUpdateTime(new Date());// 更新时间
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			entity.setUpdateUser(userID);// 更新者
			if (map.size() <= 0) {
				entity.setUpdateTime(new Date());
			} else {
				rtn.put("message", map);
			}
		}
		rtn.put("data", entity);
		rtn.put("status", IConstant.RESULT_CODE_2);

		return rtn;

	}

	@Override
	public List<Outsidefactory> outFactoryList(Outsidefactory out){
		List<Outsidefactory> outsidefactoriesList =null;
		try {
			outsidefactoriesList= (List<Outsidefactory> )outsidefactoryDao.searchByList(out);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outsidefactoriesList;
	}

	@Override
	public Map<String, Object> getOutList(Outsidefactory entity){

		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Outsidefactory> list = outsidefactoryDao.getDetailList(entity);

			if (list.size() <= 0) {
				Outsidefactory outsidefactory = new Outsidefactory();
				//消息：检索为0
				outsidefactory.setMessageCode(IConstant.EMSG0001);
				outsidefactory.setRetErrFlag(true);
				rtn.put("data", outsidefactory);
				rtn.put("error", outsidefactory);
				return rtn;
			} else {
				rtn.put("data", list);
				return rtn;
			}

		} catch (SQLException e) {
			Outsidefactory outsidefactory = new Outsidefactory();
			//错误消息：数据库操作异常，查询失败!
			outsidefactory.setMessageCode(IConstant.EMSG0004);
			outsidefactory.setRetErrFlag(true);
			outsidefactory.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", outsidefactory);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getOutListInfo(Outsidefactory entity) {

		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Outsidefactory> list = (List<Outsidefactory>) outsidefactoryDao.searchByPrimaryViewDetail(entity);

			if (list.size() <= 0) {
				Outsidefactory outsidefactory = new Outsidefactory();
				//消息：检索为0
				outsidefactory.setMessageCode(IConstant.EMSG0001);
				outsidefactory.setRetErrFlag(true);
				rtn.put("data", outsidefactory);
				rtn.put("error", outsidefactory);
				return rtn;
			} else {
				rtn.put("data", list);
				return rtn;
			}

		} catch (SQLException e) {
			Outsidefactory outsidefactory = new Outsidefactory();
			//错误消息：数据库操作异常，查询失败!
			outsidefactory.setMessageCode(IConstant.EMSG0004);
			outsidefactory.setRetErrFlag(true);
			outsidefactory.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", outsidefactory);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> outsidefactoryEdid(Outsidefactory outsidefactory, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Outsidefactory entity = null;
		int reVal = 0;
		try {
			reVal = outsidefactoryDao.updateNonQuery(outsidefactory);
			if (reVal > 0) {
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0005, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
			} else {
				entity = new Outsidefactory();
				//错误消息：数据库操作异常，更新失败!
				entity.setMessageCode(IConstant.EMSG0006);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
			}
		} catch (SQLException e) {
			entity = new Outsidefactory();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
		}
		return rtn;
	}

	@Override
	public List<Tool> toolListB(Tool t) {

		List<Tool> toolList = new ArrayList<Tool>();
		try {
			toolList= (List<Tool>) toolDao.searchByList(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toolList;

	}

	@Override
	public List<Merchants> getMerchan(Merchants mer) {
		List<Merchants>   mList =new ArrayList<Merchants>();
		try {
			mList = (List<Merchants>)merchantsDao.searchByList(mer);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mList;
	}

	@Override
	public String getNumber() {
		int total =0;
		try {
			total = outsidefactoryDao.searchByCount(new Outsidefactory());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}

	@Override
	public String getMnumber() {
		int total = 0;
		try {
			total= merchantsDao.searchByCount(new Merchants());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(total);
	}
}
