package com.icomp.common.service.icomp.v01b08.s008;

import java.util.Map;

import com.icomp.entity.base.Process;
import com.icomp.entity.base.Vprocess;


/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S008Service {

	public Map<String, Object> getList(Vprocess entity);

	public Map<String, Object> processDelete(Process process, String langCode,String langValue);

	public Map<String, Object> processtAdd(Process process, String langCode,String langValue);

	public Map<String, Object> processtEdit(Process process, String langCode,String langValue);

	public Map<String, Object> getProcessInfo(Process entity);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int i);

}
