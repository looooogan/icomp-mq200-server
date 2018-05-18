/*
 * 工具自动生成：用户表DAO接口
 * 生成时间    : 2014/08/11 15:35:17
 */
package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * 继承父接口
 * @author 工具自动生成
 *
 */
public interface CustomerDao extends BaseDao{


    int insertBatch(Customer c)throws Exception;
    List<Customer> searchByEmployee(Customer customer) throws Exception;

    int updateBatchByRFIdLists(List<String> list) throws SQLException;

    /**
     * 通过userID查询当前人员的信息
     * @param cu
     * @return
     * @throws Exception
     */
    Customer searchDetelByUserID(Customer cu) throws SQLException;
}

