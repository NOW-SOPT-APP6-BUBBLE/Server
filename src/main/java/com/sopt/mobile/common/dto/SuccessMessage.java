package com.sopt.mobile.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

  BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
  ARTISTS_FIND_SUCCESS(HttpStatus.FOUND.value(), "아티스트 목록 조회에 성공했습니다.");

  private final int status;
  private final String message;

}
