package com.icomp.common.service.icomp.v01c00.s000;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Handset;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vgrantlist;

public interface ICOMPV01C00S000Service {
    /**
     * 用户登录
     *
     * @param entity 登录用户名
     * @return 登录用户信息
     * @throws BusinessException
     */
    public Customer login(Customer entity);

    /**
     * 用户详细
     *
     * @param entity 登录用户名
     * @return 登录用户信息
     * @throws BusinessException
     */
    public Userdetail userdetail(Userdetail entity);

    /**
     * 取得用户权限信息
     *
     * @param entity 权限信息查询条件
     * @return 用户权限信息
     */
    public List<Vgrantlist> getUserGrant(Vgrantlist entity);

    /**
     * 取得用户权限信息条数
     *
     * @param entity 权限信息查询条件
     * @return 用户权限信息
     */
    public int getUserGrantCount(Vgrantlist entity);

    /**
     * 取得系统默认语言
     *
     * @param entity
     * @return
     */
    public List<Languagetable> getSysLocal(Languagetable entity);

    /**
     * 判断手持机是否注册
     *
     * @param entity
     * @return
     */
    public Map<String, Object> getHandParam(Handset entity);

    /**
     * 根据customerId获取用户姓名
     *
     * @param userdetail1
     * @return
     */
    List<Userdetail> selectUserName(Userdetail userdetail1);
}
