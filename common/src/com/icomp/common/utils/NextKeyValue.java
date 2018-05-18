package com.icomp.common.utils;


import com.icomp.common.exception.BusinessException;
import com.icomp.dao.NextkeyvalueDao;
import com.icomp.entity.base.Nextkeyvalue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
public class NextKeyValue {

	/**
	 * 主键采番
	 * @param
	 * @param userID
	 * @return
	 */
	public static String getNextkeyvalue(String tableName,String colName,String userID) {
		return UUIDgen.getId();
	}

	private static NextkeyvalueDao nextkeyvalueDao;

	public void setNextkeyvalueDao(NextkeyvalueDao nextkeyvalueDao) {
		this.nextkeyvalueDao = nextkeyvalueDao;
	}

	@SuppressWarnings("unchecked")
	public static String getNextkeyvalueNo(String tableName,String colName,String userID) {
		String key = "";
		try {
			Nextkeyvalue entity = new Nextkeyvalue();
			entity.setTableName(tableName);
			entity.setColName(colName);
			List<Nextkeyvalue> list =(List<Nextkeyvalue>) nextkeyvalueDao.searchByList(entity);
			if(list!= null && !list.isEmpty()){
				Nextkeyvalue temp = list.get(0);
				temp.setOldkeyValue(temp.getNextKeyValue());
				key = temp.getNextKeyValue();
				temp.setNextKeyValue(new BigDecimal(key).add(BigDecimal.ONE).toString());
				temp.setNextKeyValueIDWhere(temp.getNextKeyValueID());
				temp.setUpdateUser(userID);
				temp.setUpdateTime(new Date());
				temp.setVersion(temp.getVersion().add(new BigDecimal(1)));
				nextkeyvalueDao.updateNonQuery(temp);
			}
		} catch (SQLException e) {
			throw new BusinessException("", "","");
		}
		return key;
	}
	
	
	/**
	 * 主键取得
	 * @param tableName
	 * @param colName
	 * @return
	 */
	public static String getkeyvalue(String tableName,String colName) {
    /*	try {
     String   key = null;
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/icomp/config/configdao.xml");
			NextkeyvalueDao nextkeyvalueDao = (NextkeyvalueDao) ctx.getBean("nextkeyvalueDao");
			Nextkeyvalue entity = new Nextkeyvalue();
			entity.setTableName(tableName);
			entity.setColName(colName);
			List<Nextkeyvalue> list =(List<Nextkeyvalue>) nextkeyvalueDao.searchByList(entity);
			if(list!= null && !list.isEmpty()){
				Nextkeyvalue temp = list.get(0);
				key = temp.getOldkeyValue();
			}
		} catch (SQLException e) {
			throw new BusinessException("", "","");// 主键生成方法 消息未确定
		}*/
		return UUIDgen.getId();
	}
	/**
	 * 主键取得
	 * @param tableName
	 * @param userID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getkeyvalueNO(String tableName,String colName,String userID) {
		String   key = null;
			try {

			Nextkeyvalue entity = new Nextkeyvalue();
			entity.setTableName(tableName);
			entity.setColName(colName);
			List<Nextkeyvalue> list =(List<Nextkeyvalue>) nextkeyvalueDao.searchByList(entity);
			if(list!= null && !list.isEmpty()){
				Nextkeyvalue temp = list.get(0);
				key = temp.getOldkeyValue();
				
				temp.setOldkeyValue(temp.getNextKeyValue());
				key = temp.getNextKeyValue();
				temp.setNextKeyValue(new BigDecimal(key).add(BigDecimal.ONE).toString());
				temp.setNextKeyValueIDWhere(temp.getNextKeyValueID());
				temp.setUpdateUser(userID);
				temp.setUpdateTime(new Date());
				temp.setVersion(temp.getVersion().add(new BigDecimal(1)));
				nextkeyvalueDao.updateNonQuery(temp);
				
			}
		} catch (SQLException e) {
			throw new BusinessException("", "","");// 主键生成方法 消息未确定
		}
		return key;
	}
}
