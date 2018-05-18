package com.icomp.common.service.icomp.v01b08.s003;

import java.util.Map;

import com.icomp.entity.base.Languagetable;


/**
 * 国际化需求配置Service
 * @author lcc
 *
 */
public interface ICOMPV01B08S003Service {

	/**
	 * 取得国际化需求列表
	 * @param param 页面检索条件
	 */
	public Map<String,Object> getList(Languagetable entity);
	
    /**
     * 删除国际化需求信息
     * @param languagetable 页面检索条件
     * @param lang          语言
     * @param langValue 
     * @return
     */
	public Map<String, Object> languageTableDelete(Languagetable languagetable,
			String langCode, String langValue);

	public Map<String, Object> checkInput(Map<String, Object> param,
			String langCode,String langValue, String customerID, int i);

	public Map<String, Object> languageAdd(Languagetable language, String langCode, String langValue);

	public Map<String, Object> getlanguageInfo(Languagetable entity);

	public Map<String, Object> languageEdit(Languagetable languagetable,
			String langCode, String langValue);
    /**
     * 启用国际化需求信息
     * @param languagetable 页面检索条件
     * @param lang          语言
     * @param langValue 
     * @return
     */
	public Map<String, Object> languageStartUse(Languagetable languagetable,
			String langCode, String langValue);
	
}