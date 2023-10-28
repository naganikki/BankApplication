package com.web.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.spring.constants.AccountConstants;
import com.web.spring.dto.ContactInfoDto;
import com.web.spring.dto.CustomerDto;
import com.web.spring.dto.ResponseDto;
import com.web.spring.service.AccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;



@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Tag(
		name = "Controller for CRUD operations for Bank Application",
		description = "CREATE,READ,UPDATE,DELETE operations"
		)

public class BankAccountController {
		
	@Autowired
	private AccountsService accountsService;
	@Value("${build.version}")
	private String buildInfo;
	
	@Autowired
	private Environment environment;
	@Autowired
	private ContactInfoDto contactInfoDto;
		
	@Operation(
			summary = "This is for fetching details",
			description = "used for to fetch account details based on mobile number"
			)
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchDetails(@RequestParam 
			@Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be 10 digit") 
	String mobileNumber){
		CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}
	
	@PostMapping("/create")
	@Operation(
			summary = "This is for creating account",
			description = "used for to create account details "
			)
	@ApiResponse(
			responseCode = "201",
			description = "HttpStatus is created"
			)
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
		
		accountsService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
	}
	@PutMapping("/update")
	@Operation(
			summary = "This is for updating existing account",
			description = "used  to update account details "
			)
	public ResponseEntity<ResponseDto> updateDetails(@Valid @RequestBody CustomerDto customerDto){
		boolean isUpdated = accountsService.update(customerDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
		}
	}
	@DeleteMapping("/delete")
	@Operation(
			summary = "This is for delete account",
			description = "used for to delete account details "
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "200",
					description = "account deleted"
					),
			@ApiResponse(
					responseCode = "500",
					description = "internal server error"
					)
	}
			)
	public ResponseEntity<ResponseDto> deleteAccount(@RequestParam 
			@Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be 10 digit")
			String mobileNumber){
		boolean isUpdated = accountsService.delete(mobileNumber);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
		}
	}
	
	@GetMapping("/buildinfo")
	public ResponseEntity<String> getBuildInfo(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(buildInfo);
	}
	
	@GetMapping("/java-info")
	public ResponseEntity<String> getEnvInfo(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(environment.getProperty("JAVA_HOME"));
	}
	
	@GetMapping("/contact-info")
	public ResponseEntity<ContactInfoDto> getCntInfo(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(contactInfoDto);
	}

}
