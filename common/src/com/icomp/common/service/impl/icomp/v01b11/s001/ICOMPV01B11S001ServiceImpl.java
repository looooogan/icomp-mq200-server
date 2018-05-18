package com.icomp.common.service.impl.icomp.v01b11.s001;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b11.s001.ICOMPV01B11S001Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.CapabilityDao;
import com.icomp.dao.PolinkDao;
import com.icomp.dao.VcaplistDao;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Polink;
import com.icomp.entity.base.Vcaplist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01B11S001ServiceImpl extends BaseService implements
		ICOMPV01B11S001Service {

	/**
	 * 功能Dao
	 */
	private CapabilityDao capabilityDao;

	public void setCapabilityDao(CapabilityDao capabilityDao) {
		this.capabilityDao = capabilityDao;
	}

	private VcaplistDao vcaplistDao;
	public void setVcaplistDao(VcaplistDao vcaplistDao) {
		this.vcaplistDao = vcaplistDao;
	}

	private PolinkDao polinkDao;
	public void setPolinkDao(PolinkDao polinkDao) {
		this.polinkDao = polinkDao;
	}


	/**
	 * 功能管理
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 角色信息
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Capability entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Capability> list = (List<Capability>) capabilityDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Capability>();
				Capability capability = new Capability();
				//消息：检索为0
				capability.setMessageCode(IConstant.EMSG0001);
				capability.setRetErrFlag(true);
				list.add(capability);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				rtn.put("rows", list);
				return rtn;
			}

		} catch (SQLException e) {
			List<Capability> list = new ArrayList<Capability>();
			Capability capability = new Capability();
			//错误消息：数据库操作异常，查询失败!
			capability.setMessageCode(IConstant.EMSG0004);
			capability.setRetErrFlag(true);
			capability.setExceMessage(e.getMessage());
			list.add(capability);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	

	/**
	 * 取得功能信息列表
	 * @param // param 页面检索条件
	 * @param // lang 语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRoleGruanList(Vcaplist entity){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//取得用户权限信息
			List<Vcaplist> list = (List<Vcaplist>) vcaplistDao.searchByList(entity);
			if(list == null || list.size() <= 0){
				list = new ArrayList<Vcaplist>();
				Vcaplist capability = new Vcaplist();
				//消息：检索为0
				capability.setMessageCode(IConstant.EMSG0001);
				capability.setRetErrFlag(true);
				list.add(capability);
				rtn.put("rows", null);
				rtn.put("error", list);
				rtn.put("status", IConstant.RESULT_CODE_2);
				return rtn;
			} else {
				rtn.put("status", IConstant.RESULT_CODE_0);
				rtn.put("rows", list);
				return rtn;
			}
			
		} catch (SQLException e) {
			List<Vcaplist> list = new ArrayList<Vcaplist>();
			Vcaplist vcaplist = new Vcaplist();
			//错误消息：数据库操作异常，查询失败!
			vcaplist.setMessageCode(IConstant.EMSG0004);
			vcaplist.setRetErrFlag(true);
			vcaplist.setExceMessage(e.getMessage());
			list.add(vcaplist);
			rtn.put("rows", null);
			rtn.put("error", list);
			rtn.put("status", IConstant.RESULT_CODE_2);
			return rtn;
		}
	}

	/**
	 * 保存权限信息列表
	 * @param  //页面检索条件
	 * @param  //语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> saveGruant(List<Polink> list,String langCode,String langValue){
		Polink del = new Polink();
		del.setPositionIDWhere(list.get(0).getPositionID());
		Map<String,Object> rtn = new HashMap<String,Object>();
		int i = 0;
		try {
			i = polinkDao.searchByCount(del);
			if(i > 0)
			polinkDao.delete(del);
			for (Polink polink : list) {
			  polinkDao.insert(polink);
			}
			Vcaplist vcap=new Vcaplist();
			vcap.setPositionID(list.get(0).getPositionID());
			List<Vcaplist> reternList = (List<Vcaplist>) vcaplistDao.searchByList(vcap);
			//更新成功
			rtn.put("rows", reternList);
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, langCode,langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			Polink entity = new Polink();
			//错误消息：数据库操作异常，更新失败!
			entity.setMessageCode(IConstant.EMSG0006);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}
	
}
