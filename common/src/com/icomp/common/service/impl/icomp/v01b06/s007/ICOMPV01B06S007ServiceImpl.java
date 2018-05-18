package com.icomp.common.service.impl.icomp.v01b06.s007;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s007.ICOMPV01B06S007Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.VconsumptiontoolDao;
import com.icomp.entity.base.Vconsumptiontool;
/**
 * 单品刀具分析SERVICES实现类
 * @ClassName: ICOMPV01B06S007ServiceImpl 
 * @author Taoyy
 * @date 2014-8-22 上午10:17:22
 */


public class ICOMPV01B06S007ServiceImpl extends BaseService implements ICOMPV01B06S007Service {

	/**
	 * 单品刀具分析DAO
	 */
	private VconsumptiontoolDao vconsumptiontoolDao;
	public void setVconsumptiontoolDao(VconsumptiontoolDao vconsumptiontoolDao) {
		this.vconsumptiontoolDao = vconsumptiontoolDao;
	}



	public Map<String, Object> getList(Vconsumptiontool entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			//toolCode模糊查询
			List<Vconsumptiontool> list = (List<Vconsumptiontool>) vconsumptiontoolDao.searchByList_F(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vconsumptiontool>();
				Vconsumptiontool vconsumptiontool = new Vconsumptiontool();
				vconsumptiontool.setMessageCode(IConstant.EMSG0001);
				vconsumptiontool.setRetErrFlag(true);
				list.add(vconsumptiontool);
				rtn.put("rows", null);
				rtn.put("error", list);
				return rtn;
			} else {
				//结果集
				List<Vconsumptiontool> rtnList =new ArrayList<Vconsumptiontool>();
				for (Vconsumptiontool vconsumptiontool : list) {
					vconsumptiontool.setAvgNum(getAvgNumValue(vconsumptiontool));
					rtnList.add(vconsumptiontool);
				}
				rtn.put("rows", rtnList);
				//总数量 
				int total = vconsumptiontoolDao.searchByCount(entity);
				rtn.put("total", total);
				rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
				return rtn;
			}

		} catch (SQLException e) {
			List<Vconsumptiontool> list = new ArrayList<Vconsumptiontool>();
			Vconsumptiontool vconsumptiontool = new Vconsumptiontool();
			vconsumptiontool.setMessageCode(IConstant.EMSG0004);
			vconsumptiontool.setRetErrFlag(true);
			vconsumptiontool.setExceMessage(e.getMessage());
			list.add(vconsumptiontool);
			rtn.put("rows", null);
			rtn.put("error", list);
			return rtn;
		}
	}
	//平均值
	public String getAvgNumValue(Vconsumptiontool entity) {
		 DecimalFormat df = new DecimalFormat("#0.00");
		 Double dou=new Double(0);
		if(entity.getProcessAmountSum()!=null
			&&entity.getconsumedCount()!=null
			&&!entity.getconsumedCount().equals(BigDecimal.ZERO)){
			dou=entity.getProcessAmountSum().doubleValue()/entity.getconsumedCount().doubleValue();
		}
		return df.format(dou)+"";
	}

	@Override
	public Object getStatisticalCount(Vconsumptiontool entity) {
		return null;
	}

	/**
	 * 验证参数信息
	 * 
	 * @param param
	 * @param langValue
	 * @return
	 */
	@Override
	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String customerID, String langValue, int checkType) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Vconsumptiontool entity = new Vconsumptiontool();
		Map<String, String> map = new HashMap<String, String>();
			if (checkType == 0) {//分析验证
				if (StringUtils.isEmpty(param.get("ToolCode").toString())) {
					// 请输入刀具编码WMSG0055
					map.put("ToolCode", MessageReSource.getMessageBox(
							IConstant.WMSG0055, langCode, langValue));
				} else {
					entity.setToolCode(param.get("ToolCode")
							.toString());
				}
			}
			if (map.size() > 0) {
				rtn.put("message", map);
				rtn.put("status", IConstant.RESULT_CODE_1);// 返回错误消息
			} else {
				rtn.put("data", entity);
				rtn.put("status", IConstant.RESULT_CODE_0);// 验证正常
			}
			return rtn;
	}




}
