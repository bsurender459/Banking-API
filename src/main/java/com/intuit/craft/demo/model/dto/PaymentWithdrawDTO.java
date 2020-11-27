package com.intuit.craft.demo.model.dto;
import lombok.Data;

@Data
public class PaymentWithdrawDTO {

	private Integer accountNumber;	
	private Double amount;	
	private String currencyType;
	
	public PaymentWithdrawDTO() {};
	public PaymentWithdrawDTO(Integer accountNumber, Double amount, String currencyType) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.currencyType = currencyType;
	}	
}
