package com.icomp.entity.base;

import com.icomp.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * Created by logan on 2018/5/17.
 */
public class SynthesisExchangeWhere extends BaseEntity implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    private String rfidWhere;

    public String getRfidWhere() {
        return rfidWhere;
    }

    public void setRfidWhere(String rfidWhere) {
        this.rfidWhere = rfidWhere;
    }
}
