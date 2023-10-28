package com.example.cards.service;

import org.springframework.stereotype.Service;

import com.example.cards.dto.CardsDto;
@Service
public interface CardsService {
	/**
	 * 
	 * @param mobileNUmber
	 */
	 void createCard(String mobileNUmber);
	 /**
	  * 
	  * @param mobileNumber
	  * @return
	  */
	 CardsDto fetchCards(String mobileNumber);
	 /**
	  * 
	  * @param mobileNumber
	  * @return
	  */
	 boolean updateCard(CardsDto cardsDto);
	 /**
	  * 
	  * @param mobileNumber
	  * @return
	  */
	 boolean deleteCard(String mobileNumber);
	 

}
