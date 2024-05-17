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

    @Lob
    private String imageURL;

    private String introduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    private boolean isService;

    @Builder
    public ArtistMember(String name, String imageURL, String introduction, Artist artist) {
        this.name = name;
        this.imageURL = imageURL;
        this.introduction = introduction;
        this.artist = artist;
    }

    public static ArtistMember createArtistMember(String name, String imageURL, String introduction, Artist artist) {
        return ArtistMember
                .builder()
                .name(name)
                .imageURL(imageURL)
                .introduction(introduction)
                .artist(artist)
                .build();
    }
}
