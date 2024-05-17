package com.sopt.mobile.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
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

    @NotNull
    private String name;

    @Lob
    private String imageURL;

    private String description;

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
