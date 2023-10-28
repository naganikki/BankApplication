package com.web.spring.service;

import com.web.spring.dto.CustomerDto;

/**
 * 
 * 
 */
public interface AccountsService {
	void createAccount(CustomerDto customerDto);
	 CustomerDto fetchAccount(String mobileNumber);
	 boolean update(CustomerDto customerDto);
	 boolean delete(String mobileNumber);
}
