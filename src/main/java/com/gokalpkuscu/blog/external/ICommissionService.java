package com.gokalpkuscu.blog.external;

import com.gokalpkuscu.blog.exception.AmountNotEnoughForOperation;

import java.math.BigDecimal;

public interface ICommissionService {

	BigDecimal getCommissionAmount(String account, BigDecimal amount) throws AmountNotEnoughForOperation;

}
