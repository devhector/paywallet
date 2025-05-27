package com.devhector.wallet.infrastructure.persistence.mapper;

import com.devhector.wallet.domain.model.Wallet;
import com.devhector.wallet.infrastructure.persistence.WalletEntity;

public class WalletPersistenceMapper implements WalletMapper {

  public Wallet toDomain(WalletEntity entity) {
    return new Wallet(entity.getBalance());
  }

  public WalletEntity toEntity(Wallet domain) {
    return new WalletEntity(domain.balance());
  }
}
