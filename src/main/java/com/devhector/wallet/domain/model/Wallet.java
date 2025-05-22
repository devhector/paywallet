package com.devhector.wallet.domain.model;

import java.math.BigDecimal;

import com.devhector.wallet.domain.model.exceptions.InsufficientBalanceException;
import com.devhector.wallet.domain.model.exceptions.NegativeAmountException;

public class Wallet {

  private BigDecimal balance;

  public Wallet(BigDecimal balance) {
    this.balance = balance;
  }

  public void addFunds(BigDecimal amount) {
    validateNegativeAmount(amount);
    this.balance = balance.add(amount);
  }

  public void deductFunds(BigDecimal amount) {
    validateNegativeAmount(amount);
    if (balance.compareTo(amount) < 0) {
      throw new InsufficientBalanceException("Amount greater than balance");
    }
    this.balance = balance.subtract(amount);
  }

  public BigDecimal balance() {
    return this.balance;
  }

  private void validateNegativeAmount(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new NegativeAmountException("Amount less then zero");
    }
  }
}
