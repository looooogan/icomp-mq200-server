package com.icomp.common.service.icomp.v01b09.s005;

import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Containercarrier;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.entity.base.TooltransferTotal;

import java.util.List;
import java.util.Map;


public interface ICOMPV01B09S005Service {

    // 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC
    Map<String, Object> getList(TooltransferTotal entity);
    // 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC
    /**
     * 新建补领
     * @param tooltransfer
     * @param langCode
     * @param langValue
     * @return
     */
    Map<String, Object> sfersAdd( Tooltransfer tooltransfer, String langCode, String langValue);

    /**
     * 验证新建信息
     * @param param
     * @param langValue
     * @return
     */

    Map<String, Object> checkInput(Map<String, Object> param, String langCode, String langValue, int i,String userID) throws BusinessException;


    List<Containercarrier> getContainList()throws BusinessException;

    List<Containercarrier> getContainLists(Containercarrier conEntity)throws BusinessException;
}
