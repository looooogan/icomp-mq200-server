package com.icomp.wsdl.v01c01.c01s003.endpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 刀具换领
 * @ClassName: C01S003Wsdl 
 * @author Taoyy
 * @date 2016-3-4 上午11:24:36
 */
@WebService 
public interface C01S003Wsdl {
	
	/**
	 * 取得换领申请人申请信息
	 * @title getApplyInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String getApplyInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得要换领出库的刀具信息
	 * @title getRedemptionapplyInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String getRedemptionapplyInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 提交换领出库的刀具信息
	 * @title saveRedemptionapplyInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String saveRedemptionapplyInfo(@WebParam(name = "request")String request) throws Exception;
	
	
	/**
	 * 取得换领申请单
	 * @title getRedemptionInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String getRedemptionInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得换领申请单明细
	 * @title getRedemptionDetail 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String getRedemptionDetail(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得待换领刀具信息
	 * @title getRedemptionToolInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String getRedemptionToolInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 更新备货刀具状态
	 * @title saveStockingToolStauts 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String saveStockingToolStauts(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 备货刀具出库
	 * @title saveOutputStockingTool 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String saveOutputStockingTool(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 查询单品刀具信息
	 * @title seachToolInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String seachToolInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 换领结束，更新申请单
	 * @title saveRedemptionInfo 
	 * @param request
	 * @return
	 * @throws 
	 * @throws Exception
	 * String
	 */
	public String saveRedemptionInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 验证是否存在专机领用数据
	 * @title existLedplane 
	 * @param request
	 * @return
	 * @throws Exception
	 * String
	 */
	public String existLedplane(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得区分值列表
	 * @title getComlist 
	 * @param request
	 * @return
	 * @throws Exception
	 * String
	 */
	public String getComlist(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得扫描标签的绑定刀具数量及刀具编码
	 * @title getToolInfo 
	 * @param request
	 * @return
	 * @throws Exception
	 * String
	 */
	public String getToolInfo(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 保存专机领用数据
	 * @title saveLedplane 
	 * @param request
	 * @return
	 * @throws Exception
	 * String
	 */
	public String saveLedplane(@WebParam(name = "request")String request) throws Exception;
	
	/**
	 * 取得换领申请单列表按照人名和日期进行排序并显示在list中
	 * @title getRequestList 
	 * @param request
	 * @return
	 * @throws Exception
	 * String
	 */
	public String getRequestList(@WebParam(name = "request")String request) throws Exception;
	

	/**
	 * 取得用户选择的申请人、申请时间对应的备货信息
	 * @title getChoiceList 
	 * @param request
	 * @return
	 * @throws Exception
	 * C01S003Respons
	 */
	public String getChoiceList(@WebParam(name = "request")String request) throws Exception;

	/**
	 * 取得前页面传递的用户选择的申请单归还清单
	 * @title getRemand 
	 * @param request
	 * @return
	 * @throws Exception
	 * C01S003Respons
	 */
	public String getRemand(@WebParam(name = "request")String request) throws Exception;
	
	 /**
     * 刀具送回信息提交
     * @param request
     * @return
     * @throws Exception
     */
	public String reToolSubmit(@WebParam(name = "request")String request) throws Exception;
 /**
     * 刀具备货提交
     * @param request
     * @return
     * @throws Exception
     */
	public String stockMsgSubmit(@WebParam(name = "request")String request) throws Exception;

    /**
     * 领刀授权提交
     * @param request
     * @return
     * @throws Exception
     */
	public String saveGetChangeTool(@WebParam(name = "request")String request) throws Exception; /**
    /**
     * 取得已备货的刀具信息
     * @param request
     * @return
     * @throws Exception
     */
	public String getReadiedToolsMessage(@WebParam(name = "request")String request) throws Exception;
	/**
	 * 非单品-获取换领申请人列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getApplyUser(@WebParam(name = "request")String request) throws Exception;
	/**
	 * 非单品-获取换领申请列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getRedemptionappliedListCodeByUserid(@WebParam(name = "request")String request) throws Exception;
	/**
	 * 保存换领出库信息-非单品
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String saveRedemptionApplied(@WebParam(name = "request")String request) throws Exception;
	/**
	 * 保存换领出库信息-非单品
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String getRfidTypeFD(@WebParam(name = "request")String request) throws Exception;
}
