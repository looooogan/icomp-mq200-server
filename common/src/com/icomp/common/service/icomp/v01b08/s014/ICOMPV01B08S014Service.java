package com.icomp.common.service.icomp.v01b08.s014;

import java.util.Map;

import com.icomp.entity.base.Toolshelf;
import com.icomp.entity.base.Vtoolshelf;


/**
 * 生产关联配置Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S014Service {
	

	
	/**
	 * 取得生产关联信息列表
	 * @param vtoolshelf
	 * @return
	 */
	public Map<String,Object> getList(Vtoolshelf vtoolshelf);
	
	/**
	 * 新建关联
	 * @param toolshelf
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> toolshelfAdd(Toolshelf toolshelf,String langCode,String langValue);
	/**
	 * 删除关联
	 * @param toolshelf
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> toolshelfDelete(Toolshelf toolshelf,String langCode,String langValue);
	
	/**
	 * 验证用户输入信息
	 * @param param
	 * @param langCode
	 * @param langValue
	 * @param userID
	 * @param checkType
	 * @return
	 */
	public Map<String,Object> checkInput(Map<String,Object> param,String langCode,String langValue,String userID,int checkType);
	
	
}
