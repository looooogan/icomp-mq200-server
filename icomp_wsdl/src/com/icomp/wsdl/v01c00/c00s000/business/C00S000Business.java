package com.icomp.wsdl.v01c00.c00s000.business;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Userdetail;
import com.icomp.wsdl.v01c00.c00s000.endpoint.HandRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.HandRespons;
import com.icomp.wsdl.v01c00.c00s000.endpoint.LocalRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.LocalRespons;
import com.icomp.wsdl.v01c00.c00s000.endpoint.MenuRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.MenuRespons;
import com.icomp.wsdl.v01c00.c00s000.endpoint.UserRequest;
import com.icomp.wsdl.v01c00.c00s000.endpoint.UserRespons;

import java.util.List;

public interface C00S000Business {
    /**
     * 用户初始化
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    public UserRespons systemInit(UserRequest request) throws BusinessException;

    /**
     * 用户授权
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    public UserRespons userGruant(UserRequest request) throws BusinessException;

    /**
     * 用户信息取得
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    public UserRespons userInfo(UserRequest request) throws BusinessException;

    /**
     * 取得用户菜单
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    public MenuRespons getMenu(MenuRequest request) throws BusinessException;

    /**
     * 获取系统默认语言
     *
     * @return
     * @throws BusinessException
     */
    public LocalRespons getSysLocal(LocalRequest request) throws BusinessException;

    /**
     * 判断当前手持机是否注册
     *
     * @param request
     * @return
     * @throws Exception
     */
    public HandRespons getHandParam(HandRequest request) throws BusinessException;

    /**
     * 查询当前登录的用户姓名
     *
     * @param userdetail
     * @return
     */

    List<Userdetail> selectUserName(String customerId) throws BusinessException;
}
