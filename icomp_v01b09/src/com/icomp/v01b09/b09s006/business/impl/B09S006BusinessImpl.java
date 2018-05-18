package com.icomp.v01b09.b09s006.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s006.ICOMPV01B09S006Service;
import com.icomp.common.service.impl.icomp.v01b09.s006.ICOMPV01B09S006ServiceImpl;
import com.icomp.entity.base.Tooloptimization;
import com.icomp.v01b09.b09s006.business.B09S006Business;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class B09S006BusinessImpl implements B09S006Business {
	private ICOMPV01B09S006Service b09S006Service;

	private CommonService service;

	public void setService(CommonService service) {
		this.service = service;
	}

	public void setB09S006Service(ICOMPV01B09S006ServiceImpl b09S006Service) {
		this.b09S006Service = b09S006Service;
	}

	public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
//		String  = param.get("dstar").toString().trim();
//		String  = param.get("dend").toString().trim();

		String dateStarStr = null;
		String  dateEndStr = null;
		if (param.get("dstar") != null) {
			dateStarStr =String.valueOf(param.get("dstar")).trim();
		}
		if (param.get("dend") != null) {
			dateEndStr =String.valueOf( param.get("dend")).trim();
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Tooloptimization entity = new Tooloptimization();
		try {
			// 开始时间
			if (dateStarStr != null && dateStarStr != "") {
				dateStarStr += " 00:00:00";
				entity.setDateStar(format.parse(dateStarStr));

			}
			// 出库结束时间
			if (dateEndStr != null && dateEndStr != "") {
				dateEndStr += " 23:59:59";
				entity.setDateEnd(format.parse(dateEndStr));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
			// 材料号
			entity.setToolCode(StringUtils.isEmpty(param.get("toolCode").toString()) ? null : param.get("toolCode").toString());
			// 备注
			entity.setNoteFile(StringUtils.isEmpty(param.get("note").toString()) ? null : param.get("note").toString());
			//操作人
		 	entity.setCreateUser(StringUtils.isEmpty(param.get("recipient").toString()) ? null : param.get("recipient").toString());
			entity.setDelFlag(IConstant.DEL_FLAG_0);
			// 分页起始行数
			entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
			// 分页页数
			entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
			// 排序
		// 	entity.setOrderString("UpdateTime desc");
			// 待处理刀具信息查询-SynthesisParametersCode模糊查询
			Map<String, Object> rtn = b09S006Service.getList(entity);
			if (rtn.size() > 1 && rtn.get("error") != null) {
				// 检索错误时，返回
				throw new BusinessException(((List<Tooloptimization>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
			}
			return rtn;
		}

	@Override
	public Map<String, Object> optimizationAdd(Map<String, Object> param, List<String> uploadFileName, List<File> upload, String langValue, String userId, String langCode) throws BusinessException {
		Map<String, Object> ret = b09S006Service.checkInput(param,langCode,langValue,1,userId);
		if (ret.size() > 1 && ret.get("message") != null) {
			return ret;
		}

		Tooloptimization tooloptimization = (Tooloptimization) ret.get("data");
		//文件批量上传
		try {

			if(uploadFileName!=null&&uploadFileName.size()>0) {
				String path = ServletActionContext.getServletContext().getRealPath("/images");

				File file = new File(path);
				if (!file.exists()) {
					file.mkdir();
				}

				//循环将批量上传的文件保存到本地
				for (int i = 0; i < upload.size(); i++) {
					FileUtils.copyFile(upload.get(i), new File(file, uploadFileName.get(i)));
					String nameset = uploadFileName.get(i);
					String name =uploadFileName.get(i).substring(32);
					if(name.equals("name1")){
						tooloptimization.setApplicationFileName("");
						tooloptimization.setApplicationFileSrc("");
					}else if (name.contains("name1")) {
						tooloptimization.setApplicationFileName(nameset);
						tooloptimization.setApplicationFileSrc(path + "/" + nameset);

					}
					if (name.equals("name2")){
						tooloptimization.setTechnicalFileName("");
						tooloptimization.setTechnicalFileSrc("");

					}else if (name.contains("name2")) {
						tooloptimization.setTechnicalFileName(nameset);
						tooloptimization.setTechnicalFileSrc(path + "/" + nameset);

					}
					if (name.equals("name3")){
						tooloptimization.setExperimentalFileName("");
						tooloptimization.setExperimentalFileSrc("");
					} else if ( name.contains("name3")) {
						tooloptimization.setExperimentalFileName(nameset);
						tooloptimization.setExperimentalFileSrc(path + "/" + nameset);

					}
					if (name.equals("name4")){
						tooloptimization.setReportFileName("");
						tooloptimization.setReportFileSrc("");
					}else if (name.contains("name4")) {
						tooloptimization.setReportFileName(nameset);
						tooloptimization.setReportFileSrc(path + "/" +nameset);

					}
				}

			}

		} catch (IOException e) {
			//上传文件失败
			throw new BusinessException(IConstant.WMSG0112,langCode, langValue);
		}

 			ret = b09S006Service.optimizationAdd(tooloptimization, langCode, langValue);

		if (ret.size() > 0 && ret.get("error") != null) {
			//新建失败时，返回
			throw new BusinessException(((Tooloptimization) ret.get("error")).getMessageCode(), langCode, langValue);
		}
		return ret;

	}

	@Override
	public Map<String, Object> optimizationInfo(Map<String, Object> param, String langCode, String langValue) {
		Map<String,Object> ret = new HashMap<String, Object>();
		String opID = param.get("optimizationID").toString();
		Tooloptimization entity = new Tooloptimization();
		entity.setOptimizationID(opID);
		ret = b09S006Service.getToolOpKey(entity);
		if(ret.size() > 1 && ret.get("error") != null){
			//检索错误时，返回
			throw new BusinessException(((Tooloptimization)ret.get("error")).getMessageCode(),langCode,langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> optimizationEdit(Map<String, Object> param,List<String> uploadFileName, List<File> upload, String langCode, String customer, String langValue) {
		//材料号输入验证
		Map<String,Object> ret = b09S006Service.checkInput(param,langValue,customer,2,customer);
		// 错误信息

		Tooloptimization tooloptimization = (Tooloptimization) ret.get("data");
		//文件批量上传
		try {

			if(uploadFileName!=null&&uploadFileName.size()>0) {
				String path = ServletActionContext.getServletContext().getRealPath("/images");

				File file = new File(path);
				if (!file.exists()) {
					file.mkdir();
				}

				//循环将批量上传的文件保存到本地
				for (int i = 0; i < upload.size(); i++) {
					FileUtils.copyFile(upload.get(i), new File(file, uploadFileName.get(i)));
					String nameset = uploadFileName.get(i);
					String name =uploadFileName.get(i).substring(32);
					if(name.equals("name1")){

					}else if (name.contains("name1")) {
						tooloptimization.setApplicationFileName(nameset);
						tooloptimization.setApplicationFileSrc(path + "/" + nameset);

					}
					if (name.equals("name2")){

					}else if (name.contains("name2")) {
						tooloptimization.setTechnicalFileName(nameset);
						tooloptimization.setTechnicalFileSrc(path + "/" + nameset);

					}
					if (name.equals("name3")){

					} else if ( name.contains("name3")) {
						tooloptimization.setExperimentalFileName(nameset);
						tooloptimization.setExperimentalFileSrc(path + "/" + nameset);

					}
					if (name.equals("name4")){
					}else if (name.contains("name4")) {
						tooloptimization.setReportFileName(nameset);
						tooloptimization.setReportFileSrc(path + "/" +nameset);

					}
				}

			}

		} catch (IOException e) {
			//上传文件失败
			throw new BusinessException(IConstant.WMSG0112,langCode, langValue);
		}

		ret = b09S006Service.optimizationEdit(tooloptimization,langCode,langValue);


		if(ret.size() > 1 && ret.get("error") != null){
			//新建失败时，返回
			throw new BusinessException(((Tooloptimization)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		return ret;
	}

	@Override
	public Map<String, Object> getOptimization(String langCode, String langValue) throws BusinessException {
		Map<String,Object> ret = new HashMap<String,Object> ();
		List<Tooloptimization> tooloptimizationList = b09S006Service.getToolopList();
		if(tooloptimizationList.size()>0 && tooloptimizationList.get(0).isRetErrFlag()){
			//检索错误时，返回
			throw new BusinessException(tooloptimizationList.get(0).getMessageCode(), langCode,  langValue);
		}
		ret.put("TooloptimizationList", tooloptimizationList);
		return ret;
	}

	@Override
	public Map<String, Object> potimizationDel(Map<String, Object> param, String langCode, String customer, String langValue) {
		Tooloptimization entity = new Tooloptimization();
		entity.setDelFlag(IConstant.DEL_FLAG_1);
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(customer);
		entity.setOptimizationIDWhere(param.get("optimizationID").toString());
		Map<String,Object> ret = b09S006Service.potimizationDel(entity,langCode,langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			//删除失败时，返回
			throw new BusinessException(((Tooloptimization)ret.get("error")).getMessageCode(), langCode,langValue);
		}
		return ret;
	}


}
