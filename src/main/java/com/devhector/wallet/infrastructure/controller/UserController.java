package com.devhector.wallet.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devhector.wallet.application.service.UserService;
import com.devhector.wallet.domain.model.User;
import com.devhector.wallet.infrastructure.controller.dto.UserRequestDto;
import com.devhector.wallet.infrastructure.controller.dto.UserResponseDto;

@RestController
@RequestMapping("api/v0/user")
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto request) {
    User newUser = service.createUser(request);

    return ResponseEntity.ok(new UserResponseDto(
        newUser.cpfCnpj(),
        newUser.email(),
        newUser.name(),
        newUser.type()));
  }

}
