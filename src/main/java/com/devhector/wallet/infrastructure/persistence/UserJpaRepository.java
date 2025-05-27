package com.devhector.wallet.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
  Optional<UserEntity> findByCpfCnpj(String cpfCnpj);
}
