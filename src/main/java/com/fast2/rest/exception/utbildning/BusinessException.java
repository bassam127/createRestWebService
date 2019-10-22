package com.fast2.rest.exception.utbildning;

import java.io.IOException;
import java.io.Serializable;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BusinessException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private BusinessExceptionData data = new BusinessExceptionData();

	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
		this.data.moreInfo = message;	
	}
	
	public BusinessException(String message , Response.Status status) {
		this(message);
		setMoreInfo(message);
		setErrorCode(status.getStatusCode());
	}

	public int getErrorCode() {
		return this.data.errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.data.errorCode = errorCode;
	}

	public String getFriendlyMessage() {
		return this.data.friendlyMessage;
	}

	public void setFriendlyMessage(String friendlyMessage) {
		this.data.friendlyMessage = friendlyMessage;
	}

	public String getDeveloperMessage() {
		return this.data.DeveloperMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.data.DeveloperMessage = developerMessage;
	}

	public String getMoreInfo() {
		return this.data.moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.data.moreInfo = moreInfo;
	}
	
	   public String toJson() {

	        ObjectMapper Obj = new ObjectMapper();

	        String jsonStr = "";
	        try {
	            jsonStr = Obj.writeValueAsString(this.data);
	        } catch (JsonGenerationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (JsonMappingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return jsonStr;
	    }

	public static class BusinessExceptionData{
		public int errorCode;
		public String friendlyMessage;
		public String DeveloperMessage;
		public String moreInfo = "";
		
		public BusinessExceptionData() {
			
		}
		
	}

}
