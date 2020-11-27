package com.intuit.craft.demo.service;

import java.util.Date;

import com.intuit.craft.demo.model.Account;
import com.intuit.craft.demo.model.dto.PaymentDepositDTO;
import com.intuit.craft.demo.model.dto.PaymentWithdrawDTO;

public class PaymentServiceImplTest {

	public static void main(String[] args) {

		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		Date date = new Date();
		Account result, out = null;
		paymentServiceImpl.createAccount(new Account(1234, "Stewie", "Griffin", 777, date, 100.00));
		result = paymentServiceImpl.paymentDeposit(new PaymentDepositDTO(1234, 300.00, "USD"));
		System.out.println("Account Number: " + result.getAccountNumber() + " Balance: "
				+ String.format("%.2f", result.getBalance()) + " CAD");

		paymentServiceImpl.createAccount(new Account(2001, "Glenn", "Quagmire", 504, date, 35000.00));
		result = paymentServiceImpl.paymentWithdraw(new PaymentWithdrawDTO(2001, 5000.00, "MXN"));
		result = paymentServiceImpl.paymentWithdraw(new PaymentWithdrawDTO(2001, 12500.00, "USD"));
		result = paymentServiceImpl.paymentDeposit(new PaymentDepositDTO(2001, 300.00, "CAD"));
		System.out.println("Account Number: " + result.getAccountNumber() + " Balance: "
				+ String.format("%.2f", result.getBalance()) + " CAD");

		paymentServiceImpl.createAccount(new Account(1010, "Joe", "Swanson", 002, date, 7425.00));
		paymentServiceImpl.createAccount(new Account(5500, "Joe", "Swanson", 002, date, 15000.00));
		result = paymentServiceImpl.paymentWithdraw(new PaymentWithdrawDTO(5500, 5000.00, "CAD"));
		result = paymentServiceImpl.paymentWithdraw(new PaymentWithdrawDTO(1010, 7300.00, "CAD"));
		out = paymentServiceImpl.paymentDeposit(new PaymentDepositDTO(5500, 7300.00, "CAD"));
		result = paymentServiceImpl.paymentDeposit(new PaymentDepositDTO(1010, 13726.00, "MXN"));
		System.out.print("Account Number: " + result.getAccountNumber() + " Balance: "
				+ String.format("%.2f", result.getBalance()) + " CAD ");
		System.out.println("Account Number: " + out.getAccountNumber() + " Balance: "
				+ String.format("%.2f", out.getBalance()) + " CAD");

		paymentServiceImpl.createAccount(new Account(0123, "Peter", "Griffin", 123, date, 150.00));
		paymentServiceImpl.createAccount(new Account(0456, "Lois", "Griffin", 0456, date, 65000.00));
		result = paymentServiceImpl.paymentWithdraw(new PaymentWithdrawDTO(0123, 70.00, "USD"));
		result = paymentServiceImpl.paymentDeposit(new PaymentDepositDTO(0456, 23789.00, "USD"));
		out = paymentServiceImpl.paymentWithdraw(new PaymentWithdrawDTO(0456, 23.75, "CAD"));
		result = paymentServiceImpl.paymentDeposit(new PaymentDepositDTO(0123, 23.75, "CAD"));
		System.out.print("Account Number: " + result.getAccountNumber() + " Balance: "
				+ String.format("%.2f", result.getBalance()) + " CAD ");
		System.out.println("Account Number: " + out.getAccountNumber() + " Balance: "
				+ String.format("%.2f", out.getBalance()) + " CAD");

		result = paymentServiceImpl.createAccount(new Account(1010, "Joe", "Swanson", 002, date, 7425.00));
		System.out.println("Account Number: " + result.getAccountNumber() + " Balance: "
				+ String.format("%.2f", result.getBalance()) + " CAD");

	}

}
