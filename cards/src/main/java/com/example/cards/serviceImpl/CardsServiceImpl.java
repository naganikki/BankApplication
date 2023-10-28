package com.example.cards.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cards.constants.CardsConstatnts;
import com.example.cards.dto.CardsDto;
import com.example.cards.exception.CardsAlreadyExistsException;
import com.example.cards.exception.ResourceNotFoundException;
import com.example.cards.mapper.CardsMapper;
import com.example.cards.model.Cards;
import com.example.cards.repository.CardsRepository;
import com.example.cards.service.CardsService;
@Service
public class CardsServiceImpl implements CardsService {

	@Autowired
	private CardsRepository cardsRepository;
	@Override
	/**
	 * 
	 * 
	 */
	public void createCard(String mobileNumber) {
		Optional<Cards> cards = cardsRepository.findByMobileNumber(mobileNumber); 
		if(cards.isPresent()) {
			throw new CardsAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
		}
		cardsRepository.save(createNewCard(mobileNumber));
	}
	/**
	 * 
	 * @param mobileNumber
	 * @return
	 */
	private Cards createNewCard(String mobileNumber) {
		Cards newCard = new Cards();
		Long randomNumber = 100000000000L + new Random().nextInt(900000000);
		newCard.setCardNumber(randomNumber.toString());
		newCard.setMobileNumber(mobileNumber);
		newCard.setAmountUsed(0);
		newCard.setCardType(CardsConstatnts.CREDIT_CARD);
		newCard.setTotalLimit(CardsConstatnts.NEW_CARD_LIMIT);
		newCard.setAvailableAmount(CardsConstatnts.NEW_CARD_LIMIT);
		return newCard;
	}
	@Override
	/**
	 * 
	 * 
	 */
	public CardsDto fetchCards(String mobileNumber) {
		Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()->new ResourceNotFoundException("Card","mobileNumber",mobileNumber)
				);
		return CardsMapper.mapToCradsDto(cards, new CardsDto());
	}
	/***
	 * 
	 */
	@Override
	public boolean updateCard(CardsDto cardsDto){
		 System.out.println(cardsDto.getCardNumber());
		Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
				()->new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber())
				); 
			CardsMapper.mapToCards(cardsDto, cards);
			cardsRepository.save(cards);
			return true;
	}

	@Override
	public boolean deleteCard(String mobileNumber) {
		Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()->new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
				); 
		cardsRepository.delete(cards);
		
		return true;
	}

}
