package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistMemberRepository extends JpaRepository<ArtistMember, Long>, ArtistMemberQuerydslRepository {
    @Query("select a from ArtistMember a where a.id = :artistMemberId AND a.isService = true")
    Optional<ArtistMember> findServiceArtistMemberById(Long artistMemberId);
}
