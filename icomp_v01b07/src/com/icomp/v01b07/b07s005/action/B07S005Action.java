package com.icomp.v01b07.b07s005.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.ExcelDown;
import com.icomp.entity.base.*;
import com.icomp.v01b07.b07s005.business.B07S005Business;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.lang.System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 建议采购计划查询
 *
 * @author Taoyy
 * @ClassName: B07S005Action
 * @date 2014-9-12 上午09:31:13
 */

public class B07S005Action extends IcompAction {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 建议采购计划查询BUSINESS
     */
    private B07S005Business b07s005Business;

    public void setB07s005Business(B07S005Business b07s005Business) {
        this.b07s005Business = b07s005Business;
    }

    /**
     * 建议采购计划查询页面初始化
     *
     * @return String
     * @title initb03S005
     */
    public String initb07S005() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 参数
            Map<String, Object> param = super.param();
            if ("list".equals(param.get("opt"))) {
                // 建议采购计划按条件查询
                Map<String, Object> list = this.b07s005Business.getList(param, langCode, langValue,1);
                super.ajaxReturn(list);

                return NONE;
            } else {
                // 取得零部件列表
                List<Parts> partsList = b07s005Business.getPartsList();
                super.assign("partsList", partsList);
              //  List<Formulas> formulasList = b07s005Business.getFormulasList();
                // 取得全部公式
             //   super.assign("formulasList", formulasList);
                // 取得页面grid显示项目列表
               // super.session("gridcol", b07s005Business.getGridColmun("B07S005", ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue));
            }
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/B07S005.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B07S005", ((Customer) super.session("Customer")).getCustomerID());
            return null;
        } catch (Exception ex) {
            ApplicationException.setApplicationException( ex.toString(),"/B07S005.action", this.getClass().getName(), ((Customer) super.session("Customer")).getCustomerID());
        }
        return null;
    }


    public  String partAdd(){
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 根据用户选择的机构ID，取得 相应的部门及职务列表
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b07s005Business.parttAdd(param, langCode, langValue,((Customer) super.session("Customer")).getCustomerID());

            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/prossAndBuss.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "prossAndBuss",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }

    public  String partList(){
        try {
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 根据用户选择的机构ID，取得 相应的部门及职务列表
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b07s005Business.partList(param, langCode, langValue,((Customer) super.session("Customer")).getCustomerID());
            super.ajaxReturn(ret);
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/prossAndBuss.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "prossAndBuss",
                    ((Customer) super.session("Customer")).getCustomerID());
            return null;
        }
    }
    public  String partList1(){
        try {
            // 根据用户选择的机构ID，取得 相应的部门及职务列表
            Map<String, Object> param = super.param();
            List<Formulas> formulasList = b07s005Business.getFormulasList();
            // 取得全部公式
            super.ajaxReturn(formulasList);
            return null;
        } catch (Exception ex) {
            ApplicationException.setApplicationException( ex.toString(),"/B07S005.action", this.getClass().getName(), ((Customer) super.session("Customer")).getCustomerID());

            return null;
        }
    }



    public String partDel(){
        try {
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b07s005Business.fmolDel(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);
            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/userDelete.action",
                    IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
                    "userDelete", ((Customer) super.session("Customer"))
                            .getCustomerID());
            return null;
        }
    }
    public String partInfo(){
        try {
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b07s005Business.partInfo(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);
            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/userDelete.action",
                    IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
                    "userDelete", ((Customer) super.session("Customer"))
                            .getCustomerID());
            return null;
        }
    }
    public String partEdit(){
        try {
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b07s005Business.partEdit(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);
            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/userDelete.action",
                    IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
                    "userDelete", ((Customer) super.session("Customer"))
                            .getCustomerID());
            return null;
        }
    }
    private String state;

    private File file;
    private String fileFileName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }



    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //excel 导入
    public String excelDown() {

        String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
        String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
        String userID = ((Customer) super.session("Customer")).getCustomerID();
        InputStream fis = null;
        state = "";
        List<Werkzeugeanforderun> insertList = new ArrayList<Werkzeugeanforderun>();
        List<Werkzeugeanforderun> insertList1 = new ArrayList<Werkzeugeanforderun>();
        List<String> demandCodes = new ArrayList<String>();
        Map<String, Object> werMap = new HashMap<String, Object>();
        String realpath = ServletActionContext.getServletContext().getRealPath("/excel");
        String fileName = fileFileName;
        if (file != null) {
            //			String[] suffixArr =  fileName.split("[.]");
            //			String fileNewFileName = getNewFileName()+"."+suffixArr[suffixArr.length-1];
            //			System.out.println(fileNewFileName);
            File savefile = new File(new File(realpath), fileName);
            if (!savefile.getParentFile().exists()) {
                savefile.getParentFile().mkdirs();
            }
            try {
                FileUtils.copyFile(file, savefile);

                String excelPath = realpath + "//" + fileFileName;
                fileName = "";
                System.out.println(excelPath);
                //输入流

                try {
                    fis = new FileInputStream(excelPath);

                    //POI:得到解析Excel的实体集合
                   List<Werkzeugeanforderun> infos = ExcelDown.importEmployeeByPoi(fis);

                    try {

                        Map<String, Object> sMap = this.b07s005Business.dbWerforderun(infos, langCode, langValue, userID);
                        if (sMap.size() > 1 && sMap.get("error") != null) {
                            state = "文件上传失败，请重新上传！";
                        } else {
                            state = "文件上成功！";
                        }

                        try {
                            fis.close();

                        } catch (IOException e) {
                            throw new BusinessException(IConstant.WMSG0112, langCode, langValue);
                        }

                    } catch (BusinessException ex) {
                        ApplicationException.setApplicationException(getResponse(), "/B07S005.action", IConstant.RESULT_CODE_1, ex, this.getClass().getName(), "B07S005", ((Customer) super.session("Customer")).getCustomerID());
                        return null;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
                state = "文件上传失败，请重新上传！";
            }
        } else {
            return NONE;
        }

        return SUCCESS;
    }


    public String exportExcel() {

      Map<String, Object> param = new HashMap<String, Object>();
      param.put("partsCode", partsCode);
      param.put("DateStar", dstar);
       param.put("DateEnd", dend);
       param.put("formulaID", formulaID);
       param.put("ParamStringA", ParamStringA);
       param.put("ParamStringB", ParamStringB);
       param.put("ParamStringC", ParamStringC);

        try {
            HSSFWorkbook wb = new HSSFWorkbook();//创建一个工作间
            HSSFSheet sheet = wb.createSheet("sheet1");//创建一个sheet
            HSSFCellStyle style = wb.createCellStyle();//居中
            sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 9));//合并单元格

            HSSFRow rowss = sheet.createRow(0);//创建第一行
            HSSFCell cellss = rowss.createCell(0);
            cellss.setCellValue("检索：");
            cellss.setCellStyle(style);

            HSSFRow rows = sheet.createRow(1);//创建第二行
            HSSFCell cells = rows.createCell(0);//创建这行的第一个元素.从0开始

            cells.setCellValue("零部件");
            cells=rows.createCell(1);
            if ("".equals(partsCode)){
                cells.setCellValue("-");
            }else {

                Map<String,Object> list = this.b07s005Business.getPageSelList("", "");
				super.assign("AxleLineList",list.get("AxleLineList"));
				List<Parts> prlist=(List<Parts>)list.get("PartsList");
				for (Parts parts : prlist) {
					if (partsCode.equals(parts.getPartsID())) {
						cells.setCellValue(parts.getPartsName());
						break;
					} else {
						cells.setCellValue("-");
					}
				}

            }
            cells =rows.createCell(2);
            cells.setCellValue("时间");
            cells=rows.createCell(3);
            if ("".equals(dend)&&"".equals(dend)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(dstar+"-"+dend);
            }
            cells =rows.createCell(4);
            cells.setCellValue("实际产量");
            cells=rows.createCell(5);
            if ("".equals(ParamStringA)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(ParamStringA);
            }
            cells =rows.createCell(6);
            cells.setCellValue("计划产量");
            cells=rows.createCell(7);
            if ("".equals(ParamStringB)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(ParamStringB);
            }
            cells =rows.createCell(8);
            cells.setCellValue("采购频率");
            cells=rows.createCell(9);
            if ("".equals(ParamStringC)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(ParamStringC);
            }
            cells =rows.createCell(10);
            cells.setCellValue("计算公式");
            cells=rows.createCell(11);
            if ("".equals(formulaID)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(formulaID);
            }


            HSSFRow rowsd = sheet.createRow(2);//创建第三行
            HSSFCell cellsd = rowsd.createCell(0);//创建这行的第一个元素.从0开始
            sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
            cellsd.setCellValue("详细");
            cellsd.setCellStyle(style);



            HSSFRow row = sheet.createRow(3);//创建一行
            HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始
            cell.setCellValue("材料号");//写入内容
            cell.setCellStyle(style);

            cell = row.createCell(1);//同上
            cell.setCellValue("平均使用次数(D)");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("使用次数(E)");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("库存数量(F)");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("流转数量(G)");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("在途新刀数量(H)");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("在途旧刀数量(I))");
            cell.setCellStyle(style);

            cell = row.createCell(7);
            cell.setCellValue("在途旧刀折新数量(J)");
            cell.setCellStyle(style);

            cell = row.createCell(8);
            cell.setCellValue("采购周期(G)");
            cell.setCellStyle(style);

            cell = row.createCell(9);
            cell.setCellValue("建议采购数量");
            cell.setCellStyle(style);

            Map<String, Object> list = new HashMap<String, Object>();
            try {
                  list = this.b07s005Business.getList(param, "", "",2);
                if (list == null && list.size() < 0) {
                    list = new HashMap<String, Object>();
                }
            } catch (Exception e1) {
                System.out.println("ecxel导出异常");
            }
            List<Vpartsmachiningmsg> vplist = (List<Vpartsmachiningmsg>) list.get("rows");
            if (vplist == null) {
                vplist  = new ArrayList<Vpartsmachiningmsg>();
            }

            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < vplist.size(); i++) {
                Vpartsmachiningmsg vp = vplist.get(i);
                row = sheet.createRow(i +4);
//row.createCell(0).setCellValue("");
                cell = row.createCell(0);//材料号
                if ("".equals(vp.getToolCode())||vp.getToolCode()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getToolCode());
                }

                cell = row.createCell(1);//平均使用次数
                if ("".equals(vp.getAvgFrequencyUse())||vp.getAvgFrequencyUse()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getAvgFrequencyUse());
                }
                cell = row.createCell(2);//使用次数(E)
                if ("".equals(vp.getUsedCounts())||vp.getUsedCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getUsedCounts());
                }

                cell = row.createCell(3);//库存数量(F)
                if ("".equals(vp.getStockCounts())||vp.getStockCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getStockCounts());
                }
                cell = row.createCell(4);//流转数量(G)
                if ("".equals(vp.getActiveCounts())||vp.getActiveCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getActiveCounts());
                }
                cell = row.createCell(5);//在途新刀数量
                if ("".equals(vp.getGoingNewCounts())||vp.getGoingNewCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getGoingNewCounts());
                }
                cell = row.createCell(6);//在途旧刀数量
                if ("".equals(vp.getGoingOldCounts())||vp.getGoingOldCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getGoingNewCounts());
                }
                cell = row.createCell(7);//在途旧刀折新数量
                if ("".equals(vp.getGoingOldToNewCounts())||vp.getGoingOldToNewCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getGoingNewCounts());
                }
                cell = row.createCell(8);//采购周期
                if ("".equals(vp.getProcuresCycle())||vp.getProcuresCycle()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getProcuresCycle());
                }
                cell = row.createCell(9);//建议采购数量
                if ("".equals(vp.getPurchaseCounts())||vp.getPurchaseCounts()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(vp.getGoingNewCounts());
                }
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            wb.write(os);
            os.close();
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            excelStream = is;
            excelFileName = "采购计划建议.xls";
            excelFileName = new String(excelFileName.getBytes("gb2312"),
                    "iso8859-1");
            is.close();
       } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B03S003.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B03S003", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        } catch (Exception e) {
            System.out.println("写入流异常");
        }
        return "exportExcels";

    }

    private String partsCode;
    private String dstar;
    private String dend;
    private String formulaID;
    private String ParamStringA;
    private String ParamStringB;
    private String ParamStringC;
    private InputStream excelStream;
    private String excelFileName;

    public InputStream getExcelStream() {
        return excelStream;
    }

    public void setExcelStream(InputStream excelStream) {
        this.excelStream = excelStream;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

    public String getPartsCode() {
        return partsCode;
    }

    public void setPartsCode(String partsCode) {
        this.partsCode = partsCode;
    }

    public String getDstar() {
        return dstar;
    }

    public void setDstar(String dstar) {
        this.dstar = dstar;
    }

    public String getDend() {
        return dend;
    }

    public void setDend(String dend) {
        this.dend = dend;
    }

    public String getFormulaID() {
        return formulaID;
    }

    public void setFormulaID(String formulaID) {
        this.formulaID = formulaID;
    }

    public String getParamStringA() {
        return ParamStringA;
    }

    public void setParamStringA(String paramStringA) {
        ParamStringA = paramStringA;
    }

    public String getParamStringB() {
        return ParamStringB;
    }

    public void setParamStringB(String paramStringB) {
        ParamStringB = paramStringB;
    }

    public String getParamStringC() {
        return ParamStringC;
    }

    public void setParamStringC(String paramStringC) {
        ParamStringC = paramStringC;
    }
}
