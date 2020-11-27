package com.intuit.craft.demo.service;

import com.intuit.craft.demo.model.Account;
import com.intuit.craft.demo.model.dto.PaymentDepositDTO;
import com.intuit.craft.demo.model.dto.PaymentWithdrawDTO;

public interface PaymentService {

	/**
	 * @param paymentDTO
	 * @return
	 */
	Account paymentDeposit(PaymentDepositDTO paymentDepositDTO);
	
	Account paymentWithdraw(PaymentWithdrawDTO paymentWithdrawDTO);
	
	Account createAccount(Account account);

}
