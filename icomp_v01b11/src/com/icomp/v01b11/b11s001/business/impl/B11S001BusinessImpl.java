package com.icomp.v01b11.b11s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b11.s001.ICOMPV01B11S001Service;
import com.icomp.entity.base.Capability;
import com.icomp.entity.base.Comlist;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Polink;
import com.icomp.entity.base.Vagency;
import com.icomp.entity.base.Vcaplist;
import com.icomp.entity.base.Vdepartment;
import com.icomp.entity.base.Vposition;
import com.icomp.v01b11.b11s001.business.B11S001Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class B11S001BusinessImpl implements B11S001Business {

	private ICOMPV01B11S001Service iCOMPV01B11S001Service;

	public void setiCOMPV01B11S001Service(
			ICOMPV01B11S001Service iCOMPV01B11S001Service) {
		this.iCOMPV01B11S001Service = iCOMPV01B11S001Service;
	}

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	/**
	 * 取得用户信息列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param // lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		// 设置检索条件
		Capability entity = new Capability();
		// 排序
		entity.setOrderString("CapabilityID");
		Map<String, Object> rtn = iCOMPV01B11S001Service.getList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Capability>) rtn.get("error"))
					.get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 保存权限信息列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param
	 *         //   语言编码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> saveGruant(Map<String, Object> param,
			String user, String langCode, String langValue)
			throws BusinessException {
		List<Polink> polinkList = new ArrayList<Polink>();
		String capabilityStr = (String) param.get("capabilityID");
		String[] capabilityList=capabilityStr.split(",");
		// 取得编辑角色权限
		if ("".equals(param.get("PositionID").toString())) {
			throw new BusinessException(IConstant.WMSG0017, langCode, langValue);
		}
		String poid = param.get("PositionID").toString();
		/*String key = NextKeyValue.getkeyvalueNO(IConstant.POLINK,
				IConstant.POLINK_ID,user);*/
        String key = null;
        for (String capabilityid : capabilityList) {
			Polink polink = new Polink();
			//key = (new BigDecimal(key).add(BigDecimal.ONE)).toString();
             key = UUID.randomUUID().toString();
            polink.setPoLinkID(key);
			polink.setCapabilityID(capabilityid);
			polink.setPositionID(poid);
			polinkList.add(polink);
		}
		//NextKeyValue.savekeyvalue(IConstant.POLINK, IConstant.POLINK_ID, key,user);
		Map<String, Object> ret = iCOMPV01B11S001Service.saveGruant(polinkList,
				langCode, langValue);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 保存失败时，返回
			throw new BusinessException(((Polink) ret.get("error"))
					.getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得职务对应权限信息列表
	 * 
	 * @param param
	 *            页面检索条件
	 * @param //lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getRoleGruanList(Map<String, Object> param,
			String langCode, String langValue) throws BusinessException {
		
		if ("".equals(param.get("PositionID").toString())) {
			throw new BusinessException(IConstant.WMSG0017, langCode, langValue);
		}
		Vcaplist entity = new Vcaplist();
		entity.setPositionID(param.get("PositionID").toString());
		Map<String, Object> rtn =  iCOMPV01B11S001Service.getRoleGruanList(entity);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Capability>) rtn.get("error"))
					.get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;
	}

	/**
	 * 取得部门信息列表
	 * 
	 * @param param
	 * @param //lang
	 * @return
	 * @throws BusinessException
	 */
	public List<Vagency> getAgencyList(String param, String langCode,
			String langValue) throws BusinessException {
		Vagency entity = new Vagency();
		entity.setDelFlag(param);
		entity.setAgencyLanguageCode(langCode);
		List<Vagency> list = service.getVagency(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;

	}

	/**
	 * 取得部门信息列表
	 * 
	 * @param //param
	 * @param //lang
	 * @return
	 * @throws BusinessException
	 */
	public List<Vdepartment> getDepartmentList(String agencyID, String delFlag,
			String langCode, String langValue) throws BusinessException {
		Vdepartment entity = new Vdepartment();
		entity.setDepartmentAgencyID(agencyID);
		entity.setDepartmentDelFlag(delFlag);
		entity.setDepartmentLanguageCode(langCode);
		List<Vdepartment> list = service.getVdepartment(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;

	}

	/**
	 * 取得职务信息列表
	 * 
	 * @param param
	 *            部门ID
	 * @param delFlag
	 *            删除区分
	 * @param //lang
	 *            语言编码
	 * @return
	 * @throws BusinessException
	 */
	public List<Vposition> getPositionList(Map<String, Object> param, String delFlag,
			String langCode, String langValue) throws BusinessException {
		Vposition entity = new Vposition();
		String departmentID = param.get("DepartmentID").toString();
		String agencyID = param.get("AgencyID").toString();
		entity.setDepartmentID(departmentID);
		entity.setAgencyID(agencyID);
		entity.setDelFlag(delFlag);
		List<Vposition> list = service.getVposition(entity);
		if (list.size() == 1 && list.get(0).isRetErrFlag()) {
			throw new BusinessException(list.get(0).getMessageCode(), langCode,
					langValue);
		}
		return list;
	}

	/**
	 * 取得页面grid显示项目列表
	 * 
	 * @param pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getGridColmun(String pageID, String userID,
			String langCode, String langValue) throws BusinessException {

		// 取得页面grid显示项目列表
		Map<String, Object> ret = service.getGridColmun(pageID, langCode,
				IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}

	/**
	 * 取得页面Capability显示项目树
	 * 
	 * @param //pageID
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCapTree(Map<String, Object> param,
			String langCode, String langValue) {
		// 设置检索条件
		Capability entity = new Capability();
		entity.setDelFlag(IConstant.STRING_0);
		// 排序
		entity.setOrderString("CapabilityID");
		Map<String, Object> rtn = iCOMPV01B11S001Service
				.getList(entity);
		List<Capability> capList = (List<Capability>) rtn.get("rows");
		Map<String, Object> VcapMap = new HashMap<String, Object>();
		List<Capability> capRtnList = new ArrayList<Capability>();
		for (Capability vcap : capList) {
			if (vcap.getCapabilityLevel().toString().equals(IConstant.STRING_1)) {
				if(vcap.getBelongFlag().equals(IConstant.STRING_0)){
					vcap.setzTreeParentId(IConstant.STRING_1);
					vcap.setzTreeId(IConstant.STRING_1+vcap.getCapabilityOrder().toString());
				}else if(vcap.getBelongFlag().equals(IConstant.STRING_1)){
					vcap.setzTreeParentId(IConstant.STRING_2);
					vcap.setzTreeId(IConstant.STRING_2+vcap.getCapabilityOrder().toString());
				}else{
					vcap.setzTreeParentId(IConstant.STRING_9);
					vcap.setzTreeId(IConstant.STRING_9+vcap.getCapabilityOrder().toString());
				}
				capRtnList.add(vcap);
				VcapMap.put(vcap.getCapabilityID(), vcap);
			}
		}
		for (Capability vcap : capList) {
			if (IConstant.STRING_2.equals(vcap.getCapabilityLevel().toString()) || IConstant.STRING_3.equals(vcap.getCapabilityLevel().toString())) {
				Capability vParcap = (Capability) VcapMap.get(vcap
						.getCapCapabilityID());
				if (vParcap != null) {
					vcap.setzTreeParentId(vParcap.getzTreeId());
					vcap.setzTreeId(vParcap.getzTreeId() + IConstant.STRING_0
							+ vcap.getCapabilityOrder());
					capRtnList.add(vcap);
					VcapMap.put(vcap.getCapabilityID(), vcap);
				}
			}
		}
	/*	for (Capability vcap : capList) {
			if (IConstant.STRING_3.equals(vcap.getCapabilityLevel().toString())) {
				Capability vParcap = (Capability) VcapMap.get(vcap
						.getCapCapabilityID());
				if (vParcap != null) {
					vcap.setzTreeParentId(vParcap.getzTreeId());
					vcap.setzTreeId(vParcap.getzTreeId() + IConstant.STRING_0
							+ vcap.getCapabilityOrder());
					capRtnList.add(vcap);
					VcapMap.put(vcap.getCapabilityID(), vcap);
				}
			}
		}*/
		rtn.put("rows", capRtnList);
		if (rtn.size() > 1 && rtn.get("error") != null) {
			// 检索错误时，返回
			throw new BusinessException(((List<Capability>) rtn.get("error"))
					.get(0).getMessageCode(), langCode, langValue);
		}
		return rtn;

	}
	/**
	 * 取得系统区分列表
	 * @param flagType 区分定义名称
	 * @return
	 * @throws BusinessException
	 */
	public List<Comlist> getComList(String flagType,String langCode,String langValue)throws BusinessException{
		Comlist entity = new Comlist();
		entity.setComListType(flagType);
		entity.setLanguageCode(langCode);
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		List<Comlist> list = service.getComList(entity);
		if(list.size() == 1 && list.get(0).isRetErrFlag()){
			  throw new BusinessException(list.get(0).getMessageCode(), langCode,langValue);
		}
		return list;
	}
}
