package com.devhector.wallet.domain.model.exceptions;

public class NegativeAmountException extends RuntimeException {
  public NegativeAmountException(String message) {
    super(message);
  }
}
