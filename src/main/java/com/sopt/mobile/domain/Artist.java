package com.sopt.mobile.domain;

import jakarta.annotation.Nonnull;
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
public class Artist extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition="TEXT")
    private String imageURL;

    private String description;

    private boolean isSole;

    @OneToMany(mappedBy = "artist")
    private List<ArtistMember> artistMemberList = new ArrayList<>();

    @Builder
    public Artist(String name, String imageURL, String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
    }

    public static Artist createArtist(String name, String imageURL, String description) {
        return Artist
                .builder()
                .name(name)
                .imageURL(imageURL)
                .description(description)
                .build();
    }
}
