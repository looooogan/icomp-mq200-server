package com.icomp.entity.base;

import java.io.Serializable;

/**
 * 记录
 */
public class ScanGrinding implements Serializable {
    private static final long serialVersionUID = 6602717772346181525L;
    //刀具编码
    private String toolCode;
    //刀具类型(0:钻头1可刃磨2一次性)
    String toolType;
    //数量
    private String numbers;
    //当前状态(0:报废,1.丢刀,2.复磨)
    private String thisStaic;

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getThisStaic() {
        return thisStaic;
    }

    public void setThisStaic(String thisStaic) {
        this.thisStaic = thisStaic;
    }
}
