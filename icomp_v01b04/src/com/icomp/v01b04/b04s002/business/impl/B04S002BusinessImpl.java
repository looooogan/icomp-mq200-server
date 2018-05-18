package com.icomp.v01b04.b04s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b04.s002.ICOMPV01B04S002Service;
import com.icomp.entity.base.*;
import com.icomp.v01b04.b04s002.business.B04S002Business;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *车间刀具状态查询BUSINESS实现类
 *
 * @ClassName: B01S002BusinessImpl
 * @author Taoyy
 * @date 2014-8-14 下午02:02:34
 */
public class B04S002BusinessImpl implements B04S002Business {

    /**
     * 车间刀具状态查询SERVICE
     */
    private ICOMPV01B04S002Service icompv01b04s002Service;

    public void setIcompv01b04s002Service(ICOMPV01B04S002Service icompv01b04s002Service) {
        this.icompv01b04s002Service = icompv01b04s002Service;
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
                langCode,IConstant.ITEM_TYPE_1);
        if (ret.size() > 1 && ret.get("error") != null) {
            // 取得失败时，返回
            throw new BusinessException(((List<Displayeditemconfiguration>) ret
                    .get("error")).get(0).getMessageCode(), langCode, langValue);
        }
        return ret;
    }

    @Override
    public Map<String, Object> getPageSelList(String langCode, String langValue) throws BusinessException {
        Map<String,Object> ret = new HashMap<String,Object>();
        List<Assemblyline> assemblylineList = icompv01b04s002Service.getAssemblyline();
        if(assemblylineList.size()>0 && assemblylineList.get(0).isRetErrFlag()){
            //检索错误时，返回
            throw new BusinessException(assemblylineList.get(0).getMessageCode(), langCode,  langValue);
        }
        ret.put("AssemblyLineList", assemblylineList);
        //取得工序列表
        List<com.icomp.entity.base.Process> processList = icompv01b04s002Service.getProcess();
        if(processList.size()>0 && processList.get(0).isRetErrFlag()){
            //检索错误时，返回
            throw new BusinessException(processList.get(0).getMessageCode(), langCode,  langValue);
        }
        ret.put("ProcessList", processList);
        return ret;
    }

    @Override
    public List<Voplinkdown> getVoplink(String annyID, String delFlag0, String langCode, String langValue, int checkType) {
        Voplinkdown entity = new Voplinkdown();

        entity.setAssemblyLineID(annyID);


        entity.setDelFlag(IConstant.DEL_FLAG_0);
        entity.setGroupString("ProcessID");
        entity.setOrderString("ProcessName");
        List<Voplinkdown> list = icompv01b04s002Service.getVoplinList(entity);
        if (list.size() == 1 && list.get(0).isRetErrFlag()) {
            throw new BusinessException(list.get(0).getMessageCode(), langCode,
                    langValue);
        }
        return list;
    }

    @Override
    public List<Assemblyline> getAssemblyline(String delFlag0, String langCode, String langValue) {
        Assemblyline entity = new Assemblyline();

        entity.setLanguageCode(langCode);
        List<Assemblyline> list = icompv01b04s002Service.getAssemblylineList(entity);
        if(list.size() == 1 && list.get(0).isRetErrFlag()){
            throw new BusinessException(list.get(0).getMessageCode(), langCode,  langValue);
        }
        return list;
    }

    @Override
    public String getNumber() throws BusinessException {
        return icompv01b04s002Service.getAnumber();
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 合成刀具状态查询列表
     */
    public Map<String, Object> getList(Map<String, Object> param, String langCode,String langValue,int chey)throws BusinessException {
        // 2017/07/03 宋健 变更↓↓↓　dazhong@YMSC

        /**
         * 设置检索条件
         */
        Vsynthesiscondition entity = new Vsynthesiscondition();
        Synthesisknife entity2 = new Synthesisknife();
        //合成刀编码
        entity.setSynthesisParametersCode(StringUtils.isEmpty(param.get("toolCode").toString()) ? null : param.get("toolCode").toString());
        entity2.setSynthesisParametersCode(StringUtils.isEmpty(param.get("toolCode").toString()) ? null : param.get("toolCode").toString());
        //排序方式

        String orders = StringUtils.isEmpty ( param.get ( "pNumber" ).toString () ) ? null : param.get ( "pNumber" ).toString ();

        if (!StringUtils.isEmpty ( orders )) {
            orders = orders + " DESC";
            entity2.setOrderString ( orders );
        }

        //合成刀具状态
        if (chey==1){
            // 分页起始行数
            entity2.setStaIndex((Integer.parseInt(param.get("page").toString())-1) * IConstant.ROWSIZE);
            // 分页页数
            entity2.setRowCount(Integer.parseInt(param.get("rows").toString()));
        }else {
            entity2.setStaIndex(IConstant.RESULT_CODE_0);
            entity2.setRowCount(30000);
        }

        // 排序
        entity2.setDelFlag(IConstant.DEL_FLAG_0);


        // 车间刀具状态查询列表-SynthesisParametersCode模糊查询
        Map<String, Object> rtn = icompv01b04s002Service.getLists(entity2);
        if (rtn.size() > 1 && rtn.get("error") != null) {
            // 检索错误时，返回
            throw new BusinessException(((List<Synthesisknife>) rtn.get("error")).get(0).getMessageCode(), langCode,langValue);
        }
        return rtn;
        // 2017/07/03 宋健 变更↑↑↑　dazhong@YMSC
    }

}
