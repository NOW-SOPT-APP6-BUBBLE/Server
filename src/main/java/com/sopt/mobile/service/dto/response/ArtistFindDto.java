package com.sopt.mobile.service.dto.response;

import com.sopt.mobile.domain.Artist;
import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Subscribe;

import java.util.List;

public record ArtistFindDto(
        String name,
        String description,
        String photo,
        List<Subscribe> subscribe,
        List<String> isServiceMembers,
        List<String> isNotServiceMembers
) {
    public static ArtistFindDto of(Artist artist, List<Subscribe> subscribe, List<String> isServiceMembers, List<String> isNotServiceMembers) {
        return new ArtistFindDto(artist.getName(), artist.getDescription(), artist.getImageURL(), subscribe, isServiceMembers, isNotServiceMembers);
    }
}
