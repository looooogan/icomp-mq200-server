package com.icomp.common.service.icomp.v01b09.s004;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.TooltransferTotal;

import java.util.Map;


public interface ICOMPV01B09S004Service {

	public Map<String, Object> getList(Containercarrier entity);
	/**
	 * 验证打印项目信息
	 * @param param
	 * @param langValue
	 * @return
	 */

	public Map<String, Object> checkInput(Map<String, Object> param,
										  String langCode, String langValue,String userID, int i);

	/**
	 * 保存打印项目信息
	 * @param langValue
	 * @param langCode
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> printItemAdd(Containercarrier entity,
											String langCode, String langValue);
	/**
	 * 删除打印项目信息
	 * @param langValue
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printItemDelete(
			Containercarrier entity, String langCode, String langValue);
	/**
	 * 编辑打印项目信息
	 * @param langValue
	 * @param langCode
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> printEdit(Containercarrier entity,
										 String langCode, String langValue);
	/**
	 * 项目信息管理
	 * @param entity 页面查询条件
	 * @return 项目信息信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getprintItemInfo(Containercarrier entity);

	// 2017/09/13 宋健 追加↓↓↓　dazhong@YMSC
	public Map<String, Object> itemDelete(
			TooltransferTotal entity, String langCode, String langValue);
	// 2017/09/13 宋健 追加↑↑↑　dazhong@YMSC

}
