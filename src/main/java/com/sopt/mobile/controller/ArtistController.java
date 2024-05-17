package com.sopt.mobile.controller;

import com.sopt.mobile.common.dto.SuccessMessage;
import com.sopt.mobile.common.dto.SuccessStatusResponse;
import com.sopt.mobile.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/artists")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<SuccessStatusResponse> findArtists(
            @RequestHeader Long memberId
    ) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(SuccessStatusResponse.of(SuccessMessage.ARTISTS_FIND_SUCCESS, artistService.findArtists()));
    }
}
