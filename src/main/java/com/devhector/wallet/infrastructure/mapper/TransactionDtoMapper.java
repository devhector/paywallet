package com.devhector.wallet.infrastructure.mapper;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.infrastructure.controller.dto.TransactionResponseDto;

public class TransactionDtoMapper {

  public TransactionResponseDto toDto(Transaction domain) {
    return new TransactionResponseDto(
        domain.id(),
        domain.payerId(),
        domain.payeeId(),
        domain.amount(),
        domain.currentTime());
  }
}
