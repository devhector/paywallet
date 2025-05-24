package com.devhector.wallet.domain.repository;

import com.devhector.wallet.domain.model.Transaction;

public interface TransactionRepository {

  Transaction findById(String id);

  void save(Transaction transaction);
}
