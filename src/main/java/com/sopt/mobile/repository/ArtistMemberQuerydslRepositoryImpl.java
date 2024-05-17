package com.sopt.mobile.repository;

import static com.sopt.mobile.domain.QArtistMember.artistMember;
import static com.sopt.mobile.domain.QSubscribedArtist.subscribedArtist;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import jakarta.persistence.EntityManager;
import java.util.List;

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
        ))
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
        ))
        .fetch();
  }
}
