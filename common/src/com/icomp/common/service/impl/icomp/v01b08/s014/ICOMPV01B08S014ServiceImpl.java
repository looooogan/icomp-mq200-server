package com.icomp.common.service.impl.icomp.v01b08.s014;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b08.s014.ICOMPV01B08S014Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.RfidcontainerDao;
import com.icomp.dao.ToolshelfDao;
import com.icomp.dao.ToolshelflnkDao;
import com.icomp.dao.ToolshelfplaceDao;
import com.icomp.dao.VtoolshelfDao;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Toolshelf;
import com.icomp.entity.base.Toolshelflnk;
import com.icomp.entity.base.Toolshelfplace;
import com.icomp.entity.base.Vtoolshelf;

public class ICOMPV01B08S014ServiceImpl extends BaseService implements
		ICOMPV01B08S014Service {

	private ToolshelfDao toolshelfDao;
	private RfidcontainerDao rfidcontainerDao;
	private VtoolshelfDao vtoolshelfDao;
	private ToolshelflnkDao toolshelflnkDao;
	private ToolshelfplaceDao toolshelfplaceDao;

	public void setRfidcontainerDao(RfidcontainerDao rfidcontainerDao) {
		this.rfidcontainerDao = rfidcontainerDao;
	}

	public ToolshelfDao getToolshelfDao() {
		return toolshelfDao;
	}

	public void setToolshelfDao(ToolshelfDao toolshelfDao) {
		this.toolshelfDao = toolshelfDao;
	}

	public ToolshelflnkDao getToolshelflnkDao() {
		return toolshelflnkDao;
	}

	public void setToolshelflnkDao(ToolshelflnkDao toolshelflnkDao) {
		this.toolshelflnkDao = toolshelflnkDao;
	}

	public void setVtoolshelfDao(VtoolshelfDao vtoolshelfDao) {
		this.vtoolshelfDao = vtoolshelfDao;
	}

	public ToolshelfplaceDao getToolshelfplaceDao() {
		return toolshelfplaceDao;
	}

	public void setToolshelfplaceDao(ToolshelfplaceDao toolshelfplaceDao) {
		this.toolshelfplaceDao = toolshelfplaceDao;
	}

	/**
	 * 取得生产关联信息
	 * 
	 * @param Vtoolshelf
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vtoolshelf entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vtoolshelf> list = (List<Vtoolshelf>) vtoolshelfDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtoolshelf>();
				Vtoolshelf Vtoolshelf = new Vtoolshelf();
				// 消息：检索为0
				Vtoolshelf.setMessageCode(IConstant.EMSG0001);
				Vtoolshelf.setRetErrFlag(true);
				list.add(Vtoolshelf);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vtoolshelfDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
						/ IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtoolshelf> list = new ArrayList<Vtoolshelf>();
			Vtoolshelf Vtoolshelf = new Vtoolshelf();
			// 错误消息：数据库操作异常，查询失败!
			Vtoolshelf.setMessageCode(IConstant.EMSG0004);
			Vtoolshelf.setRetErrFlag(true);
			Vtoolshelf.setExceMessage(e.getMessage());
			list.add(Vtoolshelf);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 新建关联
	 * 
	 * @param Toolshelf
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> toolshelfAdd(Toolshelf toolshelf,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			Toolshelflnk toolshelflnk = new Toolshelflnk();
			toolshelflnk.setToolShelfID(toolshelf.getToolShelfID());
			List<Toolshelflnk> list = (List<Toolshelflnk>) toolshelflnkDao
					.searchByList(toolshelflnk);
			// 验证是否已经存在
			if (list.size() > 0) {
				Toolshelflnk tslEntity = new Toolshelflnk();
				tslEntity.setMessageCode(IConstant.EMSG0001);
				tslEntity.setRetErrFlag(true);
				rtn.put("status", IConstant.RESULT_CODE_2);// 异常
				rtn.put("rows", null);
				rtn.put("error", tslEntity);
				return rtn;
			} else {
				// 插入工具盘
				toolshelfDao.insert(toolshelf);
				// 获取工具盘位置信息
				Toolshelfplace toolShelfPlace = new Toolshelfplace();
				List<Toolshelfplace> ToolshelfplaceList = (List<Toolshelfplace>) toolshelfplaceDao
						.searchByList(toolShelfPlace);
				for (Toolshelfplace tsp : ToolshelfplaceList) {
					// 插入工具盘位置信息
					Toolshelflnk newEntity = new Toolshelflnk();
					newEntity.setToolShelfLnkID(NextKeyValue.getNextkeyvalue(
							IConstant.TOOL_SHELF_LNK,
							IConstant.TOOL_SHELF_LNK_ID, toolshelf
									.getUpdateUser()));// 取得表主键
					newEntity.setToolShelfID(toolshelf.getToolShelfID());
					newEntity
							.setToolShelfPlaceNumber(tsp.getToolShelfPlaceID());
					toolshelflnkDao.insert(newEntity);

				}
				// 添加rfid关联数据
				Rfidcontainer rfidcontainer = new Rfidcontainer();
				rfidcontainer.setRfidContainerID(NextKeyValue.getNextkeyvalue(
						IConstant.RFIDCONTAINER, IConstant.RFIDCONTAINERID,
						toolshelf.getUpdateUser()));// 取得表主键
				rfidcontainer.setToolShelfID(toolshelf.getToolShelfID());// 工具盘id
				rfidcontainer.setDelFlag(toolshelf.getDelFlag());// 删除区分
				rfidcontainer.setUpdateTime(toolshelf.getUpdateTime());// 更新时间
				rfidcontainer.setUpdateUser(toolshelf.getUpdateUser());// 更新者
				rfidcontainer.setBandType(IConstant.BAND_TYPE_2);// 更新者
				rfidcontainer.setVersion(BigDecimal.ZERO);// 版本号
				rfidcontainerDao.insert(rfidcontainer);
				// 成功消息：插入成功
				rtn.put("message", MessageReSource.getMessageBox(
						IConstant.IMSG0004, langCode, langValue));
				rtn.put("status", IConstant.RESULT_CODE_0);
				return rtn;
			}
		} catch (SQLException e) {
			Toolshelflnk entity = new Toolshelflnk();
			// 错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("status", IConstant.RESULT_CODE_2);
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 删除工具盘
	 * 
	 * @param toolshelf
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> toolshelfDelete(Toolshelf toolshelf,
			String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除工具盘位置信息
			Toolshelflnk searchEntity = new Toolshelflnk();
			searchEntity.setToolShelfIDWhere(toolshelf.getToolShelfIDWhere());
			toolshelflnkDao.delete(searchEntity);
			// 验证是否已经存在
			Toolshelf tfSearchEntity = new Toolshelf();
			tfSearchEntity.setToolShelfID(toolshelf.getToolShelfIDWhere());
			List<Toolshelf> list = (List<Toolshelf>) toolshelfDao
					.searchByList(tfSearchEntity);
			if (list.size() < 0) {
				Toolshelf tslEntity = new Toolshelf();
				tslEntity.setMessageCode(IConstant.EMSG0001);
				tslEntity.setRetErrFlag(true);
				rtn.put("status", IConstant.RESULT_CODE_2);// 异常
				rtn.put("rows", null);
				rtn.put("error", tslEntity);
				return rtn;
			} else {

				// 更新工具盘为无效
				toolshelf.setDelFlag(IConstant.DEL_FLAG_1);
				toolshelfDao.updateNonQuery(toolshelf);
			}
			Rfidcontainer rfidcontainerEntity = new Rfidcontainer();
			rfidcontainerEntity.setToolShelfID(toolshelf.getToolShelfIDWhere());
			List<Rfidcontainer> Rfidclist = (List<Rfidcontainer>) rfidcontainerDao
					.searchByList(rfidcontainerEntity);
			if(Rfidclist.size()>0){
				// 更新Rfidcontainer的工具盘为无效
				Rfidcontainer rfidcEntity = new Rfidcontainer();
				rfidcEntity.setToolShelfIDWhere(toolshelf.getToolShelfIDWhere());
				rfidcEntity.setDelFlag(IConstant.DEL_FLAG_1);
				rfidcontainerDao.updateNonQuery(rfidcEntity);
			}
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);// 正常
			return rtn;
		} catch (SQLException e) {
			Toolshelf entity = new Toolshelf();
			// 错误消息：数据库操作异常，删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("status", IConstant.RESULT_CODE_2);// 异常
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 验证用户输入信息
	 * 
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @param userID
	 * @param checkType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String userID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Toolshelf toolshelf = new Toolshelf();
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (StringUtils.isEmpty(param.get("DivToolShelfCode").toString())) {
				// 请输入刀具盘编码
				map.put("DivToolShelfCode", MessageReSource.getMessageBox(
						IConstant.EWMSG0270, langCode, langValue));
			} else if (param.get("DivToolShelfCode").toString().length() > 6) {
				// 请输入刀具盘编码
				map.put("DivToolShelfCode",MessageReSource.getMessageBox(
						IConstant.EWMSG0271, langCode, langValue));
			} else {
				toolshelf.setToolShelfCode(param.get("DivToolShelfCode")
						.toString());
				// 唯一性验证
				Toolshelf searchEntity = new Toolshelf();
				searchEntity.setToolShelfCode(param.get("DivToolShelfCode")
						.toString());
				searchEntity.setDelFlag(IConstant.DEL_FLAG_0);
				List<Toolshelf> list = (List<Toolshelf>) toolshelfDao
						.searchByList(searchEntity);
				if (list.size() > 0) {
					// 您所新建的刀具盘编码已存在!
					map.put("DivToolShelfCode",MessageReSource.getMessageBox(
							IConstant.EWMSG0272, langCode, langValue));
				}
			}
			if (map.size() > 0) {
				rtn.put("message", map);
				rtn.put("data", null);
				rtn.put("status", IConstant.RESULT_CODE_2);// 异常
			} else {
				toolshelf.setToolShelfID(NextKeyValue.getNextkeyvalue(
						IConstant.TOOL_SHELF, IConstant.TOOL_SHELF_ID,
						toolshelf.getUpdateUser()));// 取得表主键
				toolshelf.setDelFlag(IConstant.DEL_FLAG_0);
				toolshelf.setCreateTime(new Date());// 创建时间
				toolshelf.setCreateUser(userID);// 创建者
				toolshelf.setUpdateTime(new Date());// 更新时间
				toolshelf.setUpdateUser(userID);// 更新者
				toolshelf.setVersion(BigDecimal.ZERO);// 版本号
				rtn.put("data", toolshelf);
				rtn.put("status", IConstant.RESULT_CODE_0);// 正常
			}
		} catch (SQLException e) {
			Toolshelf entity = new Toolshelf();
			// 错误消息：数据库操作异常，查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("status", IConstant.RESULT_CODE_2);// 异常
			rtn.put("data", null);
			return rtn;
		}
		return rtn;

	}

}