package com.icomp.common.service.impl.icomp.v01b06.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.service.icomp.v01b06.s005.ICOMPV01B06S005Service;
import com.icomp.dao.DistributionDao;
import com.icomp.dao.VtoolrealtimedistributionDao;
import com.icomp.entity.base.Distribution;
import com.icomp.entity.base.Vtoolrealtimedistribution;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  刀具实时分布状况SERVICES实现类
 * @ClassName: ICOMPV01B06S005ServiceImpl
 * @author Taoyy
 * @date 2014-8-22 上午10:03:11
 */
@SuppressWarnings("unchecked")
public class ICOMPV01B06S005ServiceImpl extends BaseService implements ICOMPV01B06S005Service {

    /**
     * 刀具实时分布状况DAO
     */
    private VtoolrealtimedistributionDao vtoolrealtimedistributionDao;
    private  DistributionDao distributionDao;

    public void setDistributionDao(DistributionDao distributionDao) {
        this.distributionDao = distributionDao;
    }

    public void setVtoolrealtimedistributionDao(VtoolrealtimedistributionDao vtoolrealtimedistributionDao) {
        this.vtoolrealtimedistributionDao = vtoolrealtimedistributionDao;
    }


    public Map<String, Object> getList(Vtoolrealtimedistribution entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            //任意条件查询-toolCode模糊查询
            List<Vtoolrealtimedistribution> list = (List<Vtoolrealtimedistribution>) vtoolrealtimedistributionDao.searchByList(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Vtoolrealtimedistribution>();
                Vtoolrealtimedistribution vtoolrealtimedistribution = new Vtoolrealtimedistribution();
                vtoolrealtimedistribution.setMessageCode(IConstant.EMSG0001);
                vtoolrealtimedistribution.setRetErrFlag(true);
                list.add(vtoolrealtimedistribution);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;
            } else {
                int total = vtoolrealtimedistributionDao.searchByCount(entity);

                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
                return rtn;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            List<Vtoolrealtimedistribution> list = new ArrayList<Vtoolrealtimedistribution>();
            Vtoolrealtimedistribution vtoolrealtimedistribution = new Vtoolrealtimedistribution();
            vtoolrealtimedistribution.setMessageCode(IConstant.EMSG0004);
            vtoolrealtimedistribution.setRetErrFlag(true);
            vtoolrealtimedistribution.setExceMessage(e.getMessage());
            list.add(vtoolrealtimedistribution);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
    }

    @Override
    public Map<String, Object> getLists(Distribution entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            //任意条件查询-toolCode模糊查询
            List<Distribution> list = (List<Distribution>) distributionDao.searchByList(entity);
            for (Distribution dlist : list) {
                dlist.setToolType(String.valueOf(dlist.getToolType().charAt(0)));
                if(dlist.getExpandSpace1()==null){
                    dlist.setExpandSpace1("0");
                }else {
                    dlist.setExpandSpace1(dlist.getExpandSpace1());
                }
            }
            if (list.size() <= 0) {
                list = new ArrayList<Distribution>();
                Distribution distribution = new Distribution();
                distribution.setMessageCode(IConstant.EMSG0001);
                distribution.setRetErrFlag(true);
                list.add(distribution);
                rtn.put("rows", null);
                rtn.put("error", list);
                return rtn;
            } else {

                int total = distributionDao.searchByCount(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            List<Distribution> list = new ArrayList<Distribution>();
            Distribution distribution = new Distribution();
            distribution.setMessageCode(IConstant.EMSG0004);
            distribution.setRetErrFlag(true);
            distribution.setExceMessage(e.getMessage());
            list.add(distribution);
            rtn.put("rows", null);
            rtn.put("error", list);

        }
        return rtn;
    }

    @Override
    public String getStatisticalCount(Distribution entity) {
        Double dou = 0.0, dou1 = 0.0,  dou3 = 0.0, dou4 = 0.0, dou5 = 0.0,dou7 = 0.0,dou8 = 0.0;
        List<Distribution> list = null;
        try {
            for (Distribution ca : (List<Distribution>) distributionDao.searchByList(entity)){
                //（厂内）
                if (StringUtils.isEmpty(ca.getNumberDevices())){
                    ca.setNumberDevices(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getNumberDevices())){
                    ca.setNumberDevices(IConstant.DEL_FLAG_0);
                }
                dou += Double.parseDouble(ca.getNumberDevices());
                //厂外
                if (StringUtils.isEmpty(ca.getNumberDevices1())){
                    ca.setNumberDevices1(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getNumberDevices1())){
                    ca.setNumberDevices1(IConstant.DEL_FLAG_0);
                }
                dou1 += Double.parseDouble(ca.getNumberDevices1());
                // 2017/08/31 宋健 变更↓↓↓　dazhong@YMSC
                //（待送回）
//				if (StringUtils.isEmpty(ca.getNumberDevices2())){
//					ca.setNumberDevices2(IConstant.DEL_FLAG_0);
//				}
//				dou2 += Double.parseDouble(ca.getNumberDevices2());
                //（厂外修磨）
                if (StringUtils.isEmpty(ca.getNumberDevices3())){
                    ca.setNumberDevices3(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getNumberDevices3())){
                    ca.setNumberDevices3(IConstant.DEL_FLAG_0);
                }
                dou3 += Double.parseDouble(ca.getNumberDevices3());
                //（对刀间）
                if (StringUtils.isEmpty(ca.getNumberDevices4())) {
                    ca.setNumberDevices4(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getNumberDevices4())){
                    ca.setNumberDevices4(IConstant.DEL_FLAG_0);
                }
                dou4 += Double.parseDouble(ca.getNumberDevices4());
                //（车间）
                if (StringUtils.isEmpty(ca.getNumberDevices5())) {
                    ca.setNumberDevices5(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getNumberDevices5())){
                    ca.setNumberDevices5(IConstant.DEL_FLAG_0);
                }
                dou5 += Double.parseDouble(ca.getNumberDevices5());
                //（报废）
//				if (StringUtils.isEmpty(ca.getNumberDevices6())) {
//					ca.setNumberDevices6(IConstant.DEL_FLAG_0);
//				}
//				dou6 += Double.parseDouble(ca.getNumberDevices6());

                if (StringUtils.isEmpty(ca.getNumberDevices6())) {
                    ca.setNumberDevices6(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getNumberDevices6())){
                    ca.setNumberDevices6(IConstant.DEL_FLAG_0);
                }
                dou7 += Double.parseDouble(ca.getNumberDevices6());

                if (StringUtils.isEmpty(ca.getExpandSpace1())) {
                    ca.setExpandSpace1(IConstant.DEL_FLAG_0);
                }
                if("-".equals(ca.getExpandSpace1())){
                    ca.setExpandSpace1(IConstant.DEL_FLAG_0);
                }
                dou8 += Double.parseDouble(ca.getExpandSpace1());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dou+","+dou1+","+dou3+","+dou4+","+dou5+","+dou7+","+dou8;
        // 2017/08/31 宋健 变更↑↑↑　dazhong@YMSC

    }

    @Override
    public String getNumber() {
        int total =0;
        try {
            total= distributionDao.searchByCount(new Distribution());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(total);
    }


}
