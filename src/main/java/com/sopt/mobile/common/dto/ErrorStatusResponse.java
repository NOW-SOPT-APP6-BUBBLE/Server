package com.sopt.mobile.common.dto;

public record ErrorStatusResponse(
    int status,
    boolean success,
    String message
) {
  public static ErrorStatusResponse of(int status, String message) {
    return new ErrorStatusResponse(status, false, message);
  }
  public static ErrorStatusResponse of(ErrorMessage errorMessage) {
    return new ErrorStatusResponse(errorMessage.getStatus(), false, errorMessage.getMessage());
  }
}
