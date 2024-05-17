package com.sopt.mobile.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Builder
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @OneToMany(mappedBy = "member")
    private List<SubscribedArtist> subscribedArtistList = new ArrayList<>();

    public static Member createMember(String name, String email) {
        return Member
                .builder()
                .name(name)
                .email(email)
                .build();
    }
}
