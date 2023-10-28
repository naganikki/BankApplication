package com.web.spring.mapper;

import com.web.spring.dto.CustomerDto;
import com.web.spring.model.Customer;

public class CustomerMapper {
	public static CustomerDto mapToCustomerDto(Customer customer,CustomerDto customerDto) {
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		customerDto.setName(customer.getName());
		return customerDto;
	}
	
	public static Customer mapToCustomer(CustomerDto customerDto,Customer customer) {
		
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setName(customerDto.getName());
//		customer.setCreatedAt(LocalDateTime.now());
//		customer.setCreatedBy("Nagaraju");
//		customer.setUpdatedAt(LocalDateTime.now());
//		customer.setUpdatedBy("Raju");
		return customer;
	}

}
