package com.icomp.common.service.impl.icomp.v01b01.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s001.ICOMPV01B01S001Service;
import com.icomp.dao.StoragerecordDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VknifeinventoryDao;
import com.icomp.entity.base.Storagerecord;
import com.icomp.entity.base.Userdetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 入库信息查询SERVICE实现类 
 * @ClassName: ICOMPV01B01S001ServiceImpl 
 * @author Taoyy
 * @date 2014-8-19 下午03:48:40
 */
public class ICOMPV01B01S001ServiceImpl extends BaseService implements ICOMPV01B01S001Service {

	/**
	 * 入库信息查询DAO
	 */
	private VknifeinventoryDao vknifeinventoryDao;
	private StoragerecordDao storagerecordDao;
	private UserdetailDao userdetailDao;

	public void setUserdetailDao(UserdetailDao userdetailDao) {
		this.userdetailDao = userdetailDao;
	}

	public void setStoragerecordDao(StoragerecordDao storagerecordDao) {
		this.storagerecordDao = storagerecordDao;
	}

	public void setVknifeinventoryDao(VknifeinventoryDao vknifeinventoryDao) {
		this.vknifeinventoryDao = vknifeinventoryDao;
	}

	/**
	 * 入库信息查询列表
	 */


	@Override
	public Map<String, Object> getList(Storagerecord entity) {

			Map<String, Object> rtn = new HashMap<String, Object>();
		    Userdetail user = null;
		try {
			//ToolCode模糊查询
//			   user = new Userdetail();
//				user.setUserName(entity.getCreateUser());
//			   List<Userdetail> ulists =(List<Userdetail>) userdetailDao.searchByList(user);
//				entity.setCreateUser(ulists.get(0).getCustomerID());
				List<Storagerecord> list = (List<Storagerecord>) storagerecordDao.searchByList(entity);

			if (list.size() <= 0) {
				list = new ArrayList<Storagerecord>();
				Storagerecord storagerecord = new Storagerecord();
				storagerecord.setMessageCode(IConstant.EMSG0001);
				storagerecord.setRetErrFlag(true);
				list.add(storagerecord);
				rtn.put("rows", null);
				rtn.put("error", list);
				rtn.put("listerror",list);
				return rtn;
			} else {
//				for (Vknifeinventory vk : list) {
//					//金额= 入库数量 * 单价
//
//				}
				int total = storagerecordDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

			}

		} catch (SQLException e) {
			List<Storagerecord> list = new ArrayList<Storagerecord>();
			Storagerecord storagerecord = new Storagerecord();
			storagerecord.setMessageCode(IConstant.EMSG0004);
			storagerecord.setRetErrFlag(true);
			storagerecord.setExceMessage(e.getMessage());
			list.add(storagerecord);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
		return rtn;
	}

	@Override
	public String getNumeber() {
		String total=null;
		try {
			total =String.valueOf(storagerecordDao.searchByCount(new Storagerecord()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
