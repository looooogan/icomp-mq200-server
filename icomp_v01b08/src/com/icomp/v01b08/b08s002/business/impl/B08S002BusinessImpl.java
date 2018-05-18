package com.icomp.v01b08.b08s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b08.s002.ICOMPV01B08S002Service;
import com.icomp.common.utils.Ctl;
import com.icomp.entity.base.*;
import com.icomp.v01b08.b08s002.business.B08S002Business;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public class B08S002BusinessImpl implements B08S002Business {
	
	/**
	 * 系统初始化SERVICE
	 */
	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}
	
    /**
     * 内置编码配置SERVICE
     */
	private ICOMPV01B08S002Service iCOMPV01B08S002Service;

	public void setiCOMPV01B08S002Service(
			ICOMPV01B08S002Service iCOMPV01B08S002Service) {
		this.iCOMPV01B08S002Service = iCOMPV01B08S002Service;
	}

	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType, String langCode,String langValue)
			throws BusinessException {
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
		}
		return list;
	}

	/**
	 * 取得内置编码列表
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
	 * @return
	 * @throws BusinessException
	 */
	
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		// 设置检索条件
		Onoff entity = new Onoff();
		// 系统编码
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
//		entity.setOrderString("LibraryCodeID");
		// 取得内置编码列表
		Map<String,Object> rtn = iCOMPV01B08S002Service.getList(entity);
	    //当查询失败时
		if(rtn.size() > 1 && rtn.get("error") != null){
			  // 检索错误时，返回
			  throw new BusinessException(((List<Onoff>)rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 删除内置编码配置
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> libraryCodeDelete(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		
		Librarycode librarycode = new Librarycode();
		//删除区分设为“1”
		librarycode.setDelFlag(IConstant.DEL_FLAG_1);
		//更新时间
		librarycode.setUpdateTime(new Date());
		//更新者
		librarycode.setUpdateUser(customerID);
		//版本号
		librarycode.setVersion(new BigDecimal(param.get("version").toString()).add(BigDecimal.ONE));
		//更新条件：库位码ID
		librarycode.setLibraryCodeIDWhere(param.get("libraryCodeID").toString());
		//更新条件：更新时间
		librarycode.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		//更新条件：更新者
		librarycode.setUpdateUserWhere(param.get("updateuser").toString());
		//更新条件：版本号
		librarycode.setVersionWhere(new BigDecimal(param.get("version").toString()));
		//删除内置编码配置
		Map<String,Object> ret = iCOMPV01B08S002Service.librarycodeDelete(librarycode,langCode,langValue);
		//当删除失败时
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Librarycode)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}

	/**
     * 内置编码编辑
	 * @param param      页面检索条件
	 * @param langValue  语言值
	 * @param customerID 用户ID
	 * @param langCode   语言编码
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> librarycodeEdit(Map<String, Object> param,
			String langValue, String customerID, String langCode)
			throws BusinessException {
		//内置编码输入验证
		Map<String,Object> ret = iCOMPV01B08S002Service.checkInput(param,langCode,langValue,customerID,2);
        //当验证失败时，抛异常
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Department)ret.get("error")).getMessageCode(),langCode, langValue);
		//当验证成功时，返回
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Librarycode librarycode =  (Librarycode)ret.get("data");

		//保存部门信息
		ret = iCOMPV01B08S002Service.LibrarycodeEdit(librarycode,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //编辑失败时，返回
			  throw new BusinessException(((Librarycode)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	/**
     * 待处理内置编码取得
	 * @param param     页面检索条件
	 * @param langCode  语言编码
	 * @param langValue 语言值
     * @return
     * @throws BusinessException
     */
	public Map<String, Object> librarycodeInfo(Map<String, Object> param,String langCode,
			String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object>();
		//库位码ID
		String libraryCodeID = param.get("libraryCodeID").toString();
		//当点击编辑按钮时
		if (StringUtils.equals("edit", (String) param.get("opt"))) {
			
			Librarycode entity = new Librarycode();
			//库位码ID
			entity.setLibraryCodeID(libraryCodeID);
			//取得待编辑内置编码信息
			ret = iCOMPV01B08S002Service.getlibrarycodeInfo(entity);
			//当取得信息失败时
			if(ret.size() > 1 && ret.get("error") != null){
				  //取得错误时，返回
				  throw new BusinessException(((Librarycode)ret.get("error")).getMessageCode(),langCode, langValue);
			}
		}
		return ret;
	}

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID     页面ID
	 * @param userID     用户ID
	 * @param langCode   语言编码
	 * @param langValue  语言值
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> onOff(Map<String, Object> param, String customer, String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String, Object>();
		String onoffID =  param.get("onoffID").toString();

		Onoff  entity = new Onoff();
		entity.setOnOffID(onoffID);
		ret = iCOMPV01B08S002Service.getOnoff(param,entity,customer);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Onoff)ret.get("error")).getMessageCode(),langCode,langValue);
		}
		return ret;
	}
}