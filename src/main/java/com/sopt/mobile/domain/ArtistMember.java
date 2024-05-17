package com.sopt.mobile.domain;

import jakarta.persistence.*;
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

    @NotNull
    private String name;

    @Lob
    private String imageURL;

    private String introduction;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

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
