package com.devhector.wallet.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.domain.repository.TransactionRepository;
import com.devhector.wallet.infrastructure.mapper.TransactionMapper;

@Repository
public class JpaTransactionRepository implements TransactionRepository {
  private final TransactionJpaRepository repository;
  private final TransactionMapper mapper;

  public JpaTransactionRepository(TransactionJpaRepository repository, TransactionMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public Optional<Transaction> findById(String id) {
    return repository.findById(id)
        .map(mapper::toDomain);
  }

  public void save(Transaction transaction) {
    TransactionEntity entity = mapper.toEntity(transaction);
    repository.save(entity);
  }
}
