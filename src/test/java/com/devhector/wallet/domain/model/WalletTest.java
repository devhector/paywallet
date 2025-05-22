package com.devhector.wallet.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.devhector.wallet.domain.model.exceptions.InsufficientBalanceException;
import com.devhector.wallet.domain.model.exceptions.NegativeAmountException;

public class WalletTest {
  private static final BigDecimal BALANCE = new BigDecimal(100);

  @Test
  void whenAmountIsNegativeShouldThrowNegativeAmountException() {
    Wallet wallet = new Wallet(BALANCE);
    BigDecimal amount = new BigDecimal(-10);

    assertThrows(NegativeAmountException.class, () -> wallet.addFunds(amount));
    assertThrows(NegativeAmountException.class, () -> wallet.deductFunds(amount));
  }

  @Test
  void whenAmountIsPositiveAndAddFundsShouldAddAmountInBalance() {
    Wallet wallet = new Wallet(BALANCE);
    BigDecimal amount = new BigDecimal(10);

    wallet.addFunds(amount);

    assertEquals(new BigDecimal(110), wallet.balance());
  }

  @Test
  void whenAmountIsPositiveAndDeductFundsShouldSubtractAmountInBalance() {
    Wallet wallet = new Wallet(BALANCE);
    BigDecimal amount = new BigDecimal(10);

    wallet.deductFunds(amount);

    assertEquals(new BigDecimal(90), wallet.balance());
  }

  @Test
  void whenDeductFundsAndAmountIsGreaterThanBalanceShouldThrowsInsufficientBalanceException() {
    Wallet wallet = new Wallet(BALANCE);
    BigDecimal amount = new BigDecimal(110);

    assertThrows(InsufficientBalanceException.class, () -> wallet.deductFunds(amount));
  }
}
