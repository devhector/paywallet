package com.devhector.wallet.infrastructure.controller.dto;

import com.devhector.wallet.domain.model.UserType;

public record UserResponseDto(
    String cpfCnpj,
    String email,
    String name,
    UserType type) {
}
