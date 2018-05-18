package com.icomp.v01b07.b07s001.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Werkzeugeanforderun;

import java.util.List;
import java.util.Map;

/**
 * 在途计划报警BUsiness接口
 * @ClassName: B07S001Business 
 * @author Licc
 * @date 2014-8-12 下午04:09:08
 */
public interface B07S001Business {
	
	/**
	 * 在途计划报警查询列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue)throws BusinessException;

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String customerID,String langCode , String langValue) throws BusinessException;


	Map<String,Object> dbWerforderun(List<Werkzeugeanforderun> infos, String langCode, String langValue, String userID)throws BusinessException;

    Map<String,Object> werDelete(Map<String, Object> param)throws BusinessException;
}
