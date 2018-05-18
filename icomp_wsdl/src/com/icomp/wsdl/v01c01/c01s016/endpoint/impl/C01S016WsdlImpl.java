package com.icomp.wsdl.v01c01.c01s016.endpoint.impl;

import javax.jws.WebService;

import Decoder.BASE64Decoder;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.common.utils.CommonLogUtil;
import com.icomp.common.utils.MessageReSource;
import com.icomp.common.wsdl.BaseWsdl;
import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Request;
import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Respons;
import com.icomp.wsdl.v01c01.c01s016.business.C01S016Business;
import com.icomp.wsdl.v01c01.c01s016.business.impl.C01S016BusinessImpl;
import com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Wsdl;
/**
 * 回库处理-Webservce实现类
 * @ClassName: C01S016WsdlImpl 
 * @author Taoyy
 * @date 2016-3-1 下午12:01:17
 */
@WebService(endpointInterface = "com.icomp.wsdl.v01c01.c01s016.endpoint.C01S016Wsdl")
public class C01S016WsdlImpl extends BaseWsdl implements C01S016Wsdl{
	
	/**
	 * 旧刀入库交接-Business接口
	 */
	private C01S016Business c01S016Business;
	
	public void setC01S016Business(C01S016BusinessImpl c01S016Business) {
		this.c01S016Business = c01S016Business;
	}
	private C01S016Request regSwitch;
	/**
	 * 取得扫描刀具的修复信息
	 */
	public String getToolInfo(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S016Request)obj;
			// 取得扫描刀具的修复信息
			C01S016Respons ret = (C01S016Respons)c01S016Business.getToolInfo(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolInfo", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0084,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S016WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S016WsdlImpl","getToolInfo",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	public String saveToolJoint(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S016Request)obj;
			// 生成申领单号
			C01S016Respons ret = (C01S016Respons)c01S016Business.saveToolJoint(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"saveToolJoint", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0085,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S016WsdlImpl","saveToolJoint",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S016WsdlImpl","saveToolJoint",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 非单品-回库处理
	 */
	@Override
	public String getToolInfoDetail(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S016Request)obj;
			// 非单品-回库处理
			C01S016Respons ret = (C01S016Respons)c01S016Business.getToolInfoDetail(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolInfoDetail", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0084,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S016WsdlImpl","getToolInfoDetail",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S016WsdlImpl","getToolInfoDetail",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}
	
	/**
	 * 非单品-回库处理-刀具回库
	 */
	@Override
	public String saveToolInfoDetail(String request) throws Exception {
		try{
			//反序列化
			byte[] buf = new BASE64Decoder().decodeBuffer(request);  
			Object obj = bytesToObject(buf);
			regSwitch = (C01S016Request)obj;
			// 非单品-回库处理
			C01S016Respons ret = (C01S016Respons)c01S016Business.saveToolInfoDetail(regSwitch);
			byte[] tre = objectToBytes(ret);
			//记录查询日志
			CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(),"getToolInfoDetail", IConstant.SYSTEM_LOG_FLAG_0
					,IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(),
					MessageReSource.getMessageBox(IConstant.CIMSG0084,regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(BusinessException ex){
			ApplicationException.setApplicationException(ex,"C01S016WsdlImpl","getToolInfoDetail",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}catch(Exception ex){
			ApplicationException.setApplicationException(ex.getMessage(),"C01S016WsdlImpl","getToolInfoDetail",regSwitch.getCustomerID());
			C01S016Respons ret = new C01S016Respons();
			ret.setMessageText(ex.getMessage());
			byte[] tre = objectToBytes(ret);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(tre));
		}
	}

	/**
	 * 取得待报废刀具信息
	 */
	@Override
	public String getToolLibraryInfo(String request) throws Exception {
		try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S016Request) obj;
            // 取得待报废刀具信息
            C01S016Respons ret = (C01S016Respons) c01S016Business.getToolLibraryInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "getToolLibraryInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0055, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S016WsdlImpl", "getToolLibraryInfo", regSwitch.getCustomerID());
            C01S016Respons ret = new C01S016Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S016WsdlImpl", "getToolLibraryInfo", regSwitch.getCustomerID());
            C01S016Respons ret = new C01S016Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}

	@Override
	public String saveToolLibraryInfo(String request) throws Exception {
		try {
            //反序列化
            byte[] buf = new BASE64Decoder().decodeBuffer(request);
            Object obj = bytesToObject(buf);
            regSwitch = (C01S016Request) obj;
            // 取得待报废刀具信息
            C01S016Respons ret = (C01S016Respons) c01S016Business.saveToolLibraryInfo(regSwitch);
            byte[] tre = objectToBytes(ret);
            //记录查询日志
            CommonLogUtil.saveBrowsLog(regSwitch.getLanguageCode(), this.getClass().getName(), "saveToolLibraryInfo", IConstant.SYSTEM_LOG_FLAG_0, IConstant.SYSTEM_LOG_LEVEL_0, regSwitch.getCustomerID(), MessageReSource.getMessageBox(IConstant.CIMSG0055, regSwitch.getLanguageCode(), regSwitch.getLanguageValue()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (BusinessException ex) {
            ApplicationException.setApplicationException(ex, "C01S016WsdlImpl", "saveToolLibraryInfo", regSwitch.getCustomerID());
            C01S016Respons ret = new C01S016Respons();
            ret.setMessageText(ex.getLocalMessage()); 			ret.setStateMsg(ex.getLocalMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        } catch (Exception ex) {
            ApplicationException.setApplicationException(ex.getMessage(), "C01S016WsdlImpl", "saveToolLibraryInfo", regSwitch.getCustomerID());
            C01S016Respons ret = new C01S016Respons();
            ret.setMessageText(ex.getMessage());
            byte[] tre = objectToBytes(ret);
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(tre));
        }
	}
}
