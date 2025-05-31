package com.devhector.wallet.infrastructure.controller.dto;

import com.devhector.wallet.domain.model.UserType;

public record UserRequestDto(
    String cpfCnpj,
    String email,
    String name,
    String password,
    UserType type) {
}
