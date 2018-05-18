package com.icomp.dao;

import com.icomp.common.dao.BaseDao;
import com.icomp.entity.base.ToolReplace;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by logan on 2018/5/14.
 */
public interface ToolReplaceDao extends BaseDao{

    /**
     * 按任意查询-SynthesisParametersCode模糊查询
     * @param toolReplace 查询条件
     * @return 查询结果
     * @throws SQLException
     */
    public List<ToolReplace> queryToolReplace(ToolReplace toolReplace) throws SQLException;
}
