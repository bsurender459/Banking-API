package com.intuit.craft.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.intuit.craft.demo.model.Account;
import com.intuit.craft.demo.model.dto.PaymentDepositDTO;
import com.intuit.craft.demo.model.dto.PaymentWithdrawDTO;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Map<Integer, Account> customersAccount = new HashMap<>();

	private static final double USD = 00.50;
	private static final double MXN = 10.00;

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public Account createAccount(Account account) {
		customersAccount.put(account.getAccountNumber(), account);
		return account;
	}

	@Override
	public Account paymentDeposit(PaymentDepositDTO paymentDepositDTO) {
		double amount = 0.0;
		Account result = null;
		if ("USD".equals(paymentDepositDTO.getCurrencyType())) {
			amount = 2 * paymentDepositDTO.getAmount();
		} else if ("MXN".equals(paymentDepositDTO.getCurrencyType())) {
			amount = paymentDepositDTO.getAmount() / 10;
		} else {
			amount = paymentDepositDTO.getAmount();
		}

		if (customersAccount.containsKey(paymentDepositDTO.getAccountNumber())) {
			Account account = customersAccount.get(paymentDepositDTO.getAccountNumber());
			account.setBalance(account.getBalance() + amount);
			result = account;
			customersAccount.put(paymentDepositDTO.getAccountNumber(), account);
		} else {
			return null;
		}
		return result;
	}

	@Override
	public Account paymentWithdraw(PaymentWithdrawDTO paymentWithdrawDTO) {
		double amount = 0.0;
		Account result = null;
		if ("USD".equals(paymentWithdrawDTO.getCurrencyType())) {
			amount = 2 * paymentWithdrawDTO.getAmount();
		} else if ("MXN".equals(paymentWithdrawDTO.getCurrencyType())) {
			amount = paymentWithdrawDTO.getAmount() / 10;
		} else {
			amount = paymentWithdrawDTO.getAmount();
		}

		if (customersAccount.containsKey(paymentWithdrawDTO.getAccountNumber())) {
			Account account = customersAccount.get(paymentWithdrawDTO.getAccountNumber());
			account.setBalance(account.getBalance() - amount);
			result = account;
			customersAccount.put(paymentWithdrawDTO.getAccountNumber(), account);
		} else {
			return null;
		}
		return result;
	}

	@PostConstruct
	public void createDefaultData() {
		Date date = new Date();
		Account a1 = new Account(1234, "Stewie", "Griffin", 777, date, 100.00);
		customersAccount.put(a1.getAccountNumber(), a1);

		Account a2 = new Account(2001, "Glenn", "Quagmire", 504, date, 35000.00);
		customersAccount.put(a2.getAccountNumber(), a2);

		Account a3 = new Account(1010, "Joe", "Swanson", 002, date, 7425.00);
		customersAccount.put(a3.getAccountNumber(), a3);

		Account a4 = new Account(5500, "Joe", "Swanson", 002, date, 15000.00);
		customersAccount.put(a4.getAccountNumber(), a4);

		Account a5 = new Account(0123, "Peter", "Griffin", 123, date, 150.00);
		customersAccount.put(a5.getAccountNumber(), a5);

		Account a6 = new Account(0456, "Lois", "Griffin", 456, date, 65000.00);
		customersAccount.put(a6.getAccountNumber(), a6);

	}
}
