package com.icomp.wsdl.v01c00.c00s000.endpoint;


import java.util.List;

import com.icomp.common.pojo.BaseRespons;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vgrantlist;

public class UserRespons extends BaseRespons {
    /**
     *
     */
    private static final long serialVersionUID = -2078516020586744184L;

    /**
     * 登录用户信息
     */
    private Customer customer;
    /**
     * 用户真实姓名
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private String userDetailName;

    public String getUserDetailName() {
        return userDetailName;
    }

    public void setUserDetailName(String userDetailName) {
        this.userDetailName = userDetailName;
    }

    /**
     * 用户权限列表
     */
    private List<Vgrantlist> vgrantlist;

    public List<Vgrantlist> getVgrantlist() {
        return vgrantlist;
    }

    public void setVgrantlist(List<Vgrantlist> vgrantlist) {
        this.vgrantlist = vgrantlist;
    }

    /**
     * 页面显示项目文本值
     */
    private List<Displayeditemconfiguration> pageLabel;

    public List<Displayeditemconfiguration> getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(List<Displayeditemconfiguration> pageLabel) {
        this.pageLabel = pageLabel;
    }

    /**
     * 系统默认语言
     */
    private Languagetable languagetable;

    public Languagetable getLanguagetable() {
        return languagetable;
    }

    public void setLanguagetable(Languagetable languagetable) {
        this.languagetable = languagetable;
    }

    public List<Languagetable> getListLanguagetable() {
        return listLanguagetable;
    }

    public void setListLanguagetable(List<Languagetable> listLanguagetable) {
        this.listLanguagetable = listLanguagetable;
    }

    /**
     * 系统语言列表
     */
    private List<Languagetable> listLanguagetable;
}
