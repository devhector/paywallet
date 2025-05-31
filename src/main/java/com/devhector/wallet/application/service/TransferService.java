package com.devhector.wallet.application.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.domain.model.Transfer;
import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.domain.repository.TransactionRepository;
import com.devhector.wallet.domain.repository.UserRepository;

@Service
public class TransferService {
  private final UserRepository userRepository;
  private final TransactionRepository transactionRepository;

  public TransferService(UserRepository userRepository, TransactionRepository transactionRepository) {
    this.userRepository = userRepository;
    this.transactionRepository = transactionRepository;
  }

  @Transactional
  public Transaction tranfer(String payerCpfCnpj, String payeeCpfCnpj, BigDecimal amount) {
    User payer = userRepository.findByCpfCnpj(payerCpfCnpj);
    User payee = userRepository.findByCpfCnpj(payeeCpfCnpj);

    Transaction transaction = Transfer.execute(payer, payee, amount);

    userRepository.save(payer);
    userRepository.save(payee);
    transactionRepository.save(transaction);

    return transaction;
  }

}
