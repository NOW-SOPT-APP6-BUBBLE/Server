package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.ArtistMember;
import java.util.List;

public record ArtistMemberListFindDto(
    List<ArtistMemberFindDto> isSubsArtists,
    List<ArtistMemberFindDto> isNotSubsArtists

    ) {

    public static ArtistMemberListFindDto of(
        List<ArtistMemberFindDto> isSubsArtists,  List<ArtistMemberFindDto> isNotSubsArtists
    ) {
        return new ArtistMemberListFindDto(
            isSubsArtists, isNotSubsArtists
        );
    }
}
