package com.devhector.wallet.infrastructure.persistence.mapper;

import com.devhector.wallet.domain.model.Wallet;
import com.devhector.wallet.infrastructure.persistence.WalletEntity;

public interface WalletMapper {
  Wallet toDomain(WalletEntity entity);

  WalletEntity toEntity(Wallet domain);
}
