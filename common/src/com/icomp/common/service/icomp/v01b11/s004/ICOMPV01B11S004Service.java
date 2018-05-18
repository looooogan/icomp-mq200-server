package com.icomp.common.service.icomp.v01b11.s004;

import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Tubedetailinfo;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vcustomer;



public interface ICOMPV01B11S004Service {


	/**
	 * 用户管理
	 *
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Vcustomer entity);
	/**
	 * 用户管理
	 *
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getUserInfo(Vcustomer entity);
	/**
	 * 用户管理
	 *
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getUserdetail(Userdetail entity);
	/**
	 * 用户删除
	 *
	 * @param entity
	 *            页面查询条件
	 * @return 用户信息
	 * @throws BusinessException
	 */
	public Map<String, Object> userDelete(Customer customer, String langCode,String langValue);
	/**
	 * 新建用户信息
	 *
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> userAdd(Customer customer, String langCode,String langValue);
	/**
	 * 编辑用户信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String,Object> userEdit(Customer customer,String langCode,String langValue);
	/**
	 * 新建用户信息验证
	 *
	 * @param param
	 * @param langValue
	 * @return
	 */
	public Map<String, Object> checkInput(Map<String, Object> param,String langCode,String langValue, String userID,int checkType);

	/**
	 * 取得页面grid显示项目列表
	 * @param pageID
	 * @param lang
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getGridColmun(String pageID,String lang);

	/**
	 * 保存用户详细信息
	 * @paramparam
	 * @paramparam
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> userDetailAdd(Userdetail userdetail,
											 String langCode, String langValue);

	/**
	 * 新建用户详细信息
	 * @param param
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> userDetailEdit(Map<String, Object> param,
											  Userdetail userDetail, String langCode, String langValue);

	/**
	 * 用户详细信息验证
	 * @param param
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> userDetailcheckInput(Map<String, Object> param,
													String langCode, String langValue, String customerID, int i);

	// 2017/09/16 宋健 追加↓↓↓　dazhong@YMSC
	public Map<String, Object> getDetailInfo(Tubedetailinfo entity);

	public Map<String, Object> getTotalInfo(Tubedetailinfo entity);
	// 2017/09/16 宋健 追加↑↑↑　dazhong@YMSC
}
