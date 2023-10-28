package com.web.spring.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.constants.AccountConstants;
import com.web.spring.dto.AccountsDto;
import com.web.spring.dto.CustomerDto;
import com.web.spring.exception.CustomerAlreadyExistsException;
import com.web.spring.exception.CustomerNotFoundException;
import com.web.spring.mapper.AccountsMapper;
import com.web.spring.mapper.CustomerMapper;
import com.web.spring.model.Account;
import com.web.spring.model.Customer;
import com.web.spring.repository.AccountRepository;
import com.web.spring.repository.CustomerRepository;
import com.web.spring.service.AccountsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void createAccount(CustomerDto customerDto) {
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository
				.findBymobileNumber(customerDto.getMobileNumber());
		if(optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException("customer already exists with mobileNumber"
					+customerDto.getMobileNumber());
		}
		Customer savedCustomer = customerRepository.save(customer);
		accountRepository.save(createNewAccount(savedCustomer));
	}

	private Account createNewAccount(Customer customer) {
		Account newAccount = new Account();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 100000000L + new Random().nextInt(900000000); 
		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType(AccountConstants.SAVINGS);
		newAccount.setBranchAddress(AccountConstants.ADDRESS);
//		newAccount.setCreatedAt(LocalDateTime.now());
//		newAccount.setCreatedBy("Nagaraju");
//		newAccount.setUpdatedAt(LocalDateTime.now());
//		newAccount.setUpdatedBy("Raju");
		return newAccount;
	}

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		
		Customer customer = customerRepository.findBymobileNumber(mobileNumber).orElseThrow(
				()-> new CustomerNotFoundException("Customer", "mobileNumber", mobileNumber) );
	
		Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				()-> new CustomerNotFoundException("Account", "CustomerId", customer.getCustomerId().toString()) );
		CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
		return customerDto;
	}

	@Override
	public boolean update(CustomerDto customerDto) {
		boolean isUpdated = false;
		AccountsDto accountsDto = customerDto.getAccountsDto();
		if(accountsDto!=null) {
			Account account = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
					()-> new CustomerNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString()));
		AccountsMapper.mapToAccount(accountsDto, account);
		account = accountRepository.save(account);
		Long customerId = account.getCustomerId();
		Customer customer = customerRepository.findById(customerId).orElseThrow(
				()-> new CustomerNotFoundException("Customer", "cusyomerId", customerId.toString()) );
		CustomerMapper.mapToCustomer(customerDto, customer);
		customer = customerRepository.save(customer);
		isUpdated = true;
		}
		
		
		return isUpdated;
	}

	@Override
	public boolean delete(String mobileNumber) {
		boolean isUpdated = false;
		{
		Customer customer = customerRepository.findBymobileNumber(mobileNumber).orElseThrow(
				()-> new CustomerNotFoundException("Customer", "mobileNumber", mobileNumber));
		accountRepository.deleteByCustomerId(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		isUpdated = true;
		}
		return isUpdated;
	}
}
