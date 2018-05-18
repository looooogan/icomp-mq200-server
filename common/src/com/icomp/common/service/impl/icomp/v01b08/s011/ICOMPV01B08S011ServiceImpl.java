package com.icomp.common.service.impl.icomp.v01b08.s011;

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
import com.icomp.common.service.icomp.v01b08.s011.ICOMPV01B08S011Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.StackDao;
import com.icomp.dao.VlibrarycodeDao;
import com.icomp.dao.VstackDao;
import com.icomp.entity.base.Stack;
import com.icomp.entity.base.Vlibrarycode;
import com.icomp.entity.base.Vstack;

public class ICOMPV01B08S011ServiceImpl extends BaseService implements
		ICOMPV01B08S011Service {
	
    // 库房货架视图Dao
	private VstackDao vstackDao;
	
	public void setVstackDao(VstackDao vstackDao) {
		this.vstackDao = vstackDao;
	}
	// 库房货架Dao	
	private StackDao stackDao;
	
	public void setStackDao(StackDao stackDao) {
		this.stackDao = stackDao;
	}
	// 库位码Dao
	private VlibrarycodeDao vlibrarycodeDao;


	public void setVlibrarycodeDao(VlibrarycodeDao vlibrarycodeDao) {
		this.vlibrarycodeDao = vlibrarycodeDao;
	}


	/**
	 * 库房货架配置
	 * @param entity
	 *            页面查询条件
	 * @return 
	 */
    @SuppressWarnings("unchecked")
	public Map<String, Object> getList(Vstack entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vstack> list = (List<Vstack>) vstackDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vstack>();
				Vstack vstack = new Vstack();
				//消息：检索为0
				vstack.setMessageCode(IConstant.EMSG0001);
				vstack.setRetErrFlag(true);
				list.add(vstack);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				int total = vstackDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vstack> list = new ArrayList<Vstack>();
			Vstack vstack = new Vstack();
			//错误消息：数据库操作异常，查询失败!
			vstack.setMessageCode(IConstant.EMSG0004);
			vstack.setRetErrFlag(true);
			vstack.setExceMessage(e.getMessage());
			list.add(vstack);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
    
	/**
	 * 取得库房货架配置信息
	 * @param entity
	 *            页面查询条件
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getStackInfo(Vstack entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vstack> list = (List<Vstack>) vstackDao
					.searchByList(entity);
			if (list.size() <= 0) {
				Vstack vstack = new Vstack();
				//消息：检索为0
				vstack.setMessageCode(IConstant.EMSG0001);
				vstack.setRetErrFlag(true);
				rtn.put("data", null);
				rtn.put("error", vstack);
				return rtn;
			} else {
				rtn.put("data", list.get(0));
				return rtn;
			}

		} catch (SQLException e) {
			Vstack vstack = new Vstack();
			//错误消息：数据库操作异常，查询失败!			
			vstack.setMessageCode(IConstant.EMSG0004);
			vstack.setRetErrFlag(true);
			vstack.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", vstack);
			return rtn;
		}
	}

	/**
	 * 库房货架配置删除
	 * @param entity
	 *            页面查询条件
	 * @return 
	 */	
	@SuppressWarnings("unchecked")
	public Map<String, Object> stackDelete(Stack stack, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 删除失败! 进行数据排他验证
			Stack entity = new Stack();
			entity.setStackID(stack.getStackIDWhere());       //货架ID
			entity.setUpdateTime(stack.getUpdateTimeWhere()); //更新时间
			entity.setUpdateUser(stack.getUpdateUserWhere()); //更新者
			entity.setVersion(stack.getVersionWhere());       //版本号
			List<Stack> list = (List<Stack>) stackDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Stack();
				//您所请求的数据，已被其他用户修改，请重新查询后再进行修改！
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 删除成功
			@SuppressWarnings("unused")
			int ret = stackDao.updateNonQuery(stack);
			//删除成功，ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0003, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			Stack entity = new Stack();
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
	 * 库房货架配置新建
	 * @param entity
	 *            页面查询条件
	 * @return 
	 */	
	public Map<String, Object> stackAdd(Stack stack, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			stack.setStackID(NextKeyValue.getNextkeyvalue(
					IConstant.STACK, IConstant.STACK_ID, stack.getUpdateUser()));// 取得库房货架表主键
			stackDao.insert(stack);
			//插入成功,ID:{0}!
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0004, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Stack entity = new Stack();
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
	 * 库房货架配置编辑
	 * @param entity
	 *            页面查询条件
	 * @return 
	 */	
	@SuppressWarnings("unchecked")
	public Map<String, Object> stackEdit(Stack stack, String langCode,String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {

			// 编辑失败! 进行数据排他验证
			Stack entity = new Stack();
			entity.setStackID(stack.getStackIDWhere());
			entity.setUpdateTime(stack.getUpdateTimeWhere());
			entity.setUpdateUser(stack.getUpdateUserWhere());
			entity.setVersion(stack.getVersionWhere());
			List<Stack> list = (List<Stack>) stackDao
					.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Stack();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				return rtn;
			}
			// 更新成功
			@SuppressWarnings("unused")
			int ret = stackDao.updateNonQuery(stack);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			
			return rtn;
		} catch (SQLException e) {
			Stack entity = new Stack();
			//错误消息：数据库操作异常，更新失败!
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
		Stack stack = new Stack();		
		//页面输入项目的验证
		Map<String, String> map = new HashMap<String, String>();
		try{
			//新建验证
				//库房号验证
				if(StringUtils.isEmpty(param.get("DIVDepot").toString())){
					map.put("DIVDepot", MessageReSource.getMessageBox(
							IConstant.WMSG0104, langCode, langValue));
				}else{
					stack.setDepot(param.get("DIVDepot").toString());          //库房号
				}
				//货架验证
				if(StringUtils.isEmpty(param.get("DIVShelf").toString())){
					map.put("DIVShelf", MessageReSource.getMessageBox(
							IConstant.WMSG0105, langCode, langValue));
				}else{
					stack.setShelf(param.get("DIVShelf").toString());          //货架
				}
				//厂区验证
				if(StringUtils.isEmpty(param.get("DIVComplex").toString())){
					map.put("DIVComplex", MessageReSource.getMessageBox(
							IConstant.WMSG0103, langCode, langValue));
				}else{
					stack.setComplex(param.get("DIVComplex").toString());        //厂区
				}
				
				//层验证
				if(StringUtils.isEmpty(param.get("DIVLayer").toString())){
					map.put("DIVLayer",MessageReSource.getMessageBox(
							IConstant.WMSG0106, langCode, langValue));
				}else{
					stack.setLayer(param.get("DIVLayer").toString());
				}
				//货位验证
				if(StringUtils.isEmpty(param.get("DIVStack").toString())){
					map.put("DIVStack", MessageReSource.getMessageBox(
							IConstant.WMSG0107, langCode, langValue));
				}else{
					stack.setStack(param.get("DIVStack").toString());
				}
				//库位码验证
				if(StringUtils.isEmpty(param.get("DivSysteCodeShow").toString())){
					map.put("DivSysteCodeShow", MessageReSource.getMessageBox(
							IConstant.WMSG0108, langCode, langValue));
				}
				//删除区分验证
				if(StringUtils.isEmpty(param.get("DIVDelFlag").toString())){
					map.put("DIVDelFlag", MessageReSource.getMessageBox(
							IConstant.WMSG0019, langCode, langValue));
				}
				//验证唯一性
				List<Stack> list = (List<Stack>)stackDao.searchByList(stack);
				if(list.size()>0){
					//消息：您所新建的货架已存在!
					map.put(IConstant.STRING_1,MessageReSource.getMessageBox(
							IConstant.WMSG0209, langCode, langValue));
					if(checkType ==2&&param.get("DivStackID").toString().equals(list.get(0).getStackID())){
						 map.remove(IConstant.STRING_1);
					}
		        }
			//新建提交
			if (checkType ==1){
				if(map.size() <= 0 ){
					//备注
					stack.setremark(param.get("DIVRemark").toString());
					stack.setUpdateTime(new Date());// 更新时间
					stack.setUpdateUser(customerID);// 更新者
					stack.setCreateTime(new Date());// 创建时间
					stack.setCreateUser(customerID);// 创建者
					stack.setVersion(BigDecimal.ZERO);// 版本号
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
			Stack entity = new Stack();
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
	
	/**
	 * 取得库位码
	 */
	
	@Override
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue) {
		try {
			Vlibrarycode entity = new Vlibrarycode();
			List<Vlibrarycode> list = (List<Vlibrarycode>) vlibrarycodeDao
					.searchByList_b08s011(entity);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}