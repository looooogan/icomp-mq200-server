package com.icomp.common.service.impl.icomp.v01b06.s010;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s010.ICOMPV01B06S010Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.TooltransferDao;
import com.icomp.dao.VtooldiscardeDao;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.Vtooldiscarde;

/**
 * 刀具报废SERVICES实现类
 * 
 * @ClassName: ICOMPV01B06S010ServiceImpl
 * @author Taoyy
 * @date 2014-8-22 上午10:27:29
 */

public class ICOMPV01B06S010ServiceImpl extends BaseService implements
ICOMPV01B06S010Service {

	private VtooldiscardeDao vtooldiscardeDao;
	public void setVtooldiscardeDao(VtooldiscardeDao vtooldiscardeDao) {
		this.vtooldiscardeDao = vtooldiscardeDao;
	}
	
	private TooltransferDao tooltransferDao;  
	public void setTooltransferDao(TooltransferDao tooltransferDao) {
		this.tooltransferDao = tooltransferDao;
	}

	/**
	 * 刀具报废
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> getList(Vtooldiscarde entity){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//toolCode模糊查询
			List<Vtooldiscarde> list = (List<Vtooldiscarde>) vtooldiscardeDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vtooldiscarde>();
				Vtooldiscarde vtooldiscarde = new Vtooldiscarde();
				vtooldiscarde.setMessageCode(IConstant.EMSG0001);
				vtooldiscarde.setRetErrFlag(true);
				list.add(vtooldiscarde);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				//总数量
				int total = vtooldiscardeDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vtooldiscarde> list = new ArrayList<Vtooldiscarde>();
			Vtooldiscarde vtooldiscarde = new Vtooldiscarde();
			vtooldiscarde.setMessageCode(IConstant.EMSG0004);
			vtooldiscarde.setRetErrFlag(true);
			vtooldiscarde.setExceMessage(e.getMessage());
			list.add(vtooldiscarde);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	
	/**
	 * 报废刀具确认
	 * @title getList 
	 * @param entity
	 * @return
	 * Map<String,Object>
	 */
	public Map<String, Object> b06s010Save(String toolCode,String discardeTime,String langCode, String langValue){
		Map<String, Object> rtn = new HashMap<String, Object>();
		try{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("updateTime", discardeTime);
		map.put("toolCode", toolCode);
		// 更新职务成功
		@SuppressWarnings("unused")
		int ret = tooltransferDao.saveb06s010(map);
		rtn.put("message", MessageReSource.getMessageBox(
				IConstant.IMSG0005, langCode, langValue));
		rtn.put("status", IConstant.RESULT_CODE_0);
		
		return rtn;
	} catch (SQLException e) {
		Tooltransfer entity = new Tooltransfer();
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
