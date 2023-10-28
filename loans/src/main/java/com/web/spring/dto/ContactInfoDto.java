package com.web.spring.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "loans")
//public record ContactInfoDto(String message,Map<String,String> contactDetails,List<String> onCallSupport) {
//
//}
public class ContactInfoDto {
	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(Map<String, String> contactDetails) {
		this.contactDetails = contactDetails;
	}
	public List<String> getOnCallSupport() {
		return onCallSupport;
	}
	public void setOnCallSupport(List<String> onCallSupport) {
		this.onCallSupport = onCallSupport;
	}
	
}
