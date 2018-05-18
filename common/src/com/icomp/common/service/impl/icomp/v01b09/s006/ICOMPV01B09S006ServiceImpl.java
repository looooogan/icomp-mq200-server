package com.icomp.common.service.impl.icomp.v01b09.s006;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b09.s006.ICOMPV01B09S006Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.ToolDao;
import com.icomp.dao.TooloptimizationDao;
import com.icomp.dao.UserdetailDao;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Tooloptimization;
import com.icomp.entity.base.Userdetail;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class ICOMPV01B09S006ServiceImpl extends BaseService implements ICOMPV01B09S006Service {

    private TooloptimizationDao tooloptimizationDao;
    private ToolDao toolDao;
    private UserdetailDao userdetailDao;

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setTooloptimizationDao(TooloptimizationDao tooloptimizationDao) {
        this.tooloptimizationDao = tooloptimizationDao;

    }

    public Map<String, Object> getList(Tooloptimization entity) {

    Map<String, Object> rtn = new HashMap<String, Object>();
    try {
        List<Tooloptimization> list = (List<Tooloptimization>) tooloptimizationDao.searchByList(entity);
        if (list.size() <= 0) {
            list = new ArrayList<Tooloptimization>();
            Tooloptimization tooloptimization = new Tooloptimization();
            tooloptimization.setMessageCode(IConstant.EMSG0001);
            tooloptimization.setRetErrFlag(true);
            list.add(tooloptimization);
            rtn.put("rows", null);
            rtn.put("error", list);

        } else {

            int total = tooloptimizationDao.searchByCount(entity);
            rtn.put("rows", list);
            rtn.put("total", total);
            rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

        }

    } catch (SQLException e) {
        List<Tooloptimization> list = new ArrayList<Tooloptimization>();
        Tooloptimization tooloptimization = new Tooloptimization();
        tooloptimization.setMessageCode(IConstant.EMSG0004);
        tooloptimization.setRetErrFlag(true);
        tooloptimization.setExceMessage(e.getMessage());
        list.add(tooloptimization);
        rtn.put("rows", null);
        rtn.put("error", list);

    }
        return rtn;
}
    public Map<String, Object> optimizationAdd(Tooloptimization tooloptimization, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            tooloptimizationDao.insert(tooloptimization);
            //成功消息：插入成功
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0004, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);

        } catch (SQLException e) {
            Tooloptimization entity = new Tooloptimization();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode(IConstant.EMSG0007);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);

        }
        return rtn;
    }
    public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, int checkType,String userId) throws BusinessException {
       // 返回值
        try {
        Map<String, Object> rtn = new HashMap<String, Object>();
        // 错误信息
       Map<String, String> map = new HashMap<String, String>();
        Tooloptimization entity = new Tooloptimization();
//            // 页面名称
            if (StringUtils.isEmpty(param.get("DivToolCode").toString())) {
                map.put("DivToolCode", MessageReSource.getMessageBox(
                        IConstant.DJYH01, langCode, langValue));
            }else{
                Tool tool = new Tool();
                tool.setToolCode(param.get("DivToolCode").toString());

                   List<Tool> tool1  =(List<Tool>) toolDao.searchByList(tool);
                if(tool1.size()==0){
                    map.put("DivToolCode", MessageReSource.getMessageBox(
                            IConstant.DJYH04, langCode, langValue));
                }else {
                    entity.setToolCode(param.get("DivToolCode").toString());
                    entity.setToolID(tool1.get(0).getToolID());
                }

            }

            if (StringUtils.isEmpty(param.get("DivNote").toString())) {
                map.put("DivNote", MessageReSource.getMessageBox(
                        IConstant.DJYH02, langCode, langValue));
            }else{
                entity.setNoteFile(param.get("DivNote").toString());
            }

            if (checkType == 1){
            if (map.size() <= 0) {
                Userdetail us = new Userdetail();
                us.setCustomerID(userId);
                List<Userdetail> usList =( List<Userdetail>) userdetailDao.searchByList(us);
                entity.setCreateUser(usList.get(0).getUserName());
                entity.setVersion(BigDecimal.ZERO);// 版本号
                entity.setOptimizationID(NextKeyValue.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION, IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity.getUpdateUser()));// 取得主键
                entity.setCreateTime(new Date());// 创建时间
                entity.setDelFlag(IConstant.DEL_FLAG_0);
                entity.setUpdateTime(new Date());// 更新时间
                rtn.put("data", entity);
                rtn.put("status", IConstant.RESULT_CODE_1);

            } else {
                rtn.put("message", map);
                rtn.put("status", IConstant.RESULT_CODE_2);
                rtn.put("data", null);
            }

        } else if (checkType == 2) {
//            // 如果是编辑

            if (map.size() <= 0) {

//                entity.setUpdateUser(userID);
                entity.setUpdateTime(new Date());
                entity.setOptimizationIDWhere(param.get("DivOptimizationID").toString());
                entity.setVersionWhere(new BigDecimal(param.get("DIVDelFlag").toString()));
//                entity.setUpdateUserWhere(param.get("DivUpdateUser").toString());
//                entity.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
                rtn.put("data", entity);
                rtn.put("status", IConstant.RESULT_CODE_1);
            } else {
                rtn.put("message", map);
                rtn.put("status", IConstant.RESULT_CODE_2);
            }
        }

            return rtn;

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public Map<String, Object> getToolOpKey(Tooloptimization entity) {
        Map<String,Object> rtn = new  HashMap<String,Object>();
        try {
            List<Tooloptimization> list = (List<Tooloptimization>) tooloptimizationDao.searchByList(entity);

            for (Tooloptimization tplist : list) {
                if (tplist.getApplicationFileName()==null|| "".equals(tplist.getApplicationFileName())){

                }else {
                    tplist.setExpandSpace1(tplist.getApplicationFileName().substring(37));
                }
                if (tplist.getExperimentalFileName()==null || "".equals(tplist.getExperimentalFileName())){

                }else {
                    tplist.setExpandSpace3(tplist.getExperimentalFileName().substring(37));
                }
                if (tplist.getTechnicalFileName()==null|| "".equals(tplist.getTechnicalFileName())){

                }else {
                    tplist.setExpandSpace2(tplist.getTechnicalFileName().substring(37));
                }
                if (tplist.getReportFileName()==null || "".equals(tplist.getReportFileName())){

                }else {
                    tplist.setExpandSpace4(tplist.getReportFileName().substring(37));
                }

            }


            if (list.size() <= 0) {
                Tooloptimization tooloptimization = new Tooloptimization();
                //消息：检索为0
                tooloptimization.setMessageCode(IConstant.EMSG0001);
                tooloptimization.setRetErrFlag(true);
                rtn.put("data", null);
                rtn.put("error", tooloptimization);
                rtn.put("status",-2);
                return rtn;

            } else {
                rtn.put("data", list.get(0));
                rtn.put("status",0);
                return rtn;
            }

        } catch (SQLException e) {
            Tooloptimization tooloptimization = new Tooloptimization();
            //错误消息：数据库操作异常，查询失败!
            tooloptimization.setMessageCode(IConstant.EMSG0004);
            tooloptimization.setRetErrFlag(true);
            tooloptimization.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", tooloptimization);
            return rtn;
        }

    }

    @Override
    public Map<String, Object> optimizationEdit(Tooloptimization entity, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            // 删除失败! 进行数据排他验证
            Tooloptimization tooloptimization = new Tooloptimization();
            tooloptimization.setOptimizationID(entity.getOptimizationID());
//            tooloptimization.setUpdateTime(entity.getUpdateTimeWhere());
//            tooloptimization.setUpdateUser(entity.getUpdateUserWhere());
            List<Tooloptimization> list = (List<Tooloptimization>) tooloptimizationDao.searchByList(tooloptimization);
            if (list == null || list.size() == 0) {
                entity = new Tooloptimization();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);

            }
            // 更新项目打印成功
            @SuppressWarnings("unused")
            int ret = tooloptimizationDao.updateNonQuery(entity);
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0005, langCode,  langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);


        } catch (SQLException e) {
            Tooloptimization tooloptimization = new Tooloptimization();
            //错误消息：数据库操作异常，更新失败!
            tooloptimization.setMessageCode(IConstant.EMSG0006);
            tooloptimization.setRetErrFlag(true);
            tooloptimization.setExceMessage(e.getMessage());
            rtn.put("error", tooloptimization);
            rtn.put("data", null);

        }
        return rtn;
    }

    @Override
    public List<Tooloptimization> getToolopList() throws BusinessException {
        List<Tooloptimization> list = null;
        try {
            Tooloptimization entity = new Tooloptimization();
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            list = (List<Tooloptimization>) tooloptimizationDao.searchByList(entity);
            if (list.size() <= 0) {
                list = new ArrayList<Tooloptimization>();
                Tooloptimization parts = new Tooloptimization();
                // 消息：检索为0
                parts.setMessageCode(IConstant.EMSG0001);
                parts.setRetErrFlag(false);
                list.add(parts);
            }
            return list;
        } catch (SQLException e) {
            list = new ArrayList<Tooloptimization>();
            Tooloptimization tooloptimization = new Tooloptimization();
            // 错误消息：数据库操作异常，查询失败!
            tooloptimization.setMessageCode(IConstant.EMSG0004);
            tooloptimization.setRetErrFlag(true);
            tooloptimization.setExceMessage(e.getMessage());
            list.add(tooloptimization);

        }
        return list;
    }

    @Override
    public Map<String, Object> potimizationDel(Tooloptimization entity, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 删除失败! 进行数据排他验证
            Tooloptimization tooloptimization = new Tooloptimization();
            tooloptimization.setOptimizationID(entity.getOptimizationIDWhere());
            //entity.setUpdateTime(position.getUpdateTimeWhere());
            //entity.setUpdateUser(position.getUpdateUserWhere());

            List<Tooloptimization> list = (List<Tooloptimization>) tooloptimizationDao.searchByList(tooloptimization);
            if (list == null || list.size() == 0) {
                tooloptimization = new Tooloptimization();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                tooloptimization.setMessageCode(IConstant.WMSG0009);
                tooloptimization.setRetErrFlag(true);
                rtn.put("error", tooloptimization);
                rtn.put("data", null);
                return rtn;
            }
            // 删除成功
            @SuppressWarnings("unused")
            int ret = tooloptimizationDao.updateNonQuery(entity);
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0003, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            Tooloptimization tooloptimization = new Tooloptimization();
            //错误消息：数据库操作异常，删除失败!
            tooloptimization.setMessageCode(IConstant.EMSG0008);
            tooloptimization.setRetErrFlag(true);
            tooloptimization.setExceMessage(e.getMessage());
            rtn.put("error", tooloptimization);
            rtn.put("data", null);
            return rtn;
        }
    }
}
