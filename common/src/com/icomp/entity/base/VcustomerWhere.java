/*
 * 工具自动生成：VIEW条件实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import com.icomp.common.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW条件实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class VcustomerWhere extends BaseEntity implements Serializable {

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
	private String userdetailCustomerIDWhere;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return userdetailCustomerIDWhere
	 */
	public String getUserdetailCustomerIDWhere () {
		return userdetailCustomerIDWhere;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param userdetailCustomerIDWhere
	 */
	public void setUserdetailCustomerIDWhere (String userdetailCustomerIDWhere) {
		this.userdetailCustomerIDWhere = userdetailCustomerIDWhere;
	}

	/* 姓名	*/ 
	private String userdetailUserNameWhere;

	/**
	 * 姓名取得
	 * @return userdetailUserNameWhere
	 */
	public String getUserdetailUserNameWhere () {
		return userdetailUserNameWhere;
	}

	/**
	 * 姓名设定
	 * @param userdetailUserNameWhere
	 */
	public void setUserdetailUserNameWhere (String userdetailUserNameWhere) {
		this.userdetailUserNameWhere = userdetailUserNameWhere;
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

	/* 删除区分(0有效1删除)	*/ 
	private String userdetailDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return userdetailDelFlagWhere
	 */
	public String getUserdetailDelFlagWhere () {
		return userdetailDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param userdetailDelFlagWhere
	 */
	public void setUserdetailDelFlagWhere (String userdetailDelFlagWhere) {
		this.userdetailDelFlagWhere = userdetailDelFlagWhere;
	}

	/* 创建者	*/ 
	private String userdetailCreateUserWhere;

	/**
	 * 创建者取得
	 * @return userdetailCreateUserWhere
	 */
	public String getUserdetailCreateUserWhere () {
		return userdetailCreateUserWhere;
	}

	/**
	 * 创建者设定
	 * @param userdetailCreateUserWhere
	 */
	public void setUserdetailCreateUserWhere (String userdetailCreateUserWhere) {
		this.userdetailCreateUserWhere = userdetailCreateUserWhere;
	}

	/* 创建时间	*/ 
	private Date userdetailCreateTimeWhere;

	/**
	 * 创建时间取得
	 * @return userdetailCreateTimeWhere
	 */
	public Date getUserdetailCreateTimeWhere () {
		return userdetailCreateTimeWhere;
	}

	/**
	 * 创建时间设定
	 * @param userdetailCreateTimeWhere
	 */
	public void setUserdetailCreateTimeWhere (Date userdetailCreateTimeWhere) {
		this.userdetailCreateTimeWhere = userdetailCreateTimeWhere;
	}

	/* 更新者	*/ 
	private String userdetailUpdateUserWhere;

	/**
	 * 更新者取得
	 * @return userdetailUpdateUserWhere
	 */
	public String getUserdetailUpdateUserWhere () {
		return userdetailUpdateUserWhere;
	}

	/**
	 * 更新者设定
	 * @param userdetailUpdateUserWhere
	 */
	public void setUserdetailUpdateUserWhere (String userdetailUpdateUserWhere) {
		this.userdetailUpdateUserWhere = userdetailUpdateUserWhere;
	}

	/* 更新时间	*/ 
	private Date userdetailUpdateTimeWhere;

	/**
	 * 更新时间取得
	 * @return userdetailUpdateTimeWhere
	 */
	public Date getUserdetailUpdateTimeWhere () {
		return userdetailUpdateTimeWhere;
	}

	/**
	 * 更新时间设定
	 * @param userdetailUpdateTimeWhere
	 */
	public void setUserdetailUpdateTimeWhere (Date userdetailUpdateTimeWhere) {
		this.userdetailUpdateTimeWhere = userdetailUpdateTimeWhere;
	}

	/* 版本号	*/ 
	private BigDecimal userdetailVersionWhere;

	/**
	 * 版本号取得
	 * @return userdetailVersionWhere
	 */
	public BigDecimal getUserdetailVersionWhere () {
		return userdetailVersionWhere;
	}

	/**
	 * 版本号设定
	 * @param userdetailVersionWhere
	 */
	public void setUserdetailVersionWhere (BigDecimal userdetailVersionWhere) {
		this.userdetailVersionWhere = userdetailVersionWhere;
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

	/* 职务ID	*/ 
	private String customerPositionIDWhere;

	/**
	 * 职务ID取得
	 * @return customerPositionIDWhere
	 */
	public String getCustomerPositionIDWhere () {
		return customerPositionIDWhere;
	}

	/**
	 * 职务ID设定
	 * @param customerPositionIDWhere
	 */
	public void setCustomerPositionIDWhere (String customerPositionIDWhere) {
		this.customerPositionIDWhere = customerPositionIDWhere;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String userNameWhere;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userNameWhere
	 */
	public String getUserNameWhere () {
		return userNameWhere;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userNameWhere
	 */
	public void setUserNameWhere (String userNameWhere) {
		this.userNameWhere = userNameWhere;
	}

	/* 用户密码[16位数字字母组合]	*/ 
	private String userPassWhere;

	/**
	 * 用户密码[16位数字字母组合]取得
	 * @return userPassWhere
	 */
	public String getUserPassWhere () {
		return userPassWhere;
	}

	/**
	 * 用户密码[16位数字字母组合]设定
	 * @param userPassWhere
	 */
	public void setUserPassWhere (String userPassWhere) {
		this.userPassWhere = userPassWhere;
	}

	/* 员工卡号[20位员工卡]	*/ 
	private String employeeCardWhere;

	/**
	 * 员工卡号[20位员工卡]取得
	 * @return employeeCardWhere
	 */
	public String getEmployeeCardWhere () {
		return employeeCardWhere;
	}

	/**
	 * 员工卡号[20位员工卡]设定
	 * @param employeeCardWhere
	 */
	public void setEmployeeCardWhere (String employeeCardWhere) {
		this.employeeCardWhere = employeeCardWhere;
	}

	/* 用户类型(0系统用户1普通用户)	*/ 
	private String userTypeWhere;

	/**
	 * 用户类型(0系统用户1普通用户)取得
	 * @return userTypeWhere
	 */
	public String getUserTypeWhere () {
		return userTypeWhere;
	}

	/**
	 * 用户类型(0系统用户1普通用户)设定
	 * @param userTypeWhere
	 */
	public void setUserTypeWhere (String userTypeWhere) {
		this.userTypeWhere = userTypeWhere;
	}

	/* 用户锁定区分(0正常1锁定)	*/ 
	private String userErrFlagWhere;

	/**
	 * 用户锁定区分(0正常1锁定)取得
	 * @return userErrFlagWhere
	 */
	public String getUserErrFlagWhere () {
		return userErrFlagWhere;
	}

	/**
	 * 用户锁定区分(0正常1锁定)设定
	 * @param userErrFlagWhere
	 */
	public void setUserErrFlagWhere (String userErrFlagWhere) {
		this.userErrFlagWhere = userErrFlagWhere;
	}

	/* 错误次数	*/ 
	private BigDecimal errCountWhere;

	/**
	 * 错误次数取得
	 * @return errCountWhere
	 */
	public BigDecimal getErrCountWhere () {
		return errCountWhere;
	}

	/**
	 * 错误次数设定
	 * @param errCountWhere
	 */
	public void setErrCountWhere (BigDecimal errCountWhere) {
		this.errCountWhere = errCountWhere;
	}

	/* 锁定开始时间	*/ 
	private Date errStaTimeWhere;

	/**
	 * 锁定开始时间取得
	 * @return errStaTimeWhere
	 */
	public Date getErrStaTimeWhere () {
		return errStaTimeWhere;
	}

	/**
	 * 锁定开始时间设定
	 * @param errStaTimeWhere
	 */
	public void setErrStaTimeWhere (Date errStaTimeWhere) {
		this.errStaTimeWhere = errStaTimeWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String customerDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return customerDelFlagWhere
	 */
	public String getCustomerDelFlagWhere () {
		return customerDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param customerDelFlagWhere
	 */
	public void setCustomerDelFlagWhere (String customerDelFlagWhere) {
		this.customerDelFlagWhere = customerDelFlagWhere;
	}

	/* 更新时间	*/ 
	private Date customerUpdateTimeWhere;

	/**
	 * 更新时间取得
	 * @return customerUpdateTimeWhere
	 */
	public Date getCustomerUpdateTimeWhere () {
		return customerUpdateTimeWhere;
	}

	/**
	 * 更新时间设定
	 * @param customerUpdateTimeWhere
	 */
	public void setCustomerUpdateTimeWhere (Date customerUpdateTimeWhere) {
		this.customerUpdateTimeWhere = customerUpdateTimeWhere;
	}

	/* 更新者	*/ 
	private String customerUpdateUserWhere;

	/**
	 * 更新者取得
	 * @return customerUpdateUserWhere
	 */
	public String getCustomerUpdateUserWhere () {
		return customerUpdateUserWhere;
	}

	/**
	 * 更新者设定
	 * @param customerUpdateUserWhere
	 */
	public void setCustomerUpdateUserWhere (String customerUpdateUserWhere) {
		this.customerUpdateUserWhere = customerUpdateUserWhere;
	}

	/* 创建时间	*/ 
	private Date customerCreateTimeWhere;

	/**
	 * 创建时间取得
	 * @return customerCreateTimeWhere
	 */
	public Date getCustomerCreateTimeWhere () {
		return customerCreateTimeWhere;
	}

	/**
	 * 创建时间设定
	 * @param customerCreateTimeWhere
	 */
	public void setCustomerCreateTimeWhere (Date customerCreateTimeWhere) {
		this.customerCreateTimeWhere = customerCreateTimeWhere;
	}

	/* 创建者	*/ 
	private String customerCreateUserWhere;

	/**
	 * 创建者取得
	 * @return customerCreateUserWhere
	 */
	public String getCustomerCreateUserWhere () {
		return customerCreateUserWhere;
	}

	/**
	 * 创建者设定
	 * @param customerCreateUserWhere
	 */
	public void setCustomerCreateUserWhere (String customerCreateUserWhere) {
		this.customerCreateUserWhere = customerCreateUserWhere;
	}

	/* 版本号	*/ 
	private BigDecimal customerVersionWhere;

	/**
	 * 版本号取得
	 * @return customerVersionWhere
	 */
	public BigDecimal getCustomerVersionWhere () {
		return customerVersionWhere;
	}

	/**
	 * 版本号设定
	 * @param customerVersionWhere
	 */
	public void setCustomerVersionWhere (BigDecimal customerVersionWhere) {
		this.customerVersionWhere = customerVersionWhere;
	}

	/* 部门ID	*/ 
	private String departmentIDWhere;

	/**
	 * 部门ID取得
	 * @return departmentIDWhere
	 */
	public String getDepartmentIDWhere () {
		return departmentIDWhere;
	}

	/**
	 * 部门ID设定
	 * @param departmentIDWhere
	 */
	public void setDepartmentIDWhere (String departmentIDWhere) {
		this.departmentIDWhere = departmentIDWhere;
	}

	/* 机构ID	*/ 
	private String departmentAgencyIDWhere;

	/**
	 * 机构ID取得
	 * @return departmentAgencyIDWhere
	 */
	public String getDepartmentAgencyIDWhere () {
		return departmentAgencyIDWhere;
	}

	/**
	 * 机构ID设定
	 * @param departmentAgencyIDWhere
	 */
	public void setDepartmentAgencyIDWhere (String departmentAgencyIDWhere) {
		this.departmentAgencyIDWhere = departmentAgencyIDWhere;
	}

	/* 语言编码	*/ 
	private String departmentLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return departmentLanguageCodeWhere
	 */
	public String getDepartmentLanguageCodeWhere () {
		return departmentLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param departmentLanguageCodeWhere
	 */
	public void setDepartmentLanguageCodeWhere (String departmentLanguageCodeWhere) {
		this.departmentLanguageCodeWhere = departmentLanguageCodeWhere;
	}

	/* 部门编码	*/ 
	private String departmentCodeWhere;

	/**
	 * 部门编码取得
	 * @return departmentCodeWhere
	 */
	public String getDepartmentCodeWhere () {
		return departmentCodeWhere;
	}

	/**
	 * 部门编码设定
	 * @param departmentCodeWhere
	 */
	public void setDepartmentCodeWhere (String departmentCodeWhere) {
		this.departmentCodeWhere = departmentCodeWhere;
	}

	/* 部门名称	*/ 
	private String departmentNameWhere;

	/**
	 * 部门名称取得
	 * @return departmentNameWhere
	 */
	public String getDepartmentNameWhere () {
		return departmentNameWhere;
	}

	/**
	 * 部门名称设定
	 * @param departmentNameWhere
	 */
	public void setDepartmentNameWhere (String departmentNameWhere) {
		this.departmentNameWhere = departmentNameWhere;
	}

	/* 部门电话	*/ 
	private String departmentTelWhere;

	/**
	 * 部门电话取得
	 * @return departmentTelWhere
	 */
	public String getDepartmentTelWhere () {
		return departmentTelWhere;
	}

	/**
	 * 部门电话设定
	 * @param departmentTelWhere
	 */
	public void setDepartmentTelWhere (String departmentTelWhere) {
		this.departmentTelWhere = departmentTelWhere;
	}

	/* 部门负责人	*/ 
	private String departmentHeadWhere;

	/**
	 * 部门负责人取得
	 * @return departmentHeadWhere
	 */
	public String getDepartmentHeadWhere () {
		return departmentHeadWhere;
	}

	/**
	 * 部门负责人设定
	 * @param departmentHeadWhere
	 */
	public void setDepartmentHeadWhere (String departmentHeadWhere) {
		this.departmentHeadWhere = departmentHeadWhere;
	}

	/* 负责人手机	*/ 
	private String departmentHeadMobileWhere;

	/**
	 * 负责人手机取得
	 * @return departmentHeadMobileWhere
	 */
	public String getDepartmentHeadMobileWhere () {
		return departmentHeadMobileWhere;
	}

	/**
	 * 负责人手机设定
	 * @param departmentHeadMobileWhere
	 */
	public void setDepartmentHeadMobileWhere (String departmentHeadMobileWhere) {
		this.departmentHeadMobileWhere = departmentHeadMobileWhere;
	}

	/* 负责人电话	*/ 
	private String departmentHeadTelWhere;

	/**
	 * 负责人电话取得
	 * @return departmentHeadTelWhere
	 */
	public String getDepartmentHeadTelWhere () {
		return departmentHeadTelWhere;
	}

	/**
	 * 负责人电话设定
	 * @param departmentHeadTelWhere
	 */
	public void setDepartmentHeadTelWhere (String departmentHeadTelWhere) {
		this.departmentHeadTelWhere = departmentHeadTelWhere;
	}

	/* 部门成立时间	*/ 
	private String departmentCdateWhere;

	/**
	 * 部门成立时间取得
	 * @return departmentCdateWhere
	 */
	public String getDepartmentCdateWhere () {
		return departmentCdateWhere;
	}

	/**
	 * 部门成立时间设定
	 * @param departmentCdateWhere
	 */
	public void setDepartmentCdateWhere (String departmentCdateWhere) {
		this.departmentCdateWhere = departmentCdateWhere;
	}

	/* 部门描述	*/ 
	private String departmentDescriptionWhere;

	/**
	 * 部门描述取得
	 * @return departmentDescriptionWhere
	 */
	public String getDepartmentDescriptionWhere () {
		return departmentDescriptionWhere;
	}

	/**
	 * 部门描述设定
	 * @param departmentDescriptionWhere
	 */
	public void setDepartmentDescriptionWhere (String departmentDescriptionWhere) {
		this.departmentDescriptionWhere = departmentDescriptionWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String departmentDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return departmentDelFlagWhere
	 */
	public String getDepartmentDelFlagWhere () {
		return departmentDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param departmentDelFlagWhere
	 */
	public void setDepartmentDelFlagWhere (String departmentDelFlagWhere) {
		this.departmentDelFlagWhere = departmentDelFlagWhere;
	}

	/* 创建者	*/ 
	private String departmentCreateUserWhere;

	/**
	 * 创建者取得
	 * @return departmentCreateUserWhere
	 */
	public String getDepartmentCreateUserWhere () {
		return departmentCreateUserWhere;
	}

	/**
	 * 创建者设定
	 * @param departmentCreateUserWhere
	 */
	public void setDepartmentCreateUserWhere (String departmentCreateUserWhere) {
		this.departmentCreateUserWhere = departmentCreateUserWhere;
	}

	/* 创建时间	*/ 
	private Date departmentCreateTimeWhere;

	/**
	 * 创建时间取得
	 * @return departmentCreateTimeWhere
	 */
	public Date getDepartmentCreateTimeWhere () {
		return departmentCreateTimeWhere;
	}

	/**
	 * 创建时间设定
	 * @param departmentCreateTimeWhere
	 */
	public void setDepartmentCreateTimeWhere (Date departmentCreateTimeWhere) {
		this.departmentCreateTimeWhere = departmentCreateTimeWhere;
	}

	/* 更新者	*/ 
	private String departmentUpdateUserWhere;

	/**
	 * 更新者取得
	 * @return departmentUpdateUserWhere
	 */
	public String getDepartmentUpdateUserWhere () {
		return departmentUpdateUserWhere;
	}

	/**
	 * 更新者设定
	 * @param departmentUpdateUserWhere
	 */
	public void setDepartmentUpdateUserWhere (String departmentUpdateUserWhere) {
		this.departmentUpdateUserWhere = departmentUpdateUserWhere;
	}

	/* 更新时间	*/ 
	private Date departmentUpdateTimeWhere;

	/**
	 * 更新时间取得
	 * @return departmentUpdateTimeWhere
	 */
	public Date getDepartmentUpdateTimeWhere () {
		return departmentUpdateTimeWhere;
	}

	/**
	 * 更新时间设定
	 * @param departmentUpdateTimeWhere
	 */
	public void setDepartmentUpdateTimeWhere (Date departmentUpdateTimeWhere) {
		this.departmentUpdateTimeWhere = departmentUpdateTimeWhere;
	}

	/* 版本号	*/ 
	private BigDecimal departmentVersionWhere;

	/**
	 * 版本号取得
	 * @return departmentVersionWhere
	 */
	public BigDecimal getDepartmentVersionWhere () {
		return departmentVersionWhere;
	}

	/**
	 * 版本号设定
	 * @param departmentVersionWhere
	 */
	public void setDepartmentVersionWhere (BigDecimal departmentVersionWhere) {
		this.departmentVersionWhere = departmentVersionWhere;
	}

	/* 职务ID	*/ 
	private String positionIDWhere;

	/**
	 * 职务ID取得
	 * @return positionIDWhere
	 */
	public String getPositionIDWhere () {
		return positionIDWhere;
	}

	/**
	 * 职务ID设定
	 * @param positionIDWhere
	 */
	public void setPositionIDWhere (String positionIDWhere) {
		this.positionIDWhere = positionIDWhere;
	}

	/* 语言编码	*/ 
	private String positionLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return positionLanguageCodeWhere
	 */
	public String getPositionLanguageCodeWhere () {
		return positionLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param positionLanguageCodeWhere
	 */
	public void setPositionLanguageCodeWhere (String positionLanguageCodeWhere) {
		this.positionLanguageCodeWhere = positionLanguageCodeWhere;
	}

	/* 职务编码	*/ 
	private String positionCodeWhere;

	/**
	 * 职务编码取得
	 * @return positionCodeWhere
	 */
	public String getPositionCodeWhere () {
		return positionCodeWhere;
	}

	/**
	 * 职务编码设定
	 * @param positionCodeWhere
	 */
	public void setPositionCodeWhere (String positionCodeWhere) {
		this.positionCodeWhere = positionCodeWhere;
	}

	/* 职务名称	*/ 
	private String positionNameWhere;

	/**
	 * 职务名称取得
	 * @return positionNameWhere
	 */
	public String getPositionNameWhere () {
		return positionNameWhere;
	}

	/**
	 * 职务名称设定
	 * @param positionNameWhere
	 */
	public void setPositionNameWhere (String positionNameWhere) {
		this.positionNameWhere = positionNameWhere;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String positionDelFlagWhere;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return positionDelFlagWhere
	 */
	public String getPositionDelFlagWhere () {
		return positionDelFlagWhere;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param positionDelFlagWhere
	 */
	public void setPositionDelFlagWhere (String positionDelFlagWhere) {
		this.positionDelFlagWhere = positionDelFlagWhere;
	}

	/* 创建者	*/ 
	private String positionCreateUserWhere;

	/**
	 * 创建者取得
	 * @return positionCreateUserWhere
	 */
	public String getPositionCreateUserWhere () {
		return positionCreateUserWhere;
	}

	/**
	 * 创建者设定
	 * @param positionCreateUserWhere
	 */
	public void setPositionCreateUserWhere (String positionCreateUserWhere) {
		this.positionCreateUserWhere = positionCreateUserWhere;
	}

	/* 创建时间	*/ 
	private Date positionCreateTimeWhere;

	/**
	 * 创建时间取得
	 * @return positionCreateTimeWhere
	 */
	public Date getPositionCreateTimeWhere () {
		return positionCreateTimeWhere;
	}

	/**
	 * 创建时间设定
	 * @param positionCreateTimeWhere
	 */
	public void setPositionCreateTimeWhere (Date positionCreateTimeWhere) {
		this.positionCreateTimeWhere = positionCreateTimeWhere;
	}

	/* 更新者	*/ 
	private String positionUpdateUserWhere;

	/**
	 * 更新者取得
	 * @return positionUpdateUserWhere
	 */
	public String getPositionUpdateUserWhere () {
		return positionUpdateUserWhere;
	}

	/**
	 * 更新者设定
	 * @param positionUpdateUserWhere
	 */
	public void setPositionUpdateUserWhere (String positionUpdateUserWhere) {
		this.positionUpdateUserWhere = positionUpdateUserWhere;
	}

	/* 更新时间	*/ 
	private Date positionUpdateTimeWhere;

	/**
	 * 更新时间取得
	 * @return positionUpdateTimeWhere
	 */
	public Date getPositionUpdateTimeWhere () {
		return positionUpdateTimeWhere;
	}

	/**
	 * 更新时间设定
	 * @param positionUpdateTimeWhere
	 */
	public void setPositionUpdateTimeWhere (Date positionUpdateTimeWhere) {
		this.positionUpdateTimeWhere = positionUpdateTimeWhere;
	}

	/* 版本号	*/ 
	private BigDecimal positionVersionWhere;

	/**
	 * 版本号取得
	 * @return positionVersionWhere
	 */
	public BigDecimal getPositionVersionWhere () {
		return positionVersionWhere;
	}

	/**
	 * 版本号设定
	 * @param positionVersionWhere
	 */
	public void setPositionVersionWhere (BigDecimal positionVersionWhere) {
		this.positionVersionWhere = positionVersionWhere;
	}

	/* 机构ID	*/ 
	private String agencyIDWhere;

	/**
	 * 机构ID取得
	 * @return agencyIDWhere
	 */
	public String getAgencyIDWhere () {
		return agencyIDWhere;
	}

	/**
	 * 机构ID设定
	 * @param agencyIDWhere
	 */
	public void setAgencyIDWhere (String agencyIDWhere) {
		this.agencyIDWhere = agencyIDWhere;
	}

	/* 机构ID	*/ 
	private String age_AgencyIDWhere;

	/**
	 * 机构ID取得
	 * @return age_AgencyIDWhere
	 */
	public String getAge_AgencyIDWhere () {
		return age_AgencyIDWhere;
	}

	/**
	 * 机构ID设定
	 * @param age_AgencyIDWhere
	 */
	public void setAge_AgencyIDWhere (String age_AgencyIDWhere) {
		this.age_AgencyIDWhere = age_AgencyIDWhere;
	}

	/* 语言编码	*/ 
	private String agencyLanguageCodeWhere;

	/**
	 * 语言编码取得
	 * @return agencyLanguageCodeWhere
	 */
	public String getAgencyLanguageCodeWhere () {
		return agencyLanguageCodeWhere;
	}

	/**
	 * 语言编码设定
	 * @param agencyLanguageCodeWhere
	 */
	public void setAgencyLanguageCodeWhere (String agencyLanguageCodeWhere) {
		this.agencyLanguageCodeWhere = agencyLanguageCodeWhere;
	}

	/* 机构编码	*/ 
	private String agencyCodeWhere;

	/**
	 * 机构编码取得
	 * @return agencyCodeWhere
	 */
	public String getAgencyCodeWhere () {
		return agencyCodeWhere;
	}

	/**
	 * 机构编码设定
	 * @param agencyCodeWhere
	 */
	public void setAgencyCodeWhere (String agencyCodeWhere) {
		this.agencyCodeWhere = agencyCodeWhere;
	}

	/* 机构名称	*/ 
	private String agencyNameWhere;

	/**
	 * 机构名称取得
	 * @return agencyNameWhere
	 */
	public String getAgencyNameWhere () {
		return agencyNameWhere;
	}

	/**
	 * 机构名称设定
	 * @param agencyNameWhere
	 */
	public void setAgencyNameWhere (String agencyNameWhere) {
		this.agencyNameWhere = agencyNameWhere;
	}

	/* 机构电话	*/ 
	private String agencyTelWhere;

	/**
	 * 机构电话取得
	 * @return agencyTelWhere
	 */
	public String getAgencyTelWhere () {
		return agencyTelWhere;
	}

	/**
	 * 机构电话设定
	 * @param agencyTelWhere
	 */
	public void setAgencyTelWhere (String agencyTelWhere) {
		this.agencyTelWhere = agencyTelWhere;
	}

	/* 机构创立时间	*/ 
	private String agencyCdateWhere;

	/**
	 * 机构创立时间取得
	 * @return agencyCdateWhere
	 */
	public String getAgencyCdateWhere () {
		return agencyCdateWhere;
	}

	/**
	 * 机构创立时间设定
	 * @param agencyCdateWhere
	 */
	public void setAgencyCdateWhere (String agencyCdateWhere) {
		this.agencyCdateWhere = agencyCdateWhere;
	}

	/* 机构法人	*/ 
	private String agencyCorporateWhere;

	/**
	 * 机构法人取得
	 * @return agencyCorporateWhere
	 */
	public String getAgencyCorporateWhere () {
		return agencyCorporateWhere;
	}

	/**
	 * 机构法人设定
	 * @param agencyCorporateWhere
	 */
	public void setAgencyCorporateWhere (String agencyCorporateWhere) {
		this.agencyCorporateWhere = agencyCorporateWhere;
	}

	/* 创建者	*/ 
	private String agencyCreateUserWhere;

	/**
	 * 创建者取得
	 * @return agencyCreateUserWhere
	 */
	public String getAgencyCreateUserWhere () {
		return agencyCreateUserWhere;
	}

	/**
	 * 创建者设定
	 * @param agencyCreateUserWhere
	 */
	public void setAgencyCreateUserWhere (String agencyCreateUserWhere) {
		this.agencyCreateUserWhere = agencyCreateUserWhere;
	}

	/* 创建时间	*/ 
	private Date agencyCreateTimeWhere;

	/**
	 * 创建时间取得
	 * @return agencyCreateTimeWhere
	 */
	public Date getAgencyCreateTimeWhere () {
		return agencyCreateTimeWhere;
	}

	/**
	 * 创建时间设定
	 * @param agencyCreateTimeWhere
	 */
	public void setAgencyCreateTimeWhere (Date agencyCreateTimeWhere) {
		this.agencyCreateTimeWhere = agencyCreateTimeWhere;
	}

	/* 更新者	*/ 
	private String agencyUpdateUserWhere;

	/**
	 * 更新者取得
	 * @return agencyUpdateUserWhere
	 */
	public String getAgencyUpdateUserWhere () {
		return agencyUpdateUserWhere;
	}

	/**
	 * 更新者设定
	 * @param agencyUpdateUserWhere
	 */
	public void setAgencyUpdateUserWhere (String agencyUpdateUserWhere) {
		this.agencyUpdateUserWhere = agencyUpdateUserWhere;
	}

	/* 更新时间	*/ 
	private Date agencyUpdateTimeWhere;

	/**
	 * 更新时间取得
	 * @return agencyUpdateTimeWhere
	 */
	public Date getAgencyUpdateTimeWhere () {
		return agencyUpdateTimeWhere;
	}

	/**
	 * 更新时间设定
	 * @param agencyUpdateTimeWhere
	 */
	public void setAgencyUpdateTimeWhere (Date agencyUpdateTimeWhere) {
		this.agencyUpdateTimeWhere = agencyUpdateTimeWhere;
	}

	/* 版本号	*/ 
	private BigDecimal agencyVersionWhere;

	/**
	 * 版本号取得
	 * @return agencyVersionWhere
	 */
	public BigDecimal getAgencyVersionWhere () {
		return agencyVersionWhere;
	}

	/**
	 * 版本号设定
	 * @param agencyVersionWhere
	 */
	public void setAgencyVersionWhere (BigDecimal agencyVersionWhere) {
		this.agencyVersionWhere = agencyVersionWhere;
	}
}

