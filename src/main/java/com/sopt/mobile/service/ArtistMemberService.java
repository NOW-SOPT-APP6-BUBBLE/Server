package com.sopt.mobile.service;

import com.sopt.mobile.service.dto.response.ArtistMemberDetailFindDto;
import com.sopt.mobile.service.dto.response.ArtistMemberFindDto;
import com.sopt.mobile.service.dto.response.ArtistMemberListFindDto;

public interface ArtistMemberService {

  ArtistMemberListFindDto findSubscribedArtists(Long memberId);

  ArtistMemberDetailFindDto findArtistMemberDetail(Long memberId, Long artistMemberId);

}
