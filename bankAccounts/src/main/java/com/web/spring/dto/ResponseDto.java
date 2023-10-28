package com.web.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
		name = "Response",
		description = "displays succesful scenario"
		)
public class ResponseDto {
	public ResponseDto(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}
	@Schema(
			description = "displays status code",example = "200"
			)	
	private String statusCode;
	@Schema(
			description = "displays status messages",example = "created"
			)
	private String statusMsg;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	@Override
	public String toString() {
		return "ResponseDto [statusCode=" + statusCode + ", statusMsg=" + statusMsg + "]";
	}
	

}
