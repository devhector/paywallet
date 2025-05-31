package com.devhector.wallet.infrastructure.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devhector.wallet.domain.model.exceptions.InsufficientBalanceException;
import com.devhector.wallet.domain.model.exceptions.NegativeAmountException;
import com.devhector.wallet.domain.model.exceptions.TransactionNotFoundException;
import com.devhector.wallet.domain.model.exceptions.TransferNotAllowedForUserTypeException;
import com.devhector.wallet.domain.model.exceptions.UserNotFoundException;
import com.devhector.wallet.domain.model.exceptions.UserAlreadyExistsException;
import com.devhector.wallet.infrastructure.controller.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler({
      TransferNotAllowedForUserTypeException.class,
      InsufficientBalanceException.class,
      NegativeAmountException.class
  })
  public ResponseEntity<ErrorResponseDto> handleBadRequestExceptions(RuntimeException exception) {
    return new ResponseEntity<>(
        getErrorResponseDto(exception),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
      UserNotFoundException.class,
      TransactionNotFoundException.class
  })
  public ResponseEntity<ErrorResponseDto> handleNotFoundExceptions(RuntimeException exception) {
    return new ResponseEntity<>(
        getErrorResponseDto(exception),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ErrorResponseDto> handleUserAlreadyExistsExceptions(RuntimeException exception) {
    return new ResponseEntity<>(
        getErrorResponseDto(exception),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleGenericExceptions(Exception exception) {
    logger.error("INTERNAL ERROR: {}", exception.getMessage(), exception);
    return new ResponseEntity<>(
        new ErrorResponseDto("Internal server error", "InternalError"),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ErrorResponseDto getErrorResponseDto(RuntimeException exception) {
    return new ErrorResponseDto(exception.getMessage(), exception.getClass().getSimpleName());
  }

}
