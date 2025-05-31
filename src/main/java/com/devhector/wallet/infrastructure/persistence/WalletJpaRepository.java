package com.devhector.wallet.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {
}
