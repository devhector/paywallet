package com.devhector.wallet.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.devhector.wallet.domain.model.Wallet;
import com.devhector.wallet.domain.repository.WalletRepository;
import com.devhector.wallet.infrastructure.mapper.WalletMapper;

@Repository
public class JpaWalletRepository implements WalletRepository {
  private final WalletJpaRepository repository;
  private final WalletMapper mapper;

  public JpaWalletRepository(WalletJpaRepository repository, WalletMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public void save(Wallet wallet) {
    WalletEntity entity = mapper.toEntity(wallet);
    repository.save(entity);
  }
}
