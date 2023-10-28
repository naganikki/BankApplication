package com.web.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
	@NotEmpty
	@Size(min = 5,max = 30,message = "name should be min 5 or max 30 in length")
	@Schema(
			name = "customer name",
			description = "stores customer name" , example = "Nagaraju"		
			)
	private String name;
	@NotEmpty
	@Email(message = "email should be i valid format")
	@Schema(
			description = "email of customer"
			)
	private String email;
	@Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be 10 digit")
	@Schema(
			description = "mobile number of custimer"
			)
	private String mobileNumber;
	@Schema(
			description = "customer contains account details also"
			)	
	private AccountsDto accountsDto;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	public AccountsDto getAccountsDto() {
		return accountsDto;
	}
	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}
	
}
