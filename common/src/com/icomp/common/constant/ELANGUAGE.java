package com.icomp.common.constant;

/**
 * 语言种类枚举
 * 
 * @author yzq
 * 
 */
public enum ELANGUAGE {
	ZHCN("zh_CN"), ENUS("en_US"), JP("ja");
	String value;

	private ELANGUAGE(String value) {
		this.value = value;
	}

	public static String getValue(int input) {
		switch (input) {
		case 0:
			return ZHCN.value;
		case 1:
			return ENUS.value;
		case 2:
			return JP.value;
		default:
			return null;
		}
	}

}
