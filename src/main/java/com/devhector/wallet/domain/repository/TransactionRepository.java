package com.devhector.wallet.domain.repository;

import java.util.Optional;

import com.devhector.wallet.domain.model.Transaction;

public interface TransactionRepository {

  Optional<Transaction> findById(String id);

  void save(Transaction transaction);
}
