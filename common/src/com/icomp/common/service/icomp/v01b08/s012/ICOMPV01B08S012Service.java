package com.icomp.common.service.icomp.v01b08.s012;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Parts;

import com.icomp.entity.base.Vparts;

/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S012Service {
	/**
	 * 零部件管理
	 * @param entity 页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	//public Map<String,Object> getList(Vassemblyline entity);
	public Map<String,Object> getList(Vparts entity);
	/**
	 * 零部件管理
	 * @param entity 页面查询条件
	 * @return 零部件信息
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineInfo(Assemblyline entity);
	public Map<String,Object> paInfo(Parts entity);
	
	/**
	 * 零部件删除
	 * @param entity 页面查询条件
	 * @return 零部件信息
	 * @throws BusinessException
	 */
	public Map<String,Object> assemblyLineDelete(Assemblyline entity,String langCode,String langValue);
	public Map<String,Object> partslyLineDelete(Parts entity,String langCode,String langValue);
	/**
	 * 新建零部件信息
	 * @param entity
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> assemblyLineAdd(Assemblyline entity,String langCode,String langValue);
	public Map<String,Object> partsLineAdd(Parts entity, String langCode, String langValue);
	

	/**
	 * 编辑零部件信息
	 * @param entity
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	//public Map<String,Object> assemblyLineEdit(Assemblyline entity,String langCode,String langValue);
	public Map<String,Object> parstEdit(Parts entity,String langCode,String langValue);
	/**
	 * 取得件列表
	 * @return
	 */
	public List<Parts> getPartsLine();
	/**
	 * 新建零部件信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> checkInput(Map<String,Object> param,String langCode,String langValue,String userID,int checkType);
}
