package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.Artist;
import com.sopt.mobile.domain.Subscribe;

import java.util.List;

public record ArtistFindResponseDto(
        ArtistFindDto artist
) {
    public static ArtistFindResponseDto of(ArtistFindDto artist) {
        return new ArtistFindResponseDto(artist);
    }
}
