package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.Artist;

public record ArtistsFindResponseDto(
        String name,
        String photo
) {
    public static ArtistsFindResponseDto of(Artist artist) {
        return new ArtistsFindResponseDto(artist.getName(), artist.getImageURL());
    }
}
