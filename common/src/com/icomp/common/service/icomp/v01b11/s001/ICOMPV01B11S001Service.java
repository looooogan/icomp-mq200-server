package com.icomp.common.service.icomp.v01b11.s001;

import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Polink;
import com.icomp.entity.base.Vcaplist;

/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B11S001Service {


	/**
	 * 取得功能信息列表
	 * @param param 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Capability entity);
	
	/**
	 * 取得功能信息列表
	 * @param entity 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getRoleGruanList(Vcaplist entity);
	
	/**
	 * 保存权限信息列表
	 * @param entity 页面检索条件
	 * @param lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> saveGruant(List<Polink> entity,String langCode,String langValue);
}
