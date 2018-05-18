package com.icomp.wsdl.v01c01.c01s001.business.impl;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.service.CommonService;
import com.icomp.common.service.icomp.v01c01.s001.ICOMPV01C01S001Service;
import com.icomp.entity.base.Knifeinventory;
import com.icomp.entity.base.Rfidcontainer;
import com.icomp.entity.base.Tool;
import com.icomp.entity.base.Toolprocured;
import com.icomp.entity.base.Tooltransfer;
import com.icomp.wsdl.v01c01.c01s001.business.C01S001Business;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Request;
import com.icomp.wsdl.v01c01.c01s001.endpoint.C01S001Respons;
import com.icomp.wsdl.v01c01.c01s001.endpoint.InputTool;
import com.icomp.wsdl.v01c01.c01s001.endpoint.ProcuredBatchCount;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01S001BusinessImpl implements C01S001Business {

    public static final int ZERO = 0;
    private CommonService service;

    public void setService(CommonService service) {
        this.service = service;
    }

    private ICOMPV01C01S001Service iCOMPV01C01S001Service;

    public void setiCOMPV01C01S001Service(ICOMPV01C01S001Service iCOMPV01C01S001Service) {
        this.iCOMPV01C01S001Service = iCOMPV01C01S001Service;
    }

    /**
     * 扫描标签取得钻头(刀片)入库的信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S001Respons getBitInputInf(C01S001Request request) throws Exception {
        C01S001Respons respons = new C01S001Respons();
        Rfidcontainer entity = new Rfidcontainer();
        try {
            // 参数验证
            if (StringUtils.isEmpty(request.getRfidCode())) {
                throw new BusinessException(IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
            }
            // RFID标签
            entity.setRfidCode(request.getRfidCode());
            // 删除区分
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            // 验证RFID标签是否存在
            Rfidcontainer rfidcontainer = service.getRfidContainerByRfidCode(entity);
            if (rfidcontainer == null) {
                respons.setStateCode(IConstant.STRING_1);
                respons.setStateMsg("当前标签未初始化");
                return respons;
            } else if ((!IConstant.DEL_FLAG_1.equals(rfidcontainer.getQueryType())) && (!IConstant.DEL_FLAG_0.equals(rfidcontainer.getQueryType()))) {
                respons.setStateCode(IConstant.STRING_1);
                respons.setStateMsg("该标签不是单品刀或库位标签");
                return respons;
            } else {
            	// 标签类型
            	respons.setQueryType(rfidcontainer.getQueryType());
            	//刀具id
            	String toolId = null;
            	//刀具类型
            	String toolType = null;
            	// 材料号(刀具编码)
				String toolCode = null;
				// 库位码
				String libraryCodeID = null;
            	// 判断新刀入库表是否有数据
            	Knifeinventory ki = new Knifeinventory();
            	ki.setRfidContainerID(rfidcontainer.getRfidContainerID());
            	ki.setDelFlag(IConstant.STRING_0);
            	List<Knifeinventory> kiList = iCOMPV01C01S001Service.getKnifeinventoryInfo(ki);
            	if (kiList.size()<1) {
					// 判断刀具流转表是否有数据
            		Tooltransfer tt = new Tooltransfer();
            		tt.setRfidContainerID(rfidcontainer.getRfidContainerID());
            		tt.setDelFlag(IConstant.STRING_0);
            		List<Tooltransfer> ttList = iCOMPV01C01S001Service.getTooltransferInfo(tt);
            		if (ttList.size()<0) {
            			// 新刀库存表和刀具流转表都没有数据
            			respons.setStateCode(IConstant.STRING_1);
                        respons.setStateMsg("该标签没有对应的刀具信息");
                        return respons;
					}else {
						// 刀具流转表中有数据，取得刀具id
						toolId = ttList.get(0).getToolID();
					}
				}else {
					// 新刀入库表中有数据
					// 刀具id
					toolId = kiList.get(0).getToolID();
				}
            	
            	if (toolId == null) {
					respons.setStateCode(IConstant.STRING_1);
                    respons.setStateMsg("未找到对应的刀具id");
                    return respons;
				}
				// 根据刀具id取得刀具类型
				Tool tool = new Tool();
				tool.setToolID(toolId);
				tool.setDelFlag(IConstant.STRING_0);
				List<Tool> toolList = iCOMPV01C01S001Service.getToolInfo(tool);
				if (toolList.size()<1) {
					respons.setStateCode(IConstant.STRING_1);
                    respons.setStateMsg("刀具信息不存在");
                    return respons;
				}
				tool = toolList.get(0);
				// 刀具类型
				toolType = tool.getToolConsumetype();
				// 刀具id
				respons.setToolID(toolId);
				// 材料号(刀具编码)
				toolCode = tool.getToolCode();
				respons.setMaterialNum(toolCode);
				// 库位码
				libraryCodeID = tool.getLibraryCodeID();
				respons.setLibraryCodeID(libraryCodeID);
				
				// 在新刀库存表中统计库存量
				Knifeinventory ki2 = new Knifeinventory();
				ki2.setToolID(toolId);
				ki2.setDelFlag(IConstant.STRING_0);
				List<Knifeinventory> kiList2 = iCOMPV01C01S001Service.getKnifeinventoryInfo(ki2);
				if (kiList2.size()<1) {
					// 库存量为0
					respons.setUnitnumber(IConstant.STRING_0);
				}else {
					if (IConstant.STRING_0.equals(toolType)) {
						//钻头的库存量
						respons.setUnitnumber(kiList2.size()+"");
					}else {
						//刀片的库存量
						int sum = 0;
						for (Knifeinventory knifeinventory : kiList2) {
							sum = sum + Integer.parseInt(knifeinventory.getKnifelnventoryNumber());
						}
						respons.setUnitnumber(sum+"");
					}
				}
            	
                Toolprocured toolprocured = new Toolprocured();
                //材料号
                toolprocured.setToolCode(toolCode);
                toolprocured.setDelFlag(IConstant.DEL_FLAG_0);
                // 采购日期
                toolprocured.setOrderString("ProcuredTime DESC");

                // 获取可用批次
                List<Toolprocured> toolprocureds = iCOMPV01C01S001Service.getProcuredBatchList(toolprocured);

                if (toolprocureds == null || toolprocured.isRetErrFlag() || toolprocureds.size() <= 0) {
                    respons.setStateMsg("系统无可用入库批次");
                    respons.setStateCode(IConstant.STRING_2);
                    return respons;
                }

                List<ProcuredBatchCount> pbcList = new ArrayList<ProcuredBatchCount>();
                for (Toolprocured tp : toolprocureds) {
                    ProcuredBatchCount pbc = new ProcuredBatchCount();
                    pbc.setProcuredBatch(tp.getToolsOrdeNO ());// 采购批次
                    pbc.setProcuredCount(String.valueOf(tp.getProcuredCount()));// 采购数量
                    pbcList.add(pbc);
                }
                respons.setProcuredBatchCount(pbcList);
                respons.setStateCode(IConstant.STOCK_STATE_0);
                respons.setStateMsg("获取成功");
            }
        } catch (Exception e) {
            respons.setStateCode(IConstant.STOCK_STATE_2);
            respons.setStateMsg("获取失败");
        }
        return respons;
    }

    /**
     * 提交钻头入库信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S001Respons setBitInputInf(C01S001Request request) throws Exception {
        C01S001Respons respons = new C01S001Respons();
        Knifeinventory entity = new Knifeinventory();
        // 参数验证
        if (StringUtils.isEmpty(request.getCustomerID()) || StringUtils.isEmpty(request.getProcuredBatch())) {
            throw new BusinessException(IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
        } else {
            // 用户ID
            entity.setCreateUser(request.getCustomerID());
            // 批次
            entity.setProcuredBatch(request.getProcuredBatch());
        }
        List<InputTool> inputToolList = request.getInputToolList();
        List<Map<String, Object>> toolList = new ArrayList<Map<String, Object>>();
        if (inputToolList.size() > 0) {
            for (InputTool inputTool : inputToolList) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("RfidCode", inputTool.getRfidCode());
                item.put("MaterialNum", inputTool.getMaterialNum());
                item.put("Unitnumber", inputTool.getUnitnumber());
                item.put("ToolID", inputTool.getToolID());
                item.put("HandSetID", request.getHandSetId());
                toolList.add(item);
            }
        }

        // 提交钻头入库信息
        Map<String, Object> ret = iCOMPV01C01S001Service.setBitInputInf(toolList, entity);
        if (Integer.parseInt(ret.get("status").toString()) < 0) {
            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStateCode(ret.get("status").toString());
        respons.setStateMsg("入库成功");

        return respons;

    }

    /**
     * 根据输入的材料号查询刀片（钻头）的入库信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S001Respons searchBitInputInf(C01S001Request request) throws Exception {
        C01S001Respons respons = new C01S001Respons();
        Tool entity = new Tool();
        try {
            // 参数验证
            if (StringUtils.isEmpty(request.getMaterialNum())) {
                throw new BusinessException(IConstant.WMSG0221, IConstant.LANGUAGE_CODE_ZH, IConstant.LANGUAGE_VALUE);
            }
            // 刀具编码
            entity.setToolCode(request.getMaterialNum());
            entity.setDelFlag(IConstant.DEL_FLAG_0);
            Tool tool = iCOMPV01C01S001Service.searchBitInputInf(entity);
            if (tool.getToolCode() == null) {
                respons.setStateCode(IConstant.DEL_FLAG_1);
                respons.setStateMsg("未找到相应的材料号信息");
                return respons;
            }
            // 刀具消耗类别(0:钻头,非0:刀片)
            String toolConsumetype = tool.getToolConsumetype();
            
            // 材料号
            respons.setMaterialNum(tool.getToolCode());
            // 库位码
            respons.setLibraryCodeID(tool.getLibraryCodeID());
            // 在新刀库存表中统计库存量
			Knifeinventory ki2 = new Knifeinventory();
			ki2.setToolID(tool.getToolID());
			ki2.setDelFlag(IConstant.STRING_0);
			List<Knifeinventory> kiList2 = iCOMPV01C01S001Service.getKnifeinventoryInfo(ki2);
			if (kiList2.size()<1) {
				// 库存量为0
				respons.setUnitnumber(IConstant.STRING_0);
			}else {
				if (IConstant.STRING_0.equals(toolConsumetype)) {
					//钻头的库存量
					respons.setUnitnumber(kiList2.size()+"");
				}else {
					//刀片的库存量
					int sum = 0;
					for (Knifeinventory knifeinventory : kiList2) {
						sum = sum + Integer.parseInt(knifeinventory.getKnifelnventoryNumber());
					}
					respons.setUnitnumber(sum+"");
				}
			}
            
            // 刀具ID
            respons.setToolID(tool.getToolID());
            // 消耗类别(0:可刃磨钻头1可刃磨刀片2一次性刀片9其他)
            respons.setToolConsumetype(tool.getToolConsumetype());

            Toolprocured toolprocured = new Toolprocured();
            toolprocured.setToolCode(tool.getToolCode());
            toolprocured.setDelFlag(IConstant.DEL_FLAG_0);
            toolprocured.setOrderString("ProcuredTime DESC");
            // 获取可用批次
            List<Toolprocured> toolprocureds = iCOMPV01C01S001Service.getProcuredBatchList(toolprocured);
            if (toolprocureds.size() <= 0) {
                respons.setStateCode(IConstant.STRING_2);
                respons.setStateMsg("系统无可用入库批次");
                return respons;
            }
            List<ProcuredBatchCount> pbcList = new ArrayList<ProcuredBatchCount>();
            for (Toolprocured tp : toolprocureds) {
                ProcuredBatchCount pbc = new ProcuredBatchCount();
                pbc.setProcuredBatch(tp.getProcuredBatch());// 采购批次
                pbc.setProcuredCount(String.valueOf(tp.getProcuredCount()));// 采购数量
                pbcList.add(pbc);
            }
            respons.setProcuredBatchCount(pbcList);
            respons.setStateCode(IConstant.STOCK_STATE_0);
            respons.setStateMsg("获取成功");
        } catch (Exception e) {
            respons.setStateCode(IConstant.STOCK_STATE_2);
            respons.setStateMsg("获取失败");
        }

        return respons;
    }

    /**
     * 提交刀片入库信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    public C01S001Respons setToolInputInf(C01S001Request request) throws Exception {
        C01S001Respons respons = new C01S001Respons();
        Knifeinventory entity = new Knifeinventory();

        // 传入数据 存在性校验
        Map<String, Object> rtn = cuttingToolStorageCheck(request);
        if (Integer.parseInt(rtn.get("status").toString()) < 0) {
            respons.setStateCode(rtn.get("status").toString());
            respons.setStateMsg(rtn.get("messagetext").toString());
            return respons;
        } else {
            // 用户ID
            entity.setCreateUser(request.getCustomerID());
            // 刀具ID
            entity.setToolID(request.getToolID());
            // 批次
            entity.setProcuredBatch(request.getProcuredBatch());
            // 入库数量
            entity.setKnifelnventoryNumber(request.getStorageNum());
        }

        // 提交刀片入库信息
        Map<String, Object> ret = iCOMPV01C01S001Service.setToolInputInf(entity,request.getMaterialNum());
        if (ret.get("status").toString().equals(IConstant.RESULT_CODE_2)) {
            throw new BusinessException(ret.get("messagetext").toString(), request.getLanguageCode(), request.getLanguageValue());
        }
        respons.setStateCode(ret.get("status").toString());
        respons.setStateMsg(ret.get("messagetext").toString());
        return respons;

    }

    /**
     * 传入数据 存在性校验
     *
     * @param request
     * @return
     * @throws Exception
     */
    private Map<String, Object> cuttingToolStorageCheck(C01S001Request request) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        Map<String, Object> msgMap = new HashMap<String, Object>();
        if (StringUtils.isEmpty(request.getCustomerID())) {
            msgMap.put("MessageCode", "未传入用户ID");// 未传入用户ID
        }
        if (StringUtils.isEmpty(request.getMaterialNum())) {
            msgMap.put("MessageCode", "未传入材料号");// 未传入材料号
        }
        if (StringUtils.isEmpty(request.getProcuredBatch())) {
            msgMap.put("MessageCode", "未传入批次");// 未传入批次
        }
        if (StringUtils.isEmpty(request.getStorageNum())) {
            msgMap.put("MessageCode", "未传入入库数量");// 入库数量
        }
        if (StringUtils.isEmpty(request.getToolID())) {
            msgMap.put("MessageCode", "未传入刀具ID");// 刀具ID
        }
        if (msgMap.size() > 0) {
            rtn.put("status", IConstant.RESULT_CODE_1);
            rtn.put("messagetext", msgMap);
        } else {
            rtn.put("status", IConstant.RESULT_CODE_0);
        }
        return rtn;
    }

}
