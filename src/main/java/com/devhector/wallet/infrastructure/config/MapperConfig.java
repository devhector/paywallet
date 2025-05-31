package com.devhector.wallet.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devhector.wallet.infrastructure.mapper.TransactionDtoMapper;
import com.devhector.wallet.infrastructure.mapper.TransactionEntityMapper;
import com.devhector.wallet.infrastructure.mapper.UserEntityMapper;
import com.devhector.wallet.infrastructure.mapper.WalletEntityMapper;

@Configuration
public class MapperConfig {

  @Bean
  public UserEntityMapper userEntityMapper() {
    return new UserEntityMapper();
  }

  @Bean
  public WalletEntityMapper walletEntityMapper() {
    return new WalletEntityMapper();
  }

  @Bean
  public TransactionEntityMapper TransactionEntityMapper() {
    return new TransactionEntityMapper();
  }

  @Bean
  public TransactionDtoMapper transactionDtoMapper() {
    return new TransactionDtoMapper();
  }
}
