package com.devhector.wallet.domain.repository;

import com.devhector.wallet.domain.model.Wallet;

public interface WalletRepository {

  void save(Wallet wallet);
}
