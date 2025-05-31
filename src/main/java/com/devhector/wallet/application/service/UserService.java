package com.devhector.wallet.application.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.domain.model.Wallet;
import com.devhector.wallet.domain.model.exceptions.UserAlreadyExistsException;
import com.devhector.wallet.domain.repository.UserRepository;
import com.devhector.wallet.infrastructure.controller.dto.UserRequestDto;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User createUser(UserRequestDto request) {
    User newUser;
    String cpfCnpj = request.cpfCnpj();

    try {
      if (repository.findByCpfCnpj(cpfCnpj).isPresent()) {
        throw new UserAlreadyExistsException("User already exists with cpf/cnpj: " + cpfCnpj);
      }

      Wallet newWallet = new Wallet(BigDecimal.ZERO);

      newUser = new User(request.cpfCnpj(),
          request.email(),
          request.name(),
          request.password(),
          newWallet,
          request.type());

      repository.save(newUser);
    } catch (Exception e) {
      logger.error("Create user failed ", e.getMessage(), e);
      throw e;
    }

    return newUser;
  }
}
