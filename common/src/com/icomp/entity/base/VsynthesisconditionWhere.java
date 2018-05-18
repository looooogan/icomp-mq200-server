/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2016/03/10 15:23:42
 */
package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;



/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2016/03/10 15:23:42
 * 创建者  ：工具自动生成
 * 
 */
public class VsynthesisconditionWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 流水线名称	*/ 
	private String assemblyLineNameWhere;

	/**
	 * 流水线名称取得
	 * @return assemblyLineNameWhere
	 */
	public String getAssemblyLineNameWhere () {
		return assemblyLineNameWhere;
	}

	/**
	 * 流水线名称设定
	 * @param assemblyLineNameWhere
	 */
	public void setAssemblyLineNameWhere (String assemblyLineNameWhere) {
		this.assemblyLineNameWhere = assemblyLineNameWhere;
	}

	/* 流水线ID	*/ 
	private String assemblyLineIDWhere;

	/**
	 * 流水线ID取得
	 * @return assemblyLineIDWhere
	 */
	public String getAssemblyLineIDWhere () {
		return assemblyLineIDWhere;
	}

	/**
	 * 流水线ID设定
	 * @param assemblyLineIDWhere
	 */
	public void setAssemblyLineIDWhere (String assemblyLineIDWhere) {
		this.assemblyLineIDWhere = assemblyLineIDWhere;
	}

	/* 工序名称	*/ 
	private String processNameWhere;

	/**
	 * 工序名称取得
	 * @return processNameWhere
	 */
	public String getProcessNameWhere () {
		return processNameWhere;
	}

	/**
	 * 工序名称设定
	 * @param processNameWhere
	 */
	public void setProcessNameWhere (String processNameWhere) {
		this.processNameWhere = processNameWhere;
	}

	/* 工序ID	*/ 
	private String processIDWhere;

	/**
	 * 工序ID取得
	 * @return processIDWhere
	 */
	public String getProcessIDWhere () {
		return processIDWhere;
	}

	/**
	 * 工序ID设定
	 * @param processIDWhere
	 */
	public void setProcessIDWhere (String processIDWhere) {
		this.processIDWhere = processIDWhere;
	}

	/* 合成刀具编码(系统唯一)	*/ 
	private String synthesisParametersCodeWhere;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCodeWhere
	 */
	public String getSynthesisParametersCodeWhere () {
		return synthesisParametersCodeWhere;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCodeWhere
	 */
	public void setSynthesisParametersCodeWhere (String synthesisParametersCodeWhere) {
		this.synthesisParametersCodeWhere = synthesisParametersCodeWhere;
	}

	/* 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)	*/ 
	private String loadStateWhere;

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)取得
	 * @return loadStateWhere
	 */
	public String getLoadStateWhere () {
		return loadStateWhere;
	}

	/**
	 * 使用状态(0设备装入1设备卸下2回收旧刀3组装新刀4不合格送回5车间待安上)(该状态绑定到带标签的数据上)设定
	 * @param loadStateWhere
	 */
	public void setLoadStateWhere (String loadStateWhere) {
		this.loadStateWhere = loadStateWhere;
	}

	/* 	*/ 
	private String numberDevicesWhere;

	/**
	 * 取得
	 * @return numberDevicesWhere
	 */
	public String getNumberDevicesWhere () {
		return numberDevicesWhere;
	}

	/**
	 * 设定
	 * @param numberDevicesWhere
	 */
	public void setNumberDevicesWhere (String numberDevicesWhere) {
		this.numberDevicesWhere = numberDevicesWhere;
	}

	/* 	*/ 
	private String numberToolStorageWhere;

	/**
	 * 取得
	 * @return numberToolStorageWhere
	 */
	public String getNumberToolStorageWhere () {
		return numberToolStorageWhere;
	}

	/**
	 * 设定
	 * @param numberToolStorageWhere
	 */
	public void setNumberToolStorageWhere (String numberToolStorageWhere) {
		this.numberToolStorageWhere = numberToolStorageWhere;
	}

	/* 	*/ 
	private String regulatinRoomWhere;

	/**
	 * 取得
	 * @return regulatinRoomWhere
	 */
	public String getRegulatinRoomWhere () {
		return regulatinRoomWhere;
	}

	/**
	 * 设定
	 * @param regulatinRoomWhere
	 */
	public void setRegulatinRoomWhere (String regulatinRoomWhere) {
		this.regulatinRoomWhere = regulatinRoomWhere;
	}
}

