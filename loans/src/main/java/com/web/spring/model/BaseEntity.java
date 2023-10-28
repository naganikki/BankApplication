package com.web.spring.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@CreatedDate
	@Column(updatable = true)
	private LocalDateTime createdAt;
	@CreatedBy
	@Column(updatable = true)
	private String createdBy;
	@LastModifiedDate
	@Column(updatable = true)
	private LocalDateTime updatedAt;
	@LastModifiedBy
	@Column(updatable = true)
	private String updatedBy;

}
