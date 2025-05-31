package com.devhector.wallet.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.infrastructure.persistence.TransactionEntity;

@Component
public class TransactionEntityMapper implements TransactionMapper {

  public Transaction toDomain(TransactionEntity entity) {
    return new Transaction(
        entity.getId(),
        entity.getPayerId(),
        entity.getPayeeId(),
        entity.getAmount(),
        entity.getCurrentTime());
  }

  public TransactionEntity toEntity(Transaction domain) {
    return new TransactionEntity(
        domain.id(),
        domain.payerId(),
        domain.payeeId(),
        domain.amount(),
        domain.currentTime());
  }

}
