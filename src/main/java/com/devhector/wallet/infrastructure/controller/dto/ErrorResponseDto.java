package com.devhector.wallet.infrastructure.controller.dto;

public record ErrorResponseDto(
    String message,
    String errorType) {
}
