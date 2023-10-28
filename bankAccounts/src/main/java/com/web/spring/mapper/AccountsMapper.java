package com.web.spring.mapper;

import com.web.spring.dto.AccountsDto;
import com.web.spring.model.Account;

public class AccountsMapper {
	public static AccountsDto mapToAccountsDto(Account account,AccountsDto accountsDto) {
		accountsDto.setAccountNumber(account.getAccountNumber());
		accountsDto.setAccountType(account.getAccountType());
		accountsDto.setBranchAddress(account.getBranchAddress());
		return accountsDto;
	}
	
	public static Account mapToAccount(AccountsDto accountsDto,Account account) {
		account.setAccountNumber(accountsDto.getAccountNumber());
		account.setAccountType(accountsDto.getAccountType());
		account.setBranchAddress(accountsDto.getBranchAddress());
//		account.setCreatedAt(LocalDateTime.now());
//		account.setCreatedBy("Nagaraju");
//		account.setUpdatedAt(LocalDateTime.now());
//		account.setUpdatedBy("Raju");
		return account;
	}
}
