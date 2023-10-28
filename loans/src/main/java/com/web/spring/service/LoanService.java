package com.web.spring.service;

import com.web.spring.dto.LoansDto;

public interface LoanService {
	/**
	 * 
	 * 
	 * @param mobileNumber
	 */
	void createLoan(String mobileNumber);
	/**
	 * 
	 * @param mobileNumber
	 * @return
	 */
	LoansDto fetchLoan(String mobileNumber);
	/**
	 * 
	 * @param dto
	 * @return
	 */
	boolean updateLoan(LoansDto dto);
	/**
	 * 
	 * @param mobileNumber
	 * @return
	 */
	boolean deleteLoan(String mobileNumber);

}
