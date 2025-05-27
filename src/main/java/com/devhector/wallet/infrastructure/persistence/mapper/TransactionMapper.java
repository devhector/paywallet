package com.devhector.wallet.infrastructure.persistence.mapper;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.infrastructure.persistence.TransactionEntity;

public interface TransactionMapper {

  Transaction toDomain(TransactionEntity entity);

  TransactionEntity toEntity(Transaction domain);
}
