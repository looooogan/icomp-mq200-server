package com.icomp.common.service.icomp.v01b08.s013;

import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;

import java.util.List;
import java.util.Map;


/**
 * 生产关联配置Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S013Service {

	/**
	 * 取得零部件列表
	 * @return
	 */
	public List<Assemblyline> getAssemblyLine();
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
	 * 取得合成刀具参数列表
	 * @return
	 */
	public List<Synthesisparameters> getSynthesisParameters();

	/**
	 * 取得加工工艺列表
	 * @return
	 */
	public List<Parts> getParts();

	/**
	 * 取得生产关联信息列表
	 * @param voplink
	 * @return
	 */
	public Map<String,Object> getList(Voplink voplink);

	/**
	 * 取得生产关联信息
	 * @param oplink
	 * @return
	 */
	public Map<String,Object> oplinkInfo(Oplink oplink);

	/**
	 * 新建关联
	 * @param oplink
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkAdd(Oplink oplink,String langCode,String langValue);

	/**
	 * 编辑关联
	 * @param oplink
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkEdit(Oplink oplink,String langCode,String langValue);

	/**
	 * 删除关联
	 * @param oplink
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String,Object> oplinkDelete(Oplink oplink,String langCode,String langValue);

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


	List<Voplinkdown> getVoplinList(Voplinkdown entity);
}
