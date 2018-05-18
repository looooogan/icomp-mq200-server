package com.icomp.common.service.impl.icomp.v01b08.s010;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b08.s010.ICOMPV01B08S010Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.AssemblylineDao;
import com.icomp.dao.ProductiondesignDao;
import com.icomp.dao.VproductiondesignDao;
import com.icomp.entity.base.Assemblyline;
import com.icomp.entity.base.Productiondesign;
import com.icomp.entity.base.Vproductiondesign;
@SuppressWarnings("unchecked")
public class ICOMPV01B08S010ServiceImpl extends BaseService implements
		ICOMPV01B08S010Service {

	/**
	 * 零部件视图配置Dao
	 */
	private VproductiondesignDao vproductiondesignDao;

	public void setVproductiondesignDao(
			VproductiondesignDao vproductiondesignDao) {
		this.vproductiondesignDao = vproductiondesignDao;
	}

	private AssemblylineDao assemblylineDao;

	public void setAssemblylineDao(AssemblylineDao assemblylineDao) {
		this.assemblylineDao = assemblylineDao;
	}

	private ProductiondesignDao productiondesignDao;

	public void setProductiondesignDao(ProductiondesignDao productiondesignDao) {
		this.productiondesignDao = productiondesignDao;
	}

	/**
	 * 零部件配置
	 * 
	 * @param entity
	 *            页面查询条件
	 * @return 手持机配置信息
	 * @throws BusinessException
	 */
	public Map<String, Object> getList(Vproductiondesign entity) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		try {
			List<Vproductiondesign> list = (List<Vproductiondesign>) vproductiondesignDao
					.searchByList(entity);
			if (list.size() <= 0) {
				list = new ArrayList<Vproductiondesign>();
				Vproductiondesign vproductiondesign = new Vproductiondesign();
				// 消息：检索为0
				vproductiondesign.setMessageCode(IConstant.EMSG0001);
				vproductiondesign.setRetErrFlag(true);
				list.add(vproductiondesign);
				rtn.put("rows", null);
				rtn.put("status", IConstant.RESULT_CODE_1);// 数据条数为0
				rtn.put("error", list);
			} else {
				int total = vproductiondesignDao.searchByCount(entity);
				rtn.put("rows", list);
				rtn.put("total", total);
				rtn.put("page",(entity.getStaIndex() + IConstant.ROWSIZE_12) / IConstant.ROWSIZE_12);
			}
			return rtn;

		} catch (SQLException e) {
			List<Vproductiondesign> list = new ArrayList<Vproductiondesign>();
			Vproductiondesign vproductiondesign = new Vproductiondesign();
			// 错误消息：数据库操作异常，查询失败!
			vproductiondesign.setMessageCode(IConstant.EMSG0004);
			vproductiondesign.setRetErrFlag(true);
			vproductiondesign.setExceMessage(e.getMessage());
			list.add(vproductiondesign);
			rtn.put("rows", null);
			rtn.put("status", IConstant.RESULT_CODE_2);// 异常
			rtn.put("error", list);
			return rtn;
		}
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
		Vproductiondesign entity = new Vproductiondesign();
		List<Productiondesign> saveEntity = new ArrayList<Productiondesign>();
		Map<String, String> map = new HashMap<String, String>();
			if (checkType == 1) {
				if (StringUtils.isEmpty(param.get("ProductionYear").toString())) {
					// 请输入年
					map.put("ProductionYear", MessageReSource.getMessageBox(
							IConstant.WMSG0206, langCode, langValue));
				} else 	if (!checkOutYear(param.get("ProductionYear").toString())) {
					// 请检查年的格式
					map.put("ProductionYear","请检查年的格式!");
				} else{
					entity.setProductionYear(param.get("ProductionYear")
							.toString());
				}
				if (StringUtils.isEmpty(param.get("AssemblyLineID")
						.toString())) {
					// 请选择零部件!
					map.put("AssemblyLineID", "请选择零部件!");
				} else {
					entity.setAssemblyLineID(param.get("AssemblyLineID")
							.toString());
				}
			}
			if (checkType == 1) {
				// 保存验证
				for (int i = 1; i <= 12; i++) {
					Productiondesign saveSubEntity = new Productiondesign();
					// 位置类型
					if (StringUtils.isEmpty(param.get(
							"DivAssemblyLineAmount_" + i ).toString())) {
						//请输入计划产量!
						map.put("DivAssemblyLineAmount_" + i ,"请输入{0}计划产量!".replace("{0}", i+"月"));
						break;
					}else if (!checkOutNum(param.get(
							"DivAssemblyLineAmount_" + i ).toString())) {
						//请输入计划产量!
						map.put("DivAssemblyLineAmount_" + i ,"计划产量应为数字格式!");
						break;
					} else if(map.size()<=0){
						saveSubEntity.setProductionYear(param.get(	"ProductionYear").toString());// 年
						saveSubEntity.setAssemblyLineID(param.get("AssemblyLineID").toString());// 生产零部件id
						saveSubEntity.setProductionMonth(i + "");// 月份
						String Quarter= (int)Math.ceil(i /3.0001)+"";
						saveSubEntity.setProductionQuarter(Quarter);// 季度
						saveSubEntity.setProduction(new BigDecimal(
								param.get("DivAssemblyLineAmount_" + i ).toString()));// 生产量
						saveSubEntity.setUpdateTime(new Date());// 更新时间
						saveSubEntity.setUpdateUser(customerID);// 更新者
						saveSubEntity.setDelFlag(IConstant.DEL_FLAG_0);// 删除区分-有效
						saveSubEntity.setVersion(BigDecimal.ZERO);// 版本号
					}
					saveEntity.add(saveSubEntity);
				}
			}
			if (map.size() > 0) {
				rtn.put("message", map);
				rtn.put("status", IConstant.RESULT_CODE_1);// 返回错误消息
				return rtn;
			} else if (map.size() <= 0 && checkType == 1) {// 如果是save
				rtn.put("data", saveEntity);
				rtn.put("status", IConstant.RESULT_CODE_0);// 验证正常

			} else {
				rtn.put("data", entity);
				rtn.put("status", IConstant.RESULT_CODE_0);// 验证正常
			}
			return rtn;
	}

	/**
	 * 保存外送方式配置
	 * 
	 * @return
	 */

	@Override
	public Map<String, Object> productionDesignSave(
			List<Productiondesign> entitylist, String langCode,
			String customerID, String langValue) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Productiondesign entity = new Productiondesign();
		try {
			entity.setAssemblyLineID(entitylist.get(0).getAssemblyLineID());
			entity.setProductionYear(entitylist.get(0).getProductionYear());
			List<Productiondesign> list = (List<Productiondesign>) productiondesignDao
					.searchByList(entity);
			if (list.size() > 0) {
				entity.setAssemblyLineIDWhere(entitylist.get(0).getAssemblyLineID());
				entity.setProductionYearWhere(entitylist.get(0).getProductionYearWhere());
				productiondesignDao.delete(entity);
			}
			for (Productiondesign synLoc : entitylist) {
				synLoc.setProductionDesignID(NextKeyValue.getNextkeyvalue(IConstant.PRODUCTIONDESIGN,
						IConstant.PRODUCTIONDESIGNID,customerID));// 取得主键
				synLoc.setCreateTime(new Date());// 创建时间
				synLoc.setCreateUser(customerID);// 创建者
				productiondesignDao.insert(synLoc);
			}
			//插入成功

			rtn.put("message", MessageReSource.getMessageBox(
							IConstant.IMSG0004, langCode,  langValue));
			rtn.put("status", IConstant.RESULT_CODE_0);
			return rtn;
		} catch (SQLException e) {
			e.printStackTrace();
			// 错误消息：数据库操作异常，插入失败!
			entity.setMessageCode(IConstant.EMSG0007);
			entity.setRetErrFlag(true);
			entity.setExceMessage(e.getMessage());
			rtn.put("error", entity);
			rtn.put("data", null);
			return rtn;
		}
	}

	/**
	 * 取得零部件列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	
	@Override
	public List<Assemblyline> getAssemblylineList(Assemblyline entity) {
		try {

			List<Assemblyline> list = (List<Assemblyline>) assemblylineDao
					.searchByList(entity);
			if (list.size() <= 0) {
				// 列表取得失败!
				list = new ArrayList<Assemblyline>();
				Assemblyline vbusiness = new Assemblyline();
				vbusiness.setMessageCode(IConstant.WMSG0008);
				vbusiness.setRetErrFlag(false);
				list.add(vbusiness);
				return list;
			} else {
				return list;
			}
		} catch (SQLException e) {
			List<Assemblyline> list = new ArrayList<Assemblyline>();
			Assemblyline vbusiness = new Assemblyline();
			// 错误消息：数据库操作异常，查询失败!
			vbusiness.setMessageCode(IConstant.EMSG0004);
			vbusiness.setRetErrFlag(true);
			vbusiness.setExceMessage(e.getMessage());
			list.add(vbusiness);
			return list;
		}
	}

	@Override
	public List<Vproductiondesign> getYearList(Vproductiondesign entity) {
			List<Vproductiondesign> rtn;
			try {
				rtn = (List<Vproductiondesign>) vproductiondesignDao
						.getYearList(entity);
			
			if (rtn.size() <= 0) {
				rtn = new ArrayList<Vproductiondesign>();
				Vproductiondesign vproductiondesign = new Vproductiondesign();
				// 消息：检索为0
				vproductiondesign.setMessageCode(IConstant.EMSG0001);
				vproductiondesign.setRetErrFlag(true);
				rtn.add(vproductiondesign);
			} 
				return rtn;
			} catch (SQLException e) {
				rtn = new ArrayList<Vproductiondesign>();
				return rtn;
			}
	}

}