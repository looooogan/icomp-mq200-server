package com.icomp.common.service.impl.icomp.v01b04.s006;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b04.s006.ICOMPV01B04S006Service;
import com.icomp.dao.VprocessingquickqueryDao;
import com.icomp.entity.base.Vprocessingquickquery;
/**
 *  加工信息快速查询SERVICES实现类
 * @ClassName: ICOMPV01B04S006ServiceImpl 
 * @author Taoyy
 * @date 2014-8-20 下午06:19:41
 */

public class ICOMPV01B04S006ServiceImpl extends BaseService implements ICOMPV01B04S006Service {

	/**
	 * 加工信息快速查询DAO
	 */
	private VprocessingquickqueryDao vprocessingquickqueryDao;

	public void setVprocessingquickqueryDao(
			VprocessingquickqueryDao vprocessingquickqueryDao) {
		this.vprocessingquickqueryDao = vprocessingquickqueryDao;
	}
	
	public Map<String, Object> getList(Vprocessingquickquery entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vprocessingquickquery> list = (List<Vprocessingquickquery>) vprocessingquickqueryDao.searchByList_B04S006(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vprocessingquickquery>();
				entity.setMessageCode(IConstant.EMSG0001);
				entity.setRetErrFlag(true);
				list.add(entity);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vprocessingquickquery v : list) {
					//约当产量
					v.setsalvageValue(getsalvageValue(v));
				}
				int total = vprocessingquickqueryDao.searchByCount_B04S006(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			List<Vprocessingquickquery> list = new ArrayList<Vprocessingquickquery>();
			entity.setMessageCode(IConstant.EMSG0004);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			list.add(entity);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	/**
	 * 约当产量
	 * （（可使用次数-已使用次数）*加工数量）/可使用次数)
	 * @title getSalvageVal 
	 * @param vr
	 * @return
	 * String
	 */
	private String getsalvageValue(Vprocessingquickquery v) {
		DecimalFormat df = new DecimalFormat("#.00");
		Double double1=new Double(0);
		if(v.getavgProcessAmount()!=null&&v.getToolSharpennum()!=null){
			double1=(v.getToolSharpennum().doubleValue()-v.getUsageCounter().doubleValue())*v.getavgProcessAmount().doubleValue()/v.getToolSharpennum().doubleValue();
			return df.format(double1);
		}else{
			return "";
		}
	}

}
