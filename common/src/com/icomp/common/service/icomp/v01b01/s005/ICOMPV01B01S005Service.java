package com.icomp.common.service.icomp.v01b01.s005;

import com.icomp.entity.base.Department;
import com.icomp.entity.base.Replacement;
import com.icomp.entity.base.Vapplyuser;
import com.icomp.entity.base.Vreplacement;

import java.util.List;
import java.util.Map;

/**
 * 申请信息查询SERVICES接口
 * @ClassName: ICOMPV01B01S005Service 
 * @author Taoyy
 * @date 2014-8-13 下午05:00:21
 */
public interface ICOMPV01B01S005Service {
	/**
	 * 申请信息王列表
	 * @title getList 
	 * @param entity Vreplacement
	 * @return Map<String,Object>
	 *
	 */
	Map<String, Object> getList(Vreplacement entity);

	/**
	 * 新建补领
	 * @param replacement
	 * @param langCode
	 * @param langValue
     * @return
     */
	public Map<String, Object> replaceAdd( Replacement replacement, String langCode, String langValue);

	/**
	 *	 新建补领验证
	 * @param param
	 * @param langValue
	 * @param param
	 * @param checkType
     * @return
     */
	public Map<String, Object> checkInput(Map<String, Object> param,String langValue,String userID,int checkType);
	/**
	 * 取得件列表
	 * @return
	 */
	 List<Department> getPartsLine();

	/**
	 * 通过ID取得值
	 * @param entity
     * @return
     */
	Map<String, Object> getprintItemInfo(Vreplacement entity);

	Map<String,Object> printEdit(Replacement entity,String langCode,String langValue);

	List<Vapplyuser> getUsList();

	List<Vapplyuser> getVapplyuser(Vapplyuser entity);
//查出所有记录
	List<Vreplacement> getVrpList();


	String getVappnumber();
}
