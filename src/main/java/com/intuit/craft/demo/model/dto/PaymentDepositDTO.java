package com.intuit.craft.demo.model.dto;
import lombok.Data;

@Data
public class PaymentDepositDTO {

	private Integer accountNumber;	
	private Double amount;
	private String currencyType;
	
	public PaymentDepositDTO() {};
	
	public PaymentDepositDTO(Integer accountNumber, Double amount, String currencyType) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.currencyType = currencyType;
	}
	
}
