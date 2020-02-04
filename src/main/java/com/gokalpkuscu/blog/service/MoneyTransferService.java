package com.gokalpkuscu.blog.service;

import com.gokalpkuscu.blog.dto.OperationResult;
import com.gokalpkuscu.blog.external.IAccountService;
import com.gokalpkuscu.blog.external.ICommissionService;

import java.math.BigDecimal;

public class MoneyTransferService {

	private IAccountService accountService;

	private ICommissionService commissionService;

	public MoneyTransferService(IAccountService accountService, ICommissionService commissionService) {
		this.accountService = accountService;
		this.commissionService = commissionService;
	}

	public OperationResult sendMoney(String senderAccount, String receiverAccount, BigDecimal amount) {
		accountService.checkBalance(senderAccount, amount);

		BigDecimal commissionAmount = commissionService.getCommissionAmount(senderAccount, amount);

		OperationResult operationResult = new OperationResult();
		operationResult.setReceiverAccount(receiverAccount);
		operationResult.setTransferAmount(amount.subtract(commissionAmount));

		return operationResult;
	}

}
