package com.web.spring.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Schema(
		name = "loan info",
		description = "schema to hold loans information"
		)
@Data
@Getter
@Setter
public class LoansDto {
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be 10 digits")
	@Schema(
			description = "mobile number of customer", example = "9999988888"
			)
	
	private String mobileNumber;
	@Pattern(regexp = "(^$|[0-9]{12})",message = "account number should be 10 digits")
	@NotEmpty
	@Schema(
			description = "Loan number of the customer",example = "123456789123"
			)
	private String loanNumber;
	@NotEmpty(message = "Loan Type should be personal or home")
	@Schema(
			description = "Tytpe of Loan",example = "home loan"
			)
	private String loanType;
	@Positive(message = "Total Loan  positive ")
	@Schema(
			description = "Total Loan Amount",example = "100000"
			)
	private int totalAmount;
	@PositiveOrZero(message = "Total Loan either positive or Zero")
	@Schema(
			description = "amount paid ",example = "1000"
			)
	private int amountPaid;
	@PositiveOrZero(message = "Total Loan either positive or Zero")
	@Schema(
			description = "Total pending amount to be paid",example = "99000"
			)
	private int outStandingAmount;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(String string) {
		this.loanNumber = string;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public int getOutStandingAmount() {
		return outStandingAmount;
	}
	public void setOutStandingAmount(int outStandingAmount) {
		this.outStandingAmount = outStandingAmount;
	}
	

}
