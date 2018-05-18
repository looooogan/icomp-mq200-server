package com.icomp.common.service.icomp.v01b06.s002;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;


/**
 * 加工异常分析查询SERVICE接口
 * @ClassName: ICOMPV01B03S002Service
 * @author Taoyy
 * @date 2014-8-20 下午03:57:20
 */
public interface ICOMPV01B06S002Service {

	Map<String, Object> getList(Vanalysisabnormalprocessing entity);

	Map<String, Object> getLists(Vanalysis entity);
	/**
	 * 加工异常分析统计数量
	 * @title getStatisticalCount
	 * @param entity
	 * @return
	 * String
	 */
	String getStatisticalCount(Vanalysis entity);


	List<Process> getProcess();

	List<Parts> getParts();

	// 2017/07/04 宋健 追加↓↓↓　dazhong@YMSC
	List<Parts> getPartsListById(String id);
	// 2017/07/04 宋健 追加↑↑↑　dazhong@YMSC

	List<Assemblyline> getAssemblyline();

	String getNumber();
}
