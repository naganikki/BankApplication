package com.example.cards.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cards.constants.CardsConstatnts;
import com.example.cards.dto.CardsDto;
import com.example.cards.dto.ConfigPropertiesDto;
import com.example.cards.dto.ResponseDto;
import com.example.cards.service.CardsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@Tag(
		name = "CRUD operations for CARDS application",
		description = "CREATE,READ,UPDATE,DELETE operations for cards"
		)
@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CardsController {

	@Autowired
	private CardsService cardsService;
	
	@Value("${build.version}")
	private String buildVersion;
	
	@Autowired
	private Environment environment;
	@Autowired
	private ConfigPropertiesDto configPropertiesDto;
	
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDto> createCard(@RequestParam @Valid 
			@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
			String mobileNumber){
		cardsService.createCard(mobileNumber);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(CardsConstatnts.STATUS_201, CardsConstatnts.MESSAGE_201));
		
	}
	@GetMapping(value = "/fetch")
	public ResponseEntity<CardsDto> fetchCard(@RequestParam @Valid 
			@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
			String mobileNumber){
		CardsDto cardsDto = cardsService.fetchCards(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	}
	@PutMapping(value = "/update")
	public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto){
		System.out.println(cardsDto.getCardNumber());
		boolean isUpdated = cardsService.updateCard(cardsDto);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto( CardsConstatnts.STATUS_201,CardsConstatnts.MESSAGE_201));
		}else
		{
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto( CardsConstatnts.STATUS_417,CardsConstatnts.MESSAGE_417_UPDATE));
		}
	}
	@DeleteMapping(value = "/delete")
	public ResponseEntity<ResponseDto> deleteCard(@RequestParam @Valid 
			@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
			String mobileNumber){
		boolean	isUpdated = cardsService.deleteCard(mobileNumber);
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto( CardsConstatnts.STATUS_201,CardsConstatnts.MESSAGE_201));
		}else
		{
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto( CardsConstatnts.STATUS_417,CardsConstatnts.MESSAGE_417_DELETE));
		}
	}
	
	@GetMapping("/buildinfo")
	public ResponseEntity<String> getBuildInfo(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(buildVersion);
		
	}
	
	@GetMapping("/java-info")
	public ResponseEntity<String> getJavaInfo(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(environment.getProperty("JAVA_HOME"));
	}
	
	@GetMapping("/contact-info")
	public ResponseEntity<ConfigPropertiesDto> getContactDetails(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(configPropertiesDto);
	}
}
