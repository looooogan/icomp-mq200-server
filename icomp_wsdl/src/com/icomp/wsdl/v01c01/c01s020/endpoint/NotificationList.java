package com.icomp.wsdl.v01c01.c01s020.endpoint;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/12 0012.
 */
public class NotificationList implements Serializable {
    private static final long serialVersionUID = 2776704132721946483L;

    //通知单号
    private String orderNum;
    //通知单号ID
    private String outsideFactoryID;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOutsideFactoryID() {
        return outsideFactoryID;
    }

    public void setOutsideFactoryID(String outsideFactoryID) {
        this.outsideFactoryID = outsideFactoryID;
    }
}
