package com.gokalpkuscu.blog.dto;

import java.math.BigDecimal;

public class OperationResult {

	private BigDecimal transferAmount;

	private String receiverAccount;

	public BigDecimal getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

}
