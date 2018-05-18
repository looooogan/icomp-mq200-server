package com.icomp.common.service.impl.icomp.v01b08.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b08.s002.ICOMPV01B08S002Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.LibrarycodeDao;
import com.icomp.dao.OnoffDao;
import com.icomp.entity.base.Librarycode;
import com.icomp.entity.base.Onoff;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class ICOMPV01B08S002ServiceImpl extends BaseService implements
		ICOMPV01B08S002Service {
	
	/**
	 * 内置编码Dao
	 */		
	private LibrarycodeDao librarycodeDao;
	private OnoffDao onoffDao;

	public void setOnoffDao(OnoffDao onoffDao) {
		this.onoffDao = onoffDao;
	}

	public void setLibrarycodeDao(LibrarycodeDao librarycodeDao) {
		this.librarycodeDao = librarycodeDao;
	}
	
	/**
	 * 内置编码
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 内置编码信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Onoff entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Onoff> list = (List<Onoff>) onoffDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Onoff>();
				Onoff onoff = new Onoff();
				// 消息：检索为0
				onoff.setMessageCode(IConstant.EMSG0001);
				onoff.setRetErrFlag(true);
				list.add(onoff);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = onoffDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Onoff> list = new ArrayList<Onoff>();
			Onoff onoff = new Onoff();
			// 错误消息：数据库操作异常,查询失败!
			onoff.setMessageCode(IConstant.EMSG0004);
			onoff.setRetErrFlag(true);
			onoff.setExceMessage(e.getMessage());
			list.add(onoff);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 内置编码删除
	 * 
	 * @param librarycode
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> librarycodeDelete(Librarycode librarycode,
			String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Librarycode entity = new Librarycode();
			entity.setLibraryCodeID(librarycode.getLibraryCodeIDWhere());
			entity.setUpdateTime(librarycode.getUpdateTimeWhere());
			entity.setUpdateUser(librarycode.getUpdateUserWhere());
			entity.setVersion(librarycode.getVersionWhere());
			List<Librarycode> list = (List<Librarycode>) librarycodeDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Librarycode();
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = librarycodeDao.updateNonQuery(librarycode);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Librarycode entity = new Librarycode();
			// 错误消息：数据库操作异常,删除失败!
			entity.setMessageCode(IConstant.EMSG0008);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * 内置编码编辑
	 * 
	 * @param librarycode
	 * @param lang
	 * @return
	 */
	public Map<String, Object> LibrarycodeEdit(Librarycode librarycode,
			String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Librarycode entity = new Librarycode();
			entity.setLibraryCodeID(librarycode.getLibraryCodeIDWhere());
			entity.setUpdateTime(librarycode.getUpdateTimeWhere());
			entity.setUpdateUser(librarycode.getUpdateUserWhere());
			entity.setVersion(librarycode.getVersionWhere());
			List<Librarycode> list = (List<Librarycode>) librarycodeDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Librarycode();
				//消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			@SuppressWarnings("unused")
			int ret = librarycodeDao.updateNonQuery(librarycode);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode, langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Librarycode entity = new Librarycode();
            //错误消息：数据库操作异常,更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	@Override
	public Map<String, Object> getOnoff(Map<String, Object> param, Onoff entity, String customer) {

		Map<String, Object> rtn = new HashMap<String, Object>();
		int onID = Integer.parseInt(param.get("nf").toString());

		try {
			List<Onoff> list = (List<Onoff>) onoffDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Onoff();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				// 更新项目打印成功
			}

			Onoff onoff =  list.get(0);
			onoff.setOnOffIDWhere(list.get(0).getOnOffID());
			onoff.setOnOffCodeWhere(list.get(0).getOnOffCode());
			onoff.setOnOffName(list.get(0).getOnOffName());
			onoff.setOnOffNoed(list.get(0).getOnOffNoed());
			onoff.setDelFlag(list.get(0).getDelFlag());
			onoff.setOnOffState(new BigDecimal(onID));
			onoff.setCreateUser(list.get(0).getCreateUser());
			onoff.setCreateTime(list.get(0).getCreateTime());
			onoff.setUpdateTime(new Date());
			onoff.setUpdateUser(list.get(0).getUpdateUser());
			int ret = onoffDao.updateNonQuery(onoff);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, "",  ""));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;


		} catch (SQLException e) {
			Onoff onoff = new Onoff();
			//错误消息：数据库操作异常，查询失败!
			onoff.setMessageCode(IConstant.EMSG0004);
			onoff.setRetErrFlag(true);
			onoff.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", onoff);
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
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue, String customerID, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Librarycode librarycode = new Librarycode();
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		//编辑验证
		if(checkType == 2){ 
			//自定义编码验证
			if(StringUtils.isEmpty(param.get("DIVCustomerCode").toString())){
				map.put("DIVCustomerCode", MessageReSource.getMessageBox(
						IConstant.WMSG0034, langCode, langValue));
			}else{
				//自定义编码
				librarycode.setCustomerCode(param.get("DIVCustomerCode").toString());
			}
			//删除区分验证
			if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
				map.put("DIVDelFlag", MessageReSource.getMessageBox(
						IConstant.WMSG0019, langCode, langValue));
			}else{
				//删除区分
				librarycode.setDelFlag(param.get("DIVDelFlag").toString());
			}	
			//编辑提交
			if(map.size() > 0 ){
				rtn.put("message", map);//返回map
				rtn.put("data", null); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
				return rtn;
			}else{
				//操作人
				librarycode.setSystemLogUser(customerID);
				//更新时间
				librarycode.setUpdateTime(new Date());
				//更新者
				librarycode.setUpdateUser(customerID);
				//版本号
				librarycode.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
				//更新条件：库位码ID
				librarycode.setLibraryCodeIDWhere(param.get("DivLibraryCodeID").toString());
				//更新条件：更新时间
				librarycode.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
				//更新条件：更新者
				librarycode.setUpdateUserWhere(param.get("DivUpdateUser").toString());
				//更新条件：版本号
				librarycode.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
				
				rtn.put("data", librarycode); //数据
				rtn.put("status", IConstant.RESULT_CODE_2);//状态
				return rtn;
				
				
			}
		}
		
	    return rtn;
	}


	@SuppressWarnings("unchecked")
	/**
	 * 取得内置编码信息
	 * 
	 * @param librarycode
	 * @param lang
	 * @return
	 */
	public Map<String, Object> getlibrarycodeInfo(Librarycode entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Librarycode> list = (List<Librarycode>) librarycodeDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Librarycode librarycode = new Librarycode();
				//消息：检索为0
				librarycode.setMessageCode(IConstant.EMSG0001);
				librarycode.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", librarycode);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Librarycode librarycode = new Librarycode();	
            //错误消息：数据库操作异常,查询失败!
			librarycode.setMessageCode(IConstant.EMSG0004);
			librarycode.setRetErrFlag(true);
			librarycode.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", librarycode);
			return rtn;
		}
	}
}
