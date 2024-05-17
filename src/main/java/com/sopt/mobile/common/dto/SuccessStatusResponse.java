package com.sopt.mobile.common.dto;


public record SuccessStatusResponse<T>(
    int status,
    boolean success,
    String message,
    T result
) {

  public static SuccessStatusResponse of(SuccessMessage successMessage) {
    return new SuccessStatusResponse(successMessage.getStatus(), true, successMessage.getMessage(), null);
  }

  public static <T> SuccessStatusResponse<T> of(SuccessMessage successMessage, T responseDto) {
    return new SuccessStatusResponse(successMessage.getStatus(), true, successMessage.getMessage(), responseDto);
  }

}