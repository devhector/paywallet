package com.devhector.wallet.application.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.domain.model.Transfer;
import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.domain.model.exceptions.UserNotFoundException;
import com.devhector.wallet.domain.repository.TransactionRepository;
import com.devhector.wallet.domain.repository.UserRepository;

@Service
public class TransferService {
  private static final Logger logger = LoggerFactory.getLogger(TransferService.class);
  private final UserRepository userRepository;
  private final TransactionRepository transactionRepository;

  public TransferService(UserRepository userRepository, TransactionRepository transactionRepository) {
    this.userRepository = userRepository;
    this.transactionRepository = transactionRepository;
  }

  @Transactional
  public Transaction tranfer(String payerCpfCnpj, String payeeCpfCnpj, BigDecimal amount) {
    Transaction transaction;

    try {
      User payer = userRepository.findByCpfCnpj(payerCpfCnpj).orElseThrow(
          () -> new UserNotFoundException("Payer not found with id " + payeeCpfCnpj));
      User payee = userRepository.findByCpfCnpj(payeeCpfCnpj).orElseThrow(
          () -> new UserNotFoundException("Payee not found with id " + payeeCpfCnpj));

      transaction = Transfer.execute(payer, payee, amount);

      userRepository.save(payer);
      userRepository.save(payee);
      transactionRepository.save(transaction);
    } catch (UserNotFoundException e) {
      logger.error("Tranfer failed: {}", e.getMessage(), e);
      throw e;
    }

    return transaction;
  }

}
