/*
 * 工具自动生成：用户明细条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;


/**
 * 用户明细条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class UserdetailWhere extends BaseEntity implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 用户明细ID	*/ 
	private String userDetailIDWhere;

	/**
	 * 用户明细ID取得
	 * @return userDetailIDWhere
	 */
	public String getUserDetailIDWhere () {
		return userDetailIDWhere;
	}

	/**
	 * 用户明细ID设定
	 * @param userDetailIDWhere
	 */
	public void setUserDetailIDWhere (String userDetailIDWhere) {
		this.userDetailIDWhere = userDetailIDWhere;
	}

	/* 用户ID[自动生成20位字符串]	*/ 
	private String customerIDWhere;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return customerIDWhere
	 */
	public String getCustomerIDWhere () {
		return customerIDWhere;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param customerIDWhere
	 */
	public void setCustomerIDWhere (String customerIDWhere) {
		this.customerIDWhere = customerIDWhere;
	}

	/* 姓名	*/ 
	private String userNameWhere;

	/**
	 * 姓名取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 姓名设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}

	/* 性别(F:女M:男H:不详)	*/ 
	private String userSexWhere;

	/**
	 * 性别(F:女M:男H:不详)取得
	 * @return userSexWhere
	 */
	public String getUserSexWhere () {
		return userSexWhere;
	}

	/**
	 * 性别(F:女M:男H:不详)设定
	 * @param userSexWhere
	 */
	public void setUserSexWhere (String userSexWhere) {
		this.userSexWhere = userSexWhere;
	}

	/* 年龄	*/ 
	private BigDecimal userAgeWhere;

	/**
	 * 年龄取得
	 * @return userAgeWhere
	 */
	public BigDecimal getUserAgeWhere () {
		return userAgeWhere;
	}

	/**
	 * 年龄设定
	 * @param userAgeWhere
	 */
	public void setUserAgeWhere (BigDecimal userAgeWhere) {
		this.userAgeWhere = userAgeWhere;
	}

	/* 生年月日	*/ 
	private String userBirthdayWhere;

	/**
	 * 生年月日取得
	 * @return userBirthdayWhere
	 */
	public String getUserBirthdayWhere () {
		return userBirthdayWhere;
	}

	/**
	 * 生年月日设定
	 * @param userBirthdayWhere
	 */
	public void setUserBirthdayWhere (String userBirthdayWhere) {
		this.userBirthdayWhere = userBirthdayWhere;
	}

	/* 身份证号	*/ 
	private String userCardIDWhere;

	/**
	 * 身份证号取得
	 * @return userCardIDWhere
	 */
	public String getUserCardIDWhere () {
		return userCardIDWhere;
	}

	/**
	 * 身份证号设定
	 * @param userCardIDWhere
	 */
	public void setUserCardIDWhere (String userCardIDWhere) {
		this.userCardIDWhere = userCardIDWhere;
	}

	/* 移动电话	*/ 
	private String userMobileWhere;

	/**
	 * 移动电话取得
	 * @return userMobileWhere
	 */
	public String getUserMobileWhere () {
		return userMobileWhere;
	}

	/**
	 * 移动电话设定
	 * @param userMobileWhere
	 */
	public void setUserMobileWhere (String userMobileWhere) {
		this.userMobileWhere = userMobileWhere;
	}

	/* 座机(XXXX-XXXXXXXX)	*/ 
	private String userLandlineWhere;

	/**
	 * 座机(XXXX-XXXXXXXX)取得
	 * @return userLandlineWhere
	 */
	public String getUserLandlineWhere () {
		return userLandlineWhere;
	}

	/**
	 * 座机(XXXX-XXXXXXXX)设定
	 * @param userLandlineWhere
	 */
	public void setUserLandlineWhere (String userLandlineWhere) {
		this.userLandlineWhere = userLandlineWhere;
	}

	/* 婚否(0已婚1未婚9不详)	*/ 
	private String userPrivaciesWhere;

	/**
	 * 婚否(0已婚1未婚9不详)取得
	 * @return userPrivaciesWhere
	 */
	public String getUserPrivaciesWhere () {
		return userPrivaciesWhere;
	}

	/**
	 * 婚否(0已婚1未婚9不详)设定
	 * @param userPrivaciesWhere
	 */
	public void setUserPrivaciesWhere (String userPrivaciesWhere) {
		this.userPrivaciesWhere = userPrivaciesWhere;
	}

	/* 毕业院校	*/ 
	private String userUniversityWhere;

	/**
	 * 毕业院校取得
	 * @return userUniversityWhere
	 */
	public String getUserUniversityWhere () {
		return userUniversityWhere;
	}

	/**
	 * 毕业院校设定
	 * @param userUniversityWhere
	 */
	public void setUserUniversityWhere (String userUniversityWhere) {
		this.userUniversityWhere = userUniversityWhere;
	}

	/* 专业	*/ 
	private String userProfessionalWhere;

	/**
	 * 专业取得
	 * @return userProfessionalWhere
	 */
	public String getUserProfessionalWhere () {
		return userProfessionalWhere;
	}

	/**
	 * 专业设定
	 * @param userProfessionalWhere
	 */
	public void setUserProfessionalWhere (String userProfessionalWhere) {
		this.userProfessionalWhere = userProfessionalWhere;
	}

	/* 学历	*/ 
	private String userEducationWhere;

	/**
	 * 学历取得
	 * @return userEducationWhere
	 */
	public String getUserEducationWhere () {
		return userEducationWhere;
	}

	/**
	 * 学历设定
	 * @param userEducationWhere
	 */
	public void setUserEducationWhere (String userEducationWhere) {
		this.userEducationWhere = userEducationWhere;
	}

	/* 血型(0:A1:B2:AB3:O9:不详)	*/ 
	private String userBloodGroupWhere;

	/**
	 * 血型(0:A1:B2:AB3:O9:不详)取得
	 * @return userBloodGroupWhere
	 */
	public String getUserBloodGroupWhere () {
		return userBloodGroupWhere;
	}

	/**
	 * 血型(0:A1:B2:AB3:O9:不详)设定
	 * @param userBloodGroupWhere
	 */
	public void setUserBloodGroupWhere (String userBloodGroupWhere) {
		this.userBloodGroupWhere = userBloodGroupWhere;
	}

	/* 身高(cm)	*/ 
	private BigDecimal userHeightWhere;

	/**
	 * 身高(cm)取得
	 * @return userHeightWhere
	 */
	public BigDecimal getUserHeightWhere () {
		return userHeightWhere;
	}

	/**
	 * 身高(cm)设定
	 * @param userHeightWhere
	 */
	public void setUserHeightWhere (BigDecimal userHeightWhere) {
		this.userHeightWhere = userHeightWhere;
	}

	/* 体重(kg)	*/ 
	private BigDecimal userWeightWhere;

	/**
	 * 体重(kg)取得
	 * @return userWeightWhere
	 */
	public BigDecimal getUserWeightWhere () {
		return userWeightWhere;
	}

	/**
	 * 体重(kg)设定
	 * @param userWeightWhere
	 */
	public void setUserWeightWhere (BigDecimal userWeightWhere) {
		this.userWeightWhere = userWeightWhere;
	}
}

