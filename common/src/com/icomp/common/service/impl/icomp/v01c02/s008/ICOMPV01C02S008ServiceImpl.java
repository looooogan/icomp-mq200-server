package com.icomp.common.service.impl.icomp.v01c02.s008;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01c02.s008.ICOMPV01C02S008Service;
import com.icomp.dao.CustomerDao;
import com.icomp.entity.base.Customer;

import java.sql.SQLException;
import java.util.List;

public class ICOMPV01C02S008ServiceImpl extends BaseService implements ICOMPV01C02S008Service {

    /* 用户Dao */
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 员工卡绑定处理
     *
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
    public Customer saveUserBinding(Customer entity) {
        try {
            Customer customer = new Customer();
            Customer ret = new Customer();

             // 检查当前卡号是否已绑定、
            customer.setEmployeeCard(entity.getEmployeeCard());
            customer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Customer> list = (List<Customer>) customerDao.searchByList(customer);
            if (list.size() > 0) {
                // 您当前绑定的卡号已绑定,请不要重复绑定！
                ret = new Customer();
                ret.setMessageCode(IConstant.WMSG0157_1);
                ret.setRetErrFlag(true);
                return ret;
            }
             // 检查当前用户是否已绑定、
              customer = new Customer();
            customer.setUserName(entity.getUserName());
            customer.setDelFlag(IConstant.DEL_FLAG_0);
            List<Customer> list1 = (List<Customer>) customerDao.searchByList(customer);
            if (list1.size() > 0 && list1.get(0).getEmployeeCard() != null && !("".equals(list1.get(0).getEmployeeCard().trim()))) {
                // 您当前绑定的用户已绑定,如需继续绑定请联系系统管理员！
                ret.setMessageCode(IConstant.WMSG0157);
                ret.setRetErrFlag(true);
                return ret;
            } else if (list1.size() < 1) {
                ret.setMessageCode(IConstant.WMSG0157_2);
                ret.setRetErrFlag(true);
                return ret;
            }

            // 进行用户绑定
            customer = list1.get(0);
            entity.setCustomerIDWhere(customer.getCustomerID());
            customerDao.updateNonQuery(entity);
            return entity;

        } catch (SQLException e) {
            Customer ret = new Customer();
            ret.setMessageCode(IConstant.EMSG0004);
            ret.setRetErrFlag(true);
            ret.setExceMessage(e.getMessage());
            return ret;
        }
    }
}
