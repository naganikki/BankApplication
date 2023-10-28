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

import com.web.spring.constants.LoanConstants;
import com.web.spring.dto.ContactInfoDto;
import com.web.spring.dto.LoansDto;
import com.web.spring.dto.ResponseDto;
import com.web.spring.service.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
@Tag(
		name = "CRUD operations for LOANS",
		description = "CREATE,READ,UPDATE,DELETE operations Controller for LOANS"
		)

@RestController
@RequestMapping(value = "/api" , produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class LoansController { 
	
	@Autowired
	private LoanService loanService;
	@Value("${build.version}")
	private String buildVersion;
	@Autowired
	private Environment environment;
	@Autowired
	private ContactInfoDto contactInfoDto;
	@Operation(
			summary = "CREATE method for Loans",
			description = "if customer does not have any loans loan will be created	otherwise loan already exists exception will be thrown"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HttpStatus created"
			)
	
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDto> createDetails(@RequestParam 
			@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
			String mobileNumber){
		loanService.createLoan(mobileNumber);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
	}
	@Operation(
			summary = "this method for fetching loan details",
			description = "loan details will fetch based on mobilenumber"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Httpstatus OK"
			)
	@GetMapping(value = "/fetch")
	public ResponseEntity<LoansDto> fetchDetails(@RequestParam 
			@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
			String mobileNumber){
		LoansDto dto = loanService.fetchLoan(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
		
	}
	@Operation(
			summary = "present loan details will be updated",
			description = "updating loan details"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "200",
					description = "httpstatus OK)"
					),
			@ApiResponse(
					responseCode = "417",
					description = "httpstatus Expectation failed)"
					)
	})
	
	@PutMapping(value = "/update")
	public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody LoansDto dto){
		boolean isUpdated = loanService.updateLoan(dto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE));
		}
	}	
	@Operation(
			summary = "present loan details will be updated",
			description = "updating loan details"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "200",
					description = "httpstatus OK)"
					),
			@ApiResponse(
					responseCode = "417",
					description = "httpstatus Expectation failed)"
					)
	})
	@DeleteMapping(value = "/delete")
	public ResponseEntity<ResponseDto> deleteLoan(@RequestParam 
			@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
			String mobileNumber){
		boolean isUpdated = loanService.deleteLoan(mobileNumber);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
		}else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
		}
	}
	
	@GetMapping("/buildinfo")
	public ResponseEntity<String> getBuildInfo(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(buildVersion);
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
