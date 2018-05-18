/*
 * 工具自动生成：合成刀具参数实体类
 * 生成时间    : 2014/11/12 18:50:03
 */
package com.icomp.entity.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 合成刀具参数实体类
 * @author 工具自动生成
 * 创建时间：2014/11/12 18:50:03
 * 创建者  ：杨作庆
 *
 */
public class Synthesisparameters extends SynthesisparametersWhere implements Serializable {

	// 序列化接口属性
	private static final long serialVersionUID = 1L;

	/* 合成刀具参数ID	*/
	private String synthesisParametersID;

	/**
	 * 合成刀具参数ID取得
	 * @return synthesisParametersID
	 */
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	/**
	 * 合成刀具参数ID设定
	 * @param synthesisParametersID
	 */
	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}

	/* 合成刀具编码(系统唯一)	*/
	private String synthesisParametersCode;

	/**
	 * 合成刀具编码(系统唯一)取得
	 * @return synthesisParametersCode
	 */
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	/**
	 * 合成刀具编码(系统唯一)设定
	 * @param synthesisParametersCode
	 */
	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}

	/* 位置数	*/
	private BigDecimal synthesisCount;

	/**
	 * 位置数取得
	 * @return synthesisCount
	 */
	public BigDecimal getSynthesisCount() {
		return synthesisCount;
	}

	/**
	 * 位置数设定
	 * @param synthesisCount
	 */
	public void setSynthesisCount(BigDecimal synthesisCount) {
		this.synthesisCount = synthesisCount;
	}

	/* 是否工艺试验(0是1否)	*/
	private String technicalTest;

	/**
	 * 是否工艺试验(0是1否)取得
	 * @return technicalTest
	 */
	public String getTechnicalTest() {
		return technicalTest;
	}

	/**
	 * 是否工艺试验(0是1否)设定
	 * @param technicalTest
	 */
	public void setTechnicalTest(String technicalTest) {
		this.technicalTest = technicalTest;
	}

	/* 组成类型(0刀片1钻头2复合刀具3热套类)	*/
	private String createType;

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)取得
	 * @return createType
	 */
	public String getCreateType() {
		return createType;
	}

	/**
	 * 组成类型(0刀片1钻头2复合刀具3热套类)设定
	 * @param createType
	 */
	public void setCreateType(String createType) {
		this.createType = createType;
	}

	/* 定额加工量	*/
	private BigDecimal quotaProcessingVolume;

	/**
	 * 定额加工量取得
	 * @return quotaProcessingVolume
	 */
	public BigDecimal getQuotaProcessingVolume() {
		return quotaProcessingVolume;
	}

	/**
	 * 定额加工量设定
	 * @param quotaProcessingVolume
	 */
	public void setQuotaProcessingVolume(BigDecimal quotaProcessingVolume) {
		this.quotaProcessingVolume = quotaProcessingVolume;
	}

	/* 刀具图纸	*/
	private String toolPic;

	/**
	 * 刀具图纸取得
	 * @return toolPic
	 */
	public String getToolPic() {
		return toolPic;
	}

	/**
	 * 刀具图纸设定
	 * @param toolPic
	 */
	public void setToolPic(String toolPic) {
		this.toolPic = toolPic;
	}

	// 2017/09/5 宋健 追加↓↓↓　dazhong@YMSC
	public String cutterType;

	public String getCutterType() {
		return cutterType;
	}

	public void setCutterType(String cutterType) {
		this.cutterType = cutterType;
	}
	// 2017/09/5 宋健 追加↑↑↑　dazhong@YMSC
}

