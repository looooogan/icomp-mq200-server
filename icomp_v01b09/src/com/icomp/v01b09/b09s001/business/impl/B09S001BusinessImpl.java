package com.icomp.v01b09.b09s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b09.s001.ICOMPV01B09S001Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.Files;
import com.icomp.common.utils.UUIDgen;
import com.icomp.entity.base.*;
import com.icomp.v01b09.b09s001.business.B09S001Business;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具信息查询BUsiness实现类
 * @ClassName: B09S001BusinessImpl 
 * @author Taoyy
 * @date 2014-8-12 下午04:10:15
 */
public class B09S001BusinessImpl implements B09S001Business{

	/**
	 * 系统初始化Service
	 */
	private CommonService service;
	public void setService(CommonService service) {
		this.service = service;
	}
	
	private ICOMPV01B09S001Service iCOMPV01B09S001Service;
	public void setiCOMPV01B09S001Service(
			ICOMPV01B09S001Service iCOMPV01B09S001Service) {
		this.iCOMPV01B09S001Service = iCOMPV01B09S001Service;
	}
	/**
	 * 刀具参数列表
	 * @param param 区分定义名称
	 * @return
	 * @throws BusinessException
	 * toolcode模糊查询
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue)
			throws BusinessException {
		Vtool entity = new Vtool();
		entity.setToolCode(StringUtils.isEmpty(param.get("ToolCode").toString())?null:param.get("ToolCode").toString());
		entity.setToolName(StringUtils.isEmpty(param.get("ToolName").toString())?null:param.get("ToolName").toString());
		entity.setToolType(StringUtils.isEmpty(param.get("ToolType").toString())?null:param.get("ToolType").toString());
		entity.setToolSpecifications(StringUtils.isEmpty(param.get("ToolSpecifications").toString())?null:param.get("ToolSpecifications").toString());
		entity.setLibraryCodeID(StringUtils.isEmpty(param.get("LibraryCode").toString())?null:param.get("LibraryCode").toString());
		entity.setDelFlag(IConstant.DEL_FLAG_0);
		//entity.setDelFlag(IConstant.DEL_FLAG_0);
		// 分页起始行数
		entity.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
		// 分页页数
		entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
		// 排序
		entity.setOrderString("ToolCode");			
		Map<String, Object> rtn = iCOMPV01B09S001Service.getListToolcodeF(entity);
		if(rtn.size() > 1 && rtn.get("error") != null){
			  //检索错误时，返回
			  throw new BusinessException(((List<Vtool>)rtn.get("error")).get(0).getMessageCode(),  langCode, langValue);
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
	/**
	 *添加刀具参数
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolAdd(Map<String, Object>param,
			String savePath,String uploadFileName, File upload, String langValue, String userId,
			String langCode) throws BusinessException  {
		//用户输入验证
 		Map<String,Object> ret = iCOMPV01B09S001Service.checkInput(param,uploadFileName,langCode, langValue,userId,1);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Tool)ret.get("error")).getMessageCode(),langCode, langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Tool tool =(Tool) ret.get("data");
		tool.setToolID(UUIDgen.getId());

		try {
			if(!StringUtils.isEmpty(uploadFileName)){
			String fileType= uploadFileName.substring(uploadFileName.lastIndexOf(".")+1,uploadFileName.length());
				String fileType1 = uploadFileName.substring(uploadFileName.lastIndexOf(".")-1,uploadFileName.length());
				String a[] =uploadFileName.split("[.]");
				String fileName=a[0]+new Date().getTime()+"."+fileType;

			Files.fileUpload(savePath+"//b09s001//"+tool.getToolID(),fileName, upload);
			tool.setToolPic(fileName);
			}
		} catch (IOException e) {
			//上传文件失败
			throw new BusinessException(IConstant.WMSG0112,langCode, langValue);
		}
		//保存用户信息
		ret = iCOMPV01B09S001Service.toolAdd(tool,langCode,  langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //新建失败时，返回
			  throw new BusinessException(((Tool)ret.get("error")).getMessageCode(),langCode, langValue);
		}
		
		
		
		
		return ret;
		
	}
	/**
	 *刀具参数详细
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> toolInfo(Map<String, Object> param,
			String langCode, String langValue)throws BusinessException  {
		Map<String,Object> ret = new HashMap<String,Object>();
		String toolID = param.get("toolID").toString();
		//查询单个时需要version吗
		if (StringUtils.equals("edit", (String) param.get("opt"))){
			// 取得刀具参数
			Vtool entity = new Vtool();
			entity.setToolID(toolID);
			ret = iCOMPV01B09S001Service.getVtoolInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){
				  //检索错误时，返回
				  throw new BusinessException(((Vtool)ret.get("error")).getMessageCode(),langCode, langValue);
			}
		}
		else{
			//如果是查看
			Vtool entity = new Vtool();
			entity.setToolID(toolID);
			ret = iCOMPV01B09S001Service.getVtoolInfo(entity);
			if(ret.size() > 1 && ret.get("error") != null){//查询失败
				throw new BusinessException(((List<Vtool>)ret.get("error")).get(0).getMessageCode(),langCode, langValue);
			}
			
		}
		
		return ret;
	}
	
	/**
	 * 编辑刀具参数
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolEdit(Map<String, Object> param,
			String savePath,String uploadFileName, File upload, 
			String langValue, String customerID, String langCode) throws BusinessException {
		//用户输入验证
		Map<String,Object> ret = iCOMPV01B09S001Service.checkInput(param,uploadFileName,langCode,langValue,customerID,2);
		if(ret.size() > 1 && ret.get("error") != null){
			  throw new BusinessException(((Tool)ret.get("error")).getMessageCode(), langCode,langValue);
		}else if(ret.size() > 1 && ret.get("message") != null){
			return ret;
		}
		Tool tool =(Tool) ret.get("data");
		try {
			if(!StringUtils.isEmpty(uploadFileName)){
			String fileType= uploadFileName.substring(uploadFileName.lastIndexOf(".")+1,uploadFileName.length());
				String a[] =uploadFileName.split("[.]");
				String fileName=a[0]+new Date().getTime()+"."+fileType;
			Files.fileUpload(savePath+"//b09s001//"+tool.getToolID(),fileName, upload);
			tool.setToolPic(fileName);
			}
		}catch (IOException e) {
				//上传文件失败
				throw new BusinessException(IConstant.WMSG0112,langCode, langValue);
		}
		ret = iCOMPV01B09S001Service.toolEdit(tool,langCode,langValue);
		return ret;
		
	}

	
	/**
	 * 删除刀具参数信息
	 * @param param
	 * @param langValue
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toolDelete(Map<String, Object> param,
			String langValue, String userID, String langCode)
			throws BusinessException {
		
		Tool entity = new Tool();
		entity.setDelFlag(IConstant.DEL_FLAG_1);
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(userID);
		entity.setToolIDWhere(param.get("toolID").toString());
		entity.setVersion(new BigDecimal( param.get("version").toString()).add(BigDecimal.ONE));
		entity.setVersionWhere(new BigDecimal( param.get("version").toString()));
		entity.setUpdateTimeWhere(Ctl.strToDate(param.get("updatetime").toString().replace("T", " ")));
		entity.setUpdateUserWhere(param.get("updateuser").toString());
		Map<String,Object> ret = iCOMPV01B09S001Service.toolDelete(entity,langCode,  langValue);
		if(ret.size() > 1 && ret.get("error") != null){
			  //删除失败时，返回
			  throw new BusinessException(((Tool)ret.get("error")).getMessageCode(),langCode,langValue);
		}
		return ret;
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
		Map<String, Object> ret = service.getGridColmun(pageID,
				langCode,IConstant.ITEM_TYPE_1);
		if (ret.size() > 1 && ret.get("error") != null) {
			// 取得失败时，返回
			throw new BusinessException(((List<Displayeditemconfiguration>) ret
					.get("error")).get(0).getMessageCode(), langCode, langValue);
		}
		return ret;
	}
	/** (非 Javadoc) 
	* <p>Title: getVLibraryCodeList</p> 
	* <p>Description: </p> 
	* @param param
	* @param langValue
	* @return  
	*/ 
	
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue) throws BusinessException {
		List<Vlibrarycode> list = iCOMPV01B09S001Service.getVLibraryCodeList(param,langValue);
		return list;
	}
}
