package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import com.sopt.mobile.domain.SubscribedArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribedArtistRepository extends JpaRepository<SubscribedArtist, Long> {

  @Modifying
  @Query("delete from SubscribedArtist s where s.artistMember = :artistMember AND s.member = :member")
  void deleteSubscribedArtist(@Param("member") Member member, @Param("artistMember") ArtistMember artistMember);

  boolean existsByMemberAndArtistMember(Member member, ArtistMember artistMember);

}
