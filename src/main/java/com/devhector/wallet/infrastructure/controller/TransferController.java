package com.devhector.wallet.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devhector.wallet.application.service.TransferService;
import com.devhector.wallet.domain.model.Transaction;
import com.devhector.wallet.infrastructure.controller.dto.TransactionResponseDto;
import com.devhector.wallet.infrastructure.controller.dto.TransferRequestDto;
import com.devhector.wallet.infrastructure.mapper.TransactionDtoMapper;

@RestController
@RequestMapping("/transfer")
public class TransferController {
  private final TransferService service;
  private final TransactionDtoMapper mapper;

  public TransferController(TransferService service, TransactionDtoMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<TransactionResponseDto> transfer(@RequestBody TransferRequestDto request) {
    Transaction transaction = service.tranfer(
        request.payer(),
        request.payee(),
        request.value());

    return ResponseEntity.ok(mapper.toDto(transaction));
  }

}
