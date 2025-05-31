package com.devhector.wallet.infrastructure.mapper;

import com.devhector.wallet.domain.model.Wallet;
import com.devhector.wallet.infrastructure.persistence.WalletEntity;

public class WalletEntityMapper implements WalletMapper {

  public Wallet toDomain(WalletEntity entity) {
    return new Wallet(entity.getId(), entity.getBalance());
  }

  public WalletEntity toEntity(Wallet domain) {
    return new WalletEntity(domain.id(), domain.balance());
  }
}
