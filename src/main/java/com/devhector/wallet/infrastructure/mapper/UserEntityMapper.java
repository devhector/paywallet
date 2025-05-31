package com.devhector.wallet.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.infrastructure.persistence.UserEntity;

@Component
public class UserEntityMapper implements UserMapper {
  public User toDomain(UserEntity entity, WalletMapper mapper) {
    return new User(
        entity.getCpfCnpj(),
        entity.getEmail(),
        entity.getName(),
        entity.getPassword(),
        mapper.toDomain(entity.getWallet()),
        entity.getType());
  }

  public UserEntity toEntity(User domain, WalletMapper mapper) {
    return new UserEntity(
        domain.cpfCnpj(),
        domain.email(),
        domain.name(),
        domain.password(),
        mapper.toEntity(domain.wallet()),
        domain.type());
  }
}
