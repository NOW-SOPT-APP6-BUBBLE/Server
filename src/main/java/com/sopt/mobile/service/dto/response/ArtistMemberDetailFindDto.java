package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.ArtistMember;

public record ArtistMemberDetailFindDto(

    Long artistMemberId,
    String nickname,
    String imageURL,
    String introduction,
    boolean isSubscribed,
    String artistName,
    String artistMemberName
) {
  public static ArtistMemberDetailFindDto of(
      ArtistMember artistMember, boolean isSubscribed
  ) {
    String name = null;

    if (!artistMember.getArtist().isSole()) {
      name = artistMember.getArtist().getName();
    }

    return new ArtistMemberDetailFindDto(
        artistMember.getId(),
        artistMember.getNickname(),
        artistMember.getImageURL(),
        artistMember.getIntroduction(),
        isSubscribed,
        name,
        artistMember.getName());
  }
}
