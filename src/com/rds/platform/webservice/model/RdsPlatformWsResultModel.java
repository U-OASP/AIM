package com.rds.platform.webservice.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "wsresult")
public class RdsPlatformWsResultModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4185630904061109209L;
	private String resultCode;
	private String errorMsg;
	private Object data;
	
	@XmlElement(name="resultCode")
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	@XmlElement(name="errorMsg")
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@XmlElement(name="data")
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "{resultCode:\""+resultCode+"\",errorMsg:\""+errorMsg+"\",data:"+data.toString()+"}";
	}
}
