package com.sopt.mobile.service;

import com.sopt.mobile.common.dto.ErrorMessage;
import com.sopt.mobile.domain.Artist;
import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Subscribe;
import com.sopt.mobile.exception.NotFoundException;
import com.sopt.mobile.repository.ArtistMemberRepository;
import com.sopt.mobile.repository.ArtistRepository;
import com.sopt.mobile.service.dto.response.ArtistFindDto;
import com.sopt.mobile.service.dto.response.ArtistFindResponseDto;
import com.sopt.mobile.service.dto.response.ArtistsFindListResponseDto;
import com.sopt.mobile.service.dto.response.ArtistsFindResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMemberRepository artistMemberRepository;

    public ArtistsFindListResponseDto findArtists() {
        return ArtistsFindListResponseDto.of(artistRepository.findAll().stream()
                .map(ArtistsFindResponseDto::of)
                .toList());
    }

    public ArtistFindResponseDto findArtist(Long artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.ARTIST_NOT_FOUND_EXCEPTION)
        );

        List<ArtistMember> serviceArtistMembers = artist.getArtistMemberList().stream()
                .filter(ArtistMember::isService)
                .toList();

        List<ArtistMember> notServiceArtistMembers = artist.getArtistMemberList().stream()
                .filter(Predicate.not(ArtistMember::isService))
                .toList();

        List<Subscribe> subscribe = new ArrayList<Subscribe>();

        for (int i = 0; i < serviceArtistMembers.size(); i++) {
            subscribe.add(new Subscribe(Integer.toString(i + 1) +"인권", 4500 * (i + 1), 4500 * (i + 1) - 1000 * (i)));
        }

        List<String> isServiceMembers = new ArrayList<String>();
        List<String> isNotServiceMembers = new ArrayList<String>();
        for (int i = 0; i < serviceArtistMembers.size(); i++) {
            isServiceMembers.add(serviceArtistMembers.get(i).getName());
        }
        for (int i = 0; i < notServiceArtistMembers.size(); i++) {
            isNotServiceMembers.add(notServiceArtistMembers.get(i).getName());
        }


        return ArtistFindResponseDto.of(ArtistFindDto.of(artist, subscribe, isServiceMembers, isNotServiceMembers));
    }
}
