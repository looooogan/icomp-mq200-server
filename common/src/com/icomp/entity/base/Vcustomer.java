/*
 * 工具自动生成：VIEW实体类
 * 生成时间    : 2014/11/12 18:19:04
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * VIEW实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:19:04
 * 创建者  ：杨作庆
 * 
 */
public class Vcustomer extends VcustomerWhere implements Serializable {

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
	private String userdetailCustomerID;

	/**
	 * 用户ID[自动生成20位字符串]取得
	 * @return userdetailCustomerID
	 */
	public String getUserdetailCustomerID() {
		return userdetailCustomerID;
	}

	/**
	 * 用户ID[自动生成20位字符串]设定
	 * @param userdetailCustomerID
	 */
	public void setUserdetailCustomerID(String userdetailCustomerID) {
		this.userdetailCustomerID = userdetailCustomerID;
	}

	/* 姓名	*/ 
	private String userdetailUserName;

	/**
	 * 姓名取得
	 * @return userdetailUserName
	 */
	public String getUserdetailUserName() {
		return userdetailUserName;
	}

	/**
	 * 姓名设定
	 * @param userdetailUserName
	 */
	public void setUserdetailUserName(String userdetailUserName) {
		this.userdetailUserName = userdetailUserName;
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

	/* 删除区分(0有效1删除)	*/ 
	private String userdetailDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return userdetailDelFlag
	 */
	public String getUserdetailDelFlag() {
		return userdetailDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param userdetailDelFlag
	 */
	public void setUserdetailDelFlag(String userdetailDelFlag) {
		this.userdetailDelFlag = userdetailDelFlag;
	}

	/* 创建者	*/ 
	private String userdetailCreateUser;

	/**
	 * 创建者取得
	 * @return userdetailCreateUser
	 */
	public String getUserdetailCreateUser() {
		return userdetailCreateUser;
	}

	/**
	 * 创建者设定
	 * @param userdetailCreateUser
	 */
	public void setUserdetailCreateUser(String userdetailCreateUser) {
		this.userdetailCreateUser = userdetailCreateUser;
	}

	/* 创建时间	*/ 
	private Date userdetailCreateTime;

	/**
	 * 创建时间取得
	 * @return userdetailCreateTime
	 */
	public Date getUserdetailCreateTime() {
		return userdetailCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param userdetailCreateTime
	 */
	public void setUserdetailCreateTime(Date userdetailCreateTime) {
		this.userdetailCreateTime = userdetailCreateTime;
	}

	/* 更新者	*/ 
	private String userdetailUpdateUser;

	/**
	 * 更新者取得
	 * @return userdetailUpdateUser
	 */
	public String getUserdetailUpdateUser() {
		return userdetailUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param userdetailUpdateUser
	 */
	public void setUserdetailUpdateUser(String userdetailUpdateUser) {
		this.userdetailUpdateUser = userdetailUpdateUser;
	}

	/* 更新时间	*/ 
	private Date userdetailUpdateTime;

	/**
	 * 更新时间取得
	 * @return userdetailUpdateTime
	 */
	public Date getUserdetailUpdateTime() {
		return userdetailUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param userdetailUpdateTime
	 */
	public void setUserdetailUpdateTime(Date userdetailUpdateTime) {
		this.userdetailUpdateTime = userdetailUpdateTime;
	}

	/* 版本号	*/ 
	private BigDecimal userdetailVersion;

	/**
	 * 版本号取得
	 * @return userdetailVersion
	 */
	public BigDecimal getUserdetailVersion() {
		return userdetailVersion;
	}

	/**
	 * 版本号设定
	 * @param userdetailVersion
	 */
	public void setUserdetailVersion(BigDecimal userdetailVersion) {
		this.userdetailVersion = userdetailVersion;
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

	/* 职务ID	*/ 
	private String customerPositionID;

	/**
	 * 职务ID取得
	 * @return customerPositionID
	 */
	public String getCustomerPositionID() {
		return customerPositionID;
	}

	/**
	 * 职务ID设定
	 * @param customerPositionID
	 */
	public void setCustomerPositionID(String customerPositionID) {
		this.customerPositionID = customerPositionID;
	}

	/* 用户名[16位数字字母组合]	*/ 
	private String userName;

	/**
	 * 用户名[16位数字字母组合]取得
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名[16位数字字母组合]设定
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* 用户密码[16位数字字母组合]	*/ 
	private String userPass;

	/**
	 * 用户密码[16位数字字母组合]取得
	 * @return userPass
	 */
	public String getUserPass() {
		return userPass;
	}

	/**
	 * 用户密码[16位数字字母组合]设定
	 * @param userPass
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/* 员工卡号[20位员工卡]	*/ 
	private String employeeCard;

	/**
	 * 员工卡号[20位员工卡]取得
	 * @return employeeCard
	 */
	public String getEmployeeCard() {
		return employeeCard;
	}

	/**
	 * 员工卡号[20位员工卡]设定
	 * @param employeeCard
	 */
	public void setEmployeeCard(String employeeCard) {
		this.employeeCard = employeeCard;
	}

	/* 用户类型(0系统用户1普通用户)	*/ 
	private String userType;

	/**
	 * 用户类型(0系统用户1普通用户)取得
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 用户类型(0系统用户1普通用户)设定
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/* 用户锁定区分(0正常1锁定)	*/ 
	private String userErrFlag;

	/**
	 * 用户锁定区分(0正常1锁定)取得
	 * @return userErrFlag
	 */
	public String getUserErrFlag() {
		return userErrFlag;
	}

	/**
	 * 用户锁定区分(0正常1锁定)设定
	 * @param userErrFlag
	 */
	public void setUserErrFlag(String userErrFlag) {
		this.userErrFlag = userErrFlag;
	}

	/* 错误次数	*/ 
	private BigDecimal errCount;

	/**
	 * 错误次数取得
	 * @return errCount
	 */
	public BigDecimal getErrCount() {
		return errCount;
	}

	/**
	 * 错误次数设定
	 * @param errCount
	 */
	public void setErrCount(BigDecimal errCount) {
		this.errCount = errCount;
	}

	/* 锁定开始时间	*/ 
	private Date errStaTime;

	/**
	 * 锁定开始时间取得
	 * @return errStaTime
	 */
	public Date getErrStaTime() {
		return errStaTime;
	}

	/**
	 * 锁定开始时间设定
	 * @param errStaTime
	 */
	public void setErrStaTime(Date errStaTime) {
		this.errStaTime = errStaTime;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String customerDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return customerDelFlag
	 */
	public String getCustomerDelFlag() {
		return customerDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param customerDelFlag
	 */
	public void setCustomerDelFlag(String customerDelFlag) {
		this.customerDelFlag = customerDelFlag;
	}

	/* 更新时间	*/ 
	private Date customerUpdateTime;

	/**
	 * 更新时间取得
	 * @return customerUpdateTime
	 */
	public Date getCustomerUpdateTime() {
		return customerUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param customerUpdateTime
	 */
	public void setCustomerUpdateTime(Date customerUpdateTime) {
		this.customerUpdateTime = customerUpdateTime;
	}

	/* 更新者	*/ 
	private String customerUpdateUser;

	/**
	 * 更新者取得
	 * @return customerUpdateUser
	 */
	public String getCustomerUpdateUser() {
		return customerUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param customerUpdateUser
	 */
	public void setCustomerUpdateUser(String customerUpdateUser) {
		this.customerUpdateUser = customerUpdateUser;
	}

	/* 创建时间	*/ 
	private Date customerCreateTime;

	/**
	 * 创建时间取得
	 * @return customerCreateTime
	 */
	public Date getCustomerCreateTime() {
		return customerCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param customerCreateTime
	 */
	public void setCustomerCreateTime(Date customerCreateTime) {
		this.customerCreateTime = customerCreateTime;
	}

	/* 创建者	*/ 
	private String customerCreateUser;

	/**
	 * 创建者取得
	 * @return customerCreateUser
	 */
	public String getCustomerCreateUser() {
		return customerCreateUser;
	}

	/**
	 * 创建者设定
	 * @param customerCreateUser
	 */
	public void setCustomerCreateUser(String customerCreateUser) {
		this.customerCreateUser = customerCreateUser;
	}

	/* 版本号	*/ 
	private BigDecimal customerVersion;

	/**
	 * 版本号取得
	 * @return customerVersion
	 */
	public BigDecimal getCustomerVersion() {
		return customerVersion;
	}

	/**
	 * 版本号设定
	 * @param customerVersion
	 */
	public void setCustomerVersion(BigDecimal customerVersion) {
		this.customerVersion = customerVersion;
	}

	/* 部门ID	*/ 
	private String departmentID;

	/**
	 * 部门ID取得
	 * @return departmentID
	 */
	public String getDepartmentID() {
		return departmentID;
	}

	/**
	 * 部门ID设定
	 * @param departmentID
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	/* 机构ID	*/ 
	private String departmentAgencyID;

	/**
	 * 机构ID取得
	 * @return departmentAgencyID
	 */
	public String getDepartmentAgencyID() {
		return departmentAgencyID;
	}

	/**
	 * 机构ID设定
	 * @param departmentAgencyID
	 */
	public void setDepartmentAgencyID(String departmentAgencyID) {
		this.departmentAgencyID = departmentAgencyID;
	}

	/* 语言编码	*/ 
	private String departmentLanguageCode;

	/**
	 * 语言编码取得
	 * @return departmentLanguageCode
	 */
	public String getDepartmentLanguageCode() {
		return departmentLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param departmentLanguageCode
	 */
	public void setDepartmentLanguageCode(String departmentLanguageCode) {
		this.departmentLanguageCode = departmentLanguageCode;
	}

	/* 部门编码	*/ 
	private String departmentCode;

	/**
	 * 部门编码取得
	 * @return departmentCode
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * 部门编码设定
	 * @param departmentCode
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/* 部门名称	*/ 
	private String departmentName;

	/**
	 * 部门名称取得
	 * @return departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部门名称设定
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/* 部门电话	*/ 
	private String departmentTel;

	/**
	 * 部门电话取得
	 * @return departmentTel
	 */
	public String getDepartmentTel() {
		return departmentTel;
	}

	/**
	 * 部门电话设定
	 * @param departmentTel
	 */
	public void setDepartmentTel(String departmentTel) {
		this.departmentTel = departmentTel;
	}

	/* 部门负责人	*/ 
	private String departmentHead;

	/**
	 * 部门负责人取得
	 * @return departmentHead
	 */
	public String getDepartmentHead() {
		return departmentHead;
	}

	/**
	 * 部门负责人设定
	 * @param departmentHead
	 */
	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	/* 负责人手机	*/ 
	private String departmentHeadMobile;

	/**
	 * 负责人手机取得
	 * @return departmentHeadMobile
	 */
	public String getDepartmentHeadMobile() {
		return departmentHeadMobile;
	}

	/**
	 * 负责人手机设定
	 * @param departmentHeadMobile
	 */
	public void setDepartmentHeadMobile(String departmentHeadMobile) {
		this.departmentHeadMobile = departmentHeadMobile;
	}

	/* 负责人电话	*/ 
	private String departmentHeadTel;

	/**
	 * 负责人电话取得
	 * @return departmentHeadTel
	 */
	public String getDepartmentHeadTel() {
		return departmentHeadTel;
	}

	/**
	 * 负责人电话设定
	 * @param departmentHeadTel
	 */
	public void setDepartmentHeadTel(String departmentHeadTel) {
		this.departmentHeadTel = departmentHeadTel;
	}

	/* 部门成立时间	*/ 
	private String departmentCdate;

	/**
	 * 部门成立时间取得
	 * @return departmentCdate
	 */
	public String getDepartmentCdate() {
		return departmentCdate;
	}

	/**
	 * 部门成立时间设定
	 * @param departmentCdate
	 */
	public void setDepartmentCdate(String departmentCdate) {
		this.departmentCdate = departmentCdate;
	}

	/* 部门描述	*/ 
	private String departmentDescription;

	/**
	 * 部门描述取得
	 * @return departmentDescription
	 */
	public String getDepartmentDescription() {
		return departmentDescription;
	}

	/**
	 * 部门描述设定
	 * @param departmentDescription
	 */
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String departmentDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return departmentDelFlag
	 */
	public String getDepartmentDelFlag() {
		return departmentDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param departmentDelFlag
	 */
	public void setDepartmentDelFlag(String departmentDelFlag) {
		this.departmentDelFlag = departmentDelFlag;
	}

	/* 创建者	*/ 
	private String departmentCreateUser;

	/**
	 * 创建者取得
	 * @return departmentCreateUser
	 */
	public String getDepartmentCreateUser() {
		return departmentCreateUser;
	}

	/**
	 * 创建者设定
	 * @param departmentCreateUser
	 */
	public void setDepartmentCreateUser(String departmentCreateUser) {
		this.departmentCreateUser = departmentCreateUser;
	}

	/* 创建时间	*/ 
	private Date departmentCreateTime;

	/**
	 * 创建时间取得
	 * @return departmentCreateTime
	 */
	public Date getDepartmentCreateTime() {
		return departmentCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param departmentCreateTime
	 */
	public void setDepartmentCreateTime(Date departmentCreateTime) {
		this.departmentCreateTime = departmentCreateTime;
	}

	/* 更新者	*/ 
	private String departmentUpdateUser;

	/**
	 * 更新者取得
	 * @return departmentUpdateUser
	 */
	public String getDepartmentUpdateUser() {
		return departmentUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param departmentUpdateUser
	 */
	public void setDepartmentUpdateUser(String departmentUpdateUser) {
		this.departmentUpdateUser = departmentUpdateUser;
	}

	/* 更新时间	*/ 
	private Date departmentUpdateTime;

	/**
	 * 更新时间取得
	 * @return departmentUpdateTime
	 */
	public Date getDepartmentUpdateTime() {
		return departmentUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param departmentUpdateTime
	 */
	public void setDepartmentUpdateTime(Date departmentUpdateTime) {
		this.departmentUpdateTime = departmentUpdateTime;
	}

	/* 版本号	*/ 
	private BigDecimal departmentVersion;

	/**
	 * 版本号取得
	 * @return departmentVersion
	 */
	public BigDecimal getDepartmentVersion() {
		return departmentVersion;
	}

	/**
	 * 版本号设定
	 * @param departmentVersion
	 */
	public void setDepartmentVersion(BigDecimal departmentVersion) {
		this.departmentVersion = departmentVersion;
	}

	/* 职务ID	*/ 
	private String positionID;

	/**
	 * 职务ID取得
	 * @return positionID
	 */
	public String getPositionID() {
		return positionID;
	}

	/**
	 * 职务ID设定
	 * @param positionID
	 */
	public void setPositionID(String positionID) {
		this.positionID = positionID;
	}

	/* 语言编码	*/ 
	private String positionLanguageCode;

	/**
	 * 语言编码取得
	 * @return positionLanguageCode
	 */
	public String getPositionLanguageCode() {
		return positionLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param positionLanguageCode
	 */
	public void setPositionLanguageCode(String positionLanguageCode) {
		this.positionLanguageCode = positionLanguageCode;
	}

	/* 职务编码	*/ 
	private String positionCode;

	/**
	 * 职务编码取得
	 * @return positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * 职务编码设定
	 * @param positionCode
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	/* 职务名称	*/ 
	private String positionName;

	/**
	 * 职务名称取得
	 * @return positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * 职务名称设定
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/* 删除区分(0有效1删除)	*/ 
	private String positionDelFlag;

	/**
	 * 删除区分(0有效1删除)取得
	 * @return positionDelFlag
	 */
	public String getPositionDelFlag() {
		return positionDelFlag;
	}

	/**
	 * 删除区分(0有效1删除)设定
	 * @param positionDelFlag
	 */
	public void setPositionDelFlag(String positionDelFlag) {
		this.positionDelFlag = positionDelFlag;
	}

	/* 创建者	*/ 
	private String positionCreateUser;

	/**
	 * 创建者取得
	 * @return positionCreateUser
	 */
	public String getPositionCreateUser() {
		return positionCreateUser;
	}

	/**
	 * 创建者设定
	 * @param positionCreateUser
	 */
	public void setPositionCreateUser(String positionCreateUser) {
		this.positionCreateUser = positionCreateUser;
	}

	/* 创建时间	*/ 
	private Date positionCreateTime;

	/**
	 * 创建时间取得
	 * @return positionCreateTime
	 */
	public Date getPositionCreateTime() {
		return positionCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param positionCreateTime
	 */
	public void setPositionCreateTime(Date positionCreateTime) {
		this.positionCreateTime = positionCreateTime;
	}

	/* 更新者	*/ 
	private String positionUpdateUser;

	/**
	 * 更新者取得
	 * @return positionUpdateUser
	 */
	public String getPositionUpdateUser() {
		return positionUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param positionUpdateUser
	 */
	public void setPositionUpdateUser(String positionUpdateUser) {
		this.positionUpdateUser = positionUpdateUser;
	}

	/* 更新时间	*/ 
	private Date positionUpdateTime;

	/**
	 * 更新时间取得
	 * @return positionUpdateTime
	 */
	public Date getPositionUpdateTime() {
		return positionUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param positionUpdateTime
	 */
	public void setPositionUpdateTime(Date positionUpdateTime) {
		this.positionUpdateTime = positionUpdateTime;
	}

	/* 版本号	*/ 
	private BigDecimal positionVersion;

	/**
	 * 版本号取得
	 * @return positionVersion
	 */
	public BigDecimal getPositionVersion() {
		return positionVersion;
	}

	/**
	 * 版本号设定
	 * @param positionVersion
	 */
	public void setPositionVersion(BigDecimal positionVersion) {
		this.positionVersion = positionVersion;
	}

	/* 机构ID	*/ 
	private String agencyID;

	/**
	 * 机构ID取得
	 * @return agencyID
	 */
	public String getAgencyID() {
		return agencyID;
	}

	/**
	 * 机构ID设定
	 * @param agencyID
	 */
	public void setAgencyID(String agencyID) {
		this.agencyID = agencyID;
	}

	/* 机构ID	*/ 
	private String age_AgencyID;

	/**
	 * 机构ID取得
	 * @return age_AgencyID
	 */
	public String getAge_AgencyID() {
		return age_AgencyID;
	}

	/**
	 * 机构ID设定
	 * @param age_AgencyID
	 */
	public void setAge_AgencyID(String age_AgencyID) {
		this.age_AgencyID = age_AgencyID;
	}

	/* 语言编码	*/ 
	private String agencyLanguageCode;

	/**
	 * 语言编码取得
	 * @return agencyLanguageCode
	 */
	public String getAgencyLanguageCode() {
		return agencyLanguageCode;
	}

	/**
	 * 语言编码设定
	 * @param agencyLanguageCode
	 */
	public void setAgencyLanguageCode(String agencyLanguageCode) {
		this.agencyLanguageCode = agencyLanguageCode;
	}

	/* 机构编码	*/ 
	private String agencyCode;

	/**
	 * 机构编码取得
	 * @return agencyCode
	 */
	public String getAgencyCode() {
		return agencyCode;
	}

	/**
	 * 机构编码设定
	 * @param agencyCode
	 */
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	/* 机构名称	*/ 
	private String agencyName;

	/**
	 * 机构名称取得
	 * @return agencyName
	 */
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * 机构名称设定
	 * @param agencyName
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	/* 机构电话	*/ 
	private String agencyTel;

	/**
	 * 机构电话取得
	 * @return agencyTel
	 */
	public String getAgencyTel() {
		return agencyTel;
	}

	/**
	 * 机构电话设定
	 * @param agencyTel
	 */
	public void setAgencyTel(String agencyTel) {
		this.agencyTel = agencyTel;
	}

	/* 机构创立时间	*/ 
	private String agencyCdate;

	/**
	 * 机构创立时间取得
	 * @return agencyCdate
	 */
	public String getAgencyCdate() {
		return agencyCdate;
	}

	/**
	 * 机构创立时间设定
	 * @param agencyCdate
	 */
	public void setAgencyCdate(String agencyCdate) {
		this.agencyCdate = agencyCdate;
	}

	/* 机构法人	*/ 
	private String agencyCorporate;

	/**
	 * 机构法人取得
	 * @return agencyCorporate
	 */
	public String getAgencyCorporate() {
		return agencyCorporate;
	}

	/**
	 * 机构法人设定
	 * @param agencyCorporate
	 */
	public void setAgencyCorporate(String agencyCorporate) {
		this.agencyCorporate = agencyCorporate;
	}

	/* 创建者	*/ 
	private String agencyCreateUser;

	/**
	 * 创建者取得
	 * @return agencyCreateUser
	 */
	public String getAgencyCreateUser() {
		return agencyCreateUser;
	}

	/**
	 * 创建者设定
	 * @param agencyCreateUser
	 */
	public void setAgencyCreateUser(String agencyCreateUser) {
		this.agencyCreateUser = agencyCreateUser;
	}

	/* 创建时间	*/ 
	private Date agencyCreateTime;

	/**
	 * 创建时间取得
	 * @return agencyCreateTime
	 */
	public Date getAgencyCreateTime() {
		return agencyCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param agencyCreateTime
	 */
	public void setAgencyCreateTime(Date agencyCreateTime) {
		this.agencyCreateTime = agencyCreateTime;
	}

	/* 更新者	*/ 
	private String agencyUpdateUser;

	/**
	 * 更新者取得
	 * @return agencyUpdateUser
	 */
	public String getAgencyUpdateUser() {
		return agencyUpdateUser;
	}

	/**
	 * 更新者设定
	 * @param agencyUpdateUser
	 */
	public void setAgencyUpdateUser(String agencyUpdateUser) {
		this.agencyUpdateUser = agencyUpdateUser;
	}

	/* 更新时间	*/ 
	private Date agencyUpdateTime;

	/**
	 * 更新时间取得
	 * @return agencyUpdateTime
	 */
	public Date getAgencyUpdateTime() {
		return agencyUpdateTime;
	}

	/**
	 * 更新时间设定
	 * @param agencyUpdateTime
	 */
	public void setAgencyUpdateTime(Date agencyUpdateTime) {
		this.agencyUpdateTime = agencyUpdateTime;
	}

	/* 版本号	*/ 
	private BigDecimal agencyVersion;

	/**
	 * 版本号取得
	 * @return agencyVersion
	 */
	public BigDecimal getAgencyVersion() {
		return agencyVersion;
	}

	/**
	 * 版本号设定
	 * @param agencyVersion
	 */
	public void setAgencyVersion(BigDecimal agencyVersion) {
		this.agencyVersion = agencyVersion;
	}
}

