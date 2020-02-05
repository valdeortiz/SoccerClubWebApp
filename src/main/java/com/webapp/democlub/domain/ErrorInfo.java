package com.webapp.democlub.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int status_code;
	@JsonProperty("uri")
	private String uri;
	
//	public ErrorInfo(ApiException exception, String uri) {
//		this.message = exception.getMessage();
//		this.status_code = ;
//		this.uri = uri;
//	}
	
	public ErrorInfo(int status_code, String message, String uri) {
		this.message = message;
		this.status_code = status_code;
		this.uri = uri;
	}
	public String getMessage() {
		return message;
	}
	public int getStatus_code() {
		return status_code;
	}
	public String getUri() {
		return uri;
	}
	
	
}
