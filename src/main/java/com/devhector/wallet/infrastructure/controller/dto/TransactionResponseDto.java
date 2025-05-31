package com.devhector.wallet.infrastructure.controller.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record TransactionResponseDto(
    String id,
    String payerId,
    String payeeId,
    BigDecimal amount,
    Instant currentTime) {
}
