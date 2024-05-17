package com.sopt.mobile.service;

public interface SubscribedArtistService {
  void removeSubscribedArtist(Long memberId, Long artistMemberId);
  void addSubscribedArtist(Long memberId, Long artistMemberId);
}
