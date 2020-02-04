package com.gokalpkuscu.blog.external;

import com.gokalpkuscu.blog.exception.BalanceNotEnoughException;

import java.math.BigDecimal;

public interface IAccountService {

	void checkBalance(String account, BigDecimal amount) throws BalanceNotEnoughException;
}
