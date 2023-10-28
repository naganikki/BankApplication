package com.example.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CardsDto {
	
	@NotEmpty
	@Schema(name = "customer mobile number", description = "mobile number of customer")
	@Pattern(regexp = "(^$|[0-9]{10})",message = "should be 10 digits")
	private String mobileNumber;
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{12})",message = "should be 10 digits")
	@Schema(name = "card number", description = "12 digit card number")
	private String cardNumber;
	@NotEmpty
	@Schema(name = "Type of Card",example = "visa type")
	private String cardType;
	@PositiveOrZero(message = "amount limit either positive or zero")
	private int totalLimit;
	@PositiveOrZero(message = "amount used either positive or zero")
	private int amountUsed;
	@PositiveOrZero(message = "amount available either positive or zero")
	private int availableAmount;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getTotalLimit() {
		return totalLimit;
	}
	public void setTotalLimit(int totalLimit) {
		this.totalLimit = totalLimit;
	}
	public int getAmountUsed() {
		return amountUsed;
	}
	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}
	public int getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	@Override
	public String toString() {
		return "CardsDto [mobileNumber=" + mobileNumber + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", totalLimit=" + totalLimit + ", amountUsed=" + amountUsed + ", availableAmount=" + availableAmount
				+ "]";
	}
	public CardsDto(
			@NotEmpty(message = "mobile number should be 10 digit") @Pattern(regexp = "(^$|[0-9]{10})", message = "should be 10 digits") String mobileNumber,
			@NotEmpty String cardNumber, @NotEmpty String cardType,
			@PositiveOrZero(message = "amount limit either positive or zero") int totalLimit,
			@PositiveOrZero(message = "amount used either positive or zero") int amountUsed,
			@PositiveOrZero(message = "amount available either positive or zero") int availableAmount) {
		super();
		this.mobileNumber = mobileNumber;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.totalLimit = totalLimit;
		this.amountUsed = amountUsed;
		this.availableAmount = availableAmount;
	}
	public CardsDto() {
		// TODO Auto-generated constructor stub
	}
	
}
