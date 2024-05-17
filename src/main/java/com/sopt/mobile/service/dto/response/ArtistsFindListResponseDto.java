package com.sopt.mobile.service.dto.response;

import java.util.List;

public record ArtistsFindListResponseDto(
        List<ArtistsFindResponseDto> artists
) {
    public static ArtistsFindListResponseDto of(List<ArtistsFindResponseDto> artistsFindResponseDto) {
        return new ArtistsFindListResponseDto(artistsFindResponseDto);
    }
}
