package com.icomp.common.service.impl.icomp.v01b01.s004;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s004.ICOMPV01B01S004Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.RedemptionappliedDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VredemptionappliedDao;
import com.icomp.entity.base.Redemptionapplied;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vredemptionapplied;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 换领申请信息查询SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B01S004ServiceImpl
 * @date 2014-8-13 下午12:01:45
 */
public class ICOMPV01B01S004ServiceImpl extends BaseService implements ICOMPV01B01S004Service {

    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    @SuppressWarnings("unused")
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;
    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 换领申请DAO接口
     */
    @SuppressWarnings("unused")
    private RedemptionappliedDao redemptionappliedDao;

    public void setRedemptionappliedDao(RedemptionappliedDao redemptionappliedDao) {
        this.redemptionappliedDao = redemptionappliedDao;
    }

    private VredemptionappliedDao vredemptionappliedDao;

    public void setVredemptionappliedDao(VredemptionappliedDao vredemptionappliedDao) {
        this.vredemptionappliedDao = vredemptionappliedDao;
    }

    /**
     * 换领申请信息列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object>  getList(Vredemptionapplied entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        List<Vredemptionapplied> list = new ArrayList<Vredemptionapplied>();
        Vredemptionapplied redemptionapplied = new Vredemptionapplied();
        Userdetail userf = new Userdetail();
        try {
//            updateProcessingStatus(entity);
             list = (List<Vredemptionapplied>) vredemptionappliedDao.searchByList(entity);
            for (Vredemptionapplied vrlist : list) {
                vrlist.setToolType(String.valueOf(vrlist.getToolType().charAt(0)));

                userf.setCustomerID(vrlist.getLibraryUser());
                List<Userdetail> uslist = (List<Userdetail>)userdetailDao.searchByList(userf);
                vrlist.setLibraryUser(uslist.get(0).getUserName());
            }
            if (list.size() <= 0) {
                list = new ArrayList<Vredemptionapplied>();
                redemptionapplied.setMessageCode(IConstant.EMSG0001);
                redemptionapplied.setRetErrFlag(true);
                list.add(redemptionapplied);
                rtn.put("rows", null);
                rtn.put("error", list);
            } else {
                int total = vredemptionappliedDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
            }
        } catch (SQLException e) {
            redemptionapplied.setMessageCode(IConstant.EMSG0004);
            redemptionapplied.setRetErrFlag(true);
            redemptionapplied.setExceMessage(e.getMessage());
            list.add(redemptionapplied);
            rtn.put("rows", null);
            rtn.put("error", list);
        }
        return rtn;
    }

    /**
     * 更新已换领完成的信息
     *
     * @param entity
     * @throws SQLException
     */
    public void updateProcessingStatus(Vredemptionapplied entity) throws SQLException {
        for (Vredemptionapplied vr : (List<Vredemptionapplied>) vredemptionappliedDao.searchByList(entity)) {
            if (vr.getAppliedNumber() == null)
                vr.setAppliedNumber(BigDecimal.ZERO);
            if (vr.getReceiveNumber() == null)
                vr.setReceiveNumber(BigDecimal.ZERO);
            if (vr.getAppliedNumber().equals(vr.getReceiveNumber()) && vr.getProcessingStatus() != IConstant.PROCESSING_STATUS_4) {
                Redemptionapplied redemptionapplied = new Redemptionapplied();
                redemptionapplied.setDelFlagWhere(IConstant.DEL_FLAG_0);
            //    redemptionapplied.setRedemptionAppliedIDWhere(vr.getRedemptionAppliedID());
                redemptionapplied.setProcessingStatus(IConstant.PROCESSING_STATUS_4);
                redemptionappliedDao.updateNonQuery(redemptionapplied);
            }
        }
    }

    @Override
    public Map<String, Object> getprintItemInfo(Vredemptionapplied entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Vredemptionapplied> list = (List<Vredemptionapplied>) vredemptionappliedDao.searchByList(entity);
            if (list.size() <= 0) {
                Vredemptionapplied vredemptionapplied = new Vredemptionapplied();
                //消息：检索为0
                vredemptionapplied.setMessageCode(IConstant.EMSG0001);
                vredemptionapplied.setRetErrFlag(true);
                rtn.put("data", null);
                rtn.put("error", vredemptionapplied);
                rtn.put("status",-2);
                return rtn;
            } else {
                rtn.put("data", list.get(0));
                rtn.put("status",0);
                return rtn;
            }

        } catch (SQLException e) {
            Vredemptionapplied vredemptionapplied = new Vredemptionapplied();
            //错误消息：数据库操作异常，查询失败!
            vredemptionapplied.setMessageCode(IConstant.EMSG0004);
            vredemptionapplied.setRetErrFlag(true);
            vredemptionapplied.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", vredemptionapplied);
            return rtn;
        }
    }

    @Override
    public String getVreNumber() {
        int total=0;
        try {
           total = vredemptionappliedDao.searchByCount(new Vredemptionapplied());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(total);
    }
}
