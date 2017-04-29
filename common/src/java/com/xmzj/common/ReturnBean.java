package com.xmzj.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.xmzj.common.Enums.EnumErrorCode;
import com.xmzj.common.Enums.EnumResultCode;
import com.xmzj.common.Enums.EnumReturnCode;
import com.xmzj.common.util.GlobalizationUtils;

public class ReturnBean {
	private static Logger log = Logger.getLogger(ReturnBean.class);
//	private String returnCode="";
//	private String returnMsg="";
	private String resultCode="";
	private String resultMsg="";
	private Object resultData=null;
	 private String errorCode="";
	 private String errorMsg="";
	 
	 
	 
	 
	public ReturnBean(String errorCode,  String resultCode, String resultMsg,
			Object resultData) {
		super();
		this.errorCode = errorCode;
//		this.returnCode = returnCode;
//		this.returnMsg = returnMsg;
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}
	
	public ReturnBean(){}
	
	
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultMsg=EnumResultCode.valueOf(resultCode).getDesc();
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * 实例化成功的ReturnBean
	 * @author lei.ma 2016年5月31日 下午8:23:51 
	 * @param resultData
	 * @return
	 */
	public static ReturnBean getSuccessInstance(Object resultData){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.SUCCESS.getValue());
		rb.setResultData(resultData);
		return rb;
	}
	public static ReturnBean getSuccessInstance(){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.SUCCESS.getValue());
		rb.setResultData(null);
		return rb;
	}
	/**
	 * 实例化成功的ReturnBean,返回的数据用list包装
	 * @author lei.ma 2016年5月31日 下午8:23:51 
	 * @param resultData
	 * @return
	 */
	public static ReturnBean getSuccessListInstance(Object resultData){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.SUCCESS.getValue());
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", resultData);
		rb.setResultData(map);
		return rb;
	}
	/**
	 * 例化失败的ReturnBean，并自定义失败信息
	 * @author lei.ma 2016年5月31日 下午8:24:54 
	 * @param errorCode
	 * @param resultMsg
	 * @return
	 */
	public static ReturnBean getFailInstance(String errorCode,String resultMsg){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.FAIL.getValue());
		rb.setErrorCode(errorCode);
		rb.setResultMsg(resultMsg);
		rb.setErrorMsg(resultMsg);
		log.debug(JSONObject.toJSONString(rb));
		return rb;
	}
	public static ReturnBean getFailInstance(EnumErrorCode  errorEnum,String resultMsg){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.FAIL.getValue());
		rb.setErrorCode(errorEnum.getValue());
		rb.setErrorMsg(resultMsg);
		log.debug(JSONObject.toJSONString(rb));
		return rb;
	}
	/**
	 * 例化失败的ReturnBean，并自定义失败信息
	 * @param errorCode 错误码
	 * @param errorMsg 错误日志
	 * @param resultMsg 错误提示
	 * @return
	 */
	public static ReturnBean getFailInstance(String errorCode,String errorMsg,String resultMsg){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.FAIL.getValue());
		rb.setErrorCode(errorCode);
		rb.setErrorMsg(errorMsg);
		log.debug(JSONObject.toJSONString(rb));
		return rb;
	}
	/**
	 * 例化失败的ReturnBean
	 * @author lei.ma 2016年5月31日 下午8:25:06 
	 * @param errorCode
	 * @return
	 */
	public static ReturnBean getFailInstance(String errorCode){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.FAIL.getValue());
		rb.setErrorMsg(EnumResultCode.FAIL.getValue());
		rb.setErrorCode(errorCode);
		return rb;
	}
	public static ReturnBean getFailInstance(EnumErrorCode paramError){
		ReturnBean rb=new ReturnBean();
		rb.setResultCode(EnumResultCode.FAIL.getValue());
		rb.setErrorCode(paramError.getValue());
		String errorMsg = GlobalizationUtils.getMessage(paramError.getValue());
		if(StringUtils.isEmpty(errorMsg)){
		    errorMsg = paramError.getDesc();
		}
		rb.setErrorMsg(errorMsg);
		return rb;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

//    @Override
//    public String toString() {
////        return super.toString()+":"+JSONObject.toJSONString(this);
//    }
	
	
}
