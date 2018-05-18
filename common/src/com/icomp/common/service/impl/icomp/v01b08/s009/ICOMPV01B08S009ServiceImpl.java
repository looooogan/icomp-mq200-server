package com.icomp.common.service.impl.icomp.v01b08.s009;

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
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b08.s009.ICOMPV01B08S009Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.PartsDao;
import com.icomp.dao.VpartsDao;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Vparts;

public class ICOMPV01B08S009ServiceImpl extends BaseService implements
		ICOMPV01B08S009Service {

	/**
	 * 零部件配置Dao
	 */		
    private PartsDao partsDao;
    
	public void setPartsDao(PartsDao partsDao) {
		this.partsDao = partsDao;
	}
	
	/**
	 * 零部件视图配置Dao
	 */		
	private VpartsDao vpartsDao;

	public void setVpartsDao(VpartsDao vpartsDao) {
		this.vpartsDao = vpartsDao;
	}

	/**
	 * 零部件配置
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 手持机配置信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vparts entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vparts> list = (List<Vparts>) vpartsDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vparts>();
				Vparts vparts = new Vparts();
				//消息：检索为0
				vparts.setMessageCode(IConstant.EMSG0001);
				vparts.setRetErrFlag(true);
				list.add(vparts);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vpartsDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
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
			return rtn;
		}
	}

	/**
	 * 零部件配置删除
	 * @param parts 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> partsDelete(Parts parts, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Parts entity = new Parts();
			entity.setLanguageCode(parts.getLanguageCodeWhere());
			entity.setUpdateTime(parts.getUpdateTimeWhere());
			entity.setUpdateUser(parts.getUpdateUserWhere());
			entity.setVersion(parts.getVersionWhere());
			List<Parts> list = (List<Parts>) partsDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Parts();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = partsDao.updateNonQuery(parts);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Parts entity = new Parts();
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
	 * 零部件配置新建
	 * @param parts 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	public Map<String, Object> partsAdd(Parts parts, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			parts.setPartsID(NextKeyValue.getNextkeyvalue(
					IConstant.PARTS, IConstant.PARTS_ID, parts.getUpdateUser()));// 取得零部件表主键
			partsDao.insert(parts);
			//成功消息：新建成功
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Parts entity = new Parts();
			//错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}


	/**
	 * 取得待处理零部件配置
	 * @param entity 页面查询条件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPartsInfo(Parts entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Parts> list = (List<Parts>) partsDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Parts parts = new Parts();
				//消息：检索为0
				parts.setMessageCode(IConstant.EMSG0001);
				parts.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", parts);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Parts parts = new Parts();	
			//错误消息：数据库操作异常，查询失败!
			parts.setMessageCode(IConstant.EMSG0004);
			parts.setRetErrFlag(true);
			parts.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", parts);
			return rtn;
		}
	}

	/**
	 * 编辑零部件配置
	 * @param parts 页面查询条件
	 * @param lang 语言
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> partsEdit(Parts parts, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 编辑失败! 进行数据排他验证
			Parts entity = new Parts();
			entity.setPartsID(parts.getPartsIDWhere());
			entity.setUpdateTime(parts.getUpdateTimeWhere());
			entity.setUpdateUser(parts.getUpdateUserWhere());
			entity.setVersion(parts.getVersionWhere());
			List<Parts> list = (List<Parts>) partsDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Parts();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 成功消息：更新成功
			@SuppressWarnings("unused")
			int ret = partsDao.updateNonQuery(parts);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Parts entity = new Parts();
			//消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
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
	 * @param customerID 用户ID
	 * @param checkType  1代表新建，2代表编辑
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Parts parts = new Parts();		
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try{
			
				//工艺名称验证
				if(StringUtils.isEmpty(param.get("DIVPartsName").toString())){
					//请输入工艺名称!
					map.put("DIVPartsName",MessageReSource.getMessageBox(
							IConstant.WMSG0202, langCode, langValue));
				}else{
					//唯一性验证
					if(checkType == 1){
						Parts entity = new Parts();
						entity.setPartsName(param.get("DIVPartsName").toString());
						List<Parts> list = (List<Parts>)partsDao.searchByList(entity);
						if(list.size()>0){
							//消息：您所新建的工艺名称已存在!
							map.put("DIVPartsName", MessageReSource.getMessageBox(
									IConstant.WMSG0203, langCode, langValue));
				        }
					}
				}
				//工艺编码验证
				if(StringUtils.isEmpty(param.get("DIVPartsCode").toString())){
					map.put("DIVPartsCode",MessageReSource.getMessageBox(
							IConstant.WMSG0204, langCode, langValue));
				}else{
					//唯一性验证
					if(checkType == 1){
					Parts entity = new Parts();
					entity.setPartsCode(param.get("DIVPartsCode").toString());
					List<Parts> list = (List<Parts>)partsDao.searchByList(entity);
					if(list.size()>0){
						//消息：您所新建的工艺编码已存在!
						map.put("DIVPartsCode", MessageReSource.getMessageBox(
								IConstant.WMSG0205, langCode, langValue));
			        }
					}
				}
				//语言验证
				if(StringUtils.isEmpty(param.get("DIVLanguageCode").toString())){
					map.put("DIVLanguageCode", MessageReSource.getMessageBox(
							IConstant.WMSG0024, langCode, langValue));
				}
				//删除区分验证
				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
					map.put("DIVDelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
			
			
			//新建提交
			if (checkType ==1){
				if(map.size() <= 0 ){
					parts.setUpdateTime(new Date());// 更新时间
					parts.setUpdateUser(customerID);// 更新者
					parts.setCreateTime(new Date());// 创建时间
					parts.setCreateUser(customerID);// 创建者
					parts.setVersion(BigDecimal.ZERO);// 版本号
				}else{
					rtn.put("message", map);//返回map
					rtn.put("data", null); //数据
					rtn.put("status", IConstant.RESULT_CODE_2);//状态
					return rtn;
				}
			//编辑提交	
			}else{
				if(map.size() > 0 ){
				rtn.put("message", map);//返回map
				rtn.put("data", null); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
				return rtn;
				}
			}
		} catch (SQLException e) {
			Parts entity = new Parts();
			//错误消息：数据库操作异常，查询失败!
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
			}				
		return rtn;
		
	}
}