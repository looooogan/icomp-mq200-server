package com.icomp.common.service.icomp.v01b09.s002;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Equipment;
import com.icomp.entity.base.Parts;
import com.icomp.entity.base.Synthesiscutterlocation;
import com.icomp.entity.base.Synthesisparameters;

public interface ICOMPV01B09S002Service {

	public Map<String, Object> getList(Synthesisparameters entity)
			throws BusinessException;

	/**
	 * 验证刀具参数信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,String uploadFileName ,File upload,
										  String langCode, String langValue, String userId, int checkType) throws BusinessException;

	/**
	 * 保存刀具参数信息
	 *
	 * @param langValue
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> synthesisAdd(Synthesisparameters synthesis,
											List<Synthesiscutterlocation> SynLocList, String langCode,
											String langValue) throws BusinessException;

	/**
	 * 获取刀具参数
	 *
	 * @param entity
	 *            页面查询条件
	 * @return 项目信息信息
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisInfo(Synthesisparameters entity)
			throws BusinessException;

	/**
	 * 编辑刀具参数信息
	 *
	 * @param langValue
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisEdit(Synthesisparameters synthesis,
											 List<Synthesiscutterlocation> location, String langCode,
											 String langValue) throws BusinessException;

	// 2017/09/5 宋健 追加↓↓↓　dazhong@YMSC
	public Map<String, Object> syntEdit(Synthesisparameters synthesis,Synthesiscutterlocation location, String langCode,
										String langValue) throws BusinessException;
	// 2017/09/5 宋健 追加↑↑↑　dazhong@YMSC

	/**
	 * 删除刀具参数信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> synthesisDelete(Synthesisparameters synthesis,
											   String langCode, String langValue) throws BusinessException;

	/**
	 * 获取设备名称信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public List<Equipment> getEquipment(Equipment entity);

	/**
	 * 获取零部件信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public List<Parts> getParts(Parts entity);

	/**
	 * 获取合成刀位置信息信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	List<Synthesiscutterlocation> synthesisLocationInfo(
			Synthesiscutterlocation entity) throws BusinessException;
}
