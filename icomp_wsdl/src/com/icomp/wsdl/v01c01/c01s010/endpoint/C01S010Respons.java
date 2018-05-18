package com.icomp.wsdl.v01c01.c01s010.endpoint;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.wsdl.v01c03.c03s001.endpoint.SynthesisEntity;

import java.util.List;

/**
 * 刀具换装-返回参数
 * @ClassName: C01S010Respons 
 * @author Taoyy
 * @date 2016-2-26 下午6:12:16
 */
public class C01S010Respons extends BaseRespons {

	private static final long serialVersionUID = 345079680189123767L;
	
	// 刀具List
	private List<OutputTool> outputTool;
	private List<SynthesisEntity> inputToolList;

	public List<SynthesisEntity> getInputToolList() {
		return inputToolList;
	}

	public void setInputToolList(List<SynthesisEntity> inputToolList) {
		this.inputToolList = inputToolList;
	}

	public List<OutputTool> getOutputTool() {
		return outputTool;
	}

	public void setOutputTool(List<OutputTool> outputTool) {
		this.outputTool = outputTool;
	}

	// 合成刀具类型（0热套，1复合刀具）
	private String synthesisParametersType;
	
	public String getSynthesisParametersType() {
		return synthesisParametersType;
	}

	public void setSynthesisParametersType(String synthesisParametersType) {
		this.synthesisParametersType = synthesisParametersType;
	}
	
	// 合成刀具ID
	private String synthesisParametersID;
	
	public String getSynthesisParametersID() {
		return synthesisParametersID;
	}

	public void setSynthesisParametersID(String synthesisParametersID) {
		this.synthesisParametersID = synthesisParametersID;
	}
	
	// 合成刀具编码
	private String synthesisParametersCode;
	
	public String getSynthesisParametersCode() {
		return synthesisParametersCode;
	}

	public void setSynthesisParametersCode(String synthesisParametersCode) {
		this.synthesisParametersCode = synthesisParametersCode;
	}
	
	// 刀具ID(单品刀)
	private String toolID;
	private String toolCode;

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolID() {
		return toolID;
	}

	public void setToolID(String toolID) {
		this.toolID = toolID;
	}

	private  List<GrindingBitInfo> grindingBitInfo;

	public List<GrindingBitInfo> getGrindingBitInfo() {
		return grindingBitInfo;
	}

	public void setGrindingBitInfo(List<GrindingBitInfo> grindingBitInfo) {
		this.grindingBitInfo = grindingBitInfo;
	}
	private List<ToolScrapInfo> toolScrapInfos;

	public List<ToolScrapInfo> getToolScrapInfos() {
		return toolScrapInfos;
	}

	public void setToolScrapInfos(List<ToolScrapInfo> toolScrapInfos) {
		this.toolScrapInfos = toolScrapInfos;
	}
}
