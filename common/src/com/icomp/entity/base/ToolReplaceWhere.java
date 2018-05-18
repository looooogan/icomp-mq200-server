package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * Created by logan on 2018/5/14.
 */
public class ToolReplaceWhere extends BaseEntity implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    /* 合成刀具参数ID	*/
    private String synthesisParametersIDWhere;

    /* 材料刀ID	*/
    private String toolIDWhere;

    public String getSynthesisParametersIDWhere() {
        return synthesisParametersIDWhere;
    }

    public void setSynthesisParametersIDWhere(String synthesisParametersIDWhere) {
        this.synthesisParametersIDWhere = synthesisParametersIDWhere;
    }

    public String getToolIDWhere() {
        return toolIDWhere;
    }

    public void setToolIDWhere(String toolIDWhere) {
        this.toolIDWhere = toolIDWhere;
    }
}
