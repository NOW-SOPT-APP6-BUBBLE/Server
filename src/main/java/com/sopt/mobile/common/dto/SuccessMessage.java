package com.sopt.mobile.common.dto;

import com.sopt.mobile.service.SubscribedArtistService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

  BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
  ARTIST_MEMBER_FIND_SUCCESS(HttpStatus.OK.value(), "아티스트 멤버 목록 조회 성공했습니다."),
  ARTISTS_FIND_SUCCESS(HttpStatus.OK.value(), "아티스트 목록 조회에 성공했습니다."),
  SUBSCRIBED_ARTISTS_DELETE_SUCCESS(HttpStatus.OK.value(), "구독 중인 아티스트 제거 성공했습니다."),
  ARTIST_MEMBER_DETAIL_FIND_SUCCESS(HttpStatus.OK.value(), "아티스트 멤버 프로필 조회 성공했습니다."),
  SUBSCRIBED_ARTISTS_REGISTER_SUCCESS(HttpStatus.CREATED.value(), "아티스트 즐겨찾기에 성공했습니다."),
  ARTIST_FIND_SUCCESS(HttpStatus.OK.value(), "아티스트 조회에 성공했습니다.");
  
  private final int status;
  private final String message;

}
