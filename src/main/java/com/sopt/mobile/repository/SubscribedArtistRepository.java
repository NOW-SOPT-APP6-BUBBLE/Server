package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.SubscribedArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribedArtistRepository extends JpaRepository<SubscribedArtist, Long> {

}
