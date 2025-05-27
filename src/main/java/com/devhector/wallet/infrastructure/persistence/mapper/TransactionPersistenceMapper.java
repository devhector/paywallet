package com.devhector.wallet.infrastructure.persistence.mapper;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.infrastructure.persistence.TransactionEntity;

public class TransactionPersistenceMapper implements TransactionMapper {

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
