package com.web.spring.mapper;

import org.springframework.stereotype.Component;

import com.web.spring.dto.LoansDto;
import com.web.spring.model.Loans;
@Component
public class LoansMapper {
	public  LoansDto mapToLoanDto(Loans loans,LoansDto dto) {
		dto.setAmountPaid(loans.getAmountPaid());
		dto.setLoanNumber(loans.getLoanNumber());
		dto.setLoanType(loans.getLoanType());
		dto.setMobileNumber(loans.getMobileNumber());
		dto.setOutStandingAmount(loans.getOutStandingAmount());
		dto.setTotalAmount(loans.getTotalAmount());
		return dto;
	}
	
	public Loans mapToLoan(LoansDto dto,Loans loans) {
		loans.setAmountPaid(dto.getAmountPaid());
		loans.setLoanNumber(dto.getLoanNumber());
		loans.setLoanType(dto.getLoanType());
		loans.setMobileNumber(dto.getMobileNumber());
		loans.setOutStandingAmount(dto.getOutStandingAmount());
		loans.setTotalAmount(dto.getTotalAmount());
		return loans;
	}

}
