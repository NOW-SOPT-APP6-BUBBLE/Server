package com.sopt.mobile.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

  MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
  SUBSCRIBED_ARTIST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND.value(), "memberId, artistMemberId에 해당하는 구독 중인 아티스트가 존재하지 않습니다.");

  private final int status;
  private final String message;
}
