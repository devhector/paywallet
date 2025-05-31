package com.devhector.wallet.infrastructure.controller.dto;

import java.math.BigDecimal;

public record TransferRequestDto(
    BigDecimal value,
    String payer,
    String payee) {
}
