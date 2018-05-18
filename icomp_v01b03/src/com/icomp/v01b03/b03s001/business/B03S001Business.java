package com.icomp.v01b03.b03s001.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Userdetail;

import java.util.List;
import java.util.Map;

/**
 * 刃磨记录查询BUsiness接口
 * @ClassName: B01S001Business 
 * @author Taoyy
 * @date 2014-8-12 下午04:09:08
 */
public interface B03S001Business {
	/**
	 * 刃磨记录查询
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue,int checkType)throws BusinessException;
	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID, 
			String departmentID,String langCode , String langValue) throws BusinessException;

	String getNumber() throws BusinessException;

	List<Userdetail> getUser(Userdetail user)throws BusinessException;
}
