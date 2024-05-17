package com.sopt.mobile.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity
@NoArgsConstructor
public class SubscribedArtist extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_member_id")
    private ArtistMember artistMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public SubscribedArtist(String nickname, ArtistMember artistMember, Member member) {
        this.nickname = nickname;
        this.artistMember = artistMember;
        this.member = member;
    }

    public static SubscribedArtist createSubscribedArtist(String nickname, ArtistMember artistMember, Member member){
        return SubscribedArtist
                .builder()
                .nickname(nickname)
                .artistMember(artistMember)
                .member(member)
                .build();
    }
}
