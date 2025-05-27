package com.devhector.wallet.infrastructure.persistence.mapper;

import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.infrastructure.persistence.UserEntity;

public interface UserMapper {
  User toDomain(UserEntity entity, WalletMapper mapper);

  UserEntity toEntity(User domain, WalletMapper mapper);
}
