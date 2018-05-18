package com.icomp.wsdl.v01c01.c01s010.endpoint;

import com.icomp.common.pojo.BaseRequest;
import com.icomp.wsdl.v01c01.c01s001.endpoint.InputTool;

import java.util.List;

/**
 * 刀具换装-请求参数
 *
 * @author Taoyy
 * @ClassName: C01S010Request
 * @date 2016-2-26 下午6:11:36
 */
public class C01S010Request extends BaseRequest {

    private static final long serialVersionUID = 6602717772346187110L;

    //RFID标签
    private String rfidCode;

    public String getRfidCode() {
        return rfidCode;
    }

    public void setRfidCode(String rfidCode) {
        this.rfidCode = rfidCode;
    }

    //标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
    private String queryType;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    //合成刀具RFID
    private String synthesisParametersRfid;

    public String getSynthesisParametersRfid() {
        return synthesisParametersRfid;
    }

    public void setSynthesisParametersRfid(String synthesisParametersRfid) {
        this.synthesisParametersRfid = synthesisParametersRfid;
    }

    //单品刀具RFID
    private String singleToolRfid;

    public String getSingleToolRfid() {
        return singleToolRfid;
    }

    public void setSingleToolRfid(String singleToolRfid) {
        this.singleToolRfid = singleToolRfid;
    }

    //用户ID
    private String customerID;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    //容器RFID
    private String containerRfid;

    public String getContainerRfid() {
        return containerRfid;
    }

    public void setContainerRfid(String containerRfid) {
        this.containerRfid = containerRfid;
    }

    /* 保存入库信息列表 */
    private List<InputTool> inputToolList;

    public List<InputTool> getInputToolList() {
        return inputToolList;
    }

    public void setInputToolList(List<InputTool> inputToolList) {
        this.inputToolList = inputToolList;
    }

    private List<GrindingBitInfo> grindingBitInfo;
    private String synthesisParametersCode;

    public List<GrindingBitInfo> getGrindingBitInfo() {
        return grindingBitInfo;
    }

    public void setGrindingBitInfo(List<GrindingBitInfo> grindingBitInfo) {
        this.grindingBitInfo = grindingBitInfo;
    }

    public String getSynthesisParametersCode() {
        return synthesisParametersCode;
    }

    public void setSynthesisParametersCode(String synthesisParametersCode) {
        this.synthesisParametersCode = synthesisParametersCode;
    }

    private List<ToolScrapInfo> toolScrapInfos;

    public List<ToolScrapInfo> getToolScrapInfos() {
        return toolScrapInfos;
    }

    public void setToolScrapInfos(List<ToolScrapInfo> toolScrapInfos) {
        this.toolScrapInfos = toolScrapInfos;
    }

    /* 提交丢刀，报废信息集合 */
    private List<ScanGrindingMsg> scrapMsgs;

    public List<ScanGrindingMsg> getScrapMsgs() {
        return scrapMsgs;
    }

    public void setScrapMsgs(List<ScanGrindingMsg> scrapMsgs) {
        this.scrapMsgs = scrapMsgs;
    }

    /*提交可刃磨刀片集合*/
    private List<ScanGrindingMsg> grindingMsgs;

    public List<ScanGrindingMsg> getGrindingMsgs() {
        return grindingMsgs;
    }

    public void setGrindingMsgs(List<ScanGrindingMsg> grindingMsgs) {
        this.grindingMsgs = grindingMsgs;
    }

    /* 提交可刃磨钻头集合 */
    private List<GrindingBitMsg> grindingBitMsgs;

    public List<GrindingBitMsg> getGrindingBitMsgs() {
        return grindingBitMsgs;
    }

    public void setGrindingBitMsgs(List<GrindingBitMsg> grindingBitMsgs) {
        this.grindingBitMsgs = grindingBitMsgs;
    }

    /* 报废容器Rfid */
    private String scrapContainerRfid;

    public String getScrapContainerRfid() {
        return scrapContainerRfid;
    }

    public void setScrapContainerRfid(String scrapContainerRfid) {
        this.scrapContainerRfid = scrapContainerRfid;
    }

    /* 刃磨容器Rfid */
    private String grindingContainerRfid;

    public String getGrindingContainerRfid() {
        return grindingContainerRfid;
    }

    public void setGrindingContainerRfid(String grindingContainerRfid) {
        this.grindingContainerRfid = grindingContainerRfid;
    }

    /* 刀具id */
    private String toolID;

    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    /* 换装时不卸下刀具的标识（0代表没有卸下任何刀具） */
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private List<String> rfidCodeList;
    private String toolType;

    public List<String> getRfidCodeList() {
        return rfidCodeList;
    }

    public void setRfidCodeList(List<String> rfidCodeList) {
        this.rfidCodeList = rfidCodeList;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }
}
