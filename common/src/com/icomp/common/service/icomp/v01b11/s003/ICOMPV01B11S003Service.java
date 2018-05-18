package com.icomp.common.service.icomp.v01b11.s003;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Dplink;
import com.icomp.entity.base.Position;
import com.icomp.entity.base.Vpositions;

/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B11S003Service {


	/**
	 * 角色管理
	 * @param entity 页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	public Map<String,Object> getList(Vpositions entity);

	/**
	 * 角色管理
	 * @param entity 页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	public Map<String,Object> getRoleInfo(Vpositions entity);
	
	/**
	 * 角色删除
	 * @param entity 页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	public Map<String,Object> roleDelete(Position position,String langCode,String langValue);
	
	/**
	 * 新建角色信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> roleAdd(Position position,Dplink dplink,String langCode,String langValue);
	

	/**
	 * 编辑角色信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> roleEdit(Position position,String langCode,String langValue);
	
	/**
	 * 新建角色信息
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> checkInput(Map<String,Object> param,String langCode,String langValue,String userID,int checkType);
	
	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,String langCode,String langValue);
}
