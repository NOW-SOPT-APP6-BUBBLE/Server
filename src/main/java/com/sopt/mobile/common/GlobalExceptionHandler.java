package com.sopt.mobile.common;


import com.sopt.mobile.common.dto.ErrorStatusResponse;
import com.sopt.mobile.exception.NotFoundException;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ErrorStatusResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        ErrorStatusResponse.of(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()));
  }
  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<ErrorStatusResponse> handleNotFoundException(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStatusResponse.of(e.getErrorMessage()));
  }

}
