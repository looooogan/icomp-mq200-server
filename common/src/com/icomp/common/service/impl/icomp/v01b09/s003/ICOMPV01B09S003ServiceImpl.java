package com.icomp.common.service.impl.icomp.v01b09.s003;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b09.s003.ICOMPV01B09S003Service;
import com.icomp.common.utils.Ctl;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.utils.NextKeyValue;
import com.icomp.dao.*;
import com.icomp.entity.base.*;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class ICOMPV01B09S003ServiceImpl extends BaseService implements ICOMPV01B09S003Service {

    private VdisplayeditemconfigurationDao vdisplayeditemconfigurationDao;

    private DisplayeditemconfigurationDao displayeditemconfigurationDao;

    private ToolwholelifecycleDao toolwholelifecycleDao;

    private UserdetailDao userdetailDao;
    private TooltransferDao tooltransferDao;

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    public void setUserdetailDao(UserdetailDao userdetailDao) {
        this.userdetailDao = userdetailDao;
    }

    private ToolDao toolDao;

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setToolwholelifecycleDao(ToolwholelifecycleDao toolwholelifecycleDao) {
        this.toolwholelifecycleDao = toolwholelifecycleDao;
    }

    public void setDisplayeditemconfigurationDao(DisplayeditemconfigurationDao displayeditemconfigurationDao) {
        this.displayeditemconfigurationDao = displayeditemconfigurationDao;
    }

    public void setVdisplayeditemconfigurationDao(VdisplayeditemconfigurationDao vdisplayeditemconfigurationDao) {
        this.vdisplayeditemconfigurationDao = vdisplayeditemconfigurationDao;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getList(Toolwholelifecycle entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Toolwholelifecycle> list = toolwholelifecycleDao.searchByList1(entity);

            if (list.size() <= 0) {
                list = new ArrayList<Toolwholelifecycle>();
                Toolwholelifecycle twtool = new Toolwholelifecycle();
                //消息：检索为0
                twtool.setMessageCode(IConstant.EMSG0001);
                twtool.setRetErrFlag(true);
                list.add(twtool);
                rtn.put("rows", null);
                rtn.put("error", list);

                return rtn;
            } else {
                for (Toolwholelifecycle twlist : list) {
                    Tooltransfer tooltransfer = new Tooltransfer();
                    tooltransfer.setKnifeInventoryCode(twlist.getKnifeInventoryCode());
                    List<Tooltransfer> tflist = (List<Tooltransfer>) tooltransferDao.searchByList(tooltransfer);
                    if (tflist.size() == 0) {
                        twlist.setExpandSpace2("0");
                        twlist.setExpandSpace3("0");

                    } else {

                        if (twlist.getProcessAmount() ==null) {
                            twlist.setExpandSpace2(IConstant.DEL_FLAG_0);
                        } else {
                            twlist.setExpandSpace2(String.valueOf(twlist.getProcessAmount()));
                        }
                        if (("null").equals(String.valueOf(twlist.getVersion())) || ("").equals(String.valueOf(twlist.getVersion()))) {

                            twlist.setExpandSpace3(IConstant.DEL_FLAG_0);
                        } else {

                            twlist.setExpandSpace3(String.valueOf(twlist.getVersion()));
                        }

                    }

                    Tool t = new Tool();
                    t.setToolID(twlist.getToolID());
                    List<Tool> tlist = (List<Tool>) toolDao.searchByList(t);
                    if (tlist.size() == 0) {
                        twlist.setToolID("-");
                    } else {
                        twlist.setToolID(tlist.get(0).getToolCode());
                    }
                    Userdetail u = new Userdetail();
                    u.setCustomerID(twlist.getCreateUser());
                    List<Userdetail> ulist = (List<Userdetail>) userdetailDao.searchByList(u);
                    if (ulist.size() == 0) {
                        twlist.setCreateUser("-");
                    } else {
                        twlist.setCreateUser(ulist.get(0).getUserName());
                    }

                    if (IConstant.C03S001.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C03S001_TEXT);
                    } else if (IConstant.C01S011.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S011_TEXT);
                    } else if (IConstant.C01S013.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S013_TEXT);
                    } else if (IConstant.C01S010.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S010_TEXT);
                    } else if (IConstant.C01S014.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S014_TEXT);
                    } else if (IConstant.C01S018.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S018_TEXT);
                    } else if (IConstant.C01S027.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S027_TEXT);
                    } else if (IConstant.C01S016.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S016_TEXT);
                    } else if (IConstant.C01S005.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S005_TEXT);
                    } else if (IConstant.C01S020.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S020_TEXT);
                    } else if (IConstant.C01S019.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S019_TEXT);
                    } else if (IConstant.C01S001.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S001_TEXT);
                    } else if (IConstant.C01S003.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S003_TEXT);
                    } else if (IConstant.C01S004.equals(twlist.getBusinessFlowLnkID())) {
                        twlist.setBusinessFlowLnkID(IConstant.C01S004_TEXT);
                    }

                }

                int total = toolwholelifecycleDao.searchByCount1(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);
                return rtn;
            }

        } catch (SQLException e) {
            List<Toolwholelifecycle> list = new ArrayList<Toolwholelifecycle>();
            Toolwholelifecycle comlist = new Toolwholelifecycle();
            //错误消息：数据库操作异常，查询失败!
            comlist.setMessageCode(IConstant.EMSG0004);
            comlist.setRetErrFlag(true);
            comlist.setExceMessage(e.getMessage());
            list.add(comlist);
            rtn.put("rows", null);
            rtn.put("error", list);
            return rtn;
        }
    }

    /**
     * 新建打印项目信息
     *
     * @param
     * @param langValue
     * @return
     */
    public Map<String, Object> printItemAdd(Displayeditemconfiguration entity, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            displayeditemconfigurationDao.insert(entity);
            //插入成功
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0004, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);

            return rtn;
        } catch (SQLException e) {
            Displayeditemconfiguration ddentity = new Displayeditemconfiguration();
            //错误消息：数据库操作异常，插入失败!
            ddentity.setMessageCode(IConstant.EMSG0007);
            ddentity.setRetErrFlag(true);
            ddentity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

    /**
     * 打印项目删除
     *
     * @param
     * @return 打印项目信息
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> printEditDelete(Displayeditemconfiguration position, String langCode, String langValue) {

        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 删除失败! 进行数据排他验证
            Displayeditemconfiguration entity = new Displayeditemconfiguration();
            entity.setDisplayedItemConfigurationID(position.getDisplayedItemConfigurationIDWhere());
            //entity.setUpdateTime(position.getUpdateTimeWhere());
            //entity.setUpdateUser(position.getUpdateUserWhere());
            entity.setVersion(position.getVersionWhere());
            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList(entity);
            if (list == null || list.size() == 0) {
                entity = new Displayeditemconfiguration();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);
                return rtn;
            }
            // 删除成功
            @SuppressWarnings("unused")
            int ret = displayeditemconfigurationDao.updateNonQuery(position);
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0003, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);
            return rtn;
        } catch (SQLException e) {
            Displayeditemconfiguration entity = new Displayeditemconfiguration();
            //错误消息：数据库操作异常，删除失败!
            entity.setMessageCode(IConstant.EMSG0008);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

    /**
     * 编辑打印项目信息
     *
     * @param
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> printEdit(Displayeditemconfiguration position, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 删除失败! 进行数据排他验证
            Displayeditemconfiguration entity = new Displayeditemconfiguration();
            entity.setDisplayedItemConfigurationIDWhere(position.getDisplayedItemConfigurationID());
            entity.setUpdateTime(position.getUpdateTimeWhere());
            entity.setUpdateUser(position.getUpdateUserWhere());
            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList(entity);
            if (list == null || list.size() == 0) {
                entity = new Displayeditemconfiguration();
                // 消息：您所请求的数据,已被其他用户修改，请重新查询后再进行修改!
                entity.setMessageCode(IConstant.WMSG0009);
                entity.setRetErrFlag(true);
                rtn.put("error", entity);
                rtn.put("data", null);
                return rtn;
            }
            // 更新项目打印成功
            @SuppressWarnings("unused")
            int ret = displayeditemconfigurationDao.updateNonQuery(position);
            rtn.put("message", MessageReSource.getMessageBox(IConstant.IMSG0005, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);

            return rtn;
        } catch (SQLException e) {
            Displayeditemconfiguration entity = new Displayeditemconfiguration();
            //错误消息：数据库操作异常，更新失败!
            entity.setMessageCode(IConstant.EMSG0006);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);
            return rtn;
        }
    }

    /**
     * 项目打印管理
     *
     * @param entity 页面查询条件
     * @return 项目打印信息
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getprintItemInfo(Displayeditemconfiguration entity) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList(entity);
            if (list.size() <= 0) {
                Displayeditemconfiguration vpositions = new Displayeditemconfiguration();
                //消息：检索为0
                vpositions.setMessageCode(IConstant.EMSG0001);
                vpositions.setRetErrFlag(true);
                rtn.put("data", null);
                rtn.put("error", vpositions);
                return rtn;
            } else {
                rtn.put("data", list.get(0));
                return rtn;
            }

        } catch (SQLException e) {
            Displayeditemconfiguration vpositions = new Displayeditemconfiguration();
            //错误消息：数据库操作异常，查询失败!
            vpositions.setMessageCode(IConstant.EMSG0004);
            vpositions.setRetErrFlag(true);
            vpositions.setExceMessage(e.getMessage());
            rtn.put("data", null);
            rtn.put("error", vpositions);
            return rtn;
        }
    }

    /**
     * 新建编辑的验证
     *
     * @param param     页面查询条件
     * @param langCode  语言编码
     * @param langValue 语言值
     * @param
     * @param checkType 1代表新建，2代表编辑
     * @return
     */

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, String userID, int checkType) {
        // 返回值
        Map<String, Object> rtn = new HashMap<String, Object>();
        // 错误信息
        Map<String, String> map = new HashMap<String, String>();
        Displayeditemconfiguration entity = new Displayeditemconfiguration();
        try {
            if (checkType == 1) {
                // 页面名称
                if (StringUtils.isEmpty(param.get("DIVPageName").toString())) {
                    map.put("DIVPageName", MessageReSource.getMessageBox(IConstant.WMSG0098, langCode, langValue));
                }
                // 项目名称
                if (StringUtils.isEmpty(param.get("DIVColName").toString())) {
                    map.put("DIVColName", MessageReSource.getMessageBox(IConstant.WMSG0099, langCode, langValue));
                } else {

                    Displayeditemconfiguration displayeditemconfiguration = new Displayeditemconfiguration();
                    displayeditemconfiguration.setPageName(param.get("DIVPageName").toString());
                    displayeditemconfiguration.setColName(param.get("DIVColName").toString());
                    List<Displayeditemconfiguration> list = (List<Displayeditemconfiguration>) displayeditemconfigurationDao.searchByList(displayeditemconfiguration);
                    if (list.size() > 0) {
                        //消息：您所新建的项目名称已存在!
                        map.put("DIVColName", MessageReSource.getMessageBox(IConstant.WMSG0210, langCode, langValue));
                    }

                }
            }
            // 语言
            if (StringUtils.isEmpty(param.get("DIVlanguageCode").toString())) {
                //请选择语言种类!
                map.put("DIVlanguageCode", MessageReSource.getMessageBox(IConstant.WMSG0024, langCode, langValue));
            }
            // 是否显示
            if (StringUtils.isEmpty(param.get("DIVDisplayedFlag").toString())) {
                map.put("DIVDisplayedFlag", MessageReSource.getMessageBox(IConstant.WMSG0100, langCode, langValue));
            }
            // 项目文本
            if (StringUtils.isEmpty(param.get("DIVItemText").toString())) {
                map.put("DIVItemText", MessageReSource.getMessageBox(IConstant.WMSG0101, langCode, langValue));
            }
            // 删除区分
            if (StringUtils.isEmpty(param.get("DIVDelFlag").toString())) {
                map.put("DIVDelFlag", MessageReSource.getMessageBox(IConstant.WMSG0019, langCode, langValue));
            }
            if (checkType == 1) {
                // 如果是新增
                if (map.size() <= 0) {

                    entity.setDisplayedItemConfigurationID(NextKeyValue.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION, IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity.getUpdateUser()));// 取得主键
                    entity.setDelFlag(param.get("DIVDelFlag").toString());// 删除区分
                    entity.setVersion(BigDecimal.ZERO);// 版本号
                    entity.setCreateTime(new Date());// 创建时间
                    entity.setCreateUser(userID);// 创建者
                    entity.setUpdateTime(new Date());// 更新时间
                    entity.setUpdateUser(userID);// 更新者
                } else {
                    rtn.put("message", map);
                }

            } else if (checkType == 2) {
                // 如果是编辑
                if (map.size() <= 0) {
                    entity.setDelFlag(param.get("DIVDelFlag").toString());
                    entity.setVersion(new BigDecimal(param.get("DivVersion").toString()).add(BigDecimal.ONE));
                    entity.setUpdateUser(userID);
                    entity.setUpdateTime(new Date());
                    entity.setVersionWhere(new BigDecimal(param.get("DivVersion").toString()));
                    entity.setUpdateUserWhere(param.get("DivUpdateUser").toString());
                    entity.setUpdateTimeWhere(Ctl.strToDate(param.get("DivUpdateTime").toString().replace("T", " ")));
                } else {
                    rtn.put("message", map);
                }

            }
            rtn.put("data", entity);
            rtn.put("status", IConstant.RESULT_CODE_2);
        } catch (SQLException e) {
            Displayeditemconfiguration entity1 = new Displayeditemconfiguration();
            //错误消息：数据库操作异常，查询失败!
            entity1.setMessageCode(IConstant.EMSG0004);
            entity1.setRetErrFlag(true);
            entity1.setExceMessage(e.getMessage());
            rtn.put("error", entity1);
            rtn.put("data", null);
            return rtn;
        }
        return rtn;
    }

}
