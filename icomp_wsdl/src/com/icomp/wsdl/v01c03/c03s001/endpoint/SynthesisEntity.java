package com.icomp.wsdl.v01c03.c03s001.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/22 0022.
 */
public class SynthesisEntity implements Serializable {
    private static final long serialVersionUID = 1062906263661664425L;

    //材料号
    private String toolCode;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    //数量
    private int counts;
    //类型
    private String cutterType;

    public String getCutterType() {
        return cutterType;
    }

    public void setCutterType(String cutterType) {
        this.cutterType = cutterType;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

}
