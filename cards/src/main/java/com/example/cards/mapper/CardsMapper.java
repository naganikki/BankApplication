package com.example.cards.mapper;

import org.springframework.stereotype.Component;

import com.example.cards.dto.CardsDto;
import com.example.cards.model.Cards;

@Component
public class CardsMapper {
	public static CardsDto mapToCradsDto(Cards cards,CardsDto cardsDto) {
		cardsDto.setAmountUsed(cards.getAmountUsed());
		cardsDto.setAvailableAmount(cards.getAmountUsed());
		cardsDto.setCardNumber(cards.getCardNumber());
		cardsDto.setCardType(cards.getCardType());
		cardsDto.setMobileNumber(cards.getMobileNumber());
		cardsDto.setTotalLimit(cards.getTotalLimit());
		return cardsDto;
	}
	public static Cards mapToCards(CardsDto cardsDto,Cards cards) {
		cards.setAmountUsed(cardsDto.getAmountUsed());
		cards.setAvailableAmount(cardsDto.getAvailableAmount());
		cards.setCardNumber(cardsDto.getCardNumber());
		cards.setCardType(cardsDto.getCardType());
		cards.setMobileNumber(cardsDto.getMobileNumber());
		cards.setTotalLimit(cardsDto.getTotalLimit());
		return cards;
	}
}
