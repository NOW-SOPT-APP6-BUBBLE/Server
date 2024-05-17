package com.sopt.mobile.service;

import com.sopt.mobile.common.dto.ErrorMessage;
import com.sopt.mobile.domain.ArtistMember;
import com.sopt.mobile.domain.Member;
import com.sopt.mobile.domain.SubscribedArtist;
import com.sopt.mobile.exception.NotFoundException;
import com.sopt.mobile.repository.ArtistMemberRepository;
import com.sopt.mobile.repository.MemberRepository;
import com.sopt.mobile.repository.SubscribedArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubscribedArtistServiceImpl implements SubscribedArtistService {

    private final MemberRepository memberRepository;
    private final SubscribedArtistRepository subscribedArtistRepository;
    private final ArtistMemberRepository artistMemberRepository;

    @Override
    @Transactional
    public void removeSubscribedArtist(Long memberId, Long artistMemberId) {

        // 멤버 찾기
        Member findMember = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );

        // 아티스트 멤버 찾기
        ArtistMember findArtistMember = artistMemberRepository.findById(artistMemberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );

        // 구독 정보가 존재하는지 확인부터
        boolean exists = subscribedArtistRepository.existsByMemberAndArtistMember(findMember, findArtistMember);
        if (!exists) {
            // 구독 정보가 없으면 예외 발생
            throw new NotFoundException(ErrorMessage.SUBSCRIBED_ARTIST_NOT_FOUND_EXCEPTION);
        }

        subscribedArtistRepository.deleteSubscribedArtist(findMember, findArtistMember);
    }

    @Override
    @Transactional
    public void addSubscribedArtist(Long memberId, Long artistMemberId) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );

        // 아티스트 멤버 찾기
        ArtistMember findArtistMember = artistMemberRepository.findById(artistMemberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );

        subscribedArtistRepository.save(new SubscribedArtist(findArtistMember.getName(), findArtistMember, findMember));
    }
}
