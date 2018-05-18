package com.icomp.common.service.impl.icomp.v01b09.s004;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b09.s004.ICOMPV01B09S004Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.ContainercarrierDao;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VdisplayeditemconfigurationDao;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.TooltransferTotal;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;


public class ICOMPV01B09S004ServiceImpl extends BaseService implements ICOMPV01B09S004Service{

	private VdisplayeditemconfigurationDao vdisplayeditemconfigurationDao;

	private DisplayeditemconfigurationDao displayeditemconfigurationDao;
	private ContainercarrierDao containercarrierDao;

	public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
		this.containercarrierDao = containercarrierDao;
	}

	public void setDisplayeditemconfigurationDao(
			DisplayeditemconfigurationDao displayeditemconfigurationDao) {
		this.displayeditemconfigurationDao = displayeditemconfigurationDao;
	}

	public void setVdisplayeditemconfigurationDao(
			VdisplayeditemconfigurationDao vdisplayeditemconfigurationDao) {
		this.vdisplayeditemconfigurationDao = vdisplayeditemconfigurationDao;
	}

	// 2017/09/13 宋健 追加↓↓↓　dazhong@YMSC
	private TooltransferDao tooltransferDao;

	public void setTooltransferDao(TooltransferDao tooltransferDao) {
		this.tooltransferDao = tooltransferDao;
	}
	// 2017/09/13 宋健 追加↑↑↑　dazhong@YMSC

	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Containercarrier entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Containercarrier> list = (List<Containercarrier>) containercarrierDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Containercarrier>();
				Containercarrier containercarrier = new Containercarrier();
				//消息：检索为0
				containercarrier.setMessageCode(IConstant.EMSG0001);
				containercarrier.setRetErrFlag(true);
				list.add(containercarrier);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = containercarrierDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
						/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Containercarrier> list = new ArrayList<Containercarrier>();
			Containercarrier containercarrier = new Containercarrier();
			//错误消息：数据库操作异常，查询失败!
			containercarrier.setMessageCode(IConstant.EMSG0004);
			containercarrier.setRetErrFlag(true);
			containercarrier.setExceMessage(e.getMessage());
			list.add(containercarrier);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	/**
	 * 新建打印项目信息
	 *

	 * @param langValue
	 * @return
	 */
	public Map<String, Object> printItemAdd(Containercarrier entity,
											String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
//
// entity.setDisplayedItemConfigurationID(NextKeyValue.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION, IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity.getUpdateUser()));// 取得部门表主键
			entity .setDelFlag(IConstant.DEL_FLAG_0);
			containercarrierDao.insert(entity);
			//插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,  langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Containercarrier containercarrier = new Containercarrier();
			//错误消息：数据库操作异常，插入失败!
			containercarrier.setMessageCode(IConstant.EMSG0007);
			containercarrier.setRetErrFlag(true);
			containercarrier.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	/**
	 * 打印项目删除
	 *
	 *            页面查询条件
	 * @return 打印项目信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")

	public Map<String, Object> printItemDelete(Containercarrier position, String langCode, String langValue) {

		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Containercarrier entity = new Containercarrier();
			entity.setContainerCarrierID(position.getContainerCarrierID());
			entity.setUpdateTime(position.getUpdateTimeWhere());
			entity.setUpdateUser(position.getUpdateUserWhere());
//			entity.setVersion(position.getVersionWhere());
			Containercarrier containercarrier = (Containercarrier) containercarrierDao.searchByPrimaryKey(entity);
			if (containercarrier == null ) {
				entity = new Containercarrier();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = containercarrierDao.updateNonQuery(position);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,  langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Containercarrier entity = new Containercarrier();
			//错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	/**
	 * 新建编辑的验证
	 * @param param      页面查询条件
	 * @param langCode   语言编码
	 * @param langValue  语言值

	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */
	@SuppressWarnings("unchecked")

	public Map<String, Object> checkInput(Map<String, Object> param,
										  String langCode, String langValue, String userID, int checkType) {
		// 返回值
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 错误信息
		Map<String, String> map = new HashMap<String, String>();
		Containercarrier entity = new Containercarrier();

		if (checkType == 1)
			// 取得页面值 验证是否为空并放入实体
//		   材料号
			if (StringUtils.isEmpty(param.get("DivCarrietCode").toString())) {
				map.put("DivCarrietCode", MessageReSource.getMessageBox(
						IConstant.JCSJRQGL001, langCode, langValue));
			}else{
				entity.setContainerCarrierCode(param.get("DivCarrietCode").toString());
			}
//		容器名称
		if (StringUtils.isEmpty(param.get("DivCarrietName").toString())) {
			map.put("DivCarrietName", MessageReSource.getMessageBox(
					IConstant.JCSJRQGL002, langCode, langValue));
		}else{

			entity.setContainerCarrierName(param.get("DivCarrietName").toString());
		}
//		容器类型
		if (StringUtils.isEmpty(param.get("DivCarrietType").toString())) {
			map.put("DivCarrietType", MessageReSource.getMessageBox(
					IConstant.WMSG0098, langCode, langValue));
		}else{
			entity.setContainerCarrierType(param.get("DivCarrietType").toString());
		}
//		rfid是否绑定
//            if (StringUtils.isEmpty(param.get("DivCarrietRFID").toString())) {
//                map.put("DivCarrietRFID", MessageReSource.getMessageBox(
//                        IConstant.WMSG0098, langCode, langValue));
//            }else{
//                entity.setRfidContainerID(String.valueOf(new BigDecimal(param.get("DivCarrietRFID").toString())));
//            }
//			负责人
		if (StringUtils.isEmpty(param.get("DivPerson").toString())) {
			map.put("DivPerson", MessageReSource.getMessageBox(
					IConstant.JCSJRQGL003, langCode, langValue));
		}else{
			entity.setPerson(param.get("DivPerson").toString());
		}

		// 如果是新增
		if(checkType==1) {
			if (map.size() <= 0) {
				//entity.setItemType( param.get("DIVItemType").toString());
				entity.setVersion(BigDecimal.ZERO);// 版本号
				entity.setContainerCarrierID(NextKeyValue
						.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION,
								IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity
										.getUpdateUser()));// 取得主键
				entity.setCreateTime(new Date());// 创建时间
				entity.setCreateUser(userID);// 创建者
				entity.setUpdateTime(new Date());// 更新时间
				entity.setUpdateUser(userID);// 更新者
			} else {
				rtn.put("message", map);
			}
		}

		if (checkType == 2) {
			// 如果是编辑
			if (map.size() <= 0) {
				entity.setUpdateUser(userID);
				entity.setUpdateTime(new Date());
				entity.setContainerCarrierIDWhere(param.get("containerCarrierID").toString());
				entity.setUpdateUserWhere(param.get("DivUpdateUser").toString());
				entity.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
			} else {
				rtn.put("message", map);
			}
		}
		rtn.put("data", entity);
		rtn.put("status", IConstant.RESULT_CODE_2);

		return rtn;
	}

	/**
	 * 编辑打印项目信息

	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")

	public Map<String, Object> printEdit(Containercarrier position,
										 String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Containercarrier entity = new Containercarrier();
			entity.setContainerCarrierIDWhere(position.getContainerCarrierID());
			entity.setUpdateTime(position.getUpdateTimeWhere());
			entity.setUpdateUser(position.getUpdateUserWhere());
			List<Containercarrier> list = (List<Containercarrier>) containercarrierDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Containercarrier();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);

			}
			// 更新项目打印成功
			@SuppressWarnings("unused")
			int ret = containercarrierDao.updateNonQuery(position);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,  langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);


		} catch (SQLException e) {
			Containercarrier entity = new Containercarrier();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);

		}
		return rtn;
	}
	/**
	 * 项目打印管理
	 *
	 * @param entity
	 *            页面查询条件
	 * @return 项目打印信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")

	public Map<String, Object> getprintItemInfo(
			Containercarrier entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Containercarrier> list = (List<Containercarrier>) containercarrierDao.searchByList(entity);
			if (list.size() <= 0) {
				Containercarrier containercarrier = new Containercarrier();
				//消息：检索为0
				containercarrier.setMessageCode(IConstant.EMSG0001);
				containercarrier.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", containercarrier);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Containercarrier containercarrier = new Containercarrier();
			//错误消息：数据库操作异常，查询失败!
			containercarrier.setMessageCode(IConstant.EMSG0004);
			containercarrier.setRetErrFlag(true);
			containercarrier.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", containercarrier);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> itemDelete(TooltransferTotal entity, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			// 删除成功
			tooltransferDao.updateNum(entity);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,  langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			TooltransferTotal entity1 = new TooltransferTotal();
			//错误消息：数据库操作异常，删除失败!
			entity1.setMessageCode(IConstant.EMSG0008);
			entity1.setRetErrFlag(true);
			entity1.setExceMessage(e.getMessage());
			rtn.put("error", entity1);
			rtn.put("data", null);
			return rtn;
		}
	}

}
