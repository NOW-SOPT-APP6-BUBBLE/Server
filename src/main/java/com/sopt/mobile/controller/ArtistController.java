package com.sopt.mobile.controller;

import com.sopt.mobile.common.dto.SuccessMessage;
import com.sopt.mobile.common.dto.SuccessStatusResponse;
import com.sopt.mobile.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{artistId}")
    public ResponseEntity<SuccessStatusResponse> findArtist(
            @RequestHeader Long memberId,
            @PathVariable(name = "artistId") Long artistId
    ) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(SuccessStatusResponse.of(SuccessMessage.ARTIST_FIND_SUCCESS, artistService.findArtist(artistId)));
    }
}
