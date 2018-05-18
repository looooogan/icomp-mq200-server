package com.icomp.wsdl.v01c01.c01s024.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class TypeEntity implements Serializable {
    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    //名称
    private String typeName;
    //类型数量
    private String typeCount;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(String typeCount) {
        this.typeCount = typeCount;
    }
}
