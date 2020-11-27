package com.intuit.craft.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Account {
	
	private Integer accountNumber;
	private String firstName;
	private String lastName;
	private Integer customerId;
	private Date createDate;
	private Double balance;
	
	public Account() {};
	public Account(Integer accountNumber, String firstName, String lastName, Integer customerId, Date createDate,
			Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.createDate = createDate;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerId=" + customerId + ", createDate=" + createDate + ", balance=" + balance + "]";
	}	
}
