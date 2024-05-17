package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import java.util.List;

public interface ArtistMemberQuerydslRepository {

  List<ArtistMember> findSubscribedArtists(Member member);

  List<ArtistMember> findNotSubscribedArtists(Member member);
}
