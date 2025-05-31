package com.devhector.wallet.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.domain.model.exceptions.UserNotFoundException;
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
  public User findByCpfCnpj(String cpfCnpj) {
    return repository.findByCpfCnpj(cpfCnpj)
        .map(entity -> userMapper.toDomain(entity, walletMapper))
        .orElseThrow(() -> new UserNotFoundException("User not found: " + cpfCnpj));
  }

  @Override
  public void save(User user) {
    UserEntity entity = userMapper.toEntity(user, walletMapper);
    repository.save(entity);
  }
}
