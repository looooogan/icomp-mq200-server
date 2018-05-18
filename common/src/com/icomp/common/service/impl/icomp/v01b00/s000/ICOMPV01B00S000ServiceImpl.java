package com.icomp.common.service.impl.icomp.v01b00.s000;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b00.s000.ICOMPV01B00S000Service;
import com.icomp.dao.CustomerDao;
import com.icomp.dao.VgrantlistDao;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Vgrantlist;

public class ICOMPV01B00S000ServiceImpl extends BaseService implements ICOMPV01B00S000Service{

	/* 用户Dao */
	private CustomerDao dao;
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	
	/* 用户权限Dao */
	private VgrantlistDao vgrantlistDao;
	public void setVgrantlistDao(VgrantlistDao vgrantlistDao) {
		this.vgrantlistDao = vgrantlistDao;
	}
	
	/**
	 * 用户登录
	 * @param entity 登录用户名
	 * @return 用户登录信息
	 * @throws Exception
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	@SuppressWarnings("unchecked")
	public Customer login(Customer entity) {
		try {
			//验证用户是否存在登录异常
			//如果锁定时间已到期，则打开锁定
			//如果锁定时间未到期，不允许登录
			List<Customer> list = (List<Customer>) dao.searchByList(entity);
			if(list.size() <= 0){
				//登录失败时进行用户锁定
				
				entity = new Customer();
				//检索数据行数为0,检索失败!
				entity.setMessageCode(IConstant.WMSG0003);
				entity.setRetErrFlag(true);
				return entity;
			}else{
				entity = list.get(0);
				//检索成功!
				entity.setMessageCode(IConstant.IMSG0001);
				return entity;
			}
		} catch (SQLException e) {
			entity = new Customer();
			entity.setRetErrFlag(true);
			//数据库操作异常,查询失败!
			entity.setMessageCode(IConstant.EMSG0002);
			entity.setExceMessage(e.getMessage());
			return entity;
		}
	}



	/**
	 * 取得用户权限信息
	 * @param entity 权限信息查询条件
	 * @return 用户权限信息
	 * 作成者：杨作庆
	 * 作成时间:2014-07-08 17:14 
	 */
	@SuppressWarnings("unchecked")
	public List<Vgrantlist> getUserGrant (Vgrantlist entity){
		try {
			//取得用户权限信息
			List<Vgrantlist> list = (List<Vgrantlist>) vgrantlistDao.searchByList(entity);
			if(list == null || list.size() <= 0){
				//该用户无可用权限,请联系系统管理员!
				list = new ArrayList<Vgrantlist>();
				Vgrantlist vgrant = new Vgrantlist();
				vgrant.setMessageCode(IConstant.EMSG0003);
				vgrant.setRetErrFlag(true);
				list.add(vgrant);
				return list;
			}else{
				return list;
			}
			
		} catch (SQLException e) {
			List<Vgrantlist> list = new ArrayList<Vgrantlist>();
			Vgrantlist vgrant = new Vgrantlist();
			vgrant.setMessageCode(IConstant.EMSG0004);
			vgrant.setRetErrFlag(true);
			vgrant.setExceMessage(e.getMessage());
			list.add(vgrant);
			return list;
		}
	}
}
