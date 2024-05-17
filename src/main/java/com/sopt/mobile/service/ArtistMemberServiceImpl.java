package com.sopt.mobile.service;

import com.sopt.mobile.common.dto.ErrorMessage;
import com.sopt.mobile.domain.Member;
import com.sopt.mobile.exception.NotFoundException;
import com.sopt.mobile.repository.ArtistMemberRepository;
import com.sopt.mobile.repository.MemberRepository;
import com.sopt.mobile.service.dto.response.ArtistMemberFindDto;
import com.sopt.mobile.service.dto.response.ArtistMemberListFindDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArtistMemberServiceImpl implements ArtistMemberService{

  private final MemberRepository memberRepository;
  private final ArtistMemberRepository artistMemberRepository;

  @Override
  @Transactional(readOnly = true)
  public ArtistMemberListFindDto findSubscribedArtists(Long memberId) {

    // 멤버 찾기
    Member findMember = memberRepository.findById(memberId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
    );

    // 아티스트 찾기
    List<ArtistMemberFindDto> isSubsArtists =  artistMemberRepository.findSubscribedArtists(findMember)
        .stream().map(ArtistMemberFindDto::of).toList();

    List<ArtistMemberFindDto> isNotSubscribedArtists =  artistMemberRepository.findNotSubscribedArtists(findMember)
        .stream().map(ArtistMemberFindDto::of).toList();

    return ArtistMemberListFindDto.of(isSubsArtists, isNotSubscribedArtists);
  }
}
