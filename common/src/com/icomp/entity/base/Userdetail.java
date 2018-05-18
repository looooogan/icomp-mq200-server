/*
 * 工具自动生成：用户明细实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 用户明细实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Userdetail extends UserdetailWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户明细ID	*/ 
	private String userDetailID;

	/**
	 * 用户明细ID取得
	 * @return userDetailID
	 */
	public String getUserDetailID() {
		return userDetailID;
	}

	/**
	 * 用户明细ID设定
	 * @param userDetailID
	 */
	public void setUserDetailID(String userDetailID) {
		this.userDetailID = userDetailID;
	}

	/* 用户ID[自动生成20位字符串]	*/ 
	private String customerID;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/* 姓名	*/ 
	private String userName;

	/**
	 * 姓名取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 姓名设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* 性别(F:女M:男H:不详)	*/ 
	private String userSex;

	/**
	 * 性别(F:女M:男H:不详)取得
	 * @return userSex
	 */
	public String getUserSex() {
		return userSex;
	}

	/**
	 * 性别(F:女M:男H:不详)设定
	 * @param userSex
	 */
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	/* 年龄	*/ 
	private BigDecimal userAge;

	/**
	 * 年龄取得
	 * @return userAge
	 */
	public BigDecimal getUserAge() {
		return userAge;
	}

	/**
	 * 年龄设定
	 * @param userAge
	 */
	public void setUserAge(BigDecimal userAge) {
		this.userAge = userAge;
	}

	/* 生年月日	*/ 
	private String userBirthday;

	/**
	 * 生年月日取得
	 * @return userBirthday
	 */
	public String getUserBirthday() {
		return userBirthday;
	}

	/**
	 * 生年月日设定
	 * @param userBirthday
	 */
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	/* 身份证号	*/ 
	private String userCardID;

	/**
	 * 身份证号取得
	 * @return userCardID
	 */
	public String getUserCardID() {
		return userCardID;
	}

	/**
	 * 身份证号设定
	 * @param userCardID
	 */
	public void setUserCardID(String userCardID) {
		this.userCardID = userCardID;
	}

	/* 移动电话	*/ 
	private String userMobile;

	/**
	 * 移动电话取得
	 * @return userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * 移动电话设定
	 * @param userMobile
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/* 座机(XXXX-XXXXXXXX)	*/ 
	private String userLandline;

	/**
	 * 座机(XXXX-XXXXXXXX)取得
	 * @return userLandline
	 */
	public String getUserLandline() {
		return userLandline;
	}

	/**
	 * 座机(XXXX-XXXXXXXX)设定
	 * @param userLandline
	 */
	public void setUserLandline(String userLandline) {
		this.userLandline = userLandline;
	}

	/* 婚否(0已婚1未婚9不详)	*/ 
	private String userPrivacies;

	/**
	 * 婚否(0已婚1未婚9不详)取得
	 * @return userPrivacies
	 */
	public String getUserPrivacies() {
		return userPrivacies;
	}

	/**
	 * 婚否(0已婚1未婚9不详)设定
	 * @param userPrivacies
	 */
	public void setUserPrivacies(String userPrivacies) {
		this.userPrivacies = userPrivacies;
	}

	/* 毕业院校	*/ 
	private String userUniversity;

	/**
	 * 毕业院校取得
	 * @return userUniversity
	 */
	public String getUserUniversity() {
		return userUniversity;
	}

	/**
	 * 毕业院校设定
	 * @param userUniversity
	 */
	public void setUserUniversity(String userUniversity) {
		this.userUniversity = userUniversity;
	}

	/* 专业	*/ 
	private String userProfessional;

	/**
	 * 专业取得
	 * @return userProfessional
	 */
	public String getUserProfessional() {
		return userProfessional;
	}

	/**
	 * 专业设定
	 * @param userProfessional
	 */
	public void setUserProfessional(String userProfessional) {
		this.userProfessional = userProfessional;
	}

	/* 学历	*/ 
	private String userEducation;

	/**
	 * 学历取得
	 * @return userEducation
	 */
	public String getUserEducation() {
		return userEducation;
	}

	/**
	 * 学历设定
	 * @param userEducation
	 */
	public void setUserEducation(String userEducation) {
		this.userEducation = userEducation;
	}

	/* 血型(0:A1:B2:AB3:O9:不详)	*/ 
	private String userBloodGroup;

	/**
	 * 血型(0:A1:B2:AB3:O9:不详)取得
	 * @return userBloodGroup
	 */
	public String getUserBloodGroup() {
		return userBloodGroup;
	}

	/**
	 * 血型(0:A1:B2:AB3:O9:不详)设定
	 * @param userBloodGroup
	 */
	public void setUserBloodGroup(String userBloodGroup) {
		this.userBloodGroup = userBloodGroup;
	}

	/* 身高(cm)	*/ 
	private BigDecimal userHeight;

	/**
	 * 身高(cm)取得
	 * @return userHeight
	 */
	public BigDecimal getUserHeight() {
		return userHeight;
	}

	/**
	 * 身高(cm)设定
	 * @param userHeight
	 */
	public void setUserHeight(BigDecimal userHeight) {
		this.userHeight = userHeight;
	}

	/* 体重(kg)	*/ 
	private BigDecimal userWeight;

	/**
	 * 体重(kg)取得
	 * @return userWeight
	 */
	public BigDecimal getUserWeight() {
		return userWeight;
	}

	/**
	 * 体重(kg)设定
	 * @param userWeight
	 */
	public void setUserWeight(BigDecimal userWeight) {
		this.userWeight = userWeight;
	}
}

