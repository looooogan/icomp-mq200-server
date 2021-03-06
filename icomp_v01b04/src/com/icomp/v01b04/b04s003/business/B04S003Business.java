package com.icomp.v01b04.b04s003.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;

/**
 * 加工量异常报警BUSINESS接口
 * @ClassName: B01S002Business 
 * @author Taoyy
 * @date 2014-8-20 下午02:01:40
 */
public interface B04S003Business {
	/**
	 * 加工量异常报警列表
	 * @title getList 
	 * @param param
	 * @param langValue
	 * @return
	 * Map<String,Object>
	 */
 public	Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)throws BusinessException;

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

	public Map<String,Object> getPageSelList(String langCode, String langValue)throws BusinessException;

	public List<Assemblyline> getAssemblyline(String param, String langCode, String langValue)throws BusinessException;
	public List<Voplinkdown> getVoplink(String anyyID, String param, String langCode, String langValue, int checkType)throws BusinessException;
	List<Process> getProcess(String delFlag0, String langCode, String langValue);

	List<Equipment> getEquipment(String delFlag0, String langCode, String langValue);

	List<Axle> getAxle(String delFlag0, String langCode, String langValue);

	String getNumber()throws BusinessException;
}
