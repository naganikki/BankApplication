package com.web.spring.model;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="customer")
public class Customer extends BaseEntity{
	
	@Column(name="customer_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native",strategy = "native")
	@Schema(
			name = "customer identity",
			description = "primery key"
			)	
	private Long customerId;
	@Column(name="name")
	@Schema(
			name = "customer name",
			description = "stores customer name" , example = "Nagaraju"		
			)
	private String name;
	@Column(name="email")
	@Schema(
			description = "email of customer"
			)
	private String email;
	@Column(name="mobile_nmbr")
	@Schema(
			description = "mobile number of custimer"
			)
	private String mobileNumber;
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

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public LocalDateTime getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public String getUpdatedBy() {
//		return updatedBy;
//	}
//
//	public void setUpdatedBy(String updatedBy) {
//		this.updatedBy = updatedBy;
//	}

//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", mobileNumber="
//				+ mobileNumber + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt
//				+ ", updatedBy=" + updatedBy + "]";
//	}
	
	
	
}
