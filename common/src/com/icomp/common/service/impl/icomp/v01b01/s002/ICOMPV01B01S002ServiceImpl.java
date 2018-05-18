package com.icomp.common.service.impl.icomp.v01b01.s002;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b01.s002.ICOMPV01B01S002Service;
import com.icomp.dao.DisplayeditemconfigurationDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.dao.VtoollibraryhistoryDao;
import com.icomp.entity.base.Userdetail;
import com.icomp.entity.base.Vtoollibraryhistory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出库信息查询SERVICE实现类
 *
 * @author Taoyy
 * @ClassName: ICOMPV01B01S002ServiceImpl
 * @date 2014-8-14 下午02:32:26
 */
public class ICOMPV01B01S002ServiceImpl extends BaseService implements ICOMPV01B01S002Service {

    /**
     * 系统显示项目配置(兼顾打印项目)
     */
    @SuppressWarnings("unused")
    private DisplayeditemconfigurationDao displayeditemconfigurationDao;
    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    public void setDisplayeditemconfigurationDao(
            DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    /**
     * 出库信息查询DAO
     */
    private VtoollibraryhistoryDao vtoollibraryhistoryDao;


    public void setVtoollibraryhistoryDao(VtoollibraryhistoryDao vtoollibraryhistoryDao) {
        this.vtoollibraryhistoryDao = vtoollibraryhistoryDao;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 出库信息查询列表-模糊查询
     */
    public Map<String, Object> getList(Vtoollibraryhistory entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
            Vtoollibraryhistory vleavefactory = new Vtoollibraryhistory();
            Userdetail user= new Userdetail();

        try {

//            根据条件查出出库列表
            List<Vtoollibraryhistory> list = (List<Vtoollibraryhistory>) vtoollibraryhistoryDao.searchByList(entity);

            if (list.size() <= 0) {
                list = new ArrayList<Vtoollibraryhistory>();
                vleavefactory.setMessageCode(IConstant.EMSG0001);
                vleavefactory.setRetErrFlag(true);
                list.add(vleavefactory);
                rtn.put("rows", null);
                rtn.put("error", list);
            } else {
//                查出共有多少条符合条件
                for (Vtoollibraryhistory vlist : list) {
                    vlist.setToolType(String.valueOf(vlist.getToolCode().charAt(0)));
                    Userdetail userentity = new Userdetail();
                    userentity.setCustomerID(vlist.getReceiveUser());
                    List<Userdetail> userlist =(List<Userdetail>) userdetailDao.searchByList(userentity);
                    if(userlist.size()==0){
                        vlist.setReceiveUser(vlist.getReceiveUser());
                    }else {
                        vlist.setReceiveUser(userlist.get(0).getUserName());
                    }
                }
                int total = vtoollibraryhistoryDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
            }
            return rtn;
        } catch (SQLException e) {
            List<Vtoollibraryhistory> list = new ArrayList<Vtoollibraryhistory>();
            vleavefactory.setMessageCode(IConstant.EMSG0004);
            vleavefactory.setRetErrFlag(true);
            vleavefactory.setExceMessage(e.getMessage());
            list.add(vleavefactory);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
    }

    @Override
    public String getNumber() {
        int total=0;
        try {
             total = vtoollibraryhistoryDao.searchByCount(new Vtoollibraryhistory());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return String.valueOf(total);
    }

}
