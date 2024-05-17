package com.sopt.mobile.service;

import com.sopt.mobile.domain.Artist;
import com.sopt.mobile.repository.ArtistRepository;
import com.sopt.mobile.service.dto.response.ArtistsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<ArtistsResponseDto> findArtists() {
        return artistRepository.findAll().stream()
                .map(ArtistsResponseDto::of)
                .toList();
    }
}
