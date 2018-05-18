package com.icomp.common.service.impl.icomp.v01b08.s012;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b08.s012.ICOMPV01B08S012Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.AssemblylineDao;
import com.icomp.dao.PartsDao;
import com.icomp.dao.VassemblylineDao;
import com.icomp.dao.VpartsDao;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Vparts;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01B08S012ServiceImpl extends BaseService implements ICOMPV01B08S012Service {

	private AssemblylineDao assemblylineDao;
	private VpartsDao vpartsDao;
	private PartsDao partsDao;

	public void setPartsDao(PartsDao partsDao) {
		this.partsDao = partsDao;
	}

	public void setVpartsDao(VpartsDao vpartsDao) {
		this.vpartsDao = vpartsDao;
	}

	public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
		this.assemblylineDao = assemblylineDao;
	}

	private VassemblylineDao vassemblylineDao;

	public void setVassemblylineDao(VassemblylineDao vassemblylineDao) {
		this.vassemblylineDao = vassemblylineDao;
	}

	/**
	 * 零部件管理
	 * @param entity 页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> getList(Vparts entity){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vparts> list = (List<Vparts>) vpartsDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vparts>();
				Vparts vparts = new Vparts();
				//消息：检索为0
				vparts.setMessageCode(IConstant.EMSG0001);
				vparts.setRetErrFlag(true);
				list.add(vparts);
				rtn.put("rows", null);
				rtn.put("error", list);

			} else {
				int total = vpartsDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			List<Vparts> list = new ArrayList<Vparts>();
			Vparts vparts = new Vparts();
			//错误消息：数据库操作异常，查询失败!
			vparts.setMessageCode(IConstant.EMSG0004);
			vparts.setRetErrFlag(true);
			vparts.setExceMessage(e.getMessage());
			list.add(vparts);
			rtn.put("rows", null);
			rtn.put("error", list);

		}
		return rtn;
	}

	/**
	 * 零部件管理
	 * @param entity 页面查询条件
	 * @return 零部件信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> assemblyLineInfo(Assemblyline entity){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Assemblyline> list = (List<Assemblyline>) assemblylineDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Assemblyline assemblyline = new Assemblyline();
				//消息：检索为0
				assemblyline.setMessageCode(IConstant.EMSG0001);
				assemblyline.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", assemblyline);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Assemblyline assemblyline = new Assemblyline();
			//错误消息：数据库操作异常，查询失败!
			assemblyline.setMessageCode(IConstant.EMSG0004);
			assemblyline.setRetErrFlag(true);
			assemblyline.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", assemblyline);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> paInfo(Parts entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Parts> list = (List<Parts>) partsDao.searchByList(entity);
			if (list.size() <= 0) {
				Parts parts = new Parts();
				//消息：检索为0
				parts.setMessageCode(IConstant.EMSG0001);
				parts.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", parts);

			} else {
				rtn.put("data", list.get(0));
			}
		} catch (SQLException e) {
			Parts parts = new Parts();
			//错误消息：数据库操作异常，查询失败!
			parts.setMessageCode(IConstant.EMSG0004);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", parts);
		}
		return rtn;
	}

	/**
	 * 零部件删除
	 * @param entity 页面查询条件
	 * @return 零部件信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> assemblyLineDelete(Assemblyline entity,String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Assemblyline assemblyline = new Assemblyline();
			assemblyline.setAssemblyLineID(entity.getAssemblyLineIDWhere());
			assemblyline.setUpdateTime(entity.getUpdateTimeWhere());
			assemblyline.setUpdateUser(entity.getUpdateUserWhere());
			assemblyline.setVersion(entity.getVersionWhere());
			List<Assemblyline> list = (List<Assemblyline>) assemblylineDao
					.searchByList(assemblyline);
			if (list == null || list.size() == 0) {
				entity = new Assemblyline();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = assemblylineDao.updateNonQuery(entity);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Assemblyline assemblyline = new Assemblyline();
			//错误消息：数据库操作异常，删除失败!
			assemblyline.setMessageCode(IConstant.EMSG0008);
			assemblyline.setRetErrFlag(true);
			assemblyline.setExceMessage(e.getMessage());
			rtn.put("error", assemblyline);
			rtn.put("data", null);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> partslyLineDelete(Parts entity, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Parts parts = new Parts();
			parts.setPartsID(entity.getPartsIDWhere());
			parts.setUpdateTime(entity.getUpdateTimeWhere());
			parts.setUpdateUser(entity.getUpdateUserWhere());
			parts.setVersion(entity.getVersionWhere());
			List<Parts> list = (List<Parts>) partsDao
					.searchByList(parts);
			if (list == null || list.size() == 0) {
				entity = new Parts();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);

			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = partsDao.updateNonQuery(entity);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Parts parts = new Parts();
			//错误消息：数据库操作异常，删除失败!
			parts.setMessageCode(IConstant.EMSG0008);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			rtn.put("error", parts);
			rtn.put("data", null);

		}
		return rtn;
	}


	/**
	 * 新建零部件信息
	 * @param entity
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> assemblyLineAdd(Assemblyline entity,String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			entity.setAssemblyLineID(NextKeyValue.getNextkeyvalue(
					IConstant.ASSEMBLYLINE, IConstant.ASSEMBLYLINEID, entity.getUpdateUser()));// 取得角色表主键
			assemblylineDao.insert(entity);

			//成功消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;
		} catch (SQLException e) {
			Assemblyline assemblyline = new Assemblyline();
			//错误消息：数据库操作异常，插入失败!
			assemblyline.setMessageCode(IConstant.EMSG0007);
			assemblyline.setRetErrFlag(true);
			assemblyline.setExceMessage(e.getMessage());
			rtn.put("error", assemblyline);
			rtn.put("data", null);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> partsLineAdd(Parts entity, String langCode, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			entity.setPartsID(NextKeyValue.getNextkeyvalue(
					IConstant.PARTS, IConstant.PARTS_ID, entity.getUpdateUser()));// 取得角色表主键
			partsDao.insert(entity);

			//成功消息：插入成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);


		} catch (SQLException e) {
			Parts parts = new Parts();
			//错误消息：数据库操作异常，插入失败!
			parts.setMessageCode(IConstant.EMSG0007);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			rtn.put("error", parts);
			rtn.put("data", null);

		}
		return rtn;
	}


	/**
	 * 编辑零部件信息
	 * @param entity
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> parstEdit(Parts entity,String langCode,String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		Parts parts = new Parts();
		try {
			// 更新失败! 进行数据排他验证

			parts.setPartsID(entity.getPartsIDWhere());
			parts.setUpdateTime(entity.getUpdateTimeWhere());
			parts.setUpdateUser(entity.getUpdateUserWhere());
			parts.setVersion(entity.getVersionWhere());
			List<Parts> list = (List<Parts>) partsDao.searchByList(parts);
			if (list == null || list.size() == 0) {
				entity = new Parts();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
			}
			// 更新职务成功
			int ret = partsDao.updateNonQuery(entity);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);


		} catch (SQLException e) {
			parts = new Parts();
			//错误消息：数据库操作异常，更新失败!
			parts.setMessageCode(IConstant.EMSG0006);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			rtn.put("error", parts);
			rtn.put("data", null);
			return rtn;
		}
		return rtn;
	}

	@Override
	public List<Parts> getPartsLine() {
		try {
			Parts entity = new Parts();
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			List<Parts> list = (List<Parts>) partsDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Parts>();
				Parts parts = new Parts();
				// 消息：检索为0
				parts.setMessageCode(IConstant.EMSG0001);
				parts.setRetErrFlag(false);
				list.add(parts);
			}
			return list;
		} catch (SQLException e) {
			List<Parts> list = new ArrayList<Parts>();
			Parts parts = new Parts();
			// 错误消息：数据库操作异常，查询失败!
			parts.setMessageCode(IConstant.EMSG0004);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			list.add(parts);
			return list;
		}

	}

	/**
	 * 新建零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> checkInput(Map<String,Object> param,String langCode,String langValue,String userID,int checkType){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unused")
			Parts parts = new Parts();
			Map<String, String> map = new HashMap<String, String>();
			if(checkType ==1){ //新建
				//验证零部件是否填写
				if (StringUtils.isEmpty(param.get("DIVAssemblyLineName").toString())) {// 如果零部件名未输入
					map.put("DIVAssemblyLineName", MessageReSource.getMessageBox(
							IConstant.WMSGLY17, langCode, langValue));
				}else{
					//验证零部件名是否存在
					Parts entity = new Parts();
					entity.setPartsName(param.get("DIVAssemblyLineName").toString());
					entity.setDelFlag(IConstant.DEL_FLAG_0);
					List<Assemblyline> ret = (List<Assemblyline>)partsDao.searchByList(entity);
					if(ret.size() > 0){//零部件唯一性认证
						map.put("DIVAssemblyLineName", MessageReSource.getMessageBox(
								IConstant.WMSG0173, langCode, langValue));
					}
				}
				if (StringUtils.isEmpty(param.get("DIVAssemblyLineCode").toString())) {// 如果角色编码未输入
					map.put("DIVAssemblyLineCode", MessageReSource.getMessageBox(
							IConstant.WMSGLY17, langCode, langValue));
				}else{
					//验证零部件编码是否存在
					Parts entity = new Parts();
					entity.setPartsCode(param.get("DIVAssemblyLineCode").toString());
					entity.setDelFlag(IConstant.DEL_FLAG_0);
					List<Assemblyline> ret = (List<Assemblyline>)partsDao.searchByList(entity);
					if(ret.size() > 0){//零部件编码唯一性验证
						map.put("DIVAssemblyLineCode", MessageReSource.getMessageBox(
								IConstant.WMSG0174, langCode, langValue));
					}
				}
				// 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC
//				if (StringUtils.isEmpty(param.get("DIVAssemblyLineType").toString())) {// 零部件类型
//					map.put("DIVAssemblyLineType", MessageReSource.getMessageBox(
//							IConstant.WMSGLY18, langCode, langValue));
//				}else {
//					Parts entity = new Parts();
//					entity.setDelFlag(IConstant.DEL_FLAG_0);
//					entity.setPartsCode(param.get("DIVAssemblyLineType").toString());
//					List<Parts> ret = (List<Parts>)partsDao.searchByList(entity);
//				if(ret.size()>0){
//						map.put("DIVAssemblyLineType",MessageReSource.getMessageBox(IConstant.WMSG0017,langCode,langValue));
//					}
//				}
				// 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC
				if (StringUtils.isEmpty(param.get("DIVDelFlag").toString())) {// 如果删除区分未选择
					map.put("DIV_DelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			}else if(checkType ==2){ //编辑
				if (StringUtils.isEmpty(param.get("DIVAssemblyLineName").toString())) {// 如果零部件名未输入
					map.put("DIVAssemblyLineName", MessageReSource.getMessageBox(
							IConstant.WMSG0175, langCode, langValue));
				}
				if (StringUtils.isEmpty(param.get("DIVAssemblyLineCode").toString())) {// 如果零部件编码未输入
					map.put("DIVAssemblyLineCode", MessageReSource.getMessageBox(
							IConstant.WMSG0054, langCode, langValue));
				}
				// 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC
//				if (StringUtils.isEmpty(param.get("DIVAssemblyLineType").toString())) {// 如果语言未选择
//					map.put("DIVAssemblyLineType", MessageReSource.getMessageBox(
//							IConstant.WMSG0024, langCode, langValue));
//				}
				// 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC
				if (StringUtils.isEmpty(param.get("DIVDelFlag").toString())) {// 如果删除区分未选择
					map.put("DIVDelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			}
			if(map.size()>0){
				rtn.put("message", map);
				rtn.put("data", null);
				rtn.put("status", IConstant.RESULT_CODE_2);
			}
			return rtn;

		} catch (SQLException e){
			Parts parts = new Parts();
			//错误消息：数据库异常!
			parts.setMessageCode(IConstant.EMSG0004);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			rtn.put("error", parts);
			rtn.put("data", null);

		}
		return rtn;
	}

}