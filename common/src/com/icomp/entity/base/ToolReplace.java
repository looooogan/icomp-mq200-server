package com.icomp.entity.base;

import java.io.Serializable;

/**
 * Created by logan on 2018/5/14.
 */
public class ToolReplace extends ToolReplaceWhere implements Serializable{

    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    // 标识列
    private Integer toolReplaceID;
    // 合成刀具参数id
    private String synthesisParametersID;
    // 材料刀参数id
    private String toolCode;
    // 替换材料刀具id
    private String repalceToolCode;
    // 逻辑删除 0未删除 1已删除
    private String isDel;




    public Integer getToolReplaceID() {
        return toolReplaceID;
    }

    public void setToolReplaceID(Integer toolReplaceID) {
        this.toolReplaceID = toolReplaceID;
    }

    public String getSynthesisParametersID() {
        return synthesisParametersID;
    }

    public void setSynthesisParametersID(String synthesisParametersID) {
        this.synthesisParametersID = synthesisParametersID;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getRepalceToolCode() {
        return repalceToolCode;
    }

    public void setRepalceToolCode(String repalceToolCode) {
        this.repalceToolCode = repalceToolCode;
    }
}
