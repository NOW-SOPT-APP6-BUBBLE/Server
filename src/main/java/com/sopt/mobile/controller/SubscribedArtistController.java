package com.sopt.mobile.controller;


import com.sopt.mobile.common.dto.SuccessMessage;
import com.sopt.mobile.common.dto.SuccessStatusResponse;
import com.sopt.mobile.service.SubscribedArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/artists/artist-members/friend")
@RequiredArgsConstructor
public class SubscribedArtistController {

    private final SubscribedArtistService subscribedArtistService;

    @DeleteMapping("/{artistMemberId}")
    public ResponseEntity<SuccessStatusResponse> deleteSubscribedArtist(
            @RequestHeader(name = "memberId") Long memberId,
            @PathVariable(name = "artistMemberId") Long artistMemberId) {

        subscribedArtistService.removeSubscribedArtist(memberId, artistMemberId);
        return ResponseEntity.ok(SuccessStatusResponse.of(
                SuccessMessage.SUBSCRIBED_ARTISTS_DELETE_SUCCESS));
    }

    @PostMapping("/{artistMemberId}")
    public ResponseEntity<SuccessStatusResponse> registerSubscribedArtist(
            @RequestHeader(name = "memberId") Long memberId,
            @PathVariable(name = "artistMemberId") Long artistMemberId
    ) {
        subscribedArtistService.addSubscribedArtist(memberId, artistMemberId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SuccessStatusResponse.of(SuccessMessage.SUBSCRIBED_ARTISTS_REGISTER_SUCCESS));
    }
}
