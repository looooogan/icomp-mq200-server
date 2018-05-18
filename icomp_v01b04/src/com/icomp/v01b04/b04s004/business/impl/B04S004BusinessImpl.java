package com.icomp.v01b04.b04s004.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b04.s004.ICOMPV01B04S004Service;
import com.icomp.entity.base.*;
import com.icomp.entity.base.Process;
import com.icomp.v01b04.b04s004.business.B04S004Business;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 刀具消耗查询BUSINESS实现类
 *
 * @author Taoyy
 * @ClassName: B01S004BusinessImpl
 * @date 2014-8-14 下午02:02:34
 */
public class B04S004BusinessImpl implements B04S004Business {


    /**
     * 刀具消耗查询SERVICE
     */
    private ICOMPV01B04S004Service icompv01b04s004Service;

    public void setIcompv01b04s004Service(ICOMPV01B04S004Service icompv01b04s004Service) {
        this.icompv01b04s004Service = icompv01b04s004Service;
    }

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 取得页面grid显示项目列表
     *
     * @param pageID
     * @param langValue
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getGridColmun(String pageID, String userID,
                                             String langCode, String langValue) throws BusinessException {

        // 取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun(pageID,
                langCode, IConstant.ITEM_TYPE_1);
        if (ret.size() > 1 && ret.get("error") != null) {
            // 取得失败时，返回
            throw new BusinessException(((List<Displayeditemconfiguration>) ret
                    .get("error")).get(0).getMessageCode(), langCode, langValue);
        }
        return ret;
    }

    @Override
    public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
        Map<String, Object> ret = new HashMap<String, Object>();

        //取得生产线
        List<Assemblyline> assemblylineList = icompv01b04s004Service.getAssemblyline();
        if (assemblylineList.size() > 0 && assemblylineList.get(0).isRetErrFlag()) {
            //检索错误时，返回
            throw new BusinessException(assemblylineList.get(0).getMessageCode(), langCode, langValue);
        }
        ret.put("AssemblyLineList", assemblylineList);
        //取得轴编号
        List<Axle> axleList = icompv01b04s004Service.getAxleLine();
        if (axleList.size() > 0 && axleList.get(0).isRetErrFlag()) {
            //检索错误时，返回
            throw new BusinessException(axleList.get(0).getMessageCode(), langCode, langValue);
        }
        ret.put("AxleLineList", axleList);
        //取得工序列表
        List<Process> processList = icompv01b04s004Service.getProcess();
        if (processList.size() > 0 && processList.get(0).isRetErrFlag()) {
            //检索错误时，返回
            throw new BusinessException(processList.get(0).getMessageCode(), langCode, langValue);
        }
        ret.put("ProcessList", processList);
        //取得设备列表
        List<Equipment> equipmentList = icompv01b04s004Service.getEquipment();
        if (equipmentList.size() > 0 && equipmentList.get(0).isRetErrFlag()) {
            //检索错误时，返回
            throw new BusinessException(equipmentList.get(0).getMessageCode(), langCode, langValue);
        }
        ret.put("EquipmentList", equipmentList);
        //取得零部件列表
        List<Parts> partsList = icompv01b04s004Service.getParts();
        if (partsList.size() > 0 && partsList.get(0).isRetErrFlag()) {
            //检索错误时，返回
            throw new BusinessException(partsList.get(0).getMessageCode(), langCode, langValue);
        }
        ret.put("PartsList", partsList);


        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 刀具消耗查询列表
     */
    public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue,int chey) throws BusinessException {

        /**
         *  设置检索条件
         */
        String dateStarStr = param.get("dstar").toString().trim();
        String dateEndStr = param.get("dend").toString().trim();
        //Vtoolconsumptionquery entity = new Vtoolconsumptionquery();
        Vamortization entity = new Vamortization();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            // 申请起始时间
            if (dateStarStr != null && !"".equals(dateStarStr)) {
                dateStarStr += " 00:00:00";
                entity.setDateStar(format.parse(dateStarStr));
            }
            // 申请结束时间
            else if (dateEndStr != null &&!"".equals(dateEndStr)) {
                dateEndStr += " 23:59:59";
                entity.setDateEnd(format.parse(dateEndStr));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //刀具编码
        entity.setAssemblyLineID(StringUtils.isEmpty(param.get("productionLine").toString()) ? null : param.get("productionLine").toString());
        //供应商
        entity.setProcessID(StringUtils.isEmpty(param.get("procedure").toString()) ? null : param.get("procedure").toString());
        entity.setEquipmentID(StringUtils.isEmpty(param.get("equipment").toString()) ? null : param.get("equipment").toString());
        entity.setAxleID(StringUtils.isEmpty(param.get("axisNumber").toString()) ? null : param.get("axisNumber").toString());
        entity.setPartsID(StringUtils.isEmpty(param.get("model").toString()) ? null : param.get("model").toString());
        entity.setToolCode(StringUtils.isEmpty(param.get("toolCode").toString()) ? null : param.get("toolCode").toString());
        //排序
        entity.setOrderString("outerTime desc");
        //删除分区
        entity.setDelFlag(IConstant.DEL_FLAG_0);
      if (chey==2){
          //分页起始行数
          entity.setStaIndex(0);
          //分页页数
          entity.setRowCount(30000);

      }else {
          //分页起始行数
          entity.setStaIndex((Integer.parseInt(param.get("page").toString()) - 1) * IConstant.ROWSIZE);
          //分页页数
          entity.setRowCount(Integer.parseInt(param.get("rows").toString()));
      }
        //刀具消耗查询列表--ToolCode模糊查询
        Map<String, Object> rtn = icompv01b04s004Service.getList(entity);
        if (rtn.size() > 1 && rtn.get("error") != null) {
            // 检索错误时，返回
            throw new BusinessException(((List<Vamortization>) rtn.get("error")).get(0).getMessageCode(), langCode, langValue);
        }
        return rtn;
    }

    @Override
    public List<Assemblyline> getAssemblyline(String param, String langCode, String langValue) throws BusinessException {
        Assemblyline entity = new Assemblyline();
        entity.setDelFlag(param);
        entity.setLanguageCode(langCode);
        List<Assemblyline> list = icompv01b04s004Service.getAssemblylineList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
        }
        return list;
    }

    @Override
    public List<Voplinkdown> getVoplink(Map<String,Object> annyID, String param, String langCode, String langValue, int checkType) throws BusinessException {
        Voplinkdown entity = new Voplinkdown();
        String AssemblylineID =(String) annyID.get("productionLineID");
        String ProcedureID = (String)annyID.get("procedureID");
        String EquipmentID = (String) annyID.get("equipmentID");
        String AxleID = (String)annyID.get("axisNumberID");
        if (checkType == 1) {
            //查询工序
            entity.setAssemblyLineID(AssemblylineID);
            entity.setGroupString("ProcessName");
            entity.setOrderString("ProcessCode");
        } else if (checkType == 2) {
            //查询设备
            entity.setAssemblyLineID(AssemblylineID);
            entity.setProcessID(ProcedureID);
            entity.setGroupString("ProcessCode,EquipmentID");
            entity.setOrderString("ProcessName");
        } else if (checkType == 3) {
            //查询轴
            entity.setAssemblyLineID(AssemblylineID);
            entity.setProcessID(ProcedureID);
            entity.setEquipmentID(EquipmentID);
            entity.setGroupString("AxleCode");
            entity.setOrderString("AxleCode");
        } else if (checkType == 4) {
            //零部件
            entity.setAssemblyLineID(AssemblylineID);
            entity.setProcessID(ProcedureID);
            entity.setEquipmentID(EquipmentID);
            entity.setAxleID(AxleID);
        }

        entity.setDelFlag(param);
        List<Voplinkdown> list = icompv01b04s004Service.getVoplinList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), langCode,
                    langValue);
        }
        return list;
    }

    @Override
    public List<Process> getProcess(String delFlag0, String langCode, String langValue) {
        Process entity = new Process();
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity.setLanguageCode(langCode);
        List<Process> list = icompv01b04s004Service.getProcessList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
        }
        return list;
    }

    @Override
    public List<Equipment> getEquipment(String delFlag0, String langCode, String langValue) {
        Equipment entity = new Equipment();
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity.setLanguageCode(langCode);
        List<Equipment> list = icompv01b04s004Service.getEquipmentList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
        }
        return list;
    }

    @Override
    public List<Axle> getAxle(String delFlag0, String langCode, String langValue) {
        Axle entity = new Axle();
        entity.setDelFlag(IConstant.DEL_FLAG_0);
        List<Axle> list = icompv01b04s004Service.getAxlelist(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), langCode, langValue);
        }
        return list;
    }

    @Override
    public String getNumber() throws BusinessException {
        return icompv01b04s004Service.getNumber();
    }
}
