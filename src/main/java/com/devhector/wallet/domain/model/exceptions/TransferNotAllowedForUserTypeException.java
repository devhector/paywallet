package com.devhector.wallet.domain.model.exceptions;

public class TransferNotAllowedForUserTypeException extends RuntimeException {
  public TransferNotAllowedForUserTypeException(String message) {
    super(message);
  }
}
