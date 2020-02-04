package com.gokalpkuscu.blog;

import com.gokalpkuscu.blog.exception.BalanceNotEnoughException;
import com.gokalpkuscu.blog.external.IAccountService;
import com.gokalpkuscu.blog.external.ICommissionService;
import com.gokalpkuscu.blog.service.MoneyTransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class MoneyTransferServiceTest {

	private final String SENDER_ACCOUNT = "ANY_SENDER_ACCOUNT";
	private final String RECEIVER_ACCOUNT = "ANY_RECEIVER_ACCOUNT";

	@Mock
	private IAccountService accountService;

	@Mock
	private ICommissionService commissionService;

	@InjectMocks
	private MoneyTransferService underTest;

	//Beklediğim exception gerçekleşirse test başarılı olacak
	@Test(expected = BalanceNotEnoughException.class)
	public void testSendMoneyWithException() {

		//Burada mock objesine davranış ekliyorum, balance kontrol edilirken yetmediği konusunda exception fırtlat diyorum
		Mockito.doThrow(new BalanceNotEnoughException()).when(accountService)
				.checkBalance(Mockito.eq(SENDER_ACCOUNT), Mockito.any(BigDecimal.class));

		//Mock objesine ilgili inputlar ile geldiğinde 10 dön diyorum
		Mockito.when(commissionService.getCommissionAmount(Mockito.eq(SENDER_ACCOUNT), Mockito.any(BigDecimal.class)))
				.thenReturn(BigDecimal.TEN);

		//Test için concrete objemi artık çağırıyorum
		underTest.sendMoney(SENDER_ACCOUNT, RECEIVER_ACCOUNT, BigDecimal.ONE);
	}

}
