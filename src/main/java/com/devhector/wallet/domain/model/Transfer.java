package com.devhector.wallet.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.devhector.wallet.domain.model.exceptions.TransferNotAllowedForUserTypeException;

public class Transfer {

  public Transaction execute(User payer, User payee, BigDecimal amount) {
    Wallet payerWallet = payer.wallet();
    Wallet payeeWallet = payee.wallet();

    if (payer.type().equals(UserType.SHOPKEEPER)) {
      throw new TransferNotAllowedForUserTypeException("Shopkeeper cannot transfer.");
    }

    payerWallet.deductFunds(amount);
    payeeWallet.addFunds(amount);

    return new Transaction(
        UUID.randomUUID().toString(),
        payer.cpfCnpj(),
        payee.cpfCnpj(),
        amount,
        Instant.now());
  }

}
