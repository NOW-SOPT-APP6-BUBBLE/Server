package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistMemberRepository extends JpaRepository<ArtistMember, Long>, ArtistMemberQuerydslRepository {

}
