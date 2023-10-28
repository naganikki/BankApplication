package com.web.spring.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.constants.LoanConstants;
import com.web.spring.dto.LoansDto;
import com.web.spring.exception.LoanAlreadyExistsException;
import com.web.spring.exception.ResourceNotFoundException;
import com.web.spring.mapper.LoansMapper;
import com.web.spring.model.Loans;
import com.web.spring.repository.LoanRepository;
import com.web.spring.service.LoanService;
@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private LoansMapper loansMapper;
	
	@Override
	public void createLoan(String mobileNumber) {
		Optional<Loans> loan = loanRepository.findByMobileNumber(mobileNumber);
		if(loan.isPresent()) {
			throw new LoanAlreadyExistsException("Loan already present for this customer"+mobileNumber);
		}
		
		loanRepository.save(createNewLoan(mobileNumber));
	}
	/**
	 * 
	 * 
	 * @param mobileNumber
	 * @return
	 */
	private Loans createNewLoan(String mobileNumber) {
		Loans loan = new Loans();
		long randomNumber = 100000000000L + new Random().nextInt(900000000);
		loan.setLoanNumber(Long.toString(randomNumber));
		loan.setMobileNumber(mobileNumber);
		loan.setLoanType(LoanConstants.HOME_LOAN);
		loan.setTotalAmount(LoanConstants.NEW_LOAN_LIMIT);
		loan.setOutStandingAmount(LoanConstants.NEW_LOAN_LIMIT);
		loan.setAmountPaid(0);
		return loan;
	}
	
	@Override
	public LoansDto fetchLoan(String mobileNumber) {
		Loans loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
		return loansMapper.mapToLoanDto(loan , new LoansDto());
	}

	@Override
	public boolean updateLoan(LoansDto dto) {
		Loans loans = loanRepository.findByLoanNumber(dto.getLoanNumber()).orElseThrow(
				
				()-> new ResourceNotFoundException("Loan", "AcountNumber", dto.getLoanNumber())
				);
		loansMapper.mapToLoan(dto, loans);
		loanRepository.save(loans);
				
		return true;
	}

	@Override
	public boolean deleteLoan(String mobileNumber) {
		Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()-> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
				);
		loanRepository.deleteById(loans.getLoanId());
				
		return true;
	}

}
