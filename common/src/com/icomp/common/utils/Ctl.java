package com.icomp.common.utils;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Ctl {
	
	/**
	 * 获取时间戳
	 * @return
	 */
	public static String time(){
		Long time = new Date().getTime();
		return time.toString();
	}
	
	/**
	 * 将Map键值对拷贝到对象对应属性
	 * 
	 * @param obj
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	public static void populate(Object obj, Map map) {
		try {
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		String resultString = null;
		StringBuffer buf = new StringBuffer("");
		if(str == null)
			return str;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// resultString = buf.toString(); //32位
			resultString = buf.toString().substring(8, 24); // 16位
			return resultString;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	/**
	 * 密码加密
	 * 
	 * @param pass
	 * @return
	 */
	public static String passenc(String pass) {
		String encryption = md5(pass);
		return encryption;
	}

	/**
	 * List 去重复
	 * 
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public static void removeDuplicate(List list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
	}

	public static Date strToDate(String date) {
		Date result = null;
		String parse = date;
		parse = parse.replaceFirst("^[0-9]{4}([^0-9]?)", "yyyy$1");
		parse = parse.replaceFirst("^[0-9]{2}([^0-9]?)", "yy$1");
		parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1MM$2");
		parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}( ?)", "$1dd$2");
		parse = parse.replaceFirst("( )[0-9]{1,2}([^0-9]?)", "$1HH$2");
		parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1mm$2");
		parse = parse.replaceFirst("([^0-9]?)[0-9]{1,2}([^0-9]?)", "$1ss$2");
		DateFormat format = new SimpleDateFormat(parse);
		try {
			result = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String dateFormat(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static String dateFormat(Date date) {
		return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getTime(String cc) {
		return Ctl.dateFormat(new Date(Long.parseLong(cc)));
	}
	
	/**
	 * 判断字符串是否满足类型要求
	 * falg = 0：是否为数字
	 *        1：是否为字母
	 *        2：是否为数字、字母
	 *        3：是否为数字、字母、下划线
	 *        4: 是否为字母开头
	 * @param flag
	 * @param str
	 * @return true:满足；false:不满足
	 */
	public static boolean checkString(int flag,String str){
		switch(flag){
			case 0: //是否为数字
				 if(StringUtils.isNumeric(str)){
					 return true;
				 }
				 break;
			case 1: //是否为字母
				 if(StringUtils.isAlpha(str)){
					 return true;
				 }
				 break;
			case 2: //是否为数字、字母
		          for(int i=0 ; i<str.length() ; i++){ //循环遍历字符串   
		              if(!(Character.isDigit(str.charAt(i)) || Character.isLetter(str.charAt(i)))){     //用char包装类中的判断数字的方法判断每一个字符
		            	  return false;
		              }
		          }
		          return true;
			case 3: //是否为数字、字母、下划线
				for(int i=0 ; i<str.length() ; i++){ //循环遍历字符串   
		              if(!(Character.isDigit(str.charAt(i)) || Character.isLetter(str.charAt(i)) || StringUtils.equals(String.valueOf(str.charAt(i)),"_"))){     //用char包装类中的判断数字的方法判断每一个字符
		            	  return false;
		              }
		          }
		          return true;
			case 4: //是否为字母开头
				if(StringUtils.isAlpha(str.substring(0,1))){
					return true;
				}
				break;
		    default:
		    	break;
		}
		return false;
		
	}

}
