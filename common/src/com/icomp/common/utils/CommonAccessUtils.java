package com.icomp.common.utils;

import com.icomp.common.constant.IConstant;
import com.icomp.dao.VgrantlistDao;
import com.icomp.entity.base.Vgrantlist;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * 系统权限验证类
 * @author yzq
 *
 */
public class CommonAccessUtils {

	/**
	 * 管理平台用户功能权限验证
	 * @param userName 用户名
	 * @param action 当前action名
	 * @param lang 语言编码
	 * @return
	 */
	public static boolean CapabilityAccess(String userName,String action,String lang){
		//如果用户名为空,则返回false
		if(StringUtils.isEmpty (userName)){
			return false;
		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icomp/config/configdao.xml");
		VgrantlistDao dao = (VgrantlistDao) ctx.getBean("vgrantlistDao");
		//取得用户和url对应的数据行数
		Vgrantlist serachParam = new Vgrantlist();//设置权限列表查询条件
		serachParam.setPositionLanguageCode(lang);
		serachParam.setPositionDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setSystemLanguageCode(lang);
		serachParam.setSystemDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setCapabilityLanguageCode(lang);
		serachParam.setCapabilityDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setAgencyLanguageCode(lang);
		serachParam.setAgencyDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setDepartmentLanguageCode(lang);
		serachParam.setDepartmentDelFlag(IConstant.DEL_FLAG_0);
		serachParam.setBelongFlag(IConstant.BELONG_FLAG_0);
		serachParam.setUserName(userName);
		serachParam.setCapabilityUrl(action + ".action");
		try {
			int count = dao.searchByCount(serachParam);
			if(count <= 0){
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
}
