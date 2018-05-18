package com.icomp.common.service.impl.icomp.v01b09.s005;

import com.icomp.common.base.BaseService;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.icomp.v01b09.s005.ICOMPV01B09S005Service;
import com.icomp.common.utils.MessageReSource;
import com.icomp.dao.*;
import com.icomp.entity.base.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICOMPV01B09S005ServiceImpl extends BaseService implements ICOMPV01B09S005Service {
    private TooltransferDao tooltransferDao;
    private ToolDao toolDao;
    private VsingleproductDao vsingleproductDao;
    private KnifeinventoryDao knifeinventoryDao;
    private ContainercarrierDao containercarrierDao;

    public void setContainercarrierDao(ContainercarrierDao containercarrierDao) {
        this.containercarrierDao = containercarrierDao;
    }

    public void setKnifeinventoryDao(KnifeinventoryDao knifeinventoryDao) {
        this.knifeinventoryDao = knifeinventoryDao;
    }

    public void setVsingleproductDao(VsingleproductDao vsingleproductDao) {
        this.vsingleproductDao = vsingleproductDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    public void setTooltransferDao(TooltransferDao tooltransferDao) {
        this.tooltransferDao = tooltransferDao;
    }

    // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
    public Map<String, Object> getList(TooltransferTotal entity) {

        Map<String, Object> rtn = new HashMap<String, Object>();
        try {
            List<TooltransferTotal> list = (List<TooltransferTotal>) tooltransferDao.searchList2(entity);
            if (list.size() <= 0) {
                list = new ArrayList<TooltransferTotal>();
                TooltransferTotal vsingleproduct = new TooltransferTotal();
                vsingleproduct.setMessageCode(IConstant.EMSG0001);
                vsingleproduct.setRetErrFlag(true);
                list.add(vsingleproduct);
                rtn.put("rows", null);
                rtn.put("error", list);

            } else {
                int total = tooltransferDao.searchCount2(entity);
                rtn.put("rows", list);
                rtn.put("total", total);
                rtn.put("page", (entity.getStaIndex() + IConstant.ROWSIZE) / IConstant.ROWSIZE);

            }

        } catch (SQLException e) {
            List<Vsingleproduct> list = new ArrayList<Vsingleproduct>();
            Vsingleproduct vsingleproduct = new Vsingleproduct();
            vsingleproduct.setMessageCode(IConstant.EMSG0004);
            vsingleproduct.setRetErrFlag(true);
            vsingleproduct.setExceMessage(e.getMessage());
            list.add(vsingleproduct);
            rtn.put("rows", null);
            rtn.put("error", list);

        }
        return rtn;
    }
    // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC

    public Map<String, Object> sfersAdd(Tooltransfer tooltransfer, String langCode, String langValue) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        try {

            // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
            TooltransferTotal t = new TooltransferTotal();

            t.setToolCode(tooltransfer.getToolID());

            t.setSpareKnifeSum(tooltransfer.getToolDurable());

            t.setCreateUser(tooltransfer.getCreateUser());

            List<TooltransferTotal> list = tooltransferDao.getTooltransferTotalByKey(t);

            if(list.size()>0){
                tooltransferDao.updateTooltransferTotal(t);
            }else{
                tooltransferDao.insert(t);
            }
            // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
            //成功消息：插入成功
            rtn.put("message", MessageReSource.getMessageBox(
                    IConstant.IMSG0004, langCode, langValue));
            rtn.put("status", IConstant.RESULT_CODE_0);

        } catch (SQLException e) {
            Tooltransfer entity = new Tooltransfer();
            //错误消息：数据库操作异常，插入失败!
            entity.setMessageCode(IConstant.EMSG0007);
            entity.setRetErrFlag(true);
            entity.setExceMessage(e.getMessage());
            rtn.put("error", entity);
            rtn.put("data", null);

        }
        return rtn;
    }



    public Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, int checkType,String userID) throws BusinessException {
        // 返回值
        Map<String, Object> rtn = new HashMap<String, Object>();
        // 错误信息
        Map<String, String> map = new HashMap<String, String>();
        Tooltransfer entity = new Tooltransfer();
        List<Vsingleproduct> listvsing = new ArrayList<Vsingleproduct>();
        List<Containercarrier> listcont =new ArrayList<Containercarrier>();


        // 材料号为空验证
        if (StringUtils.isEmpty(param.get("DivexpandSpace1").toString())) {
            map.put("DivexpandSpace1", MessageReSource.getMessageBox(
                    IConstant.REPLLC002, langCode, langValue));
        }
        // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
//            else{
//                //唯一性验证
//                Tool t = new Tool();
//                t.setToolCode(param.get("DivexpandSpace1").toString());
//                t.setDelFlag(IConstant.DEL_FLAG_0);
//                List<Tool> list1 = null;
//                List<Knifeinventory> knList = null;
//                try {
//                    list1 = (List<Tool>) toolDao.searchByList(t);
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                if (list1.size() <= 0) {
//                    //您所新建的材料号不已存在!
//                    map.put("DivexpandSpace1", MessageReSource.getMessageBox(
//                            IConstant.WMSG0182, langCode, langValue));
//                }else{
//                    if (!IConstant.STRING_0.equals(list1.get(0).getToolConsumetype())){
//
//                    entity.setToolID(list1.get(0).getToolID());
//                }else {
//                        map.put("DivexpandSpace1", MessageReSource.getMessageBox(
//                                IConstant.FDPDJCSH1, langCode, langValue));
//                }
//
//                }
//
//            }
        // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
        //数量为空，数字，大于0验证
        if (StringUtils.isEmpty(param.get("DivToolDurable").toString())){
            map.put("DivToolDurable", MessageReSource.getMessageBox(
                    IConstant.FDPDJCSH_02, langCode, langValue));
        } else if (!checkOutNum(param.get("DivToolDurable").toString())) {
            //数量填入数字!
            map.put("DivToolDurable", MessageReSource.getMessageBox(
                    IConstant.FDPDJCSH_03, langCode, langValue));
        } else if (new BigDecimal(param.get("DivToolDurable").toString()).compareTo(BigDecimal.ZERO) != 1){//不大于0
            //采购周期应该大于0!
            map.put("DivToolDurable", MessageReSource.getMessageBox(
                    IConstant.FDPDJCSH_01, langCode, langValue));

        }

        // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
        if((StringUtils.isNotEmpty(param.get("DivexpandSpace1").toString()))&&(StringUtils.isNotEmpty(param.get("DivToolDurable").toString()))){
            Tooltransfer  tooltransfer = new Tooltransfer();
            tooltransfer.setToolID(param.get("DivexpandSpace1").toString());
            tooltransfer.setToolDurable(new BigDecimal(param.get("DivToolDurable").toString()));
            tooltransfer.setCreateUser(userID);
            rtn.put("data",tooltransfer);
        }
        // 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC
        List<Tool> list = null;
        if(StringUtils.isNotEmpty(param.get("DivexpandSpace1").toString())){
            Tool tool = new Tool();
            tool.setToolCode(param.get("DivexpandSpace1").toString());
            try {
                list = toolDao.getToolByToolCode(tool);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC
        //场所验证
//            if (StringUtils.isEmpty(param.get("DivContain").toString())) {
//                map.put("DivContain", MessageReSource.getMessageBox(
//                        IConstant.FDPDJCSH_04, langCode, langValue));
//            }else{
//                //创建视图实体
//                Vsingleproduct vsingleproduct =new Vsingleproduct();
//                //放入材料号
//                vsingleproduct.setToolCode(param.get("DivexpandSpace1").toString());
//                vsingleproduct.setContainerCarrierID(param.get("DivContain").toString());
//                try {
//                    listvsing= ( List<Vsingleproduct> )vsingleproductDao.searchByList(vsingleproduct);
//
//                    if (listvsing.size()>0){
//                        if (map.size()<=0){
//                            Tool t = new Tool();
//                            t.setToolCode(param.get("DivexpandSpace1").toString());
//                            t.setDelFlag(IConstant.DEL_FLAG_0);
//                            List<Tool> list1 = null;
//                            List<Knifeinventory> knList = null;
//                            list1 = (List<Tool>) toolDao.searchByList(t);
//
//                            entity.setToolDurable(new BigDecimal(param.get("DivToolDurable").toString()));
//                            entity.setToolIDWhere(list1.get(0).getToolID());
//                            entity.setRfidContainerIDWhere(listvsing.get(0).getRfidContainerID());
//                            entity.setUpdateUser(userID);
//                            entity.setUpdateTime(new Date());
//                            int ret = tooltransferDao.updateNonQuery(entity);
//                           rtn.put("message", MessageReSource.getMessageBox(
//                                    IConstant.IMSG0005, langCode,  langValue));
//                            rtn.put("status", IConstant.RESULT_CODE_0);
//                        }else {
//                            rtn.put("message", map);
//                            rtn.put("status", IConstant.RESULT_CODE_2);
//                        }
//
//
//
//                    }else {
//                        List<Containercarrier> list = new ArrayList<Containercarrier>();
//                        Containercarrier contain = new Containercarrier();
//                        contain.setContainerCarrierID(param.get("DivContain").toString());
//                        contain.setDelFlag(IConstant.DEL_FLAG_0);
//                        list = (List<Containercarrier>)containercarrierDao.searchByList(contain);
//                        if (map.size() <= 0) {
//                        entity.setRfidContainerID(list.get(0).getRfidContainerID());
//                        // 容器类别（0备用刀，1一次性报废 2待分拣容器 3厂内待刃磨 4厂外待刃磨 5刃磨完毕 6刃磨报废 7待涂层 8库房报废 9其他）
//                        String cc = list.get(0).getContainerCarrierType();
//
//                        if (IConstant.STRING_0.equals(cc)){
//                            //刀具状态(0断刀1丢失2不合格3待分拣4待换装,5到寿,6厂内待刃磨,7.厂外待刃磨8刃磨完毕,9其他10.已出厂修磨 11.厂外待涂层)
//                            entity.setToolState(IConstant.TOOL_KIND_4);
//                            entity.setToolThisState(IConstant.TOOL_KIND_1);
//                            // 库存状态(0正常1报废2返厂3封存4.流转9其他)
//                            entity.setStockState(IConstant.TOOL_KIND_4);
//                        }else if (IConstant.STRING_1.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_5);
//                            entity.setStockState(IConstant.TOOL_KIND_1);
//                        }else if (IConstant.STRING_2.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_3);
//                            entity.setStockState(IConstant.TOOL_KIND_4);
//                        }else if (IConstant.STRING_3.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_6);
//                            entity.setStockState(IConstant.TOOL_KIND_4);
//                        }else if (IConstant.STRING_4.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_7);
//                            entity.setStockState(IConstant.TOOL_KIND_4);
//                        }else if (IConstant.STRING_5.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_8);
//                            entity.setStockState(IConstant.TOOL_KIND_4);
//                        }else if (IConstant.STRING_6.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_9);
//                            entity.setStockState(IConstant.TOOL_KIND_1);
//                        }else if (IConstant.STRING_7.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_11);
//                            entity.setStockState(IConstant.TOOL_KIND_4);
//                        }else if (IConstant.STRING_8.equals(cc)){
//                            entity.setToolState(IConstant.TOOL_KIND_5);
//                            entity.setStockState(IConstant.TOOL_KIND_1);
//                        }else {
//                            entity.setToolState(IConstant.TOOL_KIND_9);
//                            entity.setStockState(IConstant.TOOL_KIND_9);
//                        }
//
//
//                            entity.setToolDurable(new BigDecimal(param.get("DivToolDurable").toString()));
//
//
//                        // 如果是新增
//
//                            entity.setVersion(BigDecimal.ZERO);// 版本号
//                            entity.setProcessAmount(new BigDecimal(0));//加工数量
//                            entity.setKnifeInventoryCode(UUIDgen.getTimes ());//库存编码
//                            entity.setBusinessFlowLnkID(IConstant.C03S001);
//                            entity.setProcessAmount(new BigDecimal(IConstant.ZERO));
//                            entity.setProcuredBatch("20160701");
//                            //  entity.setContainerCarrierID(NextKeyValue.getNextkeyvalue(IConstant.DISPLAYEDITEMCONFIGURATION, IConstant.DISPLAYEDITEMCONFIGURATION_ID, entity.getUpdateUser()));// 取得主键
//                            entity.setCreateTime(new Date());// 创建时间ser
//                            entity.setDelFlag(IConstant.DEL_FLAG_0);
//                            entity.setUpdateTime(new Date());// 更新时间
//                            entity.setUpdateUser(userID);//更新人
//                            entity.setCreateUser(userID);//创建人
//                            rtn.put("data", entity);
//                            rtn.put("status", IConstant.RESULT_CODE_0);
//
//                        } else {
//                            rtn.put("message", map);
//                            rtn.put("status", IConstant.RESULT_CODE_2);
//                        }
//                    }
//                } catch (SQLException e) {
//                    map.put("DivContain", MessageReSource.getMessageBox(IConstant.WMSG0098, langCode, langValue));
//                }
//            }
        // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
        // 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC
        //2017/09/14 王冉 变更↓↓↓　dazhong@YMSC;
        if(list.size() == 0 || list == null){
            //2017/09/14 王冉 变更↑↑↑　dazhong@YMSC
            rtn.put("message","该材料号不存在,请在刀具参数中配置");
            rtn.put("status", IConstant.RESULT_CODE_1);
        }else{
            if (map.size()>0){
                rtn.put("message",map);
                rtn.put("status", IConstant.RESULT_CODE_2);
            }
        }
        // 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC
        return rtn;
    }

    @Override
    public List<Containercarrier> getContainList()throws BusinessException {
        Containercarrier entity = null;
        Containercarrier containercarrier = null;
        List<Containercarrier> list = null;
        try {
            entity = new Containercarrier();
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            list = (List<Containercarrier>) containercarrierDao.searchByList(entity);


            if (list.size() <= 0) {
                list = new ArrayList<Containercarrier>();
                containercarrier = new Containercarrier();
                // 消息：检索为0
                containercarrier.setMessageCode(IConstant.EMSG0001);
                containercarrier.setRetErrFlag(false);
                list.add(containercarrier);

            }


        } catch (SQLException e) {
            list = new ArrayList<Containercarrier>();
            containercarrier = new Containercarrier();
            // 错误消息：数据库操作异常，查询失败!
            containercarrier.setMessageCode(IConstant.EMSG0004);
            containercarrier.setRetErrFlag(true);
            containercarrier.setExceMessage(e.getMessage());
            list.add(containercarrier);

        }
        return list;
    }

    @Override
    public List<Containercarrier> getContainLists(Containercarrier conEntity) throws BusinessException {
        List<Containercarrier> conlist = null;
        Containercarrier conEnty =null;
        try {
            conlist=new ArrayList<Containercarrier>();
            conlist = ( List<Containercarrier>)containercarrierDao.searchByList(conEntity);
            if (conlist.size() <= 0) {
                conlist = new ArrayList<Containercarrier>();
                conEnty = new Containercarrier();
                // 消息：检索为0
                conEnty.setMessageCode(IConstant.EMSG0001);
                conEnty.setRetErrFlag(false);
                conlist.add(conEnty);

            }

        } catch (SQLException e) {
            conlist = new ArrayList<Containercarrier>();
            conEnty = new Containercarrier();
            // 错误消息：数据库操作异常，查询失败!
            conEnty.setMessageCode(IConstant.EMSG0004);
            conEnty.setRetErrFlag(true);
            conEnty.setExceMessage(e.getMessage());
            conlist.add(conEnty);
        }
        return conlist;
    }

}
