package com.web.spring.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")
@Schema(
		name = "holds account details",
		description = "details like account number, address..."
		)
public class Account extends BaseEntity {
	@Column(name="customer_id")
	@Schema(
			name = "customer identification",
			description = "foreign key shared with customer table"
			)
	
	private Long customerId;
	@Column(name="account_nmbr")
	@Id
	@Schema(
			name = "10 digit account number",
			description = "primary key"
			)
	private long accountNumber;
	@Column(name="account_type")
	@Schema(
			name = "type of account",
			description = "reflect either savings or current account"
			)
	private String accountType;
	@Column(name="branch_addrs")
	@Schema(
			name = "address",
			description = "branch address where located"
			)
	private String branchAddress;
//	@Column (name = "created_at")
//	private LocalDateTime createdAt = super.createdAt;
//	@Column (name = "created_by")
//	private String createdBy = super.createdBy;
//	@Column (name = "updated_at")
//	private LocalDateTime updatedAt = super.updatedAt;
//	@Column (name = "updated_by")
//	private String updatedBy = super.updatedBy;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public LocalDateTime getUpdatedAt() {
//		return updatedAt;
//	}
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}
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
//	@Override
//	public String toString() {
//		return "Account [customerId=" + customerId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
//				+ ", branchAddress=" + branchAddress + ", createdAt=" + createdAt + ", createdBy=" + createdBy
//				+ ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + "]";
//	}
	
}
