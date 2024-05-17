package com.sopt.mobile.repository;

import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import com.sopt.mobile.service.dto.response.ArtistMemberDetailFindDto;
import java.util.List;
import java.util.Optional;

public interface ArtistMemberQuerydslRepository {

  List<ArtistMember> findSubscribedArtists(Member member);

  List<ArtistMember> findNotSubscribedArtists(Member member);

//  Optional<ArtistMemberDetailFindDto> findArtistMemberDetail(Long artistMemberId);
}
