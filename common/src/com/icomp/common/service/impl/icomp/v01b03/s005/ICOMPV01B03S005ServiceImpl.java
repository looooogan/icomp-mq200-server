package com.icomp.common.service.impl.icomp.v01b03.s005;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b03.s005.ICOMPV01B03S005Service;
import com.icomp.dao.ToolnoticehistoryDao;
import com.icomp.dao.VgrindingquicksearchDao;
import com.icomp.entity.base.Vgrindingquicksearch;

/**
 * 刃磨信息快速查询SERVICES实现类
 * 
 * @ClassName: ICOMPV01B03S005ServiceImpl
 * @author Taoyy
 * @date 2014-8-20 下午04:43:14
 */
public class ICOMPV01B03S005ServiceImpl extends BaseService implements ICOMPV01B03S005Service {

	/**
	 * 刃磨信息快速查询DAO
	 */
	private VgrindingquicksearchDao vgrindingquicksearchDao;

	public void setVgrindingquicksearchDao(VgrindingquicksearchDao vgrindingquicksearchDao) {
		this.vgrindingquicksearchDao = vgrindingquicksearchDao;
	}

	/**
	 * 刀具修复履历Dao
	 */
	private ToolnoticehistoryDao toolnoticehistoryDao;

	public void setToolnoticehistoryDao(ToolnoticehistoryDao toolnoticehistoryDao) {
		this.toolnoticehistoryDao = toolnoticehistoryDao;
	}

	/**
	 * 加工信息快速查询
	 */
	public Map<String, Object> getList(Vgrindingquicksearch entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//ToolCode模糊查询
			List<Vgrindingquicksearch> list = (List<Vgrindingquicksearch>) vgrindingquicksearchDao.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vgrindingquicksearch>();
				Vgrindingquicksearch vgrindingquicksearch = new Vgrindingquicksearch();
				vgrindingquicksearch.setMessageCode(IConstant.EMSG0001);
				vgrindingquicksearch.setRetErrFlag(true);
				list.add(vgrindingquicksearch);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				for (Vgrindingquicksearch vq : list) {
					//约当产量计算
					vq.setResidualValue(getSalvageVal(vq));
				}
				int total = vgrindingquicksearchDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vgrindingquicksearch> list = new ArrayList<Vgrindingquicksearch>();
			Vgrindingquicksearch vgrindingquicksearch = new Vgrindingquicksearch();
			vgrindingquicksearch.setMessageCode(IConstant.EMSG0004);
			vgrindingquicksearch.setRetErrFlag(true);
			vgrindingquicksearch.setExceMessage(e.getMessage());
			list.add(vgrindingquicksearch);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}

	/**
	 * 约当产量计算
	 * 修复后测量长度*(单价/刀具长度)
	 * @title getSalvageVal 
	 * @param vr
	 * @return
	 * String
	 */
	private String getSalvageVal(Vgrindingquicksearch v) {
		DecimalFormat df = new DecimalFormat("#.00");
		Double double1=Double.parseDouble(IConstant.STRING_0);
		if(v.getUnitPrice()!=null){
			double1  =(v.getToolSharpennum().doubleValue()/v.getStandardNum().doubleValue())*v.getUnitPrice().doubleValue();
		}
		return df.format(double1);
	}

}
