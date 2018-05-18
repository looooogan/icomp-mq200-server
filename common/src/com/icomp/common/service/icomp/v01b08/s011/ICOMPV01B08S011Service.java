package com.icomp.common.service.icomp.v01b08.s011;

import java.util.List;
import java.util.Map;

import com.icomp.entity.base.Stack;
import com.icomp.entity.base.Vlibrarycode;
import com.icomp.entity.base.Vstack;


/**
 * 用户登录Service
 * @author yzq
 *
 */
public interface ICOMPV01B08S011Service {

	public Map<String, Object> getList(Vstack entity);

	public Map<String, Object> stackDelete(Stack stack, String langCode,String langValue);

	public Map<String, Object> stackAdd(Stack stack, String langCode,String langValue);

	public Map<String, Object> stackEdit(Stack stack, String langCode,String langValue);

	public Map<String, Object> getStackInfo(Vstack entity);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode, String langValue, String customerID, int i);

	
	public List<Vlibrarycode> getVLibraryCodeList(Map<String, Object> param,
			String langValue);


}
