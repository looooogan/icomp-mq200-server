package com.icomp.common.service.icomp.v01b04.s002;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;


/**
 * 车间刀具状态查询SERVICE接口
 * @ClassName: ICOMPV01B03S002Service
 * @author Taoyy
 * @date 2014-8-20 下午03:57:20
 */
public interface ICOMPV01B04S002Service {
	/**
	 * 车间刀具状态查询
	 * @title getList
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vcuttingtoolstate entity);

	// 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
	public Map<String, Object> getLists(Synthesisknife entity);
	// 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
	/**
	 * 取得生产线
	 * @return
	 */
	public List<Assemblyline> getAssemblyline();
	/**
	 * 取得工序列表
	 * @return
	 */
	public List<Process> getProcess();


	List<Voplinkdown> getVoplinList(Voplinkdown entity);

	List<Assemblyline> getAssemblylineList(Assemblyline entity);

	String getAnumber();
}
