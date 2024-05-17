package com.sopt.mobile.controller;

import com.sopt.mobile.common.dto.SuccessMessage;
import com.sopt.mobile.common.dto.SuccessStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/artists/members/friend")
@RequiredArgsConstructor
public class ArtistMemberController {

  private final ArtistMemberService ArtistMemberService;

  @GetMapping("")
  public ApiResponse<MemberResponseDto.nicknameDto> getSubscribedArtists(
      @RequestHeader(name = "memberId") Long memberId){

    return SuccessStatusResponse.of(
        HttpStatus.OK,
        SuccessMessage.
        ArtistMemberService.findSubscribedArtists(memberId));

    if(!memberRequestDto.getNickname().isEmpty()) {
      MemberResponseDto.nicknameDto result = memberService.patchNickname(member, memberRequestDto);
      return ApiResponse.onSuccess(result);
    } else
      throw new ExceptionHandler(NICKNAME_EMPTY);
  }


}
