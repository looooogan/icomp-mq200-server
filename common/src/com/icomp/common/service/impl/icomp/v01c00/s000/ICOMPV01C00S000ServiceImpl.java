package com.icomp.common.service.impl.icomp.v01c00.s000;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01c00.s000.ICOMPV01C00S000Service;
import com.icomp.common.utils.ExcelDown;
import com.icomp.dao.CustomerDao;
import com.icomp.dao.HandsetDao;
import com.icomp.dao.LanguagetableDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VgrantlistDao;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Handset;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vgrantlist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ICOMPV01C00S000ServiceImpl extends BaseService implements ICOMPV01C00S000Service {

    /* 用户Dao */
    private CustomerDao dao;

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    /* 用户权限Dao */
    private VgrantlistDao vgrantlistDao;

    public void setVgrantlistDao(VgrantlistDao vgrantlistDao) {
        this.vgrantlistDao = vgrantlistDao;
    }

    private LanguagetableDao languagetableDao;

    public void setLanguagetableDao(LanguagetableDao languagetableDao) {
        this.languagetableDao = languagetableDao;
    }

    private HandsetDao handsetDao;

    public void setHandsetDao(HandsetDao handsetDao) {
        this.handsetDao = handsetDao;
    }

    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    /**
     * 用户详细
     *
     * @param entity 登录用户名
     * @return 登录用户信息
     * @throws BusinessException
     */

    public Userdetail userdetail(Userdetail entity) {
        try {
            List<Userdetail> list = (List<Userdetail>) userdetailDao.searchByList(entity);
            if (list.size() <= 0) {
                //登录失败时进行用户锁定

                entity = new Userdetail();
                //检索数据行数为0,检索失败!
                entity.setMessageCode(IConstant.WMSG0003);
                entity.setRetErrFlag(true);
                return entity;
            } else {
                entity = list.get(0);
                //检索成功!
                entity.setMessageCode(IConstant.IMSG0001);
                return entity;
            }
        } catch (SQLException e) {
            entity = new Userdetail();
            entity.setRetErrFlag(true);
            //数据库操作异常,查询失败!
            entity.setMessageCode(IConstant.EMSG0002);
            entity.setExceMessage(e.getMessage());
            return entity;
        }
    }

    /**
     * 用户登录
     *
     * @param entity 登录用户名
     * @return 用户登录信息
     * @throws Exception 作成者：杨作庆
     *                   作成时间:2014-07-08 17:14
     */
    public Customer login(Customer entity) {
        List<Customer> list = new ArrayList<Customer>();
        try {
            //验证用户是否存在登录异常
            //如果锁定时间已到期，则打开锁定
            //如果锁定时间未到期，不允许登录
            if (entity.getEmployeeCard() != null) {
                //扫卡登录
                list = (List<Customer>) dao.searchByList(entity);
                if (list.size() <= 0) {
                    entity = new Customer();
                    //检索数据行数为0,检索失败!
                    entity.setMessageCode(IConstant.WMSG000_5);
                    entity.setRetErrFlag(true);
                    return entity;
                }
            } else {
                //用户输入登录
                list = (List<Customer>) dao.searchByList(entity);
                if (list.size() <= 0) {
                    entity = new Customer();
                    //检索数据行数为0,检索失败!
                    entity.setMessageCode(IConstant.WMSG0003);
                    entity.setRetErrFlag(true);
                    return entity;
                }
            }

            entity = list.get(0);
            //检索成功!
            entity.setMessageCode(IConstant.IMSG0001);
            return entity;

        } catch (SQLException e) {
            entity = new Customer();
            entity.setRetErrFlag(true);
            //数据库操作异常,查询失败!
            entity.setMessageCode(IConstant.EMSG0002);
            entity.setExceMessage(e.getMessage());
            return entity;
        }
    }

    /**
     * 取得用户权限信息
     *
     * @param entity 权限信息查询条件
     * @return 用户权限信息
     * 作成者：杨作庆
     * 作成时间:2014-07-08 17:14
     */
    public List<Vgrantlist> getUserGrant(Vgrantlist entity) {
        try {
            //取得用户权限信息
            List<Vgrantlist> list = (List<Vgrantlist>) vgrantlistDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                //该用户无可用权限,请联系系统管理员!
                list = new ArrayList<Vgrantlist>();
                Vgrantlist vgrant = new Vgrantlist();
                vgrant.setMessageCode(IConstant.EMSG0003);
                vgrant.setRetErrFlag(true);
                list.add(vgrant);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Vgrantlist> list = new ArrayList<Vgrantlist>();
            Vgrantlist vgrant = new Vgrantlist();
            vgrant.setMessageCode(IConstant.EMSG0004);
            vgrant.setRetErrFlag(true);
            vgrant.setExceMessage(e.getMessage());
            list.add(vgrant);
            return list;
        }
    }

    /**
     * 取得系统默认语言
     *
     * @param entity
     * @return
     */
    public List<Languagetable> getSysLocal(Languagetable entity) {
        try {
            //取得用户权限信息
            List<Languagetable> list = (List<Languagetable>) languagetableDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                //系统默认语言取得失败!
                list = new ArrayList<Languagetable>();
                Languagetable vgrant = new Languagetable();
                vgrant.setMessageCode(IConstant.EMSG0003);
                vgrant.setRetErrFlag(true);
                list.add(vgrant);
                return list;
            } else {
                return list;
            }

        } catch (SQLException e) {
            List<Languagetable> list = new ArrayList<Languagetable>();
            Languagetable vgrant = new Languagetable();
            vgrant.setMessageCode(IConstant.EMSG0004);
            vgrant.setRetErrFlag(true);
            vgrant.setExceMessage(e.getMessage());
            list.add(vgrant);
            return list;
        }
    }

    /**
     * 判断手持机是否注册
     *
     * @param entity
     * @return
     */
    public Map<String, Object> getHandParam(Handset entity) {
        Map<String, Object> ret = new HashMap<String, Object>();
        try {
            //取得用户权限信息
            List<Handset> list = (List<Handset>) handsetDao.searchByList(entity);
            if (list == null || list.size() <= 0) {
                ret.put("handFlag", false);
                ret.put("handSetID", "");
                ret.put("loginStauts", "");
                return ret;
            } else {
                ret.put("handSetID", list.get(0).getHandSetID());
                ret.put("handFlag", true);
                ret.put("loginStauts", list.get(0).getLoginStauts());
                return ret;
            }

        } catch (SQLException e) {
            Handset handset = new Handset();
            handset.setMessageCode(IConstant.EMSG0004);
            handset.setRetErrFlag(true);
            handset.setExceMessage(e.getMessage());
            ret.put("hand", handset);
            return ret;
        }
    }

    /**
     * 根据customerId获取用户姓名
     *
     * @param userdetail1
     * @return
     */
    @Override
    public List<Userdetail> selectUserName(Userdetail userdetail1) {
        List<Userdetail> userdetailList = null;
        try {
            userdetailList = (List<Userdetail>) userdetailDao.searchByList(userdetail1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userdetailList;
    }

    /**
     * 取得用户权限信息条数
     *
     * @param entity 权限信息查询条件
     * @return 用户权限信息
     */
    public int getUserGrantCount(Vgrantlist entity) {
        try {
            return (int) vgrantlistDao.searchByCount(entity);
        } catch (SQLException e) {
            return 0;
        }
    }
}
