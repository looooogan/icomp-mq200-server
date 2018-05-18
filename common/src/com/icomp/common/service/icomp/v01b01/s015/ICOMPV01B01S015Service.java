package com.icomp.common.service.icomp.v01b01.s015;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;
/**
 * 库存盘点查询SERVICE接口
 * @ClassName: ICOMPV01B01S015Service
 * @author Licc
 * @date 2014-11-12 下午03:46:22
 */
public interface ICOMPV01B01S015Service {
	
	/**
	 * 库存盘点查询
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(ToolChangehistory entity);

	/**
	 * 取得零部件列表
	 * @return
	 */
	public List<Parts> getParts();
	/**
	 * 取得轴编号列表
	 * @return
	 */
	public List<Axle> getAxleLine();
	/**
	 * 取得工序列表
	 * @return
	 */
	public List<Process> getProcess();

	/**
	 * 取得设备列表
	 * @return
	 */
	public List<Equipment> getEquipment();

	/**
	 * 取得生产线
	 * @return
	 */
	public List<Assemblyline> getAssemblyline();



}
