package com.sopt.mobile.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@NoArgsConstructor
public class ArtistMember extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition="TEXT")
    private String imageURL;

    private String introduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    private boolean isService;

    private String nickname;

    @Builder
    public ArtistMember(String name, String imageURL, String introduction, Artist artist, boolean isService, String nickname) {
        this.name = name;
        this.imageURL = imageURL;
        this.introduction = introduction;
        this.artist = artist;
        this.isService = isService;
        this.nickname = nickname;
    }

    public static ArtistMember createArtistMember(String name, String imageURL, String introduction, Artist artist, boolean isService, String nickname) {
        return ArtistMember
                .builder()
                .name(name)
                .imageURL(imageURL)
                .introduction(introduction)
                .artist(artist)
                .isService(isService)
                .nickname(nickname)
                .build();
    }
}
