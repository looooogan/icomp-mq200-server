package com.icomp.v01b04.b04s002.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Voplinkdown;

import java.util.List;
import java.util.Map;

/**
 * 车间刀具状态查询BUSINESS接口
 * @ClassName: B01S002Business
 * @author Taoyy
 * @date 2014-8-20 下午02:01:40
 */
public interface B04S002Business {
	/**
	 * 车间刀具状态查询列表
	 * @title getList
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
	public	Map<String, Object> getList(Map<String, Object> param,String langCode,String langValue, int chey)throws BusinessException;
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
	/**
	 * 取得页面下拉列表内容
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;

	List<Voplinkdown> getVoplink(String assemblylineID, String delFlag0, String langCode, String langValue, int i);

	List<Assemblyline> getAssemblyline(String delFlag0, String langCode, String langValue);

	String getNumber() throws BusinessException;
}

