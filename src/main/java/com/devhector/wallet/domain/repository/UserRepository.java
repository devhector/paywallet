package com.devhector.wallet.domain.repository;

import java.util.Optional;
import com.devhector.wallet.domain.model.User;

public interface UserRepository {
  Optional<User> findByCpfCnpj(String cpfCnpj);

  void save(User user);
}
