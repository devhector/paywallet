package com.devhector.wallet.domain.repository;

import com.devhector.wallet.domain.model.Wallet;

public interface WalletRepository {

  Wallet save(Wallet wallet);
}
