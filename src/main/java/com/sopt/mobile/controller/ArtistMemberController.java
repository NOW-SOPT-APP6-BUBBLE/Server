package com.sopt.mobile.controller;

import com.sopt.mobile.common.dto.SuccessMessage;
import com.sopt.mobile.common.dto.SuccessStatusResponse;
import com.sopt.mobile.service.ArtistMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/artists/members/friend")
@RequiredArgsConstructor
public class ArtistMemberController {

  private final ArtistMemberService artistMemberService;

  @GetMapping("")
  public ResponseEntity<SuccessStatusResponse> getSubscribedArtists(
      @RequestHeader(name = "memberId") Long memberId){

    return ResponseEntity.ok(SuccessStatusResponse.of(
        SuccessMessage.ARTIST_MEMBER_FIND_SUCCESS,
        artistMemberService.findSubscribedArtists(memberId)));
  }

}
