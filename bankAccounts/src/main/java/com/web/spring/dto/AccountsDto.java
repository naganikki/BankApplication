package com.web.spring.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
		name = "holds account details",
		description = "details like account number, address..."
		)
public class AccountsDto {
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{10})",message = "account number should be 10 digit")
	@Schema(
			name = "10 digit account number",
			description = "primary key"
			)
	private Long accountNumber;
	@NotEmpty
	@Schema(
			name = "type of account",
			description = "reflect either savings or current account"
			)
	private String accountType;
	@NotEmpty
	@Schema(
			name = "address",
			description = "branch address where located"
			)
	private String branchAddress;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	@Override
	public String toString() {
		return "AccountsDto [accountNumber=" + accountNumber + ", accountType=" + accountType + ", branchAddress="
				+ branchAddress + "]";
	}
	
}
