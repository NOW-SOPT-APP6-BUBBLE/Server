package com.sopt.mobile.repository;

import com.sopt.mobile.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
