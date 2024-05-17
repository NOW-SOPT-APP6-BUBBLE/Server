package com.sopt.mobile.repository;

import static com.sopt.mobile.domain.QArtistMember.artistMember;
import static com.sopt.mobile.domain.QSubscribedArtist.subscribedArtist;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import com.sopt.mobile.service.dto.response.ArtistMemberDetailFindDto;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ArtistMemberQuerydslRepositoryImpl implements ArtistMemberQuerydslRepository {

  private final JPAQueryFactory queryFactory;

  public ArtistMemberQuerydslRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public List<ArtistMember> findSubscribedArtists(Member member) {
    return queryFactory
        .selectFrom(artistMember)
        .where(artistMember.in(
            queryFactory
                .select(subscribedArtist.artistMember)
                .from(subscribedArtist)
                .where(subscribedArtist.member.eq(member))
        ), artistMember.isService.isTrue())
        .fetch();
  }

  @Override
  public List<ArtistMember> findNotSubscribedArtists(Member member) {
    return queryFactory
        .selectFrom(artistMember)
        .where(artistMember.notIn(
            queryFactory
                .select(subscribedArtist.artistMember)
                .from(subscribedArtist)
                .where(subscribedArtist.member.eq(member))
        ) , artistMember.isService.isTrue()
        )
        .fetch();
  }

//  Long artistMemberId,
//  String nickname,
//  String imageURL,
//  String introduction,
//  boolean isSubscribed,
//  String artistName,
//  String artistMemberName
//  public Optional<ArtistMemberDetailFindDto> findArtistMemberDetail(Long artistMemberId){
//    return queryFactory
//        .select(Projections.constructor(ArtistMemberDetailFindDto.class,
//            artistMember.id,
//            artistMember.nickname,
//            artistMember.imageURL,
//            artistMember.introduction,
//            subscribedArtist.id.isNotNull().as("isSubscribed") // SubscribedArtist 존재 여부에 따라 true/false
//            subscribedArtist.name,
//            su
//        ))
//        .from(artistMember)
//        .leftJoin(subscribedArtist).on(subscribedArtist.artistMember.id.eq(artistMember.id)
//            .and(subscribedArtist.artistMember.id.eq(artistMemberId)))
//        .where(artistMember.id.eq(artistMemberId), artistMember.isService.isTrue())
//        .fetch();
//
//  }
}
