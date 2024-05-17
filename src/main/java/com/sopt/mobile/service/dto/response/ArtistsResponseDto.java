package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.Artist;

public record ArtistsResponseDto(
        String name,
        String imageURL
) {
    public static ArtistsResponseDto of(Artist artist) {
        return new ArtistsResponseDto(artist.getName(), artist.getImageURL());
    }
}
