/*
 * 工具自动生成：修复设备DAO接口
 * 生成时间    : 2014/11/12 18:19:03
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Noticeequipment;

import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface NoticeequipmentDao extends BaseDao{


    /**
     * 查询修磨设备列表
     * @return
     * @throws Exception
     * @param noticeequipment
     */
    List<Noticeequipment> getNoticelist(Noticeequipment noticeequipment)throws Exception;
}

