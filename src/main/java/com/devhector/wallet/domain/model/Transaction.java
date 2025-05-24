package com.devhector.wallet.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public record Transaction(String id, String payerId, String payeeId, BigDecimal amount, Instant currentTime) {
}
