package com.icomp.v01b07.b07s002.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01b07.s002.ICOMPV01B07S002Service;
import com.icomp.entity.base.Displayeditemconfiguration;
import com.icomp.entity.base.Vtoolalarmparam;
import com.icomp.v01b07.b07s002.business.B07S002Business;

import java.util.List;
import java.util.Map;

/**
 * 库存异常报警BUSINESS实现类
 *
 * @author Taoyy
 * @ClassName: B07S002BusinessImpl
 * @date 2014-9-19 下午01:30:24
 */

public class B07S002BusinessImpl implements B07S002Business {

    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    /**
     * 库存异常报警SERVICE
     */
    private ICOMPV01B07S002Service icompv01b07s002Service;

    public void setIcompv01b07s002Service(ICOMPV01B07S002Service icompv01b07s002Service) {
        this.icompv01b07s002Service = icompv01b07s002Service;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * 库存异常报警列表
     */ public Map<String, Object> getList(Map<String, Object> param, String langCode, String langValue) throws BusinessException {
        /**
         * 设置检索条件
         */
        Vtoolalarmparam entity = new Vtoolalarmparam ();
        //查询类型（0:新刀库，1:备刀库）
        entity.setDelFlag ( (String) param.get ( "pVentoryType" ) );
        // 分页起始行数
        entity.setStaIndex ( (Integer.parseInt ( param.get ( "page" ).toString () ) - 1) * IConstant.ROWSIZE );
        // 分页页数
        entity.setRowCount ( Integer.parseInt ( param.get ( "rows" ).toString () ) );

        // 排序
        //	entity.setOrderString("ToolID");
        // 库存异常报警列表
        Map<String, Object> rtn = icompv01b07s002Service.getLists ( entity );
        if (rtn.size () > 1 && rtn.get ( "error" ) != null) {
            // 检索错误时，返回
            throw new BusinessException ( ((List<Vtoolalarmparam>) rtn.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return rtn;
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
    public Map<String, Object> getGridColmun(String pageID, String userID, String langCode, String langValue) throws BusinessException {

        // 取得页面grid显示项目列表
        Map<String, Object> ret = service.getGridColmun ( pageID, langCode, IConstant.ITEM_TYPE_1 );
        if (ret.size () > 1 && ret.get ( "error" ) != null) {
            // 取得失败时，返回
            throw new BusinessException ( ((List<Displayeditemconfiguration>) ret.get ( "error" )).get ( 0 ).getMessageCode (), langCode, langValue );
        }
        return ret;
    }

    @Override
    public String getNumber() throws BusinessException {
        return icompv01b07s002Service.getNumber ();
    }

}
