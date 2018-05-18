package com.icomp.v01b09.b09s006.action;

import com.icomp.common.action.FileAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.UUIDgen;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.v01b09.b09s006.business.B09S006Business;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 初始化
 * @author cyn
 *
 */
public class B09S006Action extends FileAction {


	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 7255161566182210074L;
	
	private  B09S006Business b09s006Business;

	public void setB09s006Business(B09S006Business b09s006Business) {
		this.b09s006Business = b09s006Business;
	}

	public String initb09S006() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			// 参数
			Map<String, Object> param = super.param();
			if ("list".equals(param.get("opt"))) {
				// 待处理刀具信息查询列表
				Map<String, Object> list = this.b09s006Business.getList(param,langCode,langValue);
				super.ajaxReturn(list);
				return null;
			}else{
				super.assign("department","");
				//取得下拉列表列表
				Map<String,Object> list = this.b09s006Business.getOptimization(langCode, langValue);super.assign(
						"TooloptimizationList",list.get("TooloptimizationList"));
			}
			return SUCCESS;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B09S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B09S006", ((Customer) super
							.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String optimizationAdd() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();

			Map<String, Object> ret = this.b09s006Business.optimizationAdd(param, getUploadFileName(), getUpload(), langValue, ((Customer) super.session("Customer")).getCustomerID(), langCode);

			if (ret.get("message") != null && "-2".equals(ret.get("status").toString())) {
					super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
					return null;
				} else {
					super.ajaxReturn(ret);
				}

		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B09S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B09S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
		return null;
	}
	public String potimizationDel(){
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			//删除
			Map<String, Object> ret = this.b09s006Business.potimizationDel(param, langCode, ((Customer) super.session("Customer")).getCustomerID(), langValue);

			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			// 记录删除成功日志
			CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(), "displayItemDelete", IConstant.SYSTEM_LOG_FLAG_1,
					IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer")).getCustomerID(), ret.get("message").toString());
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/displayItemDelete.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "displayItemDelete",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	public String optimizationInfo() {
		try {
			// 语言实体类
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			//参数
			Map<String, Object> param = super.param();
			//申请信息列表
			Map<String, Object> ret = this.b09s006Business.optimizationInfo(param, langCode, langValue );
				super.ajaxReturn(ret);
			return  null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/B09S006.action", IConstant.RESULT_CODE_1, ex,
					this.getClass().getName(), "B09S006", ((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}
	public String optimizationEdit() {
		try {
			String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
			String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
			Map<String, Object> param = super.param();
			Map<String, Object> ret = this.b09s006Business.optimizationEdit(param, getUploadFileName(), getUpload(),langCode, ((Customer) super.session("Customer")).getCustomerID(),
					langValue);

			if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
				super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
				return null;
			} else {
				super.ajaxReturn(ret);
			}
			return null;
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(getResponse(),
					"/printItemEdit.action", IConstant.RESULT_CODE_1, ex, this
							.getClass().getName(), "printItemEdit",
					((Customer) super.session("Customer")).getCustomerID());
			return null;
		}
	}

	private List<File> upload;
	private List<String> uploadContentType;
	private List<String> uploadFileName;
	private String result;
 	private  String filename;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private File upload1;
	private File upload2;
	private File upload3;
	private File upload4;

	public File getUpload1() {
		return upload1;
	}

	public void setUpload1(File upload1) {
		this.upload1 = upload1;
	}

	public File getUpload2() {
		return upload2;
	}

	public void setUpload2(File upload2) {
		this.upload2 = upload2;
	}

	public File getUpload3() {
		return upload3;
	}

	public void setUpload3(File upload3) {
		this.upload3 = upload3;
	}

	public File getUpload4() {
		return upload4;
	}

	public void setUpload4(File upload4) {
		this.upload4 = upload4;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<File> getUpload() {
		List<File> uploads = new ArrayList<File>();
		String path = ServletActionContext.getServletContext().getRealPath("/yaguxinxi.tmp");
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (null==upload1){

			uploads.add(file);
			upload1=null;
		}else {
			System.out.println(upload1);
			uploads.add(upload1);
			upload1=null;
		}
		if (null==upload2){
			uploads.add(file);
			upload2=null;
		}else {
			uploads.add(upload2);
			upload2=null;
		}
		if (null==upload3){
			uploads.add(file);
			upload3=null;
		}else {
			uploads.add(upload3);
			upload3=null;
		}
		if (null==upload4){
			uploads.add(file);
			upload4=null;
		}else {
			uploads.add(upload4);
			upload4=null;
		}

		return uploads;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {

		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		List<String > upName =new ArrayList<String>();

			if ("name1".equals(name1)||"".equals(name1)){
				upName.add(UUIDgen.getId()+"name1");
				name1=null;
			}else {
					upName.add(UUIDgen.getId()+"name1"+name1);
				name1=null;
			}
			if ("name2".equals(name2)||"".equals(name2)){
				upName.add(UUIDgen.getId()+"name2");
				name2=null;
			}else {
				upName.add(UUIDgen.getId()+"name2"+name2);
				name2=null;
			}
			if ("name3".equals(name3)||"".equals(name3)){
				upName.add(UUIDgen.getId()+"name3");
				name3=null;
			}else {
				upName.add(UUIDgen.getId()+"name3"+name3);
				name3=null;
			}
			if ("name4".equals(name4)||"".equals(name4)){
				upName.add(UUIDgen.getId()+"name4");
				name4=null;
			}else {
				upName.add(UUIDgen.getId()+"name4"+name4);
				name4=null;
			}

			return upName;



	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}

