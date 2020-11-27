package com.intuit.craft.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.craft.demo.model.Account;
import com.intuit.craft.demo.model.dto.PaymentDepositDTO;
import com.intuit.craft.demo.model.dto.PaymentWithdrawDTO;
import com.intuit.craft.demo.service.PaymentService;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	/**
	 * @param PaymentDTO
	 * @return
	 */
	@PostMapping(value = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> paymentDeposit(@Valid @RequestBody PaymentDepositDTO paymentDepositDTO) {

		Account account = paymentService.paymentDeposit(paymentDepositDTO);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@PostMapping(value = "/withdraw", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> paymentWithdraw(@Valid @RequestBody PaymentWithdrawDTO paymentWithdrawDTO) {

		Account payment = paymentService.paymentWithdraw(paymentWithdrawDTO);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> paymentWithdraw(@Valid @RequestBody Account account) {

		Account acount = paymentService.createAccount(account);
		return new ResponseEntity<>(acount, HttpStatus.CREATED);
	}
}
