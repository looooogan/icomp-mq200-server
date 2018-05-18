package com.icomp.v01b07.b07s001.action;

import com.icomp.common.action.IcompAction;
import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.ExcelDown;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Werkzeugeanforderun;
import com.icomp.v01b07.b07s001.business.B07S001Business;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 入库信息查询Action
 *
 * @author Licc
 * @ClassName: B01S001Action
 * @date 2014-8-20 下午02:31:34
 */
public class B07S001Action extends IcompAction {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 7255161566182210074L;
    /**
     * 在途计划报警查询BUSINESS
     */
    private B07S001Business b07s001Business;

    public void setB07s001Business(B07S001Business b07s001Business) {
        this.b07s001Business = b07s001Business;
    }

    /**
     * 页面初始化
     *
     * @return String
     * @title initb07S001
     */
    public String initb07S001() {
        try {
            // 语言实体类
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            //参数
            Map<String, Object> param = super.param ();
            if ("list".equals ( param.get ( "opt" ) )) {
                // 在途计划报警查询列表
                Map<String, Object> list = this.b07s001Business.getList ( param, langCode, langValue );
                super.ajaxReturn ( list );
                return null;
            } else {
                // 取得页面grid显示项目列表
                super.session ( "gridcol", b07s001Business.getGridColmun ( "B07S001", ((Customer) super.session ( "Customer" )).getCustomerID (), langCode, langValue ) );
            }
            return SUCCESS;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/B07S001.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B07S001", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    public String werDelete() {
        try {
            String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
            String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
            Map<String, Object> param = super.param ();
            Map<String, Object> ret = this.b07s001Business.werDelete ( param);
            if (ret.get ( "message" ) != null && !"-2".equals ( ret.get ( "status" ).toString () )) {
                super.ajaxReturn ( null, null, ret.get ( "message" ), Integer.parseInt ( ret.get ( "status" ).toString () ) );
                return null;
            } else {
                super.ajaxReturn ( ret );
            }
            //记录删除成功日志
            CommonLogUtil.saveBrowsLog ( langCode, this.getClass ().getName (), "werDelete", IConstant.SYSTEM_LOG_FLAG_1, IConstant.SYSTEM_LOG_LEVEL_0, ((Customer) super.session ( "Customer" )).getCustomerID (), ret.get ( "message" ).toString () );
            return null;
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException ( getResponse (), "/werDelete.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "werDelete", ((Customer) super.session ( "Customer" )).getCustomerID () );
            return null;
        }
    }

    public String excelDown() {

        String langCode = ((Languagetable) super.session ( "Languagetable" )).getLanguageCode ();
        String langValue = ((Languagetable) super.session ( "Languagetable" )).getLanguageValue ();
        String userID = ((Customer) super.session ( "Customer" )).getCustomerID ();
        InputStream fis = null;
        state = "";
        List<Werkzeugeanforderun> insertList = new ArrayList<Werkzeugeanforderun> ();
        List<Werkzeugeanforderun> insertList1 = new ArrayList<Werkzeugeanforderun> ();
        List<String> demandCodes = new ArrayList<String> ();
        Map<String, Object> werMap = new HashMap<String, Object> ();
        String realpath = ServletActionContext.getServletContext ().getRealPath ( "/excel" );
        String fileName = fileFileName;
        if (file != null) {
            //			String[] suffixArr =  fileName.split("[.]");
            //			String fileNewFileName = getNewFileName()+"."+suffixArr[suffixArr.length-1];
            //			System.out.println(fileNewFileName);
            File savefile = new File ( new File ( realpath ), fileName );
            if (!savefile.getParentFile ().exists ()) {
                savefile.getParentFile ().mkdirs ();
            }
            try {
                FileUtils.copyFile ( file, savefile );

                String excelPath = realpath + "//" + fileFileName;
                fileName = "";
                System.out.println ( excelPath );
                //输入流

                try {
                    fis = new FileInputStream ( excelPath );

                    //POI:得到解析Excel的实体集合
                    List<Werkzeugeanforderun> infos = ExcelDown.importEmployeeByPoi ( fis );

                    try {

                        Map<String, Object> sMap = this.b07s001Business.dbWerforderun ( infos, langCode, langValue, userID );
                        if (sMap.size () > 1 && sMap.get ( "error" ) != null) {
                            state = "文件上传失败，请核对后重新上传！";
                        } else {
                            state = "文件上成功！";
                        }

                        try {
                            fis.close ();

                        } catch (IOException e) {
                            throw new BusinessException ( IConstant.WMSG0112, langCode, langValue );
                        }

                    } catch (BusinessException ex) {
                        ApplicationException.setApplicationException ( getResponse (), "/B07S001.action", IConstant.RESULT_CODE_1, ex, this.getClass ().getName (), "B07S005", ((Customer) super.session ( "Customer" )).getCustomerID () );
                        return null;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace ();
                }

            } catch (Exception e) {
                e.printStackTrace ();
                state = "文件上传失败，请重新上传！";
            }
        } else {
            return NONE;
        }

        return SUCCESS;
    }

    private String state;

    private File file;
    private String fileFileName;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

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
}
