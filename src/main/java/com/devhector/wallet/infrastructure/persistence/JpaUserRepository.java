package com.devhector.wallet.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.domain.repository.UserRepository;
import com.devhector.wallet.infrastructure.mapper.UserMapper;
import com.devhector.wallet.infrastructure.mapper.WalletMapper;

@Repository
public class JpaUserRepository implements UserRepository {
  private final UserJpaRepository repository;
  private final UserMapper userMapper;
  private final WalletMapper walletMapper;

  public JpaUserRepository(UserJpaRepository repository, UserMapper userMapper, WalletMapper walletMapper) {
    this.repository = repository;
    this.userMapper = userMapper;
    this.walletMapper = walletMapper;
  }

  @Override
  public Optional<User> findByCpfCnpj(String cpfCnpj) {
    return repository.findByCpfCnpj(cpfCnpj)
        .map(entity -> userMapper.toDomain(entity, walletMapper));
  }

  @Override
  public void save(User user) {
    UserEntity entity = userMapper.toEntity(user, walletMapper);
    repository.save(entity);
  }
}
