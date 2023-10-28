package com.web.spring.model;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Loans extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name="loan_id")
	@Schema(
			name = "Loan identity",
			description = "primery key"
			)	
	private Long loanId;
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public String getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	@Column(name="loan_nmbr")
	private String loanNumber;
	@Column(name="mobile_nmbr")
	private String mobileNumber;
	@Column(name="loan_type")
	private String loanType;
	@Column(name="total_amount")
	private int totalAmount;
	@Column(name="amount_paid")
	private int amountPaid;
	@Column(name="outstanding_amt")
	private int outStandingAmount;
	}
