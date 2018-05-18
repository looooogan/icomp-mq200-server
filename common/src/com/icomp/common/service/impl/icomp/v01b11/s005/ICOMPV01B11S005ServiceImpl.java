package com.icomp.common.service.impl.icomp.v01b11.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b11.s005.ICOMPV01B11S005Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.LeasertabeDao;
import com.icomp.entity.base.Leasertabe;
import com.icomp.entity.base.Warning;

import java.sql.SQLException;
import java.util.*;

public class ICOMPV01B11S005ServiceImpl extends BaseService implements ICOMPV01B11S005Service {

	private LeasertabeDao leasertabeDao;

	public void setLeasertabeDao(LeasertabeDao leasertabeDao) {
		this.leasertabeDao = leasertabeDao;
	}

	@Override
	public Map<String, Object> getList(Leasertabe entity) {

		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Leasertabe> list = (List<Leasertabe>) leasertabeDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Leasertabe>();
				Leasertabe lease = new Leasertabe();
				//消息：检索为0
				lease.setMessageCode(IConstant.EMSG0001);
				lease.setRetErrFlag(true);
				list.add(lease);
				rtn.put("rows", null);
				rtn.put("error", list);
			} else {
				int total = leasertabeDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE)
						/ IConstant.ROWSIZE);
			}

		} catch (SQLException e) {
			List<Leasertabe> list = new ArrayList<Leasertabe>();
			Leasertabe lease = new Leasertabe();
			//错误消息：数据库操作异常，查询失败!
			lease.setMessageCode(IConstant.EMSG0004);
			lease.setRetErrFlag(true);
			lease.setExceMessage(e.getMessage());
			list.add(lease);
			rtn.put("rows", null);
			rtn.put("error", list);

		}
		return rtn;
	}


	public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, String userID, int i) {
		return null;
	}



	public Map<String, Object> VwarningAdd(Warning entity, String langCode, String langValue) {
		return null;
	}


	public Map<String, Object> getLease(Map<String, Object> param, Leasertabe entity, String customerID){
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 监听点击的按钮(0:确认1:取消)
		String sspID = param.get("sspID").toString();

		try {
			List<Leasertabe> list = (List<Leasertabe>) leasertabeDao.searchByList(entity);
			if (list == null || list.size() == 0) {
				entity = new Leasertabe();
				// 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
				entity.setMessageCode(IConstant.WMSG0009);
				entity.setRetErrFlag(true);
				rtn.put("error", entity);
				rtn.put("data", null);
				// 更新项目打印成功
			}

			Leasertabe leaser = new Leasertabe();
			//激光码id
			leaser.setLeaserIDWhere(list.get(0).getLeaserID());

			if ("1".equals(sspID)) {
				// 点击取消按钮时，删除已传送的激光码
				int ret = leasertabeDao.delete(leaser);
			} else {
				// 点击确定按钮时，该激光码的状态变为已激活
				leaser.setLaserState(sspID);
				leaser.setUpdateTime(new Date());
				leaser.setUpdateUser(customerID);
				int ret = leasertabeDao.updateNonQuery(leaser);
			}
			rtn.put("message", MessageReSource.getMessageBox(
					IConstant.IMSG0005, "", ""));
			rtn.put("status", IConstant.RESULT_CODE_0);

			return rtn;


		} catch (SQLException e) {
			Leasertabe leasertabe = new Leasertabe();
			//错误消息：数据库操作异常，查询失败!
			leasertabe.setMessageCode(IConstant.EMSG0004);
			leasertabe.setRetErrFlag(true);
			leasertabe.setExceMessage(e.getMessage());
			rtn.put("data", null);
			rtn.put("error", leasertabe);
			return rtn;
		}
	}
}
