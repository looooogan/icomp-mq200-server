package com.icomp.v01b03.b03s003.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Merchants;
import com.icomp.v01b03.b03s002.business.B03S002Business;
import com.icomp.v01b03.b03s003.business.B03S003Business;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库房待修复刀具查询
 *
 * @author Taoyy
 * @ClassName: B01S003Action
 * @date 2014-8-12 下午04:15:17
 */
public class B03S003Action extends IcompAction {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 库房待修复刀具查询BUSINESS
     */
    private B03S003Business b03s003Business;

    public void setB03s003Business(B03S003Business b03s003Business) {
        this.b03s003Business = b03s003Business;
    }

    private B03S002Business b03s002Business;

    public void setB03s002Business(B03S002Business b03s002Business) {
        this.b03s002Business = b03s002Business;
    }


    /**
     * 页面初始化
     *
     * @return String
     * @title initb03S006
     */
    public String initb03S003() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 参数
            Map<String, Object> param = super.param();
            if ("list".equals(param.get("opt"))) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b03s002Business.getListMerchants(param, langCode, langValue,1);
                super.ajaxReturn(list);
                return null;
            }
            total = this.b03s002Business.getMnumber();
            // 取得页面grid显示项目列表
            /*super.session("gridcol", b03s002Business.getGridColmun(
					"B03S003", ((Customer) super.session("Customer"))
							.getCustomerID(), langCode,  langValue));*/
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B03S003.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B03S003", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 新建厂外通知单
     *
     * @return String
     * @title initb03S003
     */
    public String merchantsAdd() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 参数
            Map<String, Object> param = super.param();
            if ("add".equals(param.get("opt"))) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b03s002Business.merchantsAdd(param, langCode, langValue,((Customer) super.session("Customer"))
                        .getCustomerID());
                super.ajaxReturn(list);
                return null;
            }
            // 取得页面grid显示项目列表
            super.session("gridcol", b03s002Business.getGridColmun(
                    "B03S003", ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode, langValue));
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B03S003.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B03S003", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }

    }

    /**
     * 取得厂家信息
     *
     * @return
     */
    public String merchantsInfo() {
        try {
            String langValue = ((Languagetable) super.session("Languagetable"))
                    .getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable"))
                    .getLanguageCode();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b03s002Business.merchantsInfo(param, langCode, langValue);
            super.ajaxReturn(ret);
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/userInfo.action",
                    IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
                    "userInfo", ((Customer) super.session("Customer"))
                            .getCustomerID());
            return null;
        }
    }

    public String merchantsEdit() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            // 参数
            Map<String, Object> param = super.param();
            if ("find".equals(param.get("opt"))) {
                //  修复通知单查询列表
                Map<String, Object> list = this.b03s002Business.merchantsFind(param, langCode, langValue);
                super.ajaxReturn(list);
                return null;
            } else if ("edit".equals(param.get("opt"))) {
                param.put("userID", ((Customer) super.session("Customer"))
                        .getCustomerID());
                //  修复通知单查询列表
                Map<String, Object> list = this.b03s002Business.merchantsEdit(param, langCode, langValue,((Customer) super.session("Customer"))
                        .getCustomerID());
                super.ajaxReturn(list);
                return null;
            }
            // 取得页面grid显示项目列表
            super.session("gridcol", b03s002Business.getGridColmun(
                    "B03S003", ((Customer) super.session("Customer"))
                            .getCustomerID(), langCode, langValue));
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B03S003.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B03S003", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        }
    }

    /**
     * 删除
     *
     * @return
     */
    public String merchantsDelete() {
        try {
            String langValue = ((Languagetable) super.session("Languagetable")).getLanguageValue();
            String langCode = ((Languagetable) super.session("Languagetable")).getLanguageCode();
            Map<String, Object> param = super.param();
            Map<String, Object> ret = this.b03s002Business.merchantDelete(param, ((Customer) super.session("Customer")).getCustomerID(), langCode, langValue);
            if (ret.get("message") != null && !"-2".equals(ret.get("status").toString())) {
                super.ajaxReturn(null, null, ret.get("message"), Integer.parseInt(ret.get("status").toString()));
                return null;
            } else {
                super.ajaxReturn(ret);
            }
            //记录删除成功日志
//            CommonLogUtil.saveBrowsLog(langCode, this.getClass().getName(),"userDelete", IConstant.SYSTEM_LOG_FLAG_1
//                    ,IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session("Customer"))
//                            .getCustomerID(),
//                    ret.get("message").toString());
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(), "/userDelete.action",
                    IConstant.RESULT_CODE_1, ex, this.getClass().getName(),
                    "userDelete", ((Customer) super.session("Customer"))
                            .getCustomerID());
            return null;
        }

    }

    //	excel下载

    public String exportExcel() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("merchantsCold", merchantsCold);
        param.put("merchantsName", merchantsName);
        param.put("innerName", innerName);

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

            cells.setCellValue("厂家编码");
            cells=rows.createCell(1);
            if ("".equals(merchantsCold)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(merchantsCold);
            }
            cells =rows.createCell(2);
            cells.setCellValue("修磨厂家名称");
            cells=rows.createCell(3);
            if ("".equals(merchantsName)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(merchantsName);
            }
            cells =rows.createCell(4);

            cells.setCellValue("联系人");
            cells=rows.createCell(5);
            if ("".equals(innerName)){
                cells.setCellValue("-");
            }else {
                cells.setCellValue(innerName);
            }

            HSSFRow rowsd = sheet.createRow(2);//创建第三行
            HSSFCell cellsd = rowsd.createCell(0);//创建这行的第一个元素.从0开始
            sheet.addMergedRegion(new CellRangeAddress(2,2, 0, 9));//合并单元格
            cellsd.setCellValue("详细");
            cellsd.setCellStyle(style);



            HSSFRow row = sheet.createRow(3);//创建一行
            HSSFCell cell = row.createCell(0);//创建这行的第一个元素.从0开始
            cell.setCellValue("厂家编码");//写入内容
            cell.setCellStyle(style);

            cell = row.createCell(1);//同上
            cell.setCellValue("厂家名称");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("厂家类型");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("联系人");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("电话");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("地址");
            cell.setCellStyle(style);


            Map<String, Object> list = new HashMap<String, Object>();
            try {
                list = this.b03s002Business.getListMerchants(param, "", "", 2);
                if (list == null && list.size() < 0) {
                    list = new HashMap<String, Object>();
                }
            } catch (Exception e1) {
                System.out.println("ecxel导出异常");
            }
            List<Merchants> merList = (List<Merchants>) list.get("rows");
            if (merList == null) {
                merList = new ArrayList<Merchants>();
            }

            //循环,将下面几行的数据取出来放入这个sheet中
            for (int i = 0; i < merList.size(); i++) {
                Merchants merchants = merList.get(i);
                row = sheet.createRow(i +4);
//row.createCell(0).setCellValue("");
                cell = row.createCell(0);//厂家类型
                if ("".equals(merchants.getMerchantsCold())||merchants.getMerchantsCold()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(merchants.getMerchantsCold());
                }

                cell = row.createCell(1);//厂家名称
                if ("".equals(merchants.getMerchantsName())||merchants.getMerchantsName()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(merchants.getMerchantsName());
                }
                cell = row.createCell(2);//0修磨1涂层
                if (IConstant.STRING_0.equals(merchants.getMerchantsType())){
                    cell.setCellValue("修磨");
                }else if (IConstant.STRING_1.equals(merchants.getMerchantsType())){
                    cell.setCellValue("涂层");
                }else{
                    cell.setCellValue("其他");
                }

                cell = row.createCell(3);//联系人
                if ("".equals(merchants.getInnerName())||merchants.getInnerName()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(merchants.getInnerName());
                }
                cell = row.createCell(4);//电话
                if ("".equals(merchants.getMerchantsTel())||merchants.getMerchantsTel()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(merchants.getMerchantsTel());
                }
                cell = row.createCell(5);//地址
                if ("".equals(merchants.getMerchantsAddrss())||merchants.getMerchantsAddrss()==null){
                    cell.setCellValue("-");
                }else {
                    cell.setCellValue(merchants.getMerchantsAddrss());
                }
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            wb.write(os);
            os.close();
            byte[] fileContent = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(fileContent);
            excelStream = is;
            excelFileName = "厂外修磨商家.xls";
            excelFileName = new String(excelFileName.getBytes("gb2312"),
                    "iso8859-1");
            is.close();
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(getResponse(),
                    "/B03S003.action", IConstant.RESULT_CODE_1, ex,
                    this.getClass().getName(), "B03S003", ((Customer) super
                            .session("Customer")).getCustomerID());
            return null;
        } catch (IOException e) {
            System.out.println("写入流异常");
        }
        return "exportExcels";

    }
    private String merchantsCold;
    private String merchantsName;
    private String innerName;
    private InputStream excelStream;
    private String excelFileName;

    public String getMerchantsCold() {
        return merchantsCold;
    }

    public void setMerchantsCold(String merchantsCold) {
        this.merchantsCold = merchantsCold;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }

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
}

