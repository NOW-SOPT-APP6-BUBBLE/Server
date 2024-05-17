package com.sopt.mobile.service;

import com.sopt.mobile.common.dto.ErrorMessage;
import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import com.sopt.mobile.exception.NotFoundException;
import com.sopt.mobile.repository.ArtistMemberRepository;
import com.sopt.mobile.repository.MemberRepository;
import com.sopt.mobile.repository.SubscribedArtistRepository;
import com.sopt.mobile.service.dto.response.ArtistMemberDetailFindDto;
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
  private final SubscribedArtistRepository subscribedArtistRepository;

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

  @Override
  @Transactional(readOnly = true)
  public ArtistMemberDetailFindDto findArtistMemberDetail(Long memberId, Long artistMemberId) {

    // 조인으로 한번에 가져오려했는데 로직이 너무 꼬여서 더 고민해봐야 할 것 같다.

    // 멤버 찾기(유효한 회원인지 검증용)
    Member findMember = memberRepository.findById(memberId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
    );

    // 아티스트 찾기
    ArtistMember findArtistMember = artistMemberRepository.findById(artistMemberId).orElseThrow(
      () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));

    // 구독여부도 판단해줘야함~
    // 구독 정보가 존재하는지 확인부터
    boolean exists = subscribedArtistRepository.existsByMemberAndArtistMember(findMember, findArtistMember);
    return ArtistMemberDetailFindDto.of(
        findArtistMember, exists
    );
  }
}
