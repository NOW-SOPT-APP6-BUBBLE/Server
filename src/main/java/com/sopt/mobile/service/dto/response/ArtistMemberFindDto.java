package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.ArtistMember;

public record ArtistMemberFindDto(
    Long artistMemberId,
    String name,
    String imageURL,
    String introduction
) {

  public static ArtistMemberFindDto of(
      ArtistMember artistMember
  ) {
    return new ArtistMemberFindDto(
        artistMember.getId(),
        artistMember.getName(),
        artistMember.getImageURL(),
        artistMember.getIntroduction());
  }
}
