package com.web.spring.repository;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.web.spring.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
	Optional<Account> findByCustomerId(Long customerId);
	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);

}
