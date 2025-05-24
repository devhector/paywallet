package com.devhector.wallet.domain.repository;

import com.devhector.wallet.domain.model.User;

public interface UserRepository {
  User findByCpfCnpj(String cpfCnpj);

  User save(User user);
}
